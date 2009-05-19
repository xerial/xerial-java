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
// Pair.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * Pair of two objects
 * 
 * @author leo
 * 
 */
public class Pair<X, Y>
{
    private final X first;
    private final Y second;

    /**
     * 
     */
    public Pair(X x, Y y)
    {
        if (x == null || y == null)
            throw new NullPointerException();

        this.first = x;
        this.second = y;
    }

    public X getFirst()
    {
        return first;
    }

    public Y getSecond()
    {
        return second;
    }

    public static <X, Y> Pair<X, Y> newPair(X x, Y y)
    {
        return new Pair<X, Y>(x, y);
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", first, second);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Pair)
        {
            Pair other = (Pair) obj;
            return first.equals(other.first) && second.equals(other.second);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return first.hashCode() + second.hashCode() % 1987;
    }
}
