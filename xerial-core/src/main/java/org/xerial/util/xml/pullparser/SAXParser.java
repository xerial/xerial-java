/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// XerialJ Project
//
// SAXParser.java
// Since: 2005/06/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.pullparser;

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.START_TAG;
import static org.xmlpull.v1.XmlPullParser.TEXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Vector;

import org.xerial.util.xml.XMLErrorCode;
import org.xerial.util.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Imitate the behaviour of the SAX handler using XML pull parser.
 * 
 * To change the parser state (e.g. by using next(), etc.), you have to set
 * keepParserStatusStableWhileHandlingSAXEventsÅ@to false (the default is true,
 * i.e. users cannot change the parser state. No next() invocation is allowed. )
 * 
 * @author leo
 * 
 */
public class SAXParser
{
    private Vector<SAXEventHandler> _handlerList = new Vector<SAXEventHandler>();
    private boolean _keepParserStatusStableWhileHandlingSAXEvents = true;

    /**
     * 
     */
    public SAXParser(SAXEventHandler handler)
    {
        this(handler, true);
    }

    public SAXParser(SAXEventHandler handler, boolean keepParserStatusStableWhileHandlingSAXEvents)
    {
        _handlerList.add(handler);
        _keepParserStatusStableWhileHandlingSAXEvents = keepParserStatusStableWhileHandlingSAXEvents;
    }

    /**
     * Creates SAX parser with multiple event handlers
     * 
     * @param handlerList
     *            a list of SAX handlers
     */
    public SAXParser(List<SAXEventHandler> handlerList, boolean keepParserStatusStableWhileHandlingSaxEvents)
    {
        for (SAXEventHandler handler : handlerList)
        {
            _handlerList.add(handler);
        }
        _keepParserStatusStableWhileHandlingSAXEvents = keepParserStatusStableWhileHandlingSaxEvents;
    }

    public SAXParser(List<SAXEventHandler> handlerList)
    {
        this(handlerList, true);
    }

    public void addHandler(SAXEventHandler handler)
    {
        this.addHandler(handler);
    }

    public void removeHandler(SAXEventHandler handler)
    {
        int handlerIndex = _handlerList.indexOf(handler);
        this.removeHandler(handlerIndex);
    }

    public void removeHandler(int handlerIndex)
    {
        if (handlerIndex != -1 && handlerIndex < _handlerList.size())
            _handlerList.remove(handlerIndex);
    }

    /**
     * Parse the given XML file
     * 
     * @param xmlFileName
     * @throws IOException
     *             when failed to read a file
     * @throws XMLException
     * @throws XMLParserException
     *             when failed to produce XML parser instance
     * @throws XMLException
     *             when reading invalid XML data
     */
    public void parse(String xmlFileName) throws IOException, XMLException
    {
        Reader reader = new BufferedReader(new FileReader(xmlFileName));
        parse(reader);
        reader.close();
    }

    /**
     * Read the input XML data, and produce SAX events, which will be caught by
     * SAX event Handlers
     * 
     * @param xmlInputSource
     * @throws IOException
     *             file I/O errro
     * 
     * @throws XMLParserException
     *             when failed to produce PullParser Instance
     * 
     * @throws XMLException
     *             invalid XML data format
     * 
     */
    public void parse(Reader xmlInputSource) throws IOException, XMLException
    {
        XmlPullParser parser = PullParserUtil.newParser(xmlInputSource);
        this.parse(parser);
    }

    /**
     * resume parsing
     * 
     * @param xmlInputSource
     * @throws IOException
     * 
     * @throws XMLException
     *             when invalid XML data is given
     * 
     */
    public void parse(XmlPullParser p) throws IOException, XMLException
    {
        XmlPullParser parser = _keepParserStatusStableWhileHandlingSAXEvents ? new ParseContext(p) : p;

        try
        {
            if (p.getEventType() == START_DOCUMENT)
            {
                for (SAXEventHandler handler : _handlerList)
                    handler.startDocument(parser);
            }

            int state;
            while ((state = p.next()) != END_DOCUMENT)
            {
                //int handlerIndex = 0;
                switch (state)
                {
                case START_TAG:
                    for (SAXEventHandler handler : _handlerList)
                        handler.startTag(parser);
                    break;
                case END_TAG:
                    for (SAXEventHandler handler : _handlerList)
                        handler.endTag(parser);
                    break;
                case TEXT:
                    for (SAXEventHandler handler : _handlerList)
                        handler.text(parser);
                    break;
                }
            }
            for (SAXEventHandler handler : _handlerList)
                handler.endDocument(parser);
        }
        catch (XmlPullParserException e)
        {
            throw new XMLException(XMLErrorCode.PARSE_ERROR, e);
        }

    }

}
