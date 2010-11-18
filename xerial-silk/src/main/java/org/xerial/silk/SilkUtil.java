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
// SilkUtil.java
// Since: 2009/02/13 21:15:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONValue;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.TypeInfo;
import org.xerial.util.bean.impl.BeanBindingProcess;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeVisitorBase;
import org.xerial.util.tree.TreeWalker;
import org.xerial.xml.XMLAttribute;
import org.xerial.xml.XMLErrorCode;
import org.xerial.xml.XMLGenerator;

/**
 * Utilities for handling Silk file format.
 * 
 * @author leo
 * 
 */
public class SilkUtil {
    /**
     * Silk to Object mapping. Create a bean object from a given Silk file. The
     * parameter values of the specified bean class will be populated with the
     * content of the Silk file.
     * 
     * 
     * @param <E>
     * @param beanType
     *            object type to generate
     * @param silkSource
     *            Silk file address
     * @return object generated from the Silk source file
     * @throws XerialException
     * @throws IOException
     *             when failed to open the specified Silk file.
     */
    public static <E> E createBean(Class<E> beanType, URL silkSource) throws XerialException,
            IOException {
        return createBeanFromSilk(beanType, silkSource);
    }

    /**
     * Populate the parameter values of the given bean using the content of the
     * Silk file.
     * 
     * @param <E>
     * @param bean
     *            object to populate
     * @param silkSource
     *            Silk file address
     * @return
     * @throws XerialException
     * @throws IOException
     *             when failed to open the specified Silk file
     */
    public static <E> E populateBean(E bean, URL silkSource) throws XerialException, IOException {
        return populateBeanWithSilk(bean, silkSource);
    }

    /**
     * Convert the given Silk file into XML data. Since Silk's data model is
     * forest, while XML is tree, the root element (&lt;silk&gt; tag) for the
     * XML data will be generated.
     * 
     * @param silkSource
     * @return
     * @throws IOException
     * @throws XerialException
     */
    public static String toXML(URL silkSource) throws IOException, XerialException {
        StringWriter buf = new StringWriter();
        toXML(silkSource, buf);
        return buf.toString();
    }

    /**
     * Convert the silk file into XML
     * 
     * @param silkSource
     * @param out
     * @throws IOException
     * @throws XerialException
     */
    public static void toXML(URL silkSource, Writer out) throws IOException, XerialException {
        SilkWalker walker = new SilkWalker(silkSource);
        XMLBuilder builder = new XMLBuilder(out);
        walker.walk(builder);

    }

    /**
     * 
     * <pre>
     * 1:visit -&gt; 2:visit : pop(1), startTag(1, value=&quot;..&quot;), push(2:visit)
     * 1:visit -&gt; 2:text : pop(1), startTag(1, value=&quot;..&quot;), text(2:text) 
     * 1:visit -&gt; 2:leave : pop(1), selfCloseTag(1, value=&quot;..&quot;)
     * </pre>
     * 
     * @author leo
     * 
     */
    private static class XMLBuilder extends TreeVisitorBase {
        final XMLGenerator xout;
        final Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

        public XMLBuilder(Writer out) {
            xout = new XMLGenerator(out);
        }

        private void popQueue() {
            if (!eventQueue.isEmpty()) {
                TreeEvent prev = eventQueue.removeLast();

                switch (prev.event) {
                case VISIT:
                    if (prev.nodeValue == null)
                        xout.startTag(prev.nodeName);
                    else
                        xout.startTag(prev.nodeName, new XMLAttribute("value", prev.nodeValue));
                    break;
                default:
                    throw new XerialError(XMLErrorCode.INVALID_XML_STRUCTURE);
                }
            }

        }

        @Override
        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker)
                throws XerialException {
            popQueue();
            eventQueue.addLast(new TreeEvent(TreeEvent.EventType.VISIT, nodeName,
                    immediateNodeValue));
        }

        @Override
        public void text(String nodeName, String textDataFragment, TreeWalker walker)
                throws XerialException {
            popQueue();
            xout.text(textDataFragment);
        }

