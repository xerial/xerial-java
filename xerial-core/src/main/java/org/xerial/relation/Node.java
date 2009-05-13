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
// Node.java
// Since: 2009/05/13 9:18:34
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * Node is an element ({@link Cell}) of a relation.
 * 
 * @author leo
 * 
 */
public class Node implements Cell
{
    public static final int INVALID_ID = -1;
    public static final String NULL_TEXT = null;

    public final int nodeID;
    public final String nodeName;
    public final String nodeValue;

    private Node(String nodeName, int nodeID, String nodeValue)
    {
        this.nodeID = nodeID;
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
    }

    /**
     * Builder class for {@link Node}
     * 
     * @author leo
     * 
     */
    public static class NodeBuilder
    {
        private int nodeID = INVALID_ID;
        private String nodeValue = NULL_TEXT;
        private final String nodeName;

        public NodeBuilder(String nodeName)
        {
            this.nodeName = nodeName;
        }

        public NodeBuilder(Node node)
        {
            this.nodeID = node.nodeID;
            this.nodeName = node.nodeName;
            this.nodeValue = node.nodeValue;
        }

        public NodeBuilder nodeID(int nodeID)
        {
            this.nodeID = nodeID;
            return this;
        }

        public NodeBuilder nodeValue(String nodeValue)
        {
            this.nodeValue = nodeValue;
            return this;
        }

        public Node build()
        {
            return new Node(nodeName, nodeID, nodeValue);
        }

    }

    public boolean isAtom()
    {
        return true;
    }

    public boolean isTuple()
    {
        return false;
    }

    public static Node newNode(String nodeName, int nodeID)
    {
        return new Node(nodeName, nodeID, null);
    }

    public static Node newNodeWithValue(String nodeName, int nodeID, String nodeValue)
    {
        return new Node(nodeName, nodeID, nodeValue);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s(%d)", nodeName, nodeID));
        if (nodeValue != null)
        {
            builder.append("=\"");
            builder.append(nodeValue);
            builder.append("\"");
        }
        return builder.toString();
    }

    /**
     * Always return 1
     * 
     * @return
     */
    public int size()
    {
        return 1;
    }

    public void accept(CellVisitor visitor)
    {
        visitor.visitNode(this);
    }

    public Cell get(TupleIndex index)
    {
        if (index.size() == 0 && index.get(0) == 0)
            return this;
        else
            return null;
    }

    public Node getNode(TupleIndex index)
    {
        if (!(index.size() == 1 && index.get(0) == 0))
            throw new XerialError(XerialErrorCode.INVALID_STATE);
        else
            return this;
    }

    public Node getNode()
    {
        return this;
    }

    public Tuple getTuple()
    {
        throw new XerialError(XerialErrorCode.UNSUPPORTED);
    }

}
