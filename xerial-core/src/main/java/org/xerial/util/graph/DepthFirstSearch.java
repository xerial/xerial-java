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
public abstract class DepthFirstSearch<NodeLabel, EdgeLabel>
{
    enum NodeColor {
        WHITE, GRAY, BLACK
    }

    private Graph<NodeLabel, EdgeLabel> _graph;
    private HashMap<NodeLabel, NodeColor> _nodeColor = new HashMap<NodeLabel, NodeColor>();
    private HashMap<NodeLabel, NodeLabel> _predecessor = new HashMap<NodeLabel, NodeLabel>();
    private int _time;
    private HashMap<NodeLabel, Integer> _discoveryTime = new HashMap<NodeLabel, Integer>();
    private HashMap<NodeLabel, Integer> _finishTime = new HashMap<NodeLabel, Integer>();

    public DepthFirstSearch()
    {

    }

    public void run(Graph<NodeLabel, EdgeLabel> graph)
    {
        // start from the fist entry in the node collection of the graph
        run(graph, null);
    }

    public void run(Graph<NodeLabel, EdgeLabel> graph, NodeLabel startNode)
    {
        this._graph = graph;

        // initialize each node 
        for (NodeLabel eachNode : _graph.getNodeLabelSet())
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
        for (NodeLabel node : _graph.getNodeLabelSet())
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

    private void dfsVisit(NodeLabel node)
    {
        this.discoverNode(node);
        _nodeColor.put(node, NodeColor.GRAY);
        _discoveryTime.put(node, _time++);
        for (Edge edge : _graph.getOutEdgeSet(node))
        {
            this.examineEdge(edge);

            NodeLabel adjacentNode = _graph.getNodeLabel(edge.getDestNodeID());
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
    protected NodeLabel getPredecessor(NodeLabel node)
    {
        return _predecessor.get(node);
    }

    protected int getDiscoveryTime(NodeLabel node)
    {
        return _discoveryTime.get(node);
    }

    protected int getFinishTime(NodeLabel node)
    {
        return _finishTime.get(node);
    }

    protected final Graph<NodeLabel, EdgeLabel> getGraph()
    {
        return _graph;
    }

    protected EdgeLabel getEdgeLabel(Edge edge)
    {
        return _graph.getEdgeLabel(edge);
    }

    protected NodeLabel getSourceNodeLabel(Edge edge)
    {
        return GraphHelper.getSourceNodeLabel(_graph, edge);
    }

    protected NodeLabel getDestNodeLabel(Edge edge)
    {
        return GraphHelper.getDestNodeLabel(_graph, edge);
    }

    protected String toString(Edge edge)
    {
        return GraphHelper.toString(_graph, edge);
    }

    /**
     * This method is invoked only once before the search starts.
     * 
     * @param node
     */
    protected abstract void initializeNode(NodeLabel node);

    /**
     * Invoked when the DFS search from this node begins.
     * 
     * @param node
     */
    protected abstract void startNode(NodeLabel node);

    /**
     * Invoked when a new node is found
     * 
     * @param node
     */
    protected abstract void discoverNode(NodeLabel node);

    /**
     * Invoked when the depth first search beginning from this node
     * 
     * @param node
     */
    protected abstract void finishNode(NodeLabel node);

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
