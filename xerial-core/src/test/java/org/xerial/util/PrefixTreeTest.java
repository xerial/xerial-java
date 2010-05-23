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
// PrefixTreeTest.java
// Since: 2010/03/25 23:26:54
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrefixTreeTest {

    PrefixTree<Integer> t;

    @Before
    public void setUp() throws Exception {
        t = new PrefixTree<Integer>();
        t.add("commit", 1);
        t.add("update", 2);
        t.add("checkout", 3);
        t.add("log", 4);
        t.add("config", 5);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void prefix() throws Exception {
        assertEquals(1, t.findBy("com").intValue());
        assertEquals(1, t.findBy("comm").intValue());
        assertEquals(1, t.findBy("commi").intValue());
        assertEquals(1, t.findBy("commit").intValue());
        assertEquals(5, t.findBy("con").intValue());
        assertEquals(5, t.findBy("conf").intValue());
        assertEquals(5, t.findBy("confi").intValue());
        assertEquals(5, t.findBy("config").intValue());

        // prefer the first entry among the same prefix ones
        assertEquals(1, t.findBy("co").intValue());

        assertEquals(2, t.findBy("up").intValue());
        assertEquals(3, t.findBy("ch").intValue());
        assertEquals(4, t.findBy("l").intValue());

    }

}
