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
// BufferWriterTest.java
// Since: Aug 30, 2007 9:19:55 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BufferWriterTest
{

    Buffer buffer;
    BufferReader reader;
    BufferWriter writer;

    @Before
    public void setUp() throws Exception
    {
        buffer = new Buffer(1024);
        reader = new BufferReader(buffer);
        writer = new BufferWriter(buffer);
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testWrite()
    {
        writer.writeInt(434);
        writer.writeInt(1324);
        writer.writeLong(431431L);
        writer.writeLong(10000341431L);
        writer.writeBoolean(true);
        writer.writeByte((byte) 4);
        writer.writeInt(443);
        writer.writeBoolean(false);

        assertEquals(434, reader.readInt());
        assertEquals(1324, reader.readInt());
        assertEquals(431431L, reader.readLong());
        assertEquals(10000341431L, reader.readLong());
        assertEquals(true, reader.readBoolean());
        assertEquals((byte) 4, reader.readByte());
        assertEquals(443, reader.readInt());
        assertEquals(false, reader.readBoolean());
    }

}
