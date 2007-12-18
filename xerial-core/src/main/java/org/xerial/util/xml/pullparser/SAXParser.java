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

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import org.xerial.util.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


import static org.xmlpull.v1.XmlPullParser.*;

/**
 * Pull Parser���g�p���ASAXEventHandler�Œ�`�����Event�𔭍s����.
 * Event��������pull parser��next() ���\�b�h��parser�̏�Ԃ�ς�����悤�ɂ���ɂ́A
 * keepParserStatusStableWhileHandlingSAXEvents�@���@false�ɐݒ肷�邱�ƁB�f�t�H���g�ł�true(parser�͓������Ȃ��j
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
     * ������SAXHandler�𓯎��ɓ������Ƃ��Ɏg��
     * @param handlerList
     */
    public SAXParser(List<SAXEventHandler> handlerList, boolean keepParserStatusStableWhileHandlingSaxEvents)
    {
        for(SAXEventHandler handler : handlerList)
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
        if(handlerIndex != -1 && handlerIndex < _handlerList.size())        
            _handlerList.remove(handlerIndex);
    }
        
    
    /**
     * XML file��parse����
     * @param xmlFileName 
     * @throws IOException �t�@�C���̓��͂ŃG���[
     * @throws XMLParserException parser�̐����Ɏ��s�����Ƃ��B
     * @throws XMLException invalid��XML��ǂ񂾂Ƃ��B
     */
    public void parse(String xmlFileName) throws IOException, XMLException
    {
        Reader reader = new BufferedReader(new FileReader(xmlFileName));
        parse(reader);
        reader.close();
    }
    
    /**
     * XML������ xmlInputSource����ǂ݁Aevent�ɉ����āASAXEventHandler���̃��\�b�h���Ăяo��
     * @param xmlInputSource
     * @throws IOException �t�@�C���̓��͂ŃG���[
     * @throws XMLParserException parser�̐����Ɏ��s�����Ƃ��B
     * @throws XMLException invalid��XML��ǂ񂾂Ƃ��B
     */
    public void parse(Reader xmlInputSource) throws XMLException, IOException
    {
        XmlPullParser parser = PullParserUtil.newParser(xmlInputSource);
        this.parse(parser);
    }
    
    
    /**
     * ���݂�pull parser�̏�Ԃ���Aparsing ���͂��߂�
     * @param xmlInputSource
     * @throws IOException �t�@�C���̓��͂ŃG���[
     * @throws XMLException invalid��XML��ǂ񂾂Ƃ��B
     */
    public void parse(XmlPullParser p) throws XMLException, IOException
    {
        XmlPullParser parser = _keepParserStatusStableWhileHandlingSAXEvents ? new ParseContext(p) : p;
        
        try
        {
            if(p.getEventType() == START_DOCUMENT)
            {
                for(SAXEventHandler handler : _handlerList)
                    handler.startDocument(parser);
            }
            
            int state;
            while((state = p.next()) != END_DOCUMENT)
            {
                //int handlerIndex = 0;
                switch(state)
                {
                case START_TAG:
                    for(SAXEventHandler handler : _handlerList)
                        handler.startTag(parser);
                    break;
                case END_TAG:
                    for(SAXEventHandler handler : _handlerList)
                        handler.endTag(parser);
                    break;
                case TEXT:
                    for(SAXEventHandler handler : _handlerList)
                        handler.text(parser);
                    break;
                }
            }
            for(SAXEventHandler handler : _handlerList)
                handler.endDocument(parser);
        }
        catch(XmlPullParserException e)
        {
            throw new XMLException(e);
        }
        
    }


}




