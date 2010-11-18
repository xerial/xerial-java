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
// XPathExprTest.java
// Since: Sep 29, 2009 2:45:48 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkLens;
import org.xerial.util.log.Logger;

public class XPathExprTest {

    private static Logger _logger = Logger.getLogger(XPathExprTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public void parse(String expr) throws XerialException {
        XPathExpr e = XPathExpr.parse(expr);
        _logger.debug(String.format("%s:%s", expr, SilkLens.toSilk(e)));
    }

    @Test
    public void testParse() throws Exception {

        parse("//A");
        parse("/A");
        parse("/A/B");
        parse("//A/B//C");
        parse("//A[B]");
        parse("//A[B][C]");
        parse("book[//order]//title");
    }

    @Test
    public void testPredicate() throws Exception {
        parse("A[B]");
    }
}
