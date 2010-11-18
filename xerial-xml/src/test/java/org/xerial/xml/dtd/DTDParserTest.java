/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// DTDParserTest.java
// Since: Jul 25, 2007 2:30:47 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml.dtd;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.antlr.ANTLRUtil;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.xml.dtd.DTDParserUtil;
import org.xerial.xml.dtd.impl.DTDParser;

public class DTDParserTest {
    Logger _logger = Logger.getLogger(DTDParserTest.class);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void parse() throws IOException, RecognitionException {
        DTDParser parser = DTDParserUtil.createParser(FileResource.find(DTDParserTest.class,
                "auction.dtd").openStream());
        DTDParser.dtd_return r = parser.dtd();
        CommonTree t = (CommonTree) r.getTree();
        _logger.debug(ANTLRUtil.parseTree(t, DTDParser.tokenNames));
    }

    @Test
    public void parseLine() throws IOException, RecognitionException {
        DTDParser parser = DTDParserUtil.createParser(FileResource.find(DTDParserTest.class,
                "simple.dtd").openStream());
        DTDParser.dtd_return r = parser.dtd();
        CommonTree t = (CommonTree) r.getTree();
        _logger.debug(ANTLRUtil.parseTree(t, DTDParser.tokenNames));
    }
}
