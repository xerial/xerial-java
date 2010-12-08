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
// NaiveConnectionPool.java
// Since: 2007/05/29
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.xerial.db.DBException;
import org.xerial.db.DBErrorCode;
import org.xerial.util.log.Logger;

/**
 * NaiveConnectionPool creates a connection every time when 
 * a query is requested, then closes the connection affte its ResultSet is 
 * consumed.
 * @author leo
 *
 */
public class NaiveConnectionPool implements ConnectionPool {

	private static Logger _logger = Logger.getLogger(NaiveConnectionPool.class);
	
	private String driver;
	private String address;
	

	public NaiveConnectionPool(String driver, String address) {
		this.driver = driver;
		this.address = address;
		
		_logger.debug("driver: " + driver);
		_logger.debug("addredss: " + address);
	}

	public void closeAll() throws DBException {
		// do nothing
	}

	public Connection getConnection() throws DBException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DBException(DBErrorCode.UnknownJDBCDriver, e);
		}
		
		try
		{
			// establish the connections
			Connection connection = DriverManager.getConnection(address);
			return connection;
		}
		catch(SQLException e)
		{
			throw new DBException(DBErrorCode.JDBCConnectionError, e);
		}
	}

	public void returnConnection(Connection leasedConnection) {
		try {
			leasedConnection.close();
		} catch (SQLException e) {
			_logger.error(e);
		}
	}

}




