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
// SilkLexerTest.java
// Since: Jan 28, 2009 3:40:35 PM
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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.StringUtil;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

public class SilkLexerTest
{
    private static Logger _logger = Logger.getLogger(SilkLexerTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    static void scan(String filePath) throws IOException, RecognitionException
    {
        SilkLexer lexer = new SilkLexer(new ANTLRReaderStream(FileResource.open(SilkParserTest.class, filePath)));
        CommonTokenStream token = new CommonTokenStream(lexer);
        Map<Integer, String> tokenTable = ANTLRUtil.getTokenTable(SilkLexer.class, "Silk.tokens");
        _logger.debug("\n" + StringUtil.join(ANTLRUtil.prettyPrintTokenList(token.getTokens(), tokenTable), "\n"));
    }

    @Test
    public void tokenTest() throws Exception
    {
        SilkLexer lexer = new SilkLexer(
                new ANTLRReaderStream(FileResource.open(SilkLexerTest.class, "../example.silk")));

        Map<Integer, String> tokenTable = ANTLRUtil.getTokenTable(SilkLexer.class, "Silk.tokens");

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        _logger
                .debug("\n"
                        + StringUtil.join(ANTLRUtil.prettyPrintTokenList(tokenStream.getTokens(), tokenTable), "\n"));
    }

    @Test
    public void testOutValue() throws Exception
    {
        scan("outvalue.silk");
    }

    @Test
    public void testBarChart() throws Exception
    {
        scan("../barchart.silk");
    }

    @Test
    public void testMicroFormat() throws Exception
    {
        scan("../microformat.silk");
    }

    @Test
    public void testFunc() throws Exception
    {
        scan("../func.silk");
    }

    @Test
    public void testHeredoc() throws Exception
    {
        scan("../heredoc.silk");
    }

    @Test
    public void testScaffold() throws Exception
    {
        scan("../scaffold5001.silk");
    }
}
