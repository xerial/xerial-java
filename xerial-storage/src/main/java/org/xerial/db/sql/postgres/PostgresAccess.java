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
// PostgresAccess.java
// Since: Jan 16, 2008 11:05:08 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql.postgres;

import org.xerial.db.DBException;
import org.xerial.db.sql.ConnectionPool;
import org.xerial.db.sql.ConnectionPoolImpl;
import org.xerial.db.sql.DatabaseAccessBase;

/**
 * Database Access to PostgreSQL  
 * 
 * @author leo
 *
 */
public class PostgresAccess extends DatabaseAccessBase
{
    public static final String DRIVER_NAME = "org.postgresql.Driver";
    public static final String ADDRESS_PREFIX = "jdbc:postgresql://";

    public PostgresAccess(ConnectionPool connectionPool) throws DBException
    {
        super(connectionPool);
    }

    public PostgresAccess(String address, String user, String path) throws DBException
    {
        super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + address, user, path));
    }

    public PostgresAccess(String address, String user, String path, int numConnections) throws DBException
    {
        super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + address, user, path, numConnections));
    }

    public PostgresAccess(String host, String databaseName, int port, String user, String path) throws DBException
    {
        super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + host + ":" + port + "/" + databaseName, user, path));
    }

    public PostgresAccess(String host, String databaseName, int port, String user, String path, int numConnections)
            throws DBException
    {
        super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + host + ":" + port + "/" + databaseName, user, path,
                numConnections));
    }

}
