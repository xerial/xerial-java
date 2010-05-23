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
// Algorithm.java
// Since: 2004/12/27
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Algorithms for the ease of programming
 * 
 * @author leo
 * 
 */
public class Algorithm {
    private Algorithm() {};

    /**
     * Compare the min and max of two values
     * 
     * @param <E>
     *            a class that implements {@link Comparable} interface
     * @param e1
     * 
     * @param e2
     * @return MinMax
     */
    static public <E extends Comparable<E>> MinMax<E> minmax(E e1, E e2) {
        int cmpResult = e1.compareTo(e2);
        if (cmpResult <= 0) // e1 is less than or equal to e2
            return new MinMax<E>(e1, e2);
        else
            return new MinMax<E>(e2, e1);
    }

    static public <E extends Comparable<E>> E min(E e1, E e2) {
        return minmax(e1, e2).min();
    }

    static public <E extends Comparable<E>> E max(E e1, E e2) {
        return minmax(e1, e2).min();
    }

    /**
     * compare by lexicographical order
     * 
     * @param <E>
     *            a class that implements {@link Comparable} interface
     * @param f1
     * @param f2
     * @return negative value : f1 < f2, 0 : f1 == f2, positive value : f1 > f2
     */
    static public <E extends Comparable<E>> int lexicographicalCompare(Iterable<E> f1,
            Iterable<E> f2) {
        Iterator<E> i1 = f1.iterator();
        Iterator<E> i2 = f2.iterator();
        int cmp = 0;
        while (i1.hasNext() && i2.hasNext()) {
            E e1 = i1.next();
            E e2 = i2.next();
            cmp = e1.compareTo(e2);
            if (cmp != 0)
                return cmp;
        }
        if (i1.hasNext())
            return 1;
        else {
            if (i2.hasNext())
                return -1;
            else
                return 0;
        }
    }

    /**
     * translate boolean value into 1 (true) or 0 (false)
     * 
     * @param flag
     * @return true:1, false:0
     */
    static public int boolToInt(boolean flag) {
        return flag == true ? 1 : 0;
    }

    /**
     * append each element in the array to the collection
     * 
     * @param <E>
     * @param c
     *            target collection
     * @param array
     *            source data array
     */
    static public <E> void add(Collection<E> c, E[] array) {
        for (E e : array) {
            c.add(e);
        }
    }

    /**
     * append each element in the input to the target collection
     * 
     * @param <E>
     * @param container
     * @param input
     */
    static public <E> void add(List<E> container, Collection<E> input) {
        for (E e : input) {
            container.add(e);
        }
    }

    static public <Input, Output> List<Output> map(Iterable<Input> input,
            Mapper<Input, Output> mapper) {
        List<Output> result = new ArrayList<Output>();
        for (Input each : input) {
            result.add(mapper.map(each));
        }

        return result;
    }

    static public <Input, Output> Output reduce(Iterable<Input> input,
            Reducer<Input, Output> reducer) {
        return reducer.reduce(input);
    }

    static public <Input, T, Out> Out mapReduce(Iterable<Input> input, Mapper<Input, T> mapper,
            Reducer<T, Out> reducer) {
        return reduce(map(input, mapper), reducer);
    }

}
