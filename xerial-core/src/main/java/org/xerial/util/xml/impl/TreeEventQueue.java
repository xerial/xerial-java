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
// TreeEventQueue.java
// Since: Mar 31, 2009 11:56:37 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.impl;

import java.util.Collection;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;

/**
 * A queue for storing {@link TreeEvent}s
 * 
 * @author leo
 * 
 */
public class TreeEventQueue
{
    private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();
    private Deque<String> nodeNameStack = new ArrayDeque<String>();

    private static final String EMPTY_STRING = new String();

    public void push(TreeEvent e)
    {
        switch (e.event)
        {
        case VISIT:
            nodeNameStack.addLast(e.nodeName == null ? EMPTY_STRING : e.nodeName);
            break;
        case LEAVE:
            nodeNameStack.removeLast();
            break;
        }
        eventQueue.addLast(e);
    }

    public TreeEvent peekFirst()
    {
        return eventQueue.peekFirst();
    }

    public TreeEvent peekLast()
    {
        return eventQueue.peekLast();
    }

    public void push(Collection<TreeEvent> eventList)
    {
        for (TreeEvent each : eventList)
        {
            push(each);
        }
    }

    public void replaceLast(TreeEvent e)
    {
        if (e.event != eventQueue.peekLast().event)
            throw new XerialError(XerialErrorCode.INVALID_STATE, String
                    .format("replace Last must be applied for the same event type: %s, %s", e.event, eventQueue
                            .getLast().event));

        eventQueue.removeLast();
        eventQueue.addLast(e);
    }

    public String getContextNodeName()
    {
        if (nodeNameStack.isEmpty())
            return null;
        else
        {
            String str = nodeNameStack.getLast();
            if (str == EMPTY_STRING)
                return null;
            else
                return str;
        }
    }

    public TreeEvent pop()
    {
        return eventQueue.removeFirst();
    }

    public boolean isEmpty()
    {
        return eventQueue.isEmpty();
    }

}
