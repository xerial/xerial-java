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
// SilkMain.java
// Since: Apr 9, 2009 5:00:14 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import java.io.OutputStreamWriter;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;

/**
 * Command-line interface for managing Silk data format.
 * 
 * @author leo
 * 
 */
public class SilkMain
{
    private static Logger _logger = Logger.getLogger(SilkMain.class);

    private static List<Class<SilkCommand>> availableCommands;

    public static class SilkOption
    {
        @Option(symbol = "h", longName = "help", description = "display help message")
        boolean displayHelp = false;

        @Argument(index = 0, name = "sub command", required = false)
        String subCommand = "help";
    }

    public static void main(String[] args)
    {
        Logger.getRootLogger().setOutputWriter(new OutputStreamWriter(System.err));

        availableCommands = FileResource.findClasses(SilkMain.class.getPackage(), SilkCommand.class, SilkMain.class
                .getClassLoader());

        SilkOption option = new SilkOption();
        OptionParser parser = new OptionParser(option);
        parser.setIgnoreUnknownOption(true);
        try
        {
            parser.parse(args);

            if (option.subCommand == null)
                throw new XerialException(XerialErrorCode.INVALID_INPUT, "no command");

            SilkCommand command = null;
            for (Class<SilkCommand> each : availableCommands)
            {
                try
                {
                    command = each.newInstance();
                    if (command.getName() != null && command.getName().equals(option.subCommand))
                        break;
                }
                catch (InstantiationException e)
                {
                    _logger.warn(e);
                }
                catch (IllegalAccessException e)
                {
                    _logger.warn(e);
                }
            }

            if (command == null)
            {
                _logger.error("command is not specified");
                return;
            }

            // run the sub command
            OptionParser subCommandOptionParser = new OptionParser(command);
            subCommandOptionParser.parse(parser.getUnusedArguments());
            command.execute(subCommandOptionParser);

        }
        catch (Exception e)
        {
            _logger.error(e);
            e.printStackTrace();
        }

    }

}
