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
// Graph.java
// Since: Oct 22, 2008 4:09:48 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.Collection;

/**
 * A common interface for the graph structured data You can attach a node label
 * for each node, and edge label for each node
 * 
 * 
 * @author leo
 * 
 * @param <NodeLabel>
 * @param <EdgeLabel>
 */
public interface Graph<NodeLabel, EdgeLabel>
{
    /**
     * Add a new node
     * 
     * @param node
     * @return the node ID of the new node
     */
    int addNode(NodeLabel node);

    /**
     * Add a new edge
     * 
     * @param sourceNode
     * @param destNode
     * @param edge
     *            associated data to the edge
     * @return the newly added edge
     */
    Edge addEdge(NodeLabel sourceNode, NodeLabel destNode, EdgeLabel edgeLabel);

    Edge addEdge(NodeLabel sourceNode, NodeLabel destNode);

    Edge addEdge(Edge fromSourceNodeIDToDestNodeID, EdgeLabel edgeLabel);

    boolean hasNode(NodeLabel node);

    boolean hasEdge(NodeLabel src, NodeLabel dest);

    boolean hasEdge(Edge edge);

    NodeLabel getNodeLabel(int nodeID);

    EdgeLabel getEdgeLabel(Edge edge);

    EdgeLabel getEdgeLabel(int edgeID);

    int getNodeID(NodeLabel nodeLabel);

    int getEdgeID(Edge edge);

    Collection<Integer> getNodeIDSet();

    Collection<Integer> getEdgeIDSet();

    void setNodeLabel(int nodeID, NodeLabel nodeLabel);

    void setEdgeLabel(Edge edge, EdgeLabel edgeLabel);

    Collection<NodeLabel> getNodeLabelSet();

    Collection<Edge> getOutEdgeSet(NodeLabel node);

    Collection<Edge> getInEdgeSet(NodeLabel node);

    Collection<Edge> getEdgeSet();

    Collection<Integer> getDestNodeIDSetOf(int nodeID);

    Collection<Integer> getSourceNodeIDSetOf(int nodeID);

    void clear();

    int getNumNodes();

    String toGraphViz();
}
