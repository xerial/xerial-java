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
// JSONPullParser.java
// Since: May 8, 2007
//
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
import org.xerial.json.impl.JSONLexer;
import org.xerial.util.log.Logger;

/**
 * Pull Parser for JSON data
 * 
 * @author leo
 * 
 */
public class JSONPullParser
{
    private static enum ParseState {
        Root, InObject, InArray, Key, KeyedValue
    }

    private static Logger _logger = Logger.getLogger(JSONPullParser.class);
    private JSONLexer _lexer;
    private LinkedList<ParseState> parseStateStack = new LinkedList<ParseState>();
    private JSONPullParserEvent lastReportedEvent = null;
    private LinkedList<String> keyStack = new LinkedList<String>();
    private int currentDepth = 0;

    public JSONPullParser(String jsonString)
    {
        this(new JSONLexer(new ANTLRStringStream(jsonString)));
    }

    public JSONPullParser(JSONObject jsonObject)
    {
        this(new JSONLexer(new ANTLRStringStream(jsonObject.toJSONString())));
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
        return parseStateStack.getLast();
    }

    private void validateParseState(ParseState... possibleParseState) throws JSONException
    {
        ParseState current = getCurrentParseState();
        for (ParseState ps : possibleParseState)
        {
            if (ps == current)
                return;
        }
        throw new JSONException(JSONErrorCode.InvalidJSONData, "invalid parse state: " + current.name());
    }

    private void popKeyStack()
    {
        if (getCurrentParseState() == ParseState.Key)
            keyStack.removeLast();
    }

    private void pushParseState(ParseState ps)
    {
        parseStateStack.addLast(ps);
        // _logger.trace("push: " + StringUtil.join(parseStateStack, ", "));
    }

    private void popParseState()
    {
        parseStateStack.removeLast();
        // _logger.trace("pop : " + StringUtil.join(parseStateStack, ", "));
    }

    private void keyedValueTest()
    {
        if (getCurrentParseState() == ParseState.Key)
            pushParseState(ParseState.KeyedValue);
    }

    /**
     * Reads the current JSONValue, which is one of {@link JSONObject} ,
     * {@link JSONArray}, {@link JSONInteger}, {@link JSONDouble},
     * {@link JSONString}, {@link JSONBoolean} and {@link JSONNull}. This
     * methods proceeds the parse state up to the end of the returned value.
     * 
     * @return the current JSONValue
     * @throws JSONException
     *             when the current token is not a {@link JSONValue}
     */
    public JSONValue getValue() throws JSONException
    {
        JSONValue value = null;
        if (lastReportedEvent == null)
            next();

        while (lastReportedEvent.getEvent() != JSONEvent.EndJSON)
        {
            switch (lastReportedEvent.getEvent())
            {
            case StartObject:
                return readJSONObject(new JSONObject(), getDepth());
            case StartArray:
                return readJSONArray(new JSONArray(), getDepth());
            case String:
                return new JSONString(getText());
            case Integer:
                return new JSONInteger(getText());
            case Double:
                return new JSONDouble(getText());
            case Boolean:
                return new JSONBoolean(getText());
            case Null:
                return new JSONNull();
            default:
                next();
            }
        }
        throw new JSONException(JSONErrorCode.JSONValueIsNotFound);
    }

    private JSONObject readJSONObject(JSONObject jsonObject, int baseObjectDepth) throws JSONException
    {
        while (true)
        {
            JSONEvent event = next();
            switch (event)
            {
            case StartObject:
                jsonObject.put(getKeyName(), readJSONObject(new JSONObject(), getDepth()));
                break;
            case EndObject:
                if (getDepth() < baseObjectDepth)
                    return jsonObject;
                else
                    throw new JSONException(JSONErrorCode.ParseError);
            case StartArray:
                jsonObject.put(getKeyName(), readJSONArray(new JSONArray(), getDepth()));
                break;
            case EndArray:
                throw new JSONException(JSONErrorCode.NotInAJSONObject);
            case String:
            case Boolean:
            case Double:
            case Integer:
            case Null:
                jsonObject.put(getKeyName(), getValue());
                break;
            case EndJSON:
            default:
                throw new JSONException(JSONErrorCode.UnexpectedEndOfJSON);
            }
        }
    }

