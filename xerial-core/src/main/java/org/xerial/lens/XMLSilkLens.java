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

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkWriter;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Pair;
import org.xerial.util.StringUtil;
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
public class XMLSilkLens {

    private static class XMLToSilkSAXHandler extends DefaultHandler2 {
        private SilkWriter context;

        private static class AttributeNodes implements Iterable<Pair<String, String>> {
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

        private static class TagContext {
            public final String tagName;
            public final AttributeNodes attribute;
            public StringBuilder textBuf = new StringBuilder();
            public boolean isOpen = false;

            public TagContext(String tagName, AttributeNodes attribute) {
                this.tagName = tagName;
                this.attribute = attribute;
            }

            @Override
            public String toString() {
                return String.format("%s (%s) : %s", tagName, attribute, textBuf.toString());
            }
        }

        private ArrayDeque<TagContext> contextStack = new ArrayDeque<TagContext>();
        private ArrayDeque<TagContext> unopendContextStack = new ArrayDeque<TagContext>();

        public XMLToSilkSAXHandler(Writer out) {
            this.context = new SilkWriter(out);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            TagContext tc = unopendContextStack.isEmpty() ? contextStack.getLast()
                    : unopendContextStack.getLast();
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
        public void startElement(String uri, String localName, String name, Attributes atts)
                throws SAXException {

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
            throw new XerialException(XerialErrorCode.INVALID_STATE,
                    "failed to instantiate the XML parser: " + e);
        }

        //        XMLTreeWalker treeWalker = new XMLTreeWalker(xml);
        //      treeWalker.walk(new XMLToSilk(buf));

        return buf.toString();
    }

}
