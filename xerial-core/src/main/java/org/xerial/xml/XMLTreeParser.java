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
// XMLTreeParser.java
// Since: Jun 5, 2009 6:55:11 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeParser;
import org.xerial.util.tree.TreeEvent.EventType;
import org.xerial.xml.impl.TreeEventQueue;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XMLTreeParser implements TreeParser {
    private final Deque<StringBuilder> textStack = new ArrayDeque<StringBuilder>();
    private final static StringBuilder EMPTY_STRING = new StringBuilder(0);
    private final int TEXT_BUFFER_MAX = 8192;

    private boolean convertValueAttribute = false;

    private final TreeEventQueue eventQueue = new TreeEventQueue();

    private final Reader input;
    private final XMLReader xmlReader;

    public XMLTreeParser(Reader reader, boolean useValueAttribute) throws XerialException {
        this(reader);
        convertValueAttribute = true;
    }

    public XMLTreeParser(Reader reader) throws XerialException {
        try {
            this.input = reader;
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
            xmlReader = saxParser.getXMLReader();
            // Set the ContentHandler of the XMLReader
            xmlReader.setContentHandler(new SAXHandler());

        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.INVALID_STATE,
                    "failed to instantiate the XML parser: " + e);
        }

    }

    private void flushEvent() throws Exception {
        while (!eventQueue.isEmpty()) {
            TreeEvent e = eventQueue.pop();
            switch (e.event) {
            case VISIT:
                handler.visitNode(e.nodeName, e.nodeValue);
                break;
            case LEAVE:
                handler.leaveNode(e.nodeName);
                break;
            case TEXT:
                handler.text(e.nodeName, e.nodeValue);
                break;
            }

        }
    }

    private class SAXHandler implements ContentHandler {

        public void characters(char[] ch, int start, int length) throws SAXException {
            try {
                String textData = new String(ch, start, length);
                StringBuilder textBuffer = textStack.getLast();

                if (textData.length() <= 0)
                    return;

                if (textBuffer == EMPTY_STRING) {
                    textBuffer = replaceLastTextBuffer();
                }
                else if (textBuffer.length() + textData.length() > TEXT_BUFFER_MAX) {
                    // add the previous text data to the event queue
                    reportTextEvent(textBuffer);

                    // replace the text buffer
                    textBuffer = replaceLastTextBuffer();
                }
                textBuffer.append(textData);

                boolean needPrefetch = eventQueue.isEmpty() ? false
                        : eventQueue.peekLast().event == EventType.VISIT;

                if (!needPrefetch)
                    flushEvent();

            }
            catch (Exception e) {
                throw new SAXException(e);
            }

        }

        public void endDocument() throws SAXException {
            try {
                flushEvent();
                handler.finish();
            }
            catch (Exception e) {
                throw new SAXException(e);
            }
        }

        public void endElement(String uri, String localName, String name) throws SAXException {
            try {
                if (textStack.getLast() == EMPTY_STRING) {
                    eventQueue.push(TreeEvent.newLeaveEvent(name));
                }
                else {
                    StringBuilder textBuffer = textStack.getLast();
                    if (!eventQueue.isEmpty()) {
                        TreeEvent lastEvent = eventQueue.peekLast();
                        if (lastEvent.event == EventType.VISIT && lastEvent.nodeValue == null) {
                            // attach the text value to the the previous visit event
                            eventQueue.replaceLast(TreeEvent.newVisitEvent(name,
                                    sanitize(textBuffer.toString())));
                        }
                    }
                    else
                        reportTextEvent(textBuffer);

                    eventQueue.push(TreeEvent.newLeaveEvent(name));
                }
                textStack.removeLast();

                flushEvent();
            }
            catch (Exception e) {
                throw new SAXException(e);
            }

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
            try {
                handler.init();
            }
            catch (Exception e) {
                throw new SAXException(e);
            }

        }

        public void startElement(String uri, String localName, String name, Attributes atts)
                throws SAXException {
            textStack.addLast(EMPTY_STRING);
            String tagName = localName;
            String immediateNodeValue = null;

            Deque<TreeEvent> startEventQueue = new ArrayDeque<TreeEvent>(atts.getLength());
            // read attributes
            for (int i = 0; i < atts.getLength(); i++) {
                String attributeName = atts.getQName(i);
                String attributeValue = atts.getValue(i);

                // assign the value attribute as a node value of the start tag 
                if (convertValueAttribute
                        && (attributeName.equals("value") || attributeName.equals(String.format(
                                "%s:value", tagName)))) {
                    immediateNodeValue = attributeValue;
                    continue;
                }

                startEventQueue.addLast(TreeEvent.newVisitEvent(attributeName, attributeValue));
                startEventQueue.addLast(TreeEvent.newLeaveEvent(attributeName));
            }

            // push a new start tag event to the front of the queue
            startEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, immediateNodeValue));
            eventQueue.push(startEventQueue);
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // TODO Auto-generated method stub

        }

    }

    private TreeEventHandler handler;

    public void parse(TreeEventHandler handler) throws Exception {
        this.handler = handler;
        xmlReader.parse(new InputSource(input));
    }

    private StringBuilder replaceLastTextBuffer() {
        textStack.removeLast();
        StringBuilder textBuffer = new StringBuilder();
        textStack.addLast(textBuffer);
        return textBuffer;
    }

    private String sanitize(String s) {
        return s.trim();
    }

    private void reportTextEvent(StringBuilder buffer) {
        reportTextEvent(buffer.toString());
    }

    private void reportTextEvent(String textData) {
        textData = sanitize(textData);

        if (textData.length() > 0)
            eventQueue.push(TreeEvent.newTextEvent(eventQueue.getContextNodeName(), textData));
    }

}
