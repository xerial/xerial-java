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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.relation.DataType;
import org.xerial.relation.FD;
import org.xerial.relation.Node;
import org.xerial.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.relation.schema.Schema;
import org.xerial.relation.schema.SchemaBuilder;
import org.xerial.silk.SilkWalker;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitorBase;
import org.xerial.util.tree.TreeWalker;

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
        QuerySetBuilder qs = new QuerySetBuilder();
        qs.addQueryTarget(new SchemaBuilder().add("coordinate").add("group").add("species").add("revision").add("name")
                .add("sequence").build());
        qs.addQueryTarget(new SchemaBuilder().add("coordinate").add("gene", DataType.STRUCT, FD.ONE_OR_MORE).build());
        qs.addQueryTarget(new SchemaBuilder().add("gene").add("id").add("name").add("start").add("end").add("sequence")
                .build());

        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs.build(), new AmoebaJoinHandlerBase() {

            public void newAmoeba(Schema schema, Node n1, Node n2)
            {
                _logger.debug(String.format("relation (%s, %s)", n1, n2));
            }

            public void leaveNode(Schema schema, Node node)
            {
                _logger.trace(String.format("leave %s in %s", node, schema));
            }

            public void text(Schema schema, Node contextNode, String nodeName, String text)
            {
                _logger.debug(String.format("text %s:%s of %s in %s", nodeName, text, contextNode, schema));
            }
        });

        aj.sweep(new SilkWalker(FileResource.find(StreamAmoebaJoinTest.class, "sample.silk")));
    }

    @Test
    public void amoebaTest() throws Exception
    {
        QuerySetBuilder qs = new QuerySetBuilder();
        qs.addQueryTarget(new SchemaBuilder().add("coordinate").add("revision").build());

        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs.build(), new AmoebaJoinHandlerBase() {

            int count = 0;

            public void newAmoeba(Schema schema, Node n1, Node n2)
            {
                _logger.debug(String.format("relation (%s, %s)", n1, n2));
                count++;
            }

            public void finish()
            {
                assertEquals(2, count);
            }

        });

        aj.sweep(new SilkWalker(FileResource.find(StreamAmoebaJoinTest.class, "gene.silk")));

    }

    @Test
    public void loadScaffold1() throws Exception
    {
        QuerySet qs = new QuerySetBuilder().build();
        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, new AmoebaJoinHandlerBase());
        StopWatch sw = new StopWatch();
        aj.sweep(new SilkWalker(FileResource.find(StreamAmoebaJoinTest.class, "../../silk/scaffold1.silk")));
        _logger.info("time: " + sw.getElapsedTime());
    }

    @Test
    public void silkWalkPerformance() throws Exception
    {
        TreeWalker walker = new SilkWalker(FileResource.find(StreamAmoebaJoinTest.class, "../../silk/scaffold1.silk"));
        StopWatch sw = new StopWatch();
        walker.walk(new TreeVisitorBase());
        _logger.info("time: " + sw.getElapsedTime());
    }

}
