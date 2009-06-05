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
// JSONPushParser.java
// Since: Jun 1, 2009 5:52:05 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.Reader;

import org.xerial.util.ArrayDeque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeParser;
import org.xerial.util.tree.TreeEvent.EventType;

/**
 * Push-style JSON parser
 * 
 * @author leo
 * 
 */
public class JSONPushParser implements TreeParser
{
    private final JSONPullParser jsonPullParser;
    private JSONEvent lastEvent = null;

    private ArrayDeque<TreeEvent> pendingEventQueue = new ArrayDeque<TreeEvent>();

    public JSONPushParser(String json)
    {
        jsonPullParser = new JSONPullParser(json);
    }

    public JSONPushParser(Reader input) throws IOException
    {
        jsonPullParser = new JSONPullParser(input);
    }

    public void parse(TreeEventHandler handler) throws Exception
    {
        handler.init();
        parseJSON(handler);
        handler.finish();
    }

    private void flushPendingEvent(TreeEventHandler handler) throws Exception
    {
        while (!pendingEventQueue.isEmpty())
        {
            TreeEvent e = pendingEventQueue.removeFirst();
            switch (e.event)
            {
            case VISIT:
                handler.visitNode(e.nodeName, e.nodeValue);
                break;
            case LEAVE:
                handler.leaveNode(e.nodeName);
                break;
            case TEXT:
                handler.text(e.nodeName, e.nodeValue);
                break;
            }
        }
    }

    private void parseJSON(TreeEventHandler handler) throws Exception
    {
        while (lastEvent != JSONEvent.EndJSON)
        {
            lastEvent = jsonPullParser.next();
            switch (lastEvent)
            {
            case StartObject:
            {
                flushPendingEvent(handler);

                String key = jsonPullParser.getKeyName();
                pendingEventQueue.addLast(TreeEvent.newVisitEvent(key, null));
                break;
            }
            case EndObject:
            {
                flushPendingEvent(handler);
                String key = jsonPullParser.getKeyName();
                handler.leaveNode(key);
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

                flushPendingEvent(handler);
                handler.visitNode(key, value);
                handler.leaveNode(key);
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
}
