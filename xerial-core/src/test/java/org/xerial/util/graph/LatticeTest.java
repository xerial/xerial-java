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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LatticeTest
{

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

    }

}
