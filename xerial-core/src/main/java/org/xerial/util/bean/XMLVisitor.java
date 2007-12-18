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
// XMLVisitor.java
// Since: Dec 18, 2007 11:27:39 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.IOException;
import java.io.Reader;


import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.SAXEventHandler;
import org.xerial.util.xml.pullparser.SAXParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Visitor model for XML data
 * @author leo
 *
 */
public class XMLVisitor 
{
    /**
     * A visitor implementation for XML stream
     * @author leo
     *
     */
    private class XMLStreamVisitor implements SAXEventHandler
    {
        private final SAXParser parser;
        
        public XMLStreamVisitor()
        {
            parser = new SAXParser(this);
        }

        
        public void endDocument(XmlPullParser parser) throws Exception
        {
            visitor.finish();
        }

        public void endTag(XmlPullParser parser) throws Exception
        {
            visitor.leaveNode(parser.getName());
        }

        public void startDocument(XmlPullParser parser) throws Exception
        {
            visitor.init();
        }

        public void startTag(XmlPullParser parser) throws Exception
        {
            visitor.visitNode(parser.getName());
        }


        public void text(XmlPullParser parser) throws Exception
        {
            visitor.foundText(parser.getText());
        }


        public void parse(Reader reader) throws Exception, IOException
        {
            parser.parse(reader);
        }

    }
    
    private class XMLDOMVisitor 
    {
        public XMLDOMVisitor()
        {}
        
        public void parse(Element element) throws Exception
        {
            String tagName = element.getNodeName();
            visitor.visitNode(tagName);
            
            NamedNodeMap attributeMap = element.getAttributes();
            for(int i=0; i<attributeMap.getLength(); i++)
            {
                Node attributeNode =  attributeMap.item(i);
                String attributeName = attributeNode.getNodeName();
                String attributeValue = attributeNode.getNodeValue();
                
                visitor.visitNode(attributeName);
                visitor.foundText(attributeValue);
                visitor.leaveNode(attributeName);
            }

            NodeList nodeList = element.getChildNodes();
            for(int i=0; i<nodeList.getLength(); i++)
            {
                Node childNode = nodeList.item(i);
                if(childNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    parse((Element) childNode);
                }
            }
            
            visitor.leaveNode(tagName);
        }
        
    }
    
 
    private TreeVisitor visitor;
    /**
     * Constractor
     * @throws XMLException
     */
    public XMLVisitor(TreeVisitor visitor) throws XMLException
    {
        this.visitor = visitor;
    }
    
    public void parse(Reader xmlDataReader) throws Exception, IOException
    {
        XMLStreamVisitor streamVisitor =  new XMLStreamVisitor();
        streamVisitor.parse(xmlDataReader);
    }
    
    public void parse(Element xmlElement) throws Exception
    {
        XMLDOMVisitor domVisitor = new XMLDOMVisitor();
        
        visitor.init();
        domVisitor.parse(xmlElement);
        visitor.finish();
    }

}
