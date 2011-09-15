/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// JSONLexer.java
// Since: 2011/05/03 9:51:43
//
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.json.impl.JSONToken;
import org.xerial.util.ArrayDeque;
import org.xerial.util.io.BufferedScanner;

/**
 * JSON lexer for byte input stream
 * 
 * @author leo
 * 
 */
public class JSONLexer {
    public static class Token {
        public final JSONToken type;
        public final CharSequence str;

        public Token(JSONToken type, CharSequence str) {
            this.type = type;
            this.str = str;
        }

        @Override
        public String toString() {
            return String.format("[%s] %s", type, str == null ? "" : str);
        }
    }

    private BufferedScanner scanner;
    private ArrayDeque<Token> tokenQueue = new ArrayDeque<Token>();
    private long lineCount = 0;
    private int posInLine = 0;

    public JSONLexer(InputStream in) {
        this(new BufferedScanner(in));
    }

    public JSONLexer(Reader in) {
        this(new BufferedScanner(in));
    }

    public JSONLexer(String json) {
        this(new BufferedScanner(json));
    }

    public JSONLexer(BufferedScanner scanner) {
        this.scanner = scanner;
    }

    public void close() throws IOException {
        scanner.close();
    }

    /**
     * Get the next token. If null is returned, no more token is available.
     * 
     * @return
     * @throws XerialException
     */
    public Token nextToken() throws XerialException {
        if (!tokenQueue.isEmpty())
            return tokenQueue.pollFirst();

        if (scanner.hasReachedEOF())
            return null;

        // Retrieve the next token
        matchWhiteSpaces(); // skip white spaces
        scanner.resetMarks();
        scanner.mark();
        int c = LA(1);
        switch (c) {
            case '{':
                consume();
                emit(JSONToken.LBrace);
                break;
            case '}':
                consume();
                emit(JSONToken.RBrace);
                break;
            case '[':
                consume();
                emit(JSONToken.LBracket);
                break;
            case ']':
                consume();
                emit(JSONToken.RBracket);
                break;
            case ':':
                consume();
                emit(JSONToken.Colon);
                break;
            case ',':
                consume();
                emit(JSONToken.Comma);
                break;
            case '"':
                parseString();
                break;
            case BufferedScanner.EOF:
                return null;
            default: {
                parseValue();
                break;
            }
        }

        return nextToken();
    }

    void matchWhiteSpaces() throws XerialException {
        loop: for (;;) {
            int c = LA(1);
            switch (c) {
                case ' ':
                case '\t':
                    break;
                case '\r':
                    if (LA(1) != '\n') {
                        lineCount++;
                        posInLine = 0;
                    }
                    break;
                case '\n':
                    lineCount++;
                    posInLine = 0;
                    break;
                default:
                    break loop;
            }
            consume();
        }
    }

    protected int LA(int k) throws XerialException {
        try {
            return scanner.LA(k);
        }
        catch (IOException e) {
            throw XerialException.convert(e);
        }
    }

    protected void consume() throws XerialException {
        try {
            int c = scanner.consume();
            switch (c) {
                case '\r':
                    if (scanner.LA(1) != '\n') {
                        lineCount++;
                        posInLine = 0;
                    }
                    break;
                case '\n':
                    lineCount++;
                    posInLine = 0;
                    break;
                default:
                    posInLine++;
                    break;
            }
        }
        catch (IOException e) {
            throw XerialException.convert(e);
        }
    }

    public void parseValue() throws XerialException {
        int c = LA(1);

        if (c == '-' || c >= '0' && c <= '9') {
            parseNumber();
            return;
        }
        else if (match(NULL)) {
            emit(JSONToken.Null);
            return;
        }
        else if (match(TRUE)) {
            emit(JSONToken.True);
            return;
        }
        else if (match(FALSE)) {
            emit(JSONToken.False);
            return;
        }

        throw error("value", LA(1));
    }

