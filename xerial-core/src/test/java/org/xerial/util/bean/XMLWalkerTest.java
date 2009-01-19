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
// XMLWalkerTest.java
// Since: Nov 7, 2008 3:52:13 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

public class XMLWalkerTest
{
    private static Logger _logger = Logger.getLogger(XMLWalkerTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testGetSubTree() throws IOException, XerialException
    {
        XMLWalker walker = new XMLWalker(FileResource.open(XMLWalkerTest.class, "skip.xml"));
        walker.walk(new TreeVisitor() {

            LinkedList<String> nodeStack = new LinkedList<String>();

            public void finish(TreeWalker walker) throws XerialException
            {

            }

            public void init(TreeWalker walker) throws XerialException
            {

            }

            public void leaveNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
            {
                _logger.debug("leave: " + nodeName);

                String visitedNode = nodeStack.removeLast();
                Assert.assertEquals("tag name:", visitedNode, nodeName);
            }

            public void visitNode(String nodeName, TreeWalker walker) throws XerialException
            {
                _logger.debug("visit: " + nodeName);

                if (nodeName.equals("description"))
                {
                    TreeNode subtree = walker.getSubTree();
                }
                else
                {
                    nodeStack.add(nodeName);
                }

            }

            public void text(String nodeValue) throws XerialException
            {
            // TODO Auto-generated method stub

            }
        });
    }
}
