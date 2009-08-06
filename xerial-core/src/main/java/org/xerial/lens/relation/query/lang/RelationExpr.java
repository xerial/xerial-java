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

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.query.impl.LensQueryLexer;
import org.xerial.lens.relation.query.impl.LensQueryParser;

/**
 * Relation expression
 * 
 * @author leo
 * 
 */
public class RelationExpr {
    public static class Node {
        public String name;
        public String nodeValue;

        public Compare compare = null;
        public PatternMatch patternMatch = null;
    }

    public static class Compare {
        public String operator;
        public String operand;
    }

    public static class PatternMatch {
        public String operand;
    }

    public String name;
    public ArrayList<Node> node;

    public static RelationExpr parse(String expr) throws XerialException {

        LensQueryLexer l = new LensQueryLexer(new ANTLRStringStream(expr));
        CommonTokenStream ct = new CommonTokenStream(l);
        LensQueryParser p = new LensQueryParser(ct);

        try {
            LensQueryParser.relation_return ret = p.relation();
            return Lens.loadANTLRParseTree(RelationExpr.class, (Tree) ret.getTree(),
                    LensQueryParser.tokenNames);
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, e);
        }

    }
}
