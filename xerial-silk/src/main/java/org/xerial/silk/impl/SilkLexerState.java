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

import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
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
        INIT, OUT_KEY, OUT_VALUE, IN_VALUE, IN_KEY, IN_FUNC_NAME
    };

    public static enum Symbol {
        NodeStart, Colon, EnterParen, LeaveParen, LeaveValue, At
    }

    private static final Automaton<State, Symbol> automaton  = new Automaton<State, Symbol>();
    private Deque<State>                          stateStack = new ArrayDeque<State>();

    //private State beforeJSONState = State.INIT;
    //private int nestLevel = 0;
    private final AutomatonCursor<State, Symbol>  cursor;

    static {
        automaton.addTransition(State.INIT, Symbol.NodeStart, State.OUT_KEY);
        automaton.addTransition(State.OUT_KEY, Symbol.EnterParen, State.IN_KEY);
        automaton.addTransition(State.OUT_KEY, Symbol.Colon, State.OUT_VALUE);
        automaton.addTransition(State.IN_KEY, Symbol.Colon, State.IN_VALUE);
        automaton.addTransition(State.IN_VALUE, Symbol.LeaveValue, State.IN_KEY);
        automaton.addTransition(State.IN_VALUE, Symbol.EnterParen, State.IN_KEY);

        automaton.addTransition(State.OUT_VALUE, Symbol.At, State.OUT_KEY);

        for (State each : State.values())
            automaton.addStarTransition(each, each);
    }

    public SilkLexerState() {
        cursor = automaton.cursor(State.INIT);
    }

    public State transit(Symbol input) {
        State current = getCurrentState();
        switch (input) {
        case At:
            stateStack.addLast(current);
            break;
        case EnterParen:
            if (current != State.OUT_VALUE)
                stateStack.addLast(current);
            break;
        case LeaveParen:
            if (current != State.OUT_VALUE) {
                if (!stateStack.isEmpty()) {
                    State prevState = stateStack.removeLast();
                    cursor.reset(prevState);
                    return prevState;
                }
            }
            break;
        }

        return cursor.transit(input);
    }

    public State getCurrentState() {
        return cursor.getState();
    }

    public boolean isInKey() {
        State current = cursor.getState();
        return current == State.IN_KEY || current == State.OUT_KEY;
    }

    public boolean isValue() {
        State current = cursor.getState();
        return current == State.IN_VALUE || current == State.OUT_VALUE;
    }

    public boolean isInValue() {
        return getCurrentState() == State.IN_VALUE;
    }

    public boolean isOutValue() {
        return getCurrentState() == State.OUT_VALUE;
    }

    public void reset() {
        cursor.reset(State.INIT);
        stateStack.clear();
        //        beforeJSONState = State.INIT;
        //        nestLevel = 0;
    }

}
