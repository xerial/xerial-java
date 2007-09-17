//--------------------------------------
// ModernSCMD Project
//
// SQLUtil.java
// Since: 2007/02/25
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.xerial.db.DBException;
import org.xerial.util.log.Logger;


public class DatabaseAccess {

	private ConnectionPool _connectionPool;
	private static Logger _logger = Logger.getLogger(DatabaseAccess.class);
	
	public DatabaseAccess(ConnectionPool connectionPool) throws DBException
	{
		_connectionPool = connectionPool;
        
        // validate connection
        try
        {
            Connection con = _connectionPool.getConnection();
            _connectionPool.returnConnection(con);
        }
        catch (DBException e)
        {
            throw new DBException("cannot open connection: " + e);
        }
	}

	public void dispose() throws DBException
	{	
		_connectionPool.closeAll();
	}

    /**
     * perforam a given SQL query, then output its results 
     * @param <T> row type	: Bean class type
     * @param sql sql statement
     * @param resultRowType it must be equal to the T
     * @param result
     * @throws DBException
     */
    @SuppressWarnings("unchecked")
	public <T> List<T> query(String sql, Class<T> resultRowType) throws DBException
    {
    	return query(sql, new BeanReader(resultRowType));
    }

    public <T> void pullQueryResult(String sql, ResultSetHandler<T> pullHandler) throws DBException
    {
    	Connection connection = null;
        try
        {
        	connection = _connectionPool.getConnection();
            Statement statement = connection.createStatement();
            _logger.debug(sql);
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
            	pullHandler.handle(rs);
            }
        }
        catch(SQLException e)
        {
            throw new DBException(e);
        }
        finally
        {
        	if(connection != null)
        		_connectionPool.returnConnection(connection);
        }
    }
    
    public <T> List<T> query(String sql, ResultSetHandler<T> handler) throws DBException
    {
    	Connection connection = null;
    	ArrayList<T> result = new ArrayList<T>();
        try
        {
        	connection = _connectionPool.getConnection();
            Statement statement = connection.createStatement();
            _logger.debug(sql);
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
            	T row = handler.handle(rs);
            	if(row != null)
            		result.add(row);
            	else
            		_logger.warn("null handler result is returned");
            }
        }
        catch(SQLException e)
        {
            throw new DBException(e);
        }
        finally
        {
        	if(connection != null)
        		_connectionPool.returnConnection(connection);
        }
        return result;
    }


    public int update(String sql) throws DBException
    {
    	Connection connection = null;
        try
        {
        	connection = _connectionPool.getConnection();
        	connection.setAutoCommit(true);
            Statement statement = connection.createStatement();
            
            _logger.debug(sql);
            int ret = statement.executeUpdate(sql);
            return ret;
        }
        catch(SQLException e)
        {
            throw new DBException(e);
        }
        finally
        {
        	if(connection != null)
        	{
        		_connectionPool.returnConnection(connection);
        	}
        }
    }

	public ConnectionPool getConnectionPool() {
		return _connectionPool;
	}


}

