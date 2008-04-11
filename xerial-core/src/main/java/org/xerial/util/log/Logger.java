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
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.TreeMap;

import org.xerial.util.StringUtil;

public class Logger
{
    private static String[] logPrefix = { "", // ALL
            "\033[0;32m", // TRACE
            "", // DEBUG
            "\033[1;36m", // INFO
            "\033[1;33m", // WARN
            "\033[1;35m", // ERROR
            "\033[1;31m", // FATAL
            "", // OFF
            "", };

    private Writer _out = null;
    private LogLevel _threshold = LogLevel.UNSPECIFIED;
    private String _loggerFullName = "";
    private String _loggerShortName = "";
    private Logger _parentLogger = null;
    private boolean _emitEscapeSequence = false;

    private static TreeMap<String, Logger> _loggerHolder = new TreeMap<String, Logger>();
    private static Logger _rootLogger = new Logger();

    static
    {
        _rootLogger.setLogLevel(LogLevel.INFO);
        _rootLogger.setOutputWriter(new OutputStreamWriter(System.out));
        _rootLogger._loggerFullName = "root";
        _rootLogger._loggerShortName = "root";

        String logLevel = System.getProperty("xerial.loglevel");
        if(logLevel != null)
        {
            _rootLogger.setLogLevel(logLevel);
        }
        else
        {
            logLevel = System.getProperty("loglevel");
            if(logLevel != null)
            {
                _rootLogger.setLogLevel(logLevel);
            }
        }
        
        
        String loggerConfigFile = System.getProperty("log.config");
        if (loggerConfigFile != null)
        {
            try
            {
                Logger.configure(loggerConfigFile);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    /**
     * Non constractable
     */
    private Logger()
    {

    }

    private Logger(String fullTypeName)
    {
        _loggerFullName = fullTypeName;
        String[] packageList = _loggerFullName.split("\\.");
        _loggerShortName = packageList[packageList.length - 1];
        if (packageList.length == 1)
            _parentLogger = _rootLogger;
        else
        {
            String parentPackageName = concatinate(packageList, packageList.length - 1);
            _parentLogger = getLogger(parentPackageName);
        }
    }

    private String concatinate(String[] packageList, int upTo)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < upTo - 1; i++)
        {
            builder.append(packageList[i]);
            builder.append(".");
        }
        builder.append(packageList[upTo - 1]);
        return builder.toString();
    }

    @SuppressWarnings("unchecked")
    public static Logger getLogger(Class c)
    {
        return getLogger(c.getName());
    }

    public static Logger getLogger(Package p)
    {
        return getLogger(p.getName());
    }

    public static synchronized Logger getLogger(String fullTypeName)
    {
        if (fullTypeName == null)
            return _rootLogger;

        if (_loggerHolder.containsKey(fullTypeName))
            return _loggerHolder.get(fullTypeName);
        else
        {
            Logger newLogger = new Logger(fullTypeName);
            _loggerHolder.put(fullTypeName, newLogger);
            return newLogger;
        }
    }

    public static Logger getRootLogger()
    {
        return _rootLogger;
    }

    public static void configure(String configFile) throws IOException
    {
        configure(new BufferedReader(new FileReader(configFile)));
    }

    public static void configure(Reader configurationFileReader) throws IOException
    {
    	Properties configProperties = new Properties();
    	
    	StringBuilder sb = new StringBuilder();
    	int ch;
    	while((ch = configurationFileReader.read()) > 0)
    	{  
    	    sb.append((char) ch);
    	}
    	ByteArrayInputStream bs = new ByteArrayInputStream(sb.toString().getBytes());
    	configProperties.load(bs);
    	
    	for(Object key : configProperties.keySet())
    	{
    	    String[] lhs = ((String) key).split("#");
    		String loggerName = lhs[0];
    		String value = configProperties.getProperty(key.toString());
    		Logger logger = getLogger(loggerName);
    		if(lhs.length <= 1)
    		{
    		    logger.setLogLevel(value);
    		}
    		else if(lhs.length > 1)
    		{
    		    // packageName:parameter = value configuration
    		    String parameter = lhs[1];
    		    if(parameter.equals("color"))
    		    {
    		        logger.setColor(Boolean.parseBoolean(value));
    		    }
    		    else
    		    {
    		        System.err.println("unknown configuration parameter: " + parameter);
    		    }
    		}
    		else
    		{
    		    System.err.println("Error in the logger configuration file: " + key);
    		}
    	}
    }

    public String getLoggerName()
    {
        return _loggerFullName;
    }

    public void setLogLevel(LogLevel logLevel)
    {
        this._threshold = logLevel;
    }

    public void setLogLevel(String logLevel)
    {
        for (LogLevel l : LogLevel.values())
        {
            if (l.name().toLowerCase().equals(logLevel.toLowerCase()))
            {
                setLogLevel(l);
                return;
            }
        }

        throw new IllegalArgumentException("unknown log level: " + logLevel);
    }

    public LogLevel getLogLevel()
    {
        return _threshold;
    }

    public void setOutputWriter(Writer writer)
    {
        this._out = writer;
    }

    public void trace(Object message)
    {
        log(LogLevel.TRACE, message);
    }

    public void debug(Object message)
    {
        log(LogLevel.DEBUG, message);
    }

    public void info(Object message)
    {
        log(LogLevel.INFO, message);
    }

    public void warn(Object message)
    {
        log(LogLevel.WARN, message);
    }

    public void error(Object message)
    {
        log(LogLevel.ERROR, message);
    }

    public void fatal(Object message)
    {
        log(LogLevel.FATAL, message);
    }

    /**
     * Use colored console outputs using escape sequences
     * 
     * @param enable
     * @return
     */
    public void setColor(boolean enable)
    {
        _emitEscapeSequence = enable;
    }

    /**
     * @return true when escape sequence is used to output the log
     */
    public boolean isEnabledColor()
    {
        return _emitEscapeSequence;
    }

    public boolean isEnabled(LogLevel logLevel)
    {
        if (_threshold == LogLevel.UNSPECIFIED)
        {
            if (_parentLogger != null)
                return _parentLogger.isEnabled(logLevel);
            else
                return false;
        }
        return _threshold.ordinal() <= logLevel.ordinal();
    }

    private Writer getWriter()
    {
        if (_out != null)
            return _out;
        else
        {
            if (_parentLogger != null)
                return _parentLogger.getWriter();
            else
                return null;
        }
    }

    private void log(LogLevel logLevel, Object message)
    {
        if (!isEnabled(logLevel))
            return;

        Writer logOut = getWriter();
        if (logOut == null)
            return; // no output is specified

        try
        {
            if (_emitEscapeSequence)
                logOut.write(logPrefix[logLevel.ordinal()]);
            logOut.write("[" + _loggerShortName + "]\t");
            if (message != null)
                logOut.write(message.toString());
            if (_emitEscapeSequence)
                logOut.write("\033[0m");
            logOut.write(StringUtil.newline());
            logOut.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
