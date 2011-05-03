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
// JSONObject.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONObject.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * JSONObject
 * 
 * @author leo
 * 
 */
public class JSONObject extends JSONValueBase
{

    @SuppressWarnings("serial")
    class JSONObjectContent extends LinkedHashMap<String, JSONValue>
    {
    }

    JSONObjectContent content = new JSONObjectContent();

    /**
     * 
     */
    public JSONObject() {

    }

    public JSONObject(String jsonStr) throws JSONException {
        new JSONPullParser(jsonStr).populateJSONObject(this);
    }

    public static JSONObject parse(String s) throws JSONException {
        return new JSONObject(s);
    }

    public JSONObject(List<JSONElement> elemList) {
        for (JSONElement e : elemList)
            put(e.getKey(), e.getValue());
    }

    public void put(String key, JSONValue obj) {
        content.put(key, obj);
    }

    public void put(String key, Object value) throws JSONException {
        content.put(key, translateAsJSONValue(value));
    }

    @Override
    public String toString() {
        return toJSONString();
    }

    @Override
    public String toJSONString() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        ArrayList<String> elementList = new ArrayList<String>();
        for (Iterator<Entry<String, JSONValue>> it = content.entrySet().iterator(); it.hasNext();) {
            Entry<String, JSONValue> entry = it.next();
            String jsonKey = "\"" + entry.getKey() + "\"";
            String jsonValue = (entry.getValue() == null) ? "null" : entry.getValue().toJSONString();
            elementList.add(jsonKey + ":" + jsonValue);
        }
        jsonBuilder.append(join(elementList, ","));
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public int elementSize() {
        return content.size();
    }

    public JSONValue get(String key) {
        return content.get(key);
    }

    public Set<String> keys() {
        return content.keySet();
    }

    public int getInt(String key) throws JSONException {
        JSONValue v = get(key);
        if (v == null)
            throw new JSONException(JSONErrorCode.KeyIsNotFound, key);

        JSONNumber n = v.getJSONNumber();
        if (n == null)
            throw new JSONException(JSONErrorCode.NotAJSONNumber, v.toString());

        return n.getIntValue();
    }

    public String getString(String key) throws JSONException {
        JSONValue v = get(key);
        if (v == null)
            throw new JSONException(JSONErrorCode.KeyIsNotFound, key);

        JSONString s = v.getJSONString();
        if (s == null)
            throw new JSONException(JSONErrorCode.NotAJSONString, v.toString());
        return s.getValue();
    }

    @Override
    public JSONObject getJSONObject() {
        return this;
    }

    public JSONArray getJSONArray(String key) {
        JSONValue v = get(key);
        if (v == null)
            return null;

        JSONArray a = v.getJSONArray();
        if (a == null)
            return null;
        return a;
    }

    public boolean hasKey(String key) {
        return content.containsKey(key);
    }

    public Map<String, JSONValue> getKeyValueMap() {
        return content;
    }

    public JSONObject getJSONObject(String key) throws JSONException {
        JSONValue v = get(key);
        if (v == null)
            throw new JSONException(JSONErrorCode.KeyIsNotFound, key);
        JSONObject o = v.getJSONObject();
        if (o == null)
            throw new JSONException(JSONErrorCode.NotAJSONObject, v.toString());
        return o;
    }

    public JSONValueType getValueType() {
        return JSONValueType.Object;
    }

    public void remove(String nodeName) {
        content.remove(nodeName);
    }
}
