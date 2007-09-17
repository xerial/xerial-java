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
// ECNTest.java
// Since: 2005/09/09 11:12:10
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import org.xerial.util.xml.index.ECN;

import junit.framework.TestCase;

public class ECNTest extends TestCase
{
    public void testECN()
    {
        ECN a = new ECN("1.2.349.45.35");
        assertEquals(1, a.get(0));
        assertEquals(2, a.get(1));
        assertEquals(349, a.get(2));
        assertEquals(45, a.get(3));
        assertEquals(35, a.get(4));
    }
    
    public void testCompareTo()
    {
        ECN a = new ECN("1.2.4"), b = new ECN("1.2.5");
        assertTrue(a.compareTo(b) < 0);
        ECN c = new ECN("1.2.4"), d = new ECN("1.2.4.0.0");
        assertTrue(a.compareTo(c) == 0);
        assertTrue(a.compareTo(d) == 0);
    }
}
