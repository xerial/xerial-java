/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// MultiCommandOptionParser.java
// Since: 2011/02/01 17:11:01
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.lang.reflect.Modifier;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.util.FileResource;
import org.xerial.util.PrefixTree;
import org.xerial.util.ResourceFilter;
import org.xerial.util.io.VirtualFile;
import org.xerial.util.log.Logger;

/**
 * Option parser supporting multiple command.
 * 
 * @author leo
 * 
 */
public class MultiCommandOptionParser {

    private static Logger _logger = Logger.getLogger(MultiCommandOptionParser.class);

    public static class GlobalOption {
        @Argument(index = 0)
        public String command;
        @Option(symbol = "h", longName = "help", description = "display help messages")
        public boolean displayHelp = false;
    }

    private PrefixTree<Class<Command>> commandList = new PrefixTree<Class<Command>>();

    public static class Message {
        public String defaultMessage = "type --help for the list of sub commands";
    }

    private final Message message;
    private GlobalOption globalOption;
    private OptionParser globalOptionParser;

    public MultiCommandOptionParser() {
        this(new Message());
    }

    public MultiCommandOptionParser(Message m) {
        this.message = m;
    }

    public void addCommand(Class< ? > commandClass) {
        try {
            if (!Modifier.isAbstract(commandClass.getModifiers())
                    && Command.class.isAssignableFrom(commandClass)) {
                // found a sub command class
                @SuppressWarnings("unchecked")
                Class<Command> cl = (Class<Command>) commandClass;
                Command subCommand = (Command) commandClass.newInstance();
                if (subCommand == null)
                    return;
                commandList.add(subCommand.name(), cl);
            }
        }
        catch (InstantiationException e) {
            _logger.error(e);
        }
        catch (IllegalAccessException e) {
            _logger.error(e);
        }
    }

    public void addCommandsIn(Package packageToSearch) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String packageName = packageToSearch.getName();
        List<VirtualFile> classFileList = FileResource.listResources(packageName,
                new ResourceFilter() {
                    public boolean accept(String resourcePath) {
                        return resourcePath.endsWith(".class");
                    }
                });
        for (VirtualFile vf : classFileList) {
            String logicalPath = vf.getLogicalPath();
            int dot = logicalPath.lastIndexOf(".");
            if (dot <= 0)
                continue;
            String className = packageName + "."
                    + logicalPath.substring(0, dot).replaceAll("/", ".");
            try {
                Class< ? > c = Class.forName(className, false, contextClassLoader);
                addCommand(c);
            }
            catch (ClassNotFoundException e) {
                continue;
            }
        }

    }

    public void addModule() {

    }

    public void displayDefaultMessage() {
        System.out.println(message.defaultMessage);
    }

    public void displayHelpMessage() {

        // display the help message of the global options
        if (globalOptionParser == null) {
            globalOption = new GlobalOption();
            globalOptionParser = new OptionParser(globalOption);
        }

        globalOptionParser.printUsage();
        // list all sub commands
        System.out.println("[sub commands]");
        for (String subCommandName : commandList.keySet()) {
            try {
                Command c = commandList.get(subCommandName).newInstance();
                System.out.format("  %-15s\t%s", subCommandName, c.getOneLineDescription());
                System.out.println();
            }
            catch (InstantiationException e) {
                _logger.error(e);
            }
            catch (IllegalAccessException e) {
                _logger.error(e);
            }
        }
        return;
    }

    public void execute(String[] args) throws Exception {

        // Create a new instance of the option holder for each call 
        globalOption = new GlobalOption();
        globalOptionParser = new OptionParser(globalOption);
        globalOptionParser.setIgnoreUnknownOption(true);

        try {
            globalOptionParser.parse(args);

            if (globalOption.command == null) {
                if (globalOption.displayHelp)
                    displayHelpMessage();
                else
                    displayDefaultMessage();
                return;
            }

            // search for sub command
            Class<Command> subCommandCl = commandList.findBy(globalOption.command);
            if (subCommandCl == null)
                throw new OptionParserException(XerialErrorCode.UNKNOWN_COMMAND, String.format(
                        "unkown command %s", globalOption.command));
            Command subCommand = subCommandCl.newInstance();

            Object subCommandOption = subCommand.getOptionHolder();
            OptionParser subOpt = new OptionParser(subCommandOption);
            if (globalOption.displayHelp) {
                subOpt.printUsage();
            }
            else {
                subOpt.parse(globalOptionParser.getUnusedArguments());
                subCommand.execute();
            }

        }
        catch (Exception e) {
            throw e;
        }

    }

}
