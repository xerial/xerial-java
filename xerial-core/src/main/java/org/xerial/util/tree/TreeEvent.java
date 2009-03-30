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
// TreeEvent.java
// Since: Feb 13, 2009 7:15:04 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

/**
 * Representation of the {@link TreeVisitor} events
 * 
 * @author leo
 * 
 */
public class TreeEvent
{
    public static enum EventType {
        INIT, VISIT, TEXT, LEAVE, FINISH
    };

    public final EventType event;
    public final String nodeName;
    public final String nodeValue;

    private static final TreeEvent FINISH_EVENT = new TreeEvent(EventType.FINISH, null, null);
    private static final TreeEvent INIT_EVENT = new TreeEvent(EventType.FINISH, null, null);

    public static TreeEvent getFinishEvent()
    {
        return FINISH_EVENT;
    }

    public static TreeEvent getInitEvent()
    {
        return INIT_EVENT;
    }

    public static TreeEvent newVisitEvent(String nodeName, String value)
    {
        return new TreeEvent(EventType.VISIT, nodeName, value);
    }

    public static TreeEvent newLeaveEvent(String nodeName)
    {
        return new TreeEvent(EventType.LEAVE, nodeName, null);
    }

    public static TreeEvent newTextEvent(String value)
    {
        return new TreeEvent(EventType.TEXT, null, value);
    }

    public TreeEvent(EventType event, String nodeName, String value)
    {
        this.event = event;
        this.nodeName = nodeName;
        this.nodeValue = value;
    }

    public String toString()
    {
        if (nodeName != null)
        {
            if (nodeValue != null)
                return String.format("%s:%s=%s", event, nodeName, nodeValue);
            else
                return String.format("%s:%s", event, nodeName);
        }
        else
        {
            if (nodeValue != null)
                return String.format("%s:%s", event, nodeValue);
            else
                return String.format("%s", event);
        }
    }

}
