/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// LineReader.java
// Since: 2010/12/07 17:34:43
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/**
 * An extension of the BufferedReader for reading lines. The input file (or
 * buffer) will be closed automatically upon finished reading.
 * 
 * 
 * @author leo
 * 
 */
public class LineReader implements Iterable<String> {

    private int lineCount = 0;

    private BufferedReader reader;
    private boolean hasFinishedReading = false;

    public LineReader(File file) throws FileNotFoundException {
        this.reader = wrap(new FileReader(file));
    }

    public LineReader(File file, int bufferSize) throws FileNotFoundException {
        this.reader = wrap(new FileReader(file), bufferSize);
    }

    public LineReader(Reader in) {
        this.reader = wrap(in);
    }

    public LineReader(Reader in, int bufferSize) {
        this.reader = wrap(in, bufferSize);
    }

    private static BufferedReader wrap(Reader in) {
        if (BufferedReader.class.isAssignableFrom(in.getClass())) {
            return BufferedReader.class.cast(in);
        }
        else {
            return new BufferedReader(in);
        }
    }

    private static BufferedReader wrap(Reader in, int bufferSize) {
        return new BufferedReader(in, bufferSize);
    }

    /**
     * Current line number. The first line is 1
     * 
     * @return
     */
    public int getLineCount() {
        return lineCount;
    }

    public String readLine() throws IOException {
        String line = reader.readLine();
        if (line != null)
            lineCount++;
        else
            close();
        return line;
    }

    public void close() throws IOException {
        if (!hasFinishedReading) {
            hasFinishedReading = true;
            reader.close();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            ArrayDeque<String> queue = new ArrayDeque<String>();

            @Override
            public boolean hasNext() {
                if (!queue.isEmpty())
                    return true;

                try {
                    String line = readLine();
                    if (line != null) {
                        queue.addLast(line);
                        return true;
                    }
                }
                catch (IOException e) {
                    // An error occurred while reading
                }
                return false;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    return null;
                }
                return queue.pollFirst();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

}
