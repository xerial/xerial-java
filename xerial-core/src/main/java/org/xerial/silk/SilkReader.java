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
// SilkReader.java
// Since: Feb 2, 2009 10:10:48 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.Writer;
import java.net.URL;

import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONValue;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * Silk format reader
 * 
 * @author leo
 * 
 */
public class SilkReader
{
    private final URL url;

    public SilkReader(URL url)
    {
        this.url = url;
    }

    /**
     * Convert Silk format into JSON data
     * 
     * @param out
     * @throws IOException
     * @throws XerialException
     */
    public Writer toJSON(Writer out) throws IOException, XerialException
    {
        SilkWalker walker = new SilkWalker(url);
        JSONBuilder jsonBuilder = new JSONBuilder();
        walker.walk(jsonBuilder);
        JSONArray root = jsonBuilder.getRoot();
        out.append(root.toJSONString());
        return out;
    }

    private class JSONBuilder implements TreeVisitor
    {
        JSONArray root = new JSONArray();
        Deque<JSONObject> contextStack = new ArrayDeque<JSONObject>();
        Deque<StringBuilder> textStack = new ArrayDeque<StringBuilder>();
        final StringBuilder ZERO_CAPACITY_BUFFER = new StringBuilder(0);

        public JSONBuilder()
        {

        }

        public JSONArray getRoot()
        {
            return root;
        }

        private JSONObject getContext()
        {
            return contextStack.peekLast();
        }

        private StringBuilder getTextBuilder()
        {
            if (textStack.peekLast() == ZERO_CAPACITY_BUFFER)
            {
                textStack.removeLast();
                textStack.addLast(new StringBuilder());
            }
            return textStack.peekLast();
        }

        public void finish(TreeWalker walker) throws XerialException
        {}

        public void init(TreeWalker walker) throws XerialException
        {}

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {
            JSONObject node = getContext();
            contextStack.removeLast();

            if (node.keys().size() == 0)
            {
                // flatten object into single key:value pair
                JSONObject parent = getContext();
                if (textStack.peekLast() != ZERO_CAPACITY_BUFFER)
                    parent.put(nodeName, textStack.peekLast().toString());

                if (contextStack.size() == 1)
                {
                    contextStack.removeLast(); // remove additional object
                    textStack.removeLast();
                    return;
                }
            }
            else
            {
                if (contextStack.size() == 1)
                {
                    contextStack.removeLast(); // remove additional object
                    textStack.removeLast();
                    return;
                }

                JSONObject parent = getContext();
                if (!parent.hasKey(nodeName))
                    parent.put(nodeName, node);
                else
                {
                    // use array to handle multiple occurrences of the same name node
                    JSONValue elderBrother = parent.get(nodeName);
                    JSONArray array = elderBrother.getJSONArray();
                    if (array != null)
                    {
                        array.add(node);
                    }
                    else
                    {
                        parent.remove(nodeName);
                        array = new JSONArray();
                        array.add(elderBrother);
                        array.add(node);

                        parent.put(nodeName, array);
                    }
                }
            }

            textStack.removeLast();
        }

        public void text(String textDataFragment) throws XerialException
        {
            getTextBuilder().append(textDataFragment);
        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
            JSONObject newContext = new JSONObject();

            if (contextStack.isEmpty())
            {
                JSONObject childOfRoot = new JSONObject();
                childOfRoot.put(nodeName, newContext);
                root.add(childOfRoot);
                contextStack.addLast(childOfRoot); // additional object
            }

            contextStack.addLast(newContext);
            textStack.addLast(ZERO_CAPACITY_BUFFER);
            if (immediateNodeValue != null)
                getTextBuilder().append(immediateNodeValue);
        }

    }

}
