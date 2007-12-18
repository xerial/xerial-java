//--------------------------------------
// XerialJ Project
//
// JSONObject.java
// Since: Apr 4, 2007
//
// $Date: 2007-05-17 23:24:25 +0900 (Thu, 17 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONObject.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;



public class JSONObject extends JSONValueBase {

	@SuppressWarnings("serial")
	class JSONObjectContent extends LinkedHashMap<String, JSONValue> 
	{}
	
	JSONObjectContent content = new JSONObjectContent();
	
	/**
	 * 
	 */
	public JSONObject() {
		
	}

	public JSONObject(String jsonStr) throws JSONException
	{
		try {
			CommonTree t = parse(jsonStr);
			CommonTreeNodeStream ts = new CommonTreeNodeStream(t);
			JSONWalker walker = new JSONWalker(ts);
			JSONObject obj = walker.jsonObject();
			this.content = obj.content;
		} catch (RecognitionException e) {
			throw new JSONException(JSONErrorCode.InvalidJSONData, jsonStr + ": line=" + e.line + "(" + e.charPositionInLine + ")");
		}
	}
	
	/*
	public static JSONObject convertXMLtoJSONObject(Reader xmlReader)
	{
	    JSONObject result = new JSONObject();
	    try
        {
            XmlPullParser parser = PullParserUtil.newParser(xmlReader);
            
            LinkedList<JSONObject> objectStack = new LinkedList<JSONObject>();
            objectStack.add(result);
            JSONObject currentJSONObject = objectStack.getLast();
            
            boolean firstTagIsFound = false;
            int state;
            while((state = parser.next()) != XmlPullParser.END_DOCUMENT)
            {
                switch(state)
                {
                case XmlPullParser.START_TAG:
                    if(firstTagIsFound)
                    {
                        JSONObject childObject = new JSONObject();
                        objectStack.add(childObject);
                        currentJSONObject = childObject;
                    }
                    else
                    {
                        firstTagIsFound = true;
                    }
                    // parse attributes
                    for(int i=0; i<parser.getAttributeCount(); i++)
                    {
                        String attribName = parser.getAttributeName(i);
                        String attribValue = parser.getAttributeValue(i);
                        currentJSONObject.put(attribName, attribValue);
                    }
                    break;

                    
                    
                }
            }
            
            
        }
        catch (XMLParserException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (XmlPullParserException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    return null;
	}
	*/
	
	
	public static CommonTree parse(String jsonStr) throws JSONException
	{
		JSONLexer lexer = new JSONLexer(new ANTLRStringStream(jsonStr));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JSONParser parser = new JSONParser(tokens);
		
		try {
			JSONParser.jsonObject_return r = parser.jsonObject();
			return (CommonTree) r.getTree();
		} catch (RecognitionException e) {
			throw new JSONException(JSONErrorCode.InvalidJSONData, jsonStr + ": line=" + e.line + "(" + e.charPositionInLine + ")");
		}
	}
	
	JSONObject(List<JSONElement> elemList)
	{
		for(JSONElement e : elemList)
			put(e.getKey(), e.getValue());
	}
	
	
	public void put(String key, JSONValue obj)
	{
		content.put(key, obj);
	}
	
	public void put(String key, Object value) throws JSONException
	{
		content.put(key, translateAsJSONValue(value));
	}
	
	public String toString() 
	{
		return toJSONString();
	}
	
	public String toJSONString()
	{
		StringBuilder jsonBuilder = new StringBuilder();
		jsonBuilder.append("{");
		ArrayList<String> elementList = new ArrayList<String>();
		for(Iterator<Entry<String, JSONValue>> it = content.entrySet().iterator(); it.hasNext(); )
		{
			Entry<String, JSONValue> entry = it.next();
			String jsonKey = "\"" + entry.getKey() + "\"";
			String jsonValue = (entry.getValue() == null)? "null" : entry.getValue().toJSONString();
			elementList.add(jsonKey + ":" + jsonValue);
		}
		jsonBuilder.append(join(elementList, ","));
		jsonBuilder.append("}");
		return jsonBuilder.toString();
	}

	public int elementSize() {
		return content.size();
	}

	public JSONValue get(String key) {
		return content.get(key);
	}

	public Set<String> keys() {
		return content.keySet();
	}

	public int getInt(String key) throws JSONException {
		JSONValue v = get(key);
		if(v == null)
			throw new JSONException(JSONErrorCode.KeyIsNotFound, key);
		
		JSONNumber n = v.getJSONNumber();
		if(n == null)
			throw new JSONException(JSONErrorCode.NotAJSONNumber, n);
		
		return n.getIntValue();
	}
	
	public String getString(String key) throws JSONException
	{
		JSONValue v = get(key);
		if(v == null)
			throw new JSONException(JSONErrorCode.KeyIsNotFound, key);
		
		JSONString s = v.getJSONString();
		if(s == null)
			throw new JSONException(JSONErrorCode.NotAJSONString, v);
		return s.getValue();
	}

	@Override
	public JSONObject getJSONObject() {
		return this;
	}

	public JSONArray getJSONArray(String key) {
		JSONValue v = get(key);
		if(v == null)
			return null;
		
		JSONArray a = v.getJSONArray();
		if(a == null)
			return null;
		return a;
	}

	public boolean hasKey(String key) {
		return content.containsKey(key);
	}
	
	
	public Map<String, JSONValue> getKeyValueMap()
	{
		return content;
	}

	public JSONObject getJSONObject(String key) throws JSONException {
		JSONValue v = get(key);
		if(v == null)
			throw new JSONException(JSONErrorCode.KeyIsNotFound, key);
		JSONObject o = v.getJSONObject();
		if(o == null)
			throw new JSONException(JSONErrorCode.NotAJSONObject, v);
		return o;
	}
}




