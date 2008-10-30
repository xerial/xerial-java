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
// RangeTest.java
// Since: Oct 30, 2008 12:35:02 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void overlap()
    {
        Range r1 = new Range(5, 10);

        Range r2 = new Range(0, 3);
        Range r3 = new Range(1, 8);
        Range r4 = new Range(6, 9);
        Range r5 = new Range(7, 13);
        Range r6 = new Range(15, 20);

        assertFalse(r1.overlaps(r2));
        assertFalse(r2.overlaps(r1));

        assertTrue(r1.overlaps(r3));
        assertTrue(r3.overlaps(r1));

        assertTrue(r1.overlaps(r4));
        assertTrue(r4.overlaps(r1));

        assertTrue(r1.overlaps(r5));
        assertTrue(r5.overlaps(r1));

        assertFalse(r1.overlaps(r6));
        assertFalse(r6.overlaps(r1));

    }

    @Test
    public void toStringTest()
    {
        Range r1 = new Range(5, 10);
        r1.toString();
    }

}
