/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// DOMBuilder.java
// Since: 2004/12/21
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.pullparser;

import java.io.IOException;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import static org.xmlpull.v1.XmlPullParser.*;

/** XML形式入力からDOMのElementを生成するためのクラス
 * PROCESSING_INSTRUCTION, COMMENTは無視される
 * @author leo
 *
 */
public class DOMBuilder
{
    public DOMBuilder()
    {
        // do nothing
    }
    
    /** 任意のReaderからDOMElementを生成
     * @param xmlReader XMLの入力
     * @return XMLの入力に対応するDOMのElement
     * @throws XmlPullParserException parserの生成に失敗したとき
     * @throws IOException XMLの読み込みに失敗したとき
     * @throws XMLException invalidなXMLが読み込まれた場合
     */
    public Element parse(Reader xmlReader) 
        throws XmlPullParserException, IOException, XMLException
    {
        XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = parserFactory.newPullParser();
        //parser.setFeature(FEATURE_PROCESS_NAMESPACES, true);
        parser.setInput(xmlReader);
        parser.next();
        return parse(parser);
    }
    
    /** 現在のPullParserの位置の状態から部分木に対応するDOM Elementを生成する。
     * side effect: PullParserのparsingは、部分木分だけ進み、その部分木のEND_TAGを指した状態になる
     * @param pullParser
     * @throws IOException XMLの読み込みに失敗したとき
     * @throws XMLException invalidなXMLが読み込まれた場合
     * @return 入力のXMLに対応するDOMのElement
     */
    public Element parse(XmlPullParser pullParser)
        throws XMLException, IOException
    {
        return parseSubTree(pullParser);
    }
    
    protected Element parseSubTree(XmlPullParser pullParser)
        throws XMLException, IOException
    {
        Document document = createNewDOMDocument(); 
        try
        {
            return parseElement(pullParser, document);
        }
        catch(XmlPullParserException e)
        {
            throw new InvalidXMLException(e);
        }
    }
    
    protected Element parseElement(XmlPullParser pullParser, Document document)
        throws XmlPullParserException, InvalidXMLException, IOException
    {
        pullParser.require(START_TAG, null, null); // START_TAGからでないとelementのparseはできない
        String tagName = pullParser.getName();
        //String nameSpace = pullParser.getNamespace();
        //String prefix = pullParser.getPrefix();
        //String qName = prefix != null ? prefix + ":" + tagName : tagName;
        String qName = tagName; 
        Element element = document.createElement(qName);
        
        // read attributes
        for (int i = 0; i < pullParser.getAttributeCount(); i++)
        {
            //String attributeNameSpace = pullParser.getAttributeNamespace(i);
            String attributeName = pullParser.getAttributeName(i);
            String attributeValue = pullParser.getAttributeValue(i);
            element.setAttribute(attributeName, attributeValue);
//            if(attributeNameSpace == null || attributeNameSpace.length() == 0)
//            {
//                element.setAttribute(attributeName, attributeValue);
//            }
//            else
//            {
//                String attributePrefix = pullParser.getAttributePrefix(i);
//                String attributeQName = createQName(attributePrefix, attributeName);
//                element.setAttributeNS(attributeNameSpace, attributeQName, attributeValue);
//            }
        }
        
        // read child nodes
        while(pullParser.next() != END_TAG)
        {
            switch(pullParser.getEventType())
            {
            case START_TAG:
                Element childElement = parseElement(pullParser, document);
                element.appendChild(childElement);
                break;
            case TEXT:
                String text = pullParser.getText();
                Text textElement = document.createTextNode(text);
                element.appendChild(textElement);
                break;
            default:    // END_DOCUMENT, etc
                throw new InvalidXMLException("line " + pullParser.getLineNumber() + ": tag <" + qName + "> is not closed"); 
            }
        }
        
        pullParser.require(END_TAG, null, tagName);
        return element;
    }
    
    
    protected String createQName(String prefix, String name)
    {
        return prefix == null ? name : prefix + ":" + name;
    }
    
    protected Document createNewDOMDocument()
        throws XMLException
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            return docBuilder.newDocument();
        }
        catch (ParserConfigurationException e)
        {
            throw new XMLException(e);
        }
    }
    
}


