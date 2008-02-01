/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// XerialJ
//
// JSONLong.java
// Since: Feb 1, 2008 3:07:43 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

public class JSONLong implements JSONNumber
{
    long _value;

    public JSONLong(String value)
    {
        _value = Long.parseLong(value);
    }

    public JSONLong(long value)
    {
        _value = value;
    }

    public JSONArray getJSONArray()
    {
        return null;
    }

    public JSONBoolean getJSONBoolean()
    {
        return null;
    }

    public JSONNull getJSONNull()
    {
        return null;
    }

    public JSONNumber getJSONNumber()
    {
        return this;
    }

    public JSONObject getJSONObject()
    {
        return null;
    }

    public JSONString getJSONString()
    {
        return null;
    }

    public String toString()
    {
        return Long.toString(_value);
    }

    public double getDoubleValue()
    {
        return (double) _value;
    }

    public long getLongValue()
    {
        return _value;
    }

    public String toJSONString()
    {
        return toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof JSONLong)
        {
            return _value == ((JSONLong) obj).getLongValue();
        }
        else
            return false;
    }

    public JSONValueType getValueType()
    {
        return JSONValueType.Integer;
    }

    public int getIntValue()
    {
        return (int) _value;
    }

}
