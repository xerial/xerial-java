/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// Tuple.java
// Since: Feb 24, 2009 5:31:10 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.util.ArrayList;
import java.util.List;

import org.xerial.util.StringUtil;

/**
 * Tuple is a data structure for holding a list of objects.
 * 
 * @author leo
 * 
 */
public class Tuple
{
    private List<Object> tuple;

    /**
     * Set the tuple value at the specified index
     * 
     * @param tupleIndex
     *            tuple index
     * @param value
     *            value object to set
     */
    public void set(int tupleIndex, Object value)
    {
        tuple.set(tupleIndex, value);
    }

    /**
     * Append a new value to the tail of the tuple
     * 
     * @param value
     *            value object to append
     */
    public void append(Object value)
    {
        tuple.add(value);
    }

    /**
     * Get the tuple size
     * 
     * @return tuple size
     */
    public int size()
    {
        assert tuple != null;
        return tuple.size();
    }

    /**
     * Create a new fixed-size tuple. Use this factory method for
     * space-efficiency.
     * 
     * @param tupleSize
     *            size of a new tuple
     * @return fixed-size tuple
     */
    public static Tuple newFixedSizeTuple(int tupleSize)
    {
        return new Tuple(tupleSize);
    }

    public static Tuple newPair(Object attribute1, Object attribute2)
    {
        Tuple t = newFixedSizeTuple(2);
        t.set(0, attribute1);
        t.set(1, attribute2);
        return t;
    }

    private Tuple(int tupleSize)
    {
        tuple = new ArrayList<Object>(tupleSize);

        // initialize the tuple with null values
        for (int i = 0; i < tupleSize; ++i)
            tuple.add(null);
    }

    /**
     * Get the tuple value at the specified index
     * 
     * @param index
     *            tuple index in the tuple to retrieve value
     * @return value at the specified tuple index
     * @throws IndexOutOfBoundsException
     *             when index exceeds the tuple size
     */
    public Object get(int index)
    {
        return tuple.get(index);
    }

    @Override
    public String toString()
    {
        return String.format("(%s)", StringUtil.join(tuple, ", "));
    }

    /*
    public int compareTo(Tuple o)
    {
        if (o instanceof Tuple)
        {
            Tuple other = Tuple.class.cast(o);
            int s1 = size();
            int s2 = other.size();
            if (s1 < s2)
            {
                return -1;
            }
            else if (s1 > s2)
            {
                return 1;
            }
            else
            {
                for (int i = 0; i < s1; ++i)
                {

                }
            }

        }
    }
    */

}
