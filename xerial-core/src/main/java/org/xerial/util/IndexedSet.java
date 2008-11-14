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
// IndexedContainer.java
// Since: 2008/11/08 11:32:29
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set container, each element of which is assigned an unique ID in the set.
 * 
 * @author leo
 * 
 * @param <T>
 *            element type to store
 */
public class IndexedSet<T> implements Set<T>
{
    public final static int     INVALID_ID   = -1;
    private int                 elementCount = 0;
    private HashMap<T, Integer> elementToID  = new HashMap<T, Integer>();
    private ArrayList<T>        elementArray = new ArrayList<T>();

    public Collection<Integer> getIDSet()
    {
        return elementToID.values();
    }

    public boolean containsID(int id)
    {
        return id <= elementArray.size() && getByID(id) != null;
    }

    /**
     * get the element ID
     * 
     * @param element
     * @return the element ID. if no corresponding element found in the set,
     *         returns {@link IndexedSet#INVALID_ID}
     */
    public int getID(T element)
    {
        Integer id = elementToID.get(element);
        return (id == null) ? INVALID_ID : id;
    }

    /**
     * get the element ID. If the element is not present in the set, add the
     * element to the set and return the new element ID
     * 
     * @param element
     * @return
     */
    public int getIDwithAddition(T element)
    {
        if (contains(element))
            return getID(element);
        else
        {
            return addNewElement(element);
        }
    }

    /**
     * Get the element using the element ID
     * 
     * @param elementID
     * @return
     */
    public T getByID(int elementID)
    {
        return elementArray.get(elementID - 1);
    }

    public T set(int id, T element)
    {
        T oldValue = elementArray.set(id, element); // range check occurs
        elementToID.put(element, id);
        return oldValue;
    }

    /**
     * Add an new element, and return the assigned element ID
     * 
     * @param element
     * @return the new element ID
     */
    private int addNewElement(T element)
    {
        assert (!elementToID.containsKey(element));

        int newNodeID = ++elementCount;
        elementToID.put(element, newNodeID);
        elementArray.add(element);
        return newNodeID;
    }

    public boolean add(T element)
    {
        if (elementToID.containsKey(element))
        {
            return false;
        }
        else
        {
            addNewElement(element);
            return true;
        }
    }

    public boolean addAll(Collection< ? extends T> elementCollection)
    {
        boolean collectionIsChanged = false;
        for (T each : elementCollection)
        {
            collectionIsChanged |= add(each);
        }
        return collectionIsChanged;
    }

    public void clear()
    {
        elementToID.clear();
        elementArray.clear();
        elementCount = 0;

    }

    public boolean contains(Object element)
    {
        return elementToID.containsKey(element);
    }

    public boolean containsAll(Collection< ? > elementList)
    {
        for (Object each : elementList)
        {
            if (!contains(each))
                return false;
        }
        return true;
    }

    public boolean isEmpty()
    {
        return elementToID.isEmpty();
    }

    public Iterator<T> iterator()
    {
        return elementToID.keySet().iterator();
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object element)
    {
        int id = getID((T) element);
        if (id == INVALID_ID)
            return false;

        elementToID.remove(element);
        elementArray.set(id - 1, null);
        return true;
    }

    public boolean removeAll(Collection< ? > elementListToRemove)
    {
        boolean hasAnyChange = false;
        for (Object each : elementListToRemove)
        {
            hasAnyChange |= remove(each);
        }
        return hasAnyChange;
    }

    public boolean retainAll(Collection< ? > elementsToRetain)
    {
        throw new UnsupportedOperationException("retainAll");
    }

    public int size()
    {
        return elementToID.size();
    }

    public Object[] toArray()
    {
        return elementToID.keySet().toArray();
    }

    @SuppressWarnings("hiding")
    public <T> T[] toArray(T[] array)
    {
        return elementToID.keySet().toArray(array);
    }

    @Override
    public String toString()
    {
        ArrayList<String> elementList = new ArrayList<String>();
        TreeSet<Integer> sortedIDSet = new TreeSet<Integer>(getIDSet());
        for (int elementID : sortedIDSet)
        {
            elementList.add(String.format("%s(%d)", getByID(elementID), elementID));
        }

        return String.format("{%s}", StringUtil.join(elementList, ", "));
    }

}
