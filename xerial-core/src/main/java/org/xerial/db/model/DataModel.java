//--------------------------------------
// XerialJ Project
//
// DataModel.java
// Since: Apr 18, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.IntegerType;
import org.xerial.db.datatype.StringType;
import org.xerial.db.sql.sqlite.SQLiteAccess;
import org.xerial.db.sql.sqlite.SQLiteDataTypeInfo;
import org.xerial.json.InvalidJSONDataException;
import org.xerial.util.CollectionUtil;
import org.xerial.util.Functor;
import org.xerial.util.Predicate;
import org.xerial.util.bean.InvalidBeanException;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.DFSVisitor;
import org.xerial.util.graph.Edge;
import org.xerial.util.log.Logger;



/**
 * 
 * A DataModel manages the graph structure of an ER-diagram.
 * 
 *              person:(id, name, address)
 *                      ||
 * author:(book_id, author_id)
 *           |*
 *           |1
 *     book:(r2:id, r2:title)  
 *           ||
 * order:(id, book_id, customer_id, info) 
 *                       ||
 *                    customer:(id, name, address, phone)
 * 
 * 
 * query examples
 *   (person:name, book:title = "Gone with the wind")  
 * 
 *   (book:id = 10, customer:name, order:info) 
 * 
 *   
 *   select customer:id, customer:name, count(*)  from
 *   (select customer left join order on customer:id = order:customer_id)
 *   
 * 
 *  
 * Multidimensional Hash Table can support this type of query?
 * 
 * 
 * 
 *  
 *  
 * @author leo
 *
 */
public class DataModel 
{
	private static Logger _logger = Logger.getLogger(DataModel.class);
	
	private AdjacencyList<String, Relationship> _graph = new AdjacencyList<String, Relationship>();

	public void addNode(String nodeName) {
		if(!contains(nodeName))
			_graph.add(nodeName);
	}

	public boolean contains(String nodeName) {
		return _graph.hasNode(nodeName);
	}
	

	public void connectNodes(String sourceNodeName, String destNodeName, Relationship rel) throws DBException 
	{
		_graph.addEdge(sourceNodeName, destNodeName, rel);
	}

	public Set<String> getRootNodeNameSet() {
		TreeSet<String> rootNodeSet = new TreeSet<String>();
		
		for(String node : _graph.nodeCollection())
		{
			// if this node has no incoming edges
			if(_graph.inEdgeList(node).size() == 0)
				rootNodeSet.add(node);
		}
		
		return rootNodeSet;
	}

	@SuppressWarnings("unchecked")
	public List<String> destinationOf(String nodeName) {
		Set<Integer> nodeIDSet = _graph.destNodeIDSetOf(nodeName);
		
		return CollectionUtil.collect(nodeIDSet, new Functor<Integer>() {
			public Object apply(Integer nodeID) {
				return _graph.getNode(nodeID);
			}} );

	}

	public List<String> path(String src, String dest) {
		
		DFSVisitor<String, Relationship> dfs = new DFSVisitor<String, Relationship>(_graph);
		dfs.depthFirstSearch(src);
		
		
		// TODO improve by using dijkstra algorithm
		LinkedList<String> path = new LinkedList<String>();
		path.add(dest);
		String predecessor;
		String contextNode = dest;
		while(!(predecessor = dfs.getPredecessor(contextNode)).equals(contextNode))
		{
			path.addFirst(predecessor);
			if(predecessor.equals(src))
			{
				return path;
			}
			contextNode = predecessor;
		}

		if(!path.getFirst().equals(src))
			return new LinkedList<String>();
		
		return path;
	}

	public boolean hasPath(String src, String dest) {
		return path(src, dest).size() > 0;
	}

