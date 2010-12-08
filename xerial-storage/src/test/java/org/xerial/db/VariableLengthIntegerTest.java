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
// VariableLengthIntegerTest.java
// Since: 2005/07/21 16:35:00
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import org.xerial.core.XerialException;
import org.xerial.db.VariableLengthInteger;
import org.xerial.db.cache.Buffer;
import org.xerial.db.cache.BufferWriter;

import junit.framework.TestCase;

public class VariableLengthIntegerTest extends TestCase
{
    public void testInit()
    {
        VariableLengthInteger v = new VariableLengthInteger(127);
        assertEquals(1, v._binaryRepresentation.length);
        assertEquals((byte)0x7F, v._binaryRepresentation[0]);
                
    }
    
    public void testInit2()
    {
        VariableLengthInteger v = new VariableLengthInteger(16511);
        assertEquals(2, v._binaryRepresentation.length);
        assertEquals((byte) 0xFF, v._binaryRepresentation[0]);
        assertEquals((byte) 0x7F, v._binaryRepresentation[1]);
    }

    public void testTranslate() throws XerialException
    {
        byte[] buf = { 0x7F };
        VariableLengthInteger v = new VariableLengthInteger(buf, 0);
        assertEquals(127, v.intValue());
    }
    
    
    public void testTranslate2() throws XerialException
    {
        byte[] buf = { (byte) 0xFF, 0x7F };
        VariableLengthInteger v = new VariableLengthInteger(buf, 0);
        assertEquals(16511,v.intValue());
        
    }
    
    public void buffer()
    {
        Buffer buffer = new Buffer(1024);
        VariableLengthInteger v = new VariableLengthInteger(143);
        
        BufferWriter writer = new BufferWriter(buffer);
        v.writeTo(writer);
        
        //VariableLengthInteger.readFrom(
    }
}
