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
// ProgressiveSAXParser.java
// Since: 2005/06/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.pullparser;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.XMLInputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import static org.xmlpull.v1.XmlPullParser.*;

/**
 * SAXParsingの進み具合を自分でコントロールするためのクラス
 * 
 * <pre>
 * XMLInputSource xmlSource = new XMLInputSource("booklist.xml");
 * ProgressiveSAXParser parser = new ProgressiveSAXParser(handler, xmlSource);
 * 
 * int state;
 * while((state = parser.parseStep()) != XmlPullParser.END_DOCUMENT)
 * {}
 * 
 * </pre>
 * 
 * @author leo
 * 
 */
public class ProgressiveSAXParser
{
    private Vector<SAXEventHandler> _handlerList = new Vector<SAXEventHandler>();
    private boolean _keepParserStatusWhileHandlingSAXEvents = true;

    private XMLInputSource _inputSource = null;

    private XmlPullParser _parser = null;

    
    
    /**
     * @throws XMLParserException 
     * 
     */
    public ProgressiveSAXParser(SAXEventHandler handler, XMLInputSource inputSource) throws XMLException
    {
        _handlerList.add(handler);
        setXMLInputSource(inputSource);
    }

    public ProgressiveSAXParser(List<SAXEventHandler> handlerList, XMLInputSource inputSource) throws XMLException
    {
        for (SAXEventHandler handler : handlerList)
            _handlerList.add(handler);
        
        setXMLInputSource(inputSource);
    }
    
    private void enablePullParsingWhileHandlingEvents()
    {
        _keepParserStatusWhileHandlingSAXEvents = false;
    }

    private void setXMLInputSource(XMLInputSource inputSource) throws XMLException
    {
        _inputSource = inputSource;
        _parser = PullParserUtil.newParser(_inputSource.getReader());
        _parser = _keepParserStatusWhileHandlingSAXEvents ? new ParseContext(_parser) : _parser;
    }


    
    
    public int parseStep() throws Exception, IOException
    {
        assert _parser != null;
        try
        {
            int state = _parser.next();
            switch (state)
            {
            case START_TAG:
                for (SAXEventHandler handler : _handlerList)
                    handler.startTag(_parser);
                break;
            case END_TAG:
                break;
            case TEXT:
                for (SAXEventHandler handler : _handlerList)
                    handler.text(_parser);
                break;
            case END_DOCUMENT:
                for (SAXEventHandler handler : _handlerList)
                    handler.endDocument(_parser);
                break;
            case START_DOCUMENT:
                for (SAXEventHandler handler : _handlerList)
                    handler.startDocument(_parser);
                break;
            }

            return state;
        }
        catch (XmlPullParserException e)
        {
            throw new XMLException(e);
        }
    }

}
