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
// JSONObject.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONObject.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * JSONObject
 * 
 * @author leo
 * 
 */
public class JSONObject extends JSONValueBase
{

    @SuppressWarnings("serial")
    class JSONObjectContent extends LinkedHashMap<String, JSONValue>
    {
    }

    JSONObjectContent content = new JSONObjectContent();

    /**
     * 
     */
    public JSONObject() {

    }

    public JSONObject(JSONTokenizer x) throws JSONException {
        this();
        char c;
        String key;

        if (x.nextClean() != '{') {
            throw x.syntaxError("A JSONObject text must begin with '{'");
        }
        for (;;) {
            c = x.nextClean();
            switch (c) {
            case 0:
                throw x.syntaxError("A JSONObject text must end with '}'");
            case '}':
                return;
            default:
                x.back();
                key = x.nextValue().toString();
            }

            /*
             * The key is followed by ':'. We will also tolerate '=' or '=>'.
             */

            c = x.nextClean();
            if (c == '=') {
                if (x.next() != '>') {
                    x.back();
                }
            }
            else if (c != ':') {
                throw x.syntaxError("Expected a ':' after a key");
            }
            put(key, x.nextValue());

            /*
             * Pairs are separated by ','. We will also tolerate ';'.
             */

            switch (x.nextClean()) {
            case ';':
            case ',':
                if (x.nextClean() == '}') {
                    return;
                }
                x.back();
                break;
            case '}':
                return;
            default:
                throw x.syntaxError("Expected a ',' or '}'");
            }
        }
    }

    public JSONObject(String jsonStr) throws JSONException {
        this(new JSONTokenizer(jsonStr));
        //    	
        //    	
        //        try {
        //            CommonTree t = parse(jsonStr);
        //            CommonTreeNodeStream ts = new CommonTreeNodeStream(t);
        //            JSONWalker walker = new JSONWalker(ts);
        //            JSONObject obj = walker.jsonObject();
        //            this.content = obj.content;
        //        }
        //        catch (RecognitionException e) {
        //            throw new JSONException(JSONErrorCode.InvalidJSONData, jsonStr + ": line=" + e.line
        //                    + "(" + e.charPositionInLine + ")");
        //        }
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

    //    public static CommonTree parse(String jsonStr) throws JSONException {
    //        JSONLexer lexer = new JSONLexer(new ANTLRStringStream(jsonStr));
    //        CommonTokenStream tokens = new CommonTokenStream(lexer);
    //        JSONParser parser = new JSONParser(tokens);
    //
    //        try {
    //            JSONParser.jsonObject_return r = parser.jsonObject();
    //            return (CommonTree) r.getTree();
    //        }
    //        catch (RecognitionException e) {
    //            throw new JSONException(JSONErrorCode.InvalidJSONData, jsonStr + ": line=" + e.line
    //                    + "(" + e.charPositionInLine + ")");
    //        }
    //    }

    public JSONObject(List<JSONElement> elemList) {
        for (JSONElement e : elemList)
            put(e.getKey(), e.getValue());
    }

    public void put(String key, JSONValue obj) {
        content.put(key, obj);
    }

    public void put(String key, Object value) throws JSONException {
        content.put(key, translateAsJSONValue(value));
    }

    @Override
    public String toString() {
        return toJSONString();
    }

    @Override
    public String toJSONString() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        ArrayList<String> elementList = new ArrayList<String>();
        for (Iterator<Entry<String, JSONValue>> it = content.entrySet().iterator(); it.hasNext();) {
            Entry<String, JSONValue> entry = it.next();
            String jsonKey = "\"" + entry.getKey() + "\"";
            String jsonValue = (entry.getValue() == null) ? "null" : entry.getValue().toJSONString();
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
        if (v == null)
            throw new JSONException(JSONErrorCode.KeyIsNotFound, key);

        JSONNumber n = v.getJSONNumber();
        if (n == null)
            throw new JSONException(JSONErrorCode.NotAJSONNumber, v.toString());

        return n.getIntValue();
    }

    public String getString(String key) throws JSONException {
        JSONValue v = get(key);
        if (v == null)
            throw new JSONException(JSONErrorCode.KeyIsNotFound, key);

        JSONString s = v.getJSONString();
        if (s == null)
            throw new JSONException(JSONErrorCode.NotAJSONString, v.toString());
        return s.getValue();
    }

    @Override
    public JSONObject getJSONObject() {
        return this;
    }

    public JSONArray getJSONArray(String key) {
        JSONValue v = get(key);
        if (v == null)
            return null;

        JSONArray a = v.getJSONArray();
        if (a == null)
            return null;
        return a;
    }

    public boolean hasKey(String key) {
        return content.containsKey(key);
    }

    public Map<String, JSONValue> getKeyValueMap() {
        return content;
    }

    public JSONObject getJSONObject(String key) throws JSONException {
        JSONValue v = get(key);
        if (v == null)
            throw new JSONException(JSONErrorCode.KeyIsNotFound, key);
        JSONObject o = v.getJSONObject();
        if (o == null)
            throw new JSONException(JSONErrorCode.NotAJSONObject, v.toString());
        return o;
    }

    public JSONValueType getValueType() {
        return JSONValueType.Object;
    }

    public void remove(String nodeName) {
        content.remove(nodeName);
    }
}
