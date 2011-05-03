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
public class JSONLexer
{
    public static class Token
    {
        public final JSONToken type;
        public final String    str;

        public Token(JSONToken type, String str) {
            this.type = type;
            this.str = str;
        }
    }

    private BufferedScanner   scanner;
    private ArrayDeque<Token> tokenQueue = new ArrayDeque<Token>();

    public JSONLexer(InputStream in) {
        this.scanner = new BufferedScanner(in);
    }

    public JSONLexer(Reader in) {
        this.scanner = new BufferedScanner(in);
    }

    public JSONLexer(String json) {
        this.scanner = new BufferedScanner(json);
    }

    public void close() throws XerialException {
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
        scanner.mark();
        int c = scanner.LA(1);
        switch (c) {
        case '{':
            scanner.consume();
            emit(JSONToken.LBrace);
            break;
        case '}':
            scanner.consume();
            emit(JSONToken.RBrace);
            break;
        case '[':
            scanner.consume();
            emit(JSONToken.LBracket);
            break;
        case ']':
            scanner.consume();
            emit(JSONToken.RBracket);
            break;
        case ':':
            scanner.consume();
            emit(JSONToken.Colon);
            break;
        case ',':
            scanner.consume();
            emit(JSONToken.Comma);
            break;
        case '"':
            parseString();
            break;
        default: {
            parseValue();
            break;
        }
        }

        return nextToken();
    }

    void matchWhiteSpaces() throws XerialException {
        for (;;) {
            int c = scanner.LA(1);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
                break;
            scanner.consume();
        }
    }

    public void parseValue() throws XerialException {
        int c = scanner.LA(1);

        if (c == '-' || c >= '0' && c <= '9') {
            parseNumber();
            return;
        }
        else if (match(NULL))
            emit(JSONToken.Null);
        else if (match(TRUE)) {
            emit(JSONToken.True);
        }
        else if (match(FALSE)) {
            emit(JSONToken.False);
        }

        error("value", scanner.LA(1));
    }

    public void parseNumber() throws XerialException {
        {
            int c = scanner.LA(1);
            // Negative flag
            if (c == '-') {
                int c2 = scanner.LA(2);
                if (c2 >= '0' && c2 <= '9') {
                    scanner.consume();
                    c = c2;
                }
                else
                    throw error("Number", c);
            }

            if (c == '0') {
                scanner.consume();
            }
            else if (c >= '1' && c <= '9') {
                scanner.consume();
                matchDigit_s();
            }
            else
                throw error("Number", c);
        }

        {
            int c = scanner.LA(1);
            switch (c) {
            case '.': {
                scanner.consume();
                matchDigit_p();
                int c2 = scanner.LA(1);
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
            int c = scanner.LA(1);
            if (c >= '0' && c <= '9')
                scanner.consume();
            else
                return;
        }
    }

    private void matchDigit_p() throws XerialException {
        int c = scanner.LA(1);
        if (c >= '0' && c <= '9')
            scanner.consume();
        else
            throw error("Digit+", c);

        matchDigit_s();
    }

    private boolean matchExp() throws XerialException {
        {
            int c = scanner.LA(1);
            if (c == 'e' || c == 'E')
                scanner.consume();
            else
                return false;
        }

        {
            int c = scanner.LA(1);
            if (c == '+' || c == '-') {
                scanner.consume();
            }
            matchDigit_p();
        }

        return true;
    }

    private final static byte[] NULL  = { 'n', 'u', 'l', 'l' };
    private final static byte[] TRUE  = { 't', 'r', 'u', 'e' };
    private final static byte[] FALSE = { 'f', 'a', 'l', 's', 'e' };

    boolean match(byte[] text) throws XerialException {
        for (int i = 0; i < text.length; ++i) {
            if (text[i] != scanner.LA(i + 1))
                return false;
        }

        for (int i = 0; i < text.length; ++i)
            scanner.consume();
        return true;

    }

    void parseString() throws XerialException {
        match('"');

        boolean toContinue = true;
        for (;;) {
            int c = scanner.LA(1);
            switch (c) {
            case '"':
                // end of string
                scanner.consume();
                emitString();
                return;
            case '\\':
                // escape sequence 
                matchEscapeSequence();
                break;
            default:
                scanner.consume();
            }
        }

    }

    public void matchEscapeSequence() throws XerialException {
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
            scanner.consume();
            break;
        case 'u':
            scanner.consume();
            for (int i = 0; i < 4; ++i) {
                matchHexDigit();
            }
            break;
        default:
            throw error("escape sequence", c);
        }
    }

    public void matchHexDigit() throws XerialException {
        int c = scanner.LA(1);
        if (c >= '0' && c <= '9' || c >= 'A' && c <= 'F' || c >= 'a' && c >= 'f') {
            scanner.consume();
        }
        else {
            throw error("hex digit", c);
        }
    }

    public void match(int expected) throws XerialException {
        int c = scanner.LA(1);
        if (c != expected)
            throw new XerialException(XerialErrorCode.PARSE_ERROR, String.format("expected:'%s' but found '%s'",
                    expected, c));
    }

    private XerialException error(String tokenType, int foundChar) {
        return new XerialException(XerialErrorCode.PARSE_ERROR, String.format("<%s> invalid char '%s'", tokenType,
                foundChar));
    }

    void emit(JSONToken type) {
        tokenQueue.add(new Token(type, null));
    }

    void emitText(JSONToken type) {
        tokenQueue.add(new Token(type, scanner.selectedString()));
    }

    void emitString() {
        tokenQueue.add(new Token(JSONToken.String, scanner.selectedString(1)));
    }

    public int getLineNumber() {
        return scanner.getLineNumber();
    }

    public int getPosInLine() {
        return scanner.getPosInLine();
    }

}
