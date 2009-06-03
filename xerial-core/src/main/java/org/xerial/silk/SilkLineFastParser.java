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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.impl.SilkLexer;
import org.xerial.util.log.Logger;

/**
 * Parsing Silk using threads.
 * 
 * @author leo
 * 
 */
public class SilkLineFastParser
{
    private static Logger _logger = Logger.getLogger(SilkLineFastParser.class);

    private final BufferedReader buffer;
    private final ExecutorService threadManager;
    private final LinkedBlockingQueue<Future<List<SilkEvent>>> eventContainer;
    private final SilkParserConfig config;

    public SilkLineFastParser(URL resourceURL) throws IOException
    {
        this(resourceURL, new SilkParserConfig());
    }

    public SilkLineFastParser(URL resourceURL, SilkParserConfig config) throws IOException
    {
        this(new InputStreamReader(resourceURL.openStream()), config);
    }

    public SilkLineFastParser(Reader reader)
    {
        this(reader, new SilkParserConfig());
    }

    public SilkLineFastParser(Reader reader, SilkParserConfig config)
    {
        this.config = config;
        this.eventContainer = new LinkedBlockingQueue<Future<List<SilkEvent>>>(config.numWorkers);

        if (reader.getClass().isAssignableFrom(BufferedReader.class))
            buffer = BufferedReader.class.cast(reader);
        else
            buffer = new BufferedReader(reader, config.bufferSize);

        threadManager = Executors.newFixedThreadPool(config.numWorkers + 1);
    }

    private volatile boolean foundEOF = false;

    public void parse(SilkEventHandler handler) throws XerialException
    {
        try
        {
            // start up the reducer
            Future<Void> reducerTask = threadManager.submit(new Reducer(handler));

            int workerCount = 0;
            foundEOF = false;

            while (!foundEOF)
            {
                ArrayList<String> cache = new ArrayList<String>(config.numLinesInBlock);
                int lineCount = 0;
                while (lineCount < config.numLinesInBlock)
                {
                    lineCount++;
                    String line = buffer.readLine();
                    if (line == null)
                    {
                        foundEOF = true;
                        break;
                    }
                    cache.add(line);
                }

                if (!cache.isEmpty())
                {
                    // map the input
                    Mapper map = new Mapper(workerCount++, cache);

                    Future<List<SilkEvent>> future = threadManager.submit(map);
                    eventContainer.put(future);
                }
            }

            // await termination
            while (!eventContainer.isEmpty())
            {
                Thread.sleep(1);
            }
            reducerTask.cancel(true);

        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (InterruptedException e)
        {
            throw new XerialException(XerialErrorCode.INTERRUPTED, e);
        }
        finally
        {
            threadManager.shutdown();
        }

    }

    private class Mapper implements Callable<List<SilkEvent>>
    {
        final List<String> cache;
        final List<SilkEvent> eventQueue;
        final SilkLexer lexer = new SilkLexer();
        final int lsn;

        Mapper(int lsn, List<String> cache)
        {
            this.lsn = lsn;
            this.cache = cache;
            eventQueue = new ArrayList<SilkEvent>(cache.size());
        }

        public List<SilkEvent> call() throws Exception
        {
            for (int cursor = 0; cursor < cache.size(); cursor++)
            {
                try
                {
                    SilkEvent e = SilkLinePushParser.parseLine(lexer, cache.get(cursor));
                    if (e != null)
                    {
                        eventQueue.add(e);
                    }
                }
                catch (XerialException e)
                {
                    if (e.getErrorCode() == XerialErrorCode.PARSE_ERROR)
                        _logger.warn(e);
                    else
                        throw e;
                }
            }

            // finished the parsing
            cache.clear();

            return eventQueue;
        }

    }

    /**
     * subsumes event container in the sequential order
     * 
     * @author leo
     * 
     */
    private class Reducer implements Callable<Void>
    {
        private SilkEventHandler handler;

        public Reducer(SilkEventHandler handler)
        {
            this.handler = handler;
        }

        public Void call() throws Exception
        {
            try
            {
                while (true)
                {
                    Future<List<SilkEvent>> container = eventContainer.take();
                    List<SilkEvent> eventQueue = container.get();
                    for (SilkEvent e : eventQueue)
                    {
                        handler.handle(e);
                    }
                }
            }
            catch (InterruptedException e)
            {
                handler.handle(new SilkEvent(SilkEventType.END_OF_FILE, null));
            }

            return null;
        }
    }

}
