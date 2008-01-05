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
import org.xerial.util.bean.impl.XMLAttributeImpl;
import org.xerial.util.bean.impl.XMLTreeNode;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.dom.DOMUtil;
import org.xerial.util.xml.pullparser.DOMBuilder;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * XMLWalker traverses XML data in the depth first manner.
 * @author leo
 *
 */
public class XMLWalker extends TreeWalker
{
    /**
     * A walker implementation for XML stream
     * @author leo
     *
     */
    class XMLStreamWalker extends TreeWalker 
    {
        private final XmlPullParser pullParser;
        private final LinkedList<StringBuilder> textStack = new LinkedList<StringBuilder>(); 
        
        private boolean skipDescendants = false;
        private int skipLevel = Integer.MAX_VALUE;
        
        public XMLStreamWalker(TreeVisitor visitor, Reader reader) throws XMLException
        {
            super(visitor);

            if(reader == null)
                throw new XMLException("XML reader is null");

            pullParser = PullParserUtil.newParser(reader);
        }

        @Override
        public void walk() throws XerialException
        {
            try
            {
                parse();
            }
            catch (IOException e)
            {
                throw new BeanException(BeanErrorCode.IOError, e);
            }
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
                            ArrayList<TreeNodeAttribute> attributeList = new ArrayList<TreeNodeAttribute>();
                            // read attributes
                            for(int i=0; i<pullParser.getAttributeCount(); i++)
                            {
                                String attributeName = pullParser.getAttributeName(i);
                                String attributeValue = pullParser.getAttributeValue(i);
                                attributeList.add(new XMLAttributeImpl(attributeName, attributeValue));
                            }
                            getTreeVisitor().visitNode(tagName, attributeList, this);
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
                        getTreeVisitor().leaveNode(pullParser.getName(), text.trim(), this);
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

        public TreeNode getSubTree() throws BeanException
        {
            skipDescendants();
            DOMBuilder domBuilder = new DOMBuilder();
            try
            {
                Element element = domBuilder.parse(pullParser);
                return new XMLTreeNode(element);
            }
            catch (XMLException e)
            {
                throw new BeanException(BeanErrorCode.InvalidXMLData, e);
            }
            catch (IOException e)
            {
                throw new BeanException(BeanErrorCode.IOError, e);
            }
        }

    }
    
    
    /**
     * An walker implementation for XML DOM model 
     * @author leo
     *
     */
    class XMLDOMWalker extends TreeWalker
    {
        private boolean skipDesendants = false;
        private Element currentElement = null;
        
        public XMLDOMWalker(TreeVisitor visitor, Element element)
        {
            super(visitor);
            this.currentElement = element;
        }
        
        @Override
        public void walk() throws XerialException
        {
            parse(currentElement);
        }
        
        public void parse(Element element) throws XerialException
        {
            currentElement = element;
            
            String tagName = element.getNodeName();
            ArrayList<TreeNodeAttribute> attributeList = new ArrayList<TreeNodeAttribute>();
            NamedNodeMap attributeMap = element.getAttributes();
            for(int i=0; i<attributeMap.getLength(); i++)
            {
                Node attributeNode =  attributeMap.item(i);
                String attributeName = attributeNode.getNodeName();
                String attributeValue = attributeNode.getNodeValue();
             
                attributeList.add(new XMLAttributeImpl(attributeName, attributeValue));
            }
            // invoke visitor
            getTreeVisitor().visitNode(tagName, attributeList, this);

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
            getTreeVisitor().leaveNode(tagName, text.trim(), this);
        }

        public void skipDescendants()
        {
            this.skipDesendants = true;
        }

        public TreeNode getSubTree() throws BeanException
        {
            skipDescendants();
            return new XMLTreeNode(currentElement);
        }


    }
    
    
    private final TreeWalker impl;
    
    /**
     * Constructs an XML stream walker
     * @param visitor
     * @param xmlDataReader xml data stream 
     * @throws XMLException thrown when some error has found in the XML reader 
     */
    public XMLWalker(TreeVisitor visitor, Reader xmlDataReader) throws XMLException
    {
        super(visitor);
        impl = new XMLStreamWalker(visitor, xmlDataReader);
    }
    
    /**
     * Constructs an XML DOM walker
     * @param visitor
     * @param element
     */
    public XMLWalker(TreeVisitor visitor, Element element) 
    {
        super(visitor);
        impl = new XMLDOMWalker(visitor, element);
    }
    
    @Override
    public TreeNode getSubTree() throws BeanException
    {
        return impl.getSubTree();
    }

    @Override
    public void skipDescendants()
    {
        impl.skipDescendants();
    }

    @Override
    public void walk() throws XerialException
    {
        getTreeVisitor().init(impl);
        impl.walk();
        getTreeVisitor().finish(impl);
    }



}
