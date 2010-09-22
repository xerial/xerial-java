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
// Xerial Silk Weaver Project 
//
// SilkWeaverModuleBase.java
// Since: 2009/07/22 14:27:21
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.xerial.util.FileResource;
import org.xerial.util.log.LogLevel;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;

/**
 * Base implementation of SilkWeaverModule
 * 
 * @author leo
 * 
 */
public abstract class SilkWeaverModuleBase implements SilkWeaverModule {

    private final Package commandBasePackage;
    private final Logger _logger;
    private final List<SilkWeaverModule> subModuleList = new ArrayList<SilkWeaverModule>();

    /**
     * Command-line option parameter definition
     * 
     */

    @Argument(index = 0, required = false, name = "command")
    protected String commandName = null;

    @Option(symbol = "h", longName = "help", description = "display help message")
    protected boolean displayHelp = false;

    @Option(longName = "loglevel", varName = "LEVEL", description = "set log level: OFF, TRACE, DEBUG, INFO(default), WARN, ERROR, FATAL")
    protected LogLevel logLevel = null;

    @Option(symbol = "l", longName = "logconfig", varName = "path", description = "specify the path to the log config file")
    protected String logConfigFilePath = null;

    protected SilkWeaverModuleBase(Package commandBasePackage) {
        this.commandBasePackage = commandBasePackage;
        this._logger = Logger.getLogger(this.commandBasePackage);
    }

    public Package getCommandBasePackage() {
        return commandBasePackage;
    }

    public void addModule(SilkWeaverModule module) {
        subModuleList.add(module);
    }

    public List<SilkWeaverModule> getModuleList() {
        return subModuleList;
    }

    public int execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {

        // set the log level
        if (logLevel != null) {
            Logger packageLogger = Logger.getLogger("org.xerial.weaver");
            packageLogger.setLogLevel(logLevel);
        }

        // load log config file
        if (logConfigFilePath != null) {
            File logConfig = new File(logConfigFilePath);
            if (logConfig.exists()) {
                try {
                    Logger.configure(logConfig.getAbsolutePath());
                }
                catch (IOException e) {
                    _logger.warn(e);
                }
            }
            else
                _logger.warn("log config file doesn't exist: " + logConfig.getAbsolutePath());
        }

        if (commandName == null) {
            System.out.println(getProgramInfo());
            if (displayHelp) {
                displayHelp();
                return ReturnCode.SUCCESS.toInt();
            }
            else {
                System.out.println("type --help for a list of the available commands");
                return ReturnCode.SUCCESS.toInt();
            }
        }
        else {
            // search target commands
            SilkWeaverCommand c = find(commandName);
            if (c == null) {
                System.err.println("unknown command: " + commandName);
                System.err.println("type --help for a list of the available commands");
                return ReturnCode.EINVAL.toInt();
            }
            else {
                // bind the unused arguments to the sub command
                OptionParser p = new OptionParser(c);
                p.setIgnoreUnknownOption(true);
                try {
                    p.parse(unusedArgs);
                }
                catch (OptionParserException e) {
                    System.err.println(e.getMessage());
                    displayHelp = true;
                }

                if (!displayHelp) {
                    // execute the sub command
                    c.execute(this, p.getUnusedArguments());
                }
                else {
                    // display help message for the specified command 
                    if (SilkWeaverModule.class.isInstance(c)) {
                        SilkWeaverModule.class.cast(c).displayHelp();
                    }
                    else {
                        displayHelp();
                    }
                }
            }
        }

        return ReturnCode.SUCCESS.toInt();

    }

    public void displayHelp() {
        displayHelp(commandName);
    }

    public void displayHelp(String commandName) {
        if (commandName == null) {
            // display command list
            OptionParser parser = new OptionParser(this);
            parser.printUsage();
            displayCommandList();
            return;
        }
        else {
            // search target commands
            SilkWeaverCommand c = find(commandName);
            if (c == null) {
                System.err.println("unknown command: " + commandName);
                return;
            }
            else {
                // display help message for the specified command
                OptionParser p = new OptionParser(c);
                p.printUsage();
            }
        }
    }

    public void displayCommandList() {
        System.out.println("[available commands]");

        for (SilkWeaverCommand c : getSubCommandList()) {
            System.out.println(String.format("  %-15s %s", c.getCommandName(),
                    c.getOneLineDescription()));
        }
    }

    public SilkWeaverCommand find(String commandName) {
        for (SilkWeaverCommand each : getSubCommandList()) {
            if (each.getCommandName().equals(commandName))
                return each;
        }
        return null;
    }

    public List<SilkWeaverCommand> getSubCommandList() {
        List<Class<SilkWeaverCommand>> subCommandTypes = FileResource.findClasses(
                commandBasePackage, SilkWeaverCommand.class, Thread.currentThread()
                        .getContextClassLoader());
        ArrayList<SilkWeaverCommand> commandList = new ArrayList<SilkWeaverCommand>();

        if (subCommandTypes == null)
            return commandList;

        for (Class<SilkWeaverCommand> each : subCommandTypes) {
            try {
                SilkWeaverCommand c = each.newInstance();
                if (c.getCommandName() != null && !SilkWeaverModule.class.isInstance(c))
                    commandList.add(c); // add except global module
            }
            catch (InstantiationException e) {
                _logger.warn(e);
            }
            catch (IllegalAccessException e) {
                _logger.warn(e);
            }
        }

        for (SilkWeaverModule m : getModuleList()) {
            commandList.add(m);
        }

        // lexicographical sort the command list
        Collections.sort(commandList, new Comparator<SilkWeaverCommand>() {
            public int compare(SilkWeaverCommand o1, SilkWeaverCommand o2) {
                int diff = o1.getCommandName().compareTo(o2.getCommandName());
                if (diff == 0)
                    _logger.warn(String.format("duplicate commands found: %s and %s",
                            o1.getClass(), o2.getClass()));
                return diff;
            }
        });

        return commandList;
    }

}
