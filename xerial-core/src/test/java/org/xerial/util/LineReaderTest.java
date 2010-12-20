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
// LineReaderTest.java
// Since: 2010/12/20 16:50:51
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.xerial.util.log.Logger;

public class LineReaderTest {

    private static Logger _logger = Logger.getLogger(LineReaderTest.class);

    @Test
    public void iterator() throws Exception {

        int lineCount = 0;
        for (String line : new LineReader(FileResource.open(LineReaderTest.class,
                "linereader-test.txt"))) {
            lineCount++;
            switch (lineCount) {
            case 1:
                assertEquals("hello", line);
                break;
            case 2:
                assertEquals("world!", line);
                break;
            case 3:
                assertEquals("", line);
                break;
            case 4:
                assertEquals("this is line 4", line);
                break;
            case 5:
                assertEquals("== end of line ==", line);
                break;
            }

        }
        assertEquals(5, lineCount);

    }

    @Test
    public void lineCount() throws Exception {
        int lineCount = 0;
        LineReader r = new LineReader(
                FileResource.open(LineReaderTest.class, "linereader-test.txt"));
        for (String line; (line = r.readLine()) != null;) {
            lineCount++;
            assertEquals(lineCount, r.getLineCount());
        }
        assertEquals(5, lineCount);
    }

    private static void readTest(LineReader l) throws IOException {
        int lineCount = 0;
        for (String line : new LineReader(FileResource.open(LineReaderTest.class,
                "linereader-test.txt"))) {
            lineCount++;
        }
        assertEquals(5, lineCount);
    }

    @Test
    public void constructor() throws Exception {
        // set the buffer size to 1024
        readTest(new LineReader(FileResource.open(LineReaderTest.class, "linereader-test.txt"),
                1024));

        // use a tiny buffer
        readTest(new LineReader(FileResource.open(LineReaderTest.class, "linereader-test.txt"), 10));

        // use a file interface
        File tmp = FileUtil.createTempFile(new File("target"), "linereader-test", ".txt");
        tmp.deleteOnExit();
        FileUtil.copy(FileResource.openByteStream(LineReaderTest.class, "linereader-test.txt"), tmp);
        readTest(new LineReader(tmp));
        readTest(new LineReader(tmp, 10));
        readTest(new LineReader(tmp, 1024));

    }

}
