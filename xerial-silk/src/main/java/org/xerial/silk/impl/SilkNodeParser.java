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

import static org.xerial.silk.impl.SilkLineLexer.*;

import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.model.SilkElement;
import org.xerial.silk.model.SilkFunction;
import org.xerial.silk.model.SilkNode;
import org.xerial.silk.model.SilkNodeOccurrence;
import org.xerial.silk.model.SilkNode.SilkNodeBuilder;
import org.xerial.util.CollectionUtil;
import org.xerial.util.Functor;
import org.xerial.util.StringUtil;

/**
 * Recursive descent parser for {@link SilkNode} and {@link SilkFunction}
 * 
 * @author leo
 * 
 */
public class SilkNodeParser {
    private final CommonTokenStream tokenStream;

    public SilkNodeParser(CommonTokenStream tokenStream) {
        this.tokenStream = tokenStream;
    }

    public SilkElement parse() throws XerialException {
        switch (tokenStream.LA(1)) {
        case NodeIndent:
            if (tokenStream.LA(2) == At)
                return parseFunction();
            else
                return parseSilkNode().build();
        case BlockIndent: {
            SilkNodeBuilder node = parseSilkNode();
            node.setOccurrence(SilkNodeOccurrence.SEQUENCE_PRESERVING_WHITESPACES);
            return node.build();
        }
        case PullUpNodeIndent: {
            SilkNodeBuilder node = parseSilkNode();
            node.setOccurrence(SilkNodeOccurrence.SEQUENCE_PRESERVING_WHITESPACES);
            return node.build();
        }
        case FunctionIndent: {
            SilkFunction func = parseFunction();
            return func;
        }
        default:
            throw unexpectedToken(tokenStream.LT(1), NodeIndent, FunctionIndent);
        }
    }

    private Token getToken(int index) {
        Token t = tokenStream.LT(index);
        return t;
    }

    private void consume() {
        tokenStream.consume();
    }

    public SilkNodeBuilder parseSilkNode() throws XerialException {
        return parseSilkNode(new SilkNodeBuilder());
    }

    private SilkNodeBuilder parseSilkNode(SilkNodeBuilder node) throws XerialException {
        if (!(nextTokenIs(NodeIndent) || nextTokenIs(BlockIndent) || nextTokenIs(PullUpNodeIndent)))
            throw new XerialException(XerialErrorCode.PARSE_ERROR, "expected a node indent, but "
                    + toString(tokenStream.LT(1)));

        Token indent = getToken(1);
        node.setIndent(indent.getText());
        consume();

        switch (tokenStream.LA(1)) {
        case LParen:
            consume();
            parseAttributeList(node);
            testAndConsume(RParen);
            break;
        default: {
            parseNodeItem(node);
            break;
        }
        }
        return node;
    }

    private SilkNodeBuilder parseNodeItem() throws XerialException {
        SilkNodeBuilder newNode = new SilkNodeBuilder();
        return parseNodeItem(newNode);
    }

    private SilkNodeBuilder parseNodeItem(SilkNodeBuilder contextNode) throws XerialException {
        // node name
        String nodeName = parseNodeName();
        contextNode.setName(nodeName);

        parseDataType(contextNode);

        parseNodeItemAttr(contextNode);

        parsePlural(contextNode);

        parseNodeValueOpt(contextNode);

        return contextNode;
    }

    private void parseNodeValueOpt(SilkNodeBuilder node) throws XerialException {
        if (!nextTokenIs(Colon))
            return;

        consume();

        parseNodeValue(node);
    }

    private void parseNodeValue(SilkNodeBuilder node) throws XerialException {
        int nextToken = tokenStream.LA(1);

        switch (nextToken) {
        case At:
            SilkFunction func = parseFunctionInternal(new SilkFunction());
            node.setFunction(func);
            break;
        case PlainOneLine:
        case String: {
            Token t = getToken(1);
            consume();
            node.setValue(t.getText());
            break;
        }
        case JSON: {
            Token t = getToken(1);
            consume();
            node.setJSON(t.getText());
            break;
        }
        default:
            throw unexpectedToken(tokenStream.LT(1), At, PlainOneLine, String);
        }

    }

    private String parseNodeValue() throws XerialException {
        int nextToken = tokenStream.LA(1);

        switch (nextToken) {
        case At:
            // TODO
            throw new XerialException(XerialErrorCode.PARSE_ERROR,
                    "nested function is not yet supported");
        case PlainOneLine:
        case String:
            Token t = getToken(1);
            consume();
            return t.getText();
        default:
            throw unexpectedToken(tokenStream.LT(1), At, PlainOneLine, String);
        }

    }

    private void parsePlural(SilkNodeBuilder node) {
        int nextTokenType = tokenStream.LA(1);
        switch (nextTokenType) {
        case Star:
            node.setOccurrence(SilkNodeOccurrence.ZERO_OR_MORE);
            consume();
            break;
        case Plus:
            node.setOccurrence(SilkNodeOccurrence.ONE_OR_MORE);
            consume();
            break;
        case Question:
            node.setOccurrence(SilkNodeOccurrence.ZERO_OR_ONE);
            consume();
            break;
        case Seq:
            node.setOccurrence(SilkNodeOccurrence.SEQUENCE);
            consume();
            break;
        case TabSeq:
            node.setOccurrence(SilkNodeOccurrence.TABBED_SEQUENCE);
            consume();
            break;
        default:
            // do nothing
            break;
        }

    }

