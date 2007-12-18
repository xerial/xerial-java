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
 * Pull Parserを使用しつつ、SAXEventHandlerで定義されるEventを発行する.
 * Event処理中にpull parserのnext() メソッド等parserの状態を変えられるようにするには、
 * keepParserStatusStableWhileHandlingSAXEvents　を　falseに設定すること。デフォルトではtrue(parserは動かせない）
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
     * 複数のSAXHandlerを同時に動かすときに使う
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
     * XML fileをparseする
     * @param xmlFileName 
     * @throws IOException ファイルの入力でエラー
     * @throws XMLParserException parserの生成に失敗したとき。
     * @throws XMLException invalidなXMLを読んだとき。
     */
    public void parse(String xmlFileName) throws IOException, XMLException
    {
        Reader reader = new BufferedReader(new FileReader(xmlFileName));
        parse(reader);
        reader.close();
    }
    
    /**
     * XML文書を xmlInputSourceから読み、eventに応じて、SAXEventHandler中のメソッドを呼び出す
     * @param xmlInputSource
     * @throws IOException ファイルの入力でエラー
     * @throws XMLParserException parserの生成に失敗したとき。
     * @throws XMLException invalidなXMLを読んだとき。
     */
    public void parse(Reader xmlInputSource) throws XMLException, IOException
    {
        XmlPullParser parser = PullParserUtil.newParser(xmlInputSource);
        this.parse(parser);
    }
    
    
    /**
     * 現在のpull parserの状態から、parsing をはじめる
     * @param xmlInputSource
     * @throws IOException ファイルの入力でエラー
     * @throws XMLException invalidなXMLを読んだとき。
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




