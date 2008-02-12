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
// JSONDouble.java
// Since: Apr 27, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONDouble.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

public class JSONDouble implements JSONNumber {

	private double _value;
	public JSONDouble(double value)
	{
		_value = value;
	}
	
	public JSONDouble(String value)
	{
		_value = Double.parseDouble(value);
	}
	
	public double getDoubleValue() {
		return _value;
	}

	public int getIntValue() {
		return (int) _value;
	}

	public JSONNumber getJSONNumber() {
		return this;
	}

	public JSONArray getJSONArray() {
		return null;
	}

	public JSONBoolean getJSONBoolean() {
		return null;
	}

	public JSONNull getJSONNull() {
		return null;
	}

	public JSONObject getJSONObject() {
		return null;
	}

	public JSONString getJSONString() {
		return null;
	}

	public String toString()
	{
		return Double.toString(_value);
	}
	
	public String toJSONString() {
		return toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof JSONDouble)
		{
			return _value == ((JSONDouble) obj).getDoubleValue();
		}
		else
			return false;
	}

    public JSONValueType getValueType()
    {
        return JSONValueType.Double;
    }
}




