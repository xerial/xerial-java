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
// IndexedSetTest.java
// Since: 2008/11/08 12:26:16
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class IndexedSetTest
{

    @Test
    public void testGetID()
    {
        IndexedSet<String> s = new IndexedSet<String>();
        s.add("A");
        s.add("B");

        int idOfA = s.getID("A");
        int idOfB = s.getID("B");

        assertNotSame(IndexedSet.INVALID_ID, idOfA);
        assertNotSame(IndexedSet.INVALID_ID, idOfB);
        assertNotSame(idOfA, idOfB);
        assertEquals(0, idOfA);
        assertEquals(1, idOfB);

        assertTrue(s.contains("A"));
        assertTrue(s.contains("B"));

        assertEquals("A", s.getByID(idOfA));
        assertEquals("B", s.getByID(idOfB));
    }

    @Test
    public void testAddAll()
    {
        IndexedSet<String> s = new IndexedSet<String>();

        ArrayList<String> l = new ArrayList<String>();
        l.add("A");
        l.add("B");

        s.addAll(l);

        int idOfA = s.getID("A");
        int idOfB = s.getID("B");

        assertNotSame(IndexedSet.INVALID_ID, idOfA);
        assertNotSame(IndexedSet.INVALID_ID, idOfB);
        assertNotSame(idOfA, idOfB);

        assertTrue(s.contains("A"));
        assertTrue(s.contains("B"));

    }

    @Test
    public void testClear()
    {
        IndexedSet<String> s = new IndexedSet<String>();
        s.add("A");
        s.add("B");

        assertEquals(2, s.size());
        assertNotSame(IndexedSet.INVALID_ID, s.getID("A"));
        assertNotSame(IndexedSet.INVALID_ID, s.getID("B"));

        s.clear();
        assertEquals(0, s.size());
        assertEquals(IndexedSet.INVALID_ID, s.getID("A"));
    }

    @Test
    public void testContainsAll()
    {
        IndexedSet<String> s = new IndexedSet<String>();
        s.add("A");
        s.add("B");
        s.add("C");

        ArrayList<String> l = new ArrayList<String>();
        l.add("A");
        l.add("C");
        assertTrue(s.containsAll(l));
    }

    @Test
    public void testIsEmpty()
    {
        IndexedSet<String> s = new IndexedSet<String>();
        assertTrue(s.isEmpty());
        s.add("A");

        assertFalse(s.isEmpty());

    }

    @Test
    public void testIterator()
    {
        Set<String> orig = new HashSet<String>();
        orig.add("A");
        orig.add("B");
        orig.add("C");

        IndexedSet<String> s = new IndexedSet<String>();
        s.addAll(orig);

        for (String element : s)
        {
            assertTrue(orig.contains(element));
        }

    }

    @Test
    public void testRemove()
    {
        IndexedSet<String> s = new IndexedSet<String>();
        s.add("A");
        s.add("B");

        assertTrue(s.contains("A"));
        assertTrue(s.contains("B"));
        s.remove("B");
        assertTrue(s.contains("A"));
        assertFalse(s.contains("B"));

    }

    @Test
    public void testRemoveAll()
    {
        IndexedSet<String> s = new IndexedSet<String>();
        s.add("A");
        s.add("B");
        s.add("C");

        Set<String> l = new HashSet<String>();
        l.add("C");
        l.add("A");

        s.removeAll(l);
        assertTrue(s.contains("B"));
        assertFalse(s.contains("A"));
        assertFalse(s.contains("C"));

    }

}
