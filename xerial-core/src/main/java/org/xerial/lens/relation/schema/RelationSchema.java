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
// Xerial Raquel Project
//
// RelationSchema.java
// Since: Oct 6, 2008 2:46:24 PM
//
// $URL: http://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/expr/RelationSchema.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.lang.RelationAttribute;
import org.xerial.lens.relation.lang.RelationExpr;
import org.xerial.lens.relation.lang.RelationExpr.TreeDefinition;
import org.xerial.lens.relation.schema.impl.RelationSchemaLexer;
import org.xerial.lens.relation.schema.impl.RelationSchemaParser;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Edge;
import org.xerial.util.graph.Graph;
import org.xerial.util.log.Logger;

/**
 * RelationSchema represents the schema definition of a relation.
 * 
 * @author leo
 * 
 */
public class RelationSchema {
    private static Logger _logger = Logger.getLogger(RelationSchema.class);

    private final ArrayList<RelationExpr> relationDefList = new ArrayList<RelationExpr>();
    private final ArrayList<TreeDefinition> treeDefinitionList = new ArrayList<TreeDefinition>();

    public RelationSchema() {

    }

    public void addRelation(RelationExpr relation) {
        this.relationDefList.add(relation);
    }

    public List<RelationExpr> getRelation() {
        return relationDefList;
    }

    public void addTree(TreeDefinition treeDef) {
        this.treeDefinitionList.add(treeDef);
    }

    public List<TreeDefinition> getTree() {
        return treeDefinitionList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (relationDefList.size() > 0) {
            builder.append("[relation]\n");
            builder.append(StringUtil.join(relationDefList, "\n"));
        }

        if (treeDefinitionList.size() > 0) {
            builder.append("[tree]\n");
            builder.append(StringUtil.join(treeDefinitionList, "\n"));
        }
        return builder.toString();
    }

    public static RelationSchema parse(InputStream schemaText) throws IOException, XerialException {
        return parse(new InputStreamReader(schemaText));
    }

    public static RelationSchema parse(Reader schemaText) throws IOException, XerialException {
        RelationSchemaLexer lexer = new RelationSchemaLexer(new ANTLRReaderStream(schemaText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RelationSchemaParser parser = new RelationSchemaParser(tokens);

        try {
            RelationSchemaParser.schema_return ret = parser.schema();
            //_logger.debug("parse tree:\n" + ANTLRUtil.parseTree((Tree) ret.getTree(), RelationSchemaParser.tokenNames));

            RelationSchema schema = new RelationSchema();
            BeanUtilImpl.populateBeanWithParseTree(schema, (Tree) ret.getTree(),
                    RelationSchemaParser.tokenNames);

            return schema;
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, e);
        }
    }

    public Graph<String, FD> createFDGraph() {
        Graph<String, FD> fdGraph = new AdjacencyList<String, FD>();

        for (RelationExpr eachRelation : getRelation()) {
            String relationName = eachRelation.getName();

            for (TupleElement<RelationAttribute> each : eachRelation) {
                if (!each.isAtom())
                    continue;
                RelationAttribute eachAttribute = each.castToNode();
                String attributeName = eachAttribute.name;
                if (attributeName.startsWith("@"))
                    attributeName = eachRelation.getName() + attributeName;

                fdGraph.addEdge(relationName, attributeName, eachAttribute.fd);
            }
        }

        return fdGraph;
    }

    public static Map<FD, String> getEdgeStyle() {
        EnumMap<FD, String> edgeStyle = new EnumMap<FD, String>(FD.class);
        edgeStyle.put(FD.ONE_TO_ONE, "[color=\"#666666\"]");
        edgeStyle.put(FD.ONE_OR_MORE, "[penwidth=3 color=\"#F03060\"]");
        edgeStyle.put(FD.ZERO_OR_MORE, "[penwidth=3 color=\"#F03060\"]");
        edgeStyle.put(FD.ZERO_OR_ONE, "[penwidth=3 color=\"#F03060\"]");
        return edgeStyle;
    }

    public static String toGraphViz(Graph<String, FD> fdGraph) {
        StringWriter buffer = new StringWriter();
        PrintWriter out = new PrintWriter(buffer);

        out.println("digraph G {");
        out.println("graph [overlap=false rankdir=\"LR\"];");

        // node labels
        for (int nodeID : fdGraph.getNodeIDSet()) {
            out.println(String.format("%d [label=\"%s\"];", nodeID, fdGraph.getNodeLabel(nodeID)));
        }

        Map<FD, String> edgeStyle = getEdgeStyle();
        // edges
        for (int nodeID : fdGraph.getNodeIDSet()) {
            for (int destNodeID : fdGraph.getDestNodeIDSetOf(nodeID)) {
                FD occurrence = fdGraph.getEdgeLabel(new Edge(nodeID, destNodeID));
                out.println(String.format("%s -> %s %s;", nodeID, destNodeID, edgeStyle
                        .get(occurrence)));
            }

        }

        out.println("}");
        out.flush();
        return buffer.toString();
    }

}
