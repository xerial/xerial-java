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
// PageHeader.java
// Since: Aug 28, 2007 10:05:17 AM
//
// $URL:http://www.xerial.org/svn/project/XerialJ/trunk/XerialJ/src/main/java/org/xerial/db/btree/BTreePageHeader.java $
// $Author:leo $
//--------------------------------------
package org.xerial.db.btree;

import org.xerial.db.CommonPageHeader;
import org.xerial.db.PageHeader;
import org.xerial.db.cache.Buffer;
import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;

/**
 * Header of the page
 * @author leo
 *
 */
public class BTreePageHeader implements PageHeader
{
    private final CommonPageHeader defaultHeader = new CommonPageHeader();
    private int numEntries = 0;
    private boolean isDirty = false;
    
    public BTreePageHeader()
    {
    }
    
    public long getPageID()
    {
        return defaultHeader.getPageID();
    }
    public void setPageID(long pageID)
    {
        defaultHeader.setPageID(pageID);
    }
    

    public int getNumEntries()
    {
        return numEntries;
    }
    
    public void setNumEntries(int numEntries)
    {
        if(numEntries < 0)
            throw new IllegalArgumentException("numEntries cannot be less than 0: " + numEntries);
        this.numEntries = numEntries;
    }
    
    public boolean isDirty()
    {
        return isDirty;
    }
    
    public void setDirty(boolean isDirty)
    {
        this.isDirty = isDirty;
    }

    
    public void save(BufferWriter writer)
    {
        defaultHeader.save(writer);
        writer.writeInt(numEntries);
        writer.writeBoolean(isDirty);
    }
    
    public void load(BufferReader reader)
    {
        defaultHeader.load(reader);
        numEntries = reader.readInt();
        isDirty = reader.readBoolean();
    }

    public int getHeaderSize()
    {
        final int size = Buffer.INT_SIZE + Buffer.BOOLEAN_SIZE;
        return defaultHeader.getHeaderSize() + size;
    }
    

}
