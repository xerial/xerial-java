/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// DTDTest.java
// Since: Sep 28, 2009 3:32:54 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.xml.dtd;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class DTDTest
{

    private static Logger _logger = Logger.getLogger(DTDTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testParse() throws XerialException, IOException {
        DTD d = DTD.parse(FileResource.open(DTDTest.class, "auction.dtd"));
    }

    @Test
    public void testParseDBLP() throws XerialException, IOException {
        DTD d = DTD.parse(FileResource.open(DTDTest.class, "dblp.dtd"));
    }

    @Test
    public void testParseSIGMODRecord() throws XerialException, IOException {
        DTD d = DTD.parse(FileResource.open(DTDTest.class, "SigmodRecord.dtd"));
    }
}
