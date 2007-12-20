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
// DOMUtilTest.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.w3c.dom.Element;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;
import org.xerial.util.xml.dom.DOMUtil;
import org.xerial.util.xml.pullparser.DOMBuilder;
import org.xmlpull.v1.XmlPullParserException;




import junit.framework.TestCase;

/**
 * @author leo
 *
 */
public class DOMUtilTest extends TestCase
{
    private static Logger _logger = Logger.getLogger(DOMUtilTest.class);
    
    /* <booklist>
     *  <book isbn="isbn">
     *    <title> some title </title>
     *    <author> author A </author>
     *    <author> author B </author>
     *    <publisher> publisher name </publisher>
     *    <year> 2004 </year>
     *  </book>
     *  <book isbn="13214dfa">
     *    <title> </title>
     *    <author> </author>
     *  </book>
     * </booklist>
     */
    class BookXMLBean 
    {
        String[] author;
        String title;
        String isbn;
        String publisher;
        int year;
    }

    class BookListXMLBean
    {
        BookXMLBean[] book;
        

        public BookXMLBean[] getBook()
        {
            return book;
        }
        public void setBook(BookXMLBean[] book)
        {
            this.book = book;
        }
    }

    
    
    
    public void testGetTextContentMap() throws FileNotFoundException, IOException, XMLException 
    {
    	HashMap<String, String> cMap = DOMUtil.getTextContentMap(FileResource.find(DOMUtilTest.class, "domtest.xml").openStream());
    	for(String key : cMap.keySet())
    	{
    		_logger.debug(key + "\t" + cMap.get(key));
    	}
    }
    
    
    public void testTextContent() throws XMLException, XmlPullParserException, IOException
    {
        DOMBuilder builder = new DOMBuilder();
        Element element = builder.parse(new InputStreamReader(FileResource.find(DOMUtilTest.class, "simple.xml").openStream()));
        _logger.debug(DOMUtil.getText(element));
    }
    
}




