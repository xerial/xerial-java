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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.UTF8String;

/**
 * A character scanner which support character look-ahead and mark
 * functionalities.
 * 
 * @author leo
 * 
 */
public class BufferedScanner {
    private static interface Buffer {
        int length();

        int get(int index);

        int feed(int offset, int length) throws IOException;

        String toString(int offset, int length);

        UTF8String toUTF8String(int offset, int length);

        void close() throws IOException;

        /**
         * Slide the buffer contents [offset, offset+len) to [0,.. len)
         * 
         * @param offset
         * @param len
         */
        void slide(int offset, int len);

    }

    private static class ByteBuffer implements Buffer {
        InputStream source;
        byte[] buffer;

        public ByteBuffer(InputStream source, int bufferSize) {
            this.source = source;
            this.buffer = new byte[bufferSize];
        }

        public ByteBuffer(byte[] buffer) {
            this.buffer = buffer;
        }

        @Override
        public int get(int index) {
            return buffer[index];
        }

        @Override
        public int length() {
            return buffer.length;
        }

        @Override
        public String toString(int offset, int length) {
            return new String(buffer, offset, length);
        }

        @Override
        public int feed(int offset, int length) throws IOException {
            if (source == null)
                return -1;
            return source.read(buffer, offset, length);
        }

        @Override
        public void close() throws IOException {
            if (source != null)
                source.close();

        }

        @Override
        public void slide(int offset, int len) {
            System.arraycopy(buffer, offset, buffer, 0, len);
        }

        @Override
        public UTF8String toUTF8String(int offset, int length) {
            return new UTF8String(buffer, offset, length);
        }

    }

    private static class CharBuffer implements Buffer {
        Reader source;
        char[] buffer;

        public CharBuffer(Reader source, int bufferSize) {
            this.source = source;
            this.buffer = new char[bufferSize];
        }

        @Override
        public int get(int index) {
            return buffer[index];
        }

        @Override
        public int length() {
            return buffer.length;
        }

        @Override
        public String toString(int offset, int length) {
            return new String(buffer, offset, length);
        }

        @Override
        public int feed(int offset, int length) throws IOException {
            if (source == null)
                return -1;
            return source.read(buffer, offset, length);
        }

        @Override
        public void close() throws IOException {
            if (source != null)
                source.close();

        }

        @Override
        public void slide(int offset, int len) {
            System.arraycopy(buffer, offset, buffer, 0, len);
        }

        @Override
        public UTF8String toUTF8String(int offset, int length) {
            return new UTF8String(buffer, offset, length);
        }

    }

    public final static int EOF = -1;

    private Buffer buffer;
    private int bufferLimit = 0;
    private boolean reachedEOF = false;

    private static class ScannerState {
        public int cursor = 0;
        public int posInLine = 0;
        public long lineCount = 0;

        public ScannerState() {}

        public ScannerState(ScannerState m) {
            this.cursor = m.cursor;
            this.posInLine = m.posInLine;
            this.lineCount = m.lineCount;
        }

        @Override
        public String toString() {
            return String.format("%d", cursor);
        }
    }

    private ArrayDeque<ScannerState> markQueue = new ArrayDeque<ScannerState>();
    private ScannerState current;

    public BufferedScanner(InputStream in) {
        this(in, 8 * 1024); // 8kb buffer
    }

    public BufferedScanner(InputStream in, int bufferSize) {
        this(new ByteBuffer(in, bufferSize));
        if (in == null)
            throw new NullPointerException("input is null");
    }

    public BufferedScanner(Reader in) {
        this(in, 8 * 1024); // 8kb buffer
    }

    public BufferedScanner(Reader in, int bufferSize) {
        this(new CharBuffer(in, bufferSize));
        if (in == null)
            throw new NullPointerException("input is null");
    }

    public BufferedScanner(Buffer buffer) {
        this.buffer = buffer;
        this.current = new ScannerState();
    }

    public BufferedScanner(String s) {
        this(new ByteBuffer(s.getBytes()));
        this.bufferLimit = buffer.length();
    }

    public void close() throws XerialException {
        try {
            buffer.close();
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
    }

    public boolean hasReachedEOF() {
        return reachedEOF && current.cursor >= bufferLimit;
    }

    public UTF8String nextLine() throws XerialException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int ch;
        outer_loop: for (;;) {
            ch = LA(1);
            switch (ch) {
            case '\r':
                consume();
                if (LA(1) == '\n') {
                    consume();
                }
                break outer_loop;
            case '\n':
            case EOF:
                consume();
                break outer_loop;
            default:
                buf.write(ch);
                consume();
                break;
            }
        }
        return buf.size() > 0 ? new UTF8String(buf.toByteArray()) : null;
    }

