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
// ProgressiveTreeWalker.java
// Since: 2009/02/25 8:10:16
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;

/**
 * 
 * 
 * @author leo
 * 
 */
public class ProgressiveTreeWalker
{
    private TreeWalker walker;
    private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

    private boolean needNextEvent = false;

    public ProgressiveTreeWalker(TreeWalker walker)
    {
        this.walker = walker;
    }

    public boolean hasNext()
    {
        return false;
    }

    public TreeEvent next()
    {

        return null;
    }

    private void retrieveNext()
    {

    }

    private class EventCollector implements TreeVisitor
    {

        public void reportEvent(TreeEvent e)
        {
            eventQueue.addLast(e);

        }

        public void finish(TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void init(TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {

        }

        public void text(String nodeName, String textDataFragment, TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
            TreeEvent e = new TreeEvent(TreeEvent.EventType.VISIT, nodeName, immediateNodeValue);
            eventQueue.addLast(e);

        }

    }

}
