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
// SilkPushParser.java
// Since: Apr 23, 2009 10:36:56 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkLexer;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkParser;
import org.xerial.silk.impl.SilkPreamble;
import org.xerial.silk.impl.SilkParser.silkLine_return;
import org.xerial.util.bean.impl.BeanUtilImpl;

/**
 * Push-style Silk Parser
 * 
 * @author leo
 * 
 */
public class SilkPushParser
{
    private final SilkLexer lexer;
    private final SilkParser parser;
    private final BufferedReader buffer;
    private int lineCount = 0;
    private SilkEventHandler handler = null;

    private static final SilkEvent EOFEvent = new SilkEvent(SilkEventType.END_OF_FILE, null);
    private static final SilkEvent BlankLineEvent = new SilkEvent(SilkEventType.BLANK_LINE, null);

    public SilkPushParser(URL resourceURL) throws IOException
    {
        buffer = new BufferedReader(new InputStreamReader(resourceURL.openStream())); // use 1MB buffer size
        lexer = new SilkLexer();
        parser = new SilkParser(null);
    }

    private void push(SilkEvent e)
    {
        handler.handle(e);
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

    public void parse(SilkEventHandler handler) throws XerialException
    {
        if (handler == null)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "null handler");

        this.handler = handler;

        String line = null;
        try
        {
            while ((line = buffer.readLine()) != null)
            {
                lineCount++;

                if (line == null)
                {
                    return;
                }

                if (line.length() <= 0)
                {
                    push(BlankLineEvent);
                    continue;
                }

                if (line.startsWith("%"))
                {
                    push(new SilkEvent(SilkEventType.PREAMBLE, new SilkPreamble(line)));
                    continue;
                }

                if (line.startsWith("--"))
                {
                    push(new SilkEvent(SilkEventType.MULTILINE_SEPARATOR, null));
                    continue;
                }

                if (line.startsWith(">>"))
                {
                    push(new SilkEvent(SilkEventType.MULTILINE_ENTRY_SEPARATOR, null));
                    continue;
                }

                // 39000 lines/sec

                // remove leading and trailing white spaces (' ') 
                String trimmedLine = line.trim();
                if (trimmedLine.length() <= 0)
                {
                    push(BlankLineEvent);
                    continue;
                }

                // comment line 
                if (trimmedLine.startsWith("#"))
                {
                    // ignore the comment line
                    continue;
                }

                // 36000 lines / sec

                if (!(trimmedLine.startsWith("-") || trimmedLine.startsWith("@")))
                {
                    SilkDataLine dataLine = new SilkDataLine(sanitizeDataLine(trimmedLine));
                    push(new SilkEvent(SilkEventType.DATA_LINE, dataLine));
                    continue;
                }

                // 17000 lines/sec

                // lexical analysis
                lexer.resetContext();
                lexer.setCharStream(new ANTLRStringStream(line));

                // 17500 lines/sec

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
                    continue;
                }
                case SilkParser.SilkNode:
                {
                    SilkNode node = BeanUtilImpl.createBeanFromParseTree(SilkNode.class, t, SilkParser.tokenNames);
                    push(new SilkEvent(SilkEventType.NODE, node));
                    continue;
                }
                default:
                    throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format(
                            "line=%d: invalid data type: %s", lineCount, parser.getTokenNames()[t.getType()]));
                }

                // 1500 lines/sec
            }

            // EOF
            push(EOFEvent);
        }
        catch (RecognitionException e)
        {
            throw new XerialException(XerialErrorCode.INVALID_INPUT, String.format("parse error line=%d: %s",
                    lineCount, e.getMessage()));
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, String.format("line=%d: %s", lineCount, e
                    .getMessage()));
        }

    }

    public int getNumReadLine()
    {
        return lineCount;
    }
}
