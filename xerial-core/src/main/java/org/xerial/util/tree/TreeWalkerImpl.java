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
// TreeWalkerBase.java
// Since: Mar 31, 2009 5:22:58 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.impl.TreeNodeImpl;

/**
 * An {@link TreeWalker} implementation based on {@link TreeStreamReader}
 * 
 * @author leo
 * 
 */
public class TreeWalkerImpl implements TreeWalker
{
    private static Logger _logger = Logger.getLogger(TreeWalkerImpl.class);

    private final TreeStreamReader walker;
    private final Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();
    private TreeEvent last;
    private int currentLevel = 0;

    public TreeWalkerImpl(TreeStreamReader streamReader)
    {
        this.walker = streamReader;
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
        if (_logger.isTraceEnabled())
            _logger.trace("get subtree");

        int base = currentLevel;

        TreeBuilder builder = new TreeBuilder(last);

        TreeEvent e = null;
        while ((e = walker.peekNext()) != null)
        {
            switch (e.event)
            {
            case VISIT:
                currentLevel++;
                builder.startNode(e);
                break;
            case LEAVE:
                currentLevel--;
                if (currentLevel < base)
                    return builder.root;
                else
                    builder.endNode(e);
                break;
            case TEXT:
                builder.text(e);
                break;
            }

            walker.next();
        }

        return builder.root;
    }

    public void skipDescendants() throws XerialException
    {
        if (_logger.isTraceEnabled())
            _logger.trace("skip descendants");

        int base = currentLevel;
        TreeEvent e = null;
        while ((e = walker.next()) != null)
        {
            switch (e.event)
            {
            case VISIT:
                currentLevel++;
                break;
            case LEAVE:
                if (currentLevel == base)
                {
                    eventQueue.addLast(e);
                    return;
                }
                currentLevel--;
                break;
            }
        }
    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(this);

        while (hasNext())
        {
            processEvent(eventQueue.removeFirst(), visitor);
        }

        visitor.finish(this);
    }

    private boolean hasNext() throws XerialException
    {
        if (eventQueue.isEmpty())
        {
            TreeEvent e = walker.next();
            if (e == null)
                return false;

            eventQueue.addLast(e);
            return true;
        }
        else
            return true;
    }

    private void processEvent(TreeEvent e, TreeVisitor visitor) throws XerialException
    {
        if (_logger.isTraceEnabled())
            _logger.trace(e);

        last = e;

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
        }
    }

}
