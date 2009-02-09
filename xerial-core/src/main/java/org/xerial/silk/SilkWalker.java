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
// SilkWalker.java
// Since: Feb 2, 2009 11:29:02 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONValue;
import org.xerial.json.JSONValueType;
import org.xerial.silk.impl.SilkDataLine;
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkFunctionArg;
import org.xerial.silk.impl.SilkJSONValue;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkNodeOccurrence;
import org.xerial.silk.impl.SilkValue;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * {@link TreeWalker} implementation of the Silk format.
 * 
 * @author leo
 * 
 */
public class SilkWalker implements TreeWalker
{
    private static Logger _logger = Logger.getLogger(SilkWalker.class);

    private final SilkPullParser parser;
    private final Deque<SilkNode> contextNodeStack = new ArrayDeque<SilkNode>();

    /**
     * Creates a new SilkWalker with the specified input stream
     * 
     * @param input
     * @throws IOException
     */
    public SilkWalker(InputStream input) throws IOException
    {
        this.parser = new SilkPullParser(input);
        init();
    }

    /**
     * Creates a new SilkWalker with the specified reader
     * 
     * @param input
     * @throws IOException
     */
    public SilkWalker(Reader input) throws IOException
    {
        this.parser = new SilkPullParser(input);
        init();
    }

    public void init()
    {

    }

    public TreeNode getSubTree() throws XerialException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void skipDescendants()
    {
    // TODO Auto-generated method stub

    }

    private void closeUpTo(int newIndentLevel, TreeVisitor visitor) throws XerialException
    {
        //        if (newIndentLevel == SilkNode.NO_INDENT)
        //            newIndentLevel = contextNodeStack.isEmpty() ? 0 : contextNodeStack.peekLast().getIndentLevel() + 1;

        while (!contextNodeStack.isEmpty())
        {
            SilkNode node = contextNodeStack.peekLast();
            if (node.getIndentLevel() >= newIndentLevel)
            {
                contextNodeStack.removeLast();
                //outputDataCountStack.removeLast();

                if (node.getOccurrence() != SilkNodeOccurrence.TABBED_SEQUENCE)
                    closeContext(node, visitor);
            }
            else
                return;
        }
    }

    private void closeContext(SilkNode node, TreeVisitor visitor) throws XerialException
    {
        String nodeName = node.getName();
        SilkValue textValue = node.getValue();
        if (textValue != null && !textValue.isJSON())
            visitor.leaveNode(nodeName, textValue.toString(), this);
        else
            visitor.leaveNode(nodeName, null, null);
    }

    private void openContext(SilkNode node, TreeVisitor visitor) throws XerialException
    {
        int indentLevel = node.getIndentLevel();

        closeUpTo(indentLevel, visitor);

        contextNodeStack.addLast(node);
        //outputDataCountStack.addLast(0);

        if (node.getOccurrence() == SilkNodeOccurrence.TABBED_SEQUENCE)
            return; // do not invoke visit events 

        String nodeName = node.getName();
        visitor.visitNode(nodeName, this);

        SilkValue textValue = node.getValue();
        if (textValue != null && textValue.isJSON())
        {
            SilkJSONValue jsonValue = SilkJSONValue.class.cast(textValue);
            if (jsonValue.isObject())
            {
                JSONObject jsonObj = new JSONObject(jsonValue.getValue());
                walkJSONObject(jsonObj, visitor);
            }
            else
            {
                JSONArray jsonArray = new JSONArray(jsonValue.getValue());
                walkJSONAray(jsonArray, nodeName, visitor);
            }

        }

        // traverse attribute nodes with text values
        for (SilkNode eachChild : node.getChildNodes())
        {
            if (eachChild.hasValue())
            {
                openContext(eachChild, visitor);
            }
        }

    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        // initialize
        visitor.init(this);

        walkInternal(visitor);

        visitor.finish(this);
    }

