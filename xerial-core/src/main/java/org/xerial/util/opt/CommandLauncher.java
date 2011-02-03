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
// CommandLauncher.java
// Since: 2011/02/02 18:31:57
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import org.xerial.util.log.Logger;

/**
 * CUI-command launcher
 * 
 * @author leo
 * 
 */
public class CommandLauncher {

    private static Logger _logger = Logger.getLogger(CommandModuleBase.class);
    private CommandModuleBase globalModule = new CommandModuleBase();

    public void addCommand(Class< ? > commandClass) {
        globalModule.addCommand(commandClass);
    }

    public void addCommandsIn(Package p) {
        addCommandsIn(p, false);
    }

    public void addCommandsIn(String packageName) {
        addCommandsIn(packageName, false);
    }

    public void addCommandsIn(Package p, boolean recursive) {
        if (p == null)
            throw new NullPointerException("package is null");
        globalModule.addCommandsIn(p.getName(), recursive);
    }

    public void addCommandsIn(String packageName, boolean recursive) {
        if (packageName == null)
            throw new NullPointerException("package is null");
        globalModule.addCommandsIn(packageName, recursive);
    }

    public void addModule(CommandModule module) {
        globalModule.addModule(module);
    }

    public static class GlobalOption {
        @Argument(index = 0)
        public String command;
        @Option(symbol = "h", longName = "help", description = "display help messages")
        public boolean displayHelp = false;
    }

    public void execute(String[] args) throws Exception {
        globalModule.execute(args);

    }

}
