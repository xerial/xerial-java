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

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;
import org.xerial.json.JSONLens;
import org.xerial.json.JSONObject;
import org.xerial.util.FileResource;
import org.xerial.util.ObjectHandler;
import org.xerial.util.ObjectHandlerBase;
import org.xerial.util.StopWatch;
import org.xerial.util.bean.sample.Book;
import org.xerial.util.bean.sample.Gene;
import org.xerial.util.bean.sample.GenePartial;
import org.xerial.util.bean.sample.Person;
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

    /**
     * Test method for
     * {@link org.utgenome.util.bean.BeanUtil#toJSON(java.lang.Object)}.
     * 
     * @throws JSONException
     * @throws UTGBException
     * @throws UTGBException
     * @throws JSONException
     * @throws JSONException
     * @throws XerialException
     * @throws JSONException
     */
    @Test
    public void simpleBeanClassToJSON() throws XerialException, JSONException {
        String str = JSONLens.toJSON(new Person(5, "leo"));
        JSONObject json = new JSONObject(str);
        assertEquals(5, json.getInt("id"));
        assertEquals("leo", json.getString("name"));
    }

    @Test
    public void classWithArrayParameterToJSON() throws JSONException, XerialException {
        String str = JSONLens.toJSON(new Book("Data on the Web", new String[] { "Abiteboul",
                "Buneman" }));
        JSONObject json = new JSONObject(str);
        JSONArray author = json.getJSONArray("author");
        assertEquals(2, author.size());
        assertEquals("Abiteboul", author.get(0).toString());
        assertEquals("Buneman", author.get(1).toString());
        assertEquals("Data on the Web", json.getString("title"));
    }

    /*
     * @Test public void addBean() throws InvalidJSONDataException,
     * XerialException { Value[] va = {new Value("1"), new Value("2"), new
     * Value("invalid", "-1")}; Vector<Value> v = new Vector<Value>();
     * for(Value value : va) v.add(value); ValueDomain vd = new ValueDomain(v);
     * String json = JSONLens.toJSON(vd);
     * 
     * ValueDomain vd2 = new ValueDomain(); BeanUtil.populateBean(vd2, json);
     * int i =0; assertEquals(va.length, vd2.getValueList().size()); for(Object
     * obj : vd2.getValueList()) { Value val = (Value) obj;
     * assertEquals(va[i].getLabel(), val.getLabel());
     * assertEquals(va[i].getValue(), val.getValue()); i++; } }
     */

    private boolean foundGene1 = false;
    private boolean foundGene2 = false;

    @Test
    public void streamJSONReader() throws IOException, XerialException {
        foundGene1 = false;
        foundGene2 = false;

        StopWatch stopWatch = new StopWatch();
        JSONLens.loadJSON(Gene.class,
                FileResource.open(BeanUtilTest.class, "sample/genelist.json"),
                new ObjectHandlerBase<Gene>() {
                    public void handle(Gene gene) throws Exception {
                        assertNotNull(gene);
                        if (gene.getId() == 1) {
                            assertEquals("gene1", gene.getName());
                            assertEquals(100, gene.getStart());
                            assertEquals(200, gene.getEnd());
                            assertEquals("chr1", gene.getTarget());
                            assertEquals("-", gene.getStrand());
                            foundGene1 = true;
                        }
                        else if (gene.getId() == 2) {
                            assertEquals("gene2", gene.getName());
                            assertEquals(300, gene.getStart());
                            assertEquals(500, gene.getEnd());
                            assertEquals("chr2", gene.getTarget());
                            assertEquals("+", gene.getStrand());
                            foundGene2 = true;
                        }
                        else {
                            fail("invalid gene");
                        }

                    }

                    public void handleException(Exception e) {
                        _logger.error(e);
                    }

                });
        _logger.debug("loadJSON time: " + stopWatch.getElapsedTime());

        assertTrue(foundGene1);
        assertTrue(foundGene2);

    }

    @Test
    public void partialMatchTest() throws XerialException, IOException {
        foundGene1 = false;
        foundGene2 = false;

        StopWatch stopWatch = new StopWatch();
        JSONLens.findFromJSON(FileResource.open(BeanUtilTest.class, "sample/genelist.json"),
                "gene", GenePartial.class, new ObjectHandler<GenePartial>() {
                    public void handle(GenePartial gene) throws Exception {
                        assertNotNull(gene);
                        if (gene.getId() == 1) {
                            assertEquals(100, gene.getStart());
                            assertEquals(200, gene.getEnd());
                            assertEquals("chr1", gene.getTarget());
                            assertEquals("-", gene.getStrand());
                            foundGene1 = true;
                        }
                        else if (gene.getId() == 2) {
                            assertEquals(300, gene.getStart());
                            assertEquals(500, gene.getEnd());
                            assertEquals("chr2", gene.getTarget());
                            assertEquals("+", gene.getStrand());
                            foundGene2 = true;
                        }
                        else {
                            fail("invalid gene");
                        }

                    }

                    public void handleException(Exception e) {
                        _logger.error(e);
                    }

                    @Override
                    public void init() throws Exception {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void finish() throws Exception {
                        // TODO Auto-generated method stub

                    }

                });
        _logger.debug("loadJSON time: " + stopWatch.getElapsedTime());

        assertTrue(foundGene1);
        assertTrue(foundGene2);

    }

}
