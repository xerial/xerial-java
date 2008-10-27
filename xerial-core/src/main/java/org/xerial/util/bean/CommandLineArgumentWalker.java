/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// CommandLineArgumentWalker.java
// Since: Oct 27, 2008 11:14:30 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import org.xerial.core.XerialException;

/**
 * 
 * 
 * @author leo
 * 
 */
public class CommandLineArgumentWalker implements TreeWalker
{
    private final String[] args;
    private int index = 0;

    public CommandLineArgumentWalker(String[] args)
    {
        this.args = args;
    }

    public TreeNode getSubTree() throws XerialException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void skipDescendants()
    {
    // TODO Auto-generated method stub

    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        index = 0;

        for (; index < args.length; index++)
        {
            String currentArg = args[index];
            if (currentArg.startsWith("-"))
            {

            }

        }

    }

}
