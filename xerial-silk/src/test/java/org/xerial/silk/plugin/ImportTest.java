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
// ImportTest.java
// Since: Feb 9, 2009 6:55:52 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.plugin;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.json.JSONStreamWalker;
import org.xerial.silk.SilkWalker;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitorBase;
import org.xerial.util.tree.TreeWalkLog;

public class ImportTest
{
    private static Logger _logger = Logger.getLogger(ImportTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public void compare(String silkFile, String jsonFile) throws IOException, XerialException {
        TreeWalkLog l1 = walk(silkFile);
        TreeWalkLog l2 = new TreeWalkLog();

        JSONStreamWalker jWalker = new JSONStreamWalker(FileResource.open(ImportTest.class, jsonFile));
        jWalker.walk(l2);

        Assert.assertTrue(TreeWalkLog.compare(l1, l2));
    }

    public TreeWalkLog walk(String silkFile) throws IOException, XerialException {
        SilkWalker walker = new SilkWalker(FileResource.find(ImportTest.class, silkFile));
        TreeWalkLog l1 = new TreeWalkLog();

        walker.walk(l1);
        _logger.debug(l1);

        return l1;
    }

    @Test
    public void testEval() throws Exception {

        SilkWalker walker = new SilkWalker(FileResource.find(ImportTest.class, "import.silk"));
        walker.walk(new TreeVisitorBase());
    }

    @Test
    public void testImport() throws Exception {
        compare("import.silk", "import.json");
    }

    @Test
    public void loadBinary() throws Exception {
        compare("load-binary.silk", "load-binary.json");
    }

    @Test
    public void testBinary() throws Exception {
        walk("load-binary.silk");
    }

}
