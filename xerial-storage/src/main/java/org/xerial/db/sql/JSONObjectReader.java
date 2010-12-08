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

public class JSONObjectReader extends ResultSetHandler<JSONObject> {

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
