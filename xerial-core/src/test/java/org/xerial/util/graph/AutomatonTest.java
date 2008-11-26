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
// AutomatonTest.java
// Since: Nov 26, 2008 9:47:11 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class AutomatonTest
{
    private static Logger _logger = Logger.getLogger(AutomatonTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void cursor()
    {
        Automaton<Integer, String> automaton = new Automaton<Integer, String>();

        /*
         * 1 -(A)------> 2         
         *  \            |         
         *  (B)         (D)        
         *    \          v
         *     3 -> (C)-> [4] (terminal)
         *    ^
         *   (A)
         *  /  
         * 5        --
         * |       V (A)
         * --(*)-> 6 -|
         */

        automaton.addTransition(1, "A", 2);
        automaton.addTransition(1, "B", 3);
        automaton.addTransition(2, "D", 4);
        automaton.addTransition(3, "C", 4);
        automaton.addTransition(5, "A", 3);
        automaton.addStarTransition(5, 6);
        automaton.addTransition(6, "A", 6);

        automaton.addTerminalState(4);

        for (int i = 1; i <= 6; i++)
            assertTrue(automaton.hasState(i));

        AutomatonCursor<Integer, String> cursor = automaton.cursor(1);

        assertEquals(1, cursor.getState());
        assertTrue(!cursor.isTerminal());
        assertTrue(!cursor.canAcceptAnySymbol());
        assertTrue(cursor.canAccept("A"));
        assertTrue(cursor.canAccept("B"));
        assertFalse(cursor.canAccept("C"));
        assertFalse(cursor.canAccept("D"));
        assertFalse(cursor.canAcceptAnySymbol());
        assertTrue(cursor.getAcceptableSymbolSet().contains("A"));
        assertTrue(cursor.getAcceptableSymbolSet().contains("B"));

        cursor.transit("A");

        assertEquals(2, cursor.getState());
        assertTrue(!cursor.isTerminal());
        assertTrue(!cursor.canAcceptAnySymbol());
        assertTrue(cursor.canAccept("D"));
        assertFalse(cursor.canAccept("A"));
        assertFalse(cursor.canAccept("B"));
        assertFalse(cursor.canAcceptAnySymbol());
        assertTrue(cursor.getAcceptableSymbolSet().contains("D"));

        cursor.transit("D");
        assertEquals(4, cursor.getState());
        assertTrue(cursor.isTerminal());
        assertTrue(!cursor.canAcceptAnySymbol());

        cursor.reset(1);
        cursor.transit("B");
        assertEquals(3, cursor.getState());
        assertTrue(!cursor.canAcceptAnySymbol());

        cursor.transit("C");
        assertEquals(4, cursor.getState());
        assertTrue(!cursor.canAcceptAnySymbol());

        cursor.reset(5);
        assertTrue(cursor.canAcceptAnySymbol());
        assertTrue(cursor.canAccept("A"));
        assertTrue(cursor.canAccept("B"));
        assertTrue(cursor.canAccept("C"));
        assertTrue(cursor.canAccept("XX"));
        assertTrue(cursor.canAccept(null));

        cursor.transit("something");
        assertEquals(6, cursor.getState());

        cursor.transit("A");
        assertEquals(6, cursor.getState());
        cursor.transit("A");
        assertEquals(6, cursor.getState());

        _logger.debug(automaton.toString());
        _logger.debug(automaton.toGraphviz());

    }

}
