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
public class SilkNode
{
    private String indent;
    private String name;
    private SiklNodeOccurrence occurrence;
    private ArrayList<SilkNode> childNodeList = new ArrayList<SilkNode>();

    public String getNodeIndent()
    {
        return indent;
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

    public SiklNodeOccurrence getOccurrence()
    {
        return occurrence;
    }

    public void setOccurrence(SiklNodeOccurrence occurrence)
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

}
