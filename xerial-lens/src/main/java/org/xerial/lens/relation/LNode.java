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
// LNode.java
// Since: May 14, 2009 11:36:59 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

/**
 * Light-weight node that holds only a node ID and node value.
 * 
 * @author leo
 * 
 */
public class LNode extends NodeBase<LNode>
{
    private final static long INVALID_ID = -1;
    private final static String NULL_TEXT = null;

    public final long nodeID;
    public final String nodeValue;

    public LNode(long nodeID, String nodeValue)
    {
        this.nodeID = nodeID;
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

        public NodeBuilder()
        {}

        public NodeBuilder(Node node)
        {
            this.nodeID = node.nodeID;
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

        public LNode build()
        {
            return new LNode(nodeID, nodeValue);
        }

    }

    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        buf.append(nodeID);
        if (nodeValue != null)
        {
            buf.append(":");
            buf.append(nodeValue);
        }
        return buf.toString();
    }

}
