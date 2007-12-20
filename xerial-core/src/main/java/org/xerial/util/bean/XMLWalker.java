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

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_TAG;
import static org.xmlpull.v1.XmlPullParser.TEXT;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xerial.core.XerialException;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.dom.DOMUtil;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * XMLWalker traverses XML data in the depth first manner.
 * @author leo
 *
 */
public class XMLWalker 
{
    /**
     * A walker implementation for XML stream
     * @author leo
     *
     */
    class XMLStreamWalker implements TreeWalker 
    {
        private final XmlPullParser pullParser;
        private final LinkedList<StringBuilder> textStack = new LinkedList<StringBuilder>(); 
        
        private boolean skipDescendants = false;
        private int skipLevel = Integer.MAX_VALUE;
        
        public XMLStreamWalker(Reader reader) throws XMLException
        {
            pullParser = PullParserUtil.newParser(reader);
        }
        
        public void parse() throws XerialException, IOException 
        {
            int state;
            try
            {
                while((state = pullParser.next()) != END_DOCUMENT)
                {
                    //int handlerIndex = 0;
                    switch(state)
                    {
                    case START_TAG:
                    {
                        if(!skipDescendants)
                        {
                            textStack.addLast(new StringBuilder());
                            String tagName = pullParser.getName();
                            ArrayList<NodeAttribute> attributeList = new ArrayList<NodeAttribute>();
                            // read attributes
                            for(int i=0; i<pullParser.getAttributeCount(); i++)
                            {
                                String attributeName = pullParser.getAttributeName(i);
                                String attributeValue = pullParser.getAttributeValue(i);
                                attributeList.add(new XMLAttributeImpl(attributeName, attributeValue));
                            }
                            visitor.visitNode(tagName, attributeList, this);
                        }
                    }
                        break;
                    case END_TAG:
                    {
                        if(skipDescendants)
                        {
                            if(skipLevel == pullParser.getDepth())
                                skipDescendants = false;
                            else
                                break;
                        }
                        String text = textStack.getLast().toString();
                        visitor.leaveNode(pullParser.getName(), text.trim(), this);
                        textStack.removeLast();
                    }
                        break;
                    case TEXT:
                        if(!skipDescendants)
                            textStack.getLast().append(pullParser.getText());
                        break;
                    }
                }
            }
            catch (XmlPullParserException e)
            {
                throw new XMLException(e);
            }

        }


        public void skipDescendants()
        {
            skipDescendants = true;
            skipLevel = pullParser.getDepth();
        }
    }
    
    private static class XMLAttributeImpl implements NodeAttribute
    {
        private final String name;
        private final String value;
        
        public XMLAttributeImpl(String name, String value)
        {
            this.name = name;
            this.value = value;
        }

        public String getName()
        {
            return name;
        }

        public String getValue()
        {
            return value;
        }
        
    }
    
    /**
     * An walker implementation for XML DOM model 
     * @author leo
     *
     */
    class XMLDOMWalker implements TreeWalker
    {
        private boolean skipDesendants = false;
        
        public XMLDOMWalker()
        {}
        
        public void parse(Element element) throws XerialException
        {
            
            String tagName = element.getNodeName();
            ArrayList<NodeAttribute> attributeList = new ArrayList<NodeAttribute>();
            NamedNodeMap attributeMap = element.getAttributes();
            for(int i=0; i<attributeMap.getLength(); i++)
            {
                Node attributeNode =  attributeMap.item(i);
                String attributeName = attributeNode.getNodeName();
                String attributeValue = attributeNode.getNodeValue();
             
                attributeList.add(new XMLAttributeImpl(attributeName, attributeValue));
            }
            // invoke visitor
            visitor.visitNode(tagName, attributeList, this);

            // visit child nodes
            if(skipDesendants)
            {
                NodeList nodeList = element.getChildNodes();
                for(int i=0; i<nodeList.getLength(); i++)
                {
                    Node childNode = nodeList.item(i);
                    if(childNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        parse((Element) childNode);
                    }
                }
                skipDesendants = false;
            }
            
            // leave the current element
            String text = DOMUtil.getText(element);
            visitor.leaveNode(tagName, text.trim(), this);
        }

        public void skipDescendants()
        {
            this.skipDesendants = true;
        }
        
    }
    
 
    private TreeVisitor visitor;
    /**
     * Constructor
     * @throws XMLException
     */
    public XMLWalker(TreeVisitor visitor) throws XMLException
    {
        this.visitor = visitor;
    }
    
    /**
     * Parses and traverses the given XML data stream 
     * @param xmlDataReader
     * @throws XerialException 
     * @throws IOException 
     * @throws Exception
     * @throws IOException
     */
    public void parse(Reader xmlDataReader) throws XerialException, IOException 
    {
        if(xmlDataReader == null)
            throw new XMLException("XML reader is null");
        
        XMLStreamWalker streamWalker =  new XMLStreamWalker(xmlDataReader);
        visitor.init(streamWalker);
        streamWalker.parse();
        visitor.finish(streamWalker);
    }
    
    /**
     * Parse and traverses the given XML DOM element
     * @param xmlElement
     * @throws XerialException 
     * @throws Exception
     */
    public void parse(Element xmlElement) throws XerialException 
    {
        XMLDOMWalker domWalker = new XMLDOMWalker();
        visitor.init(domWalker);
        domWalker.parse(xmlElement);
        visitor.finish(domWalker);
    }



}
