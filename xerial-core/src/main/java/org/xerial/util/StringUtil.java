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
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static ArrayList<String> splitAtComma(String line) {
        return split(line, ',');
    }

    public static ArrayList<String> split(String line, char delimiter) {
        int prevPos = 0;
        ArrayList<String> tokens = new ArrayList<String>();
        final int len = line.length();
        for (int c = 0; c < len; ++c) {
            if (line.charAt(c) == delimiter) {
                tokens.add(line.substring(prevPos, c));
                prevPos = c + 1;
            }
        }
        tokens.add(line.substring(prevPos, len));
        return tokens;
    }

}
