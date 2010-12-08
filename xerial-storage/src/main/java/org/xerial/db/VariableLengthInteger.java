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
// VariableLengthInteger.java
// Since: 2005/07/21 14:59:45
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Vector;

import org.xerial.core.XerialException;
import org.xerial.db.cache.Buffer;
import org.xerial.db.cache.BufferWriter;
import org.xerial.db.datatype.TypeInformation;
 
/**
 * Variable length number representation.
 * When the most significant bit (MSB) of a byte is 0, it means the termination of the value,
 * when the MSB of a byte is 1, its following bytes must be read to compute the value. 
 * 
 * 0XXXXXXX                     :   [0, 127 (= M1 - 1)]
 * 1XXXXXXX 0XXXXXXX            :   [M1, M1 + 127 * 2^7 + 127 (= M2-1)]
 * 1XXXXXXX 1XXXXXXX 0XXXXXXX   :   [M2, M2 + 127 * 2^14 + 127 * 2^7 + 127]
 * 
 * [0, 0 + (2 ^ 7 - 1) = 127]
 * [128, 128 + (2^14 - 1) = 16511]
 * [16512, 16512 + (2^21 - 1) = 2113663]
 * @author leo
 *
 */
public class VariableLengthInteger
{
    static private int[] upperBoundByByteSize; 
    static
    {
        Vector<Integer> upperBoundArray = new Vector<Integer>();
        BigInteger previousMaximum = BigInteger.ZERO;
        BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);
        
        
        int byteSize = 1;
        BigInteger valueRange = BigInteger.ZERO;
        while(previousMaximum.compareTo(intMax) < 0)
        {
            valueRange = BigInteger.ZERO.setBit(byteSize++ * 7);
            previousMaximum = previousMaximum.add(valueRange);
            if(previousMaximum.compareTo(intMax) > 0)
                break;
            upperBoundArray.add(previousMaximum.subtract(BigInteger.ONE).intValue());
        }
        
        upperBoundByByteSize = new int[upperBoundArray.size()];
        int i = 0;
        for(int val : upperBoundArray)
        {
            upperBoundByByteSize[i++] = val;
        }
    }

    byte[] _binaryRepresentation = null;
    public VariableLengthInteger(int value)
    {
        translate(value);
    }
    
    public VariableLengthInteger(byte[] byteArray, int offset) throws DBException
    {
        translate(byteArray, offset);
    }
    
    
    
    public byte[] getByte() 
    {
        assert _binaryRepresentation != null;
        return _binaryRepresentation;
    }
    public int size()
    {
        assert _binaryRepresentation != null;
        return _binaryRepresentation.length;
    }

    public int intValue()
    {
        assert _binaryRepresentation != null;
        int value = 0;
        for(int i=0; i<_binaryRepresentation.length; i++)
        {
            value <<= 7;
            value |= _binaryRepresentation[i] & 0x7F;            
        }
        if(_binaryRepresentation.length > 1)
        value += upperBoundByByteSize[_binaryRepresentation.length - 2] + 1;
        return value;
    }
    
    private void translate(int value)
    {
        int byteSize;
        for(byteSize = 1; byteSize <= upperBoundByByteSize.length; byteSize++)
        {
            if(value <= upperBoundByByteSize[byteSize-1])
                break;
        }
        
        if(byteSize > 1)
            value -= upperBoundByByteSize[byteSize-2] + 1;   // subtract offset
        
        _binaryRepresentation = new byte[byteSize];
        int mask = 0x7F << ((byteSize - 1) * 7);
        for(int i=0; i<byteSize; i++)
        {
            _binaryRepresentation[i] = (byte) ((value & mask) >> ((byteSize - (i + 1)) * 7));
            mask >>= 7;
        }
        for(int i=0; i<_binaryRepresentation.length-1; i++)
        {
            _binaryRepresentation[i] |= 0x80;
        }
        
    }

    public static int byteSize(byte[] buffer, int offset) throws DBException
    {
        int byteLength = 1;
        int index = offset;
        while((buffer[index++] & 0x80) != 0)
        {
            byteLength++;
            if(byteLength > upperBoundByByteSize.length)
            {
                throw new DBException(DBErrorCode.InvalidDataFormat, "cannot read the variable length integer whose bite size is larger than " + upperBoundByByteSize.length);
            }
        }
        return byteLength;
        
    }
    
    /**
     * Gets the byte size of the value as an variable length integer
     * @param value
     * @return
     */
    public static int byteSize(int value)
    {
        int byteSize;
        for(byteSize = 1; byteSize <= upperBoundByByteSize.length; byteSize++)
        {
            if(value <= upperBoundByByteSize[byteSize-1])
                break;
        }
        return byteSize;
    }
    
    public static int readFrom(byte[] buffer, int offset) throws DBException
    {
        int value = 0;
        int byteLength = byteSize(buffer, offset);
        if(byteLength > TypeInformation.INT_SIZE)
        {
            if(!(byteLength == (TypeInformation.INT_SIZE + 1) && (buffer[offset] > 0x87)))  // 1000 0111
                throw new DBException(DBErrorCode.InvalidDataFormat, "value larger than 2^31-1 cannot be read");
        }
        
        for(int i=0; i<byteLength; i++)
        {
            value <<= 7;
            value |= buffer[offset+i] & 0x7F;            
        }
        
        return value;
    }
    
    
    public static VariableLengthInteger readFrom(ByteArrayInputStream buffer) throws DBException
    {
        byte[] byteArray = new byte[upperBoundByByteSize.length];
        int size = 0, b;
        while(((b = buffer.read()) & 0x80) != 0)
        {
            byteArray[size++] = (byte) b;
        }
        return new VariableLengthInteger(byteArray, 0);
    }
    
    private void translate(byte[] byteArray, int offset) throws DBException
    {
        int index = offset;
        while(index < byteArray.length)
        {
            if(((int) byteArray[index] & 0x80) == 0)
            {
                int byteSize = index - offset + 1;
                _binaryRepresentation = new byte[byteSize];
                for(int i=0; i<byteSize; i++)
                    _binaryRepresentation[i] = byteArray[offset+i];  
                return;
            }
            index++;
        }
        throw new DBException(DBErrorCode.InvalidDataFormat, "invalid code");
    }
    
    
    public int writeTo(BufferWriter writer)
    {
        for(int i=0; i<_binaryRepresentation.length; i++)
        {
            writer.writeByte(_binaryRepresentation[i]);
        }
        return _binaryRepresentation.length;
    }
    
}
