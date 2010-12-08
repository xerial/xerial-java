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

import org.xerial.db.DBErrorCode;
import org.xerial.db.DBException;
import org.xerial.util.StringUtil;

/**
 * ConnectionPoolImpl class holds established JDBC connections. For each time
 * you get a connection, you must return it to the ConnectionPoolImpl by calling
 * returnConnection(connection).
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
    private int _numMaximumConnections = 5;

    /**
     * Create an connection pool, in which only a single connection is pooled
     * This constructer is suited for memory database usage, which demands the
     * same connection must always be returned to the user
     * 
     * @param JDBCdriver
     *            driver name: e.g. "org.sqlite.JDBC"
     * @param databaseAddress
     *            database address, e.g. "jdbc:sqlite:db.sqilte3"
     * @throws DBException
     *             when loading the driver or to establish connections fail
     */
    public ConnectionPoolImpl(String JDBCDriver, String databaseAddress) throws DBException
    {
        this(JDBCDriver, databaseAddress, 1);
    }

    /**
     * @param JDBCdriver
     *            driver name: e.g. "org.sqlite.JDBC"
     * @param databaseAddress
     *            database address, e.g. "jdbc:sqlite:db.sqilte3"
     * @param the
     *            number of connections to keep
     * @throws DBException
     *             when loading the driver or to establish connections fail
     */
    public ConnectionPoolImpl(String JDBCDriver, String databaseAddress, int numConnection) throws DBException
    {
        _driver = JDBCDriver;
        _address = databaseAddress;
        _numMaximumConnections = numConnection;
        establishConnections();
    }

    public ConnectionPoolImpl(String JDBCDriver, String databaseAddress, String user, String pass) throws DBException
    {
        this(JDBCDriver, databaseAddress, user, pass, 1);
    }

    public ConnectionPoolImpl(String JDBCDriver, String databaseAddress, String user, String pass, int numConnection)
            throws DBException
    {
        _driver = JDBCDriver;
        _address = databaseAddress;
        _numMaximumConnections = numConnection;
        establishConnections(user, pass);
    }

    public synchronized void establishConnections(String user, String pass) throws DBException
    {
        try
        {
            Class.forName(_driver);
        }
        catch (ClassNotFoundException e)
        {
            throw new DBException(DBErrorCode.UnknownJDBCDriver, e);
        }

        try
        {
            // establish the connections
            for (int i = 0; i < _numMaximumConnections; i++)
            {
                Connection connection = DriverManager.getConnection(_address, user, pass);
                _connectionQueue.add(connection);
            }
        }
        catch (SQLException e)
        {
            throw new DBException(DBErrorCode.JDBCConnectionError, e);
        }
    }

    public synchronized void establishConnections() throws DBException
    {
        try
        {
            Class.forName(_driver);
        }
        catch (ClassNotFoundException e)
        {
            throw new DBException(DBErrorCode.UnknownJDBCDriver, e);
        }

        try
        {
            // establish the connections
            for (int i = 0; i < _numMaximumConnections; i++)
            {
                Connection connection = DriverManager.getConnection(_address);
                _connectionQueue.add(connection);
            }
        }
        catch (SQLException e)
        {
            throw new DBException(DBErrorCode.SQLiteDBFileNotFound, e);
        }
    }

    public synchronized void add(Connection establishedConnection)
    {
        _connectionQueue.add(establishedConnection);
    }

    // @see org.xerial.db.ConnectionPool#getConnection()
    public synchronized Connection getConnection() throws DBException
    {
        try
        {
            while (_connectionQueue.isEmpty())
            {
                wait(_timeOutSecond * 10);
            }
            Connection connection = _connectionQueue.getFirst();
            _connectionQueue.removeFirst();
            return connection;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            throw new DBException(DBErrorCode.ThreadInterruption, e);
        }
    }

    // @see org.xerial.db.ConnectionPool#returnConnection(java.sql.Connection)
    public synchronized void returnConnection(Connection leasedConnection)
    {
        _connectionQueue.add(leasedConnection);
        notify();
    }

    // @see org.xerial.db.ConnectionPool#closeAll()
    public synchronized void closeAll() throws DBException
    {
        notifyAll();
        LinkedList<String> exceptionList = new LinkedList<String>();
        for (Connection c : _connectionQueue)
        {
            try
            {
                c.close();
            }
            catch (SQLException e)
            {
                exceptionList.add(e.getMessage());
            }
        }
        if (!exceptionList.isEmpty())
            throw new DBException(DBErrorCode.FailureOnConnectionClose, StringUtil.join(exceptionList, ", "));
    }

}
