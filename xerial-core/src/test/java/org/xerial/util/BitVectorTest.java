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
// BitVectorTest.java
// Since: 2008/11/08 10:01:51
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.xerial.util.log.Logger;

public class BitVectorTest
{
    private static Logger _logger = Logger.getLogger(BitVectorTest.class);

    @Test
    public void testBitVector()
    {
        BitVector bv = new BitVector();
        bv.on(1);
        assertEquals("01", bv.toString());
        assertEquals(2, bv.size());

        bv.on(5);
        assertEquals("010001", bv.toString());
        assertEquals(6, bv.size());

    }

    @Test
    public void testSetAndGet()
    {
        BitVector bv = new BitVector();
        for (int i = 0; i < 10000; i++)
        {
            assertFalse(bv.get(i));
            bv.set(i, true);
            assertTrue(bv.get(i));
        }

    }

    @Test
    public void testOnOff()
    {
        BitVector bv = new BitVector();
        for (int i = 0; i < 10000; i++)
        {
            assertFalse(bv.get(i));
            bv.on(i);
            assertTrue(bv.get(i));
        }

        int[] pos = { 1, 34, 5093, 443, 4 };
        for (int offIndex : pos)
        {
            bv.off(offIndex);
            assertFalse(bv.get(offIndex));
        }
        
        

    }

    @Test
    public void testEqualsObject()
    {
        BitVector bv = new BitVector();
        BitVector bv2 = new BitVector();
        int[] pos = { 1, 34, 43, 13, 4 };
        for(int index : pos)
        {
            bv.on(index);
            bv2.on(index);
            assertTrue(bv.get(index));
            assertTrue(bv2.get(index));
        }
        
        assertEquals(bv, bv2);
        assertEquals(bv.hashCode(), bv2.hashCode());
        assertEquals(bv.size(), bv2.size());

        bv2.on(55);
        assertNotSame(bv, bv2);
        assertNotSame(bv.size(), bv2.size());
    }

    @Test
    public void testNewInstance()
    {
        BitVector bv = new BitVector();
        int[] pos = { 1, 34, 43, 13, 4 };
        for (int index : pos)
        {
            bv.on(index);
            assertTrue(bv.get(index));
        }

        BitVector bv2 = BitVector.newInstance(bv);
        assertEquals(bv, bv2);
        assertEquals(bv.hashCode(), bv2.hashCode());
        assertEquals(bv.size(), bv2.size());

        bv2.on(55);
        assertNotSame(bv, bv2);
        assertNotSame(bv.size(), bv2.size());

    }

}
