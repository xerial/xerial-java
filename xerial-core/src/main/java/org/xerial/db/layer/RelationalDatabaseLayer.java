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




