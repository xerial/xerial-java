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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Pair;
import org.xerial.util.Triplet;
import org.xerial.util.bean.sample.Book;
import org.xerial.util.log.Logger;

public class TypeInfoTest
{
    private static Logger _logger = Logger.getLogger(TypeInfoTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    enum SampleEnum {
        A, B, C
    }

    @Test
    public void testIsBasicType() {
        assertTrue(TypeInfo.isBasicType(Integer.class));
        assertTrue(TypeInfo.isBasicType(int.class));
        assertTrue(TypeInfo.isBasicType(Double.class));
        assertTrue(TypeInfo.isBasicType(double.class));
        assertTrue(TypeInfo.isBasicType(Float.class));
        assertTrue(TypeInfo.isBasicType(float.class));
        assertTrue(TypeInfo.isBasicType(Boolean.class));
        assertTrue(TypeInfo.isBasicType(boolean.class));
        assertTrue(TypeInfo.isBasicType(Character.class));
        assertTrue(TypeInfo.isBasicType(char.class));
        assertTrue(TypeInfo.isBasicType(String.class));
        assertTrue(TypeInfo.isBasicType(Date.class));
        assertTrue(TypeInfo.isBasicType(File.class));

        assertTrue(TypeInfo.isBasicType(Integer[].class));
        assertTrue(TypeInfo.isBasicType(int[].class));
        assertTrue(TypeInfo.isBasicType(Double[].class));
        assertTrue(TypeInfo.isBasicType(double[].class));
        assertTrue(TypeInfo.isBasicType(Float[].class));
        assertTrue(TypeInfo.isBasicType(float[].class));
        assertTrue(TypeInfo.isBasicType(Boolean[].class));
        assertTrue(TypeInfo.isBasicType(boolean[].class));
        assertTrue(TypeInfo.isBasicType(Character[].class));
        assertTrue(TypeInfo.isBasicType(char[].class));
        assertTrue(TypeInfo.isBasicType(String[].class));

        assertTrue(TypeInfo.isBasicType(Date.class));
        assertTrue(TypeInfo.isBasicType(SampleEnum.class));

        assertFalse(TypeInfo.isBasicType(Collection.class));

    }

    @Test
    public void testIsCollection() {
        assertTrue(TypeInfo.isCollection(Collection.class));
        assertTrue(TypeInfo.isCollection(List.class));
        assertTrue(TypeInfo.isCollection(Set.class));
        assertTrue(TypeInfo.isCollection(ArrayList.class));
        assertTrue(TypeInfo.isCollection(LinkedList.class));
        assertTrue(TypeInfo.isCollection(HashSet.class));
        assertTrue(TypeInfo.isCollection(TreeSet.class));
        assertTrue(TypeInfo.isCollection(ArrayDeque.class));

    }

    @Test
    public void testIsSet() {
        assertTrue(TypeInfo.isSet(Set.class));
        assertTrue(TypeInfo.isSet(HashSet.class));
        assertTrue(TypeInfo.isSet(TreeSet.class));

        assertFalse(TypeInfo.isSet(Map.class));
        assertFalse(TypeInfo.isSet(String.class));
    }

    @Test
    public void testIsSortedSet() {
        assertFalse(TypeInfo.isSortedSet(Set.class));
        assertFalse(TypeInfo.isSortedSet(HashSet.class));
        assertTrue(TypeInfo.isSortedSet(TreeSet.class));

        assertFalse(TypeInfo.isSortedSet(Map.class));
        assertFalse(TypeInfo.isSortedSet(LinkedList.class));

    }

    @Test
    public void testIsSortedMap() {
        assertFalse(TypeInfo.isSortedMap(Map.class));
        assertFalse(TypeInfo.isSortedMap(HashMap.class));
        assertTrue(TypeInfo.isSortedMap(TreeMap.class));
    }

    @Test
    public void testIsMap() {
        assertTrue(TypeInfo.isMap(Map.class));
        assertTrue(TypeInfo.isMap(HashMap.class));
        assertTrue(TypeInfo.isMap(TreeMap.class));
        assertFalse(TypeInfo.isMap(Collection.class));

    }

    @Test
    public void testIsPair() {
        assertTrue(TypeInfo.isPair(Pair.class));
        assertTrue(!TypeInfo.isPair(Triplet.class));
    }

    @Test
    public void testIsTriplet() {
        assertTrue(!TypeInfo.isTriplet(Pair.class));
        assertTrue(TypeInfo.isTriplet(Triplet.class));
    }

    @Test
    public void testIsQueue() throws Exception {
        assertTrue(TypeInfo.isQueue(Queue.class));
        assertTrue(TypeInfo.isQueue(ArrayDeque.class));
        assertFalse(TypeInfo.isQueue(ArrayList.class));
    }

    @Test
    public void testIsString() {
        assertTrue(TypeInfo.isString(String.class));
        assertFalse(TypeInfo.isString(char.class));
        assertFalse(TypeInfo.isString(List.class));

        assertFalse(TypeInfo.isString(String[].class));

    }

    @Test
    public void testIsBoolean() {
        assertTrue(TypeInfo.isBoolean(Boolean.class));
        assertTrue(TypeInfo.isBoolean(boolean.class));
        assertFalse(TypeInfo.isBoolean(Boolean[].class));
        assertFalse(TypeInfo.isBoolean(boolean[].class));
    }

    @Test
    public void testIsDOMElement() {
        assertTrue(TypeInfo.isDOMElement(Element.class));
        assertFalse(TypeInfo.isDOMElement(Node.class));
        assertFalse(TypeInfo.isDOMElement(Text.class));

    }

    @Test
    public void testHasPublicConstructor() {
        assertTrue(TypeInfo.hasPublicDefaultConstructor(Book.class));
        assertTrue(TypeInfo.hasPublicDefaultConstructor(TypeInfoTest.class));
        assertFalse(TypeInfo.hasPublicDefaultConstructor(TypeInfo.class));
    }

    @Test
    public void testCanInstantiate() {
        assertTrue(TypeInfo.canInstantiate(Book.class));
        assertTrue(TypeInfo.canInstantiate(TypeInfoTest.class));
        assertFalse(TypeInfo.canInstantiate(TypeInfo.class));

        assertTrue(TypeInfo.canInstantiate(List.class));
        assertTrue(TypeInfo.canInstantiate(Set.class));
        assertTrue(TypeInfo.canInstantiate(Map.class));
        assertTrue(TypeInfo.canInstantiate(Queue.class));
    }

    @Test
    public void testCreateInstance() throws XerialException {
        HashMap< ? , ? > map = (HashMap< ? , ? >) TypeInfo.createInstance(HashMap.class);
        String str = (String) TypeInfo.createInstance(String.class);
    }

    public static class ImmutableObj
    {
        public final int    id;
        public final String data;

        public ImmutableObj(int id, String data) {
            this.id = id;
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("id:%s, data:%s", id, data);
        }
    }

    @Test
    public void createInstance() throws Exception {
        ImmutableObj obj = TypeInfo.createInstance(ImmutableObj.class);
        assertNotNull(obj);
    }

}
