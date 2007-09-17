//--------------------------------------
// XerialJ Project
//
// JSONDouble.java
// Since: Apr 27, 2007
//
// $Date: 2007-05-01 08:19:31 +0900 (Tue, 01 May 2007) $
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
}




