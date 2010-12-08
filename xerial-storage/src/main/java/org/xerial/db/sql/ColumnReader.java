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
public class ColumnReader<T> extends ResultSetHandler<T> 
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




