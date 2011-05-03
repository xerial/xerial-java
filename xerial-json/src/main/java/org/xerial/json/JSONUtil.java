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
// JSONUtil.java
// Since: May 18, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONUtil.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.xerial.util.TypeInfo;
import org.xerial.util.lens.ObjectLens;
import org.xerial.util.lens.impl.ParameterGetter;

public class JSONUtil
{

    // non constractable
    private JSONUtil() {}

    /**
     * Convert a given object into JSON
     * 
     * @param obj
     * @return
     */
    public static String toJSON(Object obj) {
        if (obj == null)
            return "null";

        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c)) {
            if (c == String.class)
                return JSONString.toJSONString(obj.toString());
            else
                return obj.toString();
        }

        StringWriter buf = new StringWriter();
        JSONWriter json = new JSONWriter(buf);

        toJSON(json, obj);

        json.flush();
        return buf.toString();
    }

    private static void toJSON(JSONWriter json, Object obj) {
        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c)) {
            json.addObject(obj);
            return;
        }

        ObjectLens lens = ObjectLens.getObjectLens(obj.getClass());

        if (TypeInfo.isCollection(c)) {
            Collection< ? > collection = (Collection< ? >) obj;
            boolean hasAttributes = lens.hasAttributes();

            boolean bracketIsOpen = false;

            if (hasAttributes) {
                json.startObject();
                outputParemters(json, obj);

                if (!collection.isEmpty()) {
                    json.startArray("entry");
                    bracketIsOpen = true;
                }
            }
            else {
                json.startArray();
                bracketIsOpen = true;
            }

            for (Object elem : collection) {
                toJSON(json, elem);
            }

            if (bracketIsOpen)
                json.endArray();

            if (hasAttributes)
                json.endObject();

        }
        else if (TypeInfo.isMap(c)) {
            Map< ? , ? > map = (Map< ? , ? >) obj;
            boolean hasAttributes = lens.hasAttributes();

            if (hasAttributes) {
                json.startObject();
                outputParemters(json, obj);

                if (!map.isEmpty())
                    json.startArray("entry");
            }
            else if (!map.isEmpty())
                json.startArray();

            for (Entry< ? , ? > each : map.entrySet()) {
                json.startObject();
                json.putObject("key", each.getKey());
                json.putObject("value", each.getValue());
                json.endObject();
            }

            if (!map.isEmpty())
                json.endArray();

            if (hasAttributes)
                json.endObject();
        }
        else {
            if (!lens.getGetterContainer().isEmpty()) {
                json.startObject();
                outputParemters(json, obj);
                json.endObject();
            }
            else {
                // empty getter object. try toString()
                json.startString();
                json.append(obj.toString());
                json.endString();
            }
        }
    }

    private static void outputParemters(JSONWriter json, Object obj) {
        ObjectLens lens = ObjectLens.getObjectLens(obj.getClass());
        for (ParameterGetter getter : lens.getGetterContainer()) {
            json.putObject(getter.getCanonicalParamName(), getter.get(obj));
        }
    }

    public static JSONValue toJSONValue(Object value) throws JSONException {
        if (value == null)
            return new JSONNull();

        if (value instanceof JSONValue)
            return (JSONValue) value;
        else if (value instanceof String)
            return new JSONString((String) value);
        else if (value instanceof Integer)
            return new JSONInteger((Integer) value);
        else if (value instanceof Long)
            return new JSONLong((Long) value);
        else if (value instanceof Double)
            return new JSONDouble((Double) value);
        else if (value instanceof Boolean)
            return new JSONBoolean((Boolean) value);
        else if (value instanceof Float)
            return new JSONDouble((Float) value);
        else
            throw new JSONException(JSONErrorCode.CannotConvertToJSONValue, "cannot resolve " + value
                    + " type as JSONValue");

    }

    public static JSONValue parseJSON(String jsonObjectOrArray) throws JSONException {
        String json = jsonObjectOrArray.trim();
        if (json.startsWith("{")) {
            return JSONObject.parse(json);
        }
        else if (json.startsWith("[")) {
            return new JSONArray(json);
        }
        else
            throw new JSONException(JSONErrorCode.InvalidJSONData, "json data must start with { or [");

    }

}
