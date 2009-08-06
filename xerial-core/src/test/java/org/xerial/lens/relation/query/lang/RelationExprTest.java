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
package org.xerial.lens.relation.query.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.Lens;
import org.xerial.util.log.Logger;

public class RelationExprTest {
    private static Logger _logger = Logger.getLogger(RelationExprTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void parseTest() throws Exception {
        RelationExpr e1 = RelationExpr.parse("A(B, C)");
        _logger.info(Lens.toJSON(e1));
    }
}
