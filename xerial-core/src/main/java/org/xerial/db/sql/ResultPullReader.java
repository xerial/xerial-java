//--------------------------------------
// XerialJ Project
//
// ResultPullReader.java
// Since: May 31, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.xerial.json.JSONObject;

public class ResultPullReader implements ResultSetHandler<Object>
{
	private Writer _out;
	JSONObjectReader _jsonReader = new JSONObjectReader();
	
	public ResultPullReader(Writer out)
	{
		_out = out;
	}
	
	public Object handle(ResultSet rs) throws SQLException {
		
		JSONObject json = _jsonReader.handle(rs);
		try {
			_out.append(json.toJSONString());
		} catch (IOException e) {
			throw new SQLException(e.getMessage());
		}
		return null;
	}
	
}




