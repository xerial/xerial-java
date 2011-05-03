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

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.json.JSONLexer.Token;
import org.xerial.json.impl.JSONToken;
import org.xerial.util.ArrayDeque;
import org.xerial.util.log.Logger;

/**
 * Pull Parser for JSON data
 * 
 * @author leo
 * 
 */
public class JSONPullParser {
    private static enum ParseState {
        Root, InObject, InArray, Key, KeyedValue
    }

    private static Logger _logger = Logger.getLogger(JSONPullParser.class);
    private JSONLexer _lexer;

    private ArrayDeque<ParseState> parseStateStack = new ArrayDeque<ParseState>();
    private ArrayDeque<String> keyStack = new ArrayDeque<String>();

    private JSONPullParserEvent lastReportedEvent = null;
    private int currentDepth = 0;

    public JSONPullParser(String jsonString) {
        _lexer = new JSONLexer(jsonString);
        init();
    }

    public JSONPullParser(InputStream jsonStream) throws IOException {
        _lexer = new JSONLexer(jsonStream);
        init();
    }

    public JSONPullParser(Reader jsonReader) throws IOException {
        _lexer = new JSONLexer(jsonReader);
        init();
    }

    public JSONPullParser(JSONObject jsonObject) {
        this(jsonObject.toJSONString());
    }

    private void init() {
        parseStateStack.clear();
        keyStack.clear();

        lastReportedEvent = null;
        currentDepth = 0;

        parseStateStack.addLast(ParseState.Root);
    }

    private ParseState getCurrentParseState() {
        return parseStateStack.getLast();
    }

    private void validateParseState(ParseState... possibleParseState) throws JSONException {
        ParseState current = getCurrentParseState();
        for (ParseState ps : possibleParseState) {
            if (ps == current)
                return;
        }
        throw new JSONException(JSONErrorCode.InvalidJSONData, "invalid parse state: "
                + current.name() + " line = " + _lexer.getLineNumber());
    }

    private void popKeyStack() {
        if (getCurrentParseState() == ParseState.Key)
            keyStack.removeLast();
    }

    private void pushParseState(ParseState ps) {
        parseStateStack.addLast(ps);
        // _logger.trace("push: " + StringUtil.join(parseStateStack, ", "));
    }

    private void popParseState() {
        parseStateStack.removeLast();
        // _logger.trace("pop : " + StringUtil.join(parseStateStack, ", "));
    }

