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
// XerialJ Project
//
// PrioritySearchTreeTest.java
// Since: Dec 4, 2009
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrioritySearchTreeTest {

    PrioritySearchTree<String> p;

    @Before
    public void setUp() throws Exception {
        p = new PrioritySearchTree<String>();
        p.insert("A", 1, 2);
        p.insert("B", 2, 4);
        p.insert("C", 1, 8);
        p.insert("D", 3, 3);
        p.insert("E", 5, 6);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testRangeQuery() {

        List<String> result = p.rangeQuery(1, 2, 6);
        assertEquals(2, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));

        result = p.rangeQuery(2, 5, 4);
        assertEquals(2, result.size());
        assertTrue(result.contains("B"));
        assertTrue(result.contains("D"));

        result = p.rangeQuery(2, 5, 10);
        assertEquals(3, result.size());
        assertTrue(result.contains("B"));
        assertTrue(result.contains("E"));
        assertTrue(result.contains("D"));

    }

    @Test
    public void testRemove() {
        p.remove("B", 2, 4);

        List<String> result = p.rangeQuery(1, 2, 6);
        assertEquals(1, result.size());
        assertTrue(result.contains("A"));
        assertFalse(result.contains("B"));

        result = p.rangeQuery(2, 5, 4);
        assertEquals(1, result.size());
        assertTrue(result.contains("D"));

    }

}
