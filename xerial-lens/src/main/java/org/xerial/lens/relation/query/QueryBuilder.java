//--------------------------------------
// xerial-lens Project
//
// QueryBuilder.java
// Since: 2010/11/19
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.antlr.ANTLRUtil;
import org.xerial.lens.relation.DataType;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.silk.schema.SilkAttribute;
import org.xerial.silk.schema.SilkClass;
import org.xerial.silk.schema.SilkModule;
import org.xerial.silk.schema.SilkSchema;
import org.xerial.silk.schema.impl.SilkSchemaLexer;
import org.xerial.silk.schema.impl.SilkSchemaParser;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

/**
 * Building an amoeba join query set from this schema
 * 
 * @author leo
 * 
 */
public class QueryBuilder
{
    private static Logger _logger = Logger.getLogger(QueryBuilder.class);

    final SilkSchema      schema;
    final Builder         builder;

    public QueryBuilder(SilkSchema schema) {
        this.schema = schema;
        this.builder = new Builder(schema);
    }

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
                _logger.trace(StringUtil.join(
                        ANTLRUtil.prettyPrintTokenList(token.getTokens(),
                                ANTLRUtil.getTokenTable(SilkSchemaLexer.class, "SilkSchema.tokens")), "\n"));

            SilkSchemaParser parser = new SilkSchemaParser(token);

            SilkSchemaParser.schema_return ret = parser.schema();

            if (_logger.isDebugEnabled())
                _logger.debug("parse tree:\n" + ANTLRUtil.parseTree((Tree) ret.getTree(), SilkSchemaParser.tokenNames));

            SilkSchema schema = new SilkSchema();

            Lens.loadANTLRParseTree(schema.globalModule, (Tree) ret.getTree(), SilkSchemaParser.tokenNames);

            return schema;
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, String.format("parse error line %d(%d): %s", e.line,
                    e.charPositionInLine, e));
        }

    }

    /**
     * Building an amoeba join query set from this schema
     * 
     * @author leo
     * 
     */
    private static class Builder
    {
        final SilkSchema      schema;
        final QuerySetBuilder builder = new QuerySetBuilder();

        public Builder(SilkSchema schema) {
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
    public static QuerySet buildAmoebaJoinQuery(SilkSchema schema) {

        Builder builder = new Builder(schema);
        return builder.build();
    }

}
