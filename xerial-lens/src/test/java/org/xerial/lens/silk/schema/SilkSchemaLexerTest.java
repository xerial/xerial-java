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
// SilkSchemaLexerTest.java
// Since: Jul 3, 2009 2:15:48 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.silk.schema;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.antlr.ANTLRUtil;
import org.xerial.silk.schema.impl.SilkSchemaLexer;
import org.xerial.util.FileResource;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

public class SilkSchemaLexerTest
{

    private static Logger _logger = Logger.getLogger(SilkSchemaLexerTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void lex() throws Exception {
        SilkSchemaLexer lexer = new SilkSchemaLexer(new ANTLRReaderStream(FileResource.open(SilkSchemaLexerTest.class,
                "../schema.silk")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        _logger.debug(StringUtil.join(
                ANTLRUtil.prettyPrintTokenList(tokens.getTokens(),
                        ANTLRUtil.getTokenTable(SilkSchemaLexer.class, "SilkSchema.tokens")), "\n"));
    }
}
