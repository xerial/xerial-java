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
// XMLTreeWalkerTest.java
// Since: 2009/03/30 23:21:17
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

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

public class XMLTreeWalkerTest
{
    private static Logger _logger = Logger.getLogger(XMLTreeWalkerTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testGetSubTree() throws IOException, XerialException
    {
        XMLTreeWalker walker = new XMLTreeWalker(FileResource.open(XMLTreeWalkerTest.class, "../bean/skip.xml"));
        walker.walk(new TreeVisitor() {

            LinkedList<String> nodeStack = new LinkedList<String>();

            public void finish(TreeWalker walker) throws XerialException
            {

            }

            public void init(TreeWalker walker) throws XerialException
            {

            }

            public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
            {
                _logger.info("leave: " + nodeName);

                String visitedNode = nodeStack.removeLast();
                Assert.assertEquals("tag name:", visitedNode, nodeName);
            }

            public void visitNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
            {
                _logger.info(String.format("visit: %s %s", nodeName, nodeValue != null ? nodeValue : ""));

                // skip description node
                if (nodeName.equals("description"))
                {
                    TreeNode subtree = walker.getSubTree();
                    assertEquals("description", subtree.getNodeName());
                    assertNull(subtree.getNodeValue());

                    assertEquals(1, subtree.getChildren().size());
                    assertEquals("text", subtree.getChildren().get(0).getNodeName());
                    assertEquals("page", subtree.getChildren().get(0).getNodeValue());

                    _logger.info(String.format("subtree: %s", subtree));
                }
                else
                {
                    nodeStack.add(nodeName);
                }

            }

            public void text(String nodeValue, TreeWalker walker) throws XerialException
            {
                _logger.info("text:  " + nodeValue);

            }
        });
    }

    @Test
    public void testSkipDescendants()
    {
        fail("Not yet implemented");
    }

}
