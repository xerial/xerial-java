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

    public JSONStreamReader(Reader jsonStream) throws IOException
    {
        jsonPullParser = new JSONPullParser(jsonStream);
    }

    public TreeEvent next() throws XerialException
    {
        if (!eventQueue.isEmpty())
        {
            TreeEvent e = eventQueue.pop();
            //            if (_logger.isTraceEnabled())
            //                _logger.trace(e);
            return e;
        }

        if (lastEvent == JSONEvent.EndJSON)
            return null;

        readNext();

        return next();
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
            String key = jsonPullParser.getKeyName();
            eventQueue.push(TreeEvent.newVisitEvent(key, null));
            break;
        }
        case EndObject:
        {
            String key = jsonPullParser.getKeyName();
            eventQueue.push(TreeEvent.newLeaveEvent(key));
            break;
        }
        case String:
        case Integer:
        case Double:
        case Boolean:
        {
            String key = jsonPullParser.getKeyName();
            String value = jsonPullParser.getText();

            // if first child element is value attribute
            if (key.equals("value") && !eventQueue.isEmpty())
            {
                TreeEvent e = eventQueue.peekLast();
                if (e.event == EventType.VISIT)
                {
                    eventQueue.replaceLast(TreeEvent.newVisitEvent(e.nodeName, value));
                    break;
                }
            }

            eventQueue.push(TreeEvent.newVisitEvent(key, value));
            eventQueue.push(TreeEvent.newLeaveEvent(key));
            break;
        }
        case Null:
        {
            String key = jsonPullParser.getKeyName();
            eventQueue.push(TreeEvent.newVisitEvent(key, null));
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
