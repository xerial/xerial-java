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
// BTreePerformanceTest.java
// Since: Jun 21, 2009 6:09:11 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.benchmark;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;

public class BTreePerformanceTest
{
    private static Logger _logger = Logger.getLogger(BTreePerformanceTest.class);
    private int N = 1000000;
    int valueLen = 50;
    private String testString = "hello";

    private ArrayList<Integer> idList;

    @Before
    public void setUp() throws Exception
    {
        Class.forName("org.sqlite.JDBC");

    }

    @After
    public void tearDown() throws Exception
    {}

    @Ignore
    @Test
    public void btreeSearchTest() throws Exception
    {
        System.out.println("drive\toperation\tN\tpercentage\trecord\ttime");

        //        for (int l : new int[] { 10, 100, 500, 1000, 1500 })

        for (int n : new int[] { 10000, 50000, 100000 })
        {
            N = n;
            for (int l : new int[] { 50 })
            {
                setValueLen(l);
                searchTest("Intel", new File("P:"));
                searchTest("Buffalo", new File("Q:"));
                searchTest("HDD", new File("F:"));
                searchTest("memory", new File("F:"));
            }
        }
    }

    public void setValueLen(int valueLen)
    {
        this.valueLen = valueLen;
        StringBuilder buf = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < valueLen; ++i)
        {
            buf.append((char) ('a' + (char) r.nextInt(25)));
        }
        testString = buf.toString();
    }

    boolean shuffle = true;

    @Ignore
    @Test
    public void btreeInsert() throws Exception
    {
        shuffle = false;
        btreeInsertSub();
        shuffle = true;
        btreeInsertSub();
    }

    public void btreeInsertSub() throws Exception
    {
        idList = new ArrayList<Integer>(N);
        System.out.println("drive\toperation\tN\trecord\ttime\tshuffle");
        for (int i = 0; i < N; ++i)
        {
            idList.add(i);
        }
        if (shuffle)
        {
            Collections.shuffle(idList);
        }

        //        int[] tupleSize = { 10, 100, 500 };
        int[] tupleSize = { 500 };
        //        for (int n : new int[] { 10000, 50000, 100000 })
        for (int n : new int[] { 100000 })
        {
            N = n;
            for (int t : tupleSize)
            {
                setValueLen(t);

                final int repeat = 3;
                for (int i = 0; i < repeat; ++i)
                    insertTest("Intel", new File("P:"));
                for (int i = 0; i < repeat; ++i)
                    insertTest("Buffalo", new File("Q:"));
                for (int i = 0; i < repeat; ++i)
                    insertTest("HDD", new File("F:"));
            }
        }

    }

    public void searchTest(String name, File folder) throws Exception
    {

        StopWatch timer = new StopWatch();

        File tmpFolder = new File(folder, "sqlite");
        tmpFolder.mkdirs();

        File tmpFile = File.createTempFile("tmp", ".sqlite", tmpFolder);
        try
        {
            Connection conn;
            if (!name.equals("memory"))
                conn = DriverManager.getConnection("jdbc:sqlite:" + tmpFile.getAbsolutePath());
            else
                conn = DriverManager.getConnection("jdbc:sqlite::memory:");

            Statement stat = conn.createStatement();
            stat.execute("pragma synchronous=off");
            stat.executeUpdate("create table A (id integer primary key, data text)");

            stat.execute("begin transaction");
            PreparedStatement prep = conn.prepareStatement(String.format("insert into A(id, data) values(?,'%s')",
                    testString));
            for (int i = 0; i < N; ++i)
            {
                prep.setInt(1, i);
                prep.execute();
            }
            stat.execute("commit");

            int[] plist = { 5, 10, 25, 101 };
            for (int percentage : plist)
            {

                PreparedStatement prep2 = conn.prepareStatement(String.format("select * from A where id = ?"));
                PreparedStatement prep3 = conn.prepareStatement(String.format("select * from A"));

                Random r = new Random();
                timer.reset();

                if (percentage > 100)
                {
                    ResultSet rs = prep3.executeQuery();
                    while (rs.next())
                    {}
                    rs.close();
                }
                else
                {
                    int numSearch = (int) ((double) N * (double) percentage / 100.0);

                    for (int i = 0; i < numSearch; ++i)
                    {
                        int id = r.nextInt(N);
                        prep2.setInt(1, id);
                        ResultSet rs = prep2.executeQuery();
                        while (rs.next())
                        {}
                        rs.close();
                    }
                }

                double time = timer.getElapsedTime();

                System.out.println(String.format("%s\tsearch\t%d\t%s\t%d\t%4.2f", name, N,
                        percentage > 100 ? "fullscan" : percentage, valueLen, time));

            }

            stat.close();
            conn.close();
        }
        finally
        {
            tmpFile.delete();
        }

    }

    public void insertTest(String name, File folder) throws Exception
    {

        StopWatch timer = new StopWatch();

        File tmpFolder = new File(folder, "sqlite");
        tmpFolder.mkdirs();

        File tmpFile = File.createTempFile("tmp", ".sqlite", tmpFolder);
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + tmpFile.getAbsolutePath());
            Statement stat = conn.createStatement();
            stat.execute("pragma synchronous=off");
            stat.executeUpdate("create table A (id integer primary key, data text)");
            timer.reset();

            stat.execute("begin transaction");
            PreparedStatement prep = conn.prepareStatement(String.format("insert into A(id, data) values(?,'%s')",
                    testString));
            for (int i = 0; i < N; ++i)
            {
                int id = idList.get(i);
                prep.setInt(1, id);
                prep.execute();
            }

            stat.execute("commit");
            double time = timer.getElapsedTime();

            System.out.println(String.format("%s\tinsert\t%10d\t%d\t%4.2f\t%s", name, N, valueLen, time,
                    shuffle ? "random" : "incr"));

            // search test
            //            for(int i=0; i<N; ++i)
            //            {
            //                stat.executeQuery(String.format("select from A where id = %d");
            //                
            //            }
            //            

            stat.close();
            conn.close();
        }
        finally
        {
            tmpFile.delete();
        }

    }
}
