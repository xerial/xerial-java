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
import java.util.LinkedList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xerial.core.XerialException;
import org.xerial.util.bean.impl.XMLTreeNode;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.xml.XMLErrorCode;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.dom.DOMUtil;
import org.xerial.util.xml.pullparser.DOMBuilder;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * XMLWalker traverses XML data in the depth first manner.
 * 
 * @author leo
 * 
 */
public class XMLWalker implements TreeWalker
{
    /**
     * A walker implementation for XML stream
     * 
     * @author leo
     * 
     */
    class XMLStreamWalker implements TreeWalker
    {
        private final XmlPullParser pullParser;
        private final LinkedList<StringBuilder> textStack = new LinkedList<StringBuilder>();

        private boolean skipDescendants = false;
        private int skipLevel = Integer.MAX_VALUE;

        public XMLStreamWalker(Reader reader)
        {
            if (reader == null)
                throw new IllegalArgumentException("XML reader is null");

            pullParser = PullParserUtil.newParser(reader);
        }

        public void walk(TreeVisitor visitor) throws XerialException
        {
            try
            {
                parse(visitor);
            }
            catch (IOException e)
            {
                throw new BeanException(BeanErrorCode.IOError, e);
            }
        }

        public void parse(TreeVisitor visitor) throws XerialException, IOException
        {
            int state;
            try
            {
                while ((state = pullParser.next()) != END_DOCUMENT)
                {
                    // int handlerIndex = 0;
                    switch (state)
                    {
                    case START_TAG:
                    {
                        if (!skipDescendants)
                        {
                            textStack.addLast(new StringBuilder());
                            String tagName = pullParser.getName();
                            visitor.visitNode(tagName, null, this);
                            // read attributes
                            for (int i = 0; i < pullParser.getAttributeCount(); i++)
                            {
                                String attributeName = pullParser.getAttributeName(i);
                                String attributeValue = pullParser.getAttributeValue(i);
                                visitor.visitNode(attributeName, attributeValue, this);
                                if (skipDescendants)
                                {
                                    // attributes has no more descendants
                                    skipDescendants = false;
                                }
                                visitor.leaveNode(attributeName, this);
                            }

                        }
                    }
                        break;
                    case END_TAG:
                    {
                        if (skipDescendants)
                        {
                            if (skipLevel == pullParser.getDepth())
                                skipDescendants = false;
                            else
                                break;
                        }
                        String text = textStack.getLast().toString();
                        visitor.text(text.trim());
                        visitor.leaveNode(pullParser.getName(), this);
                        textStack.removeLast();
                    }
                        break;
                    case TEXT:
                        if (!skipDescendants)
                            textStack.getLast().append(pullParser.getText());
                        break;
                    }
                }
            }
            catch (XmlPullParserException e)
            {
                throw new XMLException(XMLErrorCode.PARSE_ERROR, e);
            }

        }

        public void skipDescendants()
        {
            skipDescendants = true;
            skipLevel = pullParser.getDepth();
        }

        public TreeNode getSubTree() throws XerialException
        {
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
     * 
     * @author leo
     * 
     */
    class XMLDOMWalker implements TreeWalker
    {
        private boolean skipDesendants = false;
        private Element currentElement = null;

        public XMLDOMWalker(Element element)
        {
            this.currentElement = element;
        }

        public void walk(TreeVisitor visitor) throws XerialException
        {
            parse(currentElement, visitor);
        }

        public void parse(Element element, TreeVisitor visitor) throws XerialException
        {
            currentElement = element;
            String tagName = element.getNodeName();
            // invoke visitor
            String text = DOMUtil.getText(element);
            visitor.visitNode(tagName, text.trim(), this);

            // visit attribute nodes
            NamedNodeMap attributeMap = element.getAttributes();
            for (int i = 0; i < attributeMap.getLength(); i++)
            {
                Node attributeNode = attributeMap.item(i);
                String attributeName = attributeNode.getNodeName();
                String attributeValue = attributeNode.getNodeValue();

                visitor.visitNode(attributeName, attributeValue, this);
                visitor.leaveNode(attributeName, this);
            }

            // visit child nodes
            if (skipDesendants)
            {
                NodeList nodeList = element.getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++)
                {
                    Node childNode = nodeList.item(i);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        parse((Element) childNode, visitor);
                    }
                }
                skipDesendants = false;
            }

            // leave the current element
            visitor.leaveNode(tagName, this);
        }

        public void skipDescendants()
        {
            this.skipDesendants = true;
        }

        public TreeNode getSubTree() throws XerialException
        {
            skipDescendants();
            return new XMLTreeNode(currentElement);
        }

    }

    private final TreeWalker impl;

    /**
     * Constructs an XML stream walker
     * 
     * @param visitor
     * @param xmlDataReader
     *            xml data stream
     */
    public XMLWalker(Reader xmlDataReader)
    {
        impl = new XMLStreamWalker(xmlDataReader);
    }

    /**
     * Constructs an XML DOM walker
     * 
     * @param visitor
     * @param element
     */
    public XMLWalker(Element element)
    {
        impl = new XMLDOMWalker(element);
    }

    public TreeNode getSubTree() throws XerialException
    {
        return impl.getSubTree();
    }

    public void skipDescendants()
    {
        impl.skipDescendants();
    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(impl);
        impl.walk(visitor);
        visitor.finish(impl);
    }

}
