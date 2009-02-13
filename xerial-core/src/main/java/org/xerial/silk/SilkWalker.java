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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONUtil;
import org.xerial.json.JSONValue;
import org.xerial.json.JSONValueType;
import org.xerial.silk.impl.SilkDataLine;
import org.xerial.silk.impl.SilkFunction;
import org.xerial.silk.impl.SilkFunctionArg;
import org.xerial.silk.impl.SilkJSONValue;
import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkNodeOccurrence;
import org.xerial.silk.impl.SilkValue;
import org.xerial.silk.plugin.SilkFunctionArgument;
import org.xerial.silk.plugin.SilkFunctionPlugin;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.FileResource;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.log.Logger;
import org.xerial.util.reflect.ReflectionUtil;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * {@link TreeWalker} implementation of the Silk format.
 * 
 * <pre>
 * &#064;
 * </pre>
 * 
 * @author leo
 * 
 */
public class SilkWalker implements TreeWalker
{
    private static Logger _logger = Logger.getLogger(SilkWalker.class);

    private final SilkPullParser parser;

    private int indentationOffset = 0;
    private String resourceBasePath = null;
    private Deque<SilkNode> contextNodeStack = new ArrayDeque<SilkNode>();
    private TreeVisitor visitor = null;

    private class SilkEnvImpl implements SilkEnv
    {
        int offset = indentationOffset;
        TreeVisitor visitor;

        private SilkEnvImpl(SilkFunction f, TreeVisitor visitor)
        {
            if (f.getIndentLevel() == SilkFunction.NO_INDENT)
            {
                SilkNode node = getContextNode();
                if (node == null)
                    this.offset = indentationOffset;
                else
                    this.offset = node.getIndentLevel();
            }
            else
                this.offset = f.getIndentLevel();

            this.visitor = visitor;
        }

        public int getIndentationOffset()
        {
            return offset;
        }

        public Logger getLogger()
        {
            return _logger;
        }

        public TreeWalker getTreeWalker()
        {
            return SilkWalker.this;
        }

        public TreeVisitor getTreeVisitor()
        {
            return visitor;
        }

        public String getResourceBasePath()
        {
            return resourceBasePath;
        }

        public Deque<SilkNode> getContextNodeStack()
        {
            return contextNodeStack;
        }

    }