    private void parseNodeItemAttr(SilkNodeBuilder node) throws XerialException {
        if (!nextTokenIs(LParen))
            return;

        consume();

        parseAttributeList(node);

        testAndConsume(RParen);

    }

    private void parseAttributeList(SilkNodeBuilder contextNode) throws XerialException {
        SilkNodeBuilder attributeNode = parseNodeItem();
        contextNode.addSilkNode(attributeNode);

        while (nextTokenIs(Comma)) {
            consume();
            attributeNode = parseNodeItem();
            contextNode.addSilkNode(attributeNode);
        }

    }

    /**
     * test match with the specified token type, and return the matched token.
     * If the input token doesn't match, throw an exception
     * 
     * @param tokenType
     * @return matched token
     * @throws XerialException
     */
    private Token testAndConsume(int tokenType) throws XerialException {
        Token t = getToken(1);
        if (t.getType() == tokenType) {
            consume();
            return t;
        }
        else {
            throw unexpectedToken(t, tokenType);
        }
    }

    /**
     * @param tokenType
     * @return true when the next token has the specified token type, otherwise
     *         false
     */
    private boolean nextTokenIs(int tokenType) {
        return tokenStream.LA(1) == tokenType;
    }

    private void parseDataType(SilkNodeBuilder node) throws XerialException {
        if (!nextTokenIs(LBracket))
            return;

        consume();

        // dataTypeName
        Token dtToken = getToken(1);

        String nodeName = testAndConsume(PlainOneLine).getText();
        node.setDataType(nodeName);

        testAndConsume(RBracket);

    }

    private String parseNodeName() throws XerialException {
        Token t = getToken(1);
        switch (tokenStream.LA(1)) {
        case PlainOneLine:
        case String:
            consume();
            return t.getText().trim();
        default:
            throw unexpectedToken(t, PlainOneLine, String);
        }
    }

    private SilkFunction parseFunction() throws XerialException {
        SilkFunction func = new SilkFunction();
        switch (tokenStream.LA(1)) {
        case NodeIndent: {
            Token t = getToken(1);
            func.setNodeIndent(t.getText());
            consume();
            parseFunctionInternal(func);
            return func;
        }
        case FunctionIndent: {
            Token t = getToken(1); // function indent
            func.setNodeIndent(t.getText());
            consume();

            Token funcName = testAndConsume(PlainOneLine);
            func.setName(funcName.getText().trim());

            parseFunctionArgs(func);

            return func;
        }
        default:

            throw unexpectedToken(tokenStream.LT(1), NodeIndent, FunctionIndent);
        }

    }

    private void parseFunctionArgs(SilkFunction func) throws XerialException {
        testAndConsume(LParen);
        if (!nextTokenIs(RParen)) {
            parseFunctionArg(func);
            while (nextTokenIs(Comma)) {
                consume();
                parseFunctionArg(func);
            }
        }

        testAndConsume(RParen);

    }

    private void parseFunctionArg(SilkFunction func) throws XerialException {
        if (nextTokenIs(String) || nextTokenIs(PlainOneLine)) {
            if (tokenStream.LA(2) == Colon) {
                Token key = getToken(1);
                consume();
                consume();
                String value = parseNodeValue();
                func.addKeyAndValue(key.getText().trim(), value.trim());
                return;
            }
        }

        String value = parseNodeValue();
        func.addArgument(value);
    }

    private SilkFunction parseFunctionInternal(SilkFunction func) throws XerialException {
        testAndConsume(At);
        Token funcName = testAndConsume(PlainOneLine);
        func.setName(funcName.getText().trim());

        parseFunctionArgs(func);

        return func;
    }

    private XerialException unexpectedToken(Token t) throws XerialException {
        return new XerialException(XerialErrorCode.PARSE_ERROR, java.lang.String.format(
                "unexpected token %s", SilkLineParser.tokenNames[t.getType()], toString(t)));

    }

    private XerialException unexpectedToken(Token t, Integer... expectedTokenTypes) {
        List<String> expectedTokenNames = CollectionUtil.collect(expectedTokenTypes,
                new Functor<Integer, String>() {
                    public String apply(Integer input) {
                        return SilkLineParser.tokenNames[input.intValue()];
                    }
                });

        return new XerialException(XerialErrorCode.PARSE_ERROR, java.lang.String.format(
                "expected %s, but %s", StringUtil.join(expectedTokenNames, " or "), toString(t)));
    }

    private String toString(Token t) {

        int type = t.getType();
        return java.lang.String.format("[%s at char %d: %s]", type >= 0
                && type < SilkLineParser.tokenNames.length ? SilkLineParser.tokenNames[type]
                : "unknown token type: " + type, t.getCharPositionInLine(), t.getText());
    }
}
