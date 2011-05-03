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

public class JSONArray extends JSONValueBase implements Iterable<JSONValue>
{

    private final ArrayList<JSONValue> _array = new ArrayList<JSONValue>();

    public JSONArray() {}

    public JSONArray(List<JSONValue> elemList) {
        _array.ensureCapacity(elemList.size());
        for (JSONValue v : elemList)
            _array.add(v);
    }

    JSONArray(JSONPullParser parser) throws JSONException {
        JSONEvent e = parser.next();
        if (e != JSONEvent.StartArray)
            throw new JSONException(JSONErrorCode.ParseError, "expected [, but " + e);

        parseArray(this, parser);
    }

    private static JSONArray parseArray(JSONArray array, JSONPullParser parser) throws JSONException {
        JSONEvent e;

        while ((e = parser.next()) != JSONEvent.EndJSON) {
            switch (e) {
            case Integer:
            case Double:
            case Null:
            case True:
            case False:
            case String:
                array.add(parser.getValue());
                break;
            case StartObject:
                array.add(parseObject(parser));
                break;
            case EndObject:
                break;
            case StartArray:
                array.add(parseArray(new JSONArray(), parser));
                break;
            case EndArray:
                return array;
            }

        }

        return array;

    }

    private static JSONObject parseObject(JSONPullParser parser) throws JSONException {
        JSONEvent e = parser.next();

        JSONObject obj = new JSONObject();

        while ((e = parser.next()) != JSONEvent.EndJSON) {
            switch (e) {
            case Integer:
            case Double:
            case True:
            case False:
            case Null:
            case String:
                String key = parser.getKeyName();

                // if first child element is value attribute
                if (key != null) {
                    obj.put(key, parser.getValue());
                }
                break;
            case StartObject:
                obj.put(parser.getKeyName(), parseObject(parser));
                break;
            case EndObject:
                return obj;
            case StartArray:
                obj.put(parser.getKeyName(), parseArray(new JSONArray(), parser));
                break;
            case EndArray:
                break;
            }

        }
        return obj;

    }

    public JSONArray(String jsonStr) throws JSONException {
        new JSONPullParser(jsonStr).populateJSONArray(this);
    }

    public void add(JSONValue value) {
        _array.add(value);
    }

    public void add(Object value) throws JSONException {
        _array.add(translateAsJSONValue(value));
    }

    public void add(String value) {
        _array.add(new JSONString(value));
    }

    public int size() {
        return _array.size();
    }

    public JSONValue get(int index) {
        return _array.get(index);
    }

    public JSONNumber getJSONNubmer(int index) {
        return _array.get(index).getJSONNumber();
    }

    public JSONInteger getJSONInteger(int index) {
        JSONNumber n = _array.get(index).getJSONNumber();
        if (n != null && n instanceof JSONInteger)
            return (JSONInteger) n;
        else
            return null;
    }

    public JSONDouble getJSONDouble(int index) {
        JSONNumber n = _array.get(index).getJSONNumber();
        if (n != null && n instanceof JSONDouble)
            return (JSONDouble) n;
        else
            return null;
    }

    public JSONObject getJSONObject(int index) {
        return _array.get(index).getJSONObject();
    }

    @Override
    public JSONArray getJSONArray() {
        return this;
    }

    public JSONArray getJSONArray(int i) {
        JSONValue v = get(i);
        if (v instanceof JSONArray)
            return (JSONArray) v;
        else
            return null;
    }

    public JSONBoolean getJSONBoolean(int index) {
        return _array.get(index).getJSONBoolean();
    }

    public JSONNull getJSONNull(int index) {
        return _array.get(index).getJSONNull();
    }

    public Iterator<JSONValue> iterator() {
        return _array.iterator();
    }

    @Override
    public String toString() {
        return toJSONString();
    }

    @Override
    public String toJSONString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        ArrayList<String> elemString = new ArrayList<String>();
        for (JSONValue e : _array)
            elemString.add(e.toJSONString());
        out.append(join(elemString, ","));
        out.append("]");
        return out.toString();
    }

    public String getString(int i) {
        return get(i).toString();
    }

    public JSONValueType getValueType() {
        return JSONValueType.Array;
    }

}
