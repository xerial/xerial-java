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
// LatticeNode.java
// Since: Nov 10, 2008 1:06:36 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.ArrayList;
import java.util.HashMap;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.BitVector;
import org.xerial.util.IndexedSet;
import org.xerial.util.StringUtil;

public class LatticeNode<T>
{
    private final Lattice<T>                 lattice;
    private final BitVector                  elementOnOffIndicator;
    private final HashMap<T, LatticeNode<T>> linkToNextNode = new HashMap<T, LatticeNode<T>>();

    public LatticeNode(Lattice<T> lattice, BitVector elementOnOffIndicator)
    {
        this.lattice = lattice;
        this.elementOnOffIndicator = elementOnOffIndicator;
    }

    public boolean contains(T element)
    {
        int id = lattice.elementSet.getID(element);
        if (id == IndexedSet.INVALID_ID)
            return false;

        return elementOnOffIndicator.get(id - 1);
    }

    protected int getElementID(T element)
    {
        if (!lattice.elementSet.contains(element))
            lattice.elementSet.add(element);

        return lattice.elementSet.getID(element);
    }

    public LatticeNode<T> next(T elementToAdd)
    {
        if (linkToNextNode.containsKey(elementToAdd))
        {
            return linkToNextNode.get(elementToAdd);
        }

        // Add new edge to a LatticeNode
        // First, create a new bit vector that additionally set the target element ID
        int elementID = getElementID(elementToAdd);
        BitVector newIndicator = BitVector.newInstance(elementOnOffIndicator, elementID - 1);

        int latticeNodeID = lattice.latticeNodeSet.getID(newIndicator);
        if (latticeNodeID == IndexedSet.INVALID_ID)
        {
            lattice.latticeNodeSet.add(newIndicator);
            return new LatticeNode<T>(lattice, newIndicator);
        }
        else
            return new LatticeNode<T>(lattice, lattice.latticeNodeSet.getByID(latticeNodeID));
    }

    @Override
    public String toString()
    {
        ArrayList<String> containedElement = new ArrayList<String>();
        for (int i = 0; i < elementOnOffIndicator.size(); i++)
        {
            if (elementOnOffIndicator.get(i))
            {
                T element = lattice.getElementByID(i);
                if (element == null)
                    throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "element id=" + i);
                containedElement.add(element.toString());
            }
        }

        return String.format("{%s}", StringUtil.join(containedElement, ", "));
    }
}
