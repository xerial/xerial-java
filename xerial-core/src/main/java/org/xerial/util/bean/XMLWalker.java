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
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.bean.impl.XMLTreeNode;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.tree.TreeEvent.EventType;
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
        private final StringBuilder EMPTY_STRING = new StringBuilder(0);

        private boolean skipDescendants = false;
        private int skipLevel = Integer.MAX_VALUE;
        private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

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
                            textStack.addLast(EMPTY_STRING);
                            String tagName = pullParser.getName();
                            String immediateNodeValue = null;

                            Deque<TreeEvent> startEventQueue = new ArrayDeque<TreeEvent>(
                                    pullParser.getAttributeCount() + 1);
                            // read attributes
                            for (int i = 0; i < pullParser.getAttributeCount(); i++)
                            {
                                String attributeName = pullParser.getAttributeName(i);
                                String attributeValue = pullParser.getAttributeValue(i);

                                if (attributeName.equals("value"))
                                {
                                    immediateNodeValue = attributeValue;
                                    continue;
                                }

                                startEventQueue.addLast(TreeEvent.newVisitEvent(attributeName, attributeValue));
                                if (skipDescendants)
                                {
                                    // attributes has no more descendants
                                    skipDescendants = false;
                                }
                                startEventQueue.addLast(TreeEvent.newLeaveEvent(attributeName));
                            }

                            // push a new start tag event to the front of the queue
                            startEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, immediateNodeValue));

                            eventQueue.addAll(startEventQueue);
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

                        if (textStack.getLast() == EMPTY_STRING)
                        {
                            eventQueue.add(TreeEvent.newLeaveEvent(pullParser.getName()));
                        }
                        else
                        {
                            String text = textStack.getLast().toString().trim();
                            if (!eventQueue.isEmpty() && eventQueue.getLast().event == EventType.VISIT)
                            {
                                eventQueue.removeLast();
                                eventQueue.add(TreeEvent.newVisitEvent(pullParser.getName(), text));
                            }
                            else
                                eventQueue.add(TreeEvent.newTextEvent(text));
                            eventQueue.add(TreeEvent.newLeaveEvent(pullParser.getName()));
                        }
                        textStack.removeLast();
                        flushEventQueue(visitor);
                    }
                        break;
                    case TEXT:
                        if (!skipDescendants)
                        {
                            StringBuilder textBuffer = textStack.getLast();
                            if (textBuffer == EMPTY_STRING)
                            {
                                textStack.removeLast();
                                textBuffer = new StringBuilder();
                                textStack.addLast(textBuffer);
                            }
                            textBuffer.append(pullParser.getText());
                        }

                        break;
                    }
                }
            }
            catch (XmlPullParserException e)
            {
                throw new XMLException(XMLErrorCode.PARSE_ERROR, e);
            }

            flushEventQueue(visitor);

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

        private void flushEventQueue(TreeVisitor visitor) throws XerialException
        {
            while (!eventQueue.isEmpty())
            {
                TreeEvent e = eventQueue.removeFirst();
                switch (e.event)
                {
                case VISIT:
                    visitor.visitNode(e.nodeName, e.nodeValue, this);
                    break;
                case LEAVE:
                    visitor.leaveNode(e.nodeName, this);
                    break;
                case TEXT:
                    visitor.text(e.nodeValue, this);
                    break;
                case FINISH:
                    visitor.finish(this);
                    break;
                case INIT:
                    visitor.init(this);
                    break;
                }
            }

        }

    }

    /**
     * An walker implementation for XML DOM model
     * 
     * TODO extend this to handle value attribute as an immediate node value
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
