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
// DOMWalker.java
// Since: 2009/03/30 23:39:34
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeStreamReader;
import org.xerial.util.xml.dom.DOMUtil;
import org.xerial.util.xml.impl.TreeEventQueue;

/**
 * Stream walker for DOM data
 * 
 * @author leo
 * 
 */
public class DOMStreamReader implements TreeStreamReader
{
    private TreeEventQueue eventQueue = new TreeEventQueue();
    private Deque<Context> contextStack = new ArrayDeque<Context>();

    private static class Context
    {
        Element element;
        private int childCursor = -1;
        private boolean hasVisited = false;
        private boolean hasFinished = false;

        private Context(Element element)
        {
            this.element = element;
        }

        public boolean hasVisited()
        {
            return hasVisited;
        }

        public boolean hasFinished()
        {
            return hasFinished;
        }

        public void setFinished()
        {
            hasFinished = true;
        }

        public void setVisited()
        {
            hasVisited = true;
        }

        public boolean hasNextChild()
        {
            return childCursor + 1 < element.getChildNodes().getLength();
        }

        public Node nextChild()
        {
            childCursor++;
            NodeList nodeList = element.getChildNodes();
            if (childCursor >= nodeList.getLength())
                throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                        "childCursor=%d, nodeList.length=%d", childCursor, nodeList.getLength()));
            else
            {
                Node childNode = nodeList.item(childCursor);
                return childNode;
            }

        }
    }

    public DOMStreamReader(Element element)
    {
        contextStack.addLast(new Context(element));
    }

    public TreeEvent next() throws XerialException
    {
        if (!eventQueue.isEmpty())
            return eventQueue.pop();

        if (contextStack.isEmpty())
            return null;

        if (!contextStack.isEmpty())
        {
            Context context = contextStack.getLast();
            if (context.hasFinished())
            {
                contextStack.removeLast();
                return next();
            }
            parse(context);
        }

        return next();
    }

    public void parse(Context context)
    {
        if (!context.hasVisited())
        {
            context.setVisited();

            Element currentElement = context.element;
            String tagName = currentElement.getNodeName();
            // invoke visitor
            String text = DOMUtil.getText(currentElement);

            Deque<TreeEvent> subEventQueue = new ArrayDeque<TreeEvent>();

            String nodeValue = null;
            // visit attribute nodes
            NamedNodeMap attributeMap = currentElement.getAttributes();
            for (int i = 0; i < attributeMap.getLength(); i++)
            {
                Node attributeNode = attributeMap.item(i);
                String attributeName = attributeNode.getNodeName();
                String attributeValue = attributeNode.getNodeValue();

                if (attributeName.equals("value"))
                {
                    nodeValue = attributeValue;
                    continue;
                }

                subEventQueue.addLast(TreeEvent.newVisitEvent(attributeName, attributeValue));
                subEventQueue.addLast(TreeEvent.newLeaveEvent(attributeName));
            }

            if (text != null)
            {
                text = text.trim();
                if (text.length() <= 0)
                    text = null;
            }

            if (nodeValue != null)
            {
                subEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, nodeValue));
                if (text != null)
                    subEventQueue.addLast(TreeEvent.newTextEvent(tagName, text));
            }
            else
            {
                subEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, text));
            }

            eventQueue.push(subEventQueue);
        }

        for (;;)
        {
            if (context.hasNextChild())
            {
                Node childNode = context.nextChild();
                if (childNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    contextStack.addLast(new Context((Element) childNode));
                    break;
                }
                else
                    continue;
            }
            else
            {
                context.setFinished();
                eventQueue.push(TreeEvent.newLeaveEvent(context.element.getNodeName()));
                break;
            }
        }

    }
}
