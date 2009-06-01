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
// JSONStreamReader.java
// Since: Mar 31, 2009 2:06:34 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.Reader;

import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeStreamReader;
import org.xerial.util.tree.TreeEvent.EventType;
import org.xerial.util.xml.impl.TreeEventQueue;

/**
 * JSON stream reader
 * 
 * @author leo
 * 
 */
public class JSONStreamReader implements TreeStreamReader
{
    private static Logger _logger = Logger.getLogger(JSONStreamReader.class);

    private final JSONPullParser jsonPullParser;
    private final TreeEventQueue eventQueue = new TreeEventQueue();
    private JSONEvent lastEvent = null;

    private ArrayDeque<TreeEvent> pendingEventQueue = new ArrayDeque<TreeEvent>();

    public JSONStreamReader(Reader jsonStream) throws IOException
    {
        jsonPullParser = new JSONPullParser(jsonStream);
    }

    public TreeEvent peekNext() throws XerialException
    {
        if (!eventQueue.isEmpty())
        {
            return eventQueue.peekFirst();
        }

        if (lastEvent == JSONEvent.EndJSON)
            return null;

        readNext();

        return peekNext();
    }

    public TreeEvent next() throws XerialException
    {
        if (!eventQueue.isEmpty())
        {
            TreeEvent e = eventQueue.pop();
            return e;
        }

        if (lastEvent == JSONEvent.EndJSON)
            return null;

        readNext();

        return next();

    }

    private void flushPendingEvent()
    {
        while (!pendingEventQueue.isEmpty())
            eventQueue.push(pendingEventQueue.removeFirst());

    }

    private void readNext() throws XerialException
    {
        if (lastEvent == JSONEvent.EndJSON)
            return;

        lastEvent = jsonPullParser.next();
        switch (lastEvent)
        {
        case StartObject:
        {
            flushPendingEvent();

            String key = jsonPullParser.getKeyName();
            pendingEventQueue.addLast(TreeEvent.newVisitEvent(key, null));
            break;
        }
        case EndObject:
        {
            flushPendingEvent();
            String key = jsonPullParser.getKeyName();
            eventQueue.push(TreeEvent.newLeaveEvent(key));
            break;
        }
        case String:
        case Integer:
        case Double:
        case Boolean:
        case Null:
        {
            String key = jsonPullParser.getKeyName();
            String value = lastEvent != JSONEvent.Null ? jsonPullParser.getText() : null;

            // if first child element is value attribute
            if (key != null)
            {
                if (key.equals("value") && !pendingEventQueue.isEmpty())
                {
                    TreeEvent e = pendingEventQueue.peekLast();
                    if (e.event == EventType.VISIT)
                    {
                        pendingEventQueue.removeLast();
                        pendingEventQueue.addLast(TreeEvent.newVisitEvent(e.nodeName, value));
                        break;
                    }
                }
            }

            flushPendingEvent();
            eventQueue.push(TreeEvent.newVisitEvent(key, value));
            eventQueue.push(TreeEvent.newLeaveEvent(key));
            break;
        }
        case StartArray:
        case EndArray:
        case EndJSON:
            // do nothing
            break;
        }

    }

}
