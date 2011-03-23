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
// CommandBase.java
// Since: 2011/03/22 17:50:18
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.net.URL;

/**
 * Base implementation of the {@link Command} interface
 * 
 * @author leo
 * 
 */
public abstract class CommandBase implements Command {

    @Override
    public Object getOptionHolder() {
        return this;
    }

    @Override
    public URL getHelpMessageResource() {
        return null;
    }

    @Override
    public void execute(GlobalCommandOption globalOption, String[] args) throws Exception {
        // ignore global options in default
        execute(args);
    }

}
