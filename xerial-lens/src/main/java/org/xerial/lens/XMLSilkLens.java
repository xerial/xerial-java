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
// XMLSilkLens.java
// Since: Jul 28, 2009 11:41:27 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkWalker;
import org.xerial.silk.SilkWriter;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.Pair;
import org.xerial.util.StringUtil;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeVisitorBase;
import org.xerial.util.tree.TreeWalker;
import org.xerial.xml.XMLAttribute;
import org.xerial.xml.XMLErrorCode;
import org.xerial.xml.XMLGenerator;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * XML to Silk format converter
 * 
 * @author leo
 * 
 */
public class XMLSilkLens
{

    private static class XMLToSilkSAXHandler extends DefaultHandler2
    {
        private SilkWriter context;

        private static class AttributeNodes implements Iterable<Pair<String, String>>
        {
            ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();

            public void add(String name, String value) {
                list.add(new Pair<String, String>(name, value));
            }

            @Override
            public String toString() {
                ArrayList<String> b = new ArrayList<String>();
                for (Pair<String, String> each : list) {
                    b.add(String.format("%s:%s", each.getFirst(), each.getSecond()));
                }
                return StringUtil.join(b, ", ");
            }

            public Iterator<Pair<String, String>> iterator() {
                return list.iterator();
            }

        }

        private static class TagContext
        {
            public final String         tagName;
            public final AttributeNodes attribute;
            public StringBuilder        textBuf = new StringBuilder();
            public boolean              isOpen  = false;

            public TagContext(String tagName, AttributeNodes attribute) {
                this.tagName = tagName;
                this.attribute = attribute;
            }

            @Override
            public String toString() {
                return String.format("%s (%s) : %s", tagName, attribute, textBuf.toString());
            }
        }

        private ArrayDeque<TagContext> contextStack        = new ArrayDeque<TagContext>();
        private ArrayDeque<TagContext> unopendContextStack = new ArrayDeque<TagContext>();

        public XMLToSilkSAXHandler(Writer out) {
            this.context = new SilkWriter(out);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            TagContext tc = unopendContextStack.isEmpty() ? contextStack.getLast() : unopendContextStack.getLast();
            tc.textBuf.append(ch, start, length);

        }

        @Override
        public void endDocument() throws SAXException {
            context.endDocument();
        }

        @Override
        public void endElement(String uri, String localName, String name) throws SAXException {

            // start node
            openContext();

            context = context.getParent();

            contextStack.removeLast();
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            context.commentLine("PI: " + data);
        }

        @Override
        public void comment(char[] ch, int start, int length) throws SAXException {
            context.commentLine(new String(ch, start, length));
        }

        @Override
        public void startDocument() throws SAXException {
            context.preamble();
        }

        private void openContext() {

            for (TagContext tc : unopendContextStack) {
                // start node
                if (!tc.isOpen) {
                    context = context.node(tc.tagName);
                    for (Pair<String, String> each : tc.attribute) {
                        context.attribute(each.getFirst(), each.getSecond());
                    }
                    if (tc.textBuf.length() > 0) {
                        String value = tc.textBuf.toString().trim();
                        if (value.length() > 0)
                            context.nodeValue(value);
                    }

                    tc.isOpen = true;
                }

                contextStack.addLast(tc);
            }

            unopendContextStack.clear();
        }

        @Override
        public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {

            openContext();

            AttributeNodes at = new AttributeNodes();
            for (int i = 0; i < atts.getLength(); ++i)
                at.add(StringUtil.varNameToNaturalName(atts.getQName(i)), atts.getValue(i));

            unopendContextStack.addLast(new TagContext(StringUtil.varNameToNaturalName(name), at));
        }

    }

    public static String toSilk(Reader xml) throws XerialException {

        StringWriter buf = new StringWriter();

        try {
            // Set namespaceAware to true to get a parser that corresponds to
            // the default SAX2 namespace feature setting.  This is necessary
            // because the default value from JAXP 1.0 was defined to be false.

            // Validation part 1: set whether validation is on
            //spf.setValidating(dtdValidate || xsdValidate);

            // Create a JAXP SAXParser

            // Get the encapsulated SAX XMLReader
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            DefaultHandler2 ch = new XMLToSilkSAXHandler(buf);
            // Set the ContentHandler of the XMLReader
            xmlReader.setContentHandler(ch);
            xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", ch);

            xmlReader.parse(new InputSource(xml));

        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.INVALID_STATE, "failed to instantiate the XML parser: " + e);
        }

        //        XMLTreeWalker treeWalker = new XMLTreeWalker(xml);
        //      treeWalker.walk(new XMLToSilk(buf));

        return buf.toString();
    }

    //    /**
    //     * Populate the parameter values of the given bean using the content of the
    //     * Silk file.
    //     * 
    //     * @param <E>
    //     * @param bean
    //     *            object to populate
    //     * @param silkSource
    //     *            Silk file address
    //     * @return
    //     * @throws XerialException
    //     * @throws IOException
    //     *             when failed to open the specified Silk file
    //     */
    //    public static <E> E populateBean(E bean, URL silkSource) throws XerialException, IOException {
    //        return populateBeanWithSilk(bean, silkSource);
    //    }

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
    private static class XMLBuilder extends TreeVisitorBase
    {
        final XMLGenerator     xout;
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
        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException {
            popQueue();
            eventQueue.addLast(new TreeEvent(TreeEvent.EventType.VISIT, nodeName, immediateNodeValue));
        }

        @Override
        public void text(String nodeName, String textDataFragment, TreeWalker walker) throws XerialException {
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

}
