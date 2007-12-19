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
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;

import static org.xerial.json.JSONLexer.*;

/**
 * Pull Parser for JSON data
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
	
	private static enum ParseState { InObject, InArray, InKeyedValue } 
	private LinkedList<ParseState> parseStateStack = new LinkedList<ParseState>();
	
	public JSONPullParser(String jsonString)
	{
		_lexer = new JSONLexer(new ANTLRStringStream(jsonString));
	}
	
	public JSONPullParser(InputStream jsonStream) throws IOException
	{
		_lexer = new JSONLexer(new ANTLRInputStream(jsonStream));
	}
	public JSONPullParser(Reader reader) throws IOException 
	{
	    _lexer = new JSONLexer(new ANTLRReaderStream(reader));
	}
	
	private ParseState getCurrentParseState()
	{
	    return parseStateStack.peekLast();
	}
	
	private void validateParseState(ParseState collectParseState) throws JSONException
	{
	    if(collectParseState != getCurrentParseState())
	        throw new JSONException(JSONErrorCode.InvalidJSONData, "syntax error");
	}
	
	public JSONEvent next() throws JSONException
	{
	    
	    Token token;
	    while((token = _lexer.nextToken()) != Token.EOF_TOKEN)
	    {
	        int tokenType = token.getType();
	        
	        switch(tokenType)
	        {
	        case JSONLexer.LBrace:
	            parseStateStack.addLast(ParseState.InObject);
	            return JSONEvent.StartObject; 
	        case JSONLexer.RBrace:
	            validateParseState(ParseState.InObject);
	            parseStateStack.removeLast();
	            return JSONEvent.EndObject;
	        case JSONLexer.LBracket:
	            parseStateStack.addLast(ParseState.InArray);
	            return JSONEvent.StartArray;
	        case JSONLexer.RBracket:
                validateParseState(ParseState.InArray);
                parseStateStack.removeLast();
	            return JSONEvent.EndArray;
	        case JSONLexer.Comma:
	        {
	            ParseState currentState = parseStateStack.peekLast();
	            if(currentState != ParseState.InArray || currentState != ParseState.InObject)
	                throw new JSONException(JSONErrorCode.InvalidJSONData, "syntax error");
	            continue;
	        }
	        case JSONLexer.String:
	            if(getCurrentParseState() == ParseState.InObject)
	            {
	                return JSONEvent.Key;
	            }
	        case JSONLexer.Integer:
	        case JSONLexer.Double:
	        case JSONLexer.TRUE:
	        case JSONLexer.FALSE:
	        case JSONLexer.NULL:
	            return JSONEvent.Value;
	        }
	    }	    
		
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
			throw new JSONException(JSONErrorCode.ParseError, "token stack is empty");
		else
			return _tokenStack.getLast();
	}
	
}




