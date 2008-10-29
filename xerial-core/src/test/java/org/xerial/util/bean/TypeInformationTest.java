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
// TypeInformationTest.java
// Since: Oct 27, 2008 3:50:25 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xerial.util.bean.sample.Book;
import org.xerial.util.log.Logger;

public class TypeInformationTest
{
    private static Logger _logger = Logger.getLogger(TypeInformationTest.class);
    
    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testIsBasicType()
    {
        assertTrue(TypeInformation.isBasicType(Integer.class));
        assertTrue(TypeInformation.isBasicType(int.class));
        assertTrue(TypeInformation.isBasicType(Double.class));
        assertTrue(TypeInformation.isBasicType(double.class));
        assertTrue(TypeInformation.isBasicType(Float.class));
        assertTrue(TypeInformation.isBasicType(float.class));
        assertTrue(TypeInformation.isBasicType(Boolean.class));
        assertTrue(TypeInformation.isBasicType(boolean.class));
        assertTrue(TypeInformation.isBasicType(Character.class));
        assertTrue(TypeInformation.isBasicType(char.class));
        assertTrue(TypeInformation.isBasicType(String.class));
        assertTrue(TypeInformation.isBasicType(Date.class));

        assertTrue(TypeInformation.isBasicType(Integer[].class));
        assertTrue(TypeInformation.isBasicType(int[].class));
        assertTrue(TypeInformation.isBasicType(Double[].class));
        assertTrue(TypeInformation.isBasicType(double[].class));
        assertTrue(TypeInformation.isBasicType(Float[].class));
        assertTrue(TypeInformation.isBasicType(float[].class));
        assertTrue(TypeInformation.isBasicType(Boolean[].class));
        assertTrue(TypeInformation.isBasicType(boolean[].class));
        assertTrue(TypeInformation.isBasicType(Character[].class));
        assertTrue(TypeInformation.isBasicType(char[].class));
        assertTrue(TypeInformation.isBasicType(String[].class));

        assertFalse(TypeInformation.isBasicType(Collection.class));

    }

    @Test
    public void testIsCollection()
    {
        assertTrue(TypeInformation.isCollection(Collection.class));
        assertTrue(TypeInformation.isCollection(List.class));
        assertTrue(TypeInformation.isCollection(Set.class));
        assertTrue(TypeInformation.isCollection(ArrayList.class));
        assertTrue(TypeInformation.isCollection(LinkedList.class));
        assertTrue(TypeInformation.isCollection(HashSet.class));
        assertTrue(TypeInformation.isCollection(TreeSet.class));

    }

    @Test
    public void testIsSet()
    {
        assertTrue(TypeInformation.isSet(Set.class));
        assertTrue(TypeInformation.isSet(HashSet.class));
        assertTrue(TypeInformation.isSet(TreeSet.class));

        assertFalse(TypeInformation.isSet(Map.class));
        assertFalse(TypeInformation.isSet(String.class));
    }

    @Test
    public void testIsSortedSet()
    {
        assertFalse(TypeInformation.isSortedSet(Set.class));
        assertFalse(TypeInformation.isSortedSet(HashSet.class));
        assertTrue(TypeInformation.isSortedSet(TreeSet.class));

        assertFalse(TypeInformation.isSortedSet(Map.class));
        assertFalse(TypeInformation.isSortedSet(LinkedList.class));

    }

    @Test
    public void testIsSortedMap()
    {
        assertFalse(TypeInformation.isSortedMap(Map.class));
        assertFalse(TypeInformation.isSortedMap(HashMap.class));
        assertTrue(TypeInformation.isSortedMap(TreeMap.class));
    }

    @Test
    public void testIsMap()
    {
        assertTrue(TypeInformation.isMap(Map.class));
        assertTrue(TypeInformation.isMap(HashMap.class));
        assertTrue(TypeInformation.isMap(TreeMap.class));
        assertFalse(TypeInformation.isMap(Collection.class));

    }

    @Test
    public void testIsString()
    {
        assertTrue(TypeInformation.isString(String.class));
        assertFalse(TypeInformation.isString(char.class));
        assertFalse(TypeInformation.isString(List.class));

        assertFalse(TypeInformation.isString(String[].class));

    }

    @Test
    public void testIsBoolean()
    {
        assertTrue(TypeInformation.isBoolean(Boolean.class));
        assertTrue(TypeInformation.isBoolean(boolean.class));
        assertFalse(TypeInformation.isBoolean(Boolean[].class));
        assertFalse(TypeInformation.isBoolean(boolean[].class));
    }

