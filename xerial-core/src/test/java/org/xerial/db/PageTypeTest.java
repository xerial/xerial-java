/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// PageTypeTest.java
// Since: Aug 31, 2007 10:09:54 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageTypeTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void validity()
    {
        assertTrue(PageType.isValidPageType(PageType.DatabaseInformation));
        assertTrue(PageType.isValidPageType(PageType.BTreeRoot));
        assertTrue(PageType.isValidPageType(PageType.BTreeInternalNode));
        assertTrue(PageType.isValidPageType(PageType.BTreeLeaf));
        assertTrue(PageType.isValidPageType(PageType.BTreeData));
        assertTrue(PageType.isValidPageType(PageType.FreePageBitMap));
        assertTrue(PageType.isValidPageType(PageType.Heap));
        assertTrue(PageType.isValidPageType(PageType.HeapIndex));

        assertTrue(PageType.isValidPageType(PageType.Unknown));
        assertFalse(PageType.isValidPageType(-1));
    }
    
}
