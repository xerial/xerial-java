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
// PageCache.java
// Since: Aug 28, 2007 10:02:59 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.btree;

import org.xerial.db.cache.Buffer;
import org.xerial.db.cache.BufferReader;

public class BTreePage
{
    private final Buffer buffer; 
    private final BTreePageHeader header = new BTreePageHeader();
    
    public BTreePage(Buffer buffer)
    {
        this.buffer = buffer;
        header.load(new BufferReader(buffer));
    }
    
    public BTreePageHeader getHeader()
    {
        return header;
    }
    
    
    
}
