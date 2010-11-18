/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// XerialJ
//
// SilkLineFastParser.java
// Since: Jun 3, 2009 2:37:13 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.antlr.runtime.CommonTokenStream;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.impl.SilkLineLexer;
import org.xerial.util.ArrayDeque;
import org.xerial.util.log.Logger;

/**
 * Parsing Silk using threads.
 * 
 * TODO fix a bug that does not properly report some nodes, for some timing
 * 
 * @author leo
 * 
 */
public class SilkLineFastParser implements SilkParserBase {
    private static Logger _logger = Logger.getLogger(SilkLineFastParser.class);

    private final BufferedReader buffer;
    private final ExecutorService threadManager;
    private final LinkedBlockingQueue<Future<ArrayDeque<SilkEvent>>> eventContainer;
    private final SilkParserConfig config;

    public SilkLineFastParser(URL resourceURL) throws IOException {
        this(resourceURL, new SilkParserConfig());
    }

    public SilkLineFastParser(URL resourceURL, SilkParserConfig config) throws IOException {
        this(new InputStreamReader(resourceURL.openStream(), "UTF8"), config);
    }

    public SilkLineFastParser(Reader reader) {
        this(reader, new SilkParserConfig());
    }

    public SilkLineFastParser(Reader reader, SilkParserConfig config) {
        this.config = config;
        this.eventContainer = new LinkedBlockingQueue<Future<ArrayDeque<SilkEvent>>>(
                config.numWorkers);

        if (reader.getClass().isAssignableFrom(BufferedReader.class))
            buffer = BufferedReader.class.cast(reader);
        else
            buffer = new BufferedReader(reader, config.bufferSize);

        threadManager = Executors.newFixedThreadPool(config.numWorkers + 1);
    }

    private boolean foundEOF = false;
    private volatile boolean noMoreJob = false;

    public void parse(SilkEventHandler handler) throws XerialException {
        try {
            // start up the reducer
            Future<Void> reducerTask = threadManager.submit(new Reducer(handler));
            try {
                int workerCount = 0;
                foundEOF = false;

                while (!foundEOF) {
                    ArrayList<String> cache = new ArrayList<String>(config.numLinesInBlock);
                    int lineCount = 0;
                    while (lineCount < config.numLinesInBlock) {

                        String line = buffer.readLine();
                        if (line == null) {
                            foundEOF = true;
                            break;
                        }
                        lineCount++;
                        cache.add(line);
                    }

                    if (!cache.isEmpty()) {
                        // map the input
                        Mapper map = new Mapper(workerCount++, cache);

                        Future<ArrayDeque<SilkEvent>> future = threadManager.submit(map);
                        eventContainer.put(future);
                    }
                }

                // wake up the reducer thread
                noMoreJob = true;

            }
            catch (IOException e) {
                reducerTask.cancel(true);
                throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
            }
            finally {
                threadManager.shutdown();
                while (!threadManager.awaitTermination(1, TimeUnit.MILLISECONDS)) {}
            }
        }
        catch (InterruptedException e) {
            throw new XerialException(XerialErrorCode.INTERRUPTED, e);
        }

    }

    private class Mapper implements Callable<ArrayDeque<SilkEvent>> {
        final List<String> cache;
        final ArrayDeque<SilkEvent> eventQueue;
        final SilkLineLexer lexer = new SilkLineLexer();
        final CommonTokenStream tokenStream = new CommonTokenStream();
        final int lsn;

        Mapper(int lsn, List<String> cache) {
            this.lsn = lsn;
            this.cache = cache;
            eventQueue = new ArrayDeque<SilkEvent>(cache.size());
        }

        public ArrayDeque<SilkEvent> call() throws Exception {
            for (int cursor = 0; cursor < cache.size(); cursor++) {
                try {
                    SilkEvent e = SilkLinePushParser.parseLine(lexer, tokenStream,
                            cache.get(cursor));
                    if (e != null) {
                        eventQueue.add(e);
                    }
                }
                catch (XerialException e) {
                    if (e.getErrorCode() == XerialErrorCode.PARSE_ERROR)
                        _logger.warn(e);
                    else
                        throw e;
                }
            }

            // finished the parsing
            cache.clear();

            if (_logger.isTraceEnabled())
                _logger.trace(String.format("finished workder=%d. event queue size = %d", lsn,
                        eventQueue.size()));

            return eventQueue;
        }

    }

    /**
     * subsumes event container in the sequential order
     * 
     * @author leo
     * 
     */
    private class Reducer implements Callable<Void> {
        private final SilkEventHandler handler;
        private ArrayDeque<SilkEvent> eventQueue = null;
        private int eventCount = 0;

        public Reducer(SilkEventHandler handler) {
            this.handler = handler;
        }

        public Void call() throws Exception {
            try {
                consumeEvent();
            }
            finally {
                // process remaining events
                consumeEvent();

                handler.handle(new SilkEvent(SilkEventType.END_OF_FILE, null));
            }

            return null;
        }

        public void consumeEvent() throws Exception {
            while ((eventQueue = getNext()) != null) {
                while (!eventQueue.isEmpty()) {
                    SilkEvent e = null;
                    try {
                        e = eventQueue.getFirst();
                    }
                    finally {
                        if (e != null) {
                            eventQueue.removeFirst();
                            handler.handle(e);
                            eventCount++;
                        }
                    }
                }
            }
        }

        public ArrayDeque<SilkEvent> getNext() throws ExecutionException {
            if (eventQueue != null && !eventQueue.isEmpty())
                return eventQueue;

            if (noMoreJob && eventContainer.isEmpty())
                return null;

            try {
                Future<ArrayDeque<SilkEvent>> container = eventContainer.take();
                return container.get();
            }
            catch (InterruptedException e) {
                if (eventContainer.isEmpty())
                    return null;
                else
                    return getNext();
            }

        }

    }

}
