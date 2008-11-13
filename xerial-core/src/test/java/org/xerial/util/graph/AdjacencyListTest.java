/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// AdjacencyListTest.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

/**
 * @author leo
 * 
 */
public class AdjacencyListTest
{
    private static Logger  _logger = Logger.getLogger(AdjacencyListTest.class);

    Graph<Integer, String> al;

    @Before
    public void setUp() throws Exception
    {
        al = new AdjacencyList<Integer, String>();
        /*
         *  0->1 -->2
         *  |  |^
         *  V  V|
         *  3<-4
         */
        al.addEdge(0, 1);
        al.addEdge(1, 2);
        al.addEdge(0, 3);
        al.addEdge(4, 3);
        al.addEdge(1, 4);
        al.addEdge(4, 1);
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testAddVertex()
    {
        assertEquals(5, al.getNumNodes());
        al.addNode(6);
        assertEquals(6, al.getNumNodes());
    }

    private Edge edge(int src, int dest)
    {
        return new Edge(al.getNodeID(src), al.getNodeID(dest));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddEdge()
    {
        Collection<Edge> edgeList = al.getOutEdgeSet(0);
        assertEquals(2, edgeList.size());
        assertTrue(edgeList.contains(edge(0, 1)));
        assertTrue(edgeList.contains(edge(0, 3)));

        Collection<Edge> edgeList1 = al.getOutEdgeSet(1);
        assertEquals(2, edgeList1.size());
        assertTrue(edgeList1.contains(edge(1, 2)));
        assertTrue(edgeList1.contains(edge(1, 4)));
    }

    @Test
    public void testHasEdge()
    {
        assertTrue(al.hasEdge(edge(0, 1)));
        assertTrue(al.hasEdge(edge(1, 2)));
        assertTrue(al.hasEdge(edge(0, 3)));
        assertTrue(al.hasEdge(edge(4, 3)));
        assertTrue(al.hasEdge(edge(1, 4)));
        assertTrue(al.hasEdge(edge(4, 1)));

        assertFalse(al.hasEdge(edge(1, 1)));
        assertFalse(al.hasEdge(edge(2, 1)));

    }

    @Test
    public void testHasNode()
    {
        for (int i = 0; i < 5; i++)
            assertTrue(al.hasNode(i));
        for (int i = 5; i < 10; i++)
            assertFalse(al.hasNode(i));
    }

    @Test
    public void testVertexSet()
    {
        Collection<Integer> nodeList = al.getNodeLabelSet();

        assertTrue(nodeList.contains(0));
        assertTrue(nodeList.contains(1));
        assertTrue(nodeList.contains(2));
        assertTrue(nodeList.contains(3));
        assertTrue(nodeList.contains(4));
        assertFalse(nodeList.contains(5));

    }

    @Test
    public void testDestNodeSet()
    {
        Collection<Integer> s = al.getDestNodeIDSetOf(al.getNodeID(0));
        assertEquals(2, s.size());
        assertTrue(s.contains(al.getNodeID(1)));
        assertTrue(s.contains(al.getNodeID(3)));
    }

    @Test
    public void testSourceNodeSet()
    {
        Collection<Integer> s = al.getSourceNodeIDSetOf(al.getNodeID(1));

        assertEquals(2, s.size());
        assertTrue(s.contains(al.getNodeID(0)));
        assertTrue(s.contains(al.getNodeID(4)));

    }

    @Test
    public void testOutEdgeList()
    {
        Collection<Edge> l = al.getOutEdgeSet(4);
        assertEquals(2, l.size());

        assertTrue(l.contains(edge(4, 3)));
        assertTrue(l.contains(edge(4, 1)));
    }

    @Test
    public void testInEdgeList()
    {
        Collection<Edge> l = al.getInEdgeSet(3);
        assertEquals(2, l.size());
        assertTrue(l.contains(edge(0, 3)));
        assertTrue(l.contains(edge(4, 3)));
    }

    @Test
    public void testClear()
    {
        al.clear();
        assertEquals(0, al.getNumNodes());
    }

    @Test
    public void testSetEdge()
    {
        Edge e = edge(0, 3);
        assertNull(al.getEdgeLabel(e));

        al.setEdgeLabel(e, "hello");
        assertEquals("hello", al.getEdgeLabel(e));
    }

    @Test
    public void testToString()
    {
        _logger.debug(al.toString());
    }

}
