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
// MemoryFile.java
// Since: Aug 23, 2007 12:06:42 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * {@link MemoryFile} is a class to handle main memory as if it is a file
 * 
 * @author leo
 * 
 */
public class MemoryFile implements DBFile {

    private final int chunkSize = 1024;
    private final ArrayList<MemoryChunk> chunkList = new ArrayList<MemoryChunk>();
    private long fileCursor = 0;

    class MemoryChunk {
        byte[] buffer = new byte[chunkSize]; // buffer is automatically initialized with the default value

        public MemoryChunk() {

        }

        /**
         * Reads the chunk data, then writes to the given output buffer from the
         * specified offset
         * 
         * @param outputBuffer
         * @param offsetInOutputBuffer
         * @param offsetInChunk
         * @param readBytes
         * @return the number of bytes read from this chunk. When the retuned
         *         value equals to the readBytes, the data is fully read from
         *         the chunk. If the returned value is less than the readBytes,
         *         it indicates the succeeding chunks should be read to fully
         *         retrieve the data
         */
        public int read(byte[] outputBuffer, int offsetInOutputBuffer, int offsetInChunk,
                int readBytes) {
            int availableBytesInThisChunk = chunkSize - offsetInChunk;
            int readBytesFromThisChunk = (availableBytesInThisChunk > readBytes) ? readBytes
                    : availableBytesInThisChunk;
            for (int i = 0; i < readBytesFromThisChunk; i++) {
                outputBuffer[offsetInOutputBuffer + i] = buffer[offsetInChunk + i];
            }
            return readBytesFromThisChunk;
        }

        public int write(byte[] inputBuffer, int offsetInInputBuffer, int offsetInChunk,
                int writeBytes) {
            int availableBytesInThisChunk = chunkSize - offsetInChunk;
            int writeBytesToThisChunk = (availableBytesInThisChunk > writeBytes) ? writeBytes
                    : availableBytesInThisChunk;
            for (int i = 0; i < writeBytesToThisChunk; i++) {
                buffer[offsetInChunk + i] = inputBuffer[offsetInInputBuffer + i];
            }
            return writeBytesToThisChunk;
        }
    }

    public MemoryFile() {}

    public void loadFromFile(String fileName) throws IOException, XerialException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int data;
        byte[] buf = new byte[1];
        while ((data = reader.read()) != -1) {
            buf[0] = (byte) data;
            write(buf, 0, 1);
        }
    }

    private int chunkIndex(long cursor) {
        return (int) (cursor / chunkSize);
    }

    private int chunkOffset(long cursor) {
        return (int) (cursor % chunkSize);
    }

    private MemoryChunk getChunk(int chunkIndex) {
        extendChunkListUpTo(chunkIndex);
        return chunkList.get(chunkIndex);
    }

    private void extendChunkListUpTo(int chunkIndex) {
        while (chunkIndex >= chunkList.size()) {
            chunkList.add(new MemoryChunk());
        }
    }

    public void read(byte[] buffer, int offset, int byteSize) throws XerialException {
        if ((buffer.length - offset) < byteSize)
            throw new XerialException(XerialErrorCode.INVALID_INPUT,
                    "insufficient read buffer size:" + buffer.length + "(offset: " + offset
                            + "), byteSize = " + byteSize);

        int remainingBytesToRead = byteSize;
        while (remainingBytesToRead > 0) {
            int currentChunkIndex = chunkIndex(fileCursor);
            int offsetInChunk = chunkOffset(fileCursor);
            MemoryChunk chunk = getChunk(currentChunkIndex);
            int readBytes = chunk.read(buffer, offset, offsetInChunk, remainingBytesToRead);

            fileCursor += readBytes;
            offset += readBytes;
            remainingBytesToRead -= readBytes;
        }
    }

    public void seek(long fileBytePos) throws XerialException {
        if (fileBytePos < 0)
            throw new XerialException(XerialErrorCode.INVALID_INPUT,
                    "the cursor cannot be less than 0: " + fileBytePos);

        fileCursor = fileBytePos;
    }

    public void write(byte[] buffer, int offset, int byteSize) throws XerialException {
        if ((buffer.length - offset) < byteSize)
            throw new XerialException(XerialErrorCode.INVALID_INPUT,
                    "insufficient data buffer size:" + buffer.length + "(offset: " + offset
                            + "), byteSize = " + byteSize);

        int remainingBytesToWrite = byteSize;
        while (remainingBytesToWrite > 0) {
            int currentChunkIndex = chunkIndex(fileCursor);
            int offsetInChunk = chunkOffset(fileCursor);
            MemoryChunk chunk = getChunk(currentChunkIndex);
            int wroteBytes = chunk.write(buffer, offset, offsetInChunk, remainingBytesToWrite);

            fileCursor += wroteBytes;
            offset += wroteBytes;
            remainingBytesToWrite -= wroteBytes;
        }
    }

    public void close() throws XerialException {
    // do nothing
    }

}
