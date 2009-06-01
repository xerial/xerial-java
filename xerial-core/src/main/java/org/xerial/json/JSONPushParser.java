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
// JSONPushParser.java
// Since: Jun 1, 2009 5:52:05 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import static org.xerial.json.impl.JSONLexer.*;

import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.xerial.json.impl.JSONLexer;

/**
 * Push-style JSON parser
 * 
 * @author leo
 * 
 */
public class JSONPushParser
{
    private JSONLexer lexer;

    public JSONPushParser(String json)
    {
        lexer = new JSONLexer(new ANTLRStringStream(json));
    }

    public JSONPushParser(Reader input) throws IOException
    {
        lexer = new JSONLexer(new ANTLRReaderStream(input));
    }

    private JSONEventHandler handler;

    public void parse(JSONEventHandler handler)
    {
        this.handler = handler;

        Token t = lexer.nextToken();

        switch (t.getType())
        {
        case Integer:
            break;
        case Double:
            break;
        case String:
            break;
        case LBracket:
            break;
        case RBracket:
            break;
        case LBrace:
            break;
        case RBrace:
            break;
        case Comma:
            break;
        case Colon:
            break;
        case TRUE:
            break;
        case FALSE:
            break;
        case NULL:
            break;
        }

    }

}
