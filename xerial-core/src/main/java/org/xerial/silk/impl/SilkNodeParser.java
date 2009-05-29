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
// SilkNodeParser.java
// Since: May 29, 2009 11:47:21 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import static org.xerial.silk.impl.SilkLexer.*;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * 
 * 
 * @author leo
 * 
 */
public class SilkNodeParser
{
    private CommonTokenStream tokenStream;

    public SilkNodeParser(CommonTokenStream tokenStream)
    {
        this.tokenStream = tokenStream;
    }

    public SilkElement parse() throws XerialException
    {
        switch (tokenStream.LA(1))
        {
        case NodeIndent:
            return parseSilkNode();
        case FunctionIndent:
            SilkFunction func = parseFunction();
            return func;
        default:
            throw new XerialException(XerialErrorCode.PARSE_ERROR, "invalid token: " + toString(tokenStream.LT(1)));
        }
    }

    private Token getToken(int index)
    {
        Token t = tokenStream.LT(index);
        return t;
    }

    private void consume()
    {
        tokenStream.consume();
    }

    public SilkNode parseSilkNode() throws XerialException
    {
        return parseSilkNode(new SilkNode());
    }

    private SilkNode parseSilkNode(SilkNode node) throws XerialException
    {
        if (tokenStream.LA(1) != NodeIndent)
            throw new XerialException(XerialErrorCode.PARSE_ERROR, "expected a node indent, but "
                    + toString(tokenStream.LT(1)));

        Token indent = getToken(1);
        node.setNodeIndent(indent.getText());
        consume();

        switch (tokenStream.LA(1))
        {
        case LParen:
            parseAttributeList();
            break;
        default:
        {
            SilkNode child = parseNodeItem();
            node.addSilkNode(child);
            break;
        }
        }
        return node;
    }

    private SilkNode parseNodeItem() throws XerialException
    {
        // node name
        SilkNode newNode = new SilkNode();
        String nodeName = parseNodeName();
        newNode.setName(nodeName);

        parseDataType(newNode);
        parseNodeItemAttr(newNode);

        // TODO

        return newNode;
    }

    private void parseNodeItemAttr(SilkNode node) throws XerialException
    {
        if (tokenStream.LA(1) != LParen)
            return;

        consume();

        parseAttributeList();

        match(RParen);

    }

    private void parseAttributeList() throws XerialException
    {
        // TODO
        parseAttributeItem();
    }

    private SilkNode parseAttributeItem() throws XerialException
    {
        SilkNode node = parseNodeItem();
        return node;
    }

    /**
     * test match with the specified token type, and return the matched token.
     * If the input token doesn't match, throw an exception
     * 
     * @param tokenType
     * @return matched token
     * @throws XerialException
     */
    private Token match(int tokenType) throws XerialException
    {
        Token t = getToken(1);
        if (t.getType() == tokenType)
        {
            consume();
            return t;
        }
        else
        {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, java.lang.String.format("expected %s, but %s",
                    SilkParser.tokenNames[tokenType], toString(t)));
        }
    }

    private void parseDataType(SilkNode node) throws XerialException
    {
        if (tokenStream.LA(1) != LBracket)
            return;

        consume();

        Token dtToken = getToken(1);
        // dataTypeName

        String nodeName = match(PlainOneLine).getText();
        node.setDataType(nodeName);

        match(RBracket);

    }

    private String parseNodeName() throws XerialException
    {
        Token t = getToken(1);
        switch (tokenStream.LA(1))
        {
        case PlainOneLine:
        case String:
            consume();
            return t.getText();
        default:
            throw new XerialException(XerialErrorCode.PARSE_ERROR, "expected PlainOneLine or String, but "
                    + toString(t));
        }
    }

    private SilkFunction parseFunction()
    {
        return null;
    }

    private String toString(Token t)
    {
        return java.lang.String.format("[%s(%d), %s]", SilkParser.tokenNames[t.getType()], t.getCharPositionInLine(), t
                .getText());
    }
}
