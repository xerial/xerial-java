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
// CreateDB.java
// Since: 2009/07/22 16:17:02
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.bio.blast;

import org.xerial.weaver.core.cui.SilkWeaverCommand;
import org.xerial.weaver.core.cui.SilkWeaverModule;

/**
 * @author leo
 * 
 */
public class CreateDB implements SilkWeaverCommand {

    public void execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {
    // TODO Auto-generated method stub

    }

    public String getCommandName() {
        return "formatDB";
    }

    public String getOneLineDescription() {
        // TODO Auto-generated method stub
        return null;
    }

}
