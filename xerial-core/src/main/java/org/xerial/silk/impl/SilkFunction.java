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

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.StringUtil;

/**
 * function data
 * 
 * @author leo
 * 
 */
public class SilkFunction implements SilkElement, SilkValue
{
    private String name;
    private String indent;
    private ArrayList<SilkFunctionArg> argumentList = new ArrayList<SilkFunctionArg>();

    public final static int NO_INDENT = Integer.MAX_VALUE; // must be higher than other indent levels

    /**
     * Return the indent level (the length of the leadning white spaces) of this
     * node. If no indent is specified, return {@link SilkNode#NO_INDENT}.
     * 
     * @return the indent level of the node, or {@link SilkNode#NO_INDENT} if no
     *         indent is specified.
     */
    public int getIndentLevel()
    {
        if (indent == null)
            return NO_INDENT;
        else
            return indent.length() - 1;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void addArgument(String argument)
    {
        argumentList.add(SilkFunctionArg.newArgValue(argument));
    }

    public void addKeyValuePair(SilkFunctionArg argument)
    {
        argumentList.add(argument);
    }

    public void addKeyAndValue(String key, String value)
    {
        argumentList.add(new SilkFunctionArg(key, value));
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

    @Override
    public String toString()
    {
        return String.format("function %s(%s)", name, StringUtil.join(argumentList, ", "));
    }

    public String getValue()
    {
        throw new XerialError(XerialErrorCode.UNSUPPORTED, "getValue() for SilkFunction");
    }

    public boolean isJSON()
    {
        return false;
    }

    public boolean isFunction()
    {
        return true;
    }

}
