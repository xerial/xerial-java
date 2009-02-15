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

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
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
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeVisitorBase;
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

    private int indentationOffset = 0;
    private String resourceBasePath = null;
    private Deque<SilkNode> contextNodeStack = new ArrayDeque<SilkNode>();
    private TreeVisitor visitor = null;
    private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();
    private TreeEvent currentEvent = null;

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
    protected SilkWalker(InputStream input) throws IOException
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
    protected SilkWalker(Reader input) throws IOException
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

    public SilkWalker(URL resourcePath) throws IOException
    {
        String path = resourcePath.toExternalForm();
        int fileNamePos = path.lastIndexOf("/");
        this.resourceBasePath = fileNamePos > 0 ? path.substring(0, fileNamePos) : null;
        this.parser = new SilkPullParser(new BufferedReader(new InputStreamReader(resourcePath.openStream())));
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

    private static class TreeNodeImpl implements TreeNode
    {
        String nodeName = null;
        String nodeValue = null;
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();

        public TreeNodeImpl(String nodeName, String nodeValue)
        {
            this.nodeName = nodeName;
            this.nodeValue = nodeValue;
        }

        public void setNodeValue(String text)
        {
            nodeValue = text;
        }

        public void addChild(TreeNode node)
        {
            children.add(node);
        }

        public List<TreeNode> getChildren()
        {
            return children;
        }

        public String getNodeName()
        {
            return nodeName;
        }

        public String getNodeValue()
        {
            return nodeValue;
        }

    }

    private class SubtreeBuilder extends TreeVisitorBase
    {
        final TreeNodeImpl root;
        final Deque<TreeNodeImpl> nodeStack = new ArrayDeque<TreeNodeImpl>();
        boolean hasFinished = false;

        SubtreeBuilder(String nodeName, String nodeValue)
        {
            root = new TreeNodeImpl(nodeName, nodeValue);
            nodeStack.addLast(root);
        }

        @Override
        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
            TreeNodeImpl child = new TreeNodeImpl(nodeName, immediateNodeValue);
            nodeStack.peekLast().addChild(child);
            nodeStack.addLast(child);
        }

        @Override
        public void text(String textDataFragment, TreeWalker walker) throws XerialException
        {
            nodeStack.peekLast().setNodeValue(textDataFragment);
        }

        @Override
        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {
            nodeStack.removeLast();
            if (nodeStack.isEmpty())
            {
                hasFinished = true;
            }
        }

        public boolean hasFinished()
        {
            return hasFinished;
        }

        public TreeNode getSubtreeRoot()
        {
            return root;
        }

    }

    public TreeNode getSubTree() throws XerialException
    {
        SubtreeBuilder builder;
        if (currentEvent == null)
            builder = new SubtreeBuilder("silk", null);
        else
            builder = new SubtreeBuilder(currentEvent.nodeName, currentEvent.nodeValue);

        TreeVisitor parentVisitor = this.visitor;
        this.visitor = builder;

        try
        {
            while (!builder.hasFinished())
            {
                stepNext();
            }
        }
        finally
        {
            this.visitor = parentVisitor;
        }

        return builder.getSubtreeRoot();
    }

    /**
     * If this stack is not empty, we must disable event reporting to the
     * {@link TreeVisitor}
     */
    private ArrayDeque<String> skipNodeStack = new ArrayDeque<String>();

    public void skipDescendants()
    {
        if (currentEvent == null)
            skipNodeStack.addLast("silk");
        else
            skipNodeStack.addLast(currentEvent.nodeName);
    }

    /**
     * Enqueues a visit event.
     * 
     * @param nodeName
     * @param immediateNodeValue
     * @throws XerialException
     */
    private void visit(String nodeName, String immediateNodeValue) throws XerialException
    {
        eventQueue.addLast(new TreeEvent(TreeEvent.EventType.VISIT, nodeName, immediateNodeValue));
    }

    /**
     * Enqueues a leave event
     * 
     * @param nodeName
     * @throws XerialException
     */
    private void leave(String nodeName) throws XerialException
    {
        eventQueue.addLast(new TreeEvent(TreeEvent.EventType.LEAVE, nodeName, null));
    }

    /**
     * Enqueues a text event
     * 
     * @param textFragment
     * @throws XerialException
     */
    private void text(String textFragment) throws XerialException
    {
        eventQueue.addLast(new TreeEvent(TreeEvent.EventType.TEXT, null, textFragment));

    }

    /**
     * Closed pre-opened contexts up to the specified indent level
     * 
     * @param newIndentLevel
     * @throws XerialException
     */
    private void closeContextUpTo(int newIndentLevel) throws XerialException
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
                {
                    // close context
                    String nodeName = node.getName();
                    leave(nodeName);
                }
            }
            else
                return;
        }
    }

    /**
     * Opens a new context for the given node
     * 
     * @param node
     *            new context node
     * @param visitor
     * @throws XerialException
     */
    private void openContext(SilkNode node) throws XerialException
    {
        int indentLevel = node.getIndentLevel();
        if (indentLevel != SilkNode.NO_INDENT)
            indentLevel += indentationOffset;

        closeContextUpTo(indentLevel);

        contextNodeStack.addLast(node);
        //outputDataCountStack.addLast(0);

        if (node.getOccurrence() == SilkNodeOccurrence.TABBED_SEQUENCE)
            return; // do not invoke visit events 

        String nodeName = node.getName();

        SilkValue textValue = node.getValue();

        // process text values attached to the node
        if (textValue != null)
        {
            // When the text data is JSON, traverses the JSON data 
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
                // evaluate the function 
                visit(nodeName, null);
                SilkFunction function = SilkFunction.class.cast(textValue);
                evalFunction(function);

                return;
            }
            else
            {
                // Simple text value will be reported as it is.
                visit(nodeName, textValue.toString());
            }
        }
        else
        {
            // Report a visit event without text value
            visit(nodeName, null);
        }

        // Traverse attribute nodes which have text values. If no text value is specified for an attribute, 
        // this attribute is a schema element for the following DATA_LINE 
        for (SilkNode eachChild : node.getChildNodes())
        {
            if (eachChild.hasValue())
            {
                openContext(eachChild);
            }
        }

    }

    /**
     * Evaluate the function
     * 
     * @param function
     * @throws XerialException
     */
    private void evalFunction(SilkFunction function) throws XerialException
    {
        if (!skipNodeStack.isEmpty())
            return; // skip evaluation

        SilkFunctionPlugin plugin = getPlugin(function.getName());
        if (plugin == null)
        {
            _logger.error(String.format("plugin %s not found", function.getName()));
            return;
        }
        // fill the function argument to the plugin instance
        populate(plugin, function.getArgumentList());
        plugin.eval(new SilkEnvImpl(function, visitor));

    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        // initialize
        visitor.init(this);

        walkWithoutInitAndFinish(visitor);

        visitor.finish(this);
    }

    public void walkWithoutInitAndFinish(TreeVisitor visitor) throws XerialException
    {
        this.visitor = visitor;
        // depth first search

        while (hasNext())
        {
            stepNext();
        }

    }

    /**
     * Consume the next event, and call its corresponding visitor event.
     * 
     * @throws XerialException
     */
    private void stepNext() throws XerialException
    {
        currentEvent = getNextEvent();
        //_logger.info("step: " + currentEvent);

        switch (currentEvent.event)
        {
        case INIT:
            visitor.init(this);
            break;
        case FINISH:
            visitor.finish(this);
            break;

        case VISIT:
            if (!skipNodeStack.isEmpty())
            {
                skipNodeStack.addLast(currentEvent.nodeName);
                return;
            }
            visitor.visitNode(currentEvent.nodeName, currentEvent.nodeValue, this);
            break;

        case LEAVE:
            if (!skipNodeStack.isEmpty())
            {
                String skippedNode = skipNodeStack.removeLast();
                if (skipNodeStack.isEmpty())
                    leave(skippedNode); // output skip start node
                return;
            }

            visitor.leaveNode(currentEvent.nodeName, this);
            break;

        case TEXT:
            if (!skipNodeStack.isEmpty())
                return;
            visitor.text(currentEvent.nodeValue, this);
            break;
        }

    }

    /**
     * Has finished reading the stream?
     */
    private boolean hasFinished = false;

    /**
     * Is next event available?
     * 
     * @return true if there are remaining events, otherwise fales
     * @throws XerialException
     */
    private boolean hasNext() throws XerialException
    {
        if (eventQueue.isEmpty())
        {
            if (hasFinished)
                return false;

            fillQueue();
            return hasNext();
        }
        else
            return true;
    }

    /**
     * Retrieves the next event from the queue. If the event queue is empty,
     * fill the queue with the next event
     * 
     * @return the next event.
     * @throws XerialException
     */
    private TreeEvent getNextEvent() throws XerialException
    {
        if (!eventQueue.isEmpty())
            return eventQueue.removeFirst();

        if (hasFinished)
            throw new XerialError(XerialErrorCode.INVALID_STATE,
                    "hasNext() value must be checked before calling getNextEvent()");

        fillQueue();
        return getNextEvent();
    }

    /**
     * Fill the queue by retrieving the next event from the pull parser.
     * 
     * @throws XerialException
     */
    private void fillQueue() throws XerialException
    {
        if (!parser.hasNext())
        {
            // no more input data
            closeContextUpTo(indentationOffset);
            hasFinished = true;
            return;
        }

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
            openContext(newContextNode);
            break;
        case FUNCTION:
            SilkFunction function = SilkFunction.class.cast(currentEvent.getElement());
            evalFunction(function);
            break;
        case DATA_LINE:

            // pop the context stack until finding a node for stream data node occurrence
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
                                        throw new XerialException(e.getErrorCode(), String.format("line=%d: %s", parser
                                                .getLine(), e.getMessage()));
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

        case PREAMBLE:
            break;

        }

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

    /**
     * Plugin holder
     */
    private static Map<String, Class<SilkFunctionPlugin>> pluginTable = null;

    /**
     * Get the plugin of the specified name
     * 
     * @param name
     *            plugin name
     * @return plugin instance or null if no corresponding plugin is found.
     */
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

    /**
     * Information of the function (plugin) arguments (
     * {@link SilkFunctionArgument}) described in the Class definition, which
     * implements {@link SilkFunctionPlugin}.
     * 
     * @author leo
     * 
     */
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

    /**
     * Fill the plug-in argument fields with the given arguments
     * 
     * @param plugin
     *            plug-in instance.
     * @param args
     *            function arguments.
     */
    private static void populate(SilkFunctionPlugin plugin, List<SilkFunctionArg> args)
    {
        PluginHolder holder = new PluginHolder(plugin.getClass());
        holder.populate(plugin, args);
    }

    /**
     * Get the context node
     * 
     * @return
     */
    private SilkNode getContextNode()
    {
        if (contextNodeStack.isEmpty())
            return null;
        else
            return contextNodeStack.getLast();
    }
}
