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
// FileResourceTest.java
// Since: Jul 5, 2007 11:05:34 AM
//
// $URL:http://www.xerial.org/svn/project/XerialJ/trunk/XerialJ/src/test/java/org/xerial/util/FileResourceTest.java $
// $Author:leo $
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.io.VirtualFile;
import org.xerial.util.log.Logger;

public class FileResourceTest {
    private Logger _logger = Logger.getLogger(FileResourceTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void find() throws IOException {
        URL loc = FileResource.find(FileResourceTest.class, "test-resource.txt");
        _logger.trace("resource URL: " + loc);
        assertNotNull(loc);
        BufferedReader in = new BufferedReader(new InputStreamReader(loc.openStream()));
        String line = in.readLine();
        assertNotNull(line);
        assertEquals("hello world", line);
    }

    @Test
    public void findFromRootPackage() throws URISyntaxException {
        URL url = FileResource.find("org/xerial/util/empty.file");
        assertNotNull(url);
        File file = new File(url.toURI());
        assertEquals("empty.file", file.getName());
    }

    @Test
    public void listResources() {
        List<VirtualFile> resourceList = FileResource.listResources("org.xerial.util");

        for (VirtualFile vf : resourceList) {
            _logger.trace(vf.getLogicalPath() + " : " + vf.getURL());
        }

    }

    @Test
    public void filter() {
        List<VirtualFile> resourceList = FileResource.listResources("org.xerial.util",
                new ResourceFilter() {
                    public boolean accept(String resourcePath) {
                        return resourcePath.endsWith(".java");
                    }
                });

        for (VirtualFile vf : resourceList) {
            assertTrue(vf.getLogicalPath().endsWith(".java"));
        }
    }

    @Test
    public void listResoucesInJAR() {
        List<VirtualFile> resourceList = FileResource.listResources("org.junit.runner");
        assertTrue("at least one resource must be found in org.junit.runner",
                resourceList.size() > 0);

        for (VirtualFile vf : resourceList) {
            _logger.trace(vf.getLogicalPath() + " : " + vf.getURL());
        }
    }

    @Test
    public void loadIntoString() throws IOException {
        String text = FileResource.loadIntoString(FileResourceTest.class, "test-resource.txt");
        assertEquals("hello world", text);
    }

}
