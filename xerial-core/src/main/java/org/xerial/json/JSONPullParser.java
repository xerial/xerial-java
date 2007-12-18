//--------------------------------------
// XerialJ Project
//
// JSONPullParser.java
// Since: May 8, 2007
//
// $Date: 2007-05-08 11:51:00 +0900 (Tue, 08 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONPullParser.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.xerial.core.XerialErrorCode;

import static org.xerial.json.JSONLexer.*;

/**
 * 
 * @author leo
 *
 */
public class JSONPullParser 
{
	private JSONLexer _lexer;
	private LinkedList<Token> _tokenStack = new LinkedList<Token>();

	private static HashMap<Integer, JSONEvent> _jsonEventTable = new HashMap<Integer, JSONEvent>(); 
	
	static 
	{
		_jsonEventTable.put(LBracket, JSONEvent.StartObject);
		_jsonEventTable.put(RBracket, JSONEvent.EndObject);
		_jsonEventTable.put(LBrace, JSONEvent.StartArray);
		_jsonEventTable.put(RBrace, JSONEvent.EndArray);
		
	}
	
	
	class Event
	{
		JSONEvent event;
		Token token;

		public Event(Token token)
		{
			this.token = token;
			int type = token.getType();
			switch(type)
			{
			case LBracket:
				
				break;
			case LBrace:
				break;
			}
		}
	}
	
	public JSONPullParser(String jsonString)
	{
		_lexer = new JSONLexer(new ANTLRStringStream(jsonString));
	}
	
	public JSONPullParser(InputStream jsonStream) throws IOException
	{
		_lexer = new JSONLexer(new ANTLRInputStream(jsonStream));
	}
	
	public JSONEvent next()
	{
		_tokenStack.add(_lexer.nextToken());
		return null;
	}
	
	public int getType() throws JSONException
	{
		return currentToken().getType();
	}

	public String getText() throws JSONException
	{
		return currentToken().getText();
	}
	
	private Token currentToken() throws JSONException
	{
		if(_tokenStack.isEmpty())
			throw new JSONException(XerialErrorCode.ParseError, "token stack is empty");
		else
			return _tokenStack.getLast();
	}
	
}