    private void walkInternal(TreeVisitor visitor) throws XerialException
    {
        // depth first search 
        while (parser.hasNext())
        {
            SilkEvent currentEvent = parser.next();

            //_logger.info("stack: " + contextNodeStack);

            switch (currentEvent.getType())
            {
            case NODE:
                // push context node
                SilkNode newContextNode = SilkNode.class.cast(currentEvent.getElement());
                openContext(newContextNode, visitor);
                break;
            case FUNCTION:
                SilkFunction function = SilkFunction.class.cast(currentEvent.getElement());
                if (function.getName().equals("import"))
                {
                    // import function
                    String fileName = null;
                    for (SilkFunctionArg each : function.getArgumentList())
                    {
                        if (!each.hasName())
                            fileName = each.getValue().toString();
                    }
                    if (fileName == null)
                    {
                        _logger.warn("no input file is specified");
                        break;
                    }

                    try
                    {
                        URL url = new URL(fileName);
                        SilkWalker subWalker = new SilkWalker(url.openStream());
                        subWalker.walkInternal(visitor);
                    }
                    catch (MalformedURLException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                break;
            case DATA_LINE:
                if (contextNodeStack.isEmpty())
                {
                    // row(c1, c2, ...) 
                    SilkDataLine line = SilkDataLine.class.cast(currentEvent.getElement());
                    String[] columns = line.getDataLine().trim().split("\t");
                    int index = 1;
                    visitor.visitNode("row", this);
                    for (String each : columns)
                    {
                        String columnName = String.format("c%d", index++);
                        visitor.visitNode(columnName, this);
                        visitor.leaveNode(columnName, each, this);
                    }
                    visitor.leaveNode("row", null, this);
                }
                else
                {
                    SilkNode schema = contextNodeStack.peekLast();
                    SilkDataLine line = SilkDataLine.class.cast(currentEvent.getElement());

                    switch (schema.getOccurrence())
                    {
                    case SEQUENCE:
                        visitor.text(line.getDataLine().trim());
                        break;
                    case TABBED_SEQUENCE:
                    {
                        String[] columns = line.getDataLine().trim().split("\t");
                        int columnIndex = 0;
                        visitor.visitNode(schema.getName(), this);
                        for (int i = 0; i < schema.getChildNodes().size(); i++)
                        {
                            SilkNode child = schema.getChildNodes().get(i);
                            if (child.hasValue())
                            {
                                visitor.visitNode(child.getName(), this);
                                visitor.leaveNode(child.getName(), child.getValue().toString(), this);
                            }
                            else
                            {
                                visitor.visitNode(child.getName(), this);
                                visitor.leaveNode(child.getName(), columns[columnIndex++], this);
                            }
                        }

                        visitor.leaveNode(schema.getName(), schema.hasValue() ? schema.getValue().toString() : null,
                                this);
                        break;
                    }
                    }
                }
                break;
            case BLANK_LINE:
                break;

            }

        }

        closeUpTo(0, visitor);

    }

    private void walkJSONAray(JSONArray jsonArray, String parentNodeName, TreeVisitor visitor) throws XerialException
    {
        for (JSONValue each : jsonArray)
        {
            walkJSONValue(each, parentNodeName, visitor);
        }
    }

    private void walkJSONObject(JSONObject jsonObj, TreeVisitor visitor) throws XerialException
    {
        for (String key : jsonObj.keys())
        {
            JSONValue val = jsonObj.get(key);
            walkJSONValue(val, key, visitor);
        }
    }

    private void walkJSONValue(JSONValue value, String parentNodeName, TreeVisitor visitor) throws XerialException
    {
        JSONValueType type = value.getValueType();
        switch (type)
        {
        case Array:
            walkJSONAray(value.getJSONArray(), parentNodeName, visitor);
            break;
        case Object:
            walkJSONObject(value.getJSONObject(), visitor);
            break;
        case Boolean:
            visitor.visitNode(parentNodeName, this);
            visitor.leaveNode(parentNodeName, value.toString(), this);
            break;
        case Double:
            visitor.visitNode(parentNodeName, this);
            visitor.leaveNode(parentNodeName, value.toString(), this);
            break;
        case Integer:
            visitor.visitNode(parentNodeName, this);
            visitor.leaveNode(parentNodeName, value.toString(), this);
            break;
        case Null:
            visitor.visitNode(parentNodeName, this);
            visitor.leaveNode(parentNodeName, value.toString(), this);
            break;
        case String:
            visitor.visitNode(parentNodeName, this);
            visitor.leaveNode(parentNodeName, value.toString(), this);
            break;
        }

    }

    private SilkNode getContextNode()
    {
        if (contextNodeStack.isEmpty())
            return null;
        else
            return contextNodeStack.getLast();
    }
}
