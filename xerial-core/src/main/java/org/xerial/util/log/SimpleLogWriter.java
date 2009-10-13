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
// ConsoleLogWriter.java
// Since: Oct 13, 2009 3:25:28 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.log;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.xerial.util.StringUtil;

/**
 * Generating log for console output
 * 
 * @author leo
 * 
 */
public class SimpleLogWriter implements LogWriter {

    private Writer logOut;

    public SimpleLogWriter() {
        logOut = new OutputStreamWriter(System.err);
    }

    public SimpleLogWriter(OutputStream out) {
        logOut = new OutputStreamWriter(out);
    }

    public SimpleLogWriter(Writer out) {
        logOut = out;
    }

    private static String[] logPrefix = { "", // ALL
            "\033[0;32m", // TRACE
            "", // DEBUG
            "\033[1;36m", // INFO
            "\033[1;33m", // WARN
            "\033[1;35m", // ERROR
            "\033[1;31m", // FATAL
            "", // OFF
            "", };

    public void log(Logger logger, LogLevel logLevel, Object message) {

        if (logOut == null)
            return; // no output is specified

        try {
            synchronized (this) {
                if (logger.isColorEnabled())
                    logOut.write(logPrefix[logLevel.ordinal()]);

                logOut.write(String.format("[%s] %s", logger.getLoggerShortName(),
                        message != null ? message.toString() : ""));
                if (logger.isColorEnabled())
                    logOut.write("\033[0m");

                logOut.write(StringUtil.newline());

                logOut.flush();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
