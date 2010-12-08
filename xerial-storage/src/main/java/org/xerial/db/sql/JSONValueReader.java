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

public class JSONValueReader extends ResultSetHandler<JSONValue> {

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




