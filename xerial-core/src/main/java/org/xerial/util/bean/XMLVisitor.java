/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XMLVisitor.java
// Since: Dec 18, 2007 11:27:39 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.IOException;
import java.io.Reader;

import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xerial.util.xml.pullparser.SAXEventHandler;
import org.xerial.util.xml.pullparser.SAXParser;
import org.xerial.util.xml.pullparser.XMLPullParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Visitor model for XML data
 * @author leo
 *
 */
public class XMLVisitor implements TreeVisitor, SAXEventHandler
{
    private final SAXParser parser;
    
    public XMLVisitor() throws XMLException
    {
        this.parser = new SAXParser(this);
    }
    
    public void parse(Reader xmlDataReader) throws XMLException, IOException
    {
        parser.parse(xmlDataReader);
    }
    
    public void foundText(String text)
    {
    // TODO Auto-generated method stub

    }

    public void leaveNode(String nodeName)
    {
    // TODO Auto-generated method stub

    }

    public void visitNode(String nodeName)
    {
        // TODO Auto-generated method stub

    }


    public void finish()
    {
        // TODO Auto-generated method stub
        
    }




    public void init()
    {
        // TODO Auto-generated method stub
        
    }




    public void endDocument(XmlPullParser parser) throws XMLException
    {
        finish();
    }

    public void endTag(XmlPullParser parser) throws XMLException
    {
        leaveNode(parser.getName());
    }

    public void startDocument(XmlPullParser parser) throws XMLException
    {
        init();
    }


    public void startTag(XmlPullParser parser) throws XMLException
    {
        visitNode(parser.getName());
    }


    public void text(XmlPullParser parser) throws XMLException
    {
        foundText(parser.getText());
    }

}
