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
// AmoebaQueryProcessor.java
// Since: Apr 23, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.amoeba.query.impl.AmoebaQueryLexer;
import org.xerial.amoeba.query.impl.AmoebaQueryParser;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * Given an amoeba query expression, e.g.,
 * "select species, target, track from graph"
 * 
 * (species, target, track) human, hg17, overview track human, hg17, ruler track
 * human, hg17, base color track human, hg18, overview track human, hg18, ruler
 * track ...
 * 
 * 
 * 
 * 
 * @author leo
 * 
 */
public class AmoebaQueryProcessor
{
    public static void generateAmoebaQuery(String queryString) throws XerialException
    {
        AmoebaQueryLexer lexer = new AmoebaQueryLexer(new ANTLRStringStream(queryString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AmoebaQueryParser parser = new AmoebaQueryParser(tokens);
        try
        {
            AmoebaQueryParser.amoebaQuery_return ret = parser.amoebaQuery();
            Tree tree = (Tree) ret.getTree();
        }
        catch (RecognitionException e)
        {
            throw new XerialException(XerialErrorCode.INVALID_INPUT, e);
        }
    }

}
