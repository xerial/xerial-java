/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// MatrixGraphTest.java
// Since: 2011/06/14 16:12:22
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixGraphTest {

    @Test
    public void matrix() throws Exception {

        MatrixGraph<String> g = new MatrixGraph<String>(5);
        String[] nodes = { "A", "B", "C", "D", "E" };
        for (String each : nodes)
            g.addNode(each);

        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("A", "D");

        for (String each : nodes)
            assertTrue(g.containsNode(each));

        // Tests for edge connections
        assertTrue(g.hasEdge("A", "B"));
        assertTrue(g.hasEdge("B", "C"));
        assertTrue(g.hasEdge("A", "D"));
        assertFalse(g.hasEdge("A", "C"));

        try {
            g.addNode("F");

            fail("cannot reach here");
        }
        catch (Exception e) {
            // OK

        }

    }

}
