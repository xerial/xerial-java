//--------------------------------------
// XerialJ Project
//
// JSONValue.java
// Since: Apr 4, 2007
//
// $Date: 2007-05-08 09:44:35 +0900 (Tue, 08 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONValue.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

public interface JSONValue {
	
	/**
	 * @return JSONString representation of this object if this instance is a JSONString, otherwise null
	 */
	public JSONString getJSONString();
	
	/**
	 * @return JSONNumber representation of this object if this instance is a JSONNumber, otherwise null
	 */
	public JSONNumber getJSONNumber();

	/**
	 * @return JSONObject representation of this object if this instance is a JSONSObject, otherwise null
	 */
	public JSONObject getJSONObject();
	
	/**
	 * @return JSONArray representation of this object if this instance is a JSONArray, otherwise null
	 */
	public JSONArray getJSONArray();

	/**
	 * @return JSONBoolean representation of this object if this instance is a JSONBoolean, otherwise null
	 */
	public JSONBoolean getJSONBoolean();

	/**
	 * @return JSONNull representation of this object if this instance is a JSONNull, otherwise null
	 */
	public JSONNull getJSONNull();
	
	public String toJSONString();
}




