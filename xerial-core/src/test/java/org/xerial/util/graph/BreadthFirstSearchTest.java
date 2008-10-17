/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// BreadthFirstSearchTest.java
// Since: Oct 17, 2008 5:41:48 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class BreadthFirstSearchTest
{
    AdjacencyList<String, String> graph;

    @Before
    public void setUp() throws Exception
    {
        graph = new AdjacencyList<String, String>();
        /*
         *  A->B -->C
         *  | ^|^
         *  V/ V|
         *  D<-E
         */
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "D");
        graph.addEdge("E", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "B");
        graph.addEdge("D", "B");
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void runDFS()
    {
        BreadthFirstSearch<String, String> dfs = new BreadthFirstSearchBase<String, String>();
        dfs.run(graph, "A");
    }

    class MyBFSVisitor extends BreadthFirstSearchBase<String, String>
    {
        Logger _logger = Logger.getLogger(DepthFirsetSearchTest.class);

        @Override
        protected void backEdge(Edge edge)
        {
            _logger.debug("back edge: " + edge);
        }

        @Override
        protected void discoverNode(String node)
        {
            _logger.debug("discover: " + node);
        }

        @Override
        protected void examineEdge(Edge edge)
        {
            _logger.debug("examine edge: " + edge);
        }

        @Override
        protected void finishNode(String node)
        {
            _logger.debug("finish: " + node);

        }

        @Override
        protected void forwardOrCrossEdge(Edge edge)
        {
            _logger.debug("forward or cross: " + edge);

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
            _logger.debug("tree edge: " + edge);
        }

    }

    @Test
    public void customDFS()
    {
        MyBFSVisitor dfs = new MyBFSVisitor();
        dfs.run(graph);
    }

}
