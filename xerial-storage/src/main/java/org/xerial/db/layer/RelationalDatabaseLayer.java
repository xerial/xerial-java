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
// RelationalDatabase.java
// Since: May 22, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.layer;

import java.sql.Connection;


public class RelationalDatabaseLayer implements DatabaseLayer 
{
	enum SystemType { SQLITE, POSTGRES, MYSQL, TABFILE };
	
	SystemType _systemType;
	
	private String _jdbcAddress = "";
	
	public RelationalDatabaseLayer(SystemType systemType, String jdbcAddress)
	{
		this._systemType = systemType;
		this._jdbcAddress = jdbcAddress;
	}
	
	public Connection getConnection()
	{
		return null;
	}

	public DatabaseLayer getParent() {
		// TODO Auto-generated method stub
		return null;
	}

}




