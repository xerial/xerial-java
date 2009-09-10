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
// TypeReferenceTest.java
// Since: 2008/10/29 8:06:17
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.xerial.core.XerialException;

public class TypeReferenceTest
{

    public void reference() {
        Type c = new TypeReference<List<String>>() {}.getElementType()[0];
        assertEquals(String.class, c);

        Type k = new TypeReference<Map<String, Integer>>() {}.getElementType()[0];
        Type v = new TypeReference<Map<String, Integer>>() {}.getElementType()[1];
        assertEquals(String.class, k);
        assertEquals(Integer.class, v);
    }

    @Test
    public void elementType() {
        Type c = new TypeReference<String>() {}.getType();
        assertEquals(String.class, c);
    }

    class GenericReference
    {
        Class< ? > c;

        public GenericReference(Class< ? > c) {
            this.c = c;
        }

        Object newInstance() {
            try {
                return TypeInfo.createInstance(c);
            }
            catch (XerialException e) {
                return null;
            }
        }

    }

    @Test
    public void genericTypeReference() {
        GenericReference gref = new GenericReference(String.class);

        String str = (String) gref.newInstance();

        assertNotNull(str);
        assertEquals(String.class, str.getClass());

    }

}
