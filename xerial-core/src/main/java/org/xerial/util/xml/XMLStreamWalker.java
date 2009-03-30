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
// XMLStreamWalker.java
// Since: Mar 30, 2009 5:27:15 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.START_TAG;
import static org.xmlpull.v1.XmlPullParser.TEXT;

import java.io.IOException;
import java.io.Reader;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeStreamWalker;
import org.xerial.util.tree.TreeEvent.EventType;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * {@link TreeStreamWalker} of XML data
 * 
 * @author leo
 * 
 */
public class XMLStreamWalker implements TreeStreamWalker
{
    private final XmlPullParser pullParser;
    private final Deque<StringBuilder> textStack = new ArrayDeque<StringBuilder>();
    private final static StringBuilder EMPTY_STRING = new StringBuilder(0);
    private int TEXT_BUFFER_MAX = 8192;

    private int parseState = START_DOCUMENT;
    private Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

    public XMLStreamWalker(Reader reader)
    {
        if (reader == null)
            throw new IllegalArgumentException("XML reader is null");

        pullParser = PullParserUtil.newParser(reader);

    }

    public TreeEvent next() throws XerialException
    {
        if (parseState == END_DOCUMENT)
            return TreeEvent.getFinishEvent();

        if (!eventQueue.isEmpty())
            return eventQueue.removeFirst();

        try
        {
            parseState = pullParser.next();

            switch (parseState)
            {
            case START_DOCUMENT:
                eventQueue.add(TreeEvent.getInitEvent());
                break;
            case START_TAG:
            {
                textStack.addLast(EMPTY_STRING);
                String tagName = pullParser.getName();
                String immediateNodeValue = null;

                Deque<TreeEvent> startEventQueue = new ArrayDeque<TreeEvent>(pullParser.getAttributeCount() + 1);
                // read attributes
                for (int i = 0; i < pullParser.getAttributeCount(); i++)
                {
                    String attributeName = pullParser.getAttributeName(i);
                    String attributeValue = pullParser.getAttributeValue(i);

                    // assign the value attribute as a node value of the start tag 
                    if (attributeName.equals("value"))
                    {
                        immediateNodeValue = attributeValue;
                        continue;
                    }

                    startEventQueue.addLast(TreeEvent.newVisitEvent(attributeName, attributeValue));
                    startEventQueue.addLast(TreeEvent.newLeaveEvent(attributeName));
                }

                // push a new start tag event to the front of the queue
                startEventQueue.addFirst(TreeEvent.newVisitEvent(tagName, immediateNodeValue));
                eventQueue.addAll(startEventQueue);
            }
                break;
            case END_TAG:
            {
                if (textStack.getLast() == EMPTY_STRING)
                {
                    eventQueue.add(TreeEvent.newLeaveEvent(pullParser.getName()));
                }
                else
                {
                    if (!eventQueue.isEmpty() && eventQueue.getLast().event == EventType.VISIT)
                    {
                        eventQueue.removeLast();
                        eventQueue.add(TreeEvent.newVisitEvent(pullParser.getName(), createTextEvent(textStack
                                .getLast()).nodeValue));
                    }
                    else
                        eventQueue.add(createTextEvent(textStack.getLast()));
                    eventQueue.add(TreeEvent.newLeaveEvent(pullParser.getName()));
                }
                textStack.removeLast();
            }
                break;
            case TEXT:
            {
                String textData = pullParser.getText();
                StringBuilder textBuffer = textStack.getLast();

                if (textBuffer == EMPTY_STRING)
                {
                    textStack.removeLast();
                    textBuffer = new StringBuilder();
                    textStack.addLast(textBuffer);

                    if (textData.length() < TEXT_BUFFER_MAX)
                        textBuffer.append(textData);
                    else
                        eventQueue.add(createTextEvent(textBuffer));
                }
                else
                {
                    if (textBuffer.length() + textData.length() > TEXT_BUFFER_MAX)
                    {
                        // add the previous text data to the event queue
                        eventQueue.add(createTextEvent(textBuffer));

                        // replace the text buffer
                        textStack.removeLast();
                        textBuffer = new StringBuilder();
                        textStack.addLast(textBuffer);
                    }

                    textBuffer.append(textData);
                }
            }
                break;
            default:
                // do nothing
                break;
            }

        }
        catch (XmlPullParserException e)
        {
            throw new XerialException(XMLErrorCode.PARSE_ERROR, e);
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

        return next();
    }

    private TreeEvent createTextEvent(StringBuilder buffer)
    {
        return TreeEvent.newTextEvent(buffer.toString().trim());
    }

}
