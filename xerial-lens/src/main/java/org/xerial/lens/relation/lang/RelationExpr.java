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
// Relation.java
// Since: Aug 6, 2009 11:04:31 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.lang;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.antlr.ANTLRUtil;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.lens.relation.query.impl.LensQueryLexer;
import org.xerial.lens.relation.query.impl.LensQueryParser;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.util.lens.ObjectLens;
import org.xerial.util.log.Logger;

/**
 * Relation expression for querying structured data
 * 
 * @author leo
 * 
 */
public class RelationExpr extends Tuple<RelationAttribute>
{

    private static Logger _logger = Logger.getLogger(RelationExpr.class);

    public String         name;
    public String         alias;

    private static class RelationQuery
    {
        public RelationExpr relation;
    }

    public static class TreeDefinition
    {
        private String name;

        public TreeDefinition() {}

        public TreeDefinition(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("tree: %s", name);
        }

    }

    public String getName() {
        return name;
    }

    public static RelationExpr parse(String expr) throws XerialException {

        LensQueryLexer l = new LensQueryLexer(new ANTLRStringStream(expr));
        CommonTokenStream ct = new CommonTokenStream(l);
        LensQueryParser p = new LensQueryParser(ct);

        try {
            LensQueryParser.relation_return ret = p.relation();
            if (_logger.isDebugEnabled())
                _logger.debug(ANTLRUtil.parseTree((Tree) ret.getTree(), LensQueryParser.tokenNames));

            RelationQuery r = Lens.loadANTLRParseTree(RelationQuery.class, (Tree) ret.getTree(),
                    LensQueryParser.tokenNames);

            return r.relation;
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, e);
        }

    }

    public void addNode(RelationAttribute node) {
        this.add(node);
    }

    public void addRelation(RelationExpr relation) {
        this.add(relation);
    }

    @Override
    public String toString() {
        return String.format("%s%s%s", name, alias != null ? " as " + alias : "", super.toString());
    }

    public Schema toSchema() {

        SchemaBuilder parent = new SchemaBuilder();
        parent.add(name);

        for (TupleElement<RelationAttribute> each : this) {
            if (each.isTuple()) {
                RelationExpr re = RelationExpr.class.cast(each);
                parent.add(re.toSchema());
            }
            else {
                RelationAttribute ra = RelationAttribute.class.cast(each);
                parent.add(ra.name);
            }
        }

        return parent.build();

    }

    public QuerySet buildQuerySet() {

        QuerySetBuilder b = new QuerySetBuilder();

        SchemaBuilder parent = new SchemaBuilder();
        String cName = ObjectLens.getCanonicalParameterName(name);
        parent.add(cName);

        for (TupleElement<RelationAttribute> each : this) {

            if (each.isTuple()) {
                RelationExpr re = RelationExpr.class.cast(each);
                for (Schema s : re.buildQuerySet().getTargetQuerySet())
                    b.addQueryTarget(s);

                b.addQueryTarget(new SchemaBuilder().add(cName).add(ObjectLens.getCanonicalParameterName(re.name))
                        .build());
            }
            else {
                RelationAttribute ra = RelationAttribute.class.cast(each);
                parent.add(ObjectLens.getCanonicalParameterName(ra.name));
            }
        }
        b.addQueryTarget(parent.build());

        return b.build();
    }

}
