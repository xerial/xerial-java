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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.bean.JSONStreamWalker;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitorBase;
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

    public static TreeWalkLog walk(String silkFile) throws IOException, XerialException
    {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, silkFile));
        TreeWalkLog l1 = new TreeWalkLog();
        walker.walk(l1);
        _logger.debug(l1.toString());
        return l1;
    }

    public void compare(String silkFile, String jsonFile) throws IOException, XerialException
    {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, silkFile));
        TreeWalkLog l1 = new TreeWalkLog();
        TreeWalkLog l2 = new TreeWalkLog();

        walker.walk(l1);

        JSONStreamWalker jWalker = new JSONStreamWalker(FileResource.open(SilkWalkerTest.class, jsonFile));
        jWalker.walk(l2);

        Assert.assertTrue(TreeWalkLog.compare(l1, l2));
    }

    @Test
    public void testSmall() throws IOException, XerialException
    {
        compare("small.silk", "small.json");
    }

    @Test
    public void testTab() throws IOException, XerialException
    {
        //TreeWalkLog l = walk("tab.silk");
        //_logger.info("\n" + l);
        compare("tab.silk", "tab.json");
    }

    @Test
    public void testConfig() throws IOException, XerialException
    {
        compare("suzaku-config.silk", "suzaku-config.json");
    }

    @Test
    public void testInlineJSON() throws IOException, XerialException
    {
        compare("inline.silk", "inline.json");
    }

    @Test
    public void testCSV() throws IOException, XerialException
    {
        compare("csv.silk", "csv.json");
    }

    @Test
    public void testCSVOneLine() throws IOException, XerialException
    {
        compare("csv-oneline.silk", "csv.json");
    }

    @Test
    public void testMicroFormat() throws IOException, XerialException
    {
        compare("microformat.silk", "microformat.json");
    }

    @Test
    public void testExample() throws Exception
    {
        // TODO modify JSON stream walker to handle value as an immediate node value
        TreeWalkLog l = walk("example.silk");
    }

    @Test
    public void testLoad() throws Exception
    {
        walk("plugin/load-binary.silk");
    }

    @Test
    public void testFunc() throws Exception
    {
        TreeWalkLog l = walk("func.silk");
    }

    @Test
    public void testGeneSequence() throws Exception
    {
        TreeWalkLog l = walk("sequence.silk");
    }

    @Test
    public void testSkipDescendants() throws Exception
    {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, "small.silk"));
        walker.walk(new TreeVisitorBase() {
            @Override
            public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
            {
                if (nodeName.equals("p1") || nodeName.equals("p2") || nodeName.equals("id") || nodeName.equals("name"))
                    Assert.fail("node " + nodeName + " must be skipped");

                if (nodeName.equals("data") || nodeName.equals("node2"))
                    walker.skipDescendants();

                _logger.debug("visit: " + nodeName);
            }

            @Override
            public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
            {
                _logger.debug("leave: " + nodeName);
            }

        });

    }

    @Test
    public void testGetSubtree() throws Exception
    {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, "small.silk"));
        walker.walk(new TreeVisitorBase() {
            @Override
            public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
            {
                if (nodeName.equals("link"))
                {
                    TreeNode node = walker.getSubTree();
                    assertNotNull(node);

                    assertEquals("link", node.getNodeName());
                    assertNull(node.getNodeValue());
                    assertEquals(2, node.getChildren().size());

                    TreeNode pageNameNode = node.getChildren().get(0);
                    assertEquals("page name", pageNameNode.getNodeName());
                    assertEquals("Welcome to Xerial", pageNameNode.getNodeValue());

                    TreeNode urlNode = node.getChildren().get(1);
                    assertEquals("url", urlNode.getNodeName());
                    assertEquals("http://www.xerial.org/", urlNode.getNodeValue());

                }
            }
        });

    }

}
