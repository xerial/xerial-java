/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// FileTypeTest.java
// Since: Feb 10, 2009 11:13:40 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileTypeTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetFileType() {
        assertEquals(FileType.PNG, FileType.getFileTypeFromFileExt("png"));
        assertEquals(FileType.JPEG, FileType.getFileTypeFromFileExt("jpg"));
        assertEquals(FileType.JPEG, FileType.getFileTypeFromFileExt("jpeg"));

        for (FileType eachType : FileType.values()) {
            for (String eachFileExt : eachType.getFileExtList())
                assertEquals(eachType, FileType.getFileTypeFromFileExt(eachFileExt));
        }

    }

    @Test
    public void testGetFileTypeFromPath() throws Exception {
        assertEquals(FileType.PNG, FileType.getFileType("/home/leo/tmp/somefile.png"));
        assertEquals(FileType.JPEG, FileType.getFileType("/home/leo/tmp/somefile.jpeg"));
        assertEquals(FileType.SILK, FileType.getFileType("/home/leo/tmp.1/somefile.silk"));
        assertEquals(FileType.TAR_GZ, FileType.getFileType("/home/leo/tmp.1/somefile.tar.gz"));

    }

    @Test
    public void removeExt() throws Exception {
        assertEquals("chromFa", FileType.removeFileExt("chromFa.tar.gz"));
        assertEquals("chr1", FileType.removeFileExt("chr1.fa"));
        assertEquals("chr1.fa", FileType.removeFileExt("chr1.fa.gz"));
    }

}
