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
// MySQLAccess.java
// Since: Jan 17, 2008 4:14:18 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql.mysql;

import org.xerial.db.DBException;
import org.xerial.db.sql.ConnectionPoolImpl;
import org.xerial.db.sql.DatabaseAccessBase;

/**
 * 
 * Adapter for MySQL database.
 * 
 * Since MySQL JDBC driver is licensed under GPL, we cannot include its jar archive
 * in this xerial-storage package. If you want to use this MySQL support,   
 * download the MySQL Connector/J from http://www.mysql.com/products/connector/j/, 
 * then add the JAR file to your class path.  
 *  
 * @author leo
 *
 */
public class MySQLAccess extends DatabaseAccessBase {

	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String ADDRESS_PREFIX = "jdbc:mysql://";
    
    public MySQLAccess(String address, String user, String path) throws DBException
    {
    	super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + address, user, path));
    }

    public MySQLAccess(String address, String user, String path, int numConnections) throws DBException
    {
    	super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + address, user, path, numConnections));
    }

}
