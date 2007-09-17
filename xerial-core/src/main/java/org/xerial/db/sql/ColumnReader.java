//--------------------------------------
// XerialJ Project
//
// ColumnReader.java
// Since: May 30, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * convert a column in a ResultSet into the specified value
 * @author leo
 *
 */
public class ColumnReader<T> implements ResultSetHandler<T> 
{
	private String columnName;

	public ColumnReader(String columnName)
	{
		this.columnName = columnName;
	}
	
	@SuppressWarnings("unchecked")
	public T handle(ResultSet rs) throws SQLException {
		return (T) rs.getObject(columnName);
	}
}




