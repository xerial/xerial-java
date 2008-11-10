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

public interface Automaton<State, Symbol, Action>
{
    public void addState(State state);

    public void addTransition(State from, Symbol input, State to, Action action);

    public boolean hasState(State state);

    public boolean isAcceptableSymbol(Symbol input);

    public void moveTo(State state);

    public State transit(Symbol input);
}


