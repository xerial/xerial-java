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
// HelloWorld.java
// Since: 2011/02/02 11:54:03
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt.samplemodule;

import org.xerial.util.opt.CommandBase;
import org.xerial.util.opt.Option;

public class Import extends CommandBase {

    @Option(symbol = "i", description = "input file")
    public String input = "-";

    @Override
    public String name() {
        return "import";
    }

    @Override
    public String getOneLineDescription() {
        return "import data file";
    }

    @Override
    public Object getOptionHolder() {
        return this;
    }

    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("importing " + input);
    }

}
