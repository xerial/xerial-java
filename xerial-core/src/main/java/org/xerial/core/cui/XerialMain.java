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
// XerialMain.java
// Since: Apr 9, 2009 5:00:14 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core.cui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.PrefixTree;
import org.xerial.util.log.LogLevel;
import org.xerial.util.log.Logger;
import org.xerial.util.log.SimpleLogWriter;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;

/**
 * Command-line interface for managing Silk data format.
 * 
 * @author leo
 * 
 */
public class XerialMain {
    private static Logger _logger = Logger.getLogger(XerialMain.class);

    public static class SilkGlobalOption {
        @Option(symbol = "h", longName = "help", description = "display help message")
        boolean displayHelp = false;

        @Option(symbol = "l", longName = "loglevel", description = "set loglevel to one of TRACE, DEBUG, INFO, WARN, ERROR, FATAL or ALL")
        protected LogLevel logLevel = null;

        @Argument(index = 0, name = "sub command", required = false)
        String subCommand = null;
    }

    static PrefixTree<XerialCommand> commandTable = new PrefixTree<XerialCommand>();

    static {
        for (Class<XerialCommand> each : FileResource.findClasses(XerialMain.class.getPackage(),
                XerialCommand.class, XerialMain.class.getClassLoader())) {
            try {
                XerialCommand command = each.newInstance();
                if (command.getName() != null)
                    commandTable.add(command.getName(), command);
            }
            catch (InstantiationException e) {
                _logger.warn(e);
            }
            catch (IllegalAccessException e) {
                _logger.warn(e);
            }

        }
    }

    public static int execute(String[] args) throws Exception {
        Logger.getRootLogger().setLogWriter(new SimpleLogWriter(System.err));

        SilkGlobalOption globalOption = new SilkGlobalOption();
        OptionParser parser = new OptionParser(globalOption);

        parser.parse(args, true);
        if (globalOption.logLevel != null)
            Logger.getRootLogger().setLogLevel(globalOption.logLevel);

        // find a sub command by its prefix
        XerialCommand command = commandTable.findBy(globalOption.subCommand);

        // display help
        if (command == null) {
            Help.displayCommandList();
            return XerialCommand.RETURN_WITH_SUCCESS;
        }

        OptionParser subCommandOptionParser = new OptionParser(command);

        if (globalOption.displayHelp) {
            // display the help message of the command
            String helpFileName = String.format("help-%s.txt", command.getName());
            URL helpFileAddr = FileResource.find(XerialMain.class, helpFileName);
            if (helpFileAddr == null) {
                System.out.println(String.format("command: %s", command.getName()));
            }
            else {
                BufferedReader helpReader = new BufferedReader(new InputStreamReader(helpFileAddr
                        .openStream()));
                String line;
                while ((line = helpReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            subCommandOptionParser.printUsage();
            return XerialCommand.RETURN_WITH_SUCCESS;
        }

        // execute the sub command
        subCommandOptionParser.parse(parser.getUnusedArguments());
        command.execute();
        return XerialCommand.RETURN_WITH_SUCCESS;

    }

    public static void main(String[] args) {

        try {
            int code = XerialMain.execute(args);
            System.exit(code);
            return;
        }
        catch (XerialException e) {
            _logger.error(e);
            XerialErrorCode code = e.getErrorCode();
            switch (code) {
            case INVALID_CUI_OPTION:

                break;
            default:
                e.printStackTrace();
                System.exit(XerialCommand.RETURN_WITH_FAILURE);
                return;
            }
        }
        catch (Exception e) {
            _logger.error(e);
            e.printStackTrace();
            System.exit(XerialCommand.RETURN_WITH_FAILURE);
        }
        catch (Error e) {
            e.printStackTrace();
            System.exit(XerialCommand.RETURN_WITH_FAILURE);
        }
    }

}
