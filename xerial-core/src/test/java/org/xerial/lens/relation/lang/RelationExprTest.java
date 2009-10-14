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
// RelationExprTest.java
// Since: Aug 6, 2009 11:36:09 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.lang.RelationExpr;
import org.xerial.util.log.Logger;

public class RelationExprTest {
    private static Logger _logger = Logger.getLogger(RelationExprTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public RelationExpr parse(String query) throws Exception {
        RelationExpr e = RelationExpr.parse(query);
        _logger.info(Lens.toSilk(e));
        return e;
    }

    @Test
    public void q1() throws Exception {
        parse("A(B, C)");
    }

    @Test
    public void q2() throws Exception {
        parse("book(author, isbn10 as isbn)");
    }

    @Test
    public void q3() throws Exception {
        RelationExpr e = parse("entry(dc.subject:sigmod09, link(rel:related, href), summary)");
        _logger.debug(e.toSchema());
        _logger.debug(e.buildQuerySet());
    }
}
