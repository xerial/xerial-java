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
// Lattic.java
// Since: 2008/11/08 11:30:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import org.xerial.util.BitVector;
import org.xerial.util.IndexedSet;

/**
 * lattice structure
 * 
 * @author leo
 * 
 * @param <T>
 */
public class Lattice<T>
{
    IndexedSet<T>         elementSet     = new IndexedSet<T>();
    IndexedSet<BitVector> latticeNodeSet = new IndexedSet<BitVector>();

    public Lattice()
    {
        latticeNodeSet.add(new BitVector());
    }

    public LatticeNode<T> emptyNode()
    {
        return new LatticeNode<T>(this, new BitVector());
    }

    public T getElementByID(int elementID)
    {
        return elementSet.getByID(elementID);
    }
}
