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
// PostgresAccessTest.java
// Since: Jan 16, 2008 3:47:15 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql.postgres;

import org.junit.Ignore;
import org.junit.Test;
import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.sql.DatabaseAccess;
import org.xerial.util.log.Logger;

public class PostgresAccessTest
{
    private static Logger _logger = Logger.getLogger(PostgresAccessTest.class);

    @Ignore
    @Test
    public void testConnection() throws DBException
    {
        DatabaseAccess db = new PostgresAccess("localhost", "drosophila_trackinformation", 5432, "postgres", "");
        for (String table : db.getTableNameList())
        {
            _logger.debug("table: " + table);
            Relation r = db.getRelation(table);
            for (DataType dt : r.getDataTypeList())
            {
                _logger.debug(" column: " + dt.getName() + " (" + dt.getTypeName() + ")");
            }

        }
    }
}