    @Test
    public void testIsDOMElement()
    {
        assertTrue(TypeInformation.isDOMElement(Element.class));
        assertFalse(TypeInformation.isDOMElement(Node.class));
        assertFalse(TypeInformation.isDOMElement(Text.class));

    }

    @Test
    public void testHasPublicConstructor()
    {
        assertTrue(TypeInformation.hasPublicConstructor(Book.class));
        assertTrue(TypeInformation.hasPublicConstructor(TypeInformationTest.class));
        assertFalse(TypeInformation.hasPublicConstructor(TypeInformation.class));
    }

    @Test
    public void testCanInstantiate()
    {
        assertTrue(TypeInformation.canInstantiate(Book.class));
        assertTrue(TypeInformation.canInstantiate(TypeInformationTest.class));
        assertFalse(TypeInformation.canInstantiate(TypeInformation.class));

    }

    @Test
    public void testCreateInstance() throws BeanException
    {
        HashMap< ? , ? > map = (HashMap< ? , ? >) TypeInformation.createInstance(HashMap.class);
        String str = (String) TypeInformation.createInstance(String.class);
    }
    
    /**
     * Get the underlying class for a type, or null if the type is a variable type.
     * @param type the type
     * @return the underlying class
     */
    public static Class<?> getClass(Type type) {
      if (type instanceof Class) {
        return (Class) type;
      }
      else if (type instanceof ParameterizedType) {
        return getClass(((ParameterizedType) type).getRawType());
      }
      else if (type instanceof GenericArrayType) {
        Type componentType = ((GenericArrayType) type).getGenericComponentType();
        Class<?> componentClass = getClass(componentType);
        if (componentClass != null ) {
          return Array.newInstance(componentClass, 0).getClass();
        }
        else {
          return null;
        }
      }
      else {
        return null;
      }
    }
    
    /**
     * Get the actual type arguments a child class has used to extend a generic base class.
     *
     * @param baseClass the base class
     * @param childClass the child class
     * @return a list of the raw classes for the actual type arguments.
     */
    public static <T> List<Class<?>> getTypeArguments(
      Class<T> baseClass, Class<? extends T> childClass) {
      Map<Type, Type> resolvedTypes = new HashMap<Type, Type>();
      Type type = childClass;
      // start walking up the inheritance hierarchy until we hit baseClass
      while (! getClass(type).equals(baseClass)) {
        if (type instanceof Class) {
          // there is no useful information for us in raw types, so just keep going.
          type = ((Class) type).getGenericSuperclass();
        }
        else {
          ParameterizedType parameterizedType = (ParameterizedType) type;
          Class<?> rawType = (Class) parameterizedType.getRawType();
    
          Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
          TypeVariable<?>[] typeParameters = rawType.getTypeParameters();
          for (int i = 0; i < actualTypeArguments.length; i++) {
            resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);
          }
    
          if (!rawType.equals(baseClass)) {
            type = rawType.getGenericSuperclass();
          }
        }
      }
    
      // finally, for each actual type argument provided to baseClass, determine (if possible)
      // the raw class for that type argument.
      Type[] actualTypeArguments;
      if (type instanceof Class) {
        actualTypeArguments = ((Class) type).getTypeParameters();
      }
      else {
        actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
      }
      List<Class<?>> typeArgumentsAsClasses = new ArrayList<Class<?>>();
      // resolve types by chasing down type variables.
      for (Type baseType: actualTypeArguments) {
        while (resolvedTypes.containsKey(baseType)) {
          baseType = resolvedTypes.get(baseType);
        }
        typeArgumentsAsClasses.add(getClass(baseType));
      }
      return typeArgumentsAsClasses;
    }
    
    public static Class<?> getRawClass(final Type type) {
        if (Class.class.isInstance(type)) {
            return Class.class.cast(type);
        }
        if (ParameterizedType.class.isInstance(type)) {
            final ParameterizedType parameterizedType = ParameterizedType.class
                    .cast(type);
            return getRawClass(parameterizedType.getRawType());
        }
        if (GenericArrayType.class.isInstance(type)) {
            final GenericArrayType genericArrayType = GenericArrayType.class
                    .cast(type);
            final Class<?> rawClass = getRawClass(genericArrayType
                    .getGenericComponentType());
            return Array.newInstance(rawClass, 0).getClass();
        }
        return null;
    }
    @Test
    public void getElementClass()
    {
        ArrayList<String> str = new ArrayList<String>();
      
        ParameterizedType pt = ((ParameterizedType) str.getClass().getGenericSuperclass());

        Type t = pt.getActualTypeArguments()[0];
        Class<?> c = (Class<?>) t;
        assertEquals(String.class, c);                

    }

}
