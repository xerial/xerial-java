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
// XerialJ
//
// RDBAccess.java
// Since: Jan 15, 2008 7:13:07 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.io.IOException;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.util.List;

import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.util.Predicate;

/**
 * An interface to access relational databases
 * 
 * @author leo
 * 
 */
public interface DatabaseAccess
{

    /**
     * Gets the table names contained in this database.
     * 
     * @return the list of table names
     * @throws DBException
     */
    public List<String> getTableNameList() throws DBException;

    /**
     * Gets the relation (schema) information of the table.
     * 
     * @param tableName
     *            the target table name
     * @return the relation of the table
     * @throws DBException
     */
    public Relation getRelation(String tableName) throws DBException;

    /**
     * perform the given SQL query, then output its results
     * 
     * @param sql
     *            An SQL statement
     * @param <T>
     *            row type : Bean class type to which the result will be
     *            transformed
     * @param resultRowType
     *            Bean class type to which the result will be transformed
     * @param result
     *            the list of the result beans
     * @throws DBException
     */
    public <T> List<T> query(String sql, Class<T> resultRowType) throws DBException;

    /**
     * Performs an SQL query, while consuming the results with the given handler
     * 
     * @param <T>
     * @param sql
     *            the SQL query expression
     * @param resultSetHandler
     *            the result set handler that consumes the result set of the
     *            query.
     * @throws DBException
     */
    public <T> void query(String sql, ResultSetHandler<T> resultSetHandler) throws DBException;

    /**
     * Performs an SQL query, while consuming the results with the given handler
     * 
     * @param <T>
     * @param sql
     * @param beanResultHandler
     * @throws DBException
     */
    public <T> void query(String sql, Class<T> resultRowType, BeanResultHandler<T> beanResultHandler)
            throws DBException;

    /**
     * Performs an SQL query, and retrieves the results that satisfy the filter
     * predicate
     * 
     * @param <T>
     * @param sql
     * @param resultRowType
     * @param filter
     * @return
     * @throws DBException
     */
    public <T> List<T> query(String sql, Class<T> resultRowType, Predicate<T> filter) throws DBException;

    /**
     * @param <T>
     * @param sql
     * @param beanClass
     * @param writer
     * @throws DBException
     */
    public <T> void toJSON(String sql, Class<T> beanClass, Writer writer) throws DBException, IOException;

    /**
     * Retrieves only the single column from the SQL query result
     * 
     * @param <T>
     * @param sql
     * @param targetColumn
     *            the target column
     * @param resultColumnType
     *            the target column type to be transformed
     * @return the list of the specified column data
     * @throws DBException
     */
    public <T> List<T> singleColumnQuery(String sql, String targetColumn, Class<T> resultColumnType) throws DBException;

    /**
     * Accumulate the query result within the ResultSetHandler, then return the
     * result from the handler
     * 
     * @param <T>
     * @param sql
     * @param handler
     * @return
     * @throws DBException
     */
    public <T> T accumulate(String sql, ResultSetHandler<T> handler) throws DBException;

    /**
     * Performs the update query
     * 
     * @param sql
     *            the update SQL query
     * @return the number of rows updated
     * @throws DBException
     */
    public int update(String sql) throws DBException;

    /**
     * Performs the update query
     * 
     * @param sql
     *            the update SQL query
     * @param autoCommit
     *            true when enable auto commit arounc this update query, false
     *            otherwise
     * @return the number of rows updated
     * @throws DBException
     */
    public int update(String sql, boolean autoCommit) throws DBException;

    /**
     * Performs the update using prepared statement. You can set the tuple
     * values in the {@link PreparedStatementHandler} via
     * {@link PreparedStatement#setBytes}, etc.
     * 
     * @param sqlForPreparedStatement
     *            the update SQL statement that may contain '?' mark that will
     *            be filled in the {@link PreparedStatementHandler}
     * @param handler
     *            the handler for filling '?' marks in the sql statement
     * @return
     * @throws DBException
     */
    public int updateWithPreparedStatement(String sqlForPreparedStatement, PreparedStatementHandler handler)
            throws DBException;

    /**
     * Inserts a bean into a table
     * 
     * @param <T>
     * @param tableName
     * @param bean
     * @return the number of rows updated (1 if succeeded)
     * @throws DBException
     */
    public <T> int insert(String tableName, T bean) throws DBException;

    /**
     * insert and retrieves a generated key
     * 
     * @param <T>
     * @param sql
     * @return last generated key, or -1 when key retrieval failed
     * @throws DBException
     */
    public <T> int insertAndRetrieveKeys(String sql) throws DBException;

    /**
     * Sets the time of the query until it will be terminated in seconds
     * 
     * @param sec
     *            timeout (sec.)
     */
    public void setQueryTimeout(int sec);

    /**
     * Enable/disable auto commit mode for all subsequent queries.
     */
    public void setAutoCommit(boolean enableAutoCommit);

    /**
     * Is auto-commit mode?
     * 
     * @return
     */
    public boolean isAutoCommit();

    /**
     * Close all connections managed by this database access
     * 
     * @throws DBException
     */
    public void dispose() throws DBException;

    /**
     * Test the existence of the specified table
     * 
     * @param tableName
     * @return
     */
    public boolean hasTable(String tableName) throws DBException;

    public int insertAndRetrieveKeysWithPreparedStatement(String sqlForPreparedStatment,
            PreparedStatementHandler handler) throws DBException;

    public String createTableSQL(String tableName, Relation r);

}
