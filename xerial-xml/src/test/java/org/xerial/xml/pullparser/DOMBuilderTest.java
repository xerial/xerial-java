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
// XerialJ
//
// DOMBuilderTest.java
// Since: 2004/12/21
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.xml.pullparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import junit.framework.TestCase;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xerial.util.FileResource;
import org.xerial.xml.XMLException;
import org.xerial.xml.pullparser.DOMBuilder;
import org.xmlpull.v1.XmlPullParserException;

/**
 * @author leo
 *
 */
public class DOMBuilderTest extends TestCase
{
    DOMBuilder _builder;
    Reader _xmlReader;
    enum Tag { author, title, year }
    HashMap<String, Tag> _tagMap;
    
    // @see junit.framework.TestCase#setUp()
    protected void setUp() throws Exception
    {
        super.setUp();
        _builder = new DOMBuilder();
        _xmlReader = new BufferedReader(new InputStreamReader(FileResource.find(DOMBuilderTest.class, "booklist.xml").openStream()));
        _tagMap = new HashMap<String, Tag>();
        for(Tag tag : Tag.values())
        {
            _tagMap.put(tag.name(), tag);
        }
    }
    // @see junit.framework.TestCase#tearDown()
    protected void tearDown() throws Exception
    {
        super.tearDown();
        _xmlReader.close();
    }
    /*
     * Class under test for Element parse(Reader)
     */
    public void testParseReader() throws IOException
    {        
        try
        {
            Element element = _builder.parse(_xmlReader);
            assertEquals("booklist", element.getTagName());
            NodeList bookNodes = element.getElementsByTagName("book"); // retrieve book nodes by the document order
            assertEquals(2, bookNodes.getLength());
            Element book1 = (Element) bookNodes.item(0); 
            assertNotNull(book1);
            String isbn = book1.getAttribute("isbn");
            assertNotNull(isbn);
            assertEquals("1558607544", isbn);
            
            
            
        }
        catch(XMLException e)
        {
            fail(e.getMessage());
        }
        catch(XmlPullParserException e)
        {
            fail(e.getMessage());
        }

    }

    /*
     * Class under test for Element parse(XmlPullParser)
     */
    public void testParseXmlPullParser()
    {
    }

    public void testCreateQName()
    {
        
    }

}




