//--------------------------------------
// ModernSCMD Project
//
// ConnectionPoolImpl.java
// Since: 2007/02/25
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import org.xerial.db.DBException;
import org.xerial.util.StringUtil;



/**
 * ConnectionPoolImpl class holds established JDBC connections.
 * For each time you get a connection, you must return it to the ConnectionPoolImpl
 * by calling returnConnection(connection). 
 *   
 * @author leo
 *
 */
public class ConnectionPoolImpl implements ConnectionPool 
{
	private LinkedList<Connection> _connectionQueue = new LinkedList<Connection>();
	private int _timeOutSecond = 10;
	
	private String _driver;
	private String _address;
	private int _numMaximumConnections = 1;

	
	/**
	 * @param JDBCdriver	driver name: e.g. "org.sqlite.JDBC"
	 * @param databaseAddress database address, e.g. "jdbc:sqlite:db.sqilte3"		
	 * @throws DBException	when loading the driver or to establish connections fail 
	 */
	public ConnectionPoolImpl(String JDBCdriver, String databaseAddress) throws DBException
	{
		_driver = JDBCdriver;
		_address = databaseAddress;
		establishConnections();
	}
	
	/**
	 * @param JDBCdriver	driver name: e.g. "org.sqlite.JDBC"
	 * @param databaseAddress database address, e.g. "jdbc:sqlite:db.sqilte3"
	 * @param the number of connections to keep  		
	 * @throws DBException	when loading the driver or to establish connections fail 
	 */
	public ConnectionPoolImpl(String JDBCdriver, String databaseAddress, int numConnection) throws DBException
	{
		_driver = JDBCdriver;
		_address = databaseAddress;
		_numMaximumConnections = numConnection;
		establishConnections();
	}
	
	public synchronized void establishConnections() throws DBException
	{
		try {
			Class.forName(_driver);
		} catch (ClassNotFoundException e) {
			throw new DBException(e);
		}
		
		try
		{
			// establish the connections
			for(int i=0; i<_numMaximumConnections; i++)
			{
				Connection connection = DriverManager.getConnection(_address);
				_connectionQueue.add(connection);
			}
		}
		catch(SQLException e)
		{
			throw new DBException(e);
		}
	}
	
	
	
	public synchronized void add(Connection establishedConnection)
	{
		_connectionQueue.add(establishedConnection);
	}
	
	// @see org.xerial.db.ConnectionPool#getConnection()
	public synchronized Connection getConnection() throws DBException
	{
		try {
			while(_connectionQueue.isEmpty())
			{
				wait(_timeOutSecond*10);
			}
			Connection connection = _connectionQueue.getFirst();
			_connectionQueue.removeFirst();
			return connection;
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new DBException(e);
		}			
	}
	
	// @see org.xerial.db.ConnectionPool#returnConnection(java.sql.Connection)
	public synchronized void returnConnection(Connection leasedConnection) 
	{
		_connectionQueue.add(leasedConnection);
		notify();
	}

	// @see org.xerial.db.ConnectionPool#closeAll()
	public synchronized void closeAll() throws DBException {
		notifyAll();
		LinkedList<String> exceptionList = new LinkedList<String>();
		for(Connection c : _connectionQueue)
		{
			try {
				c.close();
			} catch (SQLException e) {
				exceptionList.add(e.getMessage());
			}
		}
		if(!exceptionList.isEmpty())
			throw new DBException(StringUtil.join(exceptionList, ", "));
	}
	
	
}

