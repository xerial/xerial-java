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
// SQLite.java
// Since: 2007/05/10
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.io.File;


import org.xerial.db.datatype.DataType;

import org.xerial.util.log.Logger;

/**
 * This SQLite class holds information related to sqlite3
 * 
 * @author leo
 * 
 */
public class SQLite
{
    private static Logger _logger = Logger.getLogger(SQLite.class);

    private SQLite()
    {}

    public static final String driverName = "org.sqlite.JDBC";
    private static final String dbFilePrefix = "jdbc:sqlite:";
    private static final String memoryDatabase = dbFilePrefix + ":memory:";

    public static String getDatabaseAddress(String filePath)
    {
        File file = new File(filePath);
        String fileFullPath = file.toURI().getPath();

        /**
         * change the drive letter C:/... into c:/... since the SQLite JDBC
         * driver does not recognize capital large drive letters.
         */
        int driveLetterSeparatorPos = fileFullPath.indexOf(":");
        if (driveLetterSeparatorPos > 0)
            fileFullPath = fileFullPath.substring(0, driveLetterSeparatorPos).toLowerCase()
                    + fileFullPath.substring(driveLetterSeparatorPos);
        if (!fileFullPath.startsWith("/"))
            fileFullPath = "/" + fileFullPath;
        return dbFilePrefix + fileFullPath;
    }

    public static String getMemoryDatabaseAddress()
    {
        return memoryDatabase;
    }

    public static String getDataTypeName(DataType dataType)
    {
        return dataType.getTypeName();
    }

}
