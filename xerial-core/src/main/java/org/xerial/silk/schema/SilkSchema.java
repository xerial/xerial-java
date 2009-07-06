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
// SilkSchema.java
// Since: Jul 3, 2009 2:39:31 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.silk.schema.impl.SilkSchemaLexer;
import org.xerial.silk.schema.impl.SilkSchemaParser;
import org.xerial.util.StringUtil;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.log.Logger;

public class SilkSchema {
    private static Logger _logger = Logger.getLogger(SilkSchema.class);

    public List<SilkModule> module;
    public List<SilkRelation> relation;

    /**
     * parse the input schema file and return the parse result in the form of
     * SilkSchema
     * 
     * @param reader
     * @return an instance of SilkSchema
     * @throws XerialException
     */
    public static SilkSchema parse(Reader reader) throws XerialException {
        try {
            SilkSchemaLexer lexer = new SilkSchemaLexer(new ANTLRReaderStream(reader));
            CommonTokenStream token = new CommonTokenStream(lexer);

            if (_logger.isDebugEnabled())
                _logger
                        .debug(StringUtil.join(ANTLRUtil
                                .prettyPrintTokenList(token.getTokens(), ANTLRUtil.getTokenTable(
                                        SilkSchemaLexer.class, "SilkSchema.tokens")), "\n"));

            SilkSchemaParser parser = new SilkSchemaParser(token);

            SilkSchemaParser.schema_return ret = parser.schema();

            if (_logger.isDebugEnabled())
                _logger.debug("parse tree:\n"
                        + ANTLRUtil.parseTree((Tree) ret.getTree(), SilkSchemaParser.tokenNames));

            return Lens.loadANTLRParseTree(SilkSchema.class, (Tree) ret.getTree(),
                    SilkSchemaParser.tokenNames);
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, String.format(
                    "parse error line %d(%d): %s", e.line, e.charPositionInLine, e));
        }

    }

}
