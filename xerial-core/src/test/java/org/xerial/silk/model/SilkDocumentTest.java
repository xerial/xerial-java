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
// SilkDocumentTest.java
// Since: 2009/12/07 22:42:19
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class SilkDocumentTest {

    private static Logger _logger = Logger.getLogger(SilkDocumentTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testParse() throws Exception {
        SilkDocument doc = SilkDocument.parse(FileResource.find(SilkDocumentTest.class,
                "sample.silk"));
        _logger.debug(doc.toSilk());
    }

}
