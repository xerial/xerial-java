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
// SQLiteAccessTest.java
// Since: May 8, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.DataTypeBase;
import org.xerial.db.datatype.TypeName;
import org.xerial.db.sql.BeanResultHandler;
import org.xerial.db.sql.ConnectionPool;
import org.xerial.db.sql.ConnectionPoolImpl;
import org.xerial.db.sql.PreparedStatementHandler;
import org.xerial.db.sql.RelationBuilder;
import org.xerial.util.CollectionUtil;
import org.xerial.util.log.Logger;

public class SQLiteAccessTest
{

    static private ConnectionPool _connectionPool;

    static Logger                 _logger = Logger.getLogger(SQLiteAccessTest.class);

    @BeforeClass
    public static void openDatabase() throws DBException {

    }

    @AfterClass
    public static void closeDatabase() throws DBException {}

    private SQLiteAccess query;

    @Before
    public void setUp() throws Exception {

        _connectionPool = new ConnectionPoolImpl(SQLite.driverName, SQLite.getMemoryDatabaseAddress());
        query = new SQLiteAccess(_connectionPool);
        query.createTable("person", RelationBuilder.createRelation(Person.class));
    }

    @After
    public void tearDown() throws Exception {
        if (query != null)
            query.dispose();

    }

    @Test
    public void getTableList() throws DBException {
        List<String> tableList = CollectionUtil.toString(query.getTableList());

        assertTrue(tableList.contains("person"));
    }

    @Test
    public void hasTable() throws DBException {
        assertTrue(query.hasTable("person"));
    }

    @Test
    public void getRelation() throws DBException {
        Relation r = query.getRelationSchema("person");
        _logger.debug(r);
    }

    @Test
    public void update() throws DBException, Exception {
        query.insert("person", new Person(3, "leopard"));
        query.deleteByKeyValue(new Person(3), "person");
    }

    @Test
    public void createTable() throws DBException {
        Relation r = new Relation();
        r.add(new DataTypeBase("id", TypeName.INTEGER, true, true));
        r.add(new DataTypeBase("name", TypeName.STRING));

        query.createTable("tmp", r);
        query.dropTable("tmp");
    }

    @Test
    public void memoryDatabase() throws DBException, Exception, IOException {
        ConnectionPool connectionPool = new ConnectionPoolImpl(SQLite.driverName, SQLite.getMemoryDatabaseAddress());
        SQLiteAccess query = new SQLiteAccess(connectionPool);

        query.createTable("person", RelationBuilder.createRelation(Person.class));
        query.insert("person", new Person(1, "leo"));
        query.insert("person", new Person(2, "yui"));

        query.query("select * from person", Person.class, new BeanResultHandler<Person>() {
            public void handle(Person p) throws SQLException {
                if (p.getId() == 1) {
                    assertEquals("leo", p.getName());
                }
                else if (p.getId() == 2) {
                    assertEquals("yui", p.getName());
                }
            }

            public void finish() {

            }

            public void init() {

            }

            public void handleException(Exception e) throws Exception {
                _logger.error(e);
            }
        });

        StringWriter writer = new StringWriter();
        query.toJSON("select * from person", Person.class, writer);
        _logger.debug(writer.toString());

        query.dispose();
    }

    @Test
    public void relation() throws DBException {
        Relation r = query.getRelation("person");
        assertNotNull(r);
        assertEquals(2, r.getDataTypeList().size());

        for (DataType dt : r.getDataTypeList()) {
            if (dt.getName().equals("id"))
                assertEquals("integer", dt.getTypeName());
            else if (dt.getName().equals("name"))
                assertEquals("string", dt.getTypeName());
            else
                fail("invalid data type" + dt.toString());
        }

    }

    @Test
    public void preapredStatement() throws DBException {
        SQLiteAccess query = new SQLiteAccess(); // prepare a memory database
        final String blobData = "hello world!";

        query.update("create table blobdata (id integer primary key autoincrement not null, data blob)");
        query.updateWithPreparedStatement("insert into blobdata(data) values(?)", new PreparedStatementHandler() {
            public void setup(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setBytes(1, blobData.getBytes());
            }
        });

        List<BlobData> result = query.query("select * from blobdata", BlobData.class);
        assertEquals(1, result.size());
        assertEquals(blobData, result.get(0).getData());
    }

}
