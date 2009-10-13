/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XerialJ Project
//
// Logger.java
// Since: Jul 9, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Logger
 * 
 * @author leo
 * 
 */
public class Logger {

    private LogWriter writer = null;
    private LogLevel _threshold = LogLevel.UNSPECIFIED;
    private String _loggerFullName = "";
    private String _loggerShortName = "";
    private Logger _parentLogger = null;
    private boolean _emitEscapeSequence = false;

    private static TreeMap<String, Logger> _loggerHolder = new TreeMap<String, Logger>();
    private static Logger _rootLogger = new Logger();

    static {
        _rootLogger.setLogLevel(LogLevel.INFO);
        _rootLogger.setLogWriter(new SimpleLogWriter());

        _rootLogger._loggerFullName = "root";
        _rootLogger._loggerShortName = "root";

        String logLevel = System.getProperty("xerial.loglevel");
        if (logLevel != null) {
            _rootLogger.setLogLevel(logLevel);
        }
        else {
            logLevel = System.getProperty("loglevel");
            if (logLevel != null) {
                _rootLogger.setLogLevel(logLevel);
            }
        }

        String useColor = System.getProperty("log.color");
        if (useColor != null)
            _rootLogger._emitEscapeSequence = Boolean.parseBoolean(useColor);

        String loggerConfigFile = System.getProperty("log.config");
        if (loggerConfigFile != null) {
            try {
                Logger.configure(loggerConfigFile);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * hide constructor
     */
    private Logger() {

    }

    private Logger(String fullTypeName) {
        _loggerFullName = fullTypeName;
        String[] packageList = _loggerFullName.split("\\.");
        _loggerShortName = packageList[packageList.length - 1];
        if (packageList.length == 1)
            _parentLogger = _rootLogger;
        else {
            String parentPackageName = concatinate(packageList, packageList.length - 1);
            _parentLogger = getLogger(parentPackageName);
        }
    }

    private String concatinate(String[] packageList, int upTo) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < upTo - 1; i++) {
            builder.append(packageList[i]);
            builder.append(".");
        }
        builder.append(packageList[upTo - 1]);
        return builder.toString();
    }

    public static Logger getLogger(Class< ? > c) {
        return getLogger(c.getName());
    }

    public static Logger getLogger(Class< ? > c, String suffix) {
        if (suffix == null || suffix.length() <= 0)
            return getLogger(c);
        else
            return getLogger(String.format("%s-%s", c.getName(), suffix));
    }

    public static Logger getLogger(Package p) {
        return getLogger(p.getName());
    }

    public static synchronized Logger getLogger(String fullTypeName) {
        if (fullTypeName == null)
            return _rootLogger;

        if (_loggerHolder.containsKey(fullTypeName))
            return _loggerHolder.get(fullTypeName);
        else {
            Logger newLogger = new Logger(fullTypeName);
            _loggerHolder.put(fullTypeName, newLogger);
            newLogger._emitEscapeSequence = _rootLogger._emitEscapeSequence;
            return newLogger;
        }
    }

    public static Logger getRootLogger() {
        return _rootLogger;
    }

    public static void configure(String configFile) throws IOException {
        configure(new BufferedReader(new FileReader(configFile)));
    }

    public static void configure(Reader configurationFileReader) throws IOException {
        Properties configProperties = new Properties();

        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = configurationFileReader.read()) > 0) {
            sb.append((char) ch);
        }
        ByteArrayInputStream bs = new ByteArrayInputStream(sb.toString().getBytes());
        configProperties.load(bs);

        for (Object key : configProperties.keySet()) {
            String[] lhs = ((String) key).split("#");
            String loggerName = lhs[0];
            String value = configProperties.getProperty(key.toString());
            Logger logger = getLogger(loggerName);
            if (lhs.length <= 1) {
                logger.setLogLevel(value);
            }
            else if (lhs.length > 1) {
                // packageName:parameter = value configuration
                String parameter = lhs[1];
                if (parameter.equals("color")) {
                    logger.enableColor(Boolean.parseBoolean(value));
                }
                else {
                    System.err.println("unknown configuration parameter: " + parameter);
                }
            }
            else {
                System.err.println("Error in the logger configuration file: " + key);
            }
        }
    }

    public String getLoggerName() {
        return _loggerFullName;
    }

    public String getLoggerShortName() {
        return _loggerShortName;
    }

    public void setLogLevel(LogLevel logLevel) {
        this._threshold = logLevel;
    }

    public void setLogLevel(String logLevel) {
        for (LogLevel l : LogLevel.values()) {
            if (l.name().equalsIgnoreCase(logLevel)) {
                setLogLevel(l);
                return;
            }
        }

        warn("unknown log level: " + logLevel);
    }

    public LogLevel getLogLevel() {
        return _threshold;
    }

    public void setLogWriter(LogWriter writer) {
        if (writer == null)
            throw new NullPointerException();

        this.writer = writer;
    }

    public boolean trace(Object message) {
        log(LogLevel.TRACE, message);
        return true;
    }

    public boolean debug(Object message) {
        log(LogLevel.DEBUG, message);
        return true;
    }

    public boolean info(Object message) {
        log(LogLevel.INFO, message);
        return true;
    }

    public boolean warn(Object message) {
        log(LogLevel.WARN, message);
        return true;
    }

    public boolean error(Object message) {
        log(LogLevel.ERROR, message);
        return true;
    }

    public boolean fatal(Object message) {
        log(LogLevel.FATAL, message);
        return true;
    }

    /**
     * Use colored console outputs using escape sequences
     * 
     * @param enable
     * @return
     */
    public void enableColor(boolean enable) {
        _emitEscapeSequence = enable;
    }

    /**
     * @return true when escape sequence is used to output the log
     */
    public boolean isColorEnabled() {
        return _emitEscapeSequence;
    }

    public boolean isDebugEnabled() {
        return isEnabled(LogLevel.DEBUG);
    }

    public boolean isTraceEnabled() {
        return isEnabled(LogLevel.TRACE);
    }

    public boolean isInfoEnabled() {
        return isEnabled(LogLevel.INFO);
    }

    public boolean isWarnEnabled() {
        return isEnabled(LogLevel.WARN);
    }

    public boolean isErrorEnabled() {
        return isEnabled(LogLevel.ERROR);
    }

    public boolean isFatalEnalbed() {
        return isEnabled(LogLevel.FATAL);
    }

    public boolean isEnabled(LogLevel logLevel) {
        if (_threshold == LogLevel.UNSPECIFIED) {
            Logger parent = this;
            while ((parent = parent._parentLogger) != null) {
                if (parent.getLogLevel() == LogLevel.UNSPECIFIED)
                    continue;

                _threshold = parent.getLogLevel();
                break;
            }
            if (_threshold == LogLevel.UNSPECIFIED)
                return false;
        }
        return _threshold.ordinal() <= logLevel.ordinal();
    }

    private LogWriter getLogWriter() {
        if (writer != null)
            return writer;
        else {
            if (_parentLogger != null)
                return _parentLogger.getLogWriter();
            else
                return null;
        }
    }

    private void log(LogLevel logLevel, Object message) {
        if (!isEnabled(logLevel))
            return;

        LogWriter logOut = getLogWriter();
        if (logOut == null)
            return; // no output is specified

        try {
            logOut.log(this, logLevel, message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
