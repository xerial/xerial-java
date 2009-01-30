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
// SilkLine.java
// Since: Jan 30, 2009 3:55:13 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

/**
 * 
 * SilkLine contents
 * 
 * @author leo
 * 
 */
public class SilkLine
{
    String nodeIndent;
    SilkNode node = null;
    SilkFunction function = null;

    public String getNodeIndent()
    {
        return nodeIndent;
    }

    public void setNodeIndent(String nodeIndent)
    {
        this.nodeIndent = nodeIndent;
    }

    public void setSilkNode(SilkNode node)
    {
        this.node = node;
    }

    public SilkNode getSilkNode()
    {
        return node;
    }

    public void setFunction(SilkFunction function)
    {
        this.function = function;
    }

    public SilkFunction getFunction()
    {
        return function;
    }

    public boolean hasFunction()
    {
        return function != null;
    }

    public boolean hasSilkNode()
    {
        return node != null;
    }

}