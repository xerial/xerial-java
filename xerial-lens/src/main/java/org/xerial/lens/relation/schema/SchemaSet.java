/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// Xerial Raquel Project
//
// Schema.java
// Since: 2009/03/14 16:10:57
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.lang.RelationAttribute;
import org.xerial.lens.relation.lang.RelationExpr;
import org.xerial.lens.relation.query.StreamAmoebaJoin;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Automaton;
import org.xerial.util.graph.Edge;
import org.xerial.util.log.Logger;

/**
 * Schema class holds the entire schema set of an XML document
 * 
 * @author leo
 * 
 */
public class SchemaSet
{
    private static Logger                           _logger          = Logger.getLogger(SchemaSet.class);

    private final AdjacencyList<String, FD>         fdGraph;

    private final Automaton<XMLSkeltonNode, String> skelton          = new Automaton<XMLSkeltonNode, String>();
    private XMLSkeltonNode                          rootSkelton      = null;
    private final ArrayList<Schema>                 nestedSchemaList = new ArrayList<Schema>();

    private final HashSet<String>                   treeNodeSet      = new HashSet<String>();

    public SchemaSet(RelationSchema userDefinedSchema) throws XerialException {
        // tree node name
        // TODO tree node support
        //        for (TreeDefinition eachTree : userDefinedSchema.getTree())
        //            treeNodeSet.add(eachTree.getName());

        // create a FD graph
        HashMap<String, List<RelationExpr>> relationListOfEachCoreNode = new HashMap<String, List<RelationExpr>>();
        fdGraph = new AdjacencyList<String, FD>();
        for (RelationExpr relation : userDefinedSchema.getRelation()) {
            String coreNodeName = relation.name;

            // group relations by core node names
            List<RelationExpr> list = relationListOfEachCoreNode.get(coreNodeName);
            if (list == null) {
                list = new ArrayList<RelationExpr>();
                relationListOfEachCoreNode.put(coreNodeName, list);
            }
            list.add(relation);

            // draw edges
            for (TupleElement<RelationAttribute> each : relation) {
                if (!each.isAtom())
                    continue;
                RelationAttribute attribute = each.castToNode();
                String attributeName = attribute.name;
                if (attributeName.startsWith("@"))
                    attributeName = coreNodeName + StreamAmoebaJoin.ALTERNATIVE_ATTRIBUTE_SYMBOL
                            + attributeName.substring(1);
                fdGraph.addEdge(coreNodeName, attributeName, attribute.fd);
            }
        }

        if (_logger.isTraceEnabled())
            _logger.trace(fdGraph.toGraphViz());

        // compute start node (no parent node) set 
        HashSet<String> startNodeSet = new HashSet<String>();
        for (String coreNode : relationListOfEachCoreNode.keySet()) {
            String parent = getParentOrSelf(coreNode);
            startNodeSet.add(parent);
        }
        if (_logger.isTraceEnabled())
            _logger.trace("start node: " + startNodeSet);

        // constructs schema elements
        for (String startNode : startNodeSet) {
            Schema e = buildSchema(startNode);
            if (!e.isTuple())
                continue;

            nestedSchemaList.add(e);
        }

        if (_logger.isTraceEnabled())
            _logger.trace("schema list: " + nestedSchemaList);

        HashMap<String, List<Schema>> schemaListOfEachCoreNode = new HashMap<String, List<Schema>>();
        for (Schema each : nestedSchemaList) {
            List<Schema> list = schemaListOfEachCoreNode.get(each.getName());
            if (list == null) {
                list = new ArrayList<Schema>();
                schemaListOfEachCoreNode.put(each.getName(), list);
            }
            list.add(each);
        }

        // add skelton nodes
        HashMap<String, XMLSkeltonNode> skeltonNodeTable = new HashMap<String, XMLSkeltonNode>();
        for (String coreNode : schemaListOfEachCoreNode.keySet()) {
            XMLSkeltonNode node = new XMLSkeltonNode(schemaListOfEachCoreNode.get(coreNode));
            skelton.addState(node);
            skeltonNodeTable.put(coreNode, node);
        }

        // draw graph edges 
        for (XMLSkeltonNode eachSkeltonNode : skelton.getStateSet()) {
            for (int i = 0; i < eachSkeltonNode.size(); ++i) {
                Schema eachSchema = eachSkeltonNode.get(i);
                Schema flatSchema = eachSchema.flatten();
                for (int k = 1; k < flatSchema.size(); ++k) {
                    String name = flatSchema.get(k).getName();
                    if (skeltonNodeTable.containsKey(name)) {
                        skelton.addTransition(eachSkeltonNode, name, skeltonNodeTable.get(name));
                        startNodeSet.remove(name);
                    }
                }
            }
        }

        if (_logger.isTraceEnabled())
            _logger.trace("skelton: " + skelton.toGraphviz());

        // find a root node 
        if (startNodeSet.isEmpty() || startNodeSet.size() != 1)
            throw new XerialException(XerialErrorCode.INVALID_STATE, "no root schema or multiple root: " + startNodeSet);

        for (String name : startNodeSet) {
            rootSkelton = skeltonNodeTable.get(name);
            if (rootSkelton == null)
                throw new XerialException(XerialErrorCode.INVALID_STATE, "no skelton for " + name);
        }

        if (_logger.isTraceEnabled())
            _logger.trace("root skelton: " + rootSkelton);

    }

    public Automaton<XMLSkeltonNode, String> getSkelton() {
        return skelton;
    }

    private Schema buildSchema(String node) {
        SchemaBuilder builder = new SchemaBuilder();
        builder.setFD(FD.ONE_TO_ONE);
        builder.add(node);

        int attributeCount = 0;
        for (Edge eachEdge : fdGraph.getOutEdgeSet(node)) {
            String nextNode = fdGraph.getNodeLabel(eachEdge.getDestNodeID());
            FD fd = fdGraph.getEdgeLabel(eachEdge);
            if (fd == null || fd == FD.ONE_TO_ONE) {
                builder.add(buildSchema(nextNode));
                attributeCount++;
            }
            else {
                SchemaBuilder oneToMany = new SchemaBuilder();
                oneToMany.add(node);
                oneToMany.add(nextNode, FD.ONE_OR_MORE);
                oneToMany.setFD(fd);
                nestedSchemaList.add(oneToMany.build());
            }
        }

        if (attributeCount != 0)
            return builder.build();
        else
            return new SchemaAtom(node);
    }

    private String getParentOrSelf(String nodeName) {
        assert fdGraph != null;
        for (Edge eachEdge : fdGraph.getInEdgeSet(nodeName)) {
            FD fd = fdGraph.getEdgeLabel(eachEdge);
            if (fd == FD.ONE_TO_ONE) {
                int parentNodeID = eachEdge.getSourceNodeID();
                return getParentOrSelf(fdGraph.getNodeLabel(parentNodeID));
            }
        }

        return nodeName;
    }

    public Set<String> getTreeNodeSet() {
        return treeNodeSet;
    }

    public XMLSkeltonNode getRootSkelton() {
        return rootSkelton;
    }

    public AdjacencyList<String, FD> getFDGraph() {
        return fdGraph;
    }

}
