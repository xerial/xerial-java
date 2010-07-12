/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// ReflectionUtilTest.java
// Since: 2009/05/20 19:40:48
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.util.Pair;

public class ReflectionUtilTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public static class Param {
        public Map<Long, String> id_name;
        public List<String> note;
        public Map<Integer, Map<Integer, String>> id_rid_name;

        public List<List<String>> nestedList;
    }

    @Test
    public void testCollectionType() throws Exception {
        Type elementType = ReflectionUtil.getGenericCollectionElementType(Param.class
                .getField("note"));
        assertEquals(String.class, elementType);

        Type elementType2 = ReflectionUtil.getGenericCollectionElementRawType(Param.class
                .getField("nestedList"));

        assertTrue(ParameterizedType.class.isInstance(elementType2));

        ParameterizedType pt = ParameterizedType.class.cast(elementType2);
        Type[] typeArgument = pt.getActualTypeArguments();
        assertEquals(1, typeArgument.length);
        assertEquals(String.class, typeArgument[0]);

        Type rawType = pt.getRawType();
        assertEquals(List.class, rawType);

    }

    @Test
    public void testMapType() throws Exception {
        Pair<Type, Type> key_value_type = ReflectionUtil.getGenericMapElementTypes(Param.class
                .getField("id_name"));
        assertEquals(Long.class, key_value_type.getFirst());
        assertEquals(String.class, key_value_type.getSecond());

        Pair<Type, Type> key_value_type2 = ReflectionUtil.getGenericMapElementTypes(Param.class
                .getField("id_rid_name"));
        assertEquals(Integer.class, key_value_type2.getFirst());

        // TODO nested map type
        // assertEquals(Map.class, key_value_type2.getSecond());

    }

    public static class RawTypes {
        public String p1;
        public List<String> p2;
        public List<List<String>> p3;

    }

    @Test
    public void testGetRawType() throws Exception {
        assertEquals(String.class, RawTypes.class.getField("p1").getType());
        assertEquals(List.class, RawTypes.class.getField("p2").getType());
        assertEquals(List.class, RawTypes.class.getField("p3").getType());

    }

    public static class WithArray {
        public int[] vector;
    }

    @Ignore
    @Test
    public void addingToArrayType() throws Exception {
        WithArray w = new WithArray();
        Field field = WithArray.class.getField("vector");
        // TODO: Should we support adder for array field?
        ReflectionUtil.setFieldValue(w, field, 1);
    }

}
