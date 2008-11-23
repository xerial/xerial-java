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
// GraphHelperTest.java
// Since: 2008/11/13 10:34:26
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphHelperTest
{

    @Test
    public void testTransitiveClosure()
    {
        Graph<String, String> graph = new AdjacencyList<String, String>();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("D", "C");

        // A -> B
        //      |
        //      v
        //      C <- D

        Graph<String, String> closure = GraphHelper.transitiveClosure(graph);
        // A ->B
        //  \  |
        //   \ v
        //   _|C <- D

        assertEquals(4, closure.getEdgeSet().size());
        assertTrue(closure.hasEdge("A", "B"));
        assertTrue(closure.hasEdge("B", "C"));
        assertTrue(closure.hasEdge("A", "C"));
        assertTrue(closure.hasEdge("D", "C"));
        assertTrue(!closure.hasEdge("A", "D"));
        assertTrue(!closure.hasEdge("B", "D"));
        assertTrue(!closure.hasEdge("C", "D"));

        assertEquals(3, graph.getEdgeSet().size());
        assertTrue(graph.hasEdge("A", "B"));
        assertTrue(graph.hasEdge("B", "C"));
        assertTrue(!graph.hasEdge("A", "C"));
        assertTrue(graph.hasEdge("D", "C"));
    }

    @Test
    public void testTransitiveClosure2()
    {
        Graph<String, String> graph = new AdjacencyList<String, String>();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        // A       D -> E
        //  \     /
        //   B-->C

        Graph<String, String> closure = GraphHelper.transitiveClosure(graph);

        assertEquals(10, closure.getEdgeSet().size());
        assertTrue(closure.hasEdge("A", "B"));
        assertTrue(closure.hasEdge("A", "C"));
        assertTrue(closure.hasEdge("A", "D"));
        assertTrue(closure.hasEdge("A", "E"));
        assertTrue(closure.hasEdge("B", "C"));
        assertTrue(closure.hasEdge("B", "D"));
        assertTrue(closure.hasEdge("B", "E"));
        assertTrue(closure.hasEdge("C", "D"));
        assertTrue(closure.hasEdge("C", "E"));
        assertTrue(closure.hasEdge("D", "E"));

        assertTrue(!closure.hasEdge("E", "A"));
        assertTrue(!closure.hasEdge("E", "B"));
        assertTrue(!closure.hasEdge("E", "C"));
        assertTrue(!closure.hasEdge("E", "D"));
        assertTrue(!closure.hasEdge("D", "A"));
        assertTrue(!closure.hasEdge("D", "B"));
        assertTrue(!closure.hasEdge("D", "C"));
        assertTrue(!closure.hasEdge("C", "B"));
        assertTrue(!closure.hasEdge("C", "A"));
        assertTrue(!closure.hasEdge("B", "A"));

    }

}
