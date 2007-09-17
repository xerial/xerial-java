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
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.xerial.util.CollectionUtil;
import org.xerial.util.StringUtil;


/**
 * AdjacencyList is a directed graph in which node IDs and edge IDs are automatically 
 * assigned to for each node and edge.
 * 
 * @author leo
 * 
 */
public class AdjacencyList<NodeType, EdgeType> {
	NodeTable<NodeType> _nodeTable = new NodeTable<NodeType>();

	EdgeTable<EdgeType> _edgeTable = new EdgeTable<EdgeType>();

	public AdjacencyList() {

	}

	public int add(NodeType node) {
	    int nodeID = _nodeTable.getNodeID(node);
	    if(nodeID == -1)
	        nodeID = _nodeTable.add(node);
	    return nodeID;
	}

	public void addEdge(NodeType sourceNode, NodeType destNode) {
		addEdge(sourceNode, destNode, null);
	}

	public void addEdge(NodeType sourceNode, NodeType destNode, EdgeType edge) {
		add(sourceNode);
		add(destNode);

		int sourceNodeID = _nodeTable.getNodeID(sourceNode);
		int destNodeID = _nodeTable.getNodeID(destNode);

		_edgeTable.add(edge, sourceNodeID, destNodeID);
	}

    public void addEdge(int sourceNodeID, int destNodeID, EdgeType edge) throws GraphException
    {
        if(!_nodeTable.containsKey(sourceNodeID))
            throw new GraphException("no node id is found: " + sourceNodeID);
        if(!_nodeTable.containsKey(destNodeID))
            throw new GraphException("no node id is found: " + destNodeID);
        
        _edgeTable.add(edge, sourceNodeID, destNodeID);
        
    }
    
	/*
	public void setNodeTable(List<NodeData> nodeList)
	{
		
	}
	*/
	
	public Collection<NodeType> nodeCollection() {
		return _nodeTable.values();
	}

	public Set<Integer> nodeIDSet() {
		return _nodeTable.keySet();
	}

	public Set<Integer> destNodeIDSetOf(NodeType node) {
		return destNodeIDSet(getNodeID(node));
	}

	public Set<Integer> sourceNodeIDSetOf(NodeType node) {
		return sourceNodeIDSet(getNodeID(node));
	}

	public Set<Integer> destNodeIDSet(Integer nodeID) {
		return _edgeTable.destNodeIDSet(nodeID);
	}

	public Set<Integer> sourceNodeIDSet(Integer nodeID) {
		return _edgeTable.sourceNodeIDSet(nodeID);
	}

	public int getNodeID(NodeType node) {
		return _nodeTable.getNodeID(node);
	}

	public NodeType getNode(int nodeID) {
		return _nodeTable.get(nodeID);
	}

	public List<Edge> outEdgeList(NodeType node) {
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		int sourceNodeID = getNodeID(node);
		for (Integer destNodeID : _edgeTable.destNodeIDSet(sourceNodeID)) {
			edgeList.add(new Edge(sourceNodeID, destNodeID));
		}
		return edgeList;
	}

	public List<NodeType> outNodeList(NodeType node) {
		ArrayList<NodeType> outNodeList = new ArrayList<NodeType>();
		int sourceNodeID = getNodeID(node);
		for (Integer destNodeID : _edgeTable.destNodeIDSet(sourceNodeID)) {
			outNodeList.add(getNode(destNodeID));
		}
		return outNodeList;
	}

	public List<Edge> inEdgeList(NodeType node) {
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		int nodeID = getNodeID(node);
		for (Integer sourceNodeID : _edgeTable.sourceNodeIDSet(nodeID)) {
			edgeList.add(new Edge(sourceNodeID, nodeID));
		}
		return edgeList;
	}

	public boolean hasNode(NodeType node) {
		return _nodeTable.containsValue(node);
	}

	public boolean hasEdge(NodeType src, NodeType dest) {
		return _edgeTable.hasEdge(getNodeID(src), getNodeID(dest));
	}

	public void clear() {
		_nodeTable.clear();
		_edgeTable.clear();
	}

	public int numVertex() {
		return _nodeTable.size();
	}

	public List<Edge> edgeSet() {
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		for (int nodeID : nodeIDSet()) {
			for (Edge edge : outEdgeList(getNode(nodeID))) {
				edgeList.add(edge);
			}
		}

		return edgeList;
	}

	public int getEdgeID(Edge edge) {
		return _edgeTable.getEdgeID(edge.getSourceNodeID(), edge.getDestNodeID());
	}

	public EdgeType getEdgeInfo(Edge edge) {
		return _edgeTable.getEdgeInfo(edge);
	}

	public EdgeType getEdgeInfo(NodeType src, NodeType dest)
	{
		return _edgeTable.getEdgeInfo(new Edge(getNodeID(src), getNodeID(dest)));
	}
	
