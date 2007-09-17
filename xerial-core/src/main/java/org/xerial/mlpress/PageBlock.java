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
// PageBlock.java
// Since: 2005/07/21 1:38:52
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.xerial.core.XerialException;


enum PageType { EMPTY, ARCHIVE_HEADER, DICTIONARY, TREE_STRUCTURE, TEXT, PAGE_INDEX };

class PageHeader
{
    PageType pageType;
    
    public PageHeader(PageType pageType)
    {
        this.pageType = pageType;
    }
    
    void load(PageBlock pb)
    {
        pageType = PageType.values()[pb.read()];
    }
    void store(PageBlock pb)
    {
        pb.write(pageType.ordinal());
    }
    
    int size()
    {
        return 1;   // PageType
    }
}

class Entry
{
    // EntryHeader
    private VariableLengthInteger entry_id = null;
    private VariableLengthInteger size = null;      // size of the entry data
    private VariableLengthInteger nextPageID = null;    // 0: the last of the chain. otherwise: next pageID
    // EntryData
    private byte[] _entryData = null;
    
    public Entry(ByteArrayInputStream pageBuffer) throws XerialException, IOException
    {
        entry_id = VariableLengthInteger.readFrom(pageBuffer);
        size = VariableLengthInteger.readFrom(pageBuffer);
        nextPageID = VariableLengthInteger.readFrom(pageBuffer);
        
        _entryData = new byte[size.intValue()];
        pageBuffer.read(_entryData); 
    }
    
    public Entry(int id, int size, int nextPageID, byte[] data)
    {
        this.entry_id = new VariableLengthInteger(id);
        this.size = new VariableLengthInteger(size);
        this.nextPageID = new VariableLengthInteger(nextPageID);
        _entryData = data;
    }

    public VariableLengthInteger getId()
    {
        return entry_id;
    }

    public void setId(VariableLengthInteger id)
    {
        this.entry_id = id;
    }

    public VariableLengthInteger getNextPageID()
    {
        return nextPageID;
    }

    public void setNextPageID(VariableLengthInteger nextPageID)
    {
        this.nextPageID = nextPageID;
    }

    public VariableLengthInteger getSize()
    {
        return size;
    }

    public void setSize(VariableLengthInteger size)
    {
        this.size = size;
    }
    
    
    
}


/**
 * PageBlock represents a unit to read/write a disk page.
 * 
 * 
 * | PageHeader | PageBody  ............................|
 * | page type  | page type specific info | entries ... | 
 * 
 * @author leo
 *
 */
class PageBlock
{
    private PageHeader _pageHeader = null;
    private long    _nextPageID = 0;
    private byte[] _buf = null;                  
    private int _pageSize;
    private int _cursor = 0;

    public PageBlock(int pageSize, PageType pageType)
    {
        _buf = new byte[pageSize];        
        _pageSize = pageSize;
        
        _pageHeader = new PageHeader(pageType);
        _pageHeader.store(this);
    }
        
    public PageHeader getPageHeader()
    {
        return _pageHeader;
    }
    public ByteArrayInputStream getPageBodyInputStream()
    {
        int pageHeaderSize = _pageHeader.size();
        return new ByteArrayInputStream(_buf, pageHeaderSize, _pageSize - pageHeaderSize );
    }
    
    public byte[] read(int length)
    {
        byte[] readData = new byte[length];
        for(int i=0; i<length; i++)
        {
            readData[i] = _buf[_cursor++];
        }
        return readData;
    }
    /**
     * Reads the next byte of data 
     * @return
     */
    public int read()
    {
        return _buf[_cursor++];
    }
    
    /**
     * write a long value as 4 bytes data in the big-endian format 
     * @param value
     */
    public void write4Bytes(long value)
    {
        long mask = 0xFF000000;
        for(int i=0; i<4; i++)
        {
            int v = (int) ( (value & mask) >> (24 - 8 * i));
            write(v);
            mask >>= 8;
        }
    }
    
    
    public void write(VariableLengthInteger v)
    {
        write(v.getByte());
    }
    
    public void write(int b)
    {
        _buf[_cursor++] = (byte) b;
    }
    
    public void write(byte[] data)
    {
        for(int i=0; i<data.length; i++)
            _buf[_cursor++] = data[i];
    }
    
    public void moveCursor(int cursorPosition)
    {
        assert cursorPosition < _pageSize;
        _cursor =- cursorPosition;
    }
}


class TreeStructurePageBlock extends PageBlock
{
    public TreeStructurePageBlock(int pageSize)
    {
        super(pageSize, PageType.TREE_STRUCTURE);
    }
    
    
}


    

