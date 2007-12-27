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
 * Depth first visitor
 * @author leo
 *
 */
public class DFSVisitor<NodeType, EdgeType> 
{
	enum NodeColor { WHITE, GRAY, BLACK }	
	private AdjacencyList<NodeType, EdgeType> _graph;
	private HashMap<NodeType, NodeColor> _nodeColor = new HashMap<NodeType, NodeColor>();
	private HashMap<NodeType, NodeType> _predecessor = new HashMap<NodeType, NodeType>();
	private int _time;
	private HashMap<NodeType, Integer> _discoveryTime = new HashMap<NodeType, Integer>();
	private HashMap<NodeType, Integer> _finishTime = new HashMap<NodeType, Integer>();
	

	private void run(NodeType startNode)
	{
		for(NodeType node : _graph.nodeCollection())
		{
			this.initializeNode(node);
			
			_nodeColor.put(node, NodeColor.WHITE);
			_predecessor.put(node, node);
		}
		_time = 0;
		if(startNode != null)
		{
			this.startNode(startNode);
			dfsVisit(startNode);
		}
		for(NodeType node : _graph.nodeCollection())
		{
			NodeColor color = _nodeColor.get(node);
			assert(color != null);
			if(color == NodeColor.WHITE)
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
		for(Edge edge : _graph.outEdgeList(node))
		{
			this.examineEdge(edge);

			NodeType adjacentNode = _graph.getNode(edge.getDestNodeID());
			NodeColor color = _nodeColor.get(adjacentNode);
			assert(color != null);
			if(color == NodeColor.WHITE)
			{
				this.treeEdge(edge);
				
				_predecessor.put(adjacentNode, node);
				dfsVisit(adjacentNode);
			}
			else if(color == NodeColor.GRAY)
			{
				this.backEdge(edge);
			}
			else if(color == NodeColor.BLACK)
			{
				this.forwardOrCrossEdge(edge);
			}
		}
		
		this.finishNode(node);
		_nodeColor.put(node, NodeColor.BLACK);
		
		_finishTime.put(node, _time++);
	}

	
	
	public NodeType getPredecessor(NodeType node)
	{
		return _predecessor.get(node);
	}
	public int getDiscoveryTime(NodeType node)
	{
		return _discoveryTime.get(node);
	}
	public int getFinishTime(NodeType node)
	{
		return _finishTime.get(node);
	}
	
	
	
	
	public DFSVisitor(AdjacencyList<NodeType, EdgeType> graph)
	{
		this._graph = graph;
	}
	
	protected final AdjacencyList<NodeType, EdgeType> graph() 
	{
		return _graph;
	}

	public final void depthFirstSearch(NodeType startNode)
	{
		run(startNode);
	}
	
	public String toString(Edge edge)
	{
		return "(" + graph().getNode(edge.getSourceNodeID()).toString() 
		+ ", " + graph().getNode(edge.getDestNodeID()).toString() + ")";
	}
	
	
	
	
	public void initializeNode(NodeType node)
	{
		
	}
	
	public void startNode(NodeType node)
	{
		
	}
	public void discoverNode(NodeType node)
	{}
	
	public void finishNode(NodeType node)
	{}
	
	public void examineEdge(Edge edge)
	{
		
	}
	
	public void treeEdge(Edge edge)
	{
		
	}
	
	public void backEdge(Edge edge)
	{
		
	}
	
	public void forwardOrCrossEdge(Edge edge)
	{
		
	}

	
}




