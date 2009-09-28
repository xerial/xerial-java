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
import org.xerial.silk.impl.SilkCommentLine;
import org.xerial.silk.impl.SilkDataLine;
import org.xerial.silk.impl.SilkElement;
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkLineLexer;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkNodeParser;
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
public class SilkLinePushParser implements SilkLineParser {
    private static Logger _logger = Logger.getLogger(SilkLinePushParser.class);

    private final SilkLineLexer lexer;
    private final BufferedReader buffer;
    private long lineCount = 0;
    private SilkEventHandler handler = null;
    private final SilkParserConfig config;

    private static final SilkEvent EOFEvent = new SilkEvent(SilkEventType.END_OF_FILE, null);
    private static final SilkEvent BlankLineEvent = new SilkEvent(SilkEventType.BLANK_LINE, null);

    public SilkLinePushParser(URL resourceURL) throws IOException {
        this(new InputStreamReader(resourceURL.openStream()));
    }

    public SilkLinePushParser(URL resourceURL, SilkParserConfig config) throws IOException {
        this(new InputStreamReader(resourceURL.openStream()), config);
    }

    public SilkLinePushParser(Reader reader) {
        this(reader, new SilkParserConfig()); // 1MB
    }

    public SilkLinePushParser(Reader reader, SilkParserConfig config) {
        this.config = config;

        if (reader.getClass().isAssignableFrom(BufferedReader.class))
            buffer = BufferedReader.class.cast(reader);
        else
            buffer = new BufferedReader(reader, config.bufferSize);

        lexer = new SilkLineLexer();
    }

    private void push(SilkEvent e) throws Exception {
        handler.handle(e);
    }

    private static String sanitizeDataLine(String line) {
        if (line.startsWith("\\"))
            return removeLineComment(line.substring(1));
        else
            return removeLineComment(line);
    }

    private static Pattern lineCommentPattern = Pattern
            .compile("[^\"]*(\\\"[^\"]*\\\")*[^\"]*(#.*)");

    public static String removeLineComment(String line) {
        if (!line.contains("#"))
            return line;

        Matcher m = lineCommentPattern.matcher(line);
        if (m.matches()) {
            int lineCommentStart = m.start(2);
            if (lineCommentStart != -1)
                line = line.substring(0, lineCommentStart);
        }
        return line;
    }

    public static SilkEvent parseLine(SilkLineLexer lexer, String line) throws IOException,
            XerialException {
        if (line.length() <= 0) {
            return BlankLineEvent;
        }

        char c = line.charAt(0);

        // preamble
        if (c == '%') {
            return new SilkEvent(SilkEventType.PREAMBLE, new SilkPreamble(line));
        }

        // multi-line separator
        if (c == '-' && line.charAt(1) == '-') {
            return new SilkEvent(SilkEventType.MULTILINE_SEPARATOR, null);
        }

        // multi-line entry separator
        if (c == '>' && line.charAt(1) == '>') {
            return new SilkEvent(SilkEventType.MULTILINE_ENTRY_SEPARATOR, null);
        }

        // 39000 lines/sec

        // remove leading and trailing white spaces (' ')

        String trimmedLine = line.trim();
        if (trimmedLine.length() <= 0) {
            return BlankLineEvent;
        }

        c = trimmedLine.charAt(0);
        // comment line 
        if (c == '#') {
            return new SilkEvent(SilkEventType.COMMENT_LINE, new SilkCommentLine(line));
        }

        // 36000 lines / sec

        // data line 
        if (!(c == '-' || c == '@')) {
            // TODO set indent number correctly
            SilkDataLine dataLine = new SilkDataLine(0, sanitizeDataLine(trimmedLine));
            return new SilkEvent(SilkEventType.DATA_LINE, dataLine);
        }

        // 17000 lines/sec
        // lexical analysis
        lexer.resetContext();
        lexer.setCharStream(new ANTLRStringStream(line));

        // 17500 lines/sec

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        if (_logger.isTraceEnabled())
            _logger.trace(StringUtil.join(ANTLRUtil.prettyPrintTokenList(tokenStream.getTokens(),
                    ANTLRUtil.getTokenTable(SilkLineLexer.class, "Silk.tokens")), "\n"));

        // 100,000 lines/sec (SilkPushParser)
        // 60,000 lines/sec (SilkPushParser after consuming the lexer input)

        // 17000 lines/sec 

        SilkNodeParser nodeParser = new SilkNodeParser(tokenStream);
        SilkElement elem = nodeParser.parse();

        if (elem instanceof SilkNode)
            return new SilkEvent(SilkEventType.NODE, (SilkNode) elem);
        else if (elem instanceof SilkFunction)
            return new SilkEvent(SilkEventType.FUNCTION, (SilkFunction) elem);

        return null;

        // 50,000 lines/sec (SilkPushParser when using recursive descent parser)

        // 17,000 lines/sec (SilkPushParser when using ANTLR parser)

        // 1500 lines/sec

    }

    public void parse(SilkEventHandler handler) throws Exception {
        if (handler == null)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "null handler");

        this.handler = handler;

        String line = null;
        try {
            while ((line = buffer.readLine()) != null) {
                lineCount++;

                try {
                    SilkEvent e = parseLine(lexer, line);
                    if (e != null)
                        push(e);
                }
                catch (XerialException e) {
                    if (e.getErrorCode() == XerialErrorCode.PARSE_ERROR) {
                        // only report warning message
                        _logger.warn(String.format("parse error at line=%d: %s", lineCount, e));
                    }
                    else
                        throw e;
                }
            }

            // EOF
            push(EOFEvent);
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, String.format("line=%d: %s",
                    lineCount, e.getMessage()));
        }
        finally {

        }

    }

    public long getNumReadLine() {
        return lineCount;
    }
}
