/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XerialJ Project
//
// DFA.java
// Since: May 8, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.HashMap;
import java.util.HashSet;

import org.xerial.util.CollectionUtil;



/**
 * Deterministic finite automaton
 * @author leo
 *
 */
public class DFA<State, Alphabet> 
{
	/**
	 * if the current state is null, this DFS is in invalid sate (never reach any of terminal states) 
	 */
	private State _currentState;
	private HashSet<State> _stateSet = new HashSet<State>();
	private HashSet<State> _terminalStateSet = new HashSet<State>();

	class TransitionTargetTable extends HashMap<Alphabet, State>
	{
		private static final long serialVersionUID = 1L;

		public String toString()
		{
			return CollectionUtil.displayMap(this, "->", ", ");
		}
	}
	
	class TransitionTable extends HashMap<State, TransitionTargetTable>
	{
		private static final long serialVersionUID = 1L;
		
		public void addTransition(State from, Alphabet input, State to)
		{
			TransitionTargetTable targetTable = this.get(from);
			if(targetTable == null)
				targetTable = this.put(from, new TransitionTargetTable());

			targetTable.put(input, to);
		}
		
		public State nextState(State currentState, Alphabet input)
		{
			TransitionTargetTable targetTable = this.get(currentState);
			if(targetTable == null)
				return null;
			
			return targetTable.get(input);
		}
		
		public String toString()
		{
			return CollectionUtil.displayMap(this, ":", "\n");
		}
	};
	
	private TransitionTable _transitionTable = new TransitionTable();
	
	public DFA(State initialState)
	{
		_currentState = initialState;
	}
	
	public void addState(State s)
	{
		_stateSet.add(s);
	}
	public void addTerminalState(State s)
	{
		_stateSet.add(s);
		_terminalStateSet.add(s);
	}
	
	public void addTransition(State from, Alphabet input, State to)
	{
		_stateSet.add(from);
		_stateSet.add(to);
		_transitionTable.addTransition(from, input, to);
	}


	public boolean isTerminated()
	{
		if(_currentState == null)
			return false;
		return _terminalStateSet.contains(_currentState);
	}
	
	public State transit(Alphabet input)
	{
		if(_currentState == null)
			return null;	// null state cannot go anywhere
		
		State nextState = _transitionTable.nextState(_currentState, input);
		_currentState = nextState;
		return _currentState;
	}
	
	
	public String toString()
	{
		return _transitionTable.toString();
	}
	
	
}