	public void save(SQLiteAccess query) throws DBException {
		if(query.hasTable("node"))
			query.dropTable("node");
		if(query.hasTable("edge"))
			query.dropTable("edge");
		
		Relation nodeRelation = new Relation(); 
		nodeRelation.add(new IntegerType("id", true, true));
		nodeRelation.add(new StringType("name"));
		query.createTable("node", nodeRelation);
		
		Relation edgeRelation = new Relation();
		edgeRelation.add(new IntegerType("id", true, true));
		edgeRelation.add(new IntegerType("src"));
		edgeRelation.add(new IntegerType("dest"));
		edgeRelation.add(new IntegerType("relationship"));
		query.createTable("edge", edgeRelation);

		Vector<NodeData> nodeList = new Vector<NodeData>(); 
		for(int nodeID : _graph.nodeIDSet())
		{
			nodeList.add(new NodeData(nodeID, _graph.getNode(nodeID)));
		}
		
		Vector<EdgeData> edgeList = new Vector<EdgeData>();
		for(Edge edge : _graph.edgeSet())
		{
			edgeList.add(new EdgeData(_graph.getEdgeID(edge), edge.getSourceNodeID(), edge.getDestNodeID(), _graph.getEdgeInfo(edge)));
		}
		
		try {		
			for(NodeData node : nodeList)
				query.insert(node, "node");
			for(EdgeData edge : edgeList)
				query.insert(edge, "edge");
		}
		catch (InvalidBeanException e) {
			throw new DBException(e);
		}
	}

	public void load(SQLiteAccess query) throws DBException {
		
		try {
			TreeSet<NodeData> nodeList = CollectionUtil.sort(query.amoebaQuery(NodeData.class, "node"));
			TreeSet<EdgeData> edgeList = CollectionUtil.sort(query.amoebaQuery(EdgeData.class, "edge"));
			
			for(NodeData node : nodeList)
			{
				_graph.setNode(node.getId(), node.getName());
			}
			for(EdgeData edge : edgeList)
			{
				_graph.setEdge(edge.getId(), edge.getSrc(), edge.getDest(), EdgeData.translate(edge.getRelationship()));
			}
			
			
		} catch (InvalidBeanException e) {
			throw new DBException(e);
		}
		
	}
	
	
	public String toString()
	{
		return _graph.toString();
	}

	
	public void attachSQLiteDatabase(String sqliteDBFile) throws DBException {
		
		SQLiteAccess query = new SQLiteAccess(sqliteDBFile);
		
		Collection<String> tableList = query.getTableList();
		List<String> infoTableList = CollectionUtil.select(tableList, new Predicate<String>(){
			public boolean apply(String input) {
				return isInfoTable(input);
			}
		});
		List<String> dataTableList = CollectionUtil.select(tableList, new Predicate<String>(){
			public boolean apply(String input) {
				return !isInfoTable(input);
			}
		});
		
		//HashMap<String, HashMap<String, String>> 
		for(String infoTable : infoTableList)
		{
			// retrieve datamodel info
			try {
				for(DataModelInfo info : query.amoebaQuery(DataModelInfo.class, infoTable))
				{
					
				}
			} 
			catch (InvalidBeanException e) {
				_logger.error(e);
			}
		}
		

		for(String dataTable : dataTableList)
		{
			Relation relation = new Relation();
			for(SQLiteDataTypeInfo dataType : query.getSQLiteDataTypeInfo(dataTable))
			{
				try {
					relation.add(Relation.getDataType(dataType.getName(), dataType.getType()));
				} catch (InvalidJSONDataException e) {
					throw new DBException(e);
				}
			}
			addRelation(relation);
		}
	}
	
	public void addRelation(Relation relation)
	{
		_logger.debug("add relation: " + relation.toString());
	}
	
	private static boolean isInfoTable(String tableName)
	{
		return tableName.endsWith("_info");
	}

	public boolean hasEdge(String src, String dest) {
		return _graph.hasEdge(src, dest);
	}
	
	
	public Relationship getRelationship(String src, String dest)
	{
		return _graph.getEdgeInfo(src, dest);
	}

	
}



