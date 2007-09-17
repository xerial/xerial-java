//--------------------------------------
// XerialJ Project
//
// JSONNumber.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONNumber.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

public interface JSONNumber extends JSONValue 
{
	public double getDoubleValue();
	public int getIntValue();
	
	public String toString();

	public boolean equals(Object obj);

	public JSONNumber getJSONNumber();

}




