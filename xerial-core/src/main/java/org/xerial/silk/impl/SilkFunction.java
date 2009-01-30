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
// SilkFunction.java
// Since: Jan 30, 2009 7:36:19 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * function data
 * 
 * @author leo
 * 
 */
public class SilkFunction
{
    private String indent;
    private ArrayList<SilkFunctionArg> argumentList = new ArrayList<SilkFunctionArg>();

    public void addArgument(String argument)
    {
        argumentList.add(SilkFunctionArg.newArgValue(argument));
    }

    public void addKeyValuePair(SilkFunctionArg argument)
    {
        argumentList.add(argument);
    }

    public List<SilkFunctionArg> getArgumentList()
    {
        return argumentList;
    }

    public String getNodeIndent()
    {
        return indent;
    }

    public void setNodeIndent(String indent)
    {
        this.indent = indent;
    }

}