    private void valueWithKeyTest() {
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
    public JSONValue getValue() throws JSONException {
        if (lastReportedEvent == null)
            next();

        while (lastReportedEvent.getEvent() != JSONEvent.EndJSON) {
            switch (lastReportedEvent.getEvent()) {
            case String:
                return new JSONString(getText());
            case Integer:
                return new JSONInteger(getText());
            case Double:
                return new JSONDouble(getText());
            case True:
                return JSONBoolean.True;
            case False:
                return JSONBoolean.False;
            case Null:
                return JSONNull.NULL;
            case StartObject:
                return readJSONObject(new JSONObject(), getDepth());
            case StartArray:
                return readJSONArray(new JSONArray(), getDepth());
            default:
                next();
            }
        }
        throw new JSONException(JSONErrorCode.JSONValueIsNotFound);
    }

    /**
     * Reads the current JSONValue as String data
     * 
     * @return
     * @throws JSONException
     */
    public String getValueAsText() throws JSONException {
        if (lastReportedEvent == null)
            next();

        while (lastReportedEvent.getEvent() != JSONEvent.EndJSON) {
            switch (lastReportedEvent.getEvent()) {
            case String:
            case Integer:
            case Double:
                return getText();
            case True:
                return "true";
            case False:
                return "false";
            case Null:
                return "null";
            case StartObject:
                return readJSONObject(new JSONObject(), getDepth()).toJSONString();
            case StartArray:
                return readJSONArray(new JSONArray(), getDepth()).toJSONString();
            default:
                next();
            }
        }
        throw new JSONException(JSONErrorCode.JSONValueIsNotFound);

    }

    public void populateJSONObject(JSONObject obj) throws JSONException {
        if (lastReportedEvent == null)
            next();

        if (lastReportedEvent.getEvent() != JSONEvent.StartObject)
            throw new JSONException(JSONErrorCode.InvalidJSONData);

        readJSONObject(obj, getDepth());
    }

    public void populateJSONArray(JSONArray array) throws JSONException {
        if (lastReportedEvent == null)
            next();

        if (lastReportedEvent.getEvent() != JSONEvent.StartArray)
            throw new JSONException(JSONErrorCode.InvalidJSONData);

        readJSONArray(array, getDepth());
    }

    JSONObject readJSONObject(JSONObject jsonObject, int baseObjectDepth) throws JSONException {
        while (true) {
            JSONEvent event = next();
            switch (event) {
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
            case True:
                jsonObject.put(getKeyName(), JSONBoolean.True);
                break;
            case False:
                jsonObject.put(getKeyName(), JSONBoolean.False);
                break;
            case Null:
                jsonObject.put(getKeyName(), JSONNull.NULL);
                break;
            case String:
            case Double:
            case Integer:
                jsonObject.put(getKeyName(), getValue());
                break;
            case EndJSON:
            default:
                throw new JSONException(JSONErrorCode.UnexpectedEndOfJSON);
            }
        }
    }

    private JSONArray readJSONArray(JSONArray jsonArray, int baseArrayDepth) throws JSONException {
        while (true) {
            JSONEvent event = next();
            switch (event) {
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
            case True:
                jsonArray.add(JSONBoolean.True);
                break;
            case False:
                jsonArray.add(JSONBoolean.False);
                break;
            case Null:
                jsonArray.add(JSONNull.NULL);
                break;
            case String:
            case Double:
            case Integer:
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
    public JSONEvent next() throws JSONException {

        try {
            for (Token token = null; (token = _lexer.nextToken()) != null;) {
                if (getCurrentParseState() == ParseState.KeyedValue) {
                    keyStack.removeLast();
                    popParseState();
                    if (getCurrentParseState() == ParseState.Key)
                        popParseState();
                    else
                        throw new JSONException(JSONErrorCode.ParseError);
                }

                JSONToken tokenType = token.type;

                switch (tokenType) {
                case LBrace:
                    valueWithKeyTest();
                    currentDepth++;
                    pushParseState(ParseState.InObject);
                    return reportEvent(token, JSONEvent.StartObject);
                case RBrace:
                    currentDepth--;
                    validateParseState(ParseState.InObject);
                    popParseState();
                    popKeyStack();
                    return reportEvent(token, JSONEvent.EndObject);
                case LBracket:
                    valueWithKeyTest();
                    currentDepth++;
                    pushParseState(ParseState.InArray);
                    return reportEvent(token, JSONEvent.StartArray);
                case RBracket:
                    currentDepth--;
                    validateParseState(ParseState.InArray);
                    popParseState();
                    popKeyStack();
                    return reportEvent(token, JSONEvent.EndArray);
                case Comma:
                    validateParseState(ParseState.InArray, ParseState.InObject);
                    continue;
                case Colon:
                    validateParseState(ParseState.Key); // next sequence will be a
                    // keyed value
                    continue;
                case String:
                    if (getCurrentParseState() == ParseState.InObject) {
                        // key
                        pushParseState(ParseState.Key);
                        keyStack.addLast(unescapeString(token.str));
                        continue;
                    }
                    valueWithKeyTest();
                    return reportEvent(token, JSONEvent.String);
                case Integer:
                    valueWithKeyTest();
                    return reportEvent(token, JSONEvent.Integer);
                case Double:
                    valueWithKeyTest();
                    return reportEvent(token, JSONEvent.Double);
                case True:
                    valueWithKeyTest();
                    return reportEvent(token, JSONEvent.True);
                case False:
                    valueWithKeyTest();
                    return reportEvent(token, JSONEvent.False);
                case Null:
                    valueWithKeyTest();
                    return reportEvent(token, JSONEvent.Null);
                }
            }
        }
        catch (JSONException e) {
            throw e;
        }
        catch (XerialException e) {
            XerialErrorCode code = e.getErrorCode();
            switch (code) {
            case PARSE_ERROR:
                throw new JSONException(JSONErrorCode.ParseError, e);
            default:
                throw new JSONException(JSONErrorCode.Inherited, e);
            }
        }

        return JSONEvent.EndJSON;
    }

    protected JSONEvent reportEvent(Token token, JSONEvent e) {
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
    public String getKeyName() throws JSONException {
        if (keyStack.isEmpty())
            return null;
        else
            return keyStack.getLast();
    }

    public String getText() {
        switch (lastReportedEvent.getEvent()) {
        case String:
            return unescapeString(lastReportedEvent.getToken().str);
        case True:
            return "true";
        case False:
            return "false";
        case Null:
            return "null";
        default:
            return lastReportedEvent.getToken().str;
        }
    }

    private static String unescapeString(String text) {
        if (text == null)
            return null;

        int i = 0;
        int len = text.length();
        if (text.charAt(i) == '"') {
            i++;
            len -= 1;
        }
        StringBuilder buf = new StringBuilder(len);
        for (; i < len; ++i) {
            char c = text.charAt(i);
            if (c == '\\' && i + 1 < len) {
                char escapeChar = text.charAt(i + 1);
                switch (escapeChar) {
                case '\\':
                    buf.append('\\');
                    break;
                case 'b':
                    buf.append('\b');
                    break;
                case 'f':
                    buf.append('\f');
                    break;
                case 'n':
                    buf.append('\n');
                    break;
                case 'r':
                    buf.append('\r');
                    break;
                case 't':
                    buf.append('\t');
                    break;
                case 'u':
                    if (i + 4 < len) {
                        String hex = text.substring(i + 1, i + 5);
                        int code = Integer.parseInt(hex, 16);
                        buf.append((char) code);
                        i += 3;
                    }
                    break;
                }
                i++;
            }
            else
                buf.append(c);
        }
        return buf.toString();
    }

    public int getDepth() {
        return currentDepth;
    }

}

/**
 * A pull parser event
 * 
 * @author leo
 * 
 */
class JSONPullParserEvent {
    private Token t;
    private JSONEvent event;

    public JSONPullParserEvent(Token t, JSONEvent event) {
        this.t = t;
        this.event = event;
    }

    public Token getToken() {
        return t;
    }

    public void setToken(Token t) {
        this.t = t;
    }

    public JSONEvent getEvent() {
        return event;
    }

    public void setEvent(JSONEvent event) {
        this.event = event;
    }
}
