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

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.START_TAG;

import java.io.IOException;
import java.io.Reader;

import org.xerial.util.xml.XMLErrorCode;
import org.xerial.util.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Utilities for XML pull parser
 * 
 * @author leo
 * 
 */
public class PullParserUtil
{

    /**
     * Parse until the taget tag is found. When this method returns true, the
     * pull parser's cursor is on the START_TAG of the target
     * 
     * @param tagName
     *            the target
     * @param pullParser
     *            pull parser
     * @return true when the target tag is found, otherwise false
     * @throws IOException
     *             when failed to read XML data
     * 
     * @throws XMLException
     *             when parse error is found
     */
    static public boolean parseUntil(String tagName, XmlPullParser pullParser) throws XMLException, IOException
    {
        try
        {
            while (pullParser.next() != END_DOCUMENT)
            {
                int state = pullParser.getEventType();
                if (state == START_TAG)
                {
                    if (tagName.equals(pullParser.getName()))
                        return true; // found the target tag
                }
            }
            return false;
        }
        catch (XmlPullParserException e)
        {
            throw new XMLException(XMLErrorCode.PARSE_ERROR, e);
        }
    }

    /**
     * Generates a XML pull parser
     * 
     * @param xmlReader
     *            XML reader
     * 
     * @return an instance of the pull parser
     * @throws XMLException
     *             when failed to create XML pull parser
     * 
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
        catch (XmlPullParserException e)
        {
            throw new XMLException(XMLErrorCode.FAILED_TO_CREATE_XML_PARSER, e);
        }
    }

}
