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
// IntervalIndexerTest.java
// Since: 2005/09/09 14:08:38
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml.index;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;
import org.xerial.xml.XMLAttribute;
import org.xerial.xml.XMLGenerator;
import org.xerial.xml.index.IntervalIndexer;
import org.xerial.xml.index.LWIndexWriter;
import org.xerial.xml.pullparser.SAXParser;

public class IntervalIndexerTest
{
    private Reader xmlSource;
    private static Logger _logger = Logger.getLogger(IntervalIndexerTest.class);

    @Before
    public void setUp()
    {
        // prepare an XML document
        StringWriter xmlWriter = new StringWriter();
        XMLGenerator xout = new XMLGenerator(xmlWriter);
        xout.startTag("booklist");
        xout.startTag("book", new XMLAttribute().add("isbn", "20424142342")).startTag("author").element("first-name",
                "Peter").element("last-name", "Buneman").endTag().element("author",
                new XMLAttribute().add("id", "3214"), "leoleo").element("year", "2005").startTag("publisher").element(
                "name", "Morgan-Kaufmann").endTag().endTag();
        xout.startTag("book").startTag("authors").startTag("author").element("id", "4234").text("taro").endTag()
                .element("author", "yui").endTag().endTag();

        xout.endTag();
        xout.endDocument();
        xout.flush();

        xmlSource = new BufferedReader(new StringReader(xmlWriter.getBuffer().toString()));
    }

    @Test
    public void testOutput() throws Exception
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IntervalIndexer indexer = new IntervalIndexer(new LWIndexWriter(out));
        SAXParser parser = new SAXParser(indexer);

        parser.parse(xmlSource);

        _logger.debug(out.toString());
    }
}
