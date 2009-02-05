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
// SilkNode.java
// Since: Jan 30, 2009 6:58:59 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import java.util.ArrayList;

import org.xerial.util.StringUtil;

/**
 * SilkNode begins with '-' character, follwed by object notation of the form:
 * 
 * <pre>
 *  object_name (: nodeValue)? '(' attribute, ... ')' ([format_name])? ('*' | '&gt;' | '|')
 * </pre>
 * 
 * @author leo
 * 
 */
public class SilkNode implements SilkElement
{
    private String indent = null;
    private String name;
    private SilkValue value = null;

    private String dataType = null;
    private SilkNodeOccurrence occurrence = SilkNodeOccurrence.ONE;
    private ArrayList<SilkNode> childNodeList = new ArrayList<SilkNode>();

    public String getNodeIndent()
    {
        return indent;
    }

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

    public void setNodeIndent(String indent)
    {
        this.indent = indent;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean hasDataType()
    {
        return dataType != null;
    }

    public String getDataType()
    {
        return dataType;
    }

    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }

    public SilkNodeOccurrence getOccurrence()
    {
        return occurrence;
    }

    public void setOccurrence(SilkNodeOccurrence occurrence)
    {
        this.occurrence = occurrence;
    }

    public ArrayList<SilkNode> getChildNodes()
    {
        return childNodeList;
    }

    public void addSilkNode(SilkNode childNode)
    {
        this.childNodeList.add(childNode);
    }

    public void setValue(String text)
    {
        this.value = new SilkTextValue(text);
    }

    public void setJSON(String jsonText)
    {
        this.value = new SilkJSONValue(jsonText);
    }

    public void setFunction(SilkFunction func)
    {
        this.value = func;
    }

    public SilkValue getValue()
    {
        return value;
    }

    public boolean hasValue()
    {
        return value != null;
    }

    @Override
    public String toString()
    {
        String childNodeString = childNodeList.isEmpty() ? "" : String.format("(%s)", StringUtil.join(childNodeList,
                ", "));
        String nodeValue = value != null ? ":" + value.toString() : "";
        if (hasDataType())
            return String.format("%s[%s]<%s>%s%s", name, dataType, childNodeString, occurrence, nodeValue);
        else
            return String.format("%s%s<%s>%s", name, childNodeString, occurrence, nodeValue);
    }

}
