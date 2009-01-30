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
// SilkPullParser.java
// Since: Jan 28, 2009 1:00:02 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.xerial.silk.impl.SilkLexer;
import org.xerial.silk.impl.SilkParser;
import org.xerial.silk.impl.SilkParser.silkLine_return;

/**
 * Pull parser of the Silk format. Pull-style means each parsing event is
 * generated when next() method is called, suited to stream processing.
 * 
 * @author leo
 * 
 */
public class SilkPullParser
{
    private final SilkLexer lexer;
    private CommonTokenStream tokenStream;
    private SilkParser parser;

    public SilkPullParser(InputStream input) throws IOException
    {
        lexer = new SilkLexer(new ANTLRInputStream(input));
        init();
    }

    public SilkPullParser(Reader input) throws IOException
    {
        lexer = new SilkLexer(new ANTLRReaderStream(input));
        init();
    }

    private void init()
    {
        tokenStream = new CommonTokenStream(lexer);
        parser = new SilkParser(tokenStream);
    }

    public SilkEvent next()
    {
        try
        {
            silkLine_return ret = parser.silkLine();

        }
        catch (RecognitionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
