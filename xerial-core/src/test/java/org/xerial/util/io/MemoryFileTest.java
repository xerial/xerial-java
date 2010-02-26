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
// MemoryFileTest.java
// Since: Aug 23, 2007 2:46:56 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MemoryFileTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void write() throws Exception {
        MemoryFile file = new MemoryFile();
        try {
            String m = "hello world!";
            byte[] buf = m.getBytes();
            file.write(buf, 0, buf.length);

            file.seek(0);
            byte[] readBuf = new byte[1024];
            file.read(readBuf, 0, m.length());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < m.length(); i++) {
                char c = (char) readBuf[i];
                sb.append(c);
            }
            String m2 = sb.toString();
            assertEquals(m, m2);
        }
        finally {

        }
    }

    @Test
    public void writeAtSpecificLocation() throws Exception {
        MemoryFile file = new MemoryFile();
        try {
            String m = "hello world!";
            byte[] buf = m.getBytes();
            final int offset = 1020; // crosses the chunk boundary 
            file.seek(offset);
            file.write(buf, 0, buf.length);

            file.seek(offset);
            byte[] readBuf = new byte[1024];
            file.read(readBuf, 0, m.length());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < m.length(); i++) {
                char c = (char) readBuf[i];
                sb.append(c);
            }
            String m2 = sb.toString();
            assertEquals(m, m2);
        }
        finally {

        }

    }

}
