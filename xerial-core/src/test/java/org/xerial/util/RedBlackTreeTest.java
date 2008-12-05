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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RedBlackTreeTest
{
    RedBlackTree<Integer, String> t = new RedBlackTree<Integer, String>();

    @Before
    public void setUp() throws Exception
    {
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
    public void testContains()
    {

        assertTrue(t.contains(5));
        assertTrue(t.contains(10));
        assertTrue(t.contains(20));

        assertTrue(!t.contains(0));
        assertTrue(!t.contains(34));
        assertTrue(!t.contains(102));
        assertTrue(!t.contains(-10));
    }

    @Test
    public void testInsert()
    {
        t.put(12, "evil");

        assertEquals("hello", t.get(5));
        assertEquals("world!", t.get(10));
        assertEquals("evil", t.get(12));
        assertEquals("nice to meet you", t.get(20));

        assertTrue(t.contains(5));
        assertTrue(t.contains(10));
        assertTrue(t.contains(20));
        assertTrue(t.contains(12));

        assertTrue(!t.contains(0));
        assertTrue(!t.contains(34));
        assertTrue(!t.contains(102));
        assertTrue(!t.contains(-10));
    }

}
