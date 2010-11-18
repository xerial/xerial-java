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
// SAXEventHandler.java
// Since: 2005/06/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.xml.pullparser;

import org.xerial.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;

/**
 * SAX Event Handler interface that works with XML pull parser
 * 
 * @author leo
 * 
 */
public interface SAXEventHandler
{
    public void startTag(XmlPullParser parser) throws XMLException;

    public void endTag(XmlPullParser parser) throws XMLException;

    public void text(XmlPullParser parser) throws XMLException;

    public void startDocument(XmlPullParser parser) throws XMLException;

    public void endDocument(XmlPullParser parser) throws XMLException;
}
