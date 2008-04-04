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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.bean.sample.Address;
import org.xerial.util.bean.sample.Book;
import org.xerial.util.bean.sample.CollectionParam;
import org.xerial.util.bean.sample.ComplexMap;
import org.xerial.util.bean.sample.ComplexType;
import org.xerial.util.bean.sample.Gene;
import org.xerial.util.bean.sample.HogeHoge;
import org.xerial.util.bean.sample.Mate;
import org.xerial.util.bean.sample.NameTable;
import org.xerial.util.bean.sample.Person;
import org.xerial.util.bean.sample.PersonList;
import org.xerial.util.bean.sample.PersonList2;
import org.xerial.util.bean.sample.PersonTable;
import org.xerial.util.bean.sample.PersonVector;
import org.xerial.util.bean.sample.PrimitiveAdder;
import org.xerial.util.bean.sample.TrackInfo;
import org.xerial.util.bean.sample.UnknownTypeMap;
import org.xerial.util.log.Logger;

/**
 * 
 * @author leo
 * 
 */
public class BeanUtilTest
{
    private static Logger _logger = Logger.getLogger(BeanUtilTest.class);

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void pickPropertyName()
    {
        String getterName = BeanUtil.pickPropertyName("getSomething");
        assertEquals("something", getterName);
        String setterName = BeanUtil.pickPropertyName("setPersonName");
        assertEquals("personName", setterName);
        String adderName = BeanUtil.pickPropertyName("addObject");
        assertEquals("object", adderName);

        assertNotNull(BeanUtil.pickPropertyName("put"));
    }

    class PrivateGetterSetter
    {
        Double value;

        public PrivateGetterSetter(Double value)
        {
            this.value = value;
        }

        private Double getValue()
        {
            return value;
        }

        private void setValue(Double value)
        {
            this.value = value;
        }

    }

