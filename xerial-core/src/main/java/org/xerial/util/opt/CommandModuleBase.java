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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.xerial.core.XerialErrorCode;
import org.xerial.util.FileResource;
import org.xerial.util.PrefixTree;
import org.xerial.util.ResourceFilter;
import org.xerial.util.io.VirtualFile;
import org.xerial.util.log.Logger;

/**
 * A set of commands. To create your own module, extend this class and use
 * {@link #addCommand(Class)}, {@link #addCommandsIn(String, boolean)} methods
 * in the constructor to add commands in the module.
 * 
 * <code>
 * <pre>
 * class MyModule extends CommandModuleBase {
 *    public MyModule() { addCommand(Hello.class); }
 *    public String name() { return "mymodule"; }
 *    public String getOneLineDescription() { return "My Module. e.g. mymodule hello"; }
 * }
 * </pre>
 * </code>
 * 
 * @author leo
 * 
 */
public class CommandModuleBase implements CommandModule {

    private static Logger _logger = Logger.getLogger(CommandModuleBase.class);
    private PrefixTree<Command> commandList = new PrefixTree<Command>();
    private List<CommandLauncherEventHandler> eventHandlers = new ArrayList<CommandLauncherEventHandler>();

    private CommandHelpMessage message = new CommandHelpMessage();

    public CommandModuleBase() {

    }

    public void addEventHandler(CommandLauncherEventHandler handler) {
        this.eventHandlers.add(handler);
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
        return globalOption;
    }

    private GlobalCommandOption globalOption = new GlobalCommandOption();

    public void printDefaultMessage() {
        System.out.println(message.defaultHeader);
        System.out.println(message.defaultMessage);
    }

    @Override
    public URL getHelpMessageResource() {
        return null;
    }

    public static void printHelpMessage(URL helpFile) {

        if (helpFile == null)
            return;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(helpFile.openStream()));
            try {
                for (String line; (line = in.readLine()) != null;) {
                    System.out.println(line);
                }
            }
            finally {
                if (in != null)
                    in.close();
            }
        }
        catch (IOException e) {
            _logger.error("help file is not found: " + helpFile);
        }

    }

    public void printUsage() throws Exception {

        OptionParser globalOptionParser = new OptionParser(getOptionHolder());
        if (globalOption.command == null) {

            printHelpMessage(getHelpMessageResource());
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
                printHelpMessage(subCommand.getHelpMessageResource());
                subOpt.printUsage();
            }
        }
    }

    public Set<String> getCommandNameSet() {
        return commandList.keySet();
    }

    public Command getSubCommand(String name) throws Exception {
        // search for sub command
        Command subCommand = commandList.findBy(globalOption.command);
        if (subCommand == null)
            throw new OptionParserException(XerialErrorCode.UNKNOWN_COMMAND, String.format(
                    "unkown command %s", globalOption.command));

        return subCommand.getClass().newInstance();
    }

    private void resetOption() {
        globalOption.command = null;
        globalOption.displayHelp = false;
    }

    public void execute(String[] args) throws Exception {
        // reset the option
        resetOption();
        OptionParser globalOptionParser = new OptionParser(getOptionHolder());
        globalOptionParser.setIgnoreUnknownOption(true);

        try {
            globalOptionParser.parse(args);

            for (CommandLauncherEventHandler each : eventHandlers) {
                each.afterReadingGlobalOptions(globalOption);
            }

            if (globalOption.displayHelp) {
                printUsage();
                return;
            }

            if (globalOption.command == null) {
                printDefaultMessage();
                return;
            }

            String[] unusedArguments = globalOptionParser.getUnusedArguments();
            // search for sub command
            Command subCommand = getSubCommand(globalOption.command);
            if (CommandModule.class.isInstance(subCommand) || subCommand.getOptionHolder() == null) {
                subCommand.execute(unusedArguments);
            }
            else {
                OptionParser subOpt = new OptionParser(subCommand.getOptionHolder());
                subOpt.parse(unusedArguments);
                subCommand.execute(unusedArguments);
            }
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

    public void setMessage(CommandHelpMessage message) {
        this.message = message;
    }

    public void setOptionHolder(GlobalCommandOption opt) {
        this.globalOption = opt;
    }

}
