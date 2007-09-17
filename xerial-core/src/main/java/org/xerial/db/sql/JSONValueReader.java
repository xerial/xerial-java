//--------------------------------------
// XerialJ Project
//
// JSONValueReader.java
// Since: May 30, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.xerial.json.JSONException;
import org.xerial.json.JSONUtil;
import org.xerial.json.JSONValue;

public class JSONValueReader implements ResultSetHandler<JSONValue> {

	String targetColumn;
	
	public JSONValueReader(String targetColumn)
	{
		this.targetColumn = targetColumn;
	}
	
	public JSONValue handle(ResultSet rs) throws SQLException {

		try {
			return JSONUtil.toJSONValue(rs.getObject(targetColumn));
		} catch (JSONException e) {
			throw new SQLException(e.getMessage());
		}
	}

}




