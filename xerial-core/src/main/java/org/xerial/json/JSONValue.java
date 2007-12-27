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
	
	/**
	 * Produces output of the JSON format of this value 
	 * @return the JSON output
	 */
	public String toJSONString();
	
	/**
	 * Gets the JSON value type of this value 
	 * @return the {@link JSONValueType}
	 */
	public JSONValueType getValueType();
}




