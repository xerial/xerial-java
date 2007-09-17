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

/**
 * Given an amoeba query expression, e.g., "select species, target, track from graph"
 * 
 * (species, target, track)
 *  human, hg17, overview track
 *  human, hg17, ruler track
 *  human, hg17, base color track
 *  human, hg18, overview track 
 *  human, hg18, ruler track
 *  ...
 * 
 *  
 *   
 * 
 * @author leo
 *
 */
public class AmoebaQueryProcessor 
{
	public static void generateAmoebaQuery(String queryString) throws AmoebaQueryException
	{
		AmoebaQueryLexer lexer = new AmoebaQueryLexer(new ANTLRStringStream(queryString));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AmoebaQueryParser parser = new AmoebaQueryParser(tokens);
		try {
			AmoebaQueryParser.amoebaQuery_return ret = parser.amoebaQuery();
			Tree tree = (Tree) ret.getTree();
		} 
		catch (RecognitionException e) {
			throw new AmoebaQueryException(e);
		}
	}
	
	
}




