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

/**
 * An extension of the BufferedReader
 * 
 * @author leo
 * 
 */
public class LineReader extends BufferedReader {

    private int lineCount = 0;

    public LineReader(File file) throws FileNotFoundException {
        super(wrap(new FileReader(file)));
    }

    public LineReader(Reader in) {
        super(wrap(in));
    }

    public LineReader(Reader in, int bufferSize) {
        super(wrap(in), bufferSize);
    }

    private static BufferedReader wrap(Reader in) {
        if (BufferedReader.class.isAssignableFrom(in.getClass())) {
            return BufferedReader.class.cast(in);
        }
        else {
            return new BufferedReader(in);
        }
    }

    /**
     * Current line number. The first line is 1
     * 
     * @return
     */
    public int getLineCount() {
        return lineCount;
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line != null)
            lineCount++;
        return super.readLine();
    }

}
