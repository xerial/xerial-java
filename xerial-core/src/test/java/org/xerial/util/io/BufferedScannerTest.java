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
// BufferedScannerTest.java
// Since: 2011/04/30 16:35:11
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.StringReader;

import org.junit.Test;

public class BufferedScannerTest {
    @Test
    public void scanner() throws Exception {

        String m = "Hello World.";
        BufferedScanner s = new BufferedScanner(m);
        for (int i = 0; i < m.length(); ++i) {
            assertEquals(m.charAt(i), s.LA(1));
            if (i < m.length() - 1)
                assertEquals(m.charAt(i + 1), s.LA(2));
            s.consume();
        }
        assertEquals(-1, s.LA(1));
    }

    @Test
    public void markAndRewind() throws Exception {

        String m = "Hello World.";
        BufferedScanner s = new BufferedScanner(m);
        s.mark();
        for (int i = 0; i < 4; ++i)
            s.consume();

        assertEquals('o', s.LA(1));
        assertEquals("Hell", s.selectedString());
        assertEquals("Hell", s.selectedUTF8String().toString());
        s.rewind();

        for (int i = 0; i < m.length(); ++i) {
            assertEquals(m.charAt(i), s.LA(1));
            s.consume();
        }
        assertEquals(-1, s.LA(1));
    }

    @Test
    public void buffer() throws Exception {
        String m = "Hello World\nThanks for using silk-weaver!!!\nTaro L. Saito";
        byte[] b = m.getBytes("UTF-8");
        BufferedScanner s = new BufferedScanner(new ByteArrayInputStream(b), 10);

        for (int i = 0; i < m.length(); ++i) {
            assertEquals(m.charAt(i), s.LA(1));

            s.consume();
        }
        assertEquals(-1, s.LA(1));

    }

    @Test
    public void charBuffer() throws Exception {
        String m = "Hello World\nThanks for using silk-weaver!!!\nTaro L. Saito";
        BufferedScanner s = new BufferedScanner(new StringReader(m), 10);

        for (int i = 0; i < m.length(); ++i) {
            assertEquals(m.charAt(i), s.LA(1));
            s.consume();
        }
        assertEquals(-1, s.LA(1));

    }

}
