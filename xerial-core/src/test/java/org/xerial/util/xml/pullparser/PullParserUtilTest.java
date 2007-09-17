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
// PullParserUtilTest.java
// Since: 2005/01/11
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.pullparser;

import java.io.FileReader;
import java.io.IOException;

import org.xerial.util.FileResource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import junit.framework.TestCase;

/**
 * @author leo
 *
 */
public class PullParserUtilTest extends TestCase
{
    XmlPullParser parser;
    
    protected void setUp() throws Exception
    {
        parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(FileResource.open(PullParserUtilTest.class, "booklist.xml"));
    }
    protected void tearDown() throws Exception
    {

    }
    
    public void testParseUntil() throws XmlPullParserException, IOException
    {   
        int bookCount = 0;
        while(PullParserUtil.parseUntil("book", parser))
        {
            bookCount++;
            assertEquals("book", parser.getName());
        }
        assertEquals(2, bookCount);
    }
}




