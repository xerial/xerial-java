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
	}

	public void closeAll() throws DBException {
		// do nothing
	}

	public Connection getConnection() throws DBException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DBException(e);
		}
		
		try
		{
			// establish the connections
			Connection connection = DriverManager.getConnection(address);
			return connection;
		}
		catch(SQLException e)
		{
			throw new DBException(e);
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