    public void parseNumber() throws XerialException {

        {
            int c = LA(1);
            // Negative flag
            if (c == '-') {
                int c2 = LA(2);
                if (c2 >= '0' && c2 <= '9') {
                    consume();
                    c = c2;
                }
                else
                    throw error("Number", c);
            }

            if (c == '0') {
                consume();
            }
            else if (c >= '1' && c <= '9') {
                consume();
                matchDigit_s();
            }
            else
                throw error("Number", c);
        }

        {
            int c = LA(1);
            switch (c) {
                case '.': {
                    consume();
                    matchDigit_p();
                    int c2 = LA(1);
                    matchExp();
                    emitText(JSONToken.Double);
                    break;
                }
                default:
                    if (matchExp())
                        emitText(JSONToken.Double);
                    else
                        emitText(JSONToken.Integer);
                    break;
            }
        }

    }

    private void matchDigit_s() throws XerialException {
        for (;;) {
            int c = LA(1);
            if (c >= '0' && c <= '9')
                consume();
            else
                return;
        }
    }

    private void matchDigit_p() throws XerialException {
        try {
            int c = scanner.LA(1);
            if (c >= '0' && c <= '9')
                consume();
            else
                throw error("Digit+", c);

            matchDigit_s();
        }
        catch (IOException e) {
            throw XerialException.convert(e);
        }
    }

    private boolean matchExp() throws XerialException {
        {
            int c = LA(1);
            if (c == 'e' || c == 'E')
                consume();
            else
                return false;
        }

        {
            int c = LA(1);
            if (c == '+' || c == '-') {
                consume();
            }
            matchDigit_p();
        }

        return true;
    }

    private final static byte[] NULL = { 'n', 'u', 'l', 'l' };
    private final static byte[] TRUE = { 't', 'r', 'u', 'e' };
    private final static byte[] FALSE = { 'f', 'a', 'l', 's', 'e' };

    boolean match(byte[] text) throws XerialException {
        for (int i = 0; i < text.length; ++i) {
            if (text[i] != LA(i + 1))
                return false;
        }

        for (int i = 0; i < text.length; ++i)
            consume();
        return true;

    }

    void parseString() throws XerialException {
        match('"');

        boolean toContinue = true;
        for (;;) {
            int c = LA(1);
            switch (c) {
                case '"':
                    // end of string
                    consume();
                    emitString();
                    return;
                case '\\':
                    // escape sequence 
                    matchEscapeSequence();
                    break;
                default:
                    consume();
            }
        }

    }

    public void matchEscapeSequence() throws XerialException {
        try {
            match('\\');
            int c = scanner.LA(1);
            switch (c) {
                case '"':
                case '\\':
                case '/':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    consume();
                    break;
                case 'u':
                    consume();
                    for (int i = 0; i < 4; ++i) {
                        matchHexDigit();
                    }
                    break;
                default:
                    throw error("escape sequence", c);
            }
        }
        catch (IOException e) {
            throw XerialException.convert(e);
        }
    }

    public void matchHexDigit() throws XerialException {
        int c = LA(1);
        if (c >= '0' && c <= '9' || c >= 'A' && c <= 'F' || c >= 'a' && c >= 'f') {
            consume();
        }
        else {
            throw error("hex digit", c);
        }

    }

    public void match(int expected) throws XerialException {
        int c = LA(1);
        if (c != expected)
            throw new XerialException(XerialErrorCode.PARSE_ERROR, String.format(
                    "expected:'%s' but found '%s'", expected, c));
        else
            consume();
    }

    private XerialException error(String tokenType, int foundChar) {
        return new XerialException(XerialErrorCode.PARSE_ERROR, String.format(
                "<%s> invalid char '%s'", tokenType, foundChar));
    }

    void emit(JSONToken type) {
        tokenQueue.add(new Token(type, null));
    }

    void emitText(JSONToken type) {
        tokenQueue.add(new Token(type, scanner.selectedRawString()));
    }

    void emitString() {
        tokenQueue.add(new Token(JSONToken.String, scanner.selectedRawString(1)));
    }

    public long getLineNumber() {
        return lineCount;
    }

    public int getPosInLine() {
        return posInLine;
    }

}
