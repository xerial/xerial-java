/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// JSONStreamWalker.java
// Since: Dec 19, 2007 8:08:32 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONEvent;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONPullParser;
import org.xerial.json.JSONValue;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.tree.TreeEvent.EventType;

/**
 * A walker that traverses JSON streams
 * 
 * @author leo
 * 
 */
public class JSONStreamWalker implements TreeWalker
{
    private final JSONPullParser jsonPullParser;
    private boolean skipDescendants = false;
    private int skipLevel = Integer.MAX_VALUE;
    private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

    public JSONStreamWalker(Reader jsonStream) throws IOException
    {
        jsonPullParser = new JSONPullParser(jsonStream);
    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(this);
        walk_internal(visitor);
        visitor.finish(this);
    }

    public void walk_internal(TreeVisitor visitor) throws XerialException
    {
        JSONEvent event;
        while ((event = jsonPullParser.next()) != JSONEvent.EndJSON)
        {

            switch (event)
            {
            case StartObject:
            {
                if (!skipDescendants)
                {
                    outputAllEventsInQueue(visitor);
                    String key = jsonPullParser.getKeyName();
                    eventQueue.addLast(new TreeEvent(EventType.VISIT, key, null));
                    //visitor.visitNode(key, null, this);
                }
                break;
            }
            case EndObject:
            {
                if (skipDescendants)
                {
                    if (skipLevel == jsonPullParser.getDepth())
                        skipDescendants = false;
                    else
                        break;
                }
                outputAllEventsInQueue(visitor);
                String key = jsonPullParser.getKeyName();
                eventQueue.addLast(new TreeEvent(EventType.LEAVE, key, null));
                //visitor.leaveNode(key, this);
                break;
            }
            case String:
            case Integer:
            case Double:
            case Boolean:
            {
                if (skipDescendants)
                    break;

                String key = jsonPullParser.getKeyName();
                String value = jsonPullParser.getText();

                if (key.equals("value") && !eventQueue.isEmpty())
                {
                    TreeEvent e = eventQueue.peekLast();
                    if (e.event == EventType.VISIT)
                    {
                        eventQueue.removeLast();
                        eventQueue.addLast(new TreeEvent(EventType.VISIT, e.nodeName, value));
                        break;
                    }
                }

                outputAllEventsInQueue(visitor);

                visitor.visitNode(key, value, this);
                if (skipDescendants)
                    skipDescendants = false;
                visitor.leaveNode(key, this);

                break;
            }
            case Null:
            {
                if (skipDescendants)
                    break;

                outputAllEventsInQueue(visitor);

                String key = jsonPullParser.getKeyName();
                visitor.visitNode(key, null, this);
                if (skipDescendants)
                    skipDescendants = false;
                visitor.leaveNode(key, this);
                break;
            }
            case StartArray:
                // do nothing
                break;
            case EndArray:
                // do nothing
                break;
            }
        }

        outputAllEventsInQueue(visitor);

    }

    private void outputAllEventsInQueue(TreeVisitor visitor) throws XerialException
    {
        while (!eventQueue.isEmpty())
        {
            TreeEvent e = eventQueue.removeFirst();
            switch (e.event)
            {
            case VISIT:
                visitor.visitNode(e.nodeName, e.nodeValue, this);
                break;
            case LEAVE:
                visitor.leaveNode(e.nodeName, this);
                break;
            }
        }
    }

    public void skipDescendants() throws XerialException
    {
        skipDescendants = true;
    }

    public TreeNode getSubTree() throws XerialException
    {
        skipDescendants();
        try
        {
            return new JSONTreeNodeImpl(jsonPullParser.getKeyName(), jsonPullParser.getValue());
        }
        catch (JSONException e)
        {
            throw new BeanException(BeanErrorCode.InvalidJSONData, e);
        }
    }

    private class JSONTreeNodeImpl implements TreeNode
    {
        String key;
        JSONValue value;
        String objectValue = null;

        public JSONTreeNodeImpl(String key, JSONValue value)
        {
            this.key = key;
            this.value = value;
        }

        public List<TreeNode> getChildren()
        {
            ArrayList<TreeNode> childList = new ArrayList<TreeNode>();
            switch (value.getValueType())
            {
            case Object:
                JSONObject obj = value.getJSONObject();
                for (String entryKey : obj.keys())
                {
                    if (entryKey.equals("value"))
                    {
                        this.objectValue = obj.get(entryKey).toString();
                    }
                    else
                        childList.add(new JSONTreeNodeImpl(entryKey, obj.get(entryKey)));
                }
                break;
            case Array:
                JSONArray array = value.getJSONArray();
                for (JSONValue v : array)
                    childList.add(new JSONTreeNodeImpl(key, v));
                break;
            }

            return childList;
        }

        public String getNodeName()
        {
            return key;
        }

        public String getNodeValue()
        {
            switch (value.getValueType())
            {
            case Object:
                return objectValue;
            case Array:
            case Null:
                return null;
            default:
                return value.toString();
            }
        }

    }
}
