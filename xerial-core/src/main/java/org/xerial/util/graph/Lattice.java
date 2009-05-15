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

import java.util.ArrayList;
import java.util.HashMap;

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
    private IndexedSet<T> elementSet = new IndexedSet<T>();
    private IndexedSet<LatticeNode<T>> latticeNodeSet = new IndexedSet<LatticeNode<T>>();
    private ArrayList<HashMap<T, LatticeNode<T>>> outEdgeIndexTable = new ArrayList<HashMap<T, LatticeNode<T>>>();
    private ArrayList<HashMap<T, LatticeNode<T>>> inEdgeIndexTable = new ArrayList<HashMap<T, LatticeNode<T>>>();

    private final LatticeNode<T> emptySet;

    public Lattice()
    {
        emptySet = newLatticeNode(new BitVector());
    }

    private HashMap<T, LatticeNode<T>> getOutEdgeIndex(int latticeNodeID)
    {
        assert latticeNodeID >= 0;
        return outEdgeIndexTable.get(latticeNodeID);
    }

    private HashMap<T, LatticeNode<T>> getInEdgeIndex(int latticeNodeID)
    {
        assert latticeNodeID >= 0;
        return inEdgeIndexTable.get(latticeNodeID);
    }

    LatticeNode<T> next(LatticeNode<T> currentNode, T element)
    {
        int currentLatticeNodeID = currentNode.getID();

        HashMap<T, LatticeNode<T>> outEdgeIndexOfTheCurrentNode = getOutEdgeIndex(currentLatticeNodeID);
        LatticeNode<T> nextNode = outEdgeIndexOfTheCurrentNode.get(element);
        if (nextNode != null)
            return nextNode;

        // search the corresponding lattice node
        BitVector toFind = BitVector.newInstanceWithAnAdditionalBit(currentNode.getElementOnOffIndicator(), elementSet
                .getIDwithAddition(element));
        for (LatticeNode<T> each : latticeNodeSet)
        {
            if (each.getElementOnOffIndicator().equals(toFind))
            {
                // update edges  
                getOutEdgeIndex(currentLatticeNodeID).put(element, each);
                getInEdgeIndex(each.getID()).put(element, currentNode);

                return each;
            }
        }

        // create a new lattice node
        LatticeNode<T> newLatticeNode = newLatticeNode(toFind);

        // draw an in-edge from the current node (for back operation)
        getInEdgeIndex(newLatticeNode.getID()).put(element, currentNode);

        // draw an out-edge (labeled with the element value) from the current node to the new node
        getOutEdgeIndex(currentLatticeNodeID).put(element, newLatticeNode);

        return newLatticeNode;
    }

    LatticeNode<T> back(LatticeNode<T> currentNode, T element)
    {
        int currentLatticeNodeID = currentNode.getID();

        HashMap<T, LatticeNode<T>> inEdgeIndexOfTheCurrentNode = getInEdgeIndex(currentLatticeNodeID);
        LatticeNode<T> prevNode = inEdgeIndexOfTheCurrentNode.get(element);
        if (prevNode != null)
            return prevNode;
        else
        {
            return previousLatticeNode(currentNode.getElementOnOffIndicator(), element);
            //            throw new XerialError(XerialErrorCode.UNSUPPORTED, String.format(
            //                    "previous node must exist in the lattice. currentNode = %s, element = %s", currentNode, element));
        }
    }

    /**
     * recursively constructs the previous lattice node(s)
     * 
     * @param current
     * @param elementToRemove
     * @return
     */
    private LatticeNode<T> previousLatticeNode(BitVector current, T elementToRemove)
    {
        if (elementToRemove == null)
        {
            // no more element to remove
            return emptySet;
        }

        int elementIDToRemove = getElementID(elementToRemove);
        BitVector elementOnOffIndicator = BitVector.newInstance(current);
        elementOnOffIndicator.off(elementIDToRemove);

        for (int i = 0; i < elementOnOffIndicator.size(); i++)
        {
            if (elementOnOffIndicator.get(i))
            {
                T backEdgeNode = getElementByID(i);
                LatticeNode<T> prev = previousLatticeNode(elementOnOffIndicator, backEdgeNode);
                return prev.next(backEdgeNode);
            }
        }
        // no bit is on
        return previousLatticeNode(elementOnOffIndicator, null);
    }

    protected LatticeNode<T> newLatticeNode(BitVector bv)
    {
        LatticeNode<T> newLatticeNode = new LatticeNode<T>(this, bv);
        // allocate an new ID for the lattice node 
        int newLatticeNodeID = latticeNodeSet.getIDwithAddition(newLatticeNode);
        newLatticeNode.setID(newLatticeNodeID);

        // create in/out edge indexes for the new node
        inEdgeIndexTable.add(new HashMap<T, LatticeNode<T>>());
        outEdgeIndexTable.add(new HashMap<T, LatticeNode<T>>());

        assert (newLatticeNodeID == outEdgeIndexTable.size() - 1);
        assert (newLatticeNodeID == inEdgeIndexTable.size() - 1);

        return newLatticeNode;
    }

    public LatticeNode<T> emptyNode()
    {
        return emptySet;
    }

    public LatticeCursor<T> cursor()
    {
        return new LatticeCursorImpl<T>(emptySet);
    }

    public int getElementID(T element)
    {
        return elementSet.getID(element);
    }

    public T getElementByID(int elementID)
    {
        return elementSet.getByID(elementID);
    }

    private static class LatticeCursorImpl<T> implements LatticeCursor<T>
    {
        private LatticeNode<T> currentLatticeNode;

        public LatticeCursorImpl(LatticeNode<T> latticeNode)
        {
            this.currentLatticeNode = latticeNode;
        }

        public LatticeNode<T> reset(LatticeNode<T> node)
        {
            this.currentLatticeNode = node;
            return currentLatticeNode;
        }

        public LatticeNode<T> back(T elementToRemove)
        {
            currentLatticeNode = currentLatticeNode.back(elementToRemove);
            return currentLatticeNode;
        }

        public boolean contains(T element)
        {
            return currentLatticeNode.contains(element);
        }

        public LatticeNode<T> next(T elementToAdd)
        {
            currentLatticeNode = currentLatticeNode.next(elementToAdd);
            return currentLatticeNode;
        }

        public LatticeNode<T> getNode()
        {
            return currentLatticeNode;
        }

        public int getNodeID()
        {
            return currentLatticeNode.getID();
        }

    }

}
