/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// AdjacencyList.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.xerial.util.CollectionUtil;
import org.xerial.util.StringUtil;

/**
 * AdjacencyList is a directed graph in which node IDs and edge IDs are
 * automatically assigned to for each node and edge.
 * 
 * @author leo
 * 
 */
public class AdjacencyList<NodeLabel, EdgeLabel> implements Graph<NodeLabel, EdgeLabel>
{
    NodeTable<NodeLabel> _nodeTable = new NodeTable<NodeLabel>();

    EdgeTable<EdgeLabel> _edgeTable = new EdgeTable<EdgeLabel>();

    public AdjacencyList()
    {

    }

    /**
     * @param node
     * @return
     * @deprecated use {@link #addNode(Object)} instead
     */
    public int add(NodeLabel node)
    {
        return addNode(node);
    }

    public int addNode(NodeLabel node)
    {
        int nodeID = _nodeTable.getNodeID(node);
        if (nodeID == -1)
            nodeID = _nodeTable.add(node);
        return nodeID;
    }

    public Edge addEdge(NodeLabel sourceNode, NodeLabel destNode)
    {
        return addEdge(sourceNode, destNode, null);
    }

    public Edge addEdge(NodeLabel sourceNode, NodeLabel destNode, EdgeLabel edgeLabel)
    {
        addNode(sourceNode);
        addNode(destNode);

        int sourceNodeID = _nodeTable.getNodeID(sourceNode);
        int destNodeID = _nodeTable.getNodeID(destNode);

        Edge newEdge = new Edge(sourceNodeID, destNodeID);
        _edgeTable.add(newEdge, edgeLabel);
        return newEdge;
    }

    public Edge addEdge(Edge edge, EdgeLabel edgeLabel)
    {
        if (!_nodeTable.containsKey(edge.srcNodeID))
            throw new IllegalArgumentException("no node id is found: " + edge.srcNodeID);
        if (!_nodeTable.containsKey(edge.destNodeID))
            throw new IllegalArgumentException("no node id is found: " + edge.destNodeID);

        _edgeTable.add(edge, edgeLabel);

        return edge;
    }

    public Edge addEdge(int sourceNodeID, int destNodeID, EdgeLabel edgeLabel)
    {
        return addEdge(new Edge(sourceNodeID, destNodeID), edgeLabel);
    }

    public Collection<NodeLabel> getNodeLabels()
    {
        return _nodeTable.values();
    }

    public Collection<Integer> getNodeIDSet()
    {
        return _nodeTable.keySet();
    }

    public Collection<Integer> getDestNodeIDSetOf(int nodeID)
    {
        return _edgeTable.destNodeIDSet(nodeID);
    }

    public Collection<Integer> getSourceNodeIDSetOf(int nodeID)
    {
        return _edgeTable.sourceNodeIDSet(nodeID);
    }

    public int getNodeID(NodeLabel node)
    {
        return _nodeTable.getNodeID(node);
    }

    public NodeLabel getNodeLabel(int nodeID)
    {
        return _nodeTable.get(nodeID);
    }

    public Collection<Edge> getOutEdges(NodeLabel node)
    {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        int sourceNodeID = getNodeID(node);
        for (Integer destNodeID : _edgeTable.destNodeIDSet(sourceNodeID))
        {
            edgeList.add(new Edge(sourceNodeID, destNodeID));
        }
        return edgeList;
    }

    public List<NodeLabel> outNodeList(NodeLabel node)
    {
        ArrayList<NodeLabel> outNodeList = new ArrayList<NodeLabel>();
        int sourceNodeID = getNodeID(node);
        for (Integer destNodeID : _edgeTable.destNodeIDSet(sourceNodeID))
        {
            outNodeList.add(getNodeLabel(destNodeID));
        }
        return outNodeList;
    }

    public Collection<Edge> getInEdges(NodeLabel node)
    {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        int nodeID = getNodeID(node);
        for (Integer sourceNodeID : _edgeTable.sourceNodeIDSet(nodeID))
        {
            edgeList.add(new Edge(sourceNodeID, nodeID));
        }
        return edgeList;
    }

    public boolean hasNode(NodeLabel node)
    {
        return _nodeTable.containsValue(node);
    }

    public boolean hasEdge(NodeLabel src, NodeLabel dest)
    {
        Edge edge = new Edge(getNodeID(src), getNodeID(dest));
        return hasEdge(edge);
    }

    public boolean hasEdge(Edge e)
    {
        return _edgeTable.hasEdge(e);
    }

    public void clear()
    {
        _nodeTable.clear();
        _edgeTable.clear();
    }

    public int getNumNodes()
    {
        return _nodeTable.size();
    }

    public Collection<Edge> getEdges()
    {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int nodeID : getNodeIDSet())
        {
            for (Edge edge : getOutEdges(getNodeLabel(nodeID)))
            {
                edgeList.add(edge);
            }
        }

