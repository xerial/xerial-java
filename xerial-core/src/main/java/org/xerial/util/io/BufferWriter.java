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
// BufferWriter.java
// Since: Aug 30, 2007 6:37:35 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

/**
 * BufferWriter is a helper class to support sequential write to the buffer
 * 
 * @author leo
 * 
 */
public class BufferWriter {
    private final Buffer buffer;
    private int offset;

    /**
     * Creates the {@link BufferWriter}
     * 
     * @param buffer
     *            the buffer to write the data
     */
    public BufferWriter(final Buffer buffer) {
        this(buffer, 0);
    }

    /**
     * Creates the {@link BufferWriter}
     * 
     * @param buffer
     *            the buffer to write the data
     * @param offset
     *            the byte offset from which the data writing starts
     */
    public BufferWriter(final Buffer buffer, final int offset) {
        this.buffer = buffer;
        this.offset = offset;
    }

    public int getCursorPosition() {
        return offset;
    }

    public void writeInt(int value) {
        buffer.writeInt(offset, value);
        offset += Buffer.INT_SIZE; // integer byte size
    }

    public void writeByte(byte value) {
        buffer.writeByte(offset, value);
        offset += Buffer.BYTE_SIZE;
    }

    public void writeLong(long value) {
        buffer.writeLong(offset, value);
        offset += Buffer.LONG_SIZE; // long byte size;
    }

    public void writeBoolean(boolean value) {
        buffer.writeBoolean(offset, value);
        offset += Buffer.BOOLEAN_SIZE;
    }

}
