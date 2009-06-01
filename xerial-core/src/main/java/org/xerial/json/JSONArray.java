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
// JSONArray.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONArray.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.xerial.json.impl.JSONLexer;
import org.xerial.json.impl.JSONParser;
import org.xerial.json.impl.JSONTokenizer;

public class JSONArray extends JSONValueBase implements Iterable<JSONValue>
{

    private ArrayList<JSONValue> _array = new ArrayList<JSONValue>();

    public JSONArray()
    {}

    public JSONArray(List<JSONValue> elemList)
    {
        for (JSONValue v : elemList)
            _array.add(v);
    }

    public JSONArray(JSONTokenizer tokenizer) throws JSONException
    {
        char c = tokenizer.nextClean();
        char q;
        if (c == '[')
        {
            q = ']';
        }
        else if (c == '(')
        {
            q = ')';
        }
        else
        {
            throw tokenizer.syntaxError("A JSONArray text must start with '['");
        }
        if (tokenizer.nextClean() == ']')
        {
            return;
        }
        tokenizer.back();
        for (;;)
        {
            if (tokenizer.nextClean() == ',')
            {
                tokenizer.back();
                _array.add(null);
            }
            else
            {
                tokenizer.back();
                _array.add(tokenizer.nextValue());
            }
            c = tokenizer.nextClean();
            switch (c)
            {
            case ';':
            case ',':
                if (tokenizer.nextClean() == ']')
                {
                    return;
                }
                tokenizer.back();
                break;
            case ']':
            case ')':
                if (q != c)
                {
                    throw tokenizer.syntaxError("Expected a '" + new Character(q) + "'");
                }
                return;
            default:
                throw tokenizer.syntaxError("Expected a ',' or ']'");
            }
        }
    }

    public JSONArray(String jsonStr) throws JSONException
    {
        this(new JSONTokenizer(jsonStr));
    }

    public static CommonTree parse(String jsonStr) throws JSONException
    {
        JSONLexer lexer = new JSONLexer(new ANTLRStringStream(jsonStr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        try
        {
            JSONParser.jsonArray_return r = parser.jsonArray();
            return (CommonTree) r.getTree();
        }
        catch (RecognitionException e)
        {
            throw new JSONException(JSONErrorCode.InvalidJSONData, jsonStr + ": line=" + e.line + "("
                    + e.charPositionInLine + ")");
        }
    }

    public void add(JSONValue value)
    {
        _array.add(value);
    }

    public void add(Object value) throws JSONException
    {
        _array.add(translateAsJSONValue(value));
    }

    public void add(String value)
    {
        _array.add(new JSONString(value));
    }

    public int size()
    {
        return _array.size();
    }

    public JSONValue get(int index)
    {
        return _array.get(index);
    }

    public JSONNumber getJSONNubmer(int index)
    {
        return _array.get(index).getJSONNumber();
    }

    public JSONInteger getJSONInteger(int index)
    {
        JSONNumber n = _array.get(index).getJSONNumber();
        if (n != null && n instanceof JSONInteger)
            return (JSONInteger) n;
        else
            return null;
    }

    public JSONDouble getJSONDouble(int index)
    {
        JSONNumber n = _array.get(index).getJSONNumber();
        if (n != null && n instanceof JSONDouble)
            return (JSONDouble) n;
        else
            return null;
    }

    public JSONObject getJSONObject(int index)
    {
        return _array.get(index).getJSONObject();
    }

    @Override
    public JSONArray getJSONArray()
    {
        return this;
    }

    public JSONArray getJSONArray(int i)
    {
        JSONValue v = get(i);
        if (v instanceof JSONArray)
            return (JSONArray) v;
        else
            return null;
    }

    public JSONBoolean getJSONBoolean(int index)
    {
        return _array.get(index).getJSONBoolean();
    }

    public JSONNull getJSONNull(int index)
    {
        return _array.get(index).getJSONNull();
    }

    public Iterator<JSONValue> iterator()
    {
        return _array.iterator();
    }

    public String toString()
    {
        return toJSONString();
    }

    public String toJSONString()
    {
        StringBuilder out = new StringBuilder();
        out.append("[");
        ArrayList<String> elemString = new ArrayList<String>();
        for (JSONValue e : _array)
            elemString.add(e.toJSONString());
        out.append(join(elemString, ","));
        out.append("]");
        return out.toString();
    }

    public String getString(int i)
    {
        return get(i).toString();
    }

    public JSONValueType getValueType()
    {
        return JSONValueType.Array;
    }

}
