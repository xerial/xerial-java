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
// XMLDOMStreamWalker.java
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
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeStreamWalker;
import org.xerial.util.xml.dom.DOMUtil;

public class XMLDOMStreamWalker implements TreeStreamWalker
{
    private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();
    private Deque<Context> contextStack = new ArrayDeque<Context>();

    private static class Context
    {
        Element element;
        int childCursor = -1;

        private Context(Element element)
        {
            this.element = element;
        }

        public boolean hasProcessed()
        {
            return childCursor != -1;
        }

        public Context nextContext()
        {
            childCursor++;
            NodeList nodeList = element.getChildNodes();
            if (childCursor >= nodeList.getLength())
                return null;
            else
            {
                Node childNode = nodeList.item(childCursor);
                if (childNode.getNodeType() == Node.ELEMENT_NODE)
                    return new Context((Element) childNode);
                else
                    return nextContext();
            }

        }

    }

    public XMLDOMStreamWalker(Element element)
    {
        contextStack.addLast(new Context(element));
    }

    public TreeEvent next() throws XerialException
    {
        if (!eventQueue.isEmpty())
            return eventQueue.removeFirst();

        if (!contextStack.isEmpty())
        {
            Context context = contextStack.getLast();

        }

        return next();
    }

    public void parse(Context context)
    {
        if(context.hasProcessed())
        {
            Context nextContext = context.nextContext();
            if(nextContext == null)
                
                
        }
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
            text = text.trim();

        if (nodeValue != null)
        {
            subEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, nodeValue));
            if (text != null)
                subEventQueue.addLast(TreeEvent.newTextEvent(text));
        }
        else
        {
            subEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, text));
        }

        eventQueue.addAll(subEventQueue);

        // visit child nodes
        NodeList nodeList = currentElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE)
            {
                nextElementToProcess.addLast((Element) childNode);
            }
        }

    }
}
