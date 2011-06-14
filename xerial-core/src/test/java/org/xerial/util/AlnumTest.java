/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// AlnumTest.java
// Since: 2011/06/14 10:56:19
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlnumTest {

    @Test
    public void constructor() throws Exception {
        Alnum a = new Alnum("chr1");
        assertEquals("chr1", a.toString());
        assertEquals("chr", a.prefix);
        assertEquals(1, a.number);

        Alnum b = new Alnum("chr10");
        assertEquals("chr10", b.toString());
        assertEquals("chr", b.prefix);
        assertEquals(10, b.number);

        assertTrue(a.compareTo(b) < 0);
        assertTrue(b.compareTo(a) > 0);
        assertTrue(a.compareTo(a) == 0);

        Alnum c = new Alnum("chr2");
        assertTrue(a.compareTo(c) < 0);
        assertTrue(c.compareTo(a) > 0);

        Alnum d = new Alnum("chr2");
        assertEquals(c.hashCode(), d.hashCode());

    }
}
