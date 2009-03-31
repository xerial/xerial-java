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
// XMLStreamWalkerTest.java
// Since: Mar 30, 2009 7:02:29 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;

public class XMLStreamReaderTest
{
    private static Logger _logger = Logger.getLogger(XMLStreamReaderTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    public HashMap<String, String> parse(String xml) throws Exception
    {
        XMLStreamReader walker = new XMLStreamReader(FileResource.open(XMLStreamReaderTest.class, xml));
        TreeEvent e = null;
        HashMap<String, String> data = new HashMap<String, String>();
        while ((e = walker.next()) != null)
        {
            _logger.info(e);
            if (e.isVisit() || e.isText())
                data.put(e.nodeName, e.nodeValue);

        }
        return data;

    }

    @Test
    public void testParse() throws Exception
    {
        HashMap<String, String> data = parse("../bean/skip.xml");

        assertEquals("Will ship internationally, See description for charges", data.get("shipping"));
        assertEquals("page", data.get("text"));
        assertNull(data.get("item"));
    }

    @Test
    public void testSimple() throws Exception
    {
        HashMap<String, String> data = parse("simple.xml");

        assertEquals("Leo", data.get("author"));
        assertEquals("Hello World!  Nice to meet you", data.get("wiki"));

    }

}
