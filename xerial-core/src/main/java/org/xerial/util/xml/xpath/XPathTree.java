/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// XPathTree.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.xpath;

import java.util.TreeMap;
import java.util.Vector;

import org.xerial.util.graph.Edge;
import org.xerial.util.xml.XPathConstants.Axis;

/**
 * 複数のXPath文をtree構造で保持するクラス
 * @author leo
 *
 */
public class XPathTree
{
    int _numStates = 0;
    private TreeMap<Edge, Axis> _edge2AxisTypeMap = new TreeMap<Edge, Axis>();
    
    /**
     * 入力によって遷移する先のstateを与えるクラス
     * @author leo
     */
    class TransitionFunction implements Comparable<TransitionFunction>
    {
        private int _baseState;
        private TreeMap<String, Vector<Integer>> _nextStates = new TreeMap<String, Vector<Integer>>();
        
        public TransitionFunction(int baseState)
        {
            _baseState = baseState;
        }
        
        public int compareTo(TransitionFunction o)
        {
            return _baseState - o._baseState;
        }
        
        public void addRule(String input, Vector<Integer> nextStateList)
        {
            _nextStates.put(input, nextStateList);
        }
        
        public Vector<Integer> nextStates(String input)
        {
            return _nextStates.get(input);
        }
    }

    /**
     * 
     */
    public XPathTree()
    {
        super();
    
    }

    
    public void addList() {}
    
    
        
}




