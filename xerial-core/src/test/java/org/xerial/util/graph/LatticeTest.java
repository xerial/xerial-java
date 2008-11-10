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
// LatticeTest.java
// Since: Nov 10, 2008 12:46:24 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;

public class LatticeTest
{
    private static Logger _logger = Logger.getLogger(LatticeTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void latticeCursor()
    {
        Lattice<String> lattice = new Lattice<String>();
        LatticeNode<String> emptyNode = lattice.emptyNode();
        LatticeNode<String> aNode = emptyNode.next("A");

        assertTrue(aNode.contains("A"));
        assertFalse(aNode.contains("B"));
        assertFalse(aNode.contains("B")); // double check

        LatticeNode<String> abNode = aNode.next("B");
        assertTrue(abNode.contains("A"));
        assertTrue(abNode.contains("B"));
        assertFalse(abNode.contains("C"));

        LatticeNode<String> acNode = aNode.next("C");
        assertTrue(acNode.contains("A"));
        assertTrue(acNode.contains("C"));
        assertFalse(acNode.contains("B"));

        LatticeNode<String> acdNode = acNode.next("D");
        assertTrue(acdNode.contains("A"));
        assertTrue(acdNode.contains("C"));
        assertTrue(acdNode.contains("D"));
        assertTrue(!acdNode.contains("B"));

        LatticeNode<String> acdMinusDNode = acdNode.back("D");
        assertEquals(acNode, acdMinusDNode);
        assertNotSame(acNode, acdNode);
        assertEquals(acNode.getID(), acdMinusDNode.getID());

        LatticeNode<String> acdMinusDCNode = acdNode.back("D").back("C");
        assertEquals(aNode, acdMinusDCNode);
        assertNotSame(abNode, acdMinusDCNode);
        assertEquals(aNode.getID(), acdMinusDCNode.getID());

    }

    @Test
    public void latticePerformance()
    {
        Lattice<String> lattice = new Lattice<String>();
        LatticeNode<String> emptyNode = lattice.emptyNode();

        StopWatch timer = new StopWatch();
        int N = 10000;

        timer.reset();
        LatticeNode<String> emptyNode2 = emptyNode.next("A").next("B").next("C").next("D").back("D").back("C")
                .back("B").back("A");
        assertEquals(emptyNode, emptyNode2);

        emptyNode2 = emptyNode.next("A").next("B").back("B").back("A");
        assertEquals(emptyNode, emptyNode2);

        _logger.debug(timer.getElapsedTime());

    }

}
