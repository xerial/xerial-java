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
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialException;
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkLexer;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkParser;
import org.xerial.silk.impl.SilkParser.silkLine_return;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.log.Logger;

/**
 * Pull parser of the Silk format. Pull-style means each parsing event is
 * generated when next() method is called, suited to stream processing.
 * 
 * @author leo
 * 
 */
public class SilkPullParser
{
    private static Logger _logger = Logger.getLogger(SilkPullParser.class);

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
        if (tokenStream.LT(1) == Token.EOF_TOKEN)
            return SilkEvent.END_OF_FILE;
        _logger.info("next");
        try
        {
            silkLine_return ret = parser.silkLine();
            Tree t = (Tree) ret.getTree();
            switch (t.getType())
            {
            case SilkParser.Function:
            {
                SilkFunction func = BeanUtilImpl.createBeanFromParseTree(SilkFunction.class, t, SilkParser.tokenNames);
                return SilkEvent.FUNCTION;
            }
            case SilkParser.SilkNode:
            {
                SilkNode node = BeanUtilImpl.createBeanFromParseTree(SilkNode.class, t, SilkParser.tokenNames);
                return SilkEvent.NODE;
            }
            case SilkParser.BlankLine:
            {
                return SilkEvent.BLANK_LINE;
            }
            case SilkParser.DataLine:
            {
                String dataLine = t.getText();
                return SilkEvent.DATA_LINE;
            }
            }

        }
        catch (RecognitionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (XerialException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
