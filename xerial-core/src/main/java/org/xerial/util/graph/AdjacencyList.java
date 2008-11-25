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

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.xerial.util.IndexedSet;
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
    IndexedSet<NodeLabel> _nodeTable = new IndexedSet<NodeLabel>();

    EdgeTable<EdgeLabel> _edgeTable = new EdgeTable<EdgeLabel>();

    public AdjacencyList()
    {

    }

    public int addNode(NodeLabel node)
    {
        int nodeID = _nodeTable.getIDwithAddition(node);
        return nodeID;
    }

    public Edge addEdge(NodeLabel sourceNode, NodeLabel destNode)
    {
        return addEdge(sourceNode, destNode, null);
    }

    public Edge addEdge(NodeLabel sourceNode, NodeLabel destNode, EdgeLabel edgeLabel)
    {
        int sourceNodeID = _nodeTable.getIDwithAddition(sourceNode);
        int destNodeID = _nodeTable.getIDwithAddition(destNode);

        Edge newEdge = new Edge(sourceNodeID, destNodeID);
        _edgeTable.add(newEdge, edgeLabel);
        return newEdge;
    }

    public Edge addEdge(Edge edge, EdgeLabel edgeLabel)
    {
        if (!_nodeTable.containsID(edge.srcNodeID))
            throw new IllegalArgumentException("no node id is found: " + edge.srcNodeID);
        if (!_nodeTable.containsID(edge.destNodeID))
            throw new IllegalArgumentException("no node id is found: " + edge.destNodeID);

        _edgeTable.add(edge, edgeLabel);

        return edge;
    }

    public Edge addEdge(int sourceNodeID, int destNodeID, EdgeLabel edgeLabel)
    {
        return addEdge(new Edge(sourceNodeID, destNodeID), edgeLabel);
    }

    public Collection<NodeLabel> getNodeLabelSet()
    {
        return _nodeTable;
    }

    public Collection<Integer> getNodeIDSet()
    {
        return _nodeTable.getIDSet();
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
        return _nodeTable.getID(node);
    }

    public NodeLabel getNodeLabel(int nodeID)
    {
        return _nodeTable.getByID(nodeID);
    }

    public Collection<Edge> getOutEdgeSet(NodeLabel node)
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

    public Collection<Edge> getInEdgeSet(NodeLabel node)
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
        return _nodeTable.contains(node);
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

    public Collection<Edge> getEdgeSet()
    {
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        Collection<Integer> nodeIDSet = getNodeIDSet();
        for (int nodeID : nodeIDSet)
        {
            for (Edge edge : getOutEdgeSet(getNodeLabel(nodeID)))
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

    public void setNodeLabel(int nodeID, NodeLabel node)
    {
        _nodeTable.set(nodeID, node);
    }

    public void setEdgeLabel(Edge edge, EdgeLabel edgeLabel)
    {
        _edgeTable.setEdge(edge, edgeLabel);
    }

    public String toString()
    {

        //        ArrayList<String> nodeList = new ArrayList<String>();
        //        for (NodeLabel node : _nodeTable)
        //        {
        //            nodeList.add(String.format("%s:%s", node.toString(), _nodeTable.getID(node)));
        //        }
        String nodeData = _nodeTable.toString();

        ArrayList<String> edgeData = new ArrayList<String>();
        for (Edge e : getEdgeSet())
        {
            EdgeLabel edgeInfo = getEdgeLabel(e);
            edgeData.add(String.format("(%s, %s)%s", getNodeLabel(e.getSourceNodeID()),
                    getNodeLabel(e.getDestNodeID()), (edgeInfo != null ? ":" + edgeInfo.toString() : "")));
        }
        return String.format("node (value, id):%s\nedge(node, node):\n%s", nodeData, StringUtil.join(edgeData, ",\n"));
    }

    public String toGraphViz()
    {
        StringWriter writer = new StringWriter();
        GraphvizHelper graphviz = new GraphvizHelper(writer);
        graphviz.beginDigraph("G");
        for (int i = 0; i < _nodeTable.size(); i++)
        {
            NodeLabel node = _nodeTable.getByID(i);
            graphviz.label(i + 1, node.toString());
        }

        for (Edge e : getEdgeSet())
        {
            EdgeLabel label = getEdgeLabel(e);
            if (label != null)
                graphviz.edge(e.srcNodeID + 1, e.destNodeID + 1, String.format("label=\"%s\"", label));
            else
                graphviz.edge(e.srcNodeID + 1, e.destNodeID + 1);
        }
        graphviz.endDigraph();
        return writer.toString();

    }

    public static <NodeLabel, EdgeLabel> AdjacencyList<NodeLabel, EdgeLabel> copy(Graph<NodeLabel, EdgeLabel> source)
    {
        // sort the node ID
        TreeSet<Integer> sortedNodeIDSet = new TreeSet<Integer>();
        for (int nodeID : source.getNodeIDSet())
            sortedNodeIDSet.add(nodeID);

        // add nodes in the ascending order of node IDs
        IndexedSet<NodeLabel> nodeIndex = new IndexedSet<NodeLabel>();
        for (int nodeID : sortedNodeIDSet)
        {
            nodeIndex.add(source.getNodeLabel(nodeID));
        }

        // add edges
        EdgeTable<EdgeLabel> edgeTable = new EdgeTable<EdgeLabel>();
        for (Edge edge : source.getEdgeSet())
        {
            edgeTable.add(source.getEdgeID(edge), source.getEdgeLabel(edge), edge);
        }
        return new AdjacencyList<NodeLabel, EdgeLabel>(nodeIndex, edgeTable);
    }

    /**
     * create new graph from a given node table and edge table
     * 
     * @param nodeIndex
     * @param edgeTable
     */
    private AdjacencyList(IndexedSet<NodeLabel> nodeIndex, EdgeTable<EdgeLabel> edgeTable)
    {
        this._nodeTable = nodeIndex;
        this._edgeTable = edgeTable;
    }

    public Collection<Integer> getEdgeIDSet()
    {
        return _edgeTable.getEdgeIDSet();
    }

    public EdgeLabel getEdgeLabel(int edgeID)
    {
        return _edgeTable.getEdgeLabel(edgeID);
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

    public Collection<Integer> getEdgeIDSet()
    {
        return _edgeTable.keySet();
    }

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
