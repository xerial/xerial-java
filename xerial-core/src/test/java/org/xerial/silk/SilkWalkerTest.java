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
// SilkWalkerTest.java
// Since: Feb 2, 2009 11:55:33 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

public class SilkWalkerTest
{
    private static Logger _logger = Logger.getLogger(SilkWalkerTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testWalk() throws IOException, XerialException
    {
        SilkWalker walker = new SilkWalker(FileResource.open(SilkWalkerTest.class, "small.silk"));
        walker.walk(new TreeVisitor() {

            public void finish(TreeWalker walker) throws XerialException
            {
            // TODO Auto-generated method stub

            }

            public void init(TreeWalker walker) throws XerialException
            {
            // TODO Auto-generated method stub

            }

            public void leaveNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
            {
                _logger.info(String.format("leave: %s, %s", nodeName, immediateNodeValue));
            }

            public void text(String textDataFragment) throws XerialException
            {
                _logger.info(String.format("text:  %s", textDataFragment));
            }

            public void visitNode(String nodeName, TreeWalker walker) throws XerialException
            {
                _logger.info(String.format("visit: %s", nodeName));
            }
        });
    }
}
