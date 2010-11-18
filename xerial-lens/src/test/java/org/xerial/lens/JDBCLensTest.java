/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// JDBCLensTest.java
// Since: Dec 21, 2009 4:53:09 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.bean.BeanHandler;
import org.xerial.util.log.Logger;

public class JDBCLensTest {

    private static Logger _logger = Logger.getLogger(JDBCLensTest.class);

    Connection conn = null;
    Statement stat = null;

    @Before
    public void setUp() throws Exception {

        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:");
        stat = conn.createStatement();

        stat.executeUpdate("create table person(id integer, name string)");
        stat.executeUpdate("insert into person values(1, 'leo')");
        stat.executeUpdate("insert into person values(2, 'yui')");
        stat.executeUpdate("insert into person values(3, 'bob')");
        stat.executeUpdate("insert into person values(4, 'alice')");

    }

    @After
    public void tearDown() throws Exception {

        if (stat != null)
            stat.close();
        if (conn != null)
            conn.close();

    }

    public static class Person {
        public int id;
        public String name;
    }

    @Test
    public void mapAll() throws Exception {
        JDBCLens<Person> jl = new JDBCLens<Person>(Person.class);

        jl.mapAll(stat.executeQuery("select * from person"), new BeanHandler<Person>() {
            public void handle(Person p) throws Exception {
                assertNotNull(p);
                switch (p.id) {
                case 1:
                    assertEquals("leo", p.name);
                    break;
                case 2:
                    assertEquals("yui", p.name);
                    break;
                case 3:
                    assertEquals("bob", p.name);
                    break;
                case 4:
                    assertEquals("alice", p.name);
                    break;

                }
            }

            public void handleException(Exception e) {
                _logger.error(e);
            }
        });

    }

    @Test
    public void getBeanList() throws Exception {
        JDBCLens<Person> jl = new JDBCLens<Person>(Person.class);
        List<Person> pl = jl.mapAll(stat.executeQuery("select * from person"));
        assertEquals(4, pl.size());

    }

    public static class DataTypes {
        public boolean flag = false;
        public double d;
        public Date time;

    }

    @Test
    public void dataType() throws Exception {

        DateFormat df = DateFormat.getDateTimeInstance();
        Date today = new Date();
        today = df.parse(df.format(today));

        stat.executeUpdate("create table dt (flag boolean, d float, time datetime)");
        stat.executeUpdate(String.format("insert into dt values('true', 0.344, '%s')", df
                .format(today)));

        JDBCLens<DataTypes> jl = new JDBCLens<DataTypes>(DataTypes.class);
        List<DataTypes> r = jl.mapAll(stat.executeQuery("select * from dt"));
        assertEquals(1, r.size());

        DataTypes d = r.get(0);
        assertEquals(0.344d, d.d, 0.01);
        assertEquals(true, d.flag);
        assertEquals(today, d.time);
    }

    public static class Blob {
        public byte[] binary;
    }

    public static class Blob2 {
        private byte[] binary;

        public byte[] getBinary() {
            return binary;
        }

        public void setBinary(byte[] binary) {
            this.binary = binary;
        }

    }

    @Test
    public void blob() throws Exception {
        stat.executeUpdate("create table blob (binary blob)");
        PreparedStatement prep = conn.prepareStatement("insert into blob values(?)");
        byte[] bin = new byte[10];
        for (int i = 0; i < bin.length; i++)
            bin[i] = (byte) (i * 2);
        prep.setBytes(1, bin);
        prep.executeUpdate();

        JDBCLens<Blob> jl = new JDBCLens<Blob>(Blob.class);
        List<Blob> bl = jl.mapAll(stat.executeQuery("select * from blob"));
        assertEquals(1, bl.size());

        Blob b = bl.get(0);
        assertEquals(bin.length, b.binary.length);
        for (int i = 0; i < bin.length; i++)
            assertEquals(bin[i], b.binary[i]);

        // get/set blob
        JDBCLens<Blob2> jl2 = new JDBCLens<Blob2>(Blob2.class);
        List<Blob> bl2 = jl.mapAll(stat.executeQuery("select * from blob"));
        assertEquals(1, bl2.size());

        Blob b2 = bl2.get(0);
        assertEquals(bin.length, b2.binary.length);
        for (int i = 0; i < bin.length; i++)
            assertEquals(bin[i], b2.binary[i]);

    }

    public static class BlobString {
        public String data;
    }

    @Test
    public void blobToString() throws Exception {
        BlobString b = new BlobString();
        b.data = "hello world!";

        stat.executeUpdate("create table b (data blob)");
        PreparedStatement p = conn.prepareStatement("insert into b values(?)");
        p.setBytes(1, b.data.getBytes());
        p.executeUpdate();

        JDBCLens<BlobString> lens = new JDBCLens<BlobString>(BlobString.class);
        List<BlobString> bs = lens.mapAll(stat.executeQuery("select * from b"));
        assertEquals(1, bs.size());
        BlobString b2 = bs.get(0);

        assertEquals(b.data, b2.data);
    }

}
