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
import java.io.Reader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.impl.SilkDataLine;
import org.xerial.silk.impl.SilkElement;
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkLexer;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkNodeParser;
import org.xerial.silk.impl.SilkParser;
import org.xerial.silk.impl.SilkPreamble;
import org.xerial.util.StringUtil;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

/**
 * Push-style Silk Parser
 * 
 * @author leo
 * 
 */
public class SilkPushParser
{
    private static Logger _logger = Logger.getLogger(SilkPushParser.class);

    private final SilkLexer lexer;
    private final SilkParser parser;
    private final BufferedReader buffer;
    private long lineCount = 0;
    private SilkEventHandler handler = null;

    private static final SilkEvent EOFEvent = new SilkEvent(SilkEventType.END_OF_FILE, null);
    private static final SilkEvent BlankLineEvent = new SilkEvent(SilkEventType.BLANK_LINE, null);

    public SilkPushParser(URL resourceURL) throws IOException
    {
        this(new InputStreamReader(resourceURL.openStream()));
    }

    public SilkPushParser(Reader reader)
    {
        if (reader.getClass().isAssignableFrom(BufferedReader.class))
            buffer = BufferedReader.class.cast(reader);
        else
            buffer = new BufferedReader(reader);

        lexer = new SilkLexer();
        parser = new SilkParser(null);
    }

    private void push(SilkEvent e) throws XerialException
    {
        handler.handle(e);
    }

    private static String sanitizeDataLine(String line)
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

                char c = line.charAt(0);

                // preamble
                if (c == '%')
                {
                    push(new SilkEvent(SilkEventType.PREAMBLE, new SilkPreamble(line)));
                    continue;
                }

                // multi-line separator
                if (c == '-' && line.charAt(1) == '-')
                {
                    push(new SilkEvent(SilkEventType.MULTILINE_SEPARATOR, null));
                    continue;
                }

                // multi-line entry separator
                if (c == '>' && line.charAt(1) == '>')
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

                c = trimmedLine.charAt(0);
                // comment line 
                if (c == '#')
                {
                    // ignore the comment line
                    continue;
                }

                // 36000 lines / sec

                // data line 
                if (!(c == '-' || c == '@'))
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

                if (_logger.isTraceEnabled())
                    _logger.trace(StringUtil.join(ANTLRUtil.prettyPrintTokenList(tokenStream.getTokens(), ANTLRUtil
                            .getTokenTable(SilkLexer.class, "Silk.tokens")), "\n"));

                parser.setTokenStream(tokenStream);

                // 100,000 lines/sec (SilkPushParser)
                // 60,000 lines/sec (SilkPushParser after consuming the lexer input)

                // 17000 lines/sec 

                try
                {
                    SilkNodeParser nodeParser = new SilkNodeParser(tokenStream);
                    SilkElement elem = nodeParser.parse();
                    if (elem instanceof SilkNode)
                        push(new SilkEvent(SilkEventType.NODE, (SilkNode) elem));
                    else if (elem instanceof SilkFunction)
                        push(new SilkEvent(SilkEventType.FUNCTION, (SilkFunction) elem));

                }
                catch (XerialException e)
                {
                    if (e.getErrorCode() == XerialErrorCode.PARSE_ERROR)
                    {
                        // only report warning message
                        _logger.warn(String.format("parse error at line=%d: %s", lineCount, e));
                    }
                    else
                        throw e;
                }

                continue;

                // 50,000 lines/sec (SilkPushParser when using recursive descent parser)

                // 17,000 lines/sec (SilkPushParser when using ANTLR parser)

                // 1500 lines/sec
            }

            // EOF
            push(EOFEvent);
        }
        //        catch (RecognitionException e)
        //        {
        //            throw new XerialException(XerialErrorCode.INVALID_INPUT, String.format("parse error line=%d: %s",
        //                    lineCount, e.getMessage()));
        //        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, String.format("line=%d: %s", lineCount, e
                    .getMessage()));
        }
        finally
        {

        }

    }

    public long getNumReadLine()
    {
        return lineCount;
    }
}
