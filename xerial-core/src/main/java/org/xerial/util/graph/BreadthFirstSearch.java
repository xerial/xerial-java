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
 * @param <NodeLabel>
 * @param <EdgeLabel>
 */
public abstract class BreadthFirstSearch<NodeLabel, EdgeLabel>
{
    enum NodeColor {
        WHITE, GRAY, BLACK
    }

    private Graph<NodeLabel, EdgeLabel> _graph;
    private HashMap<NodeLabel, NodeColor> _nodeColor = new HashMap<NodeLabel, NodeColor>();
    private HashMap<NodeLabel, NodeLabel> _predecessor = new HashMap<NodeLabel, NodeLabel>();
    private int _time;
    private HashMap<NodeLabel, Integer> _depth = new HashMap<NodeLabel, Integer>();
    //private HashMap<NodeType, Integer> _finishTime = new HashMap<NodeType, Integer>();
    private Stack<NodeLabel> nodeStack = new Stack<NodeLabel>();

    public void run(Graph<NodeLabel, EdgeLabel> graph)
    {
        run(graph, null);
    }

    public void run(Graph<NodeLabel, EdgeLabel> graph, NodeLabel startNode)
    {
        this._graph = graph;
        nodeStack.clear();

        for (NodeLabel eachNode : _graph.getNodeLabelSet())
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
        for (NodeLabel node : _graph.getNodeLabelSet())
        {
            searchStart(node);
        }

    }

    private void searchStart(NodeLabel node)
    {
        NodeColor color = _nodeColor.get(node);
        assert (color != null);

        // skip already traversed nodes
        if (color != NodeColor.WHITE)
            return;

        this.startNode(node);
        bfsVisit(node);
    }

    private void bfsVisit(NodeLabel node)
    {
        nodeStack.add(node);
        this.discoverNode(node);
        _nodeColor.put(node, NodeColor.GRAY);
        _depth.put(node, 0);

        while (!nodeStack.isEmpty())
        {
            NodeLabel cursorNode = nodeStack.pop();
            this.examineNode(cursorNode);

            for (Edge edge : _graph.getOutEdgeSet(cursorNode))
            {
                this.examineEdge(edge);

                NodeLabel nextNode = _graph.getNodeLabel(edge.getDestNodeID());
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

    protected final Graph<NodeLabel, EdgeLabel> getGraph()
    {
        return _graph;
    }

    // utilty methods
    protected NodeLabel getPredecessor(NodeLabel node)
    {
        return _predecessor.get(node);
    }

    protected int getSearchDepth(NodeLabel node)
    {
        return _depth.get(node);
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
     * Invoked before the search starts
     * 
     * @param node
     */
    protected abstract void initializeNode(NodeLabel node);

    /**
     * Invoked when the search starts from this node
     * 
     * @param node
     */
    protected abstract void startNode(NodeLabel node);

    /**
     * Invoked when this node is discovered.
     * 
     * @param node
     */
    protected abstract void discoverNode(NodeLabel node);

    /**
     * Invoked when the node becomes the travasal target
     * 
     * @param node
     */
    protected abstract void examineNode(NodeLabel node);

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
    protected abstract void finishNode(NodeLabel node);

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
