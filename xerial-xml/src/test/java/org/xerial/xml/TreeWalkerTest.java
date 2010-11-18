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
// TreeWalkerTest.java
// Since: Mar 31, 2009 1:27:39 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.io.Reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

public class TreeWalkerTest
{

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    class MyWalker extends XMLTreeWalker
    {
        public MyWalker(Reader xmlReader) {
            super(xmlReader);
        }

    }

    @Test
    public void testname() throws Exception {
        MyWalker walker = new MyWalker(FileResource.open(TreeWalkerTest.class, "simple.xml"));
        walker.walk(new TreeVisitor() {

            public void finish(TreeWalker walker) throws XerialException {
                // TODO Auto-generated method stub

            }

            public void init(TreeWalker walker) throws XerialException {
                // TODO Auto-generated method stub

            }

            public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
                // TODO Auto-generated method stub

            }

            public void text(String nodeName, String textDataFragment, TreeWalker walker) throws XerialException {
                // TODO Auto-generated method stub

            }

            public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException {
                // TODO Auto-generated method stub

            }

        });
    }

}
