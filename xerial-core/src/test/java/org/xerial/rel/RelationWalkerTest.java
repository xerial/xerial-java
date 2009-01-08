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
// RelationWalkerTest.java
// Since: Jan 7, 2009 5:52:12 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.rel;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.bean.TreeVisitor;
import org.xerial.util.bean.TreeWalker;
import org.xerial.util.log.Logger;

public class RelationWalkerTest
{
    private static Logger _logger = Logger.getLogger(RelationWalkerTest.class);

    @Before
    public void setUp() throws Exception
    {
        Logger.configure(FileResource.open(RelationPullParserTest.class, "log.config"));
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void walk() throws IOException, XerialException
    {
        RelationWalker walker = new RelationWalker(FileResource.open(RelationWalkerTest.class, "tab.rel"));
        walker.walk(new TreeVisitor() {

            public void finish(TreeWalker walker) throws XerialException
            {
                _logger.debug("finish");
            }

            public void init(TreeWalker walker) throws XerialException
            {
                _logger.debug("init");
            }

            public void leaveNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
            {
                if (nodeValue != null)
                    _logger.debug(String.format("leave: %-10s = %s", nodeName, nodeValue));
                else
                    _logger.debug(String.format("leave: %-10s", nodeName));
            }

            public void visitNode(String nodeName, TreeWalker walker) throws XerialException
            {
                _logger.debug(String.format("visit: %-10s", nodeName));
            }
        });

    }

}
