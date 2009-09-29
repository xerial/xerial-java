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
// XPathExpr.java
// Since: Sep 29, 2009 2:26:59 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query.lang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.query.impl.XPathLexer;
import org.xerial.lens.relation.query.impl.XPathParser;
import org.xerial.lens.relation.query.impl.XPathParser.xpath_return;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

/**
 * XPath expression
 * 
 * @author leo
 * 
 */
public class XPathExpr {

    private static Logger _logger = Logger.getLogger(XPathExpr.class);

    public static enum Axis {
        Relative, PC, AD
    }

    public static class Step {
        public String name;
        public Axis axis = Axis.Relative;
        public List<Step> step = new ArrayList<Step>();
        public List<Predicate> prediate = new ArrayList<Predicate>();
    }

    public static class Predicate {

    }

    public Step step;

    public static XPathExpr parse(String xpathExpr) throws XerialException {
        XPathLexer lexer = new XPathLexer(new ANTLRStringStream(xpathExpr));
        CommonTokenStream token = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(token);

        try {
            xpath_return r = parser.xpath();

            if (_logger.isDebugEnabled())
                _logger.debug(ANTLRUtil.parseTree((Tree) r.getTree(), XPathParser.tokenNames));

            return Lens.loadANTLRParseTree(XPathExpr.class, (Tree) r.getTree(),
                    XPathParser.tokenNames);
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, e);
        }

    }
}
