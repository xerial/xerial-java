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
// Buffer.java
// Since: Aug 23, 2007 11:26:43 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.cache;

import org.xerial.db.storage.DBFile;
import org.xerial.db.storage.DBFileException;

/**
 * Buffer to read/write raw memory data
 * @author leo
 *
 */
public class Buffer {

    public static final int BYTE_SIZE = 1;
    public static final int CHAR_SIZE = 2;
    public static final int INT_SIZE = 4;
    public static final int LONG_SIZE = 8;
    public static final int BOOLEAN_SIZE = 1;
    
    
	private final byte[] buffer;

	public Buffer(final int bufferByteSize)
	{
		buffer = new byte[bufferByteSize];
	}
	public Buffer(final byte[] buffer)
	{
	    this.buffer = buffer;
	}
	
	
	public int size()
	{
	    return buffer.length; 
	}
	
	/**
	 * Reads an 32-bit integer (Big-endian) from the specified byte position. 
	 * 
	 * @param pos
	 * @return 
	 */
	public int readInt(int pos)
	{
		int b1 = (buffer[pos] & 0xFF) << 24;
		int b2 = (buffer[pos+1] & 0xFF) << 16;
		int b3 = (buffer[pos+2] & 0xFF) << 8;
		int b4 = buffer[pos+3] & 0xFF;
		return b1 | b2 | b3 | b4;
	}
	
	public byte readByte(int pos)
	{
		return buffer[pos];
	}
	
	public long readLong(int pos)
	{
	    return (((long)(buffer[pos]   & 0xff) << 56) |
	             ((long)(buffer[pos+1] & 0xff) << 48) |
	             ((long)(buffer[pos+2] & 0xff) << 40) |
	             ((long)(buffer[pos+3] & 0xff) << 32) |
	             ((long)(buffer[pos+4] & 0xff) << 24) |
	             ((long)(buffer[pos+5] & 0xff) << 16) |
 	             ((long)(buffer[pos+6] & 0xff) <<  8) |
	             ((long)(buffer[pos+7] & 0xff)));
	}
	
	public boolean readBoolean(int pos)
	{
	    return readByte(pos) > 0;
	}
	
	public boolean isSet(int bytePos, int bitPositionFromMSB)
	{
	    assert(bitPositionFromMSB >= 0 && bitPositionFromMSB < 8);
	    return (buffer[bytePos] & (0x80 >> bitPositionFromMSB)) != 0;  
	}
	
	public void set(int bytePos, int bitPositionFromMSB, boolean value)
	{
        assert(bitPositionFromMSB >= 0 && bitPositionFromMSB < 8);
	    if(value)
	        buffer[bytePos] = (byte) (buffer[bytePos] | (0x80 >> bitPositionFromMSB));
	    else
	        buffer[bytePos] = (byte) (buffer[bytePos] & ~(0x80 >> bitPositionFromMSB));
	}
	
	public void writeByte(int pos, int b)
	{
		buffer[pos] = (byte) b;
	}
	
	public void writeInt(int pos, int value)
	{
	    buffer[pos++] = (byte) ((value >> 24) & 0xFF);
		buffer[pos++] = (byte) ((value >> 16) & 0xFF);
		buffer[pos++] = (byte) ((value >>  8) & 0xFF);
		buffer[pos++] = (byte) ((value >>  0) & 0xFF);
	}
	
	public void writeLong(int pos, long value)
	{
	    buffer[pos++] = (byte) (0xff & (value >> 56));
	    buffer[pos++] = (byte) (0xff & (value >> 48));
	    buffer[pos++] = (byte) (0xff & (value >> 40));
	    buffer[pos++] = (byte) (0xff & (value >> 32));
	    buffer[pos++] = (byte) (0xff & (value >> 24));
	    buffer[pos++] = (byte) (0xff & (value >> 16));
	    buffer[pos++] = (byte) (0xff & (value >>  8));
	    buffer[pos++] = (byte) (0xff & value);
	}
	
	public void writeBoolean(int pos, boolean value)
	{
	    writeByte(pos, value ? 1 : 0);
	}
	
	public void save(DBFile dbFile) throws DBFileException
	{
		dbFile.write(buffer, 0, buffer.length);
	}
	
	public void load(DBFile dbFile) throws DBFileException 
	{
		dbFile.read(buffer, 0, buffer.length);
	}
}



