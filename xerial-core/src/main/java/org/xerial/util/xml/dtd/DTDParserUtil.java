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
// DTDParserUtil.java
// Since: Jul 25, 2007 4:37:10 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.dtd;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

public class DTDParserUtil
{
	private static Logger _logger = Logger.getLogger(DTDParserUtil.class);
	
    public static DTDParser createParser(InputStream dtdStream) throws IOException
    {
        DTDLexer lexer = new DTDLexer(new ANTLRInputStream(dtdStream));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        _logger.trace(StringUtil.join(tokens.getTokens(), StringUtil.newline()));
        DTDParser parser = new DTDParser(tokens);
        return parser;
    }
    
}
