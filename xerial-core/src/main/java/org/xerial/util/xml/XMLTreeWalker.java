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
// XMLTreeWalker.java
// Since: 2009/03/30 20:08:14
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import java.io.Reader;

import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.tree.TreeEvent.EventType;
import org.xerial.util.tree.impl.TreeNodeImpl;

public class XMLTreeWalker implements TreeWalker
{
    private final XMLStreamWalker walker;
    private final Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

    private int currentLevel = 0;

    public XMLTreeWalker(Reader xmlReader)
    {
        walker = new XMLStreamWalker(xmlReader);
    }

    private static class TreeBuilder
    {
        public final TreeNodeImpl root;
        public Deque<TreeNodeImpl> nodeStack = new ArrayDeque<TreeNodeImpl>();

        public TreeBuilder(TreeEvent rootNode)
        {
            root = new TreeNodeImpl(rootNode.nodeName, rootNode.nodeValue);
            nodeStack.add(root);
        }

        public void startNode(TreeEvent e)
        {
            TreeNodeImpl newNode = new TreeNodeImpl(e.nodeName, e.nodeValue);
            TreeNodeImpl parent = nodeStack.getLast();
            parent.addNode(newNode);
            nodeStack.addLast(newNode);
        }

        public void endNode(TreeEvent e)
        {
            nodeStack.removeLast();
        }

        public void text(TreeEvent e)
        {
            TreeNodeImpl current = nodeStack.getLast();
            if (current.getNodeValue() == null)
                current.setNodeValue(e.nodeValue);
            else
                current.setNodeValue(current.getNodeValue() + e.nodeValue);
        }

    }

    public TreeNode getSubTree() throws XerialException
    {
        int base = currentLevel;
        int level = currentLevel;

        TreeBuilder builder = new TreeBuilder(eventQueue.peekFirst());

        TreeEvent e = null;
        while ((e = walker.next()).event != EventType.FINISH)
        {
            switch (e.event)
            {
            case VISIT:
                level++;
                builder.startNode(e);
                break;
            case LEAVE:
                builder.endNode(e);
                if (level == base)
                {
                    return builder.root;
                }
                level--;
                break;
            case TEXT:
                builder.text(e);
                break;
            }
        }

        return builder.root;
    }

    public void skipDescendants() throws XerialException
    {
        int base = currentLevel;
        int level = currentLevel;
        TreeEvent e = null;
        while ((e = walker.next()).event != EventType.FINISH)
        {
            switch (e.event)
            {
            case VISIT:
                level++;
                break;
            case LEAVE:
                if (level == base)
                {
                    eventQueue.addLast(e);
                    return;
                }
                level--;
                break;
            }
        }
    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        TreeEvent e = null;
        while ((e = walker.next()).event != EventType.FINISH)
        {
            processEvent(e, visitor);
        }

        while (!eventQueue.isEmpty())
            processEvent(eventQueue.removeFirst(), visitor);
    }

    private void processEvent(TreeEvent e, TreeVisitor visitor) throws XerialException
    {
        eventQueue.addLast(e);
        switch (e.event)
        {
        case VISIT:
            visitor.visitNode(e.nodeName, e.nodeValue, this);
            currentLevel++;
            break;
        case LEAVE:
            visitor.leaveNode(e.nodeName, this);
            currentLevel--;
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
        eventQueue.removeLast();
    }

}
