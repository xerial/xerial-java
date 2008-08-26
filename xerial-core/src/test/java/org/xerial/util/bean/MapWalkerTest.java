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
// MapWalkerTest.java
// Since: Jan 5, 2008 5:35:03 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;

public class MapWalkerTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testWalk() throws XerialException
    {
        final Properties prop = new Properties();
        prop.put("A", "hello");
        prop.put("B", "world");

        MapWalker walker = new MapWalker(prop);
        walker.walk(new TreeVisitor() {

            boolean visitA = false;
            boolean visitB = false;
            String valueA = "";
            String valueB = "";
            boolean initialized = false;

            public void finish(TreeWalker walker) throws XerialException
            {
                assertTrue(initialized);
                assertTrue(visitA);
                assertTrue(visitB);
                assertEquals("hello", valueA);
                assertEquals("world", valueB);

                prop.put("C", "finished");
            }

            public void init(TreeWalker walker) throws XerialException
            {
                initialized = true;
            }

            public void leaveNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
            {
                if (nodeName.equals("A"))
                {
                    valueA = nodeValue;
                }
                else if (nodeName.equals("B"))
                {
                    valueB = nodeValue;
                }
            }

            public void visitNode(String nodeName, TreeWalker walker) throws XerialException
            {
                if (nodeName.equals("A"))
                {
                    visitA = true;
                }
                else if (nodeName.equals("B"))
                {
                    visitB = true;
                }

            }
        });

        assertTrue(prop.containsKey("C"));
        assertEquals("finished", prop.getProperty("C"));
    }

}
