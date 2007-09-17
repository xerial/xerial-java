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
// HeapPage.java
// Since: Aug 31, 2007 1:19:43 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.heap;

import java.util.ArrayList;

import org.xerial.db.CommonPageHeader;
import org.xerial.db.DBException;
import org.xerial.db.PageType;
import org.xerial.db.Tuple;
import org.xerial.db.cache.Buffer;
import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;


/**
 * Heap pages support sequential data appends to the database
 * @author leo
 *
 */
public class HeapPage 
{
    private final CommonPageHeader header = new CommonPageHeader();
    private int freePageCursor; 
    private long nextPageID = -1;   // -1 means no next page
    
    private final Buffer pageBuffer;
    
    public HeapPage(Buffer pageBuffer)
    {
        this.pageBuffer = pageBuffer;
    }
    
    public void addEntry(Tuple tuple)
    {
        // write the tuple into the free space
        BufferWriter writer = new BufferWriter(pageBuffer, freePageCursor);
        int tupleSize = tuple.save(writer);
        freePageCursor += tupleSize;
        
        // add the pointer to the entry in the HeapFooter
        
    }
    
    public void loadFromBuffer() throws DBException
    {
        BufferReader reader = new BufferReader(pageBuffer);
        header.load(reader);
        freePageCursor = reader.readInt();
        nextPageID = reader.readLong();
        
        
        if(header.getPageType() != PageType.Heap)
            throw new DBException("not the heap page type: " + header.getPageType());
    }
    
    public void saveToBuffer()
    {
        BufferWriter writer = new BufferWriter(pageBuffer);
        header.save(writer);
        writer.writeInt(freePageCursor);
        writer.writeLong(nextPageID);
    }
    
}


class HeapEntryIndex
{
    private ArrayList<Integer> pointerList = new ArrayList<Integer>();
    

    public void save()
    {
        
    }
    
    
    
}




