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

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.json.JSONStreamWalker;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitorBase;
import org.xerial.util.tree.TreeWalker;

public class SilkWalkerTest
{
    private static Logger _logger = Logger.getLogger(SilkWalkerTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public static TreeWalkLog walk(String silkFile) throws IOException, XerialException {
        URL f = FileResource.find(SilkWalkerTest.class, silkFile);
        if (f == null)
            throw new IOException(String.format("Resource %s is not found", silkFile));
        SilkWalker walker = new SilkWalker(f);
        TreeWalkLog l1 = new TreeWalkLog();
        walker.walk(l1);
        _logger.debug(l1.toString());
        return l1;
    }

    public static void compare(String silkFile, String jsonFile) throws IOException, XerialException {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, silkFile));
        TreeWalkLog l1 = new TreeWalkLog();
        TreeWalkLog l2 = new TreeWalkLog();

        walker.walk(l1);
        _logger.debug(l1);

        JSONStreamWalker jWalker = new JSONStreamWalker(FileResource.open(SilkWalkerTest.class, jsonFile, "UTF8"));
        jWalker.walk(l2);

        Assert.assertTrue(TreeWalkLog.compare(l1, l2));
    }

    @Test
    public void testSmall() throws IOException, XerialException {
        compare("small.silk", "small.json");
    }

    @Test
    public void testTab() throws IOException, XerialException {
        //TreeWalkLog l = walk("tab.silk");
        //_logger.info("\n" + l);
        compare("tab.silk", "tab.json");
    }

    @Test
    public void testConfig() throws IOException, XerialException {
        compare("suzaku-config.silk", "suzaku-config.json");
    }

    @Test
    public void testInlineJSON() throws IOException, XerialException {
        compare("inline.silk", "inline.json");
    }

    @Test
    public void testCSV() throws IOException, XerialException {
        compare("csv.silk", "csv.json");
    }

    @Test
    public void testCSVOneLine() throws IOException, XerialException {
        compare("csv-oneline.silk", "csv.json");
    }

    @Test
    public void testMicroFormat() throws IOException, XerialException {
        compare("microformat.silk", "microformat.json");
    }

    @Test
    public void testBarChart() throws IOException, XerialException {
        compare("barchart.silk", "barchart.json");
    }

    @Test
    public void testExample() throws Exception {
        // TODO modify JSON stream walker to handle value as an immediate node value
        TreeWalkLog l = walk("example.silk");
    }

    @Test
    public void testLoad() throws Exception {
        compare("plugin/load-binary.silk", "plugin/load-binary.json");
    }

    @Test
    public void testFunc() throws Exception {
        TreeWalkLog l = walk("func.silk");
    }

    @Test
    public void testGeneSequence() throws Exception {
        TreeWalkLog l = walk("sequence.silk");
    }

    @Test
    public void testNoNameNode() throws Exception {
        compare("noname-node.silk", "noname-node.json");
    }

    @Test
    public void testHereDocument() throws Exception {
        compare("heredoc.silk", "heredoc.json");
    }

    @Test
    public void testNullMultiline() throws Exception {
        compare("null-multiline.silk", "null-multiline.json");
    }

    @Test
    public void testScaffold() throws Exception {
        TreeWalkLog l = walk("scaffold5001.silk");
    }

    @Test
    public void testQV() throws Exception {
        compare("qv.silk", "qv.json");
    }

    @Test
    public void testMultiLineEscape() throws Exception {
        compare("multiline.silk", "multiline.json");
    }

    @Test
    public void testBED() throws Exception {
        TreeWalkLog l = walk("sample.bed.silk");
    }

    @Test
    public void testSkipDescendants() throws Exception {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, "small.silk"));
        walker.walk(new TreeVisitorBase() {
            @Override
            public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException {
                if (nodeName.equals("p1") || nodeName.equals("p2") || nodeName.equals("id") || nodeName.equals("name"))
                    Assert.fail("node " + nodeName + " must be skipped");

                if (nodeName.equals("data") || nodeName.equals("node2"))
                    walker.skipDescendants();

                _logger.debug("visit: " + nodeName);
            }

            @Override
            public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
                _logger.debug("leave: " + nodeName);
            }

        });

    }

    @Test
    public void testGetSubtree() throws Exception {
        SilkWalker walker = new SilkWalker(FileResource.find(SilkWalkerTest.class, "small.silk"));
        walker.walk(new TreeVisitorBase() {
            @Override
            public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException {
                if (nodeName.equals("link")) {
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

    @Ignore
    @Test
    public void testTabAndNode() throws Exception {
        compare("tab-node.silk", "tab-node.json");
    }

    @Ignore
    @Test
    public void testTabAndNode2() throws Exception {
        compare("tab-node2.silk", "tab-node2.json");
    }

    @Ignore
    @Test
    public void testTabAndNode2Alt() throws Exception {
        compare("tab-node2-alt.silk", "tab-node2.json");
    }

    @Test
    public void testMultiLineTextWithNewLine() throws Exception {
        compare("mltext.silk", "mltext.json");
    }

    @Test
    public void sam() throws Exception {
        compare("sam.silk", "sam.json");
    }

    @Test
    public void textValue() throws Exception {
        compare("textvalue.silk", "textvalue.json");
    }

    public static class DateTest
    {
        public Date time;
    }

    @Test
    public void date() throws Exception {
        Date now = new Date();
        DateTest dt = new DateTest();
        dt.time = now;

        String silk = SilkUtil.toSilk(dt);

        _logger.info(silk);

        // TODO date check
        //DateTest dt2 = SilkUtil.loadSilk(DateTest.class, new StringReader(silk));

        //assertTrue(dt.time.compareTo(dt2.time) >= 0);

    }

    @Test
    public void samqv() throws Exception {
        compare("samqv.silk", "samqv.json");
    }

    @Test
    public void utf8() throws Exception {
        compare("utf8.silk", "utf8.json");
    }

    @Test
    public void utgbView() throws Exception {
        SilkPullParser p = new SilkPullParser(FileResource.open(SilkWalkerTest.class, "utgb-view.silk"));
        for (TreeEvent e; (e = p.next()) != null;) {
            _logger.debug(e);
        }

    }

}
