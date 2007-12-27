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
// XerialJ
//
// JSONPullParserTest.java
// Since: Dec 19, 2007 11:09:07 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;

public class JSONPullParserTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}
    
    @Test
    public void readSample() throws IOException, JSONException
    {
        JSONPullParser pullParser = new JSONPullParser(FileResource.open(JSONPullParserTest.class, "sample.json"));
        JSONEvent e = pullParser.next();
        assertEquals(JSONEvent.StartObject, e);
        assertNull(pullParser.getKeyName());
        e = pullParser.next();
        assertEquals(JSONEvent.String, e);
        assertEquals("name", pullParser.getKeyName());
        assertEquals(new JSONString("Leo"), pullParser.getValue());
        e = pullParser.next();
        assertEquals(JSONEvent.Integer, e);
        assertEquals("id", pullParser.getKeyName());
        assertEquals(new JSONInteger(100), pullParser.getValue());
        e = pullParser.next();
        assertEquals(JSONEvent.EndObject, e);
        assertNull(pullParser.getKeyName());
        
        e = pullParser.next();
        assertEquals(JSONEvent.EndJSON, e);
        assertNull(pullParser.getKeyName());
        e = pullParser.next();
        assertEquals(JSONEvent.EndJSON, e);
        assertNull(pullParser.getKeyName());
    }
    
    @Test
    public void getValue() throws IOException, JSONException 
    {
        JSONPullParser pullParser = new JSONPullParser(FileResource.open(JSONPullParserTest.class, "sample.json"));
        JSONEvent e = pullParser.next();
        assertEquals(JSONEvent.StartObject, e);
        JSONValue value = pullParser.getValue();
        JSONObject obj = value.getJSONObject();
        assertNotNull(obj);
        JSONValue name = obj.get("name");
        assertNotNull(name);
        assertEquals("Leo", name.toString());
        JSONValue id = obj.get("id");
        assertNotNull(id);
        assertEquals(100, id.getJSONNumber().getIntValue());
    }
    
    @Test
    public void getValue2() throws IOException, JSONException
    {
        JSONPullParser pullParser = new JSONPullParser(FileResource.open(JSONPullParserTest.class, "sample.json"));

        JSONValue value = pullParser.getValue();
        JSONObject obj = value.getJSONObject();
        assertNotNull(obj);
        JSONValue name = obj.get("name");
        assertNotNull(name);
        assertEquals("Leo", name.toString());
        JSONValue id = obj.get("id");
        assertNotNull(id);
        assertEquals(100, id.getJSONNumber().getIntValue());

    }
    


}
