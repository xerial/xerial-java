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

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkWriter;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * XML to Silk format converter
 * 
 * @author leo
 * 
 */
public class XMLSilkLens {

    private static class XMLToSilk implements TreeVisitor {

        private final SilkWriter out;

        public XMLToSilk(Writer out) {
            this.out = new SilkWriter(out);

        }

        public void finish(TreeWalker walker) throws XerialException {

            out.flush();
        }

        public void init(TreeWalker walker) throws XerialException {

            out.preamble();
        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
            out.leaveNode();
        }

        public void text(String nodeName, String textDataFragment, TreeWalker walker)
                throws XerialException {

        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker)
                throws XerialException {
            if (immediateNodeValue == null)
                out.startNode(nodeName);
            else
                out.startNode(nodeName, immediateNodeValue);

        }

    }

    private static class XMLToSilkSAXHandler implements ContentHandler {
        private final SilkWriter out;

        public XMLToSilkSAXHandler(Writer out) {
            this.out = new SilkWriter(out);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {

        }

        public void endDocument() throws SAXException {
            out.flush();
        }

        public void endElement(String uri, String localName, String name) throws SAXException {
            out.leaveNode();
        }

        public void endPrefixMapping(String prefix) throws SAXException {

        }

        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

        }

        public void processingInstruction(String target, String data) throws SAXException {

        }

        public void setDocumentLocator(Locator locator) {

        }

        public void skippedEntity(String name) throws SAXException {

        }

        public void startDocument() throws SAXException {
            out.preamble();
        }

        public void startElement(String uri, String localName, String name, Attributes atts)
                throws SAXException {
            out.startNode(name);
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {

        }

    }

    public static String toSilk(Reader xml) throws XerialException {

        StringWriter buf = new StringWriter();

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();

            // Set namespaceAware to true to get a parser that corresponds to
            // the default SAX2 namespace feature setting.  This is necessary
            // because the default value from JAXP 1.0 was defined to be false.
            spf.setNamespaceAware(true);

            // Validation part 1: set whether validation is on
            //spf.setValidating(dtdValidate || xsdValidate);

            // Create a JAXP SAXParser
            SAXParser saxParser = spf.newSAXParser();

            // Get the encapsulated SAX XMLReader
            XMLReader xmlReader = saxParser.getXMLReader();
            // Set the ContentHandler of the XMLReader
            xmlReader.setContentHandler(new XMLToSilkSAXHandler(buf));

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
