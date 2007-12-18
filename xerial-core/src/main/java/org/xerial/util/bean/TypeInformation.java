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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.w3c.dom.Element;


/**
 * BasicType class holds information of standard types that can be directly
 * assignable as Bean parameter values. For example, int/Integer, double/Double,
 * String, etc. and their arrays are basic types.
 * 
 * @author leo
 * 
 */
class TypeInformation {
    static private Class[] _parameterClass = { int.class, double.class, float.class, boolean.class, String.class, Integer.class, Double.class, Float.class,
            Boolean.class };

    static private HashSet<Class> basicTypeSet = new HashSet<Class>();
    static {
        for (Class c : _parameterClass)
            basicTypeSet.add(c);
    }

    /**
     * @param c
     * @return true : if a given class is a single class or array of int,
     *         double, float, boolean, String, Integer, Double, Float or
     *         Boolean. otherwise false.
     */
    public static boolean isBasicType(Class c) {
        if (c.isArray())
            return basicTypeSet.contains(c.getComponentType());
        else
            return basicTypeSet.contains(c);
    }

    public static boolean isCollection(Class c) {
        return Collection.class.isAssignableFrom(c);
    }

    public static boolean isSet(Class c) {
        return Set.class.isAssignableFrom(c);
    }

    public static boolean isSortedSet(Class c) {
        return SortedSet.class.isAssignableFrom(c);
    }

    public static boolean isSortedMap(Class c) {
        return SortedMap.class.isAssignableFrom(c);
    }

    public static boolean isMap(Class c) {
        return Map.class.isAssignableFrom(c);
    }

    public static boolean isString(Class c) {
        return Map.class.isAssignableFrom(c);
    }

    public static boolean isDOMElement(Class c)
    {
        return Element.class.isAssignableFrom(c);
    }
    
    public static boolean hasPublicConstructor(Class c) {
        for (Constructor constructor : c.getConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                // the default constructor is public?
                if (Modifier.isPublic(constructor.getModifiers())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canInstantiate(Class c) {
        // do not worry about basic types
        return (isBasicType(c) || alternateConstractableClassFor(c) != null);
    }

    private static Class alternateConstractableClassFor(Class c) {
        if (hasPublicConstructor(c))
            return c;

        if(isCollection(c))
        {
            if(isSet(c))
            {
                if(isSortedSet(c))
                    return TreeSet.class;
                else
                    return LinkedHashSet.class;
            }
            else
                return ArrayList.class;
        }
        else if(isMap(c))
        {
            if(isSortedMap(c))
                return TreeMap.class;
            else
                return LinkedHashMap.class;
        }

        return null;
    }

    public static Object createInstance(Class c) throws BeanException {

        Class constractableClass = alternateConstractableClassFor(c);
        if (constractableClass == null)
            throw new BeanException(BeanErrorCode.NoPublicConstructor, "public constructor for the class: " + c.getName() + " is not available");

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

}
