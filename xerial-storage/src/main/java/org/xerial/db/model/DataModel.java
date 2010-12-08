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
import org.xerial.db.datatype.DataTypeBase;
import org.xerial.db.datatype.TypeName;
import org.xerial.db.sql.sqlite.SQLiteAccess;
import org.xerial.db.sql.sqlite.SQLiteDataTypeInfo;
import org.xerial.util.CollectionUtil;
import org.xerial.util.Functor;
import org.xerial.util.Predicate;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.DepthFirstSearchBase;
import org.xerial.util.graph.Edge;
import org.xerial.util.log.Logger;

/**
 * 
 * A DataModel manages the graph structure of an ER-diagram.
 * 
 * person:(id, name, address) || author:(book_id, author_id) |* |1 book:(r2:id,
 * r2:title) || order:(id, book_id, customer_id, info) || customer:(id, name,
 * address, phone)
 * 
 * 
 * query examples (person:name, book:title = "Gone with the wind")
 * 
 * (book:id = 10, customer:name, order:info)
 * 
 * 
 * select customer:id, customer:name, count(*) from (select customer left join
 * order on customer:id = order:customer_id)
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

    public void addNode(String nodeName)
    {
        if (!contains(nodeName))
            _graph.addNode(nodeName);
    }

    public boolean contains(String nodeName)
    {
        return _graph.hasNode(nodeName);
    }

    public void connectNodes(String sourceNodeName, String destNodeName, Relationship rel) throws DBException
    {
        _graph.addEdge(sourceNodeName, destNodeName, rel);
    }

    public Set<String> getRootNodeNameSet()
    {
        TreeSet<String> rootNodeSet = new TreeSet<String>();

        for (String node : _graph.getNodeLabelSet())
        {
            // if this node has no incoming edges
            if (_graph.getInEdgeSet(node).size() == 0)
                rootNodeSet.add(node);
        }

        return rootNodeSet;
    }

    @SuppressWarnings("unchecked")
    public List<String> destinationOf(String nodeName)
    {
        Collection<Integer> nodeIDSet = _graph.getDestNodeIDSetOf(_graph.getNodeID(nodeName));

        return CollectionUtil.collect(nodeIDSet, new Functor<Integer, String>() {
            public String apply(Integer nodeID)
            {
                return _graph.getNodeLabel(nodeID);
            }
        });

    }

    class PathSearch extends DepthFirstSearchBase<String, Relationship>
    {
        public List<String> getPath(String src, String dest)
        {
            run(_graph, src);

            // TODO improve by using Dijkstra's algorithm
            LinkedList<String> path = new LinkedList<String>();
            path.add(dest);
            String predecessor;
            String contextNode = dest;
            while (!(predecessor = getPredecessor(contextNode)).equals(contextNode))
            {
                path.addFirst(predecessor);
                if (predecessor.equals(src))
                {
                    return path;
                }
                contextNode = predecessor;
            }

            if (!path.getFirst().equals(src))
                return new LinkedList<String>();

            return path;

        }
    }

    public List<String> path(String src, String dest)
    {
        return new PathSearch().getPath(src, dest);
    }

    public boolean hasPath(String src, String dest)
    {
        return path(src, dest).size() > 0;
    }

    public void save(SQLiteAccess query) throws DBException
    {
        if (query.hasTable("node"))
            query.dropTable("node");
        if (query.hasTable("edge"))
            query.dropTable("edge");

        Relation nodeRelation = new Relation();
        nodeRelation.add(new DataTypeBase("id", TypeName.INTEGER, true, true));
        nodeRelation.add(new DataTypeBase("name", TypeName.STRING));
        query.createTable("node", nodeRelation);

        Relation edgeRelation = new Relation();
        edgeRelation.add(new DataTypeBase("id", TypeName.INTEGER, true, true));
        edgeRelation.add(new DataTypeBase("src", TypeName.INTEGER));
        edgeRelation.add(new DataTypeBase("dest", TypeName.INTEGER));
        edgeRelation.add(new DataTypeBase("relationship", TypeName.INTEGER));
        query.createTable("edge", edgeRelation);

        Vector<NodeData> nodeList = new Vector<NodeData>();
        for (int nodeID : _graph.getNodeIDSet())
        {
            nodeList.add(new NodeData(nodeID, _graph.getNodeLabel(nodeID)));
        }

        Vector<EdgeData> edgeList = new Vector<EdgeData>();
        for (Edge edge : _graph.getEdgeSet())
        {
            edgeList.add(new EdgeData(_graph.getEdgeID(edge), edge.getSourceNodeID(), edge.getDestNodeID(), _graph
                    .getEdgeLabel(edge)));
        }

        for (NodeData node : nodeList)
            query.insert("node", node);
        for (EdgeData edge : edgeList)
            query.insert("edge", edge);

    }

    public void load(SQLiteAccess query) throws DBException
    {

        TreeSet<NodeData> nodeList = CollectionUtil.sort(query.amoebaQuery(NodeData.class, "node"));
        TreeSet<EdgeData> edgeList = CollectionUtil.sort(query.amoebaQuery(EdgeData.class, "edge"));

        for (NodeData node : nodeList)
        {
            _graph.addNode(node.getName());
        }
        for (EdgeData edge : edgeList)
        {
            _graph.addEdge(new Edge(edge.getSrc(), edge.getDest()), EdgeData.translate(edge.getRelationship()));
        }

    }

    public String toString()
    {
        return _graph.toString();
    }

    public void attachSQLiteDatabase(String sqliteDBFile) throws DBException
    {

        SQLiteAccess query = new SQLiteAccess(sqliteDBFile);

        Collection<String> tableList = query.getTableList();
        List<String> infoTableList = CollectionUtil.select(tableList, new Predicate<String>() {
            public boolean apply(String input)
            {
                return isInfoTable(input);
            }
        });
        List<String> dataTableList = CollectionUtil.select(tableList, new Predicate<String>() {
            public boolean apply(String input)
            {
                return !isInfoTable(input);
            }
        });

        //HashMap<String, HashMap<String, String>> 
        for (String infoTable : infoTableList)
        {
            for (DataModelInfo info : query.amoebaQuery(DataModelInfo.class, infoTable))
            {

            }
        }

        for (String dataTable : dataTableList)
        {
            Relation relation = new Relation();
            for (SQLiteDataTypeInfo dataType : query.getSQLiteDataTypeInfo(dataTable))
            {
                relation.add(Relation.getDataType(dataType.getName(), dataType.getType()));
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

    public boolean hasEdge(String src, String dest)
    {
        return _graph.hasEdge(src, dest);
    }

    public Relationship getRelationship(String src, String dest)
    {
        return _graph.getEdgeLabel(src, dest);
    }

}
