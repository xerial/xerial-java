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
//-----------------------------------
// XerialJ Project
// 
// XMLGeneratorTest.java 
// Since: 2005/01/16
//
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.xerial.util.log.Logger;
import org.xerial.xml.XMLAttribute;
import org.xerial.xml.XMLGenerator;

/**
 * @author leo
 * 
 */
public class XMLGeneratorTest extends TestCase
{

    private static Logger _logger = Logger.getLogger(XMLGeneratorTest.class);

    public void testOut()
    {
        StringWriter writer = new StringWriter();
        XMLGenerator xout = new XMLGenerator(writer);
        xout.startTag("booklist");
        xout.startTag("book", new XMLAttribute().add("isbn", "232423423").add("year", 1343));
        xout.selfCloseTag("memo");
        xout.startTag("author");
        xout.text("Peter Buneman");
        xout.endTag();
        xout.startTag("author");
        xout.text("somebody");
        xout.text(" you know");
        xout.endTag();
        xout.endTag();
        xout.endTag();

        xout.endDocument();

        _logger.debug(writer.toString());
    }
}
