/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XerialJ Project
//
// DFSVisitor.java
// Since: 2007/05/14
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.HashMap;

/**
 * Depth First Search Algorithm of the graph.
 * 
 * Reference:
 * http://www.boost.org/doc/libs/1_36_0/libs/graph/doc/DFSVisitor.html
 * 
 * <ol>
 * <li>initializeNode each node is colored WHITE
 * <li>startNode
 * <li>discoverNode the node is colored GRAY
 * <li>examinEdge
 * <li>treeEdge | backEdge | forwardOrCrossEdge (if the edge is a tree edge,
 * traverse to the edge)
 * <li>finishNode the node is colored BLACK
 * 
 * </ol>
 * 
 * 
 * @author leo
 * 
 */
public abstract class DepthFirstSearch<NodeType, EdgeType>
{
    enum NodeColor {
        WHITE, GRAY, BLACK
    }

    private AdjacencyList<NodeType, EdgeType> _graph;
    private HashMap<NodeType, NodeColor> _nodeColor = new HashMap<NodeType, NodeColor>();
    private HashMap<NodeType, NodeType> _predecessor = new HashMap<NodeType, NodeType>();
    private int _time;
    private HashMap<NodeType, Integer> _discoveryTime = new HashMap<NodeType, Integer>();
    private HashMap<NodeType, Integer> _finishTime = new HashMap<NodeType, Integer>();

    public DepthFirstSearch()
    {

    }

    public void run(AdjacencyList<NodeType, EdgeType> graph)
    {
        // start from the fist entry in the node collection of the graph
        run(graph, null);
    }

    public void run(AdjacencyList<NodeType, EdgeType> graph, NodeType startNode)
    {
        this._graph = graph;

        // initialize each node 
        for (NodeType eachNode : _graph.nodeCollection())
        {
            this.initializeNode(eachNode);

            _nodeColor.put(eachNode, NodeColor.WHITE);
            _predecessor.put(eachNode, eachNode);
        }
        _time = 0;
        if (startNode != null)
        {
            this.startNode(startNode);
            dfsVisit(startNode);
        }
        for (NodeType node : _graph.nodeCollection())
        {
            NodeColor color = _nodeColor.get(node);
            assert (color != null);
            if (color == NodeColor.WHITE)
            {
                this.startNode(node);
                dfsVisit(node);
            }
        }
    }

    private void dfsVisit(NodeType node)
    {
        this.discoverNode(node);
        _nodeColor.put(node, NodeColor.GRAY);
        _discoveryTime.put(node, _time++);
        for (Edge edge : _graph.outEdgeList(node))
        {
            this.examineEdge(edge);

            NodeType adjacentNode = _graph.getNode(edge.getDestNodeID());
            NodeColor color = _nodeColor.get(adjacentNode);
            assert (color != null);
            if (color == NodeColor.WHITE)
            {
                this.treeEdge(edge);

                _predecessor.put(adjacentNode, node);
                dfsVisit(adjacentNode);
            }
            else if (color == NodeColor.GRAY)
            {
                this.backEdge(edge);
            }
            else if (color == NodeColor.BLACK)
            {
                this.forwardOrCrossEdge(edge);
            }
        }

        this.finishNode(node);
        _nodeColor.put(node, NodeColor.BLACK);

        _finishTime.put(node, _time++);
    }

    // utilty methods
    protected NodeType getPredecessor(NodeType node)
    {
        return _predecessor.get(node);
    }

    protected int getDiscoveryTime(NodeType node)
    {
        return _discoveryTime.get(node);
    }

    protected int getFinishTime(NodeType node)
    {
        return _finishTime.get(node);
    }

    protected final AdjacencyList<NodeType, EdgeType> getGraph()
    {
        return _graph;
    }

    protected EdgeType getEdgeData(Edge edge)
    {
        return _graph.getEdge(edge);
    }

    protected NodeType getSourceNode(Edge edge)
    {
        return _graph.getNode(edge.getSourceNodeID());
    }

    protected NodeType getDestNode(Edge edge)
    {
        return _graph.getNode(edge.getDestNodeID());
    }

    public String toString(Edge edge)
    {
        return String.format("(%s,%s)", getGraph().getNode(edge.getSourceNodeID()).toString(), getGraph().getNode(
                edge.getDestNodeID()).toString());
    }

    /**
     * This method is invoked only once before the search starts.
     * 
     * @param node
     */
    protected abstract void initializeNode(NodeType node);

    /**
     * Invoked when the DFS search from this node begins.
     * 
     * @param node
     */
    protected abstract void startNode(NodeType node);

    /**
     * Invoked when a new node is found
     * 
     * @param node
     */
    protected abstract void discoverNode(NodeType node);

    /**
     * Invoked when the depth first search beginning from this node
     * 
     * @param node
     */
    protected abstract void finishNode(NodeType node);

    /**
     * Invoked when searching for edges to traverse
     * 
     * @param edge
     */
    protected abstract void examineEdge(Edge edge);

    /**
     * Invoked when traversing to a newly found node (WHITE)
     * 
     * @param edge
     */
    protected abstract void treeEdge(Edge edge);

    /**
     * Invoked when a node whose DFS search is in-progress (GRAY) is found.
     * 
     * @param edge
     */
    protected abstract void backEdge(Edge edge);

    /**
     * Invoked when an already finished node (BLACK) is found
     * 
     * @param edge
     */
    protected abstract void forwardOrCrossEdge(Edge edge);

}
