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
// Automaton.java
// Since: 2008/11/07 23:47:17
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.IndexedSet;

/**
 * Automaton implementation
 * 
 * @author leo
 * 
 * @param <State>
 * @param <Symbol>
 */
public class Automaton<State, Symbol>
{
    private List<AutomatonListener<State, Symbol>> listenerList = new ArrayList<AutomatonListener<State, Symbol>>();
    private IndexedSet<State> stateSet = new IndexedSet<State>();
    private Set<State> terminalState = new HashSet<State>();
    private HashMap<State, HashMap<Symbol, State>> transition = new HashMap<State, HashMap<Symbol, State>>();

    private class CursorImpl implements AutomatonCursor<State, Symbol>
    {
        State currentState;

        public CursorImpl(State initialState)
        {
            currentState = initialState;
        }

        public boolean canAccept(Symbol input)
        {
            Map<Symbol, State> transitionTable = getTransitionTableOf(currentState);
            if (transitionTable == null)
                return false;

            return transitionTable.containsKey(input);
        }

        public State getState()
        {
            return currentState;
        }

        public boolean isTerminal()
        {
            return terminalState.contains(currentState);
        }

        public AutomatonCursor<State, Symbol> moveTo(State state)
        {
            if (!hasState(state))
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "no such state found: " + state);
            currentState = state;
            return this;
        }

        public State transit(Symbol input)
        {
            Map<Symbol, State> transitionTable = getTransitionTableOf(currentState);
            if (transitionTable == null)
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "cannot accept the symbol:" + input);

            // TODO
            return null;
        }

    }

    private Map<Symbol, State> getTransitionTableOf(State state)
    {
        return transition.get(state);
    }

    public AutomatonCursor<State, Symbol> cursor(State initialState)
    {
        // TODO impl
        return null;
    }

    public Set<State> stateSet()
    {
        return stateSet;
    }

    public void addState(State state)
    {
        stateSet.add(state);
    }

    public void addTerminalState(State state)
    {
        addState(state);
        terminalState.add(state);
    }

    public void addTransition(State from, Symbol input, State to)
    {
        HashMap<Symbol, State> transitionOfTheSymbol = transition.get(from);
        if (transitionOfTheSymbol == null)
        {
            transitionOfTheSymbol = new HashMap<Symbol, State>();
            transition.put(from, transitionOfTheSymbol);
        }

        transitionOfTheSymbol.put(input, to);
    }

    public void addListener(AutomatonListener<State, Symbol> listener)
    {
        this.listenerList.add(listener);
    }

    public void remvoeListener(AutomatonListener<State, Symbol> listener)
    {
        this.listenerList.remove(listener);
    }

    public void clearListner()
    {
        this.listenerList.clear();
    }

    public boolean hasState(State state)
    {
        return stateSet.contains(state);
    }

}
