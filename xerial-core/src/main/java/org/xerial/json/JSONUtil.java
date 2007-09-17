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

public class JSONUtil {

	// non constractable
	private JSONUtil() {}
	
	public static JSONValue toJSONValue(Object value) throws JSONException
	{
		if(value == null)
			return new JSONNull();
		
		if(value instanceof JSONValue)
			return (JSONValue) value;
		else if(value instanceof String)
			return new JSONString((String) value);
		else if(value instanceof Integer)
			return new JSONInteger((Integer) value);
		else if(value instanceof Double)
			return new JSONDouble((Double) value);
		else if(value instanceof Float)
			return new JSONDouble((Float) value);
		else
			throw new JSONException("cannot resolve " + value + " type as JSONValue");
	
	}
	
	
}




