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

import org.xerial.silk.SilkWriter;
import org.xerial.util.StringUtil;

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

        synchronized (this) {
            logOut.write(String.format("-%s(name:%s)", logLevel, logger.getLoggerShortName()));

            if (message != null) {
                logOut.write(StringUtil.NEW_LINE);
                String m = SilkWriter.escapeText(message.toString());
                logOut.write(m);
            }

            logOut.write(StringUtil.newline());
            logOut.flush();
        }

    }

}
