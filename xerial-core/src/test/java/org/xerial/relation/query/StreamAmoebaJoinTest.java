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
// StreamAmoebaJoinTest.java
// Since: 2009/05/14 17:52:37
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation.query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.relation.DataType;
import org.xerial.relation.FD;
import org.xerial.relation.Node;
import org.xerial.relation.schema.Schema;
import org.xerial.relation.schema.SchemaBuilder;
import org.xerial.silk.SilkWalker;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class StreamAmoebaJoinTest
{
    private static Logger _logger = Logger.getLogger(StreamAmoebaJoinTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void query() throws Exception
    {
        QuerySet qs = new QuerySet();
        qs.addQueryTarget(new SchemaBuilder().add("coordinate").add("group").add("species").add("revision").add("name")
                .build());
        qs.addQueryTarget(new SchemaBuilder().add("coordinate").add("gene", DataType.STRUCT, FD.ONE_OR_MORE).build());
        qs.addQueryTarget(new SchemaBuilder().add("gene").add("id").add("name").add("start").add("end").add("sequence")
                .build());

        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, new AmoebaJoinHandler() {

            public void newAmoeba(Schema schema, Node n1, Node n2)
            {
                _logger.info(String.format("relation (%s, %s)", n1, n2));
            }

            public void leaveNode(Schema schema, Node node)
            {
                _logger.info(String.format("leave %s in %s", node, schema));
            }

            public void text(Schema schema, String nodeName, String text)
            {
                _logger.info(String.format("text %s in %s: %s", text, nodeName, schema));
            }
        });

        aj.sweep(new SilkWalker(FileResource.find(StreamAmoebaJoinTest.class, "sample.silk")));
    }
}
