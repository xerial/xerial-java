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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
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

    private boolean foundEOF = false;

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
        lexer = new SilkLexer(new ANTLRInputStream(input));
        init();
    }

    public SilkPullParser(Reader input) throws IOException
    {
        lexer = new SilkLexer(new ANTLRReaderStream(input));
        init();
    }

    private void init()
    {
        tokenStream = new CommonTokenStream(lexer);
        parser = new SilkParser(tokenStream);
    }

    public boolean hasNext()
    {
        return !foundEOF;
    }

    public SilkEvent next() throws XerialException
    {
        if (foundEOF)
            return EOFEvent;

        if (tokenStream.LT(1) == Token.EOF_TOKEN)
        {
            foundEOF = true;
            return EOFEvent;
        }

        try
        {
            silkLine_return ret = parser.silkLine();
            Tree t = (Tree) ret.getTree();
            switch (t.getType())
            {
            case SilkParser.Function:
            {
                SilkFunction func = BeanUtilImpl.createBeanFromParseTree(SilkFunction.class, t, SilkParser.tokenNames);
                return new SilkEvent(SilkEventType.FUNCTION, func);
            }
            case SilkParser.SilkNode:
            {
                SilkNode node = BeanUtilImpl.createBeanFromParseTree(SilkNode.class, t, SilkParser.tokenNames);
                return new SilkEvent(SilkEventType.NODE, node);
            }
            case SilkParser.BlankLine:
            {
                return BlankLineEvent;
            }
            case SilkParser.DataLine:
            {
                SilkDataLine dataLine = new SilkDataLine(t.getText());
                return new SilkEvent(SilkEventType.DATA_LINE, dataLine);
            }
            case SilkParser.Preamble:
                return new SilkEvent(SilkEventType.PREAMBLE, new SilkPreamble(t.getText()));
            default:
                throw new XerialException(XerialErrorCode.INVALID_INPUT, "invalid data type: "
                        + parser.getTokenNames()[t.getType()]);
            }

        }
        catch (RecognitionException e)
        {
            throw new XerialException(XerialErrorCode.INVALID_INPUT, String.format("parse error line=%d: %s", e.line, e
                    .getMessage()));
        }
    }

}
