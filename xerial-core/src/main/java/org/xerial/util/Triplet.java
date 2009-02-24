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
//-----------------------------------
// XerialJ Project
// 
// Tuple.java 
// Since: 2005/01/18
//
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * Triplet structure
 * 
 * @author leo
 * 
 */
public class Triplet<E, F, J>
{
    private E first;
    private F second;
    private J third;

    public Triplet(E first, F second, J third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * @return Returns the first.
     */
    public E getFirst()
    {
        return first;
    }

    /**
     * @param first
     *            The first to set.
     */
    public void setFirst(E first)
    {
        this.first = first;
    }

    /**
     * @return Returns the second.
     */
    public F getSecond()
    {
        return second;
    }

    /**
     * @param second
     *            The second to set.
     */
    public void setSecond(F second)
    {
        this.second = second;
    }

    /**
     * @return Returns the third.
     */
    public J getThird()
    {
        return third;
    }

    /**
     * @param third
     *            The third to set.
     */
    public void setThird(J third)
    {
        this.third = third;
    }

    public static <E, F, J> Triplet<E, F, J> newTriplet(E first, F second, J third)
    {
        return new Triplet<E, F, J>(first, second, third);
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s, %s)", first, second, third);
    }

}