    private JSONArray readJSONArray(JSONArray jsonArray, int baseArrayDepth) throws JSONException
    {
        while (true)
        {
            JSONEvent event = next();
            switch (event)
            {
            case StartObject:
                jsonArray.add(readJSONObject(new JSONObject(), getDepth()));
                break;
            case EndObject:
                throw new JSONException(JSONErrorCode.ParseError);
            case StartArray:
                jsonArray.add(readJSONArray(new JSONArray(), getDepth()));
                break;
            case EndArray:
                if (getDepth() < baseArrayDepth)
                    return jsonArray;
                else
                    throw new JSONException(JSONErrorCode.ParseError);
            case String:
            case Boolean:
            case Double:
            case Integer:
            case Null:
                jsonArray.add(getValue());
                break;
            case EndJSON:
            default:
                throw new JSONException(JSONErrorCode.UnexpectedEndOfJSON);
            }
        }
    }

    /**
     * Reads the next {@link JSONEvent}
     * 
     * @return the next {@link JSONEvent}. If no more token is available,
     *         returns {@link JSONEvent#EndJSON}.
     * @throws JSONException
     *             when some syntax error is found.
     */
    public JSONEvent next() throws JSONException
    {
        Token token;
        while ((token = _lexer.nextToken()) != Token.EOF_TOKEN)
        {
            if (getCurrentParseState() == ParseState.KeyedValue)
            {
                keyStack.removeLast();
                popParseState();
                if (getCurrentParseState() == ParseState.Key)
                    popParseState();
                else
                    throw new JSONException(JSONErrorCode.ParseError);
            }

            int tokenType = token.getType();

            switch (tokenType)
            {
            case JSONLexer.LBrace:
                keyedValueTest();
                currentDepth++;
                pushParseState(ParseState.InObject);
                return reportEvent(token, JSONEvent.StartObject);
            case JSONLexer.RBrace:
                currentDepth--;
                validateParseState(ParseState.InObject);
                popParseState();
                popKeyStack();
                return reportEvent(token, JSONEvent.EndObject);
            case JSONLexer.LBracket:
                keyedValueTest();
                currentDepth++;
                pushParseState(ParseState.InArray);
                return reportEvent(token, JSONEvent.StartArray);
            case JSONLexer.RBracket:
                currentDepth--;
                validateParseState(ParseState.InArray);
                popParseState();
                popKeyStack();
                return reportEvent(token, JSONEvent.EndArray);
            case JSONLexer.Comma:
                validateParseState(ParseState.InArray, ParseState.InObject);
                continue;
            case JSONLexer.Colon:
                validateParseState(ParseState.Key); // next sequence will be a
                // keyed value
                continue;
            case JSONLexer.String:
                if (getCurrentParseState() == ParseState.InObject)
                {
                    // key
                    pushParseState(ParseState.Key);
                    keyStack.addLast(removeDoubleQuotation(token.getText()));
                    continue;
                }
                keyedValueTest();
                return reportEvent(token, JSONEvent.String);
            case JSONLexer.Integer:
                keyedValueTest();
                return reportEvent(token, JSONEvent.Integer);
            case JSONLexer.Double:
                keyedValueTest();
                return reportEvent(token, JSONEvent.Double);
            case JSONLexer.TRUE:
            case JSONLexer.FALSE:
                keyedValueTest();
                return reportEvent(token, JSONEvent.Boolean);
            case JSONLexer.NULL:
                keyedValueTest();
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
     * 
     * @return the current key, or null when the current token is no name array
     *         or object.
     * @throws JSONException
     */
    public String getKeyName() throws JSONException
    {
        if (keyStack.isEmpty())
            return null;
        else
            return keyStack.getLast();
    }

    public String getText()
    {
        if (lastReportedEvent.getEvent() == JSONEvent.String)
            return removeDoubleQuotation(lastReportedEvent.getToken().getText());
        else
            return lastReportedEvent.getToken().getText();
    }

    private static String removeDoubleQuotation(String text)
    {
        return text.substring(1, text.length() - 1);
    }

    public int getDepth()
    {
        return currentDepth;
    }

}

/**
 * A pull parser event
 * 
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
