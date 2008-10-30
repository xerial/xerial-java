/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// ResourcePathTest.java
// Since: Oct 30, 2008 9:38:38 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;

public class ResourcePathTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testGetURL() throws XerialException, IOException
    {
        ResourcePath rp = new ResourcePath(ResourcePathTest.class, "test-resource.txt");
        URL u = rp.getURL();
        assertNotNull(u);

        assertEquals("org/xerial/util/test-resource.txt", rp.getPath());

        BufferedReader reader = rp.openCharacterStream();
        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {

        }

    }

    @Test
    public void jarResource()
    {
        ResourcePath rp = new ResourcePath(Package.getPackage("org.junit"), "Test.class");
        URL u = rp.getURL();
        assertNotNull(u);

        assertEquals("org/junit/Test.class", rp.getPath());

    }

    @Test
    public void fullPath()
    {
        ResourcePath rp = new ResourcePath("org/xerial/util/test-resource.txt");
        URL u = rp.getURL();
        assertNotNull(u);

        assertEquals("org/xerial/util/test-resource.txt", rp.getPath());

    }

}
