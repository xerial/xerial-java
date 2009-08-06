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

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.lens.relation.query.impl.LensQueryLexer;
import org.xerial.lens.relation.query.impl.LensQueryParser;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

/**
 * Relation expression
 * 
 * @author leo
 * 
 */
public class RelationExpr {

    private static Logger _logger = Logger.getLogger(RelationExpr.class);

    public class Node {

        public String name;
        public String alias;

        public String nodeValue;

        public Compare compare = null;
        public PatternMatch patternMatch = null;

        public void setIndex(String tupleIndex) {
            index = TupleIndex.parse(tupleIndex);
        }

        public TupleIndex getIndex() {
            return index;
        }

    }

    public static class Compare {
        public String operator;
        public String operand;
    }

    public static class PatternMatch {
        public String operand;
    }

    public String name;
    public String alias;
    public List<Node> node;
    public List<RelationExpr> relation;
    private TupleIndex index = new TupleIndex(0);

    public void setIndex(String tupleIndex) {
        index = TupleIndex.parse(tupleIndex);
    }

    public TupleIndex getIndex() {
        return index;
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
}
