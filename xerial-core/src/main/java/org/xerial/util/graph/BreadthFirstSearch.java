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
// BreadthFirstSearch.java
// Since: Oct 17, 2008 5:01:43 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author leo
 * 
 * @param <NodeType>
 * @param <EdgeType>
 */
public abstract class BreadthFirstSearch<NodeType, EdgeType>
{
    enum NodeColor {
        WHITE, GRAY, BLACK
    }

    private AdjacencyList<NodeType, EdgeType> _graph;
    private HashMap<NodeType, NodeColor> _nodeColor = new HashMap<NodeType, NodeColor>();
    private HashMap<NodeType, NodeType> _predecessor = new HashMap<NodeType, NodeType>();
    private int _time;
    private HashMap<NodeType, Integer> _depth = new HashMap<NodeType, Integer>();
    //private HashMap<NodeType, Integer> _finishTime = new HashMap<NodeType, Integer>();
    private Stack<NodeType> nodeStack = new Stack<NodeType>();

    public void run(AdjacencyList<NodeType, EdgeType> graph)
    {
        run(graph, null);
    }

    public void run(AdjacencyList<NodeType, EdgeType> graph, NodeType startNode)
    {
        this._graph = graph;
        nodeStack.clear();

        for (NodeType eachNode : _graph.nodeCollection())
        {
            initializeNode(eachNode);
            _nodeColor.put(eachNode, NodeColor.WHITE);
            _predecessor.put(eachNode, eachNode);
        }
        _time = 0;
        if (startNode != null)
        {
            searchStart(startNode);
        }
        for (NodeType node : _graph.nodeCollection())
        {
            searchStart(node);
        }

    }

    private void searchStart(NodeType node)
    {
        NodeColor color = _nodeColor.get(node);
        assert (color != null);

        // skip already traversed nodes
        if (color != NodeColor.WHITE)
            return;

        this.startNode(node);
        bfsVisit(node);
    }

    private void bfsVisit(NodeType node)
    {
        nodeStack.add(node);
        this.discoverNode(node);
        _nodeColor.put(node, NodeColor.GRAY);
        _depth.put(node, 0);

        while (!nodeStack.isEmpty())
        {
            NodeType cursorNode = nodeStack.pop();
            this.examineNode(cursorNode);

            for (Edge edge : _graph.outEdgeList(cursorNode))
            {
                this.examineEdge(edge);

                NodeType nextNode = _graph.getNode(edge.getDestNodeID());
                NodeColor nextNodeColor = _nodeColor.get(nextNode);
                assert (nextNodeColor != null);

                switch (nextNodeColor)
                {
                case WHITE:
                    this.treeEdge(edge);
                    _nodeColor.put(nextNode, NodeColor.GRAY);
                    _depth.put(nextNode, _depth.get(cursorNode) + 1);
                    _predecessor.put(nextNode, cursorNode);

                    nodeStack.add(nextNode);
                    this.discoverNode(nextNode);
                    break;
                case GRAY:
                    this.backEdge(edge);
                    break;
                case BLACK:
                    this.forwardOrCrossEdge(edge);
                    break;
                }

            }
            this.finishNode(cursorNode);
            _nodeColor.put(cursorNode, NodeColor.BLACK);

        }

    }

    /**
     * Invoked before the search starts
     * 
     * @param node
     */
    protected abstract void initializeNode(NodeType node);

    /**
     * Invoked when the search starts from this node
     * 
     * @param node
     */
    protected abstract void startNode(NodeType node);

    /**
     * Invoked when this node is discovered.
     * 
     * @param node
     */
    protected abstract void discoverNode(NodeType node);

    /**
     * Invoked when the node becomes the travasal target
     * 
     * @param node
     */
    protected abstract void examineNode(NodeType node);

    /**
     * Invoked when the edge is examined
     * 
     * @param edge
     */
    protected abstract void examineEdge(Edge edge);

    /**
     * Invoked when a new edge is found
     * 
     * @param edge
     */
    protected abstract void treeEdge(Edge edge);

    /**
     * Invoked when all edges beginning from this node are examined.
     * 
     * @param node
     */
    protected abstract void finishNode(NodeType node);

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
