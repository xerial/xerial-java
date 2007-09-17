//--------------------------------------
// XerialJ Project
//
// JSONObjectReader.java
// Since: May 30, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.xerial.json.JSONObject;
import org.xerial.json.JSONString;

public class JSONObjectReader implements ResultSetHandler<JSONObject> {

	boolean _isInitialized = false;

	int _columnSize = 0;

	ResultSetMetaData _rsMetaData;

	public JSONObject handle(ResultSet rs) throws SQLException {
		if (!_isInitialized) {
			_rsMetaData = rs.getMetaData();
			_columnSize = _rsMetaData.getColumnCount();
		}

		JSONObject row = new JSONObject();
		for (int i = 1; i < _columnSize + 1; i++) {
			/*
			 * JSONValue value; int type = rsMetaData.getColumnType(i);
			 * switch(type) { case Types.INTEGER: value = new
			 * JSONInteger(rs.getInt(i)); break; case Types.DOUBLE: value = new
			 * JSONDouble(rs.getDouble(i)); break; default: value = new
			 * JSONString(rs.getString(i)); }
			 */

			row.put(_rsMetaData.getColumnLabel(i), new JSONString(rs.getString(i)));
		}
		return row;
	}
	

}
