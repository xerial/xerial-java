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
package org.xerial.lens.relation;

/**
 * Node is an element ({@link Cell}) of a relation.
 * 
 * @author leo
 * 
 */
public class Node extends NodeBase<Node>
{
    public static final int INVALID_ID = -1;
    public static final String NULL_TEXT = null;

    public final long nodeID;
    public final String nodeName;
    public final String nodeValue;

    private Node(String nodeName, long nodeID, String nodeValue)
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
        private long nodeID = INVALID_ID;
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

        public NodeBuilder nodeID(long nodeID)
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

}
