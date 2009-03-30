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
// TreeNodeImpl.java
// Since: 2009/03/30 23:09:43
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree.impl;

import java.util.ArrayList;
import java.util.List;

import org.xerial.util.tree.TreeNode;

public class TreeNodeImpl implements TreeNode
{
    String nodeName = null;
    String nodeValue = null;
    List<TreeNode> childNodes = new ArrayList<TreeNode>();

    public TreeNodeImpl(String nodeName, String nodeValue)
    {
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
    }

    public TreeNodeImpl addNode(TreeNodeImpl node)
    {
        childNodes.add(node);
        return node;
    }

    public List<TreeNode> getChildren()
    {
        return childNodes;
    }

    public String getNodeName()
    {
        return nodeName;
    }

    public String getNodeValue()
    {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue)
    {
        this.nodeValue = nodeValue;
    }

    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        buf.append(nodeName);
        if (nodeValue != null)
        {
            buf.append(":");
            buf.append(nodeValue);
        }
        if (!childNodes.isEmpty())
        {
            buf.append("(");
            int index = 0;
            for (TreeNode each : childNodes)
            {
                if (index != 0)
                    buf.append(", ");
                buf.append(each);
                index++;
            }
            buf.append(")");
        }

        return buf.toString();
    }

}
