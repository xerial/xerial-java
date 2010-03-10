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
// XerialJ
//
// SilkFunctionPlugin.java
// Since: Feb 9, 2009 3:42:01 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.plugin;

import org.xerial.core.XerialException;
import org.xerial.lens.tree.TreeEventHandler;
import org.xerial.silk.SilkEnv;

/**
 * The common interface of pluggable functions that can be used in Silk format.
 * 
 * @author leo
 * 
 */
public interface SilkFunctionPlugin
{
    /**
     * @param env
     *            contains current context for parsing
     * @throws XerialException
     */
    public void init(SilkEnv env) throws XerialException;

    public void eval(SilkEnv env, TreeEventHandler handler) throws Exception;

}
