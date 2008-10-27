/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// SinglePathTest.java
// Since: 2004/12/27
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

/**
 * @author leo
 * 
 */
public class SinglePathTest
{
    @Test
    public void testConstructor()
    {
        SinglePath root = SinglePath.rootPath();
        assertEquals(0, root.size());

        SinglePath p = SinglePath.newPath("/book/author");
        assertTrue(p.isAbsolutePath());
        assertEquals(2, p.size());
        assertEquals("book", p.getTag(0));
        assertEquals("author", p.getTag(1));
    }

    @Test
    public void testPathComparator()
    {
        SinglePath p1 = SinglePath.newPath("/book/author");
        SinglePath p2 = new SinglePath(p1, "title");
        assertTrue(p1.compareTo(p2) < 0);
        assertNotSame(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testContainer()
    {
        SinglePath p1 = SinglePath.newPath("/book/author");
        SinglePath p2 = SinglePath.newPath("/book/author");
        SinglePath p3 = SinglePath.newPath("/book/author");
        SinglePath p4 = SinglePath.newPath("/book/author/item");

        HashSet<SinglePath> pathSet = new HashSet<SinglePath>();

        pathSet.add(p1);
        pathSet.add(p2);

        assertTrue(pathSet.contains(p1));
        assertTrue(pathSet.contains(p2));
        assertTrue(pathSet.contains(p3));
        assertFalse(pathSet.contains(p4));

        pathSet.add(p4);

        assertTrue(pathSet.contains(p1));
        assertTrue(pathSet.contains(p2));
        assertTrue(pathSet.contains(p3));
        assertTrue(pathSet.contains(p4));

    }
}
