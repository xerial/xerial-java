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
// MapWalker.java
// Since: Jan 5, 2008 3:20:17 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xerial.core.XerialException;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * {@link TreeWalker} for map structured data
 * 
 * @author leo
 * 
 */
public class MapWalker implements TreeWalker
{
    private final Map map;

    public MapWalker(Map map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    static class SingleTreeNode implements TreeNode
    {
        private final String nodeName;
        private final String nodeValue;

        public SingleTreeNode(String nodeName, String nodeValue)
        {
            this.nodeName = nodeName;
            this.nodeValue = nodeValue;
        }

        public List<TreeNode> getChildren()
        {
            return new ArrayList<TreeNode>();
        }

        public String getNodeName()
        {
            return nodeName;
        }

        public String getNodeValue()
        {
            return nodeValue;
        }

    }

    public TreeNode getSubTree() throws XerialException
    {
        if (currentKey != null)
        {
            Object value = map.get(currentKey);
            return new SingleTreeNode(currentKey.toString(), value != null ? value.toString() : null);
        }
        else
            throw new BeanException(BeanErrorCode.NoMoreSubtree);
    }

    public void skipDescendants() throws XerialException
    {
    // there is nothing to do
    }

    private Object currentKey;

    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(this);
        // visit the imaginary root node
        visitor.visitNode("_root", null, this);

        for (Object key : map.keySet())
        {
            currentKey = key;
            String nodeName = key.toString();
            Object value = map.get(key);
            visitor.visitNode(nodeName, value != null ? value.toString() : null, this);
            visitor.leaveNode(nodeName, this);
        }
        // leave the imaginary root node
        visitor.leaveNode("_root", this);
        visitor.finish(this);
    }

}
