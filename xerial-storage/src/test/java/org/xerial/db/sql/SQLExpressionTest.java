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
import org.xerial.db.sql.SQLExpression.Quote;
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
			// okay
		}
	}
	
	@Test
	public void sanitizeWhereClause()
	{
	    try
        {
            SQLExpression.sanitize("where species=\"drosophila\" and kind=\"\"", Quote.NONE);
            SQLExpression.sanitize("where kind=\"\" and species=\"medaka\" and name=\"5'sage tag\"", Quote.NONE);
        }
        catch (DBException e)
        {
            fail(e.getMessage());
        }
	}
	
	@Test
	public void emptyQuote()
	{
        try
        {
            String sql= SQLExpression.fillTemplate("select * from person $1", "where name=\"\"");
            
            _logger.debug(sql);
            String sql2 = SQLExpression.fillTemplate("select count(*) as count from (select * from tracks where kind=\"\" group by $1)", "kind");
        }
        catch (DBException e)
        {
            fail(e.getMessage());
        }
	    
	}
	
	
}