        @Override
        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
            if (!eventQueue.isEmpty()) {
                TreeEvent prev = eventQueue.removeLast();

                switch (prev.event) {
                case VISIT:
                    if (prev.nodeValue == null)
                        xout.selfCloseTag(prev.nodeName);
                    else
                        xout.element(prev.nodeName, prev.nodeValue);
                }
            }
            else
                xout.endTag();
        }

        @Override
        public void init(TreeWalker walker) throws XerialException {
            visitNode("silk", null, walker);
        }

        @Override
        public void finish(TreeWalker walker) throws XerialException {
            leaveNode("silk", walker);
            xout.endDocument();
        }
    }

    /**
     * Convert the Silk data into JSON.
     * 
     * TODO implementation
     * 
     * @param silkSource
     * @param out
     * @throws IOException
     * @throws XerialException
     */
    public static Writer toJSON(URL silkSource, Writer out) throws IOException, XerialException {
        SilkWalker walker = new SilkWalker(silkSource);
        JSONBuilder jsonBuilder = new JSONBuilder();
        walker.walk(jsonBuilder);
        JSONArray root = jsonBuilder.getRoot();
        out.append(root.toJSONString());
        return out;
    }

    private static class JSONBuilder implements TreeVisitor {
        JSONArray root = new JSONArray();
        Deque<JSONObject> contextStack = new ArrayDeque<JSONObject>();
        Deque<StringBuilder> textStack = new ArrayDeque<StringBuilder>();
        final StringBuilder ZERO_CAPACITY_BUFFER = new StringBuilder(0);

        public JSONBuilder() {

        }

        public JSONArray getRoot() {
            return root;
        }

        private JSONObject getContext() {
            return contextStack.peekLast();
        }

        private StringBuilder getTextBuilder() {
            if (textStack.peekLast() == ZERO_CAPACITY_BUFFER) {
                textStack.removeLast();
                textStack.addLast(new StringBuilder());
            }
            return textStack.peekLast();
        }

        public void finish(TreeWalker walker) throws XerialException {}

        public void init(TreeWalker walker) throws XerialException {}

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
            JSONObject node = getContext();
            contextStack.removeLast();

            if (node.keys().size() == 0) {
                // flatten object into single key:value pair
                JSONObject parent = getContext();
                if (textStack.peekLast() != ZERO_CAPACITY_BUFFER)
                    parent.put(nodeName, textStack.peekLast().toString());

                if (contextStack.size() == 1) {
                    contextStack.removeLast(); // remove additional object
                    textStack.removeLast();
                    return;
                }
            }
            else {
                if (contextStack.size() == 1) {
                    contextStack.removeLast(); // remove additional object
                    textStack.removeLast();
                    return;
                }

                JSONObject parent = getContext();
                if (!parent.hasKey(nodeName))
                    parent.put(nodeName, node);
                else {
                    // use array to handle multiple occurrences of the same name node
                    JSONValue elderBrother = parent.get(nodeName);
                    JSONArray array = elderBrother.getJSONArray();
                    if (array != null) {
                        array.add(node);
                    }
                    else {
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

        public void text(String nodeName, String textDataFragment, TreeWalker walker)
                throws XerialException {
            getTextBuilder().append(textDataFragment);
        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker)
                throws XerialException {
            JSONObject newContext = new JSONObject();

            if (contextStack.isEmpty()) {
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

    /**
     * Convert the given object into Silk
     * 
     * @param obj
     * @return
     */
    public static String toSilk(Object obj) {
        StringWriter buf = new StringWriter();
        SilkWriter writer = new SilkWriter(buf);
        writer.toSilk(obj);
        writer.flush();
        return buf.toString();
    }

    public static <T> T createSilkBean(Class<T> beanClass, URL silkFileLocation)
            throws XerialException {
        T bean = TypeInfo.createInstance(beanClass);
        BeanBindingProcess bindingProcess = BeanBindingProcess.newBinderWithRootContext(bean);

        try {
            SilkWalker walker = new SilkWalker(silkFileLocation);
            walker.walk(bindingProcess);
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

        return bean;
    }

    public static <T> T populateBeanWithSilk(T bean, URL silkResourceLocation)
            throws XerialException, IOException {
        try {
            SilkLens.loadSilk(bean, silkResourceLocation);
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

        return bean;
    }

    // Silk Stream
    public static <E> E createBeanFromSilk(Class<E> beanType, URL silkFileAddress)
            throws XerialException, IOException {
        return BeanUtilImpl.createTypedBean(new SilkWalker(silkFileAddress), beanType);
    }

    //    public static <E> E populateBeanWithSilk(E bean, URL silkFileAddress) throws XerialException,
    //            IOException {
    //        return BeanUtilImpl.createBean(new SilkWalker(silkFileAddress), bean);
    //    }

    /**
     * Forbid construction
     */
    protected SilkUtil() {}

}
