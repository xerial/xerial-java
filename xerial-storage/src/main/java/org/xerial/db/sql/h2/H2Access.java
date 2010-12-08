/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// H2Access.java
// Since: Oct 22, 2008 9:47:32 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql.h2;

import java.util.LinkedList;

import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.TypeName;
import org.xerial.db.sql.ConnectionPoolImpl;
import org.xerial.db.sql.DatabaseAccessBase;
import org.xerial.util.StringUtil;

public class H2Access extends DatabaseAccessBase
{
    public static final String DRIVER_NAME = "org.h2.Driver";
    public static final String ADDRESS_PREFIX = "jdbc:h2:";

    /**
     * open memory database
     * 
     * @throws DBException
     */
    public H2Access() throws DBException
    {
        super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + "mem:"));
    }

    public H2Access(String address) throws DBException
    {
        super(new ConnectionPoolImpl(DRIVER_NAME, ADDRESS_PREFIX + address));
    }

    @Override
    public String createTableSQL(String tableName, Relation r)
    {
        LinkedList<String> columnDefList = new LinkedList<String>();
        for (DataType dt : r.getDataTypeList())
        {
            StringBuilder columnDef = new StringBuilder();
            String typeName = dt.getTypeName();
            if (dt.getType() == TypeName.STRING)
                typeName = "varchar";
            columnDef.append(String.format("%s %s", dt.getName(), typeName));

            if (dt.getName().equals("id"))
            {
                columnDef.append(" not null auto_increment primary key");
                // id attribute must be the first column
                columnDefList.addFirst(columnDef.toString());
            }
            else
                columnDefList.add(columnDef.toString());
        }

        String schema = StringUtil.join(columnDefList, ", ");
        String sql = String.format("create table if not exists %s (%s)", tableName, schema);
        return sql;
    }
}