    @Test
    public void basicType()
    {
        Class[] basicType = { int.class, double.class, float.class, boolean.class, String.class, Integer.class,
                Double.class, Float.class, Boolean.class };
        for (Class c : basicType)
            assertTrue(TypeInformation.isBasicType(c));

        Class[] basicArrayType = { int[].class, double[].class, float[].class, boolean[].class, String[].class,
                Integer[].class, Double[].class, Float[].class, Boolean[].class };

        for (Class c : basicArrayType)
        {
            assertTrue(TypeInformation.isBasicType(c));
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
     * @throws InvalidBeanException
     * @throws JSONException
     */
    @Test
    public void simpleBeanClassToJSON() throws BeanException, JSONException
    {
        String str = BeanUtil.toJSON(new Person(5, "leo"));
        JSONObject json = new JSONObject(str);
        assertEquals(5, json.getInt("id"));
        assertEquals("leo", json.getString("name"));
    }

    @Test
    public void classWithArrayParameterToJSON() throws JSONException, BeanException
    {
        String str = BeanUtil.toJSON(new Book("Data on the Web", new String[] { "Abiteboul", "Buneman" }));
        JSONObject json = new JSONObject(str);
        JSONArray author = json.getJSONArray("author");
        assertEquals(2, author.size());
        assertEquals("Abiteboul", author.get(0).toString());
        assertEquals("Buneman", author.get(1).toString());
        assertEquals("Data on the Web", json.getString("title"));
    }

    @Test
    public void doNotUsePrivateGetter() throws JSONException, BeanException
    {
        String str = BeanUtil.toJSON(new PrivateGetterSetter(1.34));
        JSONObject json = new JSONObject(str);
        // Since getValue() methods is private, BeanUtil.toJSON() method should
        // not output the value 1.34
        assert (!json.hasKey("value"));
        assertEquals(0, json.elementSize());
    }

    @Test
    public void populate() throws JSONException, BeanException
    {
        Person s = new Person(10, "leo");
        Person s2 = new Person();
        BeanUtil.populateBean(s2, BeanUtil.toJSON(s));
        assertEquals(s.getId(), s2.getId());
        assertEquals(s.getName(), s2.getName());
    }

    @Test
    public void populateArray() throws JSONException, BeanException
    {
        Book s1 = new Book("Data on the Web", new String[] { "Abiteboul", "Buneman" });
        Book s2 = new Book();
        BeanUtil.populateBean(s2, BeanUtil.toJSON(s1));
        assertEquals(s1.getTitle(), s2.getTitle());
        assertEquals(s1.getAuthor(), s2.getAuthor());
    }

    @Test
    public void doNotUsePrivateSetter() throws JSONException, BeanException
    {
        PrivateGetterSetter p = new PrivateGetterSetter(0.0);
        BeanUtil.populateBean(p, "{\"value\" : 1.34}");
        assertEquals(0.0, p.getValue());
    }

    @Test
    public void beanWithCollectionParameters() throws BeanException
    {
        String[] name = { "taro", "leo" };
        Vector<String> v = new Vector<String>();
        for (String s : name)
            v.add(s);

        Integer[] idList = { 10, 12, 13 };
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int id : idList)
            a.add(id);
        CollectionParam c = new CollectionParam(v, a);
        String json = BeanUtil.toJSON(c);

        CollectionParam c2 = new CollectionParam();
        BeanUtil.populateBean(c2, json);

        assertEquals(v.size(), c2.getName().size());
        for (int i = 0; i < c.getName().size(); i++)
            assertEquals(c.getName().get(i), c2.getName().get(i));

        assertEquals(a.size(), c2.getId().size());
        for (int i = 0; i < c.getId().size(); i++)
            assertEquals(c.getId().get(i), c2.getId().get(i));

    }

    @Test
    public void nestedBean() throws BeanException
    {
        Address addr = new Address(new Person(3, "leo"), "world");
        String json = BeanUtil.toJSON(addr);
        Address addr2 = new Address();
        BeanUtil.populateBean(addr2, json);

        assertNotNull(addr2.getPerson());
        assertNotNull(addr2.getAddress());

        assertEquals(3, addr2.getPerson().getId());
        assertEquals("leo", addr2.getPerson().getName());
        assertEquals("world", addr2.getAddress());
    }

    @Test
    public void beanCollection() throws BeanException
    {
        Person[] pa = { new Person(1, "leo"), new Person(3, "taro") };
        Vector<Person> pv = new Vector<Person>();
        for (Person p : pa)
            pv.add(p);

        PersonList pl = new PersonList(pv);
        String json = BeanUtil.toJSON(pl);

        PersonList pl2 = new PersonList();
        BeanUtil.populateBean(pl2, json);

        assertNotNull(pl2.getPerson());
        assertEquals(pl.getPerson().size(), pl2.getPerson().size());
        for (int i = 0; i < pl.getPerson().size(); i++)
        {
            Person p1 = pl.getPerson().get(i);
            Person p2 = pl2.getPerson().get(i);
            assertEquals(p1, p2);
        }
    }

    /*
     * @Test public void addBean() throws InvalidJSONDataException,
     * InvalidBeanException { Value[] va = {new Value("1"), new Value("2"), new
     * Value("invalid", "-1")}; Vector<Value> v = new Vector<Value>();
     * for(Value value : va) v.add(value); ValueDomain vd = new ValueDomain(v);
     * String json = BeanUtil.toJSON(vd);
     * 
     * ValueDomain vd2 = new ValueDomain(); BeanUtil.populateBean(vd2, json);
     * int i =0; assertEquals(va.length, vd2.getValueList().size()); for(Object
     * obj : vd2.getValueList()) { Value val = (Value) obj;
     * assertEquals(va[i].getLabel(), val.getLabel());
     * assertEquals(va[i].getValue(), val.getValue()); i++; } }
     */

    @Test
    public void adder() throws BeanException
    {
        int[] ans = { 1, 2, 3 };
        PrimitiveAdder p = new PrimitiveAdder();
        for (int v : ans)
            p.addValueList(v);

        String json = BeanUtil.toJSON(p);
        PrimitiveAdder p2 = new PrimitiveAdder();
        BeanUtil.populateBean(p2, json);

        assertEquals(ans.length, p2.getValueList().size());
        int index = 0;
        for (int v : ans)
        {
            assertEquals(v, p2.getValueList().get(index++));
        }

    }

    @Test
    public void mapBean() throws BeanException
    {
        String[] data = { "apple", "banana", "coconut" };
        NameTable n1 = new NameTable();
        for (int i = 0; i < data.length; i++)
            n1.putNameTable(i, data[i]);

        // json string should have the form: { "nameTable":[ [1, "apple"], [2,
        // "banana"], [3, "coconut"] ] }
        String json = BeanUtil.toJSON(n1);

        NameTable n2 = new NameTable();
        BeanUtil.populateBean(n2, json);

        for (int i = 0; i < data.length; i++)
        {
            assertNotNull(n2.getNameTable(i));
            assertEquals(data[i], n2.getNameTable(i));
        }
    }

    @Test
    public void beanMap() throws BeanException
    {
        Person[] pair1 = { new Person(1, "leo"), new Person(2, "naoko") };
        Person[] pair2 = { new Person(3, "json"), new Person(4, "xml") };

        Mate m1 = new Mate();
        m1.putPair(pair1[0], pair1[1]);
        m1.putPair(pair2[0], pair2[1]);

        // json = { "pair":[[{"id":1, "name":"leo"}, {"id":2, "name":"naoko"}],
        // [{"id":3, "name":"json"}, {"id":4, "name":"xml"}]]}
        String json = BeanUtil.toJSON(m1);

        Mate m2 = new Mate();
        BeanUtil.populateBean(m2, json);
        assertEquals(m1.getPair(pair1[0]), m2.getPair(pair1[0]));
        assertEquals(m1.getPair(pair2[0]), m2.getPair(pair2[0]));
    }

    @Test
    public void treeMapBindRule() throws BeanException
    {
        TreeMap t = new TreeMap<Integer, String>();
        BeanBinderSet bs = BeanUtil.getBeanOutputRule(t.getClass());
        assertTrue(bs.getBindRules().size() == 0);
    }

    @Test
    public void mapOfMap() throws BeanException
    {
        HogeHoge h = new HogeHoge();
        h.map.put(1, "hoge");
        h.map.put(10, "hoge2");
        TreeMap<Integer, String> t = new TreeMap<Integer, String>();
        t.put(4, "hoge3");
        h.graph.put(3, t);

        String json = BeanUtil.toJSON(h);
        _logger.debug(json);

        HogeHoge h2 = new HogeHoge();
        BeanUtil.populateBean(h2, json);
        _logger.debug(BeanUtil.toJSON(h2));

        assertEquals(h.getMap(), h2.getMap());
        assertEquals(h.getGraph().toString(), h2.getGraph().toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void unknwonTypeMap() throws BeanException
    {
        UnknownTypeMap u1 = new UnknownTypeMap("rank");
        u1.put("good", 50);
        u1.put("excellent", 100);

        String json = BeanUtil.toJSON(u1);
        _logger.debug(json);

        UnknownTypeMap u2 = new UnknownTypeMap();
        BeanUtil.populateBean(u2, json);

        assertEquals(u1.size(), u2.size());
        assertEquals(u1.getMapName(), u2.getMapName());
        assertEquals("50", u2.get("good"));
        assertEquals("100", u2.get("excellent"));
    }

    @Test
    public void complexType() throws BeanException, JSONException
    {
        PersonTable p = new PersonTable();
        p.put(1, new Person(100, "leo"));
        p.put(2, new Person(101, "ahsan"));
        ComplexMap m = new ComplexMap();
        m.put(1234, p);
        ComplexType ct = new ComplexType();
        ct.setTable(m);

        String json = BeanUtil.toJSON(ct);

        ComplexType ct2 = new ComplexType();
        BeanUtil.populateBean(ct2, json);

        String json2 = BeanUtil.toJSON(ct2);

        assertEquals(json, json2);

        @SuppressWarnings("unused")
        JSONObject jsonObj = new JSONObject(json);

    }

    class NonConstructableClass
    {
        public NonConstructableClass()
        {}

        public void setName(String value)
        {

        }
    }

    @Ignore
    @Test
    public void constructorCheck()
    {
        try
        {
            // NonConstructableClass c = new NonConstructableClass();
            ArrayList<NonConstructableClass> a = new ArrayList<NonConstructableClass>();
            BeanUtil.populateBean(a, "{\"-c\":[{\"name\":\"leo\"}]}");
        }
        catch (BeanException e)
        {
            return;
        }
        fail("cannot reach here");
    }

    @Ignore
    @Test
    public void constructorCheck2()
    {
        try
        {
            Map<Integer, NonConstructableClass> m = new TreeMap<Integer, NonConstructableClass>();
            BeanUtil.populateBean(m, "{\"-m\":[[1, {\"name\":\"leo\"}]]}");
        }
        catch (BeanException e)
        {
            return;
        }
        fail("cannot reach here");
    }

    @Ignore
    @Test
    public void constructorCheck3()
    {
        try
        {
            Map<NonConstructableClass, String> m = new TreeMap<NonConstructableClass, String>();
            BeanUtil.populateBean(m, "{\"-m\":[[{\"name\":\"leo\"},\"value\"]]}");
        }
        catch (BeanException e)
        {
            return;
        }
        fail("cannot reach here");
    }

    @Test
    public void extendedCollection() throws BeanException
    {
        PersonVector pv = new PersonVector();
        pv.add(new Person(1, "leo"));
        String json = BeanUtil.toJSON(pv);

        PersonVector pv2 = new PersonVector();
        BeanUtil.populateBean(pv2, json);

        assertEquals(1, pv2.size());
        assertEquals(pv, pv2);
    }

    @Test
    public void beanToXML() throws BeanException
    {
        PersonVector pv = new PersonVector();
        pv.add(new Person(1, "leo"));
        pv.add(new Person(2, "taro"));
        String xml = BeanUtil.toXML("person", pv);
        _logger.debug(xml);

        Person[] pair1 = { new Person(1, "leo"), new Person(2, "naoko") };
        Person[] pair2 = { new Person(3, "json"), new Person(4, "xml") };

        Mate m1 = new Mate();
        m1.putPair(pair1[0], pair1[1]);
        m1.putPair(pair2[0], pair2[1]);
        String xml2 = BeanUtil.toXML("mate", m1);
        _logger.debug(xml);
        _logger.debug(xml2);

        assertTrue(true);
    }

    @Ignore
    @Test
    public void beanToXML2() throws BeanException
    {
        TrackInfo t = new TrackInfo("sample track", false);
        t.putProperty("species", "human");
        t.putProperty("revision", "hg18");

        String xml = BeanUtil.toXML("track-info", t);
        _logger.debug(xml);

        TrackInfo t2 = new TrackInfo();
        BeanUtil.populateBeanWithXML(t2, xml);
        _logger.debug(BeanUtil.toXML("track-info", t2));

        assertEquals(t.getName(), t2.getName());
        assertEquals(t.getPack(), t2.getPack());
        assertEquals(t.getProperty().get("species"), t2.getProperty().get("species"));
        assertEquals(t.getProperty().get("revision"), t2.getProperty().get("revision"));
    }

    @Test
    public void adderTest2() throws BeanException
    {
        PersonList2 pl = new PersonList2();
        pl.addPerson(new Person(1, "leo"));
        pl.addPerson(new Person(2, "yui"));

        String json = BeanUtil.toJSON(pl);

        PersonList2 pl2 = new PersonList2();
        BeanUtil.populateBean(pl2, json);
        String json2 = BeanUtil.toJSON(pl2);
        _logger.debug(json2);

        String xml = BeanUtil.toXML("personList", pl);
        _logger.debug(xml);

    }

    private boolean foundGene1 = false;
    private boolean foundGene2 = false;

    @Test
    public void streamJSONReader() throws IOException, BeanException
    {
        foundGene1 = false;
        foundGene2 = false;

        StopWatch stopWatch = new StopWatch();
        BeanUtil.loadJSON(FileResource.open(BeanUtilTest.class, "sample/genelist.json"), Gene.class,
                new BeanHandler<Gene>() {
                    public void handle(Gene gene) throws Exception
                    {
                        assertNotNull(gene);
                        if (gene.getId() == 1)
                        {
                            assertEquals("gene1", gene.getName());
                            assertEquals(100, gene.getStart());
                            assertEquals(200, gene.getEnd());
                            assertEquals("chr1", gene.getTarget());
                            assertEquals("-", gene.getStrand());
                            foundGene1 = true;
                        }
                        else if (gene.getId() == 2)
                        {
                            assertEquals("gene2", gene.getName());
                            assertEquals(300, gene.getStart());
                            assertEquals(500, gene.getEnd());
                            assertEquals("chr2", gene.getTarget());
                            assertEquals("+", gene.getStrand());
                            foundGene2 = true;
                        }
                        else
                        {
                            fail("invalid gene");
                        }

                    }
                });
        _logger.debug("loadJSON time: " + stopWatch.getElapsedTime());

        assertTrue(foundGene1);
        assertTrue(foundGene2);

    }

    @Test
    public void toJSONPerf() throws BeanException, IOException
    {

        final ArrayList<Gene> geneList = new ArrayList<Gene>();
        BeanUtil.loadJSON(FileResource.open(BeanUtilTest.class, "chr1.json"), Gene.class, new BeanHandler<Gene>() {
            public void handle(Gene gene) throws Exception
            {
                geneList.add(gene);
            }
        });

        StopWatch stopWatch = new StopWatch();
        for (Gene g : geneList)
        {
            BeanUtil.toJSON(g);
        }
        _logger.debug("toJSON time: " + stopWatch.getElapsedTime());

    }

}
