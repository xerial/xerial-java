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
// SilkLogWriter.java
// Since: Oct 13, 2009 3:35:01 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Generating log in Silk format
 * 
 * @author leo
 * 
 */
public class SilkLogWriter implements LogWriter {

    private Writer logOut = new OutputStreamWriter(System.err);

    public SilkLogWriter() {

    }

    public SilkLogWriter(Writer out) {
        this.logOut = out;
    }

    public void log(Logger logger, LogLevel logLevel, Object message) throws IOException {

        if (logOut == null)
            return; // no output is specified

        DateFormat df = DateFormat.getDateTimeInstance();

        synchronized (this) {
            Date now = new Date();
            logOut.write(String.format("-log(level:%s, name:%s, time:\"%s\")", logLevel.name()
                    .toLowerCase(), logger.getLoggerName(), df.format(now)));

            if (message != null) {
                logOut.write(">>");
                logOut.write(NEW_LINE);
                String m = escapeText(message.toString());
                logOut.write(m);
            }

            logOut.write(NEW_LINE);
            logOut.flush();
        }

    }

    public static final String NEW_LINE = System.getProperty("line.separator");

    public static String escapeText(String text) {
        String[] line = text.split("\r?\n");
        if (line == null)
            return escapeDataLine(text);

        List<String> buf = new ArrayList<String>();
        for (String each : line) {
            buf.add(escapeDataLine(each));
        }
        return join(buf, NEW_LINE);
    }

    private static Pattern leadingHyphen = Pattern.compile("\\s*-");

    private static String escapeDataLine(String dataLine) {

        if (dataLine == null)
            return dataLine;

        Matcher m = leadingHyphen.matcher(dataLine);
        if (m.lookingAt()) {
            int hyphenPos = m.end();
            StringBuilder buf = new StringBuilder();
            buf.append(dataLine.substring(0, hyphenPos - 1));
            buf.append("\\");
            buf.append(dataLine.substring(hyphenPos - 1));
            return buf.toString();
        }

        // no change
        return dataLine;
    }

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

}
