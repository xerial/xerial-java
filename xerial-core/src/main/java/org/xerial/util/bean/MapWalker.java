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

/**
 * {@link TreeWalker} for map structured data
 * 
 * @author leo
 * 
 */
public class MapWalker extends TreeWalker
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

    @Override
    public TreeNode getSubTree() throws BeanException
    {
        if (currentKey != null)
        {
            Object value = map.get(currentKey);
            return new SingleTreeNode(currentKey.toString(), value != null ? value.toString() : null);
        }
        else
            throw new BeanException(BeanErrorCode.NoMoreSubtree);
    }

    @Override
    public void skipDescendants()
    {
    // there is nothing to do
    }

    private Object currentKey;

    @Override
    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(this);
        // visit the imaginary root node
        visitor.visitNode("_root", this);

        for (Object key : map.keySet())
        {
            currentKey = key;
            String nodeName = key.toString();
            Object value = map.get(key);
            visitor.visitNode(nodeName, this);
            visitor.leaveNode(nodeName, value != null ? value.toString() : null, this);
        }
        // leave the imaginary root node
        visitor.leaveNode("_root", null, this);
        visitor.finish(this);
    }

}
