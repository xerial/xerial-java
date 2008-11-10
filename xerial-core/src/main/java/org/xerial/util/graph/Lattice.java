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


import java.util.HashMap;

import org.xerial.util.BitVector;
import org.xerial.util.IndexedSet;

public class Lattice<T>
{
    private IndexedSet<T>         elementSet     = new IndexedSet<T>();
    private IndexedSet<BitVector> latticeNodeSet = new IndexedSet<BitVector>();
    
    public class LatticeNode
    {
        final BitVector elementOnOffIndicator;
        final HashMap<T, LatticeNode> linkToNextNode = new HashMap<T, LatticeNode>(); 

        public LatticeNode(BitVector elementOnOffIndicator)
        {
            this.elementOnOffIndicator = elementOnOffIndicator;
        }

        public boolean contains(T element)
        {
            int id = elementSet.getID(element);
            if (id == IndexedSet.INVALID_ID)
                return false;

            return elementOnOffIndicator.get(id - 1);
        }

        public LatticeNode next(T elementToAdd)
        {
            int elementID = getID(elementToAdd);
            
            BitVector newIndicator = BitVector.newInstance(elementOnOffIndicator);
            newIndicator.on(elementID - 1);

            int latticeNodeID = latticeNodeSet.getID(newIndicator);
            if (latticeNodeID == IndexedSet.INVALID_ID)
            {
                latticeNodeSet.add(newIndicator);
                return new LatticeNode(newIndicator);
            }
            else
                return new LatticeNode(latticeNodeSet.getByID(latticeNodeID));
        }
    }
    
    protected int getID(T element)
    {
        if (!elementSet.contains(element))
            elementSet.add(element);

        return elementSet.getID(element);
    }
    
    public Lattice()
    {
        latticeNodeSet.add(new BitVector());
    }
    
    public LatticeNode emptyNode()
    {
        return new LatticeNode(new BitVector());
    }
    
}
