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
// DTDToFDHandlerTest.java
// Since: Jul 24, 2007 4:20:07 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.amoeba;


import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.log.LogLevel;
import org.xerial.util.log.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.XMLReaderFactory;

public class DTDToFDHandlerTest
{
    XMLReader xmlReader;
    DefaultHandler2 handler = new DTDToFDHandler();
    Logger _logger = Logger.getLogger(DTDToFDHandlerTest.class); 
    
    
    @Before
    public void setUp() throws Exception
    {
        xmlReader = XMLReaderFactory.createXMLReader();

        xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", true);
        xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", true);

        xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
        xmlReader.setProperty("http://xml.org/sax/properties/declaration-handler", handler);
        xmlReader.setContentHandler(handler);
    }

    @After
    public void tearDown() throws Exception
    {}
    
    @Test
    public void parse() throws IOException, SAXException, URISyntaxException
    {
        xmlReader.parse(FileResource.find(DTDToFDHandlerTest.class, "xmark.xml").toURI().toString());
    }
    
    @Test 
    public void parseMAGEML() throws SAXException, URISyntaxException, IOException
    {
        try
        {
            xmlReader.parse(new URI("http://www.xerial.org/dtd/Iron_array.xml").toString());
        }
        catch (UnknownHostException e)
        {
            _logger.warn("network connection might not be present: " + e);
        }
    }
    
    

}
