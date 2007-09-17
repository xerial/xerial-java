//--------------------------------------
// XerialJ Project
//
// ResultSetHandler.java
// Since: May 30, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A ResultSet<T> handler converts a given row in a ResultSet (java.sql.ResultSet)
 * into a object of type T.
 * @author leo
 *
 */
public interface ResultSetHandler<T>
{
	public T handle(ResultSet rs) throws SQLException;
}




