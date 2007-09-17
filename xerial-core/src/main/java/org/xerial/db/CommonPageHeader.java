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
// Since: Aug 28, 2007 11:34:35 AM
//
// $URL:http://www.xerial.org/svn/project/XerialJ/trunk/XerialJ/src/main/java/org/xerial/db/cache/PageHeader.java $
// $Author:leo $
//--------------------------------------
package org.xerial.db;

import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;


/**
 * Header of the disk page
 * @author leo
 *
 */
public class CommonPageHeader implements PageHeader
{
    private long pageID = -1;    // the default is set to the invalid page ID, -1 
    private int pageType = PageType.Unknown;    //  
    
    public CommonPageHeader()
    {}
    
    
    public long getPageID()
    {
        return pageID;
    }

    public void setPageID(long pageID)
    {
        if(pageID < 0)
            throw new IllegalArgumentException("invalid page ID: " + pageID);
        
        this.pageID = pageID;
    }
    
    public int getPageType()
    {
        return pageType;
    }

    public void setPageType(int pageType)
    {
        if(!PageType.isValidPageType(pageType))
            throw new IllegalArgumentException("invalid page type: " + pageType);
        
        this.pageType = pageType;
    }


    public void save(BufferWriter writer)
    {
        writer.writeLong(getPageID());
        writer.writeInt(getPageType());
    }
    public void load(BufferReader reader)
    {
        setPageID(reader.readLong());
        setPageType(reader.readInt());
    }


    public int getHeaderSize()
    {
        final int size = 4 + 8; 
        return size;
    }
    
}
