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
// CommandModule.java
// Since: 2011/02/01 17:13:23
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.util.FileResource;
import org.xerial.util.PrefixTree;
import org.xerial.util.ResourceFilter;
import org.xerial.util.io.VirtualFile;
import org.xerial.util.log.Logger;

/**
 * A set of commands
 * 
 * @author leo
 * 
 */
public class CommandModuleBase implements CommandModule {

    private static Logger _logger = Logger.getLogger(CommandModuleBase.class);
    private PrefixTree<Command> commandList = new PrefixTree<Command>();

    public static class Message {
        public String defaultMessage = "type --help for the list of sub commands";
    }

    private Message message = new Message();

    public CommandModuleBase() {

    }

    public void addModule(CommandModule module) {
        if (commandList.findBy(module.name()) != null) {
            _logger.warn("duplicate module (or command) name found: " + module.name());
        }
        commandList.add(module.name(), module);

    }

    public void addCommand(Class< ? > commandClass) {
        if (Modifier.isAbstract(commandClass.getModifiers())
                || !Command.class.isAssignableFrom(commandClass))
            return;

        try {
            // found a sub command class
            @SuppressWarnings("unchecked")
            Class<Command> cl = (Class<Command>) commandClass;
            Command subCommand = (Command) commandClass.newInstance();
            if (subCommand == null)
                return;

            if (commandList.findBy(subCommand.name()) != null) {
                _logger.warn("duplicate command found: " + subCommand.name());
            }
            commandList.add(subCommand.name(), subCommand);
        }
        catch (InstantiationException e) {
            _logger.error(e);
        }
        catch (IllegalAccessException e) {
            _logger.error(e);
        }
    }

    public void addCommandsIn(String packageName, boolean recursive) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        List<VirtualFile> classFileList = FileResource.listResources(packageName,
                new ResourceFilter() {
                    public boolean accept(String resourcePath) {
                        return resourcePath.endsWith(".class");
                    }
                });

        LinkedHashSet<String> subPackagePath = new LinkedHashSet<String>();
        for (VirtualFile vf : classFileList) {
            String logicalPath = vf.getLogicalPath();
            int dot = logicalPath.lastIndexOf(".");
            if (dot <= 0)
                continue;

            if (!recursive && logicalPath.contains("/")) {
                continue;
            }

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

    @Override
    public Object getOptionHolder() {
        return null;
    }

    public static class GlobalOption {
        @Argument(index = 0)
        public String command;
        @Option(symbol = "h", longName = "help", description = "display help messages")
        public boolean displayHelp = false;
    }

    private GlobalOption globalOption;
    private OptionParser globalOptionParser;

    public void printDefaultMessage() {
        System.out.println(message.defaultMessage);
    }

    public void printUsage() throws Exception {

        if (globalOption == null) {
            globalOption = new GlobalOption();
            globalOptionParser = new OptionParser(globalOption);
        }

        if (globalOption.command == null) {
            // display the help message of the global options
            globalOptionParser.printUsage();
            // list all sub commands
            System.out.println("[sub commands]");
            for (String subCommandName : commandList.keySet()) {
                Command c = commandList.get(subCommandName);
                System.out.format("  %-15s\t%s", subCommandName, c.getOneLineDescription());
                System.out.println();
            }
            return;
        }
        else {
            Command subCommand = getSubCommand(globalOption.command);
            OptionParser subOpt = new OptionParser(subCommand.getOptionHolder());
            if (CommandModule.class.isAssignableFrom(subCommand.getClass())) {
                // when the sub command is a module, delegate the help message processing to it  
                String[] unusedArguments = globalOptionParser.getUnusedArguments();
                subOpt.parse(unusedArguments);
                CommandModule module = CommandModule.class.cast(subCommand);
                module.printUsage();
            }
            else {
                subOpt.printUsage();
            }
        }
    }

    public Command getSubCommand(String name) throws Exception {
        // search for sub command
        Command subCommand = commandList.findBy(globalOption.command);
        if (subCommand == null)
            throw new OptionParserException(XerialErrorCode.UNKNOWN_COMMAND, String.format(
                    "unkown command %s", globalOption.command));

        return subCommand.getClass().newInstance();
    }

    public void execute(String[] args) throws Exception {
        // Create a new instance of the option holder for each call 
        globalOption = new GlobalOption();
        globalOptionParser = new OptionParser(globalOption);
        globalOptionParser.setIgnoreUnknownOption(true);

        try {
            globalOptionParser.parse(args);

            if (globalOption.displayHelp) {
                printUsage();
                return;
            }

            if (globalOption.command == null) {
                printDefaultMessage();
                return;
            }

            // search for sub command
            Command subCommand = getSubCommand(globalOption.command);
            OptionParser subOpt = new OptionParser(subCommand.getOptionHolder());
            String[] unusedArguments = globalOptionParser.getUnusedArguments();
            subOpt.parse(unusedArguments);
            subCommand.execute(unusedArguments);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String getOneLineDescription() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

}
