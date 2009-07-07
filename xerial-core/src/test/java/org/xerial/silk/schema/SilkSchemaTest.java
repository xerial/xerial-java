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
// SilkSchemaTest.java
// Since: Jul 3, 2009 3:31:38 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.Lens;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class SilkSchemaTest {

    private static Logger _logger = Logger.getLogger(SilkSchemaTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void parse() throws Exception {
        SilkSchema schema = SilkSchema
                .parse(FileResource.open(SilkSchemaTest.class, "schema.silk"));

        // confirm module
        assertNotNull(schema.module);
        assertEquals(1, schema.module.size());
        SilkModule m = schema.module.get(0);
        assertEquals("org.utgenome", m.name);

        // confirm classes

        assertNotNull(m.classDef);
        assertEquals(7, m.classDef.size());
        for (SilkClass c : m.classDef) {
            if (c.name.equals("Coordinate")) {

            }
            else if (c.name.equals("Locus")) {

            }
            else if (c.name.equals("Gene")) {

            }
            else if (c.name.equals("Exon")) {

            }
            else if (c.name.equals("CDS")) {

            }
            else if (c.name.equals("Reference")) {

            }
            else if (c.name.equals("Read")) {

            }

        }

        // confirm relation
        //        assertNotNull(schema.relation);
        //        assertEquals(1, schema.relation.size());
        //        SilkRelation r = schema.relation.get(0);
        //        assertEquals("Alignment", r.name);
        //        assertEquals(2, r.attribute.size());

        _logger.info(Lens.toJSON(schema));

        _logger.info(schema.toGraphviz());

    }

}
