/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// org.xerial.util Project
// 
// StringUtil.java 
// Since: 2004/12/30
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.util.impl.CSVLineParser;

/**
 * A utility for manipulating Strings
 * 
 * @author leo
 * 
 */
public class StringUtil {

    public static final String SINGLE_QUOTE = "\'";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String NEW_LINE = System.getProperty("line.separator");

    private StringUtil() {}

    /**
     * Concatenates all elements in the given collection c into a single string
     * with the separator
     * 
     * @param c
     *            a collection of elements to concatenate
     * @param concatinator
     *            a concatenator: ex. ", ", "." etc.
     * @return a concatenated string
     */
    public static <T> String join(Collection<T> c, String concatinator) {
        if (c == null)
            return "";
        int size = c.size();
        if (size == 0)
            return "";

        Iterator<T> it = c.iterator();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; it.hasNext() && i < size - 1; i++) {
            Object data = it.next();
            if (data != null)
                buf.append(data.toString());
            else
                buf.append("null");
            buf.append(concatinator);
        }
        Object lastData = it.next();
        if (lastData != null)
            buf.append(lastData.toString());
        else
            buf.append("null");
        return buf.toString();
    }

    /**
     * Concatenates all elements in the given array c into a single string with
     * the separator
     * 
     * @param c
     *            an array of elements to concatenate
     * @param concatinator
     *            a concatenator: ex. ", ", "." etc.
     * @return the concatenated string
     */
    public static String join(Object[] c, String concatinator) {
        if (c == null)
            return "";
        int size = c.length;
        if (size == 0)
            return "";

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            Object data = c[i];
            buf.append(data != null ? data.toString() : "");
            buf.append(concatinator);
        }
        buf.append(c[size - 1]);
        return buf.toString();
    }

    /**
     * quote a given message with an quotation mark
     * 
     * @param message
     * @param quotationMark
     *            StringUtil.SINGLE_QUOTE, StringUtil.DOUBLE_QUOTE, or other
     *            strings.
     * @return the quoted message
     */
    public static String quote(String message, String quotationMark) {
        if (message == null)
            return message;
        return String.format("%s%s%s", quotationMark, message, quotationMark);
    }

    public static String doubleQuote(String message) {
        return quote(message, DOUBLE_QUOTE);
    }

    public static String unquote(String message) {
        if (message == null)
            return message;
        if (message.length() > 1) {
            if ((message.charAt(0) == '"' && message.charAt(message.length() - 1) == '"')
                    || (message.charAt(0) == '\'' && message.charAt(message.length() - 1) == '\''))
                return message.substring(1, message.length() - 1);
        }
        return message;
    }

    static Pattern _whiteSpacePattern = Pattern.compile("[ \t\n\r]*");

    static public boolean isWhiteSpace(String s) {
        Matcher m = _whiteSpacePattern.matcher(s);
        return m.matches();
    }

    public static String concatinateWithTab(Object... data) {
        return StringUtil.join(data, "\t");
    }

    public static String newline() {
        return NEW_LINE;
    }

    public static ArrayList<String> splitAtTab(String line) {
        return split(line, '\t');
    }

    public static ArrayList<String> splitCSV(String line) {
        CSVLineParser parser = new CSVLineParser();
        return parser.parseLine(line);
    }

    public static ArrayList<String> split(String line, char delimiter) {
        int prevPos = 0;
        ArrayList<String> tokens = new ArrayList<String>();
        final int len = line.length();
        for (int index = 0; index < len; ++index) {
            if (line.charAt(index) == delimiter) {
                tokens.add(line.substring(prevPos, index));
                prevPos = index + 1;
            }
        }
        tokens.add(line.substring(prevPos, len));
        return tokens;
    }

    private static HashMap<String, String> canonicalNameTable = new HashMap<String, String>();
    private static HashMap<String, String> naturalNameTable = new HashMap<String, String>();
    private static Pattern paramNameReplacePattern = Pattern.compile("[\\s-_]");

    public static String varNameToCanonicalName(String paramName) {
        if (paramName == null)
            return paramName;

        String cName = canonicalNameTable.get(paramName);
        if (cName == null) {
            Matcher m = paramNameReplacePattern.matcher(paramName);
            cName = m.replaceAll("").toLowerCase();
            canonicalNameTable.put(paramName, cName);
        }
        return cName;
    }

    public static String varNameToNaturalName(String varName) {
        if (varName == null)
            return null;

        String nName = naturalNameTable.get(varName);
        if (nName == null) {
            ArrayList<String> components = new ArrayList<String>();
            int start = 0;
            int cursor = 0;
            while (cursor < varName.length()) {
                while (cursor < varName.length() && Character.isUpperCase(varName.charAt(cursor))) {
                    cursor++;
                }
                if ((cursor - start) >= 2) {
                    components.add(varName.substring(start, cursor));
                    start = cursor;
                    continue;
                }
                while (cursor < varName.length()) {
                    char c = varName.charAt(cursor);
                    if (isSplitChar(c)) {
                        break;
                    }
                    cursor++;
                }
                if (start < cursor) {
                    components.add(varName.substring(start, cursor).toLowerCase());
                }
                else
                    cursor++;
                start = cursor;
            }
            nName = join(components, " ");
            naturalNameTable.put(varName, nName);
        }
        return nName;
    }

    private static boolean isSplitChar(char c) {
        return Character.isUpperCase(c) || c == '_' || c == '-' || c == ' ';
    }

    /**
     * Split the given string into args[]
     * 
     * @param arg
     * @return
     */
    public static String[] tokenizeCommandLineArgument(String arg) {
        ArrayList<String> split = CommandLineParser.split(arg);
        String[] args = new String[split.size()];
        for (int i = 0; i < split.size(); ++i)
            args[i] = split.get(i);
        return args;
    }

    public static class CommandLineParser {
        private final String arg;
        private int wordStart = 0;
        private int cursor = 0;
        private ArrayList<String> tokens = new ArrayList<String>();

        private CommandLineParser(String arg) {
            this.arg = arg;
        }

        ArrayList<String> split() {

            for (; cursor < arg.length(); cursor++) {
                char c = arg.charAt(cursor);
                switch (c) {
                case '"':
                    parseDoubleQuoteString();
                    break;
                case '\'':
                    parseSingleQuoteString();
                    break;
                case '\\':
                    parseEscapeSequence();
                    break;
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    if (wordStart < cursor) {
                        tokens.add(arg.substring(wordStart, cursor));
                    }
                    wordStart = cursor + 1;
                    break;
                default:
                    break;
                }
            }

            if (wordStart < cursor) {
                tokens.add(arg.substring(wordStart, Math.min(cursor, arg.length())));
            }

            return tokens;
        }

        void parseEscapeSequence() {
            cursor++;
            cursor++;
        }

        void parseDoubleQuoteString() {

            boolean isSingleToken = false;
            if (wordStart == cursor) {
                wordStart = cursor + 1;
                isSingleToken = true;
            }
            cursor++;

            for (; cursor < arg.length(); cursor++) {
                switch (arg.charAt(cursor)) {
                case '\\':
                    parseEscapeSequence();
                    break;
                case '"':
                    if (wordStart < cursor) {
                        tokens.add(arg.substring(wordStart, isSingleToken ? cursor : cursor + 1));
                        wordStart = cursor + 1;
                    }
                    return;
                }
            }

        }

        void parseSingleQuoteString() {

            boolean isSingleToken = false;
            if (wordStart == cursor) {
                wordStart = cursor + 1;
                isSingleToken = true;
            }
            cursor++;
            for (; cursor < arg.length(); cursor++) {
                switch (arg.charAt(cursor)) {
                case '\\':
                    parseEscapeSequence();
                    break;
                case '\'':
                    if (wordStart < cursor) {
                        tokens.add(arg.substring(wordStart, isSingleToken ? cursor : cursor + 1));
                        wordStart = cursor + 1;
                    }
                    return;
                }
            }
        }

        public static ArrayList<String> split(String arg) {
            return new CommandLineParser(arg).split();
        }

    }

}
