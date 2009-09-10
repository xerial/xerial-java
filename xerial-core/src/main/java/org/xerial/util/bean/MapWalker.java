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
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.xerial.core.XerialErrorCode;
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
    private final Map< ? , ? > map;

    public MapWalker(Map< ? , ? > map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    static class SingleTreeNode implements TreeNode
    {
        private final String nodeName;
        private final String nodeValue;

        public SingleTreeNode(String nodeName, String nodeValue) {
            this.nodeName = nodeName;
            this.nodeValue = nodeValue;
        }

        public List<TreeNode> getChildren() {
            return new ArrayList<TreeNode>();
        }

        public String getNodeName() {
            return nodeName;
        }

        public String getNodeValue() {
            return nodeValue;
        }

    }

    public TreeNode getSubTree() throws XerialException {
        if (currentKey != null) {
            Object value = map.get(currentKey);
            return new SingleTreeNode(currentKey.toString(), value != null ? value.toString() : null);
        }
        else
            throw new XerialException(XerialErrorCode.NoMoreSubtree);
    }

    public void skipDescendants() throws XerialException {
    // there is nothing to do
    }

    private Object currentKey;

    public void walk(TreeVisitor visitor) throws XerialException {
        visitor.init(this);
        walk(null, map, visitor);
        visitor.finish(this);
    }

    private void walk(String nodeName, Object value, TreeVisitor visitor) throws XerialException {
        if (value == null) {
            visitor.visitNode(nodeName, null, this);
            visitor.leaveNode(nodeName, this);
            return;
        }

        assert value != null;

        Class< ? > valueType = value.getClass();
        if (TypeInfo.isArray(valueType)) {
            for (Object each : (Object[]) value) {
                walk(nodeName, each, visitor);
            }
        }
        else if (TypeInfo.isCollection(valueType)) {
            for (Object each : (Collection< ? >) value) {
                walk(nodeName, each, visitor);
            }
        }
        else if (TypeInfo.isMap(valueType)) {
            visitor.visitNode(nodeName, null, this);
            Map< ? , ? > mapValue = (Map< ? , ? >) value;
            for (Object key : mapValue.keySet()) {
                currentKey = key;
                String entryName = key.toString();
                Object entryValue = map.get(key);
                walk(entryName, entryValue, visitor);
            }
            visitor.leaveNode(nodeName, this);
        }
        else {
            visitor.visitNode(nodeName, value.toString(), this);
            visitor.leaveNode(nodeName, this);
        }

    }

}
