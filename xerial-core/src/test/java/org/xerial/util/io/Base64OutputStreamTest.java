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
// Base64OutputStreamTest.java
// Since: 2009/02/12 17:03:20
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class Base64OutputStreamTest
{
    private static Logger _logger = Logger.getLogger(Base64OutputStreamTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testname() throws Exception
    {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        Base64OutputStream out = new Base64OutputStream(buf);

        URL iconImage = FileResource.find(Base64OutputStreamTest.class, "icon.png");
        InputStream in = iconImage.openStream();
        int readBytes = 0;
        byte[] buffer = new byte[8192];
        while ((readBytes = in.read(buffer, 0, buffer.length)) != -1)
        {
            out.write(buffer, 0, readBytes);
        }

        _logger.debug(buf.toString());

    }

}
