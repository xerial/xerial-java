//--------------------------------------
// XerialJ Project
//
// JSONBoolean.java
// Since: Apr 4, 2007
//
// $Date: 2007-05-01 08:19:31 +0900 (Tue, 01 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONBoolean.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

public class JSONBoolean extends JSONValueBase {
	
	private boolean _value;
	
	public JSONBoolean(boolean b)
	{
		this._value = b; 
	}
	
	public JSONBoolean(String text)
    {
	    if(text.equals("true"))
	        this._value = true;
	    else
	        this._value = false;
    }

    public boolean getValue()
	{
		return _value;
	}
	
	public String toString() 
	{
		return _value ? "true" : "false"; 
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof JSONBoolean))
			return false;
		
		return getValue() == ((JSONBoolean) o).getValue();
	}
	
	@Override
	public JSONBoolean getJSONBoolean() {
		return this;
	}
}




