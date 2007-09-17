//--------------------------------------
// XerialJ Project
//
// JSONElement.java
// Since: Apr 26, 2007
//
// $Date: 2007-05-01 08:19:31 +0900 (Tue, 01 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONElement.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

class JSONElement {
	String key;
	JSONValue value;
	
	public JSONElement(String key, JSONValue value)
	{
		this.key = key; this.value = value;
	}
	
	public String getKey() { return key; }
	public JSONValue getValue() { return value; }
	
}




