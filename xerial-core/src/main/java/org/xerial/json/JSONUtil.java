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

public class JSONUtil
{

    // non constractable
    private JSONUtil()
    {}

    public static JSONValue toJSONValue(Object value) throws JSONException
    {
        if (value == null)
            return new JSONNull();

        if (value instanceof JSONValue)
            return (JSONValue) value;
        else if (value instanceof String)
            return new JSONString((String) value);
        else if (value instanceof Integer)
            return new JSONInteger((Integer) value);
        else if (value instanceof Double)
            return new JSONDouble((Double) value);
        else if (value instanceof Float)
            return new JSONDouble((Float) value);
        else
            throw new JSONException(JSONErrorCode.CannotConvertToJSONValue, "cannot resolve " + value
                    + " type as JSONValue");

    }

    public static JSONValue parseJSON(String jsonObjectOrArray) throws JSONException
    {
        String json = jsonObjectOrArray.trim();
        if (json.startsWith("{"))
        {
            return new JSONObject(json);
        }
        else if (json.startsWith("["))
        {
            return new JSONArray(json);
        }
        else
            throw new JSONException(JSONErrorCode.InvalidJSONData, "json data must start with { or [");

    }

}
