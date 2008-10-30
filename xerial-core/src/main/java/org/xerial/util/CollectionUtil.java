/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XerialJ Project
//
// CollectionUtil.java
// Since: May 8, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CollectionUtil
{

    /**
     * Non constractable class
     */
    private CollectionUtil()
    {}

    public static <In> List<String> toString(Collection<In> collection)
    {
        ArrayList<String> result = new ArrayList<String>();
        for (In input : collection)
        {
            if (input != null)
                result.add(input.toString());
            else
                result.add(null);
        }
        return result;
    }

    public static <In, Out> List<Out> collectFromNonGenericCollection(Iterable<In> collection, Functor<In, Out> functor)
    {
        ArrayList<Out> result = new ArrayList<Out>();
        for (In input : collection)
        {
            result.add(functor.apply(input));
        }
        return result;
    }

    public static <In> List<In> select(Iterable<In> collection, Predicate<In> filter)
    {
        ArrayList<In> result = new ArrayList<In>();
        for (In input : collection)
        {
            if (filter.apply(input))
                result.add(input);
        }
        return result;
    }

    public static <In, Out> List<Out> collect(Iterable<In> collection, Functor<In, Out> functor)
    {
        ArrayList<Out> result = new ArrayList<Out>();
        for (In input : collection)
        {
            result.add(functor.apply(input));
        }
        return result;
    }

    public static <In, Out> List<Out> collect(In[] collection, Functor<In, Out> functor)
    {
        ArrayList<Out> result = new ArrayList<Out>();
        for (In input : collection)
        {
            result.add(functor.apply(input));
        }
        return result;
    }

    public static <K, V> List<Object> collect(Map<K, V> map, BinaryFunctor<K, V> functor)
    {
        ArrayList<Object> result = new ArrayList<Object>();
        for (K key : map.keySet())
        {
            result.add(functor.apply(key, map.get(key)));
        }
        return result;
    }

    public static <K, V> String displayMap(Map<K, V> map, final String keyValueSeparator, final String elementSeparator)
    {
        return StringUtil.join(collect(map, new BinaryFunctor<K, V>() {
            public Object apply(K key, V value)
            {
                return key.toString() + keyValueSeparator + value.toString();
            }
        }), ", ");
    }

    public static <E> TreeSet<E> sort(Collection<E> collection)
    {
        TreeSet<E> sortedSet = new TreeSet<E>();
        for (E e : collection)
        {
            sortedSet.add(e);
        }
        return sortedSet;
    }

    /**
     * Converts an array into a list
     * 
     * @param <E>
     * @param array
     * @return list representation of a given array
     */
    public static <E> List<E> toList(E[] array)
    {
        ArrayList<E> result = new ArrayList<E>(array.length);
        for (int i = 0; i < array.length; i++)
            result.add(array[i]);
        return result;
    }

}
