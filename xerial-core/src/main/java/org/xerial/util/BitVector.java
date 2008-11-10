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
// BitVector.java
// Since: 2008/11/08 9:29:14
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.List;

/**
 * bit array, which consists of zero (false) or one (true) values
 * 
 * @author leo
 * 
 */
public class BitVector
{
    private final static int   BIT_LENGTH = 32;
    private ArrayList<Integer> bitVector  = new ArrayList<Integer>();
    private int                size       = 0;

    public BitVector()
    {}

    public void on(int index)
    {
        set(index, true);
    }

    public void off(int index)
    {
        set(index, false);
    }

    public void set(int index, boolean flag)
    {
        extend(index);

        int pos = pos(index);
        int mask = 0x01 << offset(index);

        int value = bitVector.get(pos);
        bitVector.set(pos, flag ? (value |= mask) : (value &= ~mask));
    }

    public boolean get(int index)
    {
        int pos = pos(index);
        if (pos >= bitVector.size())
            return false;

        int value = bitVector.get(pos);
        int mask = 0x01 << offset(index);
        return (value &= mask) != 0;
    }

    private static int pos(int index)
    {
        return index / BIT_LENGTH;
    }

    private static int offset(int index)
    {
        return index % BIT_LENGTH;
    }

    private void extend(int index)
    {
        if (size <= index)
            size = index + 1;

        int pos = pos(index);
        if (pos < bitVector.size())
            return;

        while (bitVector.size() <= pos)
            bitVector.add(0);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!BitVector.class.isInstance(obj))
            return false;

        BitVector other = BitVector.class.cast(obj);

        // compare the size
        int size = this.bitVector.size();
        if (size != other.bitVector.size())
            return false;

        // compare each byte
        for (int i = 0; i < size; i++)
        {
            if (!this.bitVector.get(i).equals(other.bitVector.get(i)))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int hashValue = 3;
        for (int v : bitVector)
            hashValue += hashValue * 137 + v;

        return hashValue % 1987;
    }

    /**
     * @param array
     */
    private BitVector(List<Integer> array, int bitSize)
    {
        this.size = bitSize;
        // copy the array
        for (int v : array)
        {
            this.bitVector.add(v);
        }
    }

    public static BitVector newInstance(BitVector source)
    {
        return new BitVector(source.bitVector, source.size);
    }

    public static BitVector newInstanceWithAnAdditionalBit(BitVector source, int bitIndexToAdd)
    {
        BitVector newInstance = new BitVector(source.bitVector, source.size);
        newInstance.on(bitIndexToAdd);
        return newInstance;
    }

    public int size()
    {
        return size;
    }

    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < size; i++)
            buf.append(get(i) ? "1" : "0");
        return buf.toString();
    }

}
