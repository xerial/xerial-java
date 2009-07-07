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
// XerialJ
//
// SilkSchema.java
// Since: Jul 3, 2009 2:39:31 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Properties;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.DataType;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.silk.schema.impl.SilkSchemaLexer;
import org.xerial.silk.schema.impl.SilkSchemaParser;
import org.xerial.util.StringUtil;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.graph.GraphvizHelper;
import org.xerial.util.log.Logger;

public class SilkSchema {
    private static Logger _logger = Logger.getLogger(SilkSchema.class);

    public SilkModule globalModule = new SilkModule();

    /**
     * parse the input schema file and return the parse result in the form of
     * SilkSchema
     * 
     * @param reader
     * @return an instance of SilkSchema
     * @throws XerialException
     */
    public static SilkSchema parse(Reader reader) throws XerialException {
        try {
            SilkSchemaLexer lexer = new SilkSchemaLexer(new ANTLRReaderStream(reader));
            CommonTokenStream token = new CommonTokenStream(lexer);

            if (_logger.isTraceEnabled())
                _logger
                        .trace(StringUtil.join(ANTLRUtil
                                .prettyPrintTokenList(token.getTokens(), ANTLRUtil.getTokenTable(
                                        SilkSchemaLexer.class, "SilkSchema.tokens")), "\n"));

            SilkSchemaParser parser = new SilkSchemaParser(token);

            SilkSchemaParser.schema_return ret = parser.schema();

            if (_logger.isDebugEnabled())
                _logger.debug("parse tree:\n"
                        + ANTLRUtil.parseTree((Tree) ret.getTree(), SilkSchemaParser.tokenNames));

            SilkSchema schema = new SilkSchema();

            Lens.loadANTLRParseTree(schema.globalModule, (Tree) ret.getTree(),
                    SilkSchemaParser.tokenNames);

            return schema;
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, String.format(
                    "parse error line %d(%d): %s", e.line, e.charPositionInLine, e));
        }

    }

    /**
     * Get the SilkClass information of the given class name
     * 
     * @param className
     * @return
     */
    public SilkClass getSilkClass(String className) {
        // search global module
        return getSilkClass(globalModule, className);
    }

    /**
     * Get the SilkClass information of the given class name contained in the
     * specified module
     * 
     * @param module
     * @param className
     * @return
     */
    SilkClass getSilkClass(SilkModule module, String className) {
        for (SilkClass each : module.classDef) {
            if (each.name != null && each.name.equals(className))
                return each;
        }

        for (SilkModule m : module.module) {
            SilkClass c = getSilkClass(m, className);
            if (c != null)
                return c;
        }

        return null;
    }

    /**
     * Building an amoeba join query set from this schema
     * 
     * @author leo
     * 
     */
    private static class QueryBuilder {
        final SilkSchema schema;
        final QuerySetBuilder builder = new QuerySetBuilder();

        public QueryBuilder(SilkSchema schema) {
            this.schema = schema;
        }

        public QuerySet build() {
            build(schema.globalModule);

            return builder.build();
        }

        void build(SilkModule module) {

            for (SilkClass eachClass : module.classDef) {

                {
                    // build queries for retrieving attributes of the core node (class name)
                    SchemaBuilder sb = new SchemaBuilder();
                    sb.add(eachClass.name);
                    for (SilkAttribute eachAttribute : eachClass.getInheritedAttributes(schema)) {
                        sb.add(eachAttribute.name, getDataType(eachAttribute.typeName),
                                eachAttribute.isArray ? FD.ZERO_OR_MORE : FD.ONE_TO_ONE);
                    }
                    builder.addQueryTarget(sb.build());
                }

                // bridge to ancestors
                buildFromBelongsToDependency(eachClass);

            }

            // for each sub module
            for (SilkModule each : module.module) {
                build(each);
            }
        }

        public static DataType getDataType(String typeName) {
            if (typeName != null) {
                for (DataType each : DataType.values()) {
                    if (each.name().equalsIgnoreCase(typeName))
                        return each;
                }
            }
            return DataType.STRING;
        }

        void buildFromBelongsToDependency(SilkClass current) {

            SilkClass ancestor = current;
            while (ancestor != null) {
                // for belongs_to relationship
                if (ancestor.belongsTo != null) {
                    SilkClass parent = schema.getSilkClass(ancestor.belongsTo);
                    if (parent == null) {
                        _logger.warn("unknown class: " + ancestor.belongsTo);
                        return;
                    }

                    SchemaBuilder relation = new SchemaBuilder();
                    relation.add(parent.name, DataType.REFERENCE, FD.ONE_TO_ONE);
                    relation.add(current.name, DataType.REFERENCE, FD.ZERO_OR_MORE);
                    builder.addQueryTarget(relation.build());
                    return;
                }

                ancestor = ancestor.getParent(schema);
            }

        }

    }

    /**
     * Build a set of amoeba join queries corresponding to this schema
     * 
     * @return
     */
    public QuerySet buildAmoebaJoinQuery() {

        QueryBuilder builder = new QueryBuilder(this);
        return builder.build();
    }

    public String toGraphviz() {
        StringWriter buf = new StringWriter();
        GraphvizHelper g = new GraphvizHelper(buf);
        g.beginDigraph("G");
        g.graphOption("font=Arial");

        int moduleCount = 1;
        for (SilkModule eachModule : globalModule.module) {
            String moduleID = String.format("m%d", moduleCount++);
            g.node(moduleID, eachModule.name);

            for (SilkClass eachClass : eachModule.classDef) {
                String classID = String.format("c_%s", eachClass.name);

                g.node(classID, eachClass.name);
                // parent
                if (eachClass.parent != null) {
                    String parentID = String.format("c_%s", eachClass.parent);

                    Properties prop = new Properties();
                    prop.put("arrowhead", StringUtil.doubleQuote("none"));
                    prop.put("arrowtail", StringUtil.doubleQuote("empty"));
                    prop.put("colro", "gray");
                    g.edge(parentID, classID, prop);
                }
                else {
                    // module to class
                    g.edge(moduleID, classID);
                }

                // attributes
                int attributeCount = 1;
                for (SilkAttribute eachAttribute : eachClass.attribute) {
                    String attribID = String.format("%s_a%d", classID, attributeCount++);
                    {
                        String label = eachAttribute.name;
                        if (eachAttribute.typeName != null)
                            label += String.format(" [%s]", eachAttribute.typeName);

                        Properties prop = new Properties();
                        prop.put("label", StringUtil.doubleQuote(label));
                        prop.put("shape", "box");
                        g.node(attribID, prop);
                    }

                    if (eachAttribute.isArray) {
                        Properties edgeProp = new Properties();
                        edgeProp.put("color", "red");
                        g.edge(classID, attribID, edgeProp);
                    }
                    else
                        g.edge(classID, attribID);

                }

            }
        }

        g.endDigraph();

        g.flush();

        return buf.toString();
    }

}
