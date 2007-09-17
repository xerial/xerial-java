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
// PageBlockTest.java
// Since: 2005/07/24 13:10:31
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

public class PageBlockTest extends TestCase
{
    
    public void testWrite4Bytes()
    {
        PageBlock pb = new PageBlock(1024, PageType.EMPTY);
        
        long value = 0xFE203040;
        pb.write4Bytes(value);
        ByteArrayInputStream bin = pb.getPageBodyInputStream();
        
        assertEquals(0xFE, bin.read());
        assertEquals(0x20, bin.read());
        assertEquals(0x30, bin.read());
        assertEquals(0x40, bin.read());
        
    }
}
