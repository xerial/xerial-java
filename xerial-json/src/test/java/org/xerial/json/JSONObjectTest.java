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
// JSONObjectTest.java
// Since: Apr 26, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.json;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class JSONObjectTest
{

    static Logger _logger = Logger.getLogger(JSONObjectTest.class); ;

    @BeforeClass
    static public void setUpBeforeClass() {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {}

    //	@Test
    //	public void testParse() throws JSONException
    //	{
    //		String jsonTree = JSONObject.parse("{ \"name\":\"leo\", \"id\":3}").toStringTree();
    //		_logger.debug(jsonTree);
    //	}
    //	
    //	
    //	public JSONObject parse(String json) throws RecognitionException, JSONException
    //	{
    //		CommonTree t = JSONObject.parse(json);
    //		_logger.debug(t.toStringTree());
    //		return new JSONObject(json);
    //	}

    @Test
    public void testJSONObjectString() throws Exception {

        try {
            JSONObject obj = JSONObject.parse("{ \"name\":\"leo\", \"id\":3}");
            assertEquals(2, obj.elementSize());
            assertEquals(JSONValueType.String, obj.get("name").getValueType());
            assertEquals(new JSONString("leo"), obj.get("name"));
            assertEquals(JSONValueType.Integer, obj.get("id").getValueType());
            assertEquals(new JSONInteger(3), obj.get("id"));
        }
        catch (JSONException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testNestedJSONObject() throws Exception {
        try {
            JSONObject obj = JSONObject.parse("{ \"person\":{\"name\":\"leo\", \"id\":3}, \"isValid\":true}");
            _logger.debug(obj);
            assertEquals(2, obj.elementSize());
            assertEquals(new JSONBoolean(true), obj.get("isValid"));
            JSONValue v = obj.get("person");
            assertTrue(v instanceof JSONObject);
            JSONObject p = (JSONObject) v;
            assertEquals(new JSONString("leo"), p.get("name"));
            assertEquals(new JSONInteger(3), p.get("id"));
        }
        catch (JSONException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testArray() throws Exception {
        JSONObject obj;
        try {
            obj = JSONObject.parse("{ \"person\":[\"leo\", 3, \"yui\"]}");
            _logger.debug(obj);

            assertEquals(1, obj.elementSize());
            JSONValue v = obj.get("person");
            assertTrue(v instanceof JSONArray);
            JSONArray a = (JSONArray) v;
            assertEquals(3, a.size());
            assertEquals(new JSONString("leo"), a.get(0));
            assertEquals(new JSONInteger(3), a.get(1));
            assertEquals(new JSONString("yui"), a.get(2));
        }
        catch (JSONException e) {
            fail(e.getMessage());
        }
    }

}
