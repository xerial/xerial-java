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
// ElementList.java
// Since: Oct 30, 2008 4:13:55 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml.dtd;

import java.util.ArrayList;
import java.util.List;

public class ChildList
{
    private ArrayList<ChildNode> childList = new ArrayList<ChildNode>();
    private Occurence            occurence = Occurence.ONE;

    public void addChild(ChildNode child)
    {
        childList.add(child);
    }

    public List<ChildNode> getChildNodeList()
    {
        return childList;
    }

    public Occurence getOccurence()
    {
        return occurence;
    }

    public void setOccurence(Occurence occurence)
    {
        this.occurence = occurence;
    }

}
