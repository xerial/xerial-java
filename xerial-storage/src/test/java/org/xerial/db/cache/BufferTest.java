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
// BufferTest.java
// Since: Aug 30, 2007 8:08:28 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.cache;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.db.DBException;
import org.xerial.db.datatype.TypeInformation;
import org.xerial.db.storage.DBFile;
import org.xerial.db.storage.MemoryFile;

public class BufferTest
{
    Buffer buffer = null;
    
    @Before
    public void setUp() throws Exception
    {
        buffer = new Buffer(1024);
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testBufferInt()
    {
        assertEquals(Integer.SIZE / 8, TypeInformation.INT_SIZE); 
    }

    @Test
    public void testSize()
    {
        assertEquals(1024, buffer.size());
    }

    @Test
    public void testReadInt()
    {
        buffer.writeInt(0, 41431);
        assertEquals(41431, buffer.readInt(0));

        
        buffer.writeInt(100, 234243);
        assertEquals(234243, buffer.readInt(100));
    }

    @Test
    public void testReadByte()
    {
        buffer.writeByte(0, 43);
        assertEquals((byte)43, buffer.readByte(0));
        
        buffer.writeByte(400, 4531);
        assertEquals((byte) 4531, buffer.readByte(400));
    }

    @Test
    public void testReadLong()
    {
        long v = 434143143434444L;
        buffer.writeLong(0, v);
        assertEquals(v, buffer.readLong(0));
        
        long v2 = 134134141351351353L;
        buffer.writeLong(100, v2);
        assertEquals(v2, buffer.readLong(100));
    }

    @Test
    public void testIsSet()
    {
        buffer.set(0, 0, true);
        buffer.set(0, 5, true);
        buffer.set(14, 3, true);
        buffer.set(14, 4, false);
        
        assertEquals(true, buffer.isSet(0, 0));
        assertEquals(true, buffer.isSet(0, 5));
        assertEquals(true, buffer.isSet(14, 3));
        assertEquals(false, buffer.isSet(14, 4));
    }

    @Test
    public void testSaveLoad() throws DBException
    {
        DBFile file = new MemoryFile();
        
        buffer.writeInt(0, 3044);
        buffer.writeLong(4, 1034134434L);
        
        file.seek(0);
        buffer.save(file);
        
        byte[] readBuf = new byte[1024];
        file.seek(0);
        file.read(readBuf, 0, 16);
        
        Buffer buffer2 = new Buffer(readBuf);
        
        assertEquals(3044, buffer2.readInt(0));
        assertEquals(1034134434L, buffer2.readLong(4));
        
        
        // load test
        Buffer buffer3 = new Buffer(1024);
        file.seek(0);
        buffer3.load(file);
        
        assertEquals(3044, buffer3.readInt(0));
        assertEquals(1034134434L, buffer3.readLong(4));
    }


}
