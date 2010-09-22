/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// Convert.java
// Since: Sep 22, 2010 11:27:53 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

public class Convert implements SilkWeaverCommand {

    @Override
    public String getCommandName() {
        return "convert";
    }

    @Override
    public String getOneLineDescription() {
        return "convert Silk data into a binary format";
    }

    @Override
    public int execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {

        return ReturnCode.SUCCESS.toInt();
    }

}