    /**
     * Creates a new SilkWalker with the specified input stream
     * 
     * @param input
     *            `@throws IOException
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

    public SilkWalker(String resourceBasePath, String resourceName) throws IOException
    {
        this.resourceBasePath = resourceBasePath;
        String resourcePath = resourceBasePath;
        if (!resourcePath.endsWith("/"))
            resourcePath += "/";
        resourcePath += resourceName;
        this.parser = new SilkPullParser(SilkWalker.class.getResourceAsStream(resourcePath));
        init();
    }

    public SilkWalker(URL resource) throws IOException
    {
        String path = resource.toExternalForm();
        int fileNamePos = path.lastIndexOf("/");
        this.resourceBasePath = fileNamePos > 0 ? path.substring(0, fileNamePos) : null;
        this.parser = new SilkPullParser(new BufferedReader(new InputStreamReader(resource.openStream())));
        init();
    }

    public SilkWalker(URL resource, SilkEnv env) throws IOException
    {
        String path = resource.toExternalForm();
        int fileNamePos = path.lastIndexOf("/");
        this.resourceBasePath = fileNamePos > 0 ? path.substring(0, fileNamePos) : null;
        this.parser = new SilkPullParser(new BufferedReader(new InputStreamReader(resource.openStream())));
        init(env);
    }

    public void init()
    {
        if (resourceBasePath == null)
            resourceBasePath = System.getProperty("user.dir", "");
    }

    public void init(SilkEnv env)
    {
        resourceBasePath = env.getResourceBasePath();
        indentationOffset = env.getIndentationOffset();
        contextNodeStack = env.getContextNodeStack();
    }

    public TreeNode getSubTree() throws XerialException
    {
        // TODO Auto-generated method stub
        return null;
    }

    private ArrayDeque<String> skipNodeStack = new ArrayDeque<String>();

    public void skipDescendants()
    {
        SilkNode context = getContextNode();
        if (context == null)
            skipNodeStack.addLast("__root");
        else
            skipNodeStack.addLast(context.getName());
    }

    private void visit(String nodeName, String immediateNodeValue) throws XerialException
    {
        if (!skipNodeStack.isEmpty())
        {
            skipNodeStack.addLast(nodeName);
            return;
        }

        visitor.visitNode(nodeName, immediateNodeValue, this);

    }

    private void leave(String nodeName) throws XerialException
    {
        if (!skipNodeStack.isEmpty())
        {
            String skippedNode = skipNodeStack.removeLast();
            if (skipNodeStack.isEmpty())
                leave(skippedNode); // output skip start node
            return;
        }

        visitor.leaveNode(nodeName, this);
    }

    private void text(String textFragment) throws XerialException
    {
        if (!skipNodeStack.isEmpty())
            return;

        visitor.text(textFragment, this);
    }

    private void closeUpTo(int newIndentLevel) throws XerialException
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
                    closeContext(node);
            }
            else
                return;
        }
    }

    private void closeContext(SilkNode node) throws XerialException
    {
        String nodeName = node.getName();
        leave(nodeName);
    }

    private void openContext(SilkNode node, TreeVisitor visitor) throws XerialException
    {
        int indentLevel = node.getIndentLevel();
        if (indentLevel != SilkNode.NO_INDENT)
            indentLevel += indentationOffset;

        closeUpTo(indentLevel);

        contextNodeStack.addLast(node);
        //outputDataCountStack.addLast(0);

        if (node.getOccurrence() == SilkNodeOccurrence.TABBED_SEQUENCE)
            return; // do not invoke visit events 

        String nodeName = node.getName();

        SilkValue textValue = node.getValue();

        if (textValue != null)
        {
            if (textValue.isJSON())
            {
                visit(nodeName, null);
                SilkJSONValue jsonValue = SilkJSONValue.class.cast(textValue);
                if (jsonValue.isObject())
                {
                    JSONObject jsonObj = new JSONObject(jsonValue.getValue());
                    walkJSONObject(jsonObj);
                }
                else
                {
                    JSONArray jsonArray = new JSONArray(jsonValue.getValue());
                    walkJSONAray(jsonArray, nodeName);
                }
            }
            else if (textValue.isFunction())
            {
                visit(nodeName, null);
                SilkFunction function = SilkFunction.class.cast(textValue);
                evalFunction(function, visitor);

                return;
            }
            else
                visit(nodeName, textValue.toString());
        }
        else
            visit(nodeName, null);

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

        walkWithoutInitAndFinish(visitor);

        visitor.finish(this);
    }

    private void evalFunction(SilkFunction function, TreeVisitor visitor) throws XerialException
    {
        if (!skipNodeStack.isEmpty())
            return; // skip evaluation

        SilkFunctionPlugin plugin = getPlugin(function.getName());
        if (plugin == null)
        {
            _logger.error(String.format("plugin %s not found", function.getName()));
            return;
        }
        populate(plugin, function.getArgumentList());
        plugin.eval(new SilkEnvImpl(function, visitor));

    }

    public void walkWithoutInitAndFinish(TreeVisitor visitor) throws XerialException
    {
        this.visitor = visitor;

        // depth first search 
        while (parser.hasNext())
        {
            SilkEvent currentEvent = parser.next();

            if (_logger.isDebugEnabled())
            {
                _logger.debug("stack: " + contextNodeStack);
                _logger.debug(currentEvent);
            }

            switch (currentEvent.getType())
            {
            case NODE:
                // push context node
                SilkNode newContextNode = SilkNode.class.cast(currentEvent.getElement());
                openContext(newContextNode, visitor);
                break;
            case FUNCTION:
                SilkFunction function = SilkFunction.class.cast(currentEvent.getElement());
                evalFunction(function, visitor);
                break;
            case DATA_LINE:

                // pop the context stack up to the node with stream data node occurrence
                while (!contextNodeStack.isEmpty())
                {
                    SilkNode node = contextNodeStack.peekLast();
                    if (!node.getOccurrence().isFollowedByStreamData())
                    {
                        contextNodeStack.removeLast();
                        leave(node.getName());
                    }
                    else
                        break;
                }

                if (contextNodeStack.isEmpty())
                {
                    // row(c1, c2, ...) 
                    SilkDataLine line = SilkDataLine.class.cast(currentEvent.getElement());
                    String[] columns = line.getDataLine().trim().split("\t");
                    int index = 1;
                    visit("row", null);
                    for (String each : columns)
                    {
                        String columnName = String.format("c%d", index++);
                        visitor.visitNode(columnName, each, this);
                        visitor.leaveNode(columnName, this);
                    }
                    leave("row");
                }
                else
                {

                    SilkNode schema = contextNodeStack.peekLast();
                    SilkDataLine line = SilkDataLine.class.cast(currentEvent.getElement());
                    switch (schema.getOccurrence())
                    {
                    case SEQUENCE:
                        text(line.getDataLine().trim());
                        break;
                    case TABBED_SEQUENCE:
                    {
                        String[] columns = line.getDataLine().trim().split("\t");
                        int columnIndex = 0;
                        visit(schema.getName(), schema.hasValue() ? schema.getValue().toString() : null);
                        for (int i = 0; i < schema.getChildNodes().size(); i++)
                        {
                            SilkNode child = schema.getChildNodes().get(i);
                            if (child.hasValue())
                            {
                                visit(child.getName(), child.getValue().toString());
                                leave(child.getName());
                            }
                            else
                            {
                                if (columnIndex < columns.length)
                                {
                                    String columnData = columns[columnIndex++];
                                    String dataType = child.getDataType();
                                    if (dataType != null && dataType.equalsIgnoreCase("json"))
                                    {
                                        try
                                        {
                                            JSONValue json = JSONUtil.parseJSON(columnData);
                                            if (json.getJSONObject() != null)
                                            {
                                                visit(child.getName(), null);
                                                walkJSONValue(json, child.getName());
                                                leave(child.getName());
                                            }
                                            else
                                                walkJSONValue(json, child.getName());
                                        }
                                        catch (JSONException e)
                                        {
                                            throw new XerialException(e.getErrorCode(), String.format("line=%d: %s",
                                                    parser.getLine(), e.getMessage()));
                                        }

                                    }
                                    else
                                    {
                                        visit(child.getName(), columnData);
                                        leave(child.getName());
                                    }
                                }
                            }
                        }
                        leave(schema.getName());
                        break;
                    }
                    }
                }
                break;
            case BLANK_LINE:
                break;

            }

        }

        closeUpTo(indentationOffset);

    }

    private void walkJSONAray(JSONArray jsonArray, String parentNodeName) throws XerialException
    {
        for (JSONValue each : jsonArray)
        {
            walkJSONValue(each, parentNodeName);
        }
    }

    private void walkJSONObject(JSONObject jsonObj) throws XerialException
    {
        for (String key : jsonObj.keys())
        {
            JSONValue val = jsonObj.get(key);
            walkJSONValue(val, key);
        }
    }

    private void walkJSONValue(JSONValue value, String parentNodeName) throws XerialException
    {
        JSONValueType type = value.getValueType();
        switch (type)
        {
        case Array:
            walkJSONAray(value.getJSONArray(), parentNodeName);
            break;
        case Object:
            walkJSONObject(value.getJSONObject());
            break;
        case Boolean:
            visit(parentNodeName, value.toString());
            leave(parentNodeName);
            break;
        case Double:
            visit(parentNodeName, value.toString());
            leave(parentNodeName);
            break;
        case Integer:
            visit(parentNodeName, value.toString());
            leave(parentNodeName);
            break;
        case Null:
            visit(parentNodeName, value.toString());
            leave(parentNodeName);
            break;
        case String:
            visit(parentNodeName, value.toString());
            leave(parentNodeName);
            break;
        }

    }

    private static Map<String, Class<SilkFunctionPlugin>> pluginTable = null;

    private SilkFunctionPlugin getPlugin(String name)
    {
        Class<SilkFunctionPlugin> pluginClass = getPluginTable().get(name);
        if (pluginClass == null)
            return null;

        try
        {
            SilkFunctionPlugin pluginInstance = pluginClass.newInstance();
            return pluginInstance;
        }
        catch (InstantiationException e)
        {
            _logger.warn(e);
            return null;
        }
        catch (IllegalAccessException e)
        {
            _logger.warn(e);
            return null;
        }
    }

    private Map<String, Class<SilkFunctionPlugin>> getPluginTable()
    {
        if (pluginTable == null)
        {
            pluginTable = new TreeMap<String, Class<SilkFunctionPlugin>>();
            // load plugins 
            for (Class<SilkFunctionPlugin> each : FileResource.findClasses(SilkFunctionPlugin.class.getPackage(),
                    SilkFunctionPlugin.class, SilkWalker.class.getClassLoader()))
            {
                String functionName = each.getSimpleName().toLowerCase();
                _logger.trace("loaded " + functionName);
                pluginTable.put(functionName, each);
            }
        }

        return pluginTable;
    }

    private static class PluginField
    {
        Field field;
        SilkFunctionArgument argInfo;

        private PluginField(SilkFunctionArgument argInfo, Field field)
        {
            this.argInfo = argInfo;
            this.field = field;
        }
    }

    private static class PluginHolder
    {
        Class< ? extends SilkFunctionPlugin> pluginClass;
        ArrayList<PluginField> argumentFieldList = new ArrayList<PluginField>();
        Map<String, PluginField> keyValueFieldTable = new HashMap<String, PluginField>();

        public PluginHolder(Class< ? extends SilkFunctionPlugin> pluginClass)
        {
            this.pluginClass = pluginClass;

            //ArrayList<SilkFunctionArgument> argDefs = new ArrayList<SilkFunctionArgument>();
            for (Field eachField : pluginClass.getDeclaredFields())
            {
                SilkFunctionArgument argInfo = eachField.getAnnotation(SilkFunctionArgument.class);
                if (argInfo != null)
                {
                    PluginField pf = new PluginField(argInfo, eachField);
                    if (argInfo.name().equals(SilkFunctionArgument.NO_VALUE))
                        argumentFieldList.add(pf);
                    else
                        keyValueFieldTable.put(argInfo.name(), pf);
                }
            }

            // sort arguments in the order of their ordinal
            Collections.sort(argumentFieldList, new Comparator<PluginField>() {
                public int compare(PluginField o1, PluginField o2)
                {
                    return o1.argInfo.ordinal() - o2.argInfo.ordinal();
                }
            });

        }

        /**
         * Bind function arguments to the plug-in instance
         * 
         * @param plugin
         *            the instance of the plug-in
         * @param args
         *            the function arguments
         */
        public void populate(SilkFunctionPlugin plugin, List<SilkFunctionArg> args)
        {
            int noNameArgCount = 0;
            for (SilkFunctionArg eachArgument : args)
            {
                String argValue = eachArgument.getValue().toString();
                try
                {
                    if (eachArgument.hasName())
                    {
                        // key value arg
                        PluginField f = keyValueFieldTable.get(eachArgument.getName());
                        if (f == null)
                        {
                            _logger.warn("unknown argument: " + eachArgument);
                            continue;
                        }
                        ReflectionUtil.setFieldValue(plugin, f.field, argValue);
                    }
                    else
                    {
                        // unnamed argument
                        // matching argument order
                        if (noNameArgCount >= argumentFieldList.size())
                        {
                            _logger.warn("no corresponding field for the argument is found: " + eachArgument);
                            continue;
                        }
                        PluginField f = argumentFieldList.get(noNameArgCount);
                        ReflectionUtil.setFieldValue(plugin, f.field, argValue);

                        if (!TypeInformation.isCollection(f.field.getType()))
                            noNameArgCount++;
                    }
                }
                catch (XerialException e)
                {
                    _logger.error(e);
                }

            }
        }

    }

    private void populate(SilkFunctionPlugin plugin, List<SilkFunctionArg> args)
    {
        PluginHolder holder = new PluginHolder(plugin.getClass());
        holder.populate(plugin, args);
    }

    private SilkNode getContextNode()
    {
        if (contextNodeStack.isEmpty())
            return null;
        else
            return contextNodeStack.getLast();
    }
}
