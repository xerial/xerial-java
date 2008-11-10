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

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.BitVector;
import org.xerial.util.IndexedSet;
import org.xerial.util.StringUtil;

/**
 * lattice node
 * 
 * @author leo
 * 
 * @param <T>
 */
public class LatticeNode<T>
{
    private int              id = -1;
    private final Lattice<T> lattice;
    private final BitVector  elementOnOffIndicator;

    public LatticeNode(Lattice<T> lattice, BitVector elementOnOffIndicator)
    {
        this.lattice = lattice;
        this.elementOnOffIndicator = elementOnOffIndicator;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        assert id != -1;
        return id;
    }

    BitVector getElementOnOffIndicator()
    {
        return elementOnOffIndicator;
    }

    public boolean contains(T element)
    {
        int id = lattice.getElementID(element);
        if (id == IndexedSet.INVALID_ID)
            return false;

        return elementOnOffIndicator.get(id);
    }

    public LatticeNode<T> next(T elementToAdd)
    {
        return lattice.next(this, elementToAdd);
    }

    public LatticeNode<T> back(T elementToRemove)
    {
        return lattice.back(this, elementToRemove);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj)
    {
        if (!this.getClass().isInstance(obj))
            return false;

        LatticeNode<T> other = (LatticeNode<T>) obj;
        return this.lattice == other.lattice && this.elementOnOffIndicator.equals(other.elementOnOffIndicator);
    }

    @Override
    public int hashCode()
    {
        int hashValue = 3;
        hashValue += lattice.hashCode() * 31;
        hashValue += elementOnOffIndicator.hashCode() * 31;
        return hashValue % 1987;
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