        return edgeList;
    }

    public int getEdgeID(Edge edge)
    {
        return _edgeTable.getEdgeID(edge);
    }

    public EdgeLabel getEdgeLabel(Edge edge)
    {
        return _edgeTable.getEdgeLabel(edge);
    }

    public EdgeLabel getEdgeLabel(NodeLabel src, NodeLabel dest)
    {
        return _edgeTable.getEdgeLabel(new Edge(getNodeID(src), getNodeID(dest)));
    }

    /**
     * @param edge
     * @return
     * @deprecated use {@link #getEdge(Edge)} instead
     */
    public EdgeLabel getEdgeInfo(Edge edge)
    {
        return getEdgeLabel(edge);
    }

    /**
     * @param src
     * @param dest
     * @return
     * @deprecated use {@link #getEdge(Object, Object)} instead
     */
    public EdgeLabel getEdgeInfo(NodeLabel src, NodeLabel dest)
    {
        return getEdgeLabel(src, dest);
    }

    public void setNodeLabel(int nodeID, NodeLabel node)
    {
        _nodeTable.add(nodeID, node);
    }

    public void setEdgeLabel(Edge edge, EdgeLabel edgeLabel)
    {
        _edgeTable.setEdge(edge, edgeLabel);
    }

    public String toString()
    {
        String nodeData = CollectionUtil.displayMap(_nodeTable, ":", ", ");

        ArrayList<String> edgeData = new ArrayList<String>();
        for (Edge e : getEdges())
        {
            EdgeLabel edgeInfo = getEdgeLabel(e);
            edgeData.add(e.toString() + ":" + (edgeInfo != null ? edgeInfo.toString() : ""));
        }
        return "node: " + nodeData + "\n" + StringUtil.join(edgeData, "\n");
    }

}

class NodeTable<NodeType> extends TreeMap<Integer, NodeType>
{
    private static final long serialVersionUID = 1L;

    private int _numNode = 0;

    private HashMap<NodeType, Integer> _nodeIDIndex = new HashMap<NodeType, Integer>();

    public int getNodeID(NodeType node)
    {
        Integer nodeID = _nodeIDIndex.get(node);
        return (nodeID == null) ? -1 : nodeID;
    }

    public int add(int nodeID, NodeType node)
    {
        super.put(nodeID, node);
        if (nodeID > _numNode)
            _numNode = nodeID;
        _nodeIDIndex.put(node, nodeID);
        _numNode++;
        return nodeID;
    }

    public int add(NodeType node)
    {
        int newNodeID = _numNode + 1;
        super.put(newNodeID, node);
        _nodeIDIndex.put(node, newNodeID);
        ++_numNode;
        return newNodeID;
    }

    public void clear()
    {
        _numNode = 0;
        super.clear();
        _nodeIDIndex.clear();
    }

}

class EdgeTable<EdgeLabel>
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    TreeMap<Integer, EdgeLabel> _edgeTable = new TreeMap<Integer, EdgeLabel>();
    TreeMap<Edge, Integer> _edgeIndex = new TreeMap<Edge, Integer>();
    HashMap<Integer, TreeSet<Integer>> _outNodeListOfEachNode = new HashMap<Integer, TreeSet<Integer>>();
    HashMap<Integer, TreeSet<Integer>> _inNodeListOfEachNode = new HashMap<Integer, TreeSet<Integer>>();

    protected int add(int newEdgeID, EdgeLabel edgeLabel, Edge newEdge)
    {
        Set<Integer> destNodeListOfSourceNode = destNodeIDSet(newEdge.srcNodeID);
        Set<Integer> sourceNodeListdOfDestinationNode = sourceNodeIDSet(newEdge.destNodeID);

        destNodeListOfSourceNode.add(newEdge.destNodeID);
        sourceNodeListdOfDestinationNode.add(newEdge.srcNodeID);
        _edgeIndex.put(newEdge, newEdgeID);
        _edgeTable.put(newEdgeID, edgeLabel);

        return newEdgeID;
    }

    public int add(Edge edge, EdgeLabel edgeLabel)
    {
        if (hasEdge(edge))
            return getEdgeID(edge);

        int newEdgeID = _edgeIndex.size() + 1;
        return add(newEdgeID, edgeLabel, edge);
    }

    public void setEdge(Edge edge, EdgeLabel edgeLabel)
    {
        if (!hasEdge(edge))
        {
            add(edge, edgeLabel);
            return;
        }

        int edgeID = getEdgeID(edge);
        _edgeTable.put(edgeID, edgeLabel);
    }

    public boolean hasEdge(Edge edge)
    {
        return destNodeIDSet(edge.srcNodeID).contains(edge.destNodeID);
    }

    public EdgeLabel getEdgeLabel(int edgeID)
    {
        return _edgeTable.get(edgeID);
    }

    public EdgeLabel getEdgeLabel(Edge edge)
    {
        return getEdgeLabel(getEdgeID(edge));
    }

    public int getEdgeID(Edge e)
    {
        Integer edgeID = _edgeIndex.get(e);
        if (edgeID == null)
            throw new NoSuchElementException(String.format("edge %s not found", e));
        else
            return edgeID;
    }

    public Set<Integer> destNodeIDSet(int sourceNodeID)
    {
        TreeSet<Integer> destNodeIDSet = _outNodeListOfEachNode.get(sourceNodeID);
        if (destNodeIDSet == null)
        {
            TreeSet<Integer> newNodeIDSet = new TreeSet<Integer>();
            _outNodeListOfEachNode.put(sourceNodeID, newNodeIDSet);
            return newNodeIDSet;
        }
        else
            return destNodeIDSet;
    }

    public Set<Integer> sourceNodeIDSet(int destNodeID)
    {
        TreeSet<Integer> destNodeIDSet = _inNodeListOfEachNode.get(destNodeID);
        if (destNodeIDSet == null)
        {
            TreeSet<Integer> newNodeIDSet = new TreeSet<Integer>();
            _inNodeListOfEachNode.put(destNodeID, newNodeIDSet);
            return newNodeIDSet;
        }
        else
            return destNodeIDSet;
    }

    public void clear()
    {
        _edgeTable.clear();
        _edgeIndex.clear();

        _outNodeListOfEachNode.clear();
        _inNodeListOfEachNode.clear();
    }

}
