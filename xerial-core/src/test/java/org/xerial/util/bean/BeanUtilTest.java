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
// BeanUtilTest.java
// Since: 2007/03/29
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.TypeInfo;
import org.xerial.util.log.Logger;

/**
 * 
 * @author leo
 * 
 */
public class BeanUtilTest {
    private static Logger _logger = Logger.getLogger(BeanUtilTest.class);

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}

    @Test
    public void pickPropertyName() {
        String getterName = BeanUtil.pickPropertyName("getSomething");
        assertEquals("something", getterName);
        String setterName = BeanUtil.pickPropertyName("setPersonName");
        assertEquals("personName", setterName);
        String adderName = BeanUtil.pickPropertyName("addObject");
        assertEquals("object", adderName);

        assertNotNull(BeanUtil.pickPropertyName("put"));
    }

    class PrivateGetterSetter {
        Double value;

        public PrivateGetterSetter(Double value) {
            this.value = value;
        }

        private Double getValue() {
            return value;
        }

        private void setValue(Double value) {
            this.value = value;
        }

    }

    @Test
    public void basicType() {
        Class< ? >[] basicType = { int.class, double.class, float.class, boolean.class,
                String.class, Integer.class, Double.class, Float.class, Boolean.class };
        for (Class c : basicType)
            assertTrue(TypeInfo.isBasicType(c));

        Class< ? >[] basicArrayType = { int[].class, double[].class, float[].class,
                boolean[].class, String[].class, Integer[].class, Double[].class, Float[].class,
                Boolean[].class };

        for (Class c : basicArrayType) {
            assertTrue(TypeInfo.isBasicType(c));
        }
    }

}
