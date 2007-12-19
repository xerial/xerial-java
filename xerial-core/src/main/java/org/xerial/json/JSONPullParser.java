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
import java.util.LinkedList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;


/**
 * Pull Parser for JSON data
 * @author leo
 *
 */
public class JSONPullParser 
{
    private static enum ParseState { Root, InObject, InArray, Key, KeyedValue } 
    
	private JSONLexer _lexer;
    private LinkedList<ParseState> parseStateStack = new LinkedList<ParseState>();
	private JSONPullParserEvent lastReportedEvent = null;
	private LinkedList<String> keyStack = new LinkedList<String>();
	private int currentDepth = 0;
	
	public JSONPullParser(String jsonString)
	{
		this(new JSONLexer(new ANTLRStringStream(jsonString)));
	}
	
	public JSONPullParser(InputStream jsonStream) throws IOException
	{
		this(new JSONLexer(new ANTLRInputStream(jsonStream)));
	}
	public JSONPullParser(Reader reader) throws IOException 
	{
	    this(new JSONLexer(new ANTLRReaderStream(reader)));
	}
	
	protected JSONPullParser(JSONLexer lexer)
	{
	    _lexer = lexer;
	    parseStateStack.addLast(ParseState.Root);
	}
	
	private ParseState getCurrentParseState()
	{
	    return parseStateStack.peekLast();
	}
	
	
	private void validateParseState(ParseState... possibleParseState) throws JSONException
	{
	    ParseState current = getCurrentParseState();
	    for(ParseState ps : possibleParseState)
	    {
	        if(ps == current)
	            return;
	    }
	    throw new JSONException(JSONErrorCode.InvalidJSONData, "invalid parse state: " + current.name());
	}
	
	private void popKeyStack()
	{
	    if(getCurrentParseState() == ParseState.Key)
	        keyStack.removeLast();
	}
	
	public JSONEvent next() throws JSONException
	{
	    Token token;
	    while((token = _lexer.nextToken()) != Token.EOF_TOKEN)
	    {
	        if(getCurrentParseState() == ParseState.KeyedValue)
	        {
	            keyStack.removeLast();
	            parseStateStack.removeLast();
	            if(getCurrentParseState() == ParseState.Key)
	                parseStateStack.removeLast();
	            else
	                throw new JSONException(JSONErrorCode.ParseError);
	        }
	        
	        int tokenType = token.getType();
	        
	        switch(tokenType)
	        {
	        case JSONLexer.LBrace:
	            currentDepth++;
	            parseStateStack.addLast(ParseState.InObject);
	            return reportEvent(token, JSONEvent.StartObject); 
	        case JSONLexer.RBrace:
                currentDepth--;
	            validateParseState(ParseState.InObject);
	            parseStateStack.removeLast();
	            popKeyStack();
	            return reportEvent(token, JSONEvent.EndObject);
	        case JSONLexer.LBracket:
	            currentDepth++;
	            parseStateStack.addLast(ParseState.InArray);
	            return reportEvent(token, JSONEvent.StartArray);
	        case JSONLexer.RBracket:
                currentDepth--;
                validateParseState(ParseState.InArray);
                parseStateStack.removeLast();
                popKeyStack();
	            return reportEvent(token, JSONEvent.EndArray);
	        case JSONLexer.Comma:
	            validateParseState(ParseState.InArray, ParseState.InObject);
	            continue;
	        case JSONLexer.Colon:
	            validateParseState(ParseState.Key); // next sequence will be a keyed value
	            continue;
	        case JSONLexer.String:
	            if(getCurrentParseState() == ParseState.InObject)
	            {
	                // key
	                parseStateStack.addLast(ParseState.Key);
	                keyStack.addLast(removeDoubleQuotation(token.getText()));
	                continue;
	            }
                if(getCurrentParseState() == ParseState.Key)
                    parseStateStack.addLast(ParseState.KeyedValue);
                return reportEvent(token, JSONEvent.String);
	        case JSONLexer.Integer:
                if(getCurrentParseState() == ParseState.Key)
                    parseStateStack.addLast(ParseState.KeyedValue);
                return reportEvent(token, JSONEvent.Integer);
	        case JSONLexer.Double:
                if(getCurrentParseState() == ParseState.Key)
                    parseStateStack.addLast(ParseState.KeyedValue);
                return reportEvent(token, JSONEvent.Double);
	        case JSONLexer.TRUE:
	        case JSONLexer.FALSE:
	            if(getCurrentParseState() == ParseState.Key)
                    parseStateStack.addLast(ParseState.KeyedValue);
                return reportEvent(token, JSONEvent.Boolean);
	        case JSONLexer.NULL:
                if(getCurrentParseState() == ParseState.Key)
                    parseStateStack.addLast(ParseState.KeyedValue);
                return reportEvent(token, JSONEvent.Null);
	        }
	    }	    
		
		return JSONEvent.EndJSON;
	}


	protected JSONEvent reportEvent(Token token, JSONEvent e)
	{
	    lastReportedEvent = new JSONPullParserEvent(token, e);
	    return lastReportedEvent.getEvent();
	}


	/**
	 * Gets the current object/array/value key.
	 * @return the current key, or null when the current token is no name array or object.
	 * @throws JSONException
	 */
	public String getKeyName() throws JSONException
	{
	    if(keyStack.isEmpty())
	        return null;
	    else
	        return keyStack.peekLast();
	}
	
	/**
	 * Gets the JSONValue of the current event
	 * @return the current JSONValue, or null If current event type is Start/EndObject, Start/EndArray or EndJSON, 
	 * @throws JSONException
	 */
	public JSONValue getValue() 
	{
	    String text = lastReportedEvent.getToken().getText();
	    switch(lastReportedEvent.getEvent())
	    {
	    case String:
	        return new JSONString(removeDoubleQuotation(text));
	    case Integer:
	        return new JSONInteger(text);
	    case Double:
	        return new JSONDouble(text);
	    case Boolean:
	        return new JSONBoolean(text);
	    case Null:
	        return new JSONNull();
	    default:
	        return null;
	    }

	}
	
	public String getText() 
	{
        return lastReportedEvent.getToken().getText();
	}
	
	private static String removeDoubleQuotation(String text)
	{
	    return text.substring(1, text.length()-1);
	}

    public int getDepth()
    {
        return currentDepth;
    }
	
	
}

/**
 * A pull parser event
 * @author leo
 *
 */
class JSONPullParserEvent 
{
    private Token t;
    private JSONEvent event;
    
    public JSONPullParserEvent(Token t, JSONEvent event)
    {
        this.t = t;
        this.event = event;
    }

    public Token getToken()
    {
        return t;
    }

    public void setToken(Token t)
    {
        this.t = t;
    }

    public JSONEvent getEvent()
    {
        return event;
    }

    public void setEvent(JSONEvent event)
    {
        this.event = event;
    }
}



