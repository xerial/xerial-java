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
// DOMWalkerTest.java
// Since: 2009/03/31 9:36:17
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeEvent.EventType;
import org.xerial.util.xml.pullparser.DOMBuilder;

public class DOMWalkerTest
{
    private static Logger _logger = Logger.getLogger(DOMWalkerTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testWalk() throws Exception
    {
        DOMBuilder builder = new DOMBuilder();
        DOMWalker walker = new DOMWalker(builder.parse(FileResource.open(DOMWalkerTest.class, "domtest.xml")));

        HashMap<String, String> nodeData = new HashMap<String, String>();

        TreeEvent e;
        while ((e = walker.next()) != null)
        {
            if (e.event == EventType.VISIT)
                nodeData.put(e.nodeName, e.nodeValue);
        }

        assertNull(nodeData.get("domtest"));
        assertNull(nodeData.get("birth"));
        assertEquals("Yui-chan", nodeData.get("name"));
        assertEquals("25", nodeData.get("day"));
        assertEquals("12", nodeData.get("month"));
        assertEquals("2002", nodeData.get("year"));
        assertEquals("xxxbbbaaa", nodeData.get("photo"));
        assertEquals("Tokyo", nodeData.get("address"));

    }

}
