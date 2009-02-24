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
// XerialJ
//
// TypeInformation.java
// Since: Aug 9, 2007 9:37:40 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.w3c.dom.Element;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Pair;
import org.xerial.util.Triplet;

/**
 * BasicType class holds information of standard types that can be directly
 * assignable as Bean parameter values. For example, int/Integer, double/Double,
 * String, etc. and their arrays are basic types.
 * 
 * @author leo
 * 
 */
public class TypeInformation
{
    static private Class< ? >[] _parameterClass = { int.class, double.class, float.class, long.class, boolean.class,
            char.class, short.class, String.class, Integer.class, Double.class, Float.class, Long.class, Boolean.class,
            Character.class, Short.class, Date.class };

    static private HashSet<Class< ? >> basicTypeSet = new HashSet<Class< ? >>();
    static
    {
        for (Class< ? > c : _parameterClass)
            basicTypeSet.add(c);
    }

    /**
     * non-constractable
     */
    private TypeInformation()
    {}

    /**
     * @param c
     * @return true : if a given class is a single class or array of int,
     *         double, float, boolean, String, Integer, Double, Float or
     *         Boolean. otherwise false.
     */
    public static boolean isBasicType(Class< ? > c)
    {
        if (c.isArray())
            return basicTypeSet.contains(c.getComponentType());
        else if (c.isEnum())
            return true;
        else
            return basicTypeSet.contains(c);
    }

    public static boolean isCollection(Class< ? > c)
    {
        return Collection.class.isAssignableFrom(c);
    }

    public static boolean isSet(Class< ? > c)
    {
        return Set.class.isAssignableFrom(c);
    }

    public static boolean isSortedSet(Class< ? > c)
    {
        return SortedSet.class.isAssignableFrom(c);
    }

    public static boolean isSortedMap(Class< ? > c)
    {
        return SortedMap.class.isAssignableFrom(c);
    }

    public static boolean isMap(Class< ? > c)
    {
        return Map.class.isAssignableFrom(c);
    }

    public static boolean isQueue(Class< ? > c)
    {
        return Queue.class.isAssignableFrom(c);
    }

    public static boolean isEnum(Class< ? > c)
    {
        return c.isEnum();
    }

    public static boolean isArray(Class< ? > c)
    {
        return c.isArray();
    }

    public static boolean isString(Class< ? > c)
    {
        return String.class.isAssignableFrom(c);
    }

    public static boolean isBoolean(Class< ? > c)
    {
        return boolean.class.isAssignableFrom(c) || Boolean.class.isAssignableFrom(c);
    }

    public static boolean isDOMElement(Class< ? > c)
    {
        return Element.class.isAssignableFrom(c);
    }

    public static boolean isPair(Class< ? > c)
    {
        return Pair.class.isAssignableFrom(c);
    }

    public static boolean isTriplet(Class< ? > c)
    {
        return Triplet.class.isAssignableFrom(c);
    }

    public static boolean hasPublicConstructor(Class< ? > c)
    {
        for (Constructor< ? > constructor : c.getConstructors())
        {
            if (constructor.getParameterTypes().length == 0)
            {
                // the default constructor is public?
                if (Modifier.isPublic(constructor.getModifiers()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canInstantiate(Class< ? > c)
    {
        // do not worry about basic types
        return (isBasicType(c) || alternateConstractableClassFor(c) != null);
    }

    /**
     * @param <T>
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    // type cast is tested
    private static <T> Class<T> alternateConstractableClassFor(Class<T> c)
    {
        if (hasPublicConstructor(c))
            return c;

        if (isCollection(c))
        {
            if (isSet(c))
            {
                if (isSortedSet(c))
                    return (Class<T>) TreeSet.class;
                else
                    return (Class<T>) LinkedHashSet.class;
            }
            else if (isQueue(c))
            {
                return (Class<T>) ArrayDeque.class;
            }
            else
                return (Class<T>) ArrayList.class;
        }
        else if (isMap(c))
        {
            if (isSortedMap(c))
                return (Class<T>) TreeMap.class;
            else
                return (Class<T>) LinkedHashMap.class;
        }

        return null;
    }

    public static <T> T createInstance(Class<T> c) throws BeanException
    {

        Class<T> constractableClass = alternateConstractableClassFor(c);
        if (constractableClass == null)
            throw new BeanException(BeanErrorCode.NoPublicConstructor, "public constructor for the class: "
                    + c.getName() + " is not available");

        try
        {
            return constractableClass.newInstance();
        }
        catch (InstantiationException e)
        {
            throw new BeanException(BeanErrorCode.InstantiationFailure, e);
        }
        catch (IllegalAccessException e)
        {
            throw new BeanException(BeanErrorCode.IllegalAccess, e);
        }
    }

    public static Class< ? > getElementTypeOfCollection(Class< ? extends Collection< ? >> collectionType)
    {
        //        collectionType.get
        //        
        //        ParameterizedType pt = getParentParameterizedType(type, Collection.class);
        //        if (pt != null)
        //        {
        //            Type[] actualType = pt.getActualTypeArguments();
        //            if (actualType.length > 0)
        //                return resolveRawType(actualType[0], orig);
        //        }
        //        return orig;
        return null;
    }

    public static ParameterizedType getParameterizedType(Type t)
    {
        if (t == null)
            return null;

        if (t instanceof ParameterizedType)
        {
            ParameterizedType pt = (ParameterizedType) t;
            return pt;
        }
        if (t instanceof Class)
            return getParameterizedType(((Class< ? >) t).getGenericSuperclass());
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    public static ParameterizedType getParentParameterizedType(Type t, Class target)
    {
        if (t == null)
            return null;

        if (t instanceof ParameterizedType)
        {
            ParameterizedType pt = (ParameterizedType) t;
            if (target.isAssignableFrom((Class) pt.getRawType()))
            {
                return pt;
            }
        }

        if (t instanceof Class)
        {
            Class c = (Class) t;
            return getParentParameterizedType(c.getGenericSuperclass(), target);
        }
        else
            return null;
    }

    public static Class< ? > resolveRawType(Type type, Class< ? > orig)
    {
        if (type instanceof ParameterizedType)
        {
            ParameterizedType pt = (ParameterizedType) type;
            return resolveRawType(pt.getRawType(), orig);
        }
        else if (type instanceof Class)
            return (Class< ? >) type;
        else
            return orig;
    }

    public static Class< ? > resolveRawType(Type type)
    {
        if (type instanceof ParameterizedType)
        {
            ParameterizedType pt = (ParameterizedType) type;
            return resolveRawType(pt.getRawType());
        }
        else if (type instanceof Class)
            return (Class< ? >) type;
        else
            return Object.class;
    }

}
