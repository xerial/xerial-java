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

import java.io.File;
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
import java.util.concurrent.ConcurrentHashMap;

import org.w3c.dom.Element;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Pair;
import org.xerial.util.Triplet;

/**
 * TypeInfo holds the information of standard types that can be directly
 * assignable as Bean parameter values. For example, int/Integer, double/Double,
 * String, etc. and their arrays are basic types.
 * 
 * @author leo
 * 
 */
public class TypeInfo {
    static private Class< ? >[] _parameterClass = { int.class, double.class, float.class,
            long.class, boolean.class, char.class, short.class, String.class, Integer.class,
            Double.class, Float.class, Long.class, Boolean.class, Character.class, Short.class,
            Date.class, File.class };

    static private HashSet<Class< ? >> basicTypeSet = new HashSet<Class< ? >>();
    static {
        for (Class< ? > c : _parameterClass)
            basicTypeSet.add(c);
    }

    /**
     * non-constructable
     */
    private TypeInfo() {}

    /**
     * @param c
     * @return true : if a given class is a single class or array of int,
     *         double, float, boolean, String, Integer, Double, Float, Boolean,
     *         or File. otherwise false.
     */
    public static boolean isBasicType(Class< ? > c) {
        if (c.isArray())
            return basicTypeSet.contains(c.getComponentType());
        else if (c.isEnum())
            return true;
        else
            return basicTypeSet.contains(c);
    }

    public static boolean isIterable(Class< ? > c) {
        return Iterable.class.isAssignableFrom(c);
    }

    public static boolean isCollection(Class< ? > c) {
        return Collection.class.isAssignableFrom(c);
    }

    public static boolean isSet(Class< ? > c) {
        return Set.class.isAssignableFrom(c);
    }

    public static boolean isSortedSet(Class< ? > c) {
        return SortedSet.class.isAssignableFrom(c);
    }

    public static boolean isSortedMap(Class< ? > c) {
        return SortedMap.class.isAssignableFrom(c);
    }

    public static boolean isMap(Class< ? > c) {
        return Map.class.isAssignableFrom(c);
    }

    public static boolean isQueue(Class< ? > c) {
        return Queue.class.isAssignableFrom(c);
    }

    public static boolean isEnum(Class< ? > c) {
        return c.isEnum();
    }

    public static boolean isArray(Class< ? > c) {
        return c.isArray();
    }

    public static boolean isString(Class< ? > c) {
        return String.class.isAssignableFrom(c);
    }

    public static boolean isBoolean(Class< ? > c) {
        return boolean.class.isAssignableFrom(c) || Boolean.class.isAssignableFrom(c);
    }

    public static boolean isDOMElement(Class< ? > c) {
        return Element.class.isAssignableFrom(c);
    }

    public static boolean isPair(Class< ? > c) {
        return Pair.class.isAssignableFrom(c);
    }

    public static boolean isTriplet(Class< ? > c) {
        return Triplet.class.isAssignableFrom(c);
    }

