//--------------------------------------
// XerialJ Project
//
// JSONInteger.java
// Since: 2007/04/27
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.json;

public class JSONInteger implements JSONNumber {

	int _value;
	
	public JSONInteger(String value)
	{
		_value = Integer.parseInt(value);
	}
	
	public JSONInteger(int value)
	{
		_value = value;
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

	public JSONNumber getJSONNumber() {
		return this;
	}

	public JSONObject getJSONObject() {
		return null;
	}

	public JSONString getJSONString() {
		return null;
	}


	public String toString()
	{
		return Integer.toString(_value);
	}
	
	public double getDoubleValue() {
		return (double) _value;
	}

	public int getIntValue() {
		return _value;
	}

	public String toJSONString() {
		return toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof JSONInteger)
		{
			return _value == ((JSONInteger) obj).getIntValue();
		}
		else
			return false;
	}


}