	public void setNode(int nodeID, NodeType node)
	{
		_nodeTable.add(nodeID, node);
	}
	public void setEdge(int edgeID, int sourceNodeID, int destNodeID, EdgeType edge)
	{
		_edgeTable.add(edgeID, edge, sourceNodeID, destNodeID);
	}
	
	public String toString()
	{
		String nodeData = CollectionUtil.displayMap(_nodeTable, ":", ", ");
		
		ArrayList<String> edgeData = new ArrayList<String>();
		for(Edge e : edgeSet())
		{
			EdgeType edgeInfo = getEdgeInfo(e);
			edgeData.add(e.toString() + ":" + (edgeInfo != null ? edgeInfo.toString() : ""));
		}
		return "node: " + nodeData + "\n" + StringUtil.join(edgeData, "\n");
	}

	
}

class NodeTable<NodeType> extends TreeMap<Integer, NodeType> {
	private static final long serialVersionUID = 1L;

	private int _numNode = 0;

	private HashMap<NodeType, Integer> _nodeIDIndex = new HashMap<NodeType, Integer>();

	public int getNodeID(NodeType node) {
		Integer nodeID = _nodeIDIndex.get(node);
		return (nodeID == null) ? -1 : nodeID;
	}

	public int add(int nodeID, NodeType node)
	{
		super.put(nodeID, node);
		if(nodeID > _numNode)
			_numNode = nodeID;
		_nodeIDIndex.put(node, nodeID);
		_numNode++;
		return nodeID;
	}
	
	public int add(NodeType node) {
		int newNodeID = _numNode + 1;
		super.put(newNodeID, node);
		_nodeIDIndex.put(node, newNodeID);
		++_numNode;
		return newNodeID;
	}

	public void clear() {
		_numNode = 0;
		super.clear();
		_nodeIDIndex.clear();
	}

}

class EdgeTable<EdgeType> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TreeMap<Integer, EdgeType> _edgeTable = new TreeMap<Integer, EdgeType>();
	TreeMap<Edge, Integer> _edgeIndex = new TreeMap<Edge, Integer>();
	HashMap<Integer, TreeSet<Integer>> _outNodeListOfEachNode = new HashMap<Integer, TreeSet<Integer>>();
	HashMap<Integer, TreeSet<Integer>> _inNodeListOfEachNode = new HashMap<Integer, TreeSet<Integer>>();

	public int add(int newEdgeID, EdgeType edge, int sourceNodeID, int destNodeID)
	{
		Edge newEdge = new Edge(sourceNodeID, destNodeID);
		Set<Integer> destNodeListOfSourceNode = destNodeIDSet(sourceNodeID);
		Set<Integer> sourceNodeListdOfDestinationNode = sourceNodeIDSet(destNodeID);

		destNodeListOfSourceNode.add(destNodeID);
		sourceNodeListdOfDestinationNode.add(sourceNodeID);
		_edgeIndex.put(newEdge, newEdgeID);
		_edgeTable.put(newEdgeID, edge);

		return newEdgeID;
	}
	
	public int add(EdgeType edge, int sourceNodeID, int destNodeID) {
		if (hasEdge(sourceNodeID, destNodeID))
			return getEdgeID(sourceNodeID, destNodeID);

		int newEdgeID = _edgeIndex.size() + 1;
		return add(newEdgeID, edge, sourceNodeID, destNodeID);
	}

	public boolean hasEdge(int sourceNodeID, int destNodeID) {
		return destNodeIDSet(sourceNodeID).contains(destNodeID);
	}

	public EdgeType getEdgeInfo(int edgeID) {
		return _edgeTable.get(edgeID);
	}

	public EdgeType getEdgeInfo(Edge edge) {
		return getEdgeInfo(getEdgeID(edge.getSourceNodeID(), edge.getDestNodeID()));
	}

	public int getEdgeID(int sourceNodeID, int destNodeID) {
		return _edgeIndex.get(new Edge(sourceNodeID, destNodeID));
	}

	public Set<Integer> destNodeIDSet(int sourceNodeID) {
		TreeSet<Integer> destNodeIDSet = _outNodeListOfEachNode.get(sourceNodeID);
		if (destNodeIDSet == null) {
			TreeSet<Integer> newNodeIDSet = new TreeSet<Integer>();
			_outNodeListOfEachNode.put(sourceNodeID, newNodeIDSet);
			return newNodeIDSet;
		} else
			return destNodeIDSet;
	}

	public Set<Integer> sourceNodeIDSet(int destNodeID) {
		TreeSet<Integer> destNodeIDSet = _inNodeListOfEachNode.get(destNodeID);
		if (destNodeIDSet == null) {
			TreeSet<Integer> newNodeIDSet = new TreeSet<Integer>();
			_inNodeListOfEachNode.put(destNodeID, newNodeIDSet);
			return newNodeIDSet;
		} else
			return destNodeIDSet;
	}

	public void clear() {
		_edgeTable.clear();
		_edgeIndex.clear();

		_outNodeListOfEachNode.clear();
		_inNodeListOfEachNode.clear();
	}

}
