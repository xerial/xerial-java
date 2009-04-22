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
// SilkPullParser.java
// Since: Jan 28, 2009 1:00:02 PM
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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.impl.SilkDataLine;
import org.xerial.silk.impl.SilkElement;
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkLexer;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkParser;
import org.xerial.silk.impl.SilkPreamble;
import org.xerial.silk.impl.SilkParser.silkLine_return;
import org.xerial.util.ArrayDeque;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.log.Logger;

/**
 * Pull parser of the Silk format. Pull-style means each parsing event is
 * generated when next() method is called, suited to stream processing.
 * 
 * @author leo
 * 
 */
public class SilkPullParser
{
    private static Logger _logger = Logger.getLogger(SilkPullParser.class);
    private static final SilkEvent EOFEvent = new SilkEvent(SilkEventType.END_OF_FILE, null);
    private static final SilkEvent BlankLineEvent = new SilkEvent(SilkEventType.BLANK_LINE, null);

    private int lineCount = 0;

    private final int eventQueueMax = 10000;
    private boolean foundEOF = false;

    private ArrayBlockingQueue<SilkEvent> eventQueue = new ArrayBlockingQueue<SilkEvent>(eventQueueMax);

    /**
     * SilkEvents
     * 
     * @author leo
     * 
     */
    private static class EventItem
    {
        SilkEventType event;
        SilkElement element;

        public EventItem(SilkEventType event, SilkElement element)
        {
            this.event = event;
            this.element = element;
        }

        public EventItem(SilkEventType event)
        {
            this.event = event;
            this.element = null;
        }
    }

    private ExecutorService threadPool;

    public SilkPullParser(InputStream input) throws IOException
    {
        this(new InputStreamReader(input));
    }

    public SilkPullParser(Reader input) throws IOException
    {
        threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(new SilkEventProducer(input));
    }

    protected class SilkEventProducer implements Runnable
    {
        private final SilkLexer lexer;
        private final SilkParser parser;
        private final BufferedReader buffer;

        public SilkEventProducer(Reader input)
        {
            buffer = new BufferedReader(input, 1024 * 1024); // use 1MB buffer size
            lexer = new SilkLexer();
            parser = new SilkParser(null);
        }

        public void push(SilkEvent e)
        {
            try
            {
                eventQueue.put(e);
            }
            catch (InterruptedException e1)
            {
                e1.printStackTrace();
            }
        }

        public void run()
        {
            while (!foundEOF)
            {
                readNext();
            }
        }

        public void readNext()
        {
            // read next line
            String line = null;
            try
            {
                // line without newline characters, '\n' and '\r' 
                line = buffer.readLine();
                lineCount++;
            }
            catch (IOException e)
            {
                throw new XerialError(XerialErrorCode.IO_EXCEPTION, String.format("line=%d: %s", lineCount, e
                        .getMessage()));
            }

            if (line == null)
            {
                // EOF
                push(EOFEvent);
                foundEOF = true;
                return;
            }

            // 40000 lines/sec

            //        // dummy
            //        if (true)
            //        {
            //            SilkNode node = new SilkNode();
            //            node.setName("dummy");
            //            node.setNodeIndent("-");
            //            push(new SilkEvent(SilkEventType.NODE, node));
            //            //push(BlankLineEvent);
            //            return;
            //        }

            if (line.length() <= 0)
            {
                push(BlankLineEvent);
                return;
            }

            if (line.startsWith("%"))
            {
                push(new SilkEvent(SilkEventType.PREAMBLE, new SilkPreamble(line)));
                return;
            }
            else if (line.startsWith("--"))
            {
                push(new SilkEvent(SilkEventType.MULTILINE_SEPARATOR, null));
                return;
            }
            else if (line.startsWith(">>"))
            {
                push(new SilkEvent(SilkEventType.MULTILINE_ENTRY_SEPARATOR, null));
                return;
            }

            // 39000 lines/sec

            // remove leading and trailing white spaces (' ') 
            String trimmedLine = line.trim();
            if (trimmedLine.length() <= 0)
            {
                push(BlankLineEvent);
                return;
            }

            // comment line 
            if (trimmedLine.startsWith("#"))
            {
                // ignore the comment line
                return;
            }

            // 36000 lines / sec

            if (!(trimmedLine.startsWith("-") || trimmedLine.startsWith("@")))
            {
                SilkDataLine dataLine = new SilkDataLine(sanitizeDataLine(trimmedLine));
                push(new SilkEvent(SilkEventType.DATA_LINE, dataLine));
                return;
            }

            // 17000 lines/sec

            // lexical analysis
            lexer.resetContext();
            lexer.setCharStream(new ANTLRStringStream(line));

            // 17500 lines/sec

            try
            {
                CommonTokenStream tokenStream = new CommonTokenStream(lexer);
                parser.setTokenStream(tokenStream);

                // 17000 lines/sec 

                silkLine_return ret = parser.silkLine();
                Tree t = (Tree) ret.getTree();

                // 8500 -> 12000 lines/sec

                switch (t.getType())
                {
                case SilkParser.Function:
                {
                    SilkFunction func = BeanUtilImpl.createBeanFromParseTree(SilkFunction.class, t,
                            SilkParser.tokenNames);
                    push(new SilkEvent(SilkEventType.FUNCTION, func));
                    return;
                }
                case SilkParser.SilkNode:
                {
                    SilkNode node = BeanUtilImpl.createBeanFromParseTree(SilkNode.class, t, SilkParser.tokenNames);
                    push(new SilkEvent(SilkEventType.NODE, node));
                    return;
                }
                default:
                    throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format(
                            "line=%d: invalid data type: %s", lineCount, parser.getTokenNames()[t.getType()]));
                }

                // 1500 lines/sec
            }
            catch (RecognitionException e)
            {
                throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format("parse error line=%d: %s",
                        lineCount, e.getMessage()));
            }
            catch (XerialException e)
            {
                throw new XerialError(e.getErrorCode(), e);
            }

        }

    }

    private ArrayDeque<SilkEvent> prefetchedEventQueue = new ArrayDeque<SilkEvent>();

    public boolean hasNext() throws XerialException
    {
        if (!prefetchedEventQueue.isEmpty())
            return true;

        if (foundEOF)
            return !eventQueue.isEmpty();

        try
        {
            prefetchedEventQueue.addLast(eventQueue.take());
        }
        catch (InterruptedException e)
        {
            foundEOF = true;
        }
        return hasNext();
    }

    public SilkEvent next() throws XerialException
    {
        if (!prefetchedEventQueue.isEmpty())
            return prefetchedEventQueue.removeFirst();

        if (foundEOF && eventQueue.isEmpty())
            return null;

        try
        {
            prefetchedEventQueue.addLast(eventQueue.take());
        }
        catch (InterruptedException e1)
        {
            foundEOF = true;
        }

        return next();
    }

    public static String sanitizeDataLine(String line)
    {
        if (line.startsWith("\\"))
            return removeLineComment(line.substring(1));
        else
            return removeLineComment(line);
    }

    private static Pattern lineCommentPattern = Pattern.compile("[^\"]*(\\\"[^\"]*\\\")*[^\"]*(#.*)");

    public static String removeLineComment(String line)
    {
        if (!line.contains("#"))
            return line;

        Matcher m = lineCommentPattern.matcher(line);
        if (m.matches())
        {
            int lineCommentStart = m.start(2);
            if (lineCommentStart != -1)
                line = line.substring(0, lineCommentStart);
        }
        return line;
    }

    protected void fillQueue() throws XerialException
    {}

    public int getLine()
    {
        return lineCount;
    }

}
