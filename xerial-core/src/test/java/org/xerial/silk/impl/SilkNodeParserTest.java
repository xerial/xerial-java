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
// SilkNodeParserTest.java
// Since: May 29, 2009 1:13:58 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.silk.model.SilkNode;
import org.xerial.util.FileResource;

public class SilkNodeParserTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testParser() throws Exception {
        SilkLineLexer lexer = new SilkLineLexer(new ANTLRReaderStream(FileResource.open(
                SilkNodeParserTest.class, "node.silk")));

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SilkNodeParser parser = new SilkNodeParser(tokenStream);
        SilkNode node = parser.parseSilkNode().build();

        assertEquals("coordinate", node.getName());
        assertEquals(0, node.getIndentLevel());
        List<SilkNode> children = node.getChildNodes();
        assertEquals(3, children.size());

    }

}
