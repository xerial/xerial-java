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
// PullParserUtil.java
// Since: 2005/01/11
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.pullparser;

import java.io.IOException;
import java.io.Reader;

import org.xerial.util.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import static org.xmlpull.v1.XmlPullParser.*;

/** XMLのpull parserを便利に使うためのユーティリティ群
 * @author leo
 *
 */
public class PullParserUtil
{

    /** 特定のtagにたどり着くまで、parseを進める
     * @param tagName 目標のtag
     * @param pullParser pull parser
     * @return 目的のtagが見つかればtrue, 見つからなければfalse。trueの時、
     * pull parserは、START_TAGのところにカーソルがあった状態になる
     * @throws XmlPullParserException
     * @throws IOException
     */
    static public boolean parseUntil(String tagName, XmlPullParser pullParser) throws XmlPullParserException, IOException
    {
        while(pullParser.next() != END_DOCUMENT)
        {
            int state = pullParser.getEventType();
            if(state == START_TAG)
            {
                if(tagName.equals(pullParser.getName()))
                    return true; // found the target tag
            }
        }
        return false;
    }
    
    /**
     * プルパーサの生成補助
     * @param xmlReader XMLを読み込むreader
     * @return pull parserのインスタンス
     * @throws XMLParserException parserの生成に失敗した時
     */
    static public XmlPullParser newParser(Reader xmlReader) throws XMLException
    {
        XmlPullParser parser;
        try
        {
            parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(xmlReader);
            return parser;
        }
        catch(XmlPullParserException e)
        {
            throw new XMLException(e);
        }
    }

}




