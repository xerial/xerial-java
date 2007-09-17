//--------------------------------------
// XerialJ Project
//
// JSONString.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONString.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;


public class JSONString extends JSONValueBase {

	private String s;
	public JSONString() {}
	public JSONString(String s)
	{
		this.s = s;
	}
	
	public String toString()
	{
		return s;
	}
	
	public String toJSONString()
	{
		return "\"" + s + "\"";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JSONString) {
			return s.equals(((JSONString) obj).s);
		}
		return false;
	}
	
	@Override
	public JSONString getJSONString() {
		return this;
	}
	
	public String getValue()
	{
		return s;
	}
}




