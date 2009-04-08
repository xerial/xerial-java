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
// SilkTreeEventQueue.java
// Since: Apr 8, 2009 3:40:33 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import org.xerial.silk.plugin.SilkFunctionPlugin;
import org.xerial.util.ArrayDeque;
import org.xerial.util.tree.TreeEvent;

public class SilkTreeEventQueue
{
    private ArrayDeque<Object> eventQueue = new ArrayDeque<Object>();

    public void push(TreeEvent e)
    {
        eventQueue.addLast(e);
    }

    public void push(SilkFunctionPlugin plugin)
    {
        eventQueue.addLast(plugin);
    }

    //    public TreeEvent peekFirst()
    //    {
    //        
    //        return eventQueue.peekFirst();
    //    }
    //
    //    public TreeEvent peekLast()
    //    {
    //        return eventQueue.peekLast();
    //    }
    //
    //    public void push(Collection<TreeEvent> eventList)
    //    {
    //        for (TreeEvent each : eventList)
    //        {
    //            push(each);
    //        }
    //    }
    //
    //    public TreeEvent pop()
    //    {
    //        return eventQueue.removeFirst();
    //    }
    //
    //    public boolean isEmpty()
    //    {
    //        return eventQueue.isEmpty();
    //    }
    //

}
