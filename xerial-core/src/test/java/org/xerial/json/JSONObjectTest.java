//--------------------------------------
// XerialJ Project
//
// JSONObjectTest.java
// Since: Apr 26, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.json;

import static org.junit.Assert.*;


import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class JSONObjectTest {

	static Logger _logger = Logger.getLogger(JSONObjectTest.class);;
	
	@BeforeClass
	static public void setUpBeforeClass()
	{

	}
	
	@Before
	public void setUp() throws Exception {
		
		
		
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParse() throws InvalidJSONDataException 
	{
		String jsonTree = JSONObject.parse("{ \"name\":\"leo\", \"id\":3}").toStringTree();
		_logger.debug(jsonTree);
	}
	
	
	public JSONObject parse(String json) throws RecognitionException, InvalidJSONDataException
	{
		CommonTree t = JSONObject.parse(json);
		_logger.debug(t.toStringTree());
		return new JSONObject(json);
	}
	
	@Test
	public void testJSONObjectString() throws RecognitionException {
		
		try
		{
			JSONObject obj = new JSONObject("{ \"name\":\"leo\", \"id\":3}");
			assertEquals(2, obj.elementSize());
			assertEquals(new JSONString("leo"), obj.get("name"));
			assertEquals(new JSONInteger(3), obj.get("id"));
		}
		catch(InvalidJSONDataException e)
		{
			fail(e.getMessage());
		}
		
		
	}
	
	@Test 
	public void testNestedJSONObject() throws RecognitionException 
	{
		try {
			JSONObject obj = new JSONObject("{ \"person\":{\"name\":\"leo\", \"id\":3}, \"isValid\":true}");
			_logger.debug(obj);
			assertEquals(2, obj.elementSize());
			assertEquals(new JSONBoolean(true), obj.get("isValid"));
			JSONValue v = obj.get("person");
			assertTrue(v instanceof JSONObject);
			JSONObject p = (JSONObject) v;
			assertEquals(new JSONString("leo"), p.get("name"));
			assertEquals(new JSONInteger(3), p.get("id"));
		} catch (InvalidJSONDataException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	@Test 
	public void testArray() throws RecognitionException 
	{
		JSONObject obj;
		try {
			obj = new JSONObject("{ \"person\":[\"leo\", 3, \"yui\"]}");
			_logger.debug(obj);

			assertEquals(1, obj.elementSize());
			JSONValue v = obj.get("person");
			assertTrue(v instanceof JSONArray);
			JSONArray a = (JSONArray) v;
			assertEquals(3, a.size());
			assertEquals(new JSONString("leo"), a.get(0));
			assertEquals(new JSONInteger(3), a.get(1));
			assertEquals(new JSONString("yui"), a.get(2));
		} catch (InvalidJSONDataException e) {
			fail(e.getMessage());
		}
	}

}




