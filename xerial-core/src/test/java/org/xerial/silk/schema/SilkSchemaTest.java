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
//--------------------------------------j
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
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.query.AmoebaJoinHandlerBase;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.StreamAmoebaJoin;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.silk.SilkParser;
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
        SilkModule globalModule = schema.globalModule;
        assertNotNull(globalModule.module);
        assertEquals(1, globalModule.module.size());
        SilkModule m = globalModule.module.get(0);
        assertEquals("org.utgenome", m.name);

        // confirm classes

        assertNotNull(m.classDef);
        assertEquals(7, m.classDef.size());
        for (SilkClass c : m.classDef) {
            if (c.name.equals("Coordinate")) {
                assertNull(c.belongsTo);
            }
            else if (c.name.equals("Locus")) {
                assertEquals("Coordinate", c.belongsTo);
            }
            else if (c.name.equals("Gene")) {

            }
            else if (c.name.equals("Exon")) {
                assertEquals("Gene", c.belongsTo);
            }
            else if (c.name.equals("CDS")) {
                assertEquals("Gene", c.belongsTo);
            }
            else if (c.name.equals("Reference")) {

            }
            else if (c.name.equals("Read")) {
                assertEquals("Reference", c.belongsTo);
            }

        }

        // confirm relation
        //        assertNotNull(schema.relation);
        //        assertEquals(1, schema.relation.size());
        //        SilkRelation r = schema.relation.get(0);
        //        assertEquals("Alignment", r.name);
        //        assertEquals(2, r.attribute.size());

        _logger.info(Lens.toJSON(schema));

        //_logger.info(schema.toGraphviz());

    }

    @Test
    public void buildQuery() throws Exception {

        SilkSchema schema = SilkSchema.parse(FileResource.open(SilkSchemaTest.class, "read.silk"));
        QuerySet qs = schema.buildAmoebaJoinQuery();

        _logger.info(qs);

        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, new AmoebaJoinHandlerBase() {

            public void leaveNode(Schema schema, Node node) throws Exception {
                _logger.trace(String.format("leave %s in %s", node, schema));
            }

            public void newAmoeba(Schema schema, Node coreNode, Node attributeNode)
                    throws Exception {
                _logger.info(String.format("amoeba (%s, %s)", coreNode, attributeNode));
            }

            public void text(Schema schema, Node coreNode, Node textNode, String text)
                    throws Exception {
                _logger.trace(String.format("text (%s, %s:%s)", coreNode, textNode, text));
            }
        });

        aj.sweep(new SilkParser(FileResource.open(SilkSchemaTest.class, "../scaffold5001.silk")));

    }

}
