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
// RedBlackTreeTest.java
// Since: Dec 5, 2008 6:13:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class RedBlackTreeTest
{
    private static Logger _logger = Logger.getLogger(RedBlackTreeTest.class);

    RedBlackTree<Integer, String> t = new RedBlackTree<Integer, String>();

    @Before
    public void setUp() throws Exception
    {
        TreeMap<Integer, String> competitor = new TreeMap<Integer, String>();

        t.put(10, "world!");
        t.put(5, "hello");
        t.put(20, "nice to meet you");
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testGetKey()
    {
        assertEquals("hello", t.get(5));
        assertEquals("world!", t.get(10));
        assertEquals("nice to meet you", t.get(20));
    }

    @Test
    public void testSize()
    {
        assertEquals(3, t.size());
    }

    @Test
    public void testContains()
    {

        assertTrue(t.containsKey(5));
        assertTrue(t.containsKey(10));
        assertTrue(t.containsKey(20));

        assertTrue(!t.containsKey(0));
        assertTrue(!t.containsKey(34));
        assertTrue(!t.containsKey(102));
        assertTrue(!t.containsKey(-10));
    }

    @Test
    public void testInsert()
    {
        t.put(12, "evil");

        assertEquals("hello", t.get(5));
        assertEquals("world!", t.get(10));
        assertEquals("evil", t.get(12));
        assertEquals("nice to meet you", t.get(20));

        assertTrue(t.containsKey(5));
        assertTrue(t.containsKey(10));
        assertTrue(t.containsKey(20));
        assertTrue(t.containsKey(12));

        assertTrue(!t.containsKey(0));
        assertTrue(!t.containsKey(34));
        assertTrue(!t.containsKey(102));
        assertTrue(!t.containsKey(-10));

        assertEquals(4, t.size());
    }

    @Test
    public void performenceTest()
    {
        RedBlackTree<Integer, String> rt = new RedBlackTree<Integer, String>();

        final int N = 10000;

        Random r = new Random(0);
        StopWatch timer = new StopWatch();
        for (int i = 0; i < N; ++i)
            rt.put(r.nextInt(), null);
        _logger.debug("LLRB: " + timer.getElapsedTime());
        rt.clear();

        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
        r = new Random(0);
        timer.reset();
        for (int i = 0; i < N; ++i)
            tm.put(r.nextInt(), null);
        _logger.debug("RB:   " + timer.getElapsedTime());

    }

}
