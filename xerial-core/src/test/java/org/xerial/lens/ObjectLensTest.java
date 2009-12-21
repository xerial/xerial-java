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
// ObjectLensTest.java
// Since: May 19, 2009 12:23:25 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.Pair;
import org.xerial.util.log.Logger;

public class ObjectLensTest {

    private static Logger _logger = Logger.getLogger(ObjectLensTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void pickPairedName() throws Exception {
        Pair<String, String> p = ObjectLens.pickRelationName("Invoice_Order");
        assertEquals("invoice", p.getFirst());
        assertEquals("order", p.getSecond());

        p = ObjectLens.pickRelationName("LineItem_Order");
        assertEquals("lineitem", p.getFirst());
        assertEquals("order", p.getSecond());

        p = ObjectLens.pickRelationName("gene_JSON");
        assertEquals("gene", p.getFirst());
        assertEquals("json", p.getSecond());

        p = ObjectLens.pickRelationName("_");
        assertEquals("", p.getFirst());
        assertEquals("", p.getSecond());

    }

    @Test
    public void pickPropertyName() throws Exception {
        String c = ObjectLens.pickPropertyName("addSomething");
        assertEquals("something", c);

        c = ObjectLens.pickPropertyName("addSomethingImportant");
        assertEquals("somethingimportant", c);

        c = ObjectLens.pickPropertyName("add");
        assertEquals("", c);

    }

    @Test
    public void canonicalNameTest() throws Exception {
        assertEquals("itemrgb", ObjectLens.getCanonicalParameterName("itemRgb"));
        assertEquals("itemref", ObjectLens.getCanonicalParameterName("item_ref"));
        assertEquals("helloworld", ObjectLens.getCanonicalParameterName("Hello World"));
        assertEquals("helloworld", ObjectLens.getCanonicalParameterName("Hello-World"));

    }

    public static class ExtMap extends TreeMap<Integer, String> {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        public String name = "ext-map";

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ExtMap))
                return false;

            ExtMap other = (ExtMap) o;

            return name.equals(other.name) && super.equals(other);

        }
    }

    @Test
    public void mapTest() throws Exception {
        ExtMap extMap = new ExtMap();
        extMap.put(1, "hello");
        extMap.put(10, "world");
        String json = ObjectLens.toJSON(extMap);
        _logger.debug(json);

        ExtMap extMap2 = Lens.loadJSON(ExtMap.class, new StringReader(json));
        _logger.debug(ObjectLens.toJSON(extMap2));

        assertEquals(extMap, extMap2);
    }

    public static class ExtList extends ArrayList<Integer> {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        public String name = "ext-list";

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ExtList))
                return false;

            ExtList other = (ExtList) o;

            return name.equals(other.name) && super.equals(other);

        }
    }

    @Test
    public void arrayTest() throws Exception {
        ExtList extList = new ExtList();

        extList.add(10);
        extList.add(14);

        String json = ObjectLens.toJSON(extList);
        _logger.debug(json);

        ExtList extList2 = Lens.loadJSON(ExtList.class, new StringReader(json));
        _logger.debug(ObjectLens.toJSON(extList2));

        assertEquals(extList, extList2);

    }

    public static class PropReader {
        Properties prop = new Properties();

        public void put(String key, String value) {
            prop.put(key, value);
        }
    }

    public static class Person {
        public int id;
        public String name;
    }

    @Test
    public void getParameter() throws Exception {
        Person p = new Person();
        p.id = 10;
        p.name = "leo";
        ObjectLens lens = ObjectLens.getObjectLens(Person.class);

        Object id = lens.getParameter(p, "id");
        assertNotNull(id);
        assertEquals(p.id, Integer.class.cast(id));
        Object name = lens.getParameter(p, "name");
        assertNotNull(name);
        assertEquals(p.name, String.class.cast(name));

    }

    @Test
    public void setParameter() throws Exception {
        Person p = new Person();
        p.id = 10;
        p.name = "leo";

        ObjectLens lens = ObjectLens.getObjectLens(Person.class);
        lens.setParameter(p, "id", 50);
        lens.setParameter(p, "name", "yui");

        assertEquals(50, p.id);
        assertEquals("yui", p.name);

    }

}
