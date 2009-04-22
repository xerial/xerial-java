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
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
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
import org.xerial.util.antlr.ANTLRUtil;
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

    private final SilkLexer lexer;
    private CommonTokenStream tokenStream;
    private SilkParser parser;
    private int lineCount = 0;

    private final BufferedReader buffer;

    private boolean foundEOF = false;

    private ArrayDeque<SilkEvent> eventQueue = new ArrayDeque<SilkEvent>();
    private static Map<Integer, String> tokenTable;

    static
    {
        try
        {
            tokenTable = ANTLRUtil.getTokenTable(SilkPullParser.class, "impl/Silk.tokens");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

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

    public SilkPullParser(InputStream input) throws IOException
    {
        this(new InputStreamReader(input));
    }

    public SilkPullParser(Reader input) throws IOException
    {
        buffer = new BufferedReader(input);
        lexer = new SilkLexer();
    }

    public boolean hasNext() throws XerialException
    {
        if (!eventQueue.isEmpty())
            return true;

        if (foundEOF)
            return false;

        fillQueue();

        return hasNext();
    }

    public SilkEvent next() throws XerialException
    {
        if (!eventQueue.isEmpty())
            return eventQueue.removeFirst();

        if (foundEOF)
            return null;

        fillQueue();

        return next();
    }

    public void push(SilkEvent e)
    {
        eventQueue.addLast(e);
    }

    public void fillQueue() throws XerialException
    {
        if (foundEOF)
            return;

        // read next line
        String line = null;
        try
        {
            line = buffer.readLine();
            lineCount++;
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, String.format("line=%d: %s", lineCount, e
                    .getMessage()));
        }

        if (line == null)
        {
            // EOF
            push(EOFEvent);
            foundEOF = true;
            return;
        }

        if (line.length() <= 0)
        {
            push(BlankLineEvent);
            return;
        }

        // lexical analysis
        lexer.resetContext();
        lexer.setCharStream(new ANTLRStringStream(line));

        try
        {
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            SilkParser parser = new SilkParser(tokenStream);
            silkLine_return ret = parser.silkLine();
            Tree t = (Tree) ret.getTree();
            switch (t.getType())
            {
            case SilkParser.Function:
            {
                SilkFunction func = BeanUtilImpl.createBeanFromParseTree(SilkFunction.class, t, SilkParser.tokenNames);
                push(new SilkEvent(SilkEventType.FUNCTION, func));
                break;
            }
            case SilkParser.SilkNode:
            {
                SilkNode node = BeanUtilImpl.createBeanFromParseTree(SilkNode.class, t, SilkParser.tokenNames);
                push(new SilkEvent(SilkEventType.NODE, node));
                break;
            }
            case SilkParser.BlankLine:
            {
                push(BlankLineEvent);
                break;
            }
            case SilkParser.DataLine:
            {
                SilkDataLine dataLine = new SilkDataLine(t.getText());
                push(new SilkEvent(SilkEventType.DATA_LINE, dataLine));
                break;
            }
            case SilkParser.Preamble:
                push(new SilkEvent(SilkEventType.PREAMBLE, new SilkPreamble(t.getText())));
                break;
            case SilkParser.MultiLineEntrySeparator:
                push(new SilkEvent(SilkEventType.MULTILINE_ENTRY_SEPARATOR, null));
                break;
            case SilkParser.MultiLineSeparator:
                push(new SilkEvent(SilkEventType.MULTILINE_SEPARATOR, null));
                break;
            case SilkParser.LineComment:
                // ignore the comment line
                break;
            default:
                throw new XerialException(XerialErrorCode.INVALID_INPUT, String.format(
                        "line=%d: invalid data type: %s", lineCount, parser.getTokenNames()[t.getType()]));
            }

        }
        catch (RecognitionException e)
        {
            throw new XerialException(XerialErrorCode.INVALID_INPUT, String.format("parse error line=%d: %s",
                    lineCount, e.getMessage()));
        }
    }

    public int getLine()
    {
        return lineCount;
    }

}