    public static boolean hasDefaultConstructor(Class< ? > c) {
        for (Constructor< ? > constructor : c.getConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPublicDefaultConstructor(Class< ? > c) {
        return getPublicDefaultConstructor(c) != null;
    }

    public static Constructor< ? > getPublicDefaultConstructor(Class< ? > c) {
        for (Constructor< ? > constructor : c.getConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                // the default constructor is public?
                if (Modifier.isPublic(constructor.getModifiers())) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public static boolean canInstantiate(Class< ? > c) {
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
    private static <T> Class<T> alternateConstractableClassFor(Class<T> c) {
        if (hasPublicDefaultConstructor(c))
            return c;

        if (isCollection(c)) {
            if (isSet(c)) {
                if (isSortedSet(c))
                    return (Class<T>) TreeSet.class;
                else
                    return (Class<T>) LinkedHashSet.class;
            }
            else if (isQueue(c)) {
                return (Class<T>) ArrayDeque.class;
            }
            else
                return (Class<T>) ArrayList.class;
        }
        else if (isMap(c)) {
            if (isSortedMap(c))
                return (Class<T>) TreeMap.class;
            else
                return (Class<T>) LinkedHashMap.class;
        }

        return null;
    }

    public static <T> Object createPrimitiveTypeInstance(Class<T> c) throws XerialException {
        if (!c.isPrimitive())
            throw new XerialException(XerialErrorCode.InvalidType, String.format(
                    "%s is not a primitive", c.getSimpleName()));

        // Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE
        if (c == int.class)
            return 0;
        else if (c == long.class)
            return 1L;
        else if (c == double.class)
            return (double) 0;
        else if (c == boolean.class)
            return false;
        else if (c == float.class)
            return (float) 0;
        else if (c == short.class)
            return (short) 0;
        else if (c == byte.class)
            return (byte) 0;
        else if (c == char.class)
            return (char) 0;
        else
            return null;

    }

    //    public static <T> Object createInstance(Class<T> c) throws XerialException
    //    {
    //        if (c.isPrimitive())
    //            return createPrimitiveTypeInstance(c);
    //
    //        try
    //        {
    //            Class<T> constractableClass = alternateConstractableClassFor(c);
    //            if (constractableClass == null)
    //                throw new XerialException(XerialErrorCode.NoPublicConstructor, "No public constructor for the class: "
    //                        + c.getName() + " is available");
    //            
    //            return constractableClass.newInstance();
    //        }
    //        catch (InstantiationException e)
    //        {
    //            throw new XerialException(XerialErrorCode.InstantiationFailure, e);
    //        }
    //        catch (IllegalAccessException e)
    //        {
    //            throw new XerialException(XerialErrorCode.IllegalAccess, e);
    //        }
    //    }

    private static ConcurrentHashMap<Class< ? >, Constructor< ? >> constructorTable = new ConcurrentHashMap<Class< ? >, Constructor< ? >>();

    private static <T> Object createInstance(Constructor< ? > cons) throws XerialException {
        try {
            Class< ? >[] argType = cons.getParameterTypes();
            Object[] args = new Object[argType.length];
            for (int i = 0; i < argType.length; ++i)
                args[i] = createInstance(argType[i]);
            return cons.newInstance(args);
        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.InstantiationFailure, e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T createInstance(Class<T> c) throws XerialException {
        if (c.isPrimitive())
            return (T) createPrimitiveTypeInstance(c);

        try {
            Constructor< ? > cons = constructorTable.get(c);
            if (cons != null) {
                return (T) createInstance(cons);
            }

            assert cons == null;

            Class<T> constractableClass = alternateConstractableClassFor(c);
            if (constractableClass != null) {
                cons = getPublicDefaultConstructor(constractableClass);
                assert cons != null;
                constructorTable.put(c, cons);
                return constractableClass.newInstance();
            }
            else {
                // search other public constructors
                for (Constructor< ? > publicConstructor : c.getConstructors()) {
                    try {
                        Object instance = createInstance(publicConstructor);
                        constructorTable.put(c, publicConstructor);
                        return (T) instance;
                    }
                    catch (Exception e) {

                    }
                }

                // search hidden constructors
                for (Constructor< ? > constructor : c.getDeclaredConstructors()) {
                    try {
                        constructor.setAccessible(true);
                        Object instance = createInstance(constructor);
                        constructorTable.put(c, constructor);
                        return (T) instance;
                    }
                    catch (Exception e) {

                    }
                }

                throw new XerialException(XerialErrorCode.NoPublicConstructor,
                        "No public constructor for the class: " + c.getName() + " is available");

            }
        }
        catch (InstantiationException e) {
            throw new XerialException(XerialErrorCode.InstantiationFailure, e);
        }
        catch (IllegalAccessException e) {
            throw new XerialException(XerialErrorCode.IllegalAccess, e);
        }
    }

    public static Class< ? > getElementTypeOfCollection(
            Class< ? extends Collection< ? >> collectionType) {
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

    public static ParameterizedType getParameterizedType(Type t) {
        if (t == null)
            return null;

        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            return pt;
        }
        if (t instanceof Class)
            return getParameterizedType(((Class< ? >) t).getGenericSuperclass());
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    public static ParameterizedType getParentParameterizedType(Type t, Class target) {
        if (t == null)
            return null;

        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            if (target.isAssignableFrom((Class) pt.getRawType())) {
                return pt;
            }
        }

        if (t instanceof Class) {
            Class c = (Class) t;
            return getParentParameterizedType(c.getGenericSuperclass(), target);
        }
        else
            return null;
    }

    public static Class< ? > resolveRawType(Type type, Class< ? > orig) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return resolveRawType(pt.getRawType(), orig);
        }
        else if (type instanceof Class)
            return (Class< ? >) type;
        else
            return orig;
    }

    public static Class< ? > resolveRawType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return resolveRawType(pt.getRawType());
        }
        else if (type instanceof Class)
            return (Class< ? >) type;
        else
            return Object.class;
    }

}
