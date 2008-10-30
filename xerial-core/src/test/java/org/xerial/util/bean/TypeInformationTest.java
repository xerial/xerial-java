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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        assertTrue(TypeInformation.isBasicType(Date.class));

        assertTrue(TypeInformation.isBasicType(Enum.class));

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

}
