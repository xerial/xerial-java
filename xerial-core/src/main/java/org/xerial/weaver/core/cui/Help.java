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
// Help.java
// Since: 2009/07/22 11:27:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Usage;

/**
 * help command
 * 
 * @author leo
 * 
 */
@Usage(command = "help", description = "display help message of the specified command")
public class Help implements SilkWeaverCommand {

    @Argument(index = 0, required = false, name = "command")
    String targetCommand = null;

    public int execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {
        module.displayHelp(targetCommand);
        return ReturnCode.SUCCESS.toInt();
    }

    public String getCommandName() {
        return "help";
    }

    public String getOneLineDescription() {
        return "display help messages";
    }

}
