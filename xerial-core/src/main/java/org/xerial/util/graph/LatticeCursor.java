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
// LatticeCursor.java
// Since: 2008/11/10 17:09:29
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

/**
 * A cursor for traversing lattice structure
 * 
 * @author leo
 * 
 * @param <T>
 */
public interface LatticeCursor<T>
{
    /**
     * move to next lattice node that has the specified element
     * 
     * @param elementToAdd
     */
    LatticeNode<T> next(T elementToAdd);

    /**
     * move to previous lattice node that lacks the specified element
     * 
     * @param elementToRemove
     */
    LatticeNode<T> back(T elementToRemove);

    /**
     * test the current lattice node contains the specified element
     * 
     * @param element
     * @return
     */
    boolean contains(T element);

    LatticeNode<T> getNode();
    
    int getNodeID();
    
}
