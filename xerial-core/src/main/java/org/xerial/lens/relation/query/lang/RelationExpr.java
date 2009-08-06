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
package org.xerial.lens.relation.query.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.query.impl.LensQueryLexer;
import org.xerial.lens.relation.query.impl.LensQueryParser;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

/**
 * Relation expression
 * 
 * @author leo
 * 
 */
public class RelationExpr extends RelationItem {

    private static Logger _logger = Logger.getLogger(RelationExpr.class);

    public class Node extends RelationItem {

        public String nodeValue;

        public Compare compare = null;
        public PatternMatch patternMatch = null;

        @Override
        public boolean isRelation() {
            return false;
        }
    }

    public static class Compare {
        public String operator;
        public String operand;
    }

    public static class PatternMatch {
        public String operand;
    }

    public List<Node> node = new ArrayList<Node>();
    public List<RelationExpr> relation = new ArrayList<RelationExpr>();

    @Override
    public boolean isRelation() {
        return true;
    }

    private static class RelationQuery {
        public RelationExpr relation;
    }

    public static RelationExpr parse(String expr) throws XerialException {

        LensQueryLexer l = new LensQueryLexer(new ANTLRStringStream(expr));
        CommonTokenStream ct = new CommonTokenStream(l);
        LensQueryParser p = new LensQueryParser(ct);

        try {
            LensQueryParser.relation_return ret = p.relation();
            if (_logger.isDebugEnabled())
                _logger.debug("\n"
                        + ANTLRUtil.parseTree((Tree) ret.getTree(), LensQueryParser.tokenNames));

            RelationQuery r = Lens.loadANTLRParseTree(RelationQuery.class, (Tree) ret.getTree(),
                    LensQueryParser.tokenNames);

            return r.relation;
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, e);
        }

    }

    public Schema toSchema() {

        ArrayList<RelationItem> sortedRelationItem = new ArrayList<RelationItem>();
        sortedRelationItem.addAll(node);
        sortedRelationItem.addAll(relation);

        Collections.sort(sortedRelationItem, new Comparator<RelationItem>() {
            public int compare(RelationItem o1, RelationItem o2) {
                return o1.getIndex().compareTo(o2.getIndex());
            }
        });

        SchemaBuilder parent = new SchemaBuilder();
        parent.add(name);
        SchemaBuilder sibling = new SchemaBuilder();
        for (RelationItem each : sortedRelationItem) {
            if (each.isRelation()) {
                RelationExpr re = RelationExpr.class.cast(each);
                sibling.add(re.toSchema());
            }
            else
                sibling.add(each.name);
        }

        parent.add(sibling.build());

        return parent.build();

    }

}
