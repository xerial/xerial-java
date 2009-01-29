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
// SilkLexerState.java
// Since: 2009/01/29 20:12:51
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

import org.xerial.util.graph.Automaton;
import org.xerial.util.graph.AutomatonCursor;

/**
 * Lexer state DFA
 * 
 * <pre>
 *  DEFAULT -(NodeStart)-&gt; KEY 
 *  KEY -&gt; (Colon) -&gt; OUT
 *  OUT -&gt; (LParen) -&gt; IN
 *  IN -&gt; (Colon) -&gt; IN
 *   
 *  ($current = ANY) -&gt; (Other) -&gt; ($current)
 * </pre>
 * 
 * @author leo
 * 
 */
public class SilkLexerState
{
    public static enum State {
        INIT, KEY, OUT, IN
    };

    public static enum Symbol {
        NodeStart, Colon, EnterParen
    }

    private final Automaton<State, Symbol> automaton = new Automaton<State, Symbol>();
    private final AutomatonCursor<State, Symbol> cursor;

    public SilkLexerState()
    {
        automaton.addTransition(State.INIT, Symbol.NodeStart, State.KEY);
        automaton.addTransition(State.KEY, Symbol.Colon, State.OUT);
        automaton.addTransition(State.KEY, Symbol.EnterParen, State.IN);
        automaton.addTransition(State.OUT, Symbol.EnterParen, State.IN);

        for (State each : State.values())
            automaton.addStarTransition(each, each);

        cursor = automaton.cursor(State.INIT);
    }

    public State transit(Symbol input)
    {
        return cursor.transit(input);
    }

    public State getCurrentState()
    {
        return cursor.getState();
    }

    public void reset()
    {
        cursor.reset(State.INIT);
    }

}
