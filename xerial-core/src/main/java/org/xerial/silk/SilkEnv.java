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
// SilkEnv.java
// Since: Feb 9, 2009 5:43:18 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * Environment variable holder for evaluating Silk functions.
 * 
 * @author leo
 * 
 */
public interface SilkEnv
{
    public TreeWalker getTreeWalker();

    public TreeVisitor getTreeVisitor();

    public Logger getLogger();

    /**
     * Get the baseline indentation level
     * 
     * @return the baseline indentation
     */
    public int getIndentationLevel();
}
