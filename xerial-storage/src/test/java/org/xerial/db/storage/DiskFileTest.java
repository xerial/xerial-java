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
// DiskFileTest.java
// Since: Aug 23, 2007 2:21:52 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.db.DBException;

public class DiskFileTest
{

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void write() throws DBException, FileNotFoundException {
        DiskFile file = new DiskFile("target/diskfile.db");
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
        catch (DBException e) {
            fail(e.getMessage());
        }
        finally {
            file.close();
        }
    }

    @Test
    public void writeAtSpecificLocation() throws DBException, FileNotFoundException {
        DiskFile file = new DiskFile("diskfile.db");
        try {
            String m = "hello world!";
            byte[] buf = m.getBytes();
            final int offset = 2048;
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
        catch (DBException e) {
            fail(e.getMessage());
        }
        finally {
            file.close();
        }

    }

}
