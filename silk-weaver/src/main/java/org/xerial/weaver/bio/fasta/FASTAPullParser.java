/*--------------------------------------------------------------------------
 *  Copyright 2007 utgenome.org
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
// UTGB Common Project
//
// FASTAPullParser.java
// Since: Jun 4, 2007
//
// $URL: http://svn.utgenome.org/utgb/trunk/utgb/utgb-core/src/main/java/org/utgenome/format/fasta/FASTAPullParser.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.weaver.bio.fasta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import org.xerial.weaver.SilkWeaverErrorCode;
import org.xerial.weaver.SilkWeaverException;

/**
 * A pull parser for FASTA format files
 * 
 * @author leo
 * 
 */
public class FASTAPullParser {
    private static enum TokenType {
        DescriptionLine, SequenceLine
    }

    private static class Token {
        private TokenType type;
        private String data;

        public Token(TokenType type, String data) {
            this.type = type;
            this.data = data.trim();
        }

        public TokenType getType() {
            return type;
        }

        public String getData() {
            return data;
        }
    }

    private LinkedList<Token> tokenStack = new LinkedList<Token>();
    private final BufferedReader fastaReader;
    private int lineCount = 0;

    public FASTAPullParser(Reader reader) {
        fastaReader = new BufferedReader(reader);
    }

    public FASTAPullParser(File fastaFile) throws FileNotFoundException {
        fastaReader = new BufferedReader(new FileReader(fastaFile));
    }

    private boolean hasStackedToken() {
        return !tokenStack.isEmpty();
    }

    private Token popToken() {
        return tokenStack.removeLast();
    }

    private Token nextToken() throws IOException {
        if (hasStackedToken())
            return popToken();
        else {
            // read next line
            String line = fastaReader.readLine();
            if (line == null)
                return null; // no more token
            lineCount++;
            if (line.startsWith(">"))
                return new Token(TokenType.DescriptionLine, line.substring(1));
            else
                return new Token(TokenType.SequenceLine, line);
        }
    }

    /**
     * read the next fasta sequence;
     * 
     * @return the next fasta sequence, or null when there is no more sequence
     *         to read.
     * @throws InvalidFormatException
     *             when the input fasta data format is invalid
     * @throws IOException
     */
    public FASTASequence nextSequence() throws SilkWeaverException, IOException {
        Token t = nextToken();
        if (t == null)
            return null;

        TokenType type = t.getType();
        if (type == TokenType.DescriptionLine) {
            String seq = readSequence();
            return new FASTASequence(t.getData(), seq);
        }
        else
            return null;
    }

    public String nextSequenceLine() throws IOException {
        Token t = nextToken();
        if (t == null)
            return null;

        TokenType type = t.getType();
        if (type == TokenType.SequenceLine) {
            return t.getData();
        }
        else {
            tokenStack.add(t);
            return null;
        }
    }

    public String nextDescriptionLine() throws IOException {
        Token t = nextToken();
        if (t == null)
            return null;
        if (t.getType() == TokenType.DescriptionLine) {
            return t.getData();
        }
        else {
            tokenStack.add(t);
            return null;
        }
    }

    private String readSequence() throws SilkWeaverException, IOException {
        Token t = nextToken();
        if (t == null)
            throw new SilkWeaverException(SilkWeaverErrorCode.INVALID_FORMAT, "sequence is null: "
                    + lineInfo());

        TokenType type;
        StringBuilder builder = new StringBuilder();
        while ((type = t.getType()) == TokenType.SequenceLine) {
            builder.append(t.getData());
            t = nextToken();
            if (t == null) {
                return builder.toString();
            }
        }
        tokenStack.add(t);
        return builder.toString();

    }

    private String lineInfo() {
        return "line=" + lineCount;
    }

}
