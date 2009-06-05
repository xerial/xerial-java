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
// SilkStreamReader.java
// Since: 2009/03/31 19:53:33
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeStreamReader;

/**
 * {@link TreeStreamReader} implementation for the Silk data format.
 * 
 * @author leo
 * 
 */
public class SilkPullParser implements TreeStreamReader
{
    private static Logger _logger = Logger.getLogger(SilkPullParser.class);

    private final SilkParser parser;
    private final ArrayBlockingQueue<TreeEvent> eventQueue = new ArrayBlockingQueue<TreeEvent>(10000);
    private final ArrayDeque<TreeEvent> prefetchedEventQueue = new ArrayDeque<TreeEvent>();

    private long numReadLine = 0;

    // for changing push-parser to pull parser
    private final ExecutorService threadManager;

    /**
     * Creates a new reader with the specified input stream
     * 
     * @param input
     *            `@throws IOException
     */
    protected SilkPullParser(InputStream input) throws IOException
    {
        this(new InputStreamReader(input));
    }

    /**
     * Creates a new reader with the specified reader
     * 
     * @param input
     * @throws IOException
     */
    protected SilkPullParser(Reader input) throws IOException
    {
        this(input, SilkEnv.newEnv(), new SilkParserConfig());
    }

    public SilkPullParser(Reader input, SilkEnv env) throws IOException
    {
        this(input, env, new SilkParserConfig());
    }

    /**
     * Creates a new reader inherited the given environment
     * 
     * @param input
     * @param env
     * @throws IOException
     */
    public SilkPullParser(Reader input, SilkEnv env, SilkParserConfig config) throws IOException
    {
        this.parser = new SilkParser(input, env, config);

        this.threadManager = Executors.newFixedThreadPool(1);
        threadManager.submit(new BackgroundParser());

    }

    /**
     * Create a new reader for reading local resources
     * 
     * @param resourceBasePath
     * @param resourceName
     * @throws IOException
     */
    public SilkPullParser(String resourceBasePath, String resourceName) throws IOException
    {
        this(new BufferedReader(new InputStreamReader(SilkWalker.class.getResourceAsStream(SilkParser.getResourcePath(
                resourceBasePath, resourceName)))), SilkEnv.newEnv(resourceBasePath));
    }

    /**
     * Create a new reader for reading the specified resource URL
     * 
     * @param resourcePath
     * @throws IOException
     */
    public SilkPullParser(URL resourcePath) throws IOException
    {
        this(resourcePath, SilkEnv.newEnv());
    }

    public SilkPullParser(URL resource, SilkEnv env) throws IOException
    {
        this(new BufferedReader(new InputStreamReader(resource.openStream())), SilkEnv.newEnv(env, SilkParser
                .getResourceBasePath(resource)));
    }

    public SilkPullParser(URL resource, SilkEnv env, SilkParserConfig config) throws IOException
    {
        this(new BufferedReader(new InputStreamReader(resource.openStream())), SilkEnv.newEnv(env, SilkParser
                .getResourceBasePath(resource)), config);
    }

    public SilkPullParser(URL resource, SilkParserConfig config) throws IOException
    {
        this(resource, SilkEnv.newEnv(), config);
    }

    private class BackgroundParser implements Callable<Void>
    {

        public Void call() throws Exception
        {
            try
            {
                parser.parse(new TreeEventHandler() {
                    public void finish() throws Exception
                    {
                        hasParsingFinished = true;
                    }

                    public void init() throws Exception
                    {
                        hasParsingFinished = false;
                    }

                    public void leaveNode(String nodeName) throws Exception
                    {
                        eventQueue.put(TreeEvent.newLeaveEvent(nodeName));
                    }

                    public void text(String nodeName, String textDataFragment) throws Exception
                    {
                        eventQueue.put(TreeEvent.newTextEvent(nodeName, textDataFragment));
                    }

                    public void visitNode(String nodeName, String immediateNodeValue) throws Exception
                    {
                        eventQueue.put(TreeEvent.newVisitEvent(nodeName, immediateNodeValue));

                    }
                });

                return null;
            }
            finally
            {
                threadManager.shutdown();
            }
        }

    }

    public TreeEvent peekNext() throws XerialException
    {
        if (hasNext())
            return prefetchedEventQueue.getFirst();
        else
            return null;
    }

    public TreeEvent next() throws XerialException
    {
        if (hasNext())
        {
            TreeEvent e = prefetchedEventQueue.removeFirst();
            return e;
        }
        else
            return null;
    }

    /**
     * Has finished reading the stream?
     */
    private volatile boolean hasParsingFinished = false;
    private boolean hasPrefetchFinished = false;

    /**
     * Is next event available?
     * 
     * @return true if there are remaining events, otherwise fales
     * @throws XerialException
     */
    private boolean hasNext() throws XerialException
    {
        if (!prefetchedEventQueue.isEmpty())
            return true;

        assert (prefetchedEventQueue.isEmpty());

        if (hasPrefetchFinished)
            return false;

        if (hasParsingFinished)
        {
            int count = eventQueue.drainTo(prefetchedEventQueue);
            //_logger.debug("prefetch: " + count);
            //_logger.debug("eventQueue size: " + eventQueue.size());
            hasPrefetchFinished = true;
            return hasNext();
        }

        try
        {
            TreeEvent e = null;
            while (!hasParsingFinished && (e = eventQueue.poll(1, TimeUnit.MILLISECONDS)) == null)
            {}

            if (e != null)
                prefetchedEventQueue.addLast(e);

            return hasNext();
        }
        catch (InterruptedException e)
        {

        }

        return false;
    }

    public long getNumReadLine()
    {
        return numReadLine;
    }

}
