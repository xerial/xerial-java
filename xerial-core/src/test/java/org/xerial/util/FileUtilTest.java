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
// FileUtilTest.java
// Since: May 3, 2010 12:31:10 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileUtilTest {

    private final File tmpDir = new File("target");

    @Before
    public void setUp() throws Exception {
        tmpDir.mkdirs();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testRmdir() throws IOException {
        File testDir = FileUtil.createTempDir(tmpDir, "sample");
        assertTrue(testDir.exists());
        FileUtil.rmdir(testDir);

        assertTrue(!testDir.exists());
    }

    @Test
    public void testCopyInputStreamFile() throws IOException {
        File tmpFile = FileUtil.createTempFile(tmpDir, "sample", ".tmp");
        tmpFile.deleteOnExit();

        FileUtil.copy(FileResource.openByteStream(FileUtilTest.class, "scaffold/hello.txt"),
                tmpFile);
        assertTrue(tmpFile.exists());

        assertEquals(FileUtil.sha1(FileResource.openByteStream(FileUtilTest.class,
                "scaffold/hello.txt")), FileUtil.sha1(tmpFile));
    }

    @Test
    public void testCopyInputStreamFileCopyConfig() throws IOException {
        File tmpFile = FileUtil.createTempFile(tmpDir, "sample", ".tmp");
        tmpFile.deleteOnExit();

        FileUtil.CopyConfig c = new FileUtil.CopyConfig();
        c.BLOCK_SIZE = 8;
        FileUtil.copy(FileResource.openByteStream(FileUtilTest.class, "scaffold/hello.txt"),
                tmpFile, c);
        assertTrue(tmpFile.exists());

        assertEquals(FileUtil.sha1(FileResource.openByteStream(FileUtilTest.class,
                "scaffold/hello.txt")), FileUtil.sha1(tmpFile));
    }

    @Test
    public void testCopyFileFile() throws IOException {
        File tmpFile = FileUtil.createTempFile(tmpDir, "sample", ".tmp");
        tmpFile.deleteOnExit();

        FileUtil.copy(FileResource.openByteStream(FileUtilTest.class, "scaffold/hello.txt"),
                tmpFile);
        assertTrue(tmpFile.exists());

        File tmpFile2 = FileUtil.createTempFile(tmpDir, "sample2", ".tmp");
        tmpFile2.deleteOnExit();

        FileUtil.copy(tmpFile, tmpFile2);

        assertEquals(FileUtil.sha1(tmpFile), FileUtil.sha1(tmpFile2));
    }

    @Test
    public void testCopyFileFileCopyConfig() throws IOException {
        File tmpFile = FileUtil.createTempFile(tmpDir, "sample", ".tmp");
        tmpFile.deleteOnExit();

        FileUtil.copy(FileResource.openByteStream(FileUtilTest.class, "scaffold/hello.txt"),
                tmpFile);
        assertTrue(tmpFile.exists());

        File tmpFile2 = FileUtil.createTempFile(tmpDir, "sample2", ".tmp");
        tmpFile2.deleteOnExit();

        FileUtil.CopyConfig c = new FileUtil.CopyConfig();
        c.BLOCK_SIZE = 1024;
        FileUtil.copy(tmpFile, tmpFile2, c);

        assertEquals(FileUtil.sha1(tmpFile), FileUtil.sha1(tmpFile2));

    }

}
