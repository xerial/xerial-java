//--------------------------------------
// XerialJ Project
//
// ConnectionPool.java
// Since: 2007/05/29
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.Connection;

import org.xerial.db.DBException;


public interface ConnectionPool {

	public Connection getConnection() throws DBException;
	public void returnConnection(Connection leasedConnection);
	public void closeAll() throws DBException;

}