    public void consume() throws XerialException {
        if (current.cursor >= bufferLimit) {
            if (!fill()) {
                // Do nothing
                return;
            }
        }

        int ch = buffer.get(current.cursor++);
        current.posInLine++;
        switch (ch) {
        case '\r':
            if (LA(1) != '\n') {
                current.lineCount++;
                current.posInLine = 0;
            }
            break;
        case '\n':
            current.lineCount++;
            current.posInLine = 0;
            break;
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

        // current.cursor might be changed at fill(), so we need to recompute the lookahead position  
        return buffer.get(current.cursor + lookahead - 1);
    }

    private boolean fill() throws XerialException {
        if (reachedEOF) {
            return false;
        }

        // Move the [mark ... limit)
        if (!markQueue.isEmpty()) {
            ScannerState mark = markQueue.peekFirst();
            int lenToPreserve = bufferLimit - mark.cursor;
            if (lenToPreserve < buffer.length()) {
                // Move [mark.cursor, limit) to the [0, ..., mark.cursor)
                if (lenToPreserve > 0)
                    buffer.slide(mark.cursor, lenToPreserve);
                bufferLimit = lenToPreserve;
                current.cursor -= mark.cursor;
                mark.cursor = 0;
            }
            else {
                // The buffer got too big, invalidate the mark
                markQueue.clear();
                bufferLimit = 0;
                current.cursor = 0;
            }
        }
        else {
            bufferLimit = 0;
            current.cursor = 0;
        }

        // Read the data from the stream, and fill the buffer
        int readLen = buffer.length() - bufferLimit;
        try {
            int readBytes = buffer.feed(current.cursor, readLen);
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

    public Range getSelectedRange() {
        if (markQueue.isEmpty())
            throw new NullPointerException("no mark is set");

        return new Range(markQueue.getLast().cursor, current.cursor);
    }

    public String selectedString() {
        Range r = getSelectedRange();
        return buffer.toString(r.begin, r.size());
    }

    public UTF8String selectedUTF8String() {
        Range r = getSelectedRange();
        return buffer.toUTF8String(r.begin, r.size());
    }

    public UTF8String selectedUTF8StringWithTrimming() {
        Range r = trim(getSelectedRange());
        return buffer.toUTF8String(r.begin, r.size());
    }

    private static class Range {
        public final int begin;
        public final int end;

        public Range(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public int size() {
            return end - begin;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d)", begin, end);
        }
    }

    Range trim(Range input) {
        int begin = input.begin;
        int end = input.end;

        for (; begin < end; begin++) {
            int c = buffer.get(begin);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
                break;
        }
        for (; begin < end; end--) {
            int c = buffer.get(end - 1);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
                break;
        }
        if (begin >= end) {
            begin = end;
        }

        int size = end - begin;
        return new Range(begin, end);
    }

    Range trim() {
        return trim(getSelectedRange());
    }

    public String selectedStringWithTrimming() {
        Range r = trim();
        if (r == null)
            return null;
        return buffer.toString(r.begin, r.size());
    }

    public String selectedString(int margin) {
        if (markQueue.isEmpty())
            return null;

        Range selected = getSelectedRange();
        Range trimmed = new Range(selected.begin + margin, selected.end - margin);
        return buffer.toString(trimmed.begin, trimmed.size());
    }

    public UTF8String selectedUTF8String(int margin) {
        if (markQueue.isEmpty())
            return null;

        Range selected = getSelectedRange();
        Range trimmed = new Range(selected.begin + margin, selected.end - margin);
        return buffer.toUTF8String(trimmed.begin, trimmed.size());
    }

    public UTF8String selectedUTF8StringFromFirstMark() {
        Range selected = new Range(markQueue.peekFirst().cursor, current.cursor);
        return buffer.toUTF8String(selected.begin, selected.size());
    }

    public int distanceFromFirstMark() {
        return current.cursor - markQueue.peekFirst().cursor;
    }

    public void mark() {
        markQueue.add(new ScannerState(current));
    }

    public void resetMarks() {
        markQueue.clear();
    }

    /**
     * Reset the stream position to the last marker.
     */
    public void rewind() {
        current = markQueue.pollLast();
    }

    public long getLineCount() {
        return current.lineCount;
    }

    public int getPosInLine() {
        return current.posInLine;
    }

}
