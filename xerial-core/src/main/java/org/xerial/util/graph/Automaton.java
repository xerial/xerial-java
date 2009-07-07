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

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.IndexedSet;
import org.xerial.util.StringUtil;

/**
 * Definite Finite State Automaton implementation
 * 
 * @author leo
 * 
 * @param <State>
 * @param <Symbol>
 */
public class Automaton<State, Symbol> {
    private List<AutomatonListener<State, Symbol>> listenerList = new ArrayList<AutomatonListener<State, Symbol>>();
    private IndexedSet<State> stateSet = new IndexedSet<State>();
    private Set<State> terminalState = new HashSet<State>();
    private HashMap<State, HashMap<Symbol, State>> transition = new HashMap<State, HashMap<Symbol, State>>();
    private HashMap<State, State> transitionForOtherInput = new HashMap<State, State>();

    private class CursorImpl implements AutomatonCursor<State, Symbol> {
        State currentState;

        public CursorImpl(State initialState) {
            currentState = initialState;
        }

        public boolean canAccept(Symbol input) {
            if (canAcceptAnySymbol())
                return true;

            // when cannot accept any symbol
            if (input == null)
                return false;

            return getTransitionTableOf(currentState).containsKey(input);
        }

        public Set<Symbol> getAcceptableSymbolSet() {
            return getAcceptableSymbolSetOf(currentState);
        }

        public boolean canAcceptAnySymbol() {
            return transitionForOtherInput.containsKey(currentState);
        }

        public State getState() {
            return currentState;
        }

        public boolean isTerminal() {
            return terminalState.contains(currentState);
        }

        public AutomatonCursor<State, Symbol> reset(State state) {
            if (!hasState(state))
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "no such state found: "
                        + state);
            currentState = state;
            return this;
        }

        public State transit(Symbol input) {
            Map<Symbol, State> transitionTable = getTransitionTableOf(currentState);
            State nextState = transitionTable.get(input);
            if (nextState == null)
                return otherTransit(input);

            // notify the transition to listeners
            for (AutomatonListener<State, Symbol> each : listenerList) {
                each.onTansit(currentState, input, nextState);
            }

            currentState = nextState;
            return currentState;
        }

        private State otherTransit(Symbol input) {
            if (transitionForOtherInput.containsKey(currentState)) {
                currentState = transitionForOtherInput.get(currentState);
                return currentState;
            }
            else {
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "cannot accept the symbol:"
                        + input);
            }
        }

    }

    private Map<Symbol, State> getTransitionTableOf(State state) {
        HashMap<Symbol, State> result = transition.get(state);
        if (result == null) {
            result = new HashMap<Symbol, State>();
            transition.put(state, result);
        }
        return result;
    }

    public AutomatonCursor<State, Symbol> cursor(State initialState) {
        return new CursorImpl(initialState);
    }

    public Set<State> getStateSet() {
        return stateSet;
    }

    public Set<Symbol> getAcceptableSymbolSetOf(State state) {
        if (!hasState(state))
            throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format(
                    "state %s not found", state));

        return getTransitionTableOf(state).keySet();
    }

    public Set<State> getAdjacentStates(State from) {
        HashSet<State> result = new HashSet<State>();
        if (transitionForOtherInput.containsKey(from))
            result.add(transitionForOtherInput.get(from));

        result.addAll(getTransitionTableOf(from).values());
        return result;
    }

    public void addState(State state) {
        stateSet.add(state);
    }

    public void addTerminalState(State state) {
        addState(state);
        terminalState.add(state);
    }

    public void addTransition(State from, Symbol input, State to) {
        addState(from);
        addState(to);

        getTransitionTableOf(from).put(input, to);
    }

    public void addStarTransition(State from, State to) {
        addState(from);
        addState(to);

        transitionForOtherInput.put(from, to);
    }

    public void addListener(AutomatonListener<State, Symbol> listener) {
        this.listenerList.add(listener);
    }

    public void remvoeListener(AutomatonListener<State, Symbol> listener) {
        this.listenerList.remove(listener);
    }

    public void clearListner() {
        this.listenerList.clear();
    }

    public boolean hasState(State state) {
        return stateSet.contains(state);
    }

    public String toString() {
        ArrayList<String> edgeData = new ArrayList<String>();
        for (State from : transition.keySet()) {
            int fromID = stateSet.getID(from);
            for (Entry<Symbol, State> eachTransition : getTransitionTableOf(from).entrySet()) {
                edgeData.add(String.format("%s -> %s [%s]", from, eachTransition.getValue(),
                        eachTransition.getKey()));
            }

            if (transitionForOtherInput.containsKey(from)) {
                edgeData
                        .add(String.format("%s -> %s [*]", from, transitionForOtherInput.get(from)));
            }
        }

        return String.format("node:\n%s\nedge:\n%s", StringUtil.join(stateSet, ",\n"), StringUtil
                .join(edgeData, ",\n"));
    }

    public String toGraphviz() {
        StringWriter writer = new StringWriter();
        GraphvizHelper g = new GraphvizHelper(writer);
        g.beginDigraph("G");
        for (State each : stateSet) {
            g.node(stateSet.getID(each), each.toString());
        }

        for (State from : transition.keySet()) {
            int fromID = stateSet.getID(from);
            for (Entry<Symbol, State> eachTransition : getTransitionTableOf(from).entrySet()) {
                g.edge(fromID, stateSet.getID(eachTransition.getValue()), eachTransition.getKey()
                        .toString());
            }

            if (transitionForOtherInput.containsKey(from)) {
                g.edge(Integer.toString(fromID), transitionForOtherInput.get(from).toString(), "*");
            }
        }

        g.endDigraph();
        return writer.toString();
    }

}
