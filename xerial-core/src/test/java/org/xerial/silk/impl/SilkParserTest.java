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
// SilkParserTest.java
// Since: Jan 28, 2009 6:32:05 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import java.io.IOException;
import java.util.Map;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.StringUtil;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

public class SilkParserTest
{
    private static Logger _logger = Logger.getLogger(SilkParserTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    static void parse(String filePath) throws IOException, RecognitionException
    {
        SilkLexer lexer = new SilkLexer(new ANTLRReaderStream(FileResource.open(SilkParserTest.class, filePath)));
        CommonTokenStream token = new CommonTokenStream(lexer);
        Map<Integer, String> tokenTable = ANTLRUtil.getTokenTable(SilkLexer.class, "Silk.tokens");
        _logger.info("\n" + StringUtil.join(ANTLRUtil.prettyPrintTokenList(token.getTokens(), tokenTable), "\n"));
        SilkParser parser = new SilkParser(token);
        SilkParser.silkFile_return ret = parser.silkFile();
        _logger.info("\n" + ANTLRUtil.parseTree((Tree) ret.getTree(), parser.getTokenNames()));
    }

    @Test
    public void testExample() throws Exception
    {
        parse("../example.silk");
    }

    @Test
    public void testFunction() throws Exception
    {
        parse("../funk.silk");
    }

    @Test
    public void testSuzakuConfig() throws Exception
    {
        parse("../suzaku-config.silk");
    }

    @Test
    public void testTab() throws Exception
    {
        parse("../tab.silk");
    }

    @Test
    public void testJSON() throws Exception
    {
        parse("../json.silk");
    }

    @Test
    public void testSmall() throws Exception
    {
        parse("../small.silk");
    }

    @Test
    public void testType() throws Exception
    {
        parse("../type.silk");
    }

    @Test
    public void pullTest() throws Exception
    {
        String filePath = "../small.silk";

        SilkLexer lexer = new SilkLexer(new ANTLRReaderStream(FileResource.open(SilkParserTest.class, filePath)));
        CommonTokenStream token = new CommonTokenStream(lexer);
        Map<Integer, String> tokenTable = ANTLRUtil.getTokenTable(SilkLexer.class, "Silk.tokens");
        //_logger.info("\n" + StringUtil.join(ANTLRUtil.prettyPrintTokenList(token.getTokens(), tokenTable), "\n"));

        SilkParser parser = new SilkParser(token);
        int lastIndex = Integer.MIN_VALUE;
        int currentIndex = token.index();

        while (lastIndex < currentIndex)
        {
            _logger.info(String.format("%d, %d", lastIndex, currentIndex));
            SilkParser.silkLine_return ret = parser.silkLine();
            _logger.info("\n" + ANTLRUtil.parseTree((Tree) ret.getTree(), parser.getTokenNames()));
            lastIndex = currentIndex;
            currentIndex = token.index();
        }
        _logger.info(String.format("%d, %d", lastIndex, currentIndex));

    }
}
