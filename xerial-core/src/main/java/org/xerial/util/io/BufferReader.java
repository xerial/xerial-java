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
// BufferReader.java
// Since: Aug 30, 2007 6:44:54 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

/**
 * BufferReader is a helper class to support sequential read from a buffer
 * 
 * @author leo
 * 
 */
public class BufferReader {
    private final Buffer buffer;
    private int offset;

    public BufferReader(final Buffer buffer) {
        this(buffer, 0);
    }

    public BufferReader(final Buffer buffer, final int offset) {
        this.buffer = buffer;
        this.offset = offset;
    }

    public int readInt() {
        int value = buffer.readInt(offset);
        offset += Buffer.INT_SIZE;
        return value;
    }

    public long readLong() {
        long value = buffer.readLong(offset);
        offset += Buffer.LONG_SIZE;
        return value;
    }

    public byte readByte() {
        byte value = buffer.readByte(offset);
        offset += Buffer.BYTE_SIZE;
        return value;
    }

    public boolean readBoolean() {
        boolean value = buffer.readBoolean(offset);
        offset += Buffer.BOOLEAN_SIZE;
        return value;
    }

}
