//--------------------------------------
// XerialJ Project
//
// SQLiteReaderTest.java
// Since: May 31, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;


import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xerial.db.DBException;
import org.xerial.db.sql.SQLExpression;
import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;


public class SQLiteReaderTest {
	SQLiteReader reader;
	
	@BeforeClass
	public static void setUpClass()
	{
		// set the path to the SQLite JDBC dll
		//System.setProperty("org.sqlite.lib.path", "lib");
	}
	
	@Before
	public void setUp() throws Exception {
		 reader = new SQLiteReader();
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void query() throws JSONException, InvalidJSONDataException, DBException, IOException
	{
		JSONObject json = new JSONObject();
		json.put("database", SQLite.getMemoryDatabaseAddress());
		json.put("sql", SQLExpression.fillTemplate("select * from $1", "person"));
	
		//reader.query(json.toJSONString(), System.out);
	}

}




