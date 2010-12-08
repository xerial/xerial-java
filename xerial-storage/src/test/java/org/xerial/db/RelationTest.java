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
// RelationTest.java
// Since: Jun 26, 2008 4:05:53 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.TypeName;
import org.xerial.db.sql.sqlite.Person;

public class RelationTest
{

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetDataTypeStringString() {
        String paramName = "param";
        DataType dt = Relation.getDataType(paramName, "integer");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.INTEGER);

        dt = Relation.getDataType(paramName, "int");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.INTEGER);

        // must not be case-sensitive 
        dt = Relation.getDataType(paramName, "Integer");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.INTEGER);

        // serial type must be an integer
        dt = Relation.getDataType(paramName, "serial");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.INTEGER);

        dt = Relation.getDataType(paramName, "boolean");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.BOOLEAN);

        dt = Relation.getDataType(paramName, "string");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.STRING);

        dt = Relation.getDataType(paramName, "long");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.LONG);

        dt = Relation.getDataType(paramName, "password");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.PASSWORD);

        dt = Relation.getDataType(paramName, "text");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.TEXT);

        dt = Relation.getDataType(paramName, "datetime");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.DATETIME);

        // unknown type must be bound to StringType
        dt = Relation.getDataType(paramName, "other");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.STRING);

        // blob type
        dt = Relation.getDataType(paramName, "blob");
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.BLOB);

    }

    @Test
    public void testGetDataTypeStringClassOfT() {
        String paramName = "param";
        DataType dt = null;

        dt = Relation.getDataType(paramName, Integer.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.INTEGER);

        dt = Relation.getDataType(paramName, int.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.INTEGER);

        dt = Relation.getDataType(paramName, Boolean.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.BOOLEAN);

        dt = Relation.getDataType(paramName, boolean.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.BOOLEAN);

        dt = Relation.getDataType(paramName, String.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.STRING);

        dt = Relation.getDataType(paramName, Long.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.LONG);

        dt = Relation.getDataType(paramName, long.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.LONG);

        dt = Relation.getDataType(paramName, Date.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.DATETIME);

        // unknown type must be bound to StringType
        dt = Relation.getDataType(paramName, Person.class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.STRING);

        // {@link Blob} type
        dt = Relation.getDataType(paramName, byte[].class);
        assertEquals(dt.getName(), paramName);
        assertEquals(dt.getType(), TypeName.BLOB);

    }

}
