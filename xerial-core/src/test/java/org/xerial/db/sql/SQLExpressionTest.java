//--------------------------------------
// XerialJ Project
//
// SQLExpressionTest.java
// Since: Jun 5, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.db.DBException;
import org.xerial.util.log.Logger;

public class SQLExpressionTest {

	static Logger _logger = Logger.getLogger(SQLExpressionTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void expr() throws DBException
	{
		String sql = "select $1 from $2";
		String sql2 = SQLExpression.fillTemplate(sql, "*", "person");
		assertEquals("select * from person", sql2);
		
	}
	
	@Test
	public void sanitize()
	{
		String valnableSQL = "select * from person where name='$1'";
		String maliciousCode = "'; delete from person; select * from person where name ='"; 
		
		String sql;
		try {
			sql = SQLExpression.fillTemplate(valnableSQL, maliciousCode);
			fail(sql + " must be sanitized");
		} catch (DBException e) {
			// okay! injection is detected
		}

	}
	
	@Test
	public void sanitize2()
	{
		String valnableSQL = "select * from person where name=\"$1\"";
		String maliciousCode = "hello\"; drop table; \"";
		try {
			String sql = SQLExpression.fillTemplate(valnableSQL, maliciousCode);
			fail(sql + " must be sanitized");
		} catch (DBException e) {
			// okey
		}
	}
}




