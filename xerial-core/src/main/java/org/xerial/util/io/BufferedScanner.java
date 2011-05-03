/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// BufferedScanner.java
// Since: 2011/04/30 15:36:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.IOException;
import java.io.InputStream;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * A character scanner which support character look-ahead and mark
 * functionalities.
 * 
 * @author leo
 * 
 */
public class BufferedScanner {
    public final static int EOF = -1;

    private final InputStream in;
    private byte[] buffer;
    private int bufferLimit = 0;
    private boolean reachedEOF = false;

    private static class ScannerState {
        public int cursor = 0;
        public int lineNumber = 1;
        public int posInLine = 0;

        public ScannerState() {}

        public ScannerState(ScannerState m) {
            this.cursor = m.cursor;
            this.lineNumber = m.lineNumber;
            this.posInLine = m.posInLine;
        }

    }

    private ScannerState mark;
    private ScannerState current = new ScannerState();

    public BufferedScanner(InputStream in) {
        this(in, 8 * 1024); // 8kb buffer
    }

    public BufferedScanner(InputStream in, int bufferSize) {
        if (in == null)
            throw new NullPointerException("input is null");
        this.in = in;
        buffer = new byte[bufferSize];
    }

    public BufferedScanner(String s) {
        this.in = null;
        buffer = s.getBytes();
        bufferLimit = buffer.length;
    }

    public void close() throws XerialException {
        try {
            in.close();
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
    }

    public boolean hasReachedEOF() {
        return current.cursor >= bufferLimit && reachedEOF;
    }

    public void consume() throws XerialException {
        if (current.cursor >= bufferLimit) {
            if (!fill()) {
                // Do nothing
                return;
            }
        }

        int ch = buffer[current.cursor++];
        current.posInLine++;
        if (ch == '\n') {
            current.lineNumber++;
            current.posInLine = 0;
        }
    }

    /**
     * Get the next character of lookahead.
     * 
     * @param i
     * @return
     * @throws IOException
     */
    public int LA(int lookahead) throws XerialException {
        if (current.cursor + lookahead - 1 >= bufferLimit) {
            if (!fill()) {
                // No more character
                return EOF;
            }
        }

        return buffer[current.cursor + lookahead - 1];
    }

    private boolean fill() throws XerialException {
        if (in == null || reachedEOF) {
            reachedEOF = true;
            return false;
        }

        // Move the [mark ... limit)
        if (mark != null) {
            int lenToPreserve = bufferLimit - mark.cursor;
            if (lenToPreserve < buffer.length) {
                // Move [mark.cursor, limit) to the [0, ..., mark.cursor)
                if (lenToPreserve > 0)
                    System.arraycopy(buffer, mark.cursor, buffer, 0, lenToPreserve);
                mark.cursor = 0;
                bufferLimit = lenToPreserve;
                current.cursor -= mark.cursor;
            }
            else {
                // The buffer got too big, invalidate the mark
                mark = null;
                bufferLimit = 0;
                current.cursor = 0;
            }
        }
        else {
            bufferLimit = 0;
            current.cursor = 0;
        }

        // Read the data from the stream, and fill the buffer
        int readLen = buffer.length - bufferLimit;
        try {
            int readBytes = in.read(buffer, current.cursor, readLen);
            if (readBytes < readLen) {
                reachedEOF = true;
            }
            if (readBytes == -1)
                return false;
            else {
                bufferLimit += readBytes;
                return true;
            }
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
    }

    public String selectedString() {
        if (mark == null)
            return null;

        int size = current.cursor - mark.cursor;
        return new String(buffer, mark.cursor, size);
    }

    public String selectedStringWithTrimming() {
        if (mark == null)
            return null;

        int begin = mark.cursor;
        int end = current.cursor;

        for (; begin < end; begin++) {
            int c = buffer[begin];
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
                break;
        }
        for (; begin < end; end--) {
            int c = buffer[end - 1];
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
                break;
        }
        if (begin >= end) {
            begin = end;
        }

        int size = end - begin;
        return new String(buffer, begin, size);
    }

    public String selectedString(int margin) {
        if (mark == null)
            return null;

        int begin = mark.cursor + margin;
        int end = current.cursor - margin;
        int size = end - begin;
        return new String(buffer, begin, size);
    }

    public void mark() {
        mark = new ScannerState(current);
    }

    /**
     * Reset the stream position to the last marker.
     */
    public void rewind() {
        current = mark;
        mark = null;
    }

    /**
     * Get the current line number. The first line number is 1.
     * 
     * @return
     */
    public int getLineNumber() {
        return current.lineNumber;
    }

    /**
     * Get the character position in the current line. The first character
     * position in line is 1.
     * 
     * @return
     */
    public int getPosInLine() {
        return current.posInLine;
    }
}
