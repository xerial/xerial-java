//--------------------------------------
// XerialJ Project
//
// AmoebaQueryParserTest.java
// Since: Apr 23, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;


import static org.junit.Assert.fail;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class AmoebaQueryParserTest {
	
	private Logger _logger = Logger.getLogger(AmoebaQueryParserTest.class);
	
	@Before
	public void setUp() throws Exception {
	    
	}

	@After
	public void tearDown() throws Exception {
	}

	private AmoebaQueryParser parser(String query)
	{
		AmoebaQueryLexer lexer = new AmoebaQueryLexer(new ANTLRStringStream(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		List tokenList = tokens.getTokens();
		AmoebaQueryParser parser = new AmoebaQueryParser(tokens);
		return parser;
	}
	
	private void parse(String query)
	{
		try {
			_logger.debug(query);
			AmoebaQueryParser.amoebaQuery_return r = parser(query).amoebaQuery();
			CommonTree t = (CommonTree) r.getTree();
			_logger.debug(t.toStringTree());
		} catch (RecognitionException e) {
			int line = e.line;
			int charPos = e.charPositionInLine;
			StringBuilder cursor = new StringBuilder(); 
			for(int i=0; i<charPos; i++)
				cursor.append(' ');
			cursor.append("^");
			String errorMessage = e + " token=" + e.token + " line: " + e.line + "(" + e.charPositionInLine +")\n" + query + "\n" + cursor.toString();
			_logger.error(errorMessage);
			List stack = AmoebaQueryParser.getRuleInvocationStack(e, e.getClass().getName());
			_logger.error(stack);
			fail(errorMessage);
		}
	}
	
	@Test 
	public void select()
	{
		parse("select book");
		parse("select book, title");
		parse("select book, title where year = 2007");
		parse("select book, title from bib where year >= 2000");
		parse("select paper, author, title, year from (select bib where category = 'computer science')");
		
		parse("select *");
		parse("select * from bib");
	}
	
	@Test
	public void cond()
	{
		parse("select book where year != 2007");
		parse("select book where year >= 2007");
	}
	
	@Test
	public void fromClause()
	{
		parse("select book, title from file('book.xml')");
		parse("select book from (select bib)");
		parse("select author, title from bib, paper");
	}
	
	@Test
	public void xmlRetrieval()
	{
		parse("select xml(book) from bib");
	}
	
	@Test
	public void labelReference()
	{
		parse("select b.book, b.author from bib as b");
	}
	
	
	@Test
	public void inCondition()
	{
		parse("select book, author where author in (select author where name like 'leo')");
	}
	
	@Test
	public void orExpr()
	{
		parse("select book where author like 'Buneman' or author like 'Peter'");
	}
	
	@Test
	public void insert()
	{
		parse("insert (book, author, title)");
		parse("insert (book, author = 'leo', title = 'Gone with the Wind')");
		parse("insert (book, author = {'leo', 'yui'}, title = 'Gone with the Wind')");
	}
	
	@Test
	public void update()
	{
		parse("update set (author = 'leo')"); 
	}
	 
	/*
	@Test
	public void shortHandNotation()
	{
		parse("(book, title)");
		parse("(book, title), year = 2007");
		parse("(book, title), year >= 2000 : (bib)");
		parse("(paper, author, title, year) : (bib), category = 'computer science'");
	}
	*/
	
	@Test 
	public void comment()
	{
		parse("select book /* comment */, title");
		parse("// single line comment\n select book");
	}
	
	
	
}




