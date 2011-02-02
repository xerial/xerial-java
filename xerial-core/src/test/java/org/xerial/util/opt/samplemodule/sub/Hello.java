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
// Hello.java
// Since: 2011/02/02 11:51:20
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt.samplemodule.sub;

import org.xerial.util.opt.Command;

public class Hello implements Command {

    @Override
    public String name() {
        return "hello2";
    }

    @Override
    public String getOneLineDescription() {
        return "say hello";
    }

    @Override
    public Object getOptionHolder() {
        return this;
    }

    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("HELLO");
    }

}
