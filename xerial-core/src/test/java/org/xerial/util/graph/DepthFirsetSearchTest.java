/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// UTGB Common Project
//
// DFSVisitorTest.java
// Since: May 15, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/test/org/utgenome/util/graph/DFSVisitorTest.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class DepthFirsetSearchTest
{

    AdjacencyList<String, String> graph;

    @Before
    public void setUp() throws Exception
    {
        graph = new AdjacencyList<String, String>();
        /*
         *  A->B -->C
         *  |  |^
         *  V  V|
         *  D<-E
         */
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "D");
        graph.addEdge("E", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "B");
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void runDFS()
    {
        DepthFirstSearch<String, String> dfs = new DepthFirstSearchBase<String, String>();
        dfs.run(graph, "A");
    }

    class MyDFSVisitor extends DepthFirstSearch<String, String>
    {
        Logger _logger = Logger.getLogger(DepthFirsetSearchTest.class);

        @Override
        protected void backEdge(Edge edge)
        {
            _logger.debug("back edge: " + toString(edge));
        }

        @Override
        protected void discoverNode(String node)
        {
            _logger.debug("discover: " + node);
        }

        @Override
        protected void examineEdge(Edge edge)
        {
            _logger.debug("examine edge: " + toString(edge));
        }

        @Override
        protected void finishNode(String node)
        {
            _logger.debug("finish: " + node);

        }

        @Override
        protected void forwardOrCrossEdge(Edge edge)
        {
            _logger.debug("forward or cross: " + toString(edge));

        }

        @Override
        protected void initializeNode(String node)
        {
            _logger.debug("initialize: " + node);

        }

        @Override
        protected void startNode(String node)
        {
            _logger.debug("start: " + node);

        }

        @Override
        protected void treeEdge(Edge edge)
        {
            _logger.debug("tree edge: " + toString(edge));
        }

    }

    @Test
    public void customDFS()
    {
        MyDFSVisitor dfs = new MyDFSVisitor();
        dfs.run(graph);
    }

}
