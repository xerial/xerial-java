//--------------------------------------
// XerialJ Project
//
// JSONValueBase.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONValueBase.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import java.util.Collection;
import java.util.Iterator;

public class JSONValueBase implements JSONValue {

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
		return null;
	}

	public JSONObject getJSONObject() {
		return null;
	}

	public JSONString getJSONString() {
		return null;
	}

	
	public JSONValue translateAsJSONValue(Object value) throws JSONException
	{
		return JSONUtil.toJSONValue(value);
	}

	public String toJSONString() {
		return this.toString();
	}
	
    /**
     * Concatinates all elements in the given collection c into a single string with the separator
     * @param c a collection of elements to concatenate
     * @param concatinator a concatenator: ex. ", ", "." etc.  
     * @return a concatenated string
     */
    protected static String join(Collection c, String concatinator)
    {
        if(c == null)
            return "";
        int size = c.size();
        if(size == 0)
            return "";
        
        Iterator it = c.iterator();
        StringBuilder buf = new StringBuilder();    
        for(int i=0; it.hasNext() && i<size-1; i++)
        {
            Object data = it.next();
            buf.append(data.toString());
            buf.append(concatinator);
        }
        Object lastData = it.next();
        buf.append(lastData.toString());
        return buf.toString();
    }
}




