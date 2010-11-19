/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// JSONLensTest.java
// Since: 2010/11/18 15:17:05
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

import org.junit.Ignore;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONUtil;
import org.xerial.util.FileResource;
import org.xerial.util.ObjectHandler;
import org.xerial.util.ObjectHandlerBase;
import org.xerial.util.StopWatch;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.BeanUtilTest;
import org.xerial.util.bean.sample.GenePartial;
import org.xerial.util.log.Logger;

public class JSONLensTest
{

    private static Logger _logger = Logger.getLogger(JSONLensTest.class);

    public static class Gene
    {
        private int    id;
        private int    start;
        private int    end;
        private String strand;
        private String name;
        private String target;

        public Gene() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getStrand() {
            return strand;
        }

        public void setStrand(String strand) {
            this.strand = strand;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

    }

    @Test
    public void toJSONPerf() throws XerialException, IOException {

        final ArrayList<Gene> geneList = new ArrayList<Gene>();
        JSONLens.loadJSON(Gene.class, FileResource.open(JSONLensTest.class, "chr1.json"),
                new ObjectHandlerBase<Gene>() {
                    public void handle(Gene gene) throws Exception {
                        geneList.add(gene);
                    }

                    public void handleException(Exception e) {
                        _logger.error(e);
                    }

                });

        StopWatch stopWatch = new StopWatch();
        for (Gene g : geneList) {
            JSONLens.toJSON(g);
        }
        _logger.debug("toJSON time: " + stopWatch.getElapsedTime());

    }

    /**
     * Sample class for BeanUtilTest
     * 
     * @author leo
     * 
     */
    public static class Person implements Comparable<Person>
    {
        int    id;
        String name;

        public Person() {}

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Person) {
                Person other = (Person) o;
                return (id == other.id) && (name.equals(other.name));
            }
            else
                return false;
        }

        public int compareTo(Person o) {
            return (this.id - o.id);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Book
    {
        String            title;
        ArrayList<String> authorList = new ArrayList<String>();

        public Book() {}

        public Book(String title, String[] authorList) {
            this.title = title;
            for (String author : authorList)
                addAuthor(author);
        }

        public ArrayList<String> getAuthor() {
            return authorList;
        }

        public void addAuthor(String author) {
            authorList.add(author);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class PrivateGetterSetter
    {
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
    public void populate() throws JSONException, XerialException, IOException {
        Person s = new Person(10, "leo");
        Person s2 = new Person();
        JSONLens.loadJSON(s2, JSONLens.toJSON(s));
        assertEquals(s.getId(), s2.getId());
        assertEquals(s.getName(), s2.getName());
    }

    @Test
    public void populateArray() throws JSONException, XerialException, IOException {
        Book s1 = new Book("Data on the Web", new String[] { "Abiteboul", "Buneman" });
        Book s2 = new Book();
        JSONLens.loadJSON(s2, JSONLens.toJSON(s1));
        assertEquals(s1.getTitle(), s2.getTitle());
        assertEquals(s1.getAuthor(), s2.getAuthor());
    }

    @Test
    public void doNotUsePrivateSetter() throws JSONException, XerialException, IOException {
        PrivateGetterSetter p = new PrivateGetterSetter(0.0);
        JSONLens.loadJSON(p, "{\"value\" : 1.34}");
        assertEquals(0.0, p.getValue(), 0.01);
    }

    public class Address
    {
        Person person;
        String address;

        public Address() {

        }

        public Address(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

    }

    public class CollectionParam
    {
        Vector<String>     nameList = new Vector<String>();
        ArrayList<Integer> idList   = new ArrayList<Integer>();

        public CollectionParam(Vector<String> nameList, ArrayList<Integer> idList) {
            this.nameList = nameList;
            this.idList = idList;
        }

        public CollectionParam() {}

        public ArrayList<Integer> getId() {
            return idList;
        }

        public void addId(int id) {
            this.idList.add(id);
        }

        public Vector<String> getName() {
            return nameList;
        }

        public void addName(String name) {
            this.nameList.add(name);
        }
    }

    @Test
    public void beanWithCollectionParameters() throws XerialException, IOException {
        String[] name = { "taro", "leo" };
        Vector<String> v = new Vector<String>();
        for (String s : name)
            v.add(s);

        Integer[] idList = { 10, 12, 13 };
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int id : idList)
            a.add(id);
        CollectionParam c = new CollectionParam(v, a);
        String json = JSONLens.toJSON(c);

        CollectionParam c2 = new CollectionParam();
        JSONLens.loadJSON(c2, json);

        assertEquals(v.size(), c2.getName().size());
        for (int i = 0; i < c.getName().size(); i++)
            assertEquals(c.getName().get(i), c2.getName().get(i));

        assertEquals(a.size(), c2.getId().size());
        for (int i = 0; i < c.getId().size(); i++)
            assertEquals(c.getId().get(i), c2.getId().get(i));

    }

    @Test
    public void nestedBean() throws XerialException, IOException {
        Address addr = new Address(new Person(3, "leo"), "world");
        String json = JSONLens.toJSON(addr);
        Address addr2 = new Address();
        JSONLens.loadJSON(addr2, json);

        assertNotNull(addr2.getPerson());
        assertNotNull(addr2.getAddress());

        assertEquals(3, addr2.getPerson().getId());
        assertEquals("leo", addr2.getPerson().getName());
        assertEquals("world", addr2.getAddress());
    }

    public class PersonList
    {
        Vector<Person> personList = new Vector<Person>();

        public PersonList() {}

        public PersonList(Vector<Person> personList) {
            this.personList = personList;
        }

        public Vector<Person> getPerson() {
            return personList;
        }

        public void addPerson(Person person) {
            personList.add(person);
        }
    }

    @Test
    public void beanCollection() throws XerialException, IOException {
        Person[] pa = { new Person(1, "leo"), new Person(3, "taro") };
        Vector<Person> pv = new Vector<Person>();
        for (Person p : pa)
            pv.add(p);

        PersonList pl = new PersonList(pv);
        String json = JSONLens.toJSON(pl);

        PersonList pl2 = new PersonList();
        JSONLens.loadJSON(pl2, json);

        assertNotNull(pl2.getPerson());
        assertEquals(pl.getPerson().size(), pl2.getPerson().size());
        for (int i = 0; i < pl.getPerson().size(); i++) {
            Person p1 = pl.getPerson().get(i);
            Person p2 = pl2.getPerson().get(i);
            assertEquals(p1, p2);
        }
    }

    public class Sample
    {
        int    id;
        String name;

        public Sample() {}

        /**
         * @param id
         * @param name
         */
        public Sample(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "id=" + id + " name=" + name;
        }
    }

    @Test
    public void createBeanFromJSON() throws IOException, XerialException {
        Sample s = JSONLens.loadJSON(Sample.class, FileResource.open(JSONLensTest.class, "sample.json"));
        assertEquals(100, s.getId());
        assertEquals("Leo", s.getName());
    }

    public static class SampleList
    {
        private static Logger     _logger    = Logger.getLogger(SampleList.class);
        private ArrayList<Sample> sampleList = new ArrayList<Sample>();
        private String            listName;

        public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        public SampleList() {}

        public void addSample(Sample s) {
            _logger.trace("add: " + s);
            sampleList.add(s);
        }

        public ArrayList<Sample> getSampleList() {
            return sampleList;
        }

    }

    @Test
    public void createNestedBeanFromJSON() throws XerialException, IOException {
        SampleList sl = JSONLens.loadJSON(SampleList.class, FileResource.open(JSONLensTest.class, "samplelist.json"));
        assertEquals(2, sl.getSampleList().size());
        assertEquals(100, sl.getSampleList().get(0).getId());
        assertEquals(101, sl.getSampleList().get(1).getId());
        assertEquals("Leo", sl.getSampleList().get(0).getName());
        assertEquals("Yui", sl.getSampleList().get(1).getName());
        assertEquals("My Family", sl.getListName());
    }

    public static class PrimitiveAdder
    {
        Vector<Integer> valueList = new Vector<Integer>();

        public PrimitiveAdder() {}

        public void addValueList(Integer value) {
            valueList.add(value);
        }

        public Vector<Integer> getValueList() {
            return valueList;
        }

        @SuppressWarnings("unchecked")
        public void setValueList(Vector valueList) {
            // this setter must be ignored, so we set invalid values to the valueList
            valueList.clear();
            valueList.add(434);
            valueList.add(4134);
        }
    }

    @Ignore
    @Test
    public void adder() throws XerialException, IOException {
        int[] ans = { 1, 2, 3 };
        PrimitiveAdder p = new PrimitiveAdder();
        for (int v : ans)
            p.addValueList(v);

        String json = JSONLens.toJSON(p);
        PrimitiveAdder p2 = new PrimitiveAdder();
        JSONLens.loadJSON(p2, json);

        assertEquals(ans.length, p2.getValueList().size());
        int index = 0;
        for (int v : ans) {
            assertEquals(v, p2.getValueList().get(index++).intValue());
        }

    }

    public static class NameTable
    {
        Map<Integer, String> nameTable = new TreeMap<Integer, String>();

        public NameTable() {}

        public NameTable(Map<Integer, String> nameTable) {
            this.nameTable = nameTable;
        }

        public String getNameTable(Integer key) {
            return nameTable.get(key);
        }

        public void putNameTable(Integer key, String value) {
            nameTable.put(key, value);
        }

        public Map<Integer, String> getNameTable() {
            return nameTable;
        }

        public void setNameTable(Map<Integer, String> nameTable) {
            this.nameTable = nameTable;
        }
    }

    @Ignore
    @Test
    public void mapBean() throws XerialException, IOException {
        String[] data = { "apple", "banana", "coconut" };
        NameTable n1 = new NameTable();
        for (int i = 0; i < data.length; i++)
            n1.putNameTable(i, data[i]);

        // json string should have the form: { "nameTable":[ [1, "apple"], [2,
        // "banana"], [3, "coconut"] ] }
        String json = JSONLens.toJSON(n1);

        NameTable n2 = new NameTable();
        JSONLens.loadJSON(n2, json);

        for (int i = 0; i < data.length; i++) {
            assertNotNull(n2.getNameTable(i));
            assertEquals(data[i], n2.getNameTable(i));
        }
    }

    public class Mate
    {
        Map<Person, Person> pair = new TreeMap<Person, Person>();

        public Mate() {}

        public Map<Person, Person> getPair() {
            return pair;
        }

        public void setPair(Map<Person, Person> pair) {
            this.pair = pair;
        }

        public void putPair(Person p1, Person p2) {
            pair.put(p1, p2);
        }

        public Person getPair(Person p1) {
            return pair.get(p1);
        }
    }

    @Ignore
    @Test
    public void beanMap() throws XerialException, IOException {
        Person[] pair1 = { new Person(1, "leo"), new Person(2, "naoko") };
        Person[] pair2 = { new Person(3, "json"), new Person(4, "xml") };

        Mate m1 = new Mate();
        m1.putPair(pair1[0], pair1[1]);
        m1.putPair(pair2[0], pair2[1]);

        // json = { "pair":[[{"id":1, "name":"leo"}, {"id":2, "name":"naoko"}],
        // [{"id":3, "name":"json"}, {"id":4, "name":"xml"}]]}
        String json = JSONLens.toJSON(m1);

        Mate m2 = new Mate();
        JSONLens.loadJSON(m2, json);
        assertEquals(m1.getPair(pair1[0]), m2.getPair(pair1[0]));
        assertEquals(m1.getPair(pair2[0]), m2.getPair(pair2[0]));
    }

    @Test
    public void treeMapBindRule() throws XerialException {
        TreeMap t = new TreeMap<Integer, String>();
        BeanBinderSet bs = BeanUtil.getBeanOutputRule(t.getClass());
        assertTrue(bs.getBindRules().size() == 0);
    }

    public static class HogeHoge
    {
        public SortedMap<Integer, String>                     map   = new TreeMap<Integer, String>();
        public SortedMap<Integer, SortedMap<Integer, String>> graph = new TreeMap<Integer, SortedMap<Integer, String>>();

        public HogeHoge() {}

        public Map<Integer, String> getMap() {
            return map;
        }

        public void putMap(Integer key, String value) {
            map.put(key, value);
        }

        public Map getGraph() {
            return graph;
        }

        public void putGraph(Integer index, SortedMap<Integer, String> graphData) {
            graph.put(index, graphData);
        }

    }

    @Ignore
    @Test
    public void mapOfMap() throws XerialException, IOException {
        HogeHoge h = new HogeHoge();
        h.map.put(1, "hoge");
        h.map.put(10, "hoge2");
        TreeMap<Integer, String> t = new TreeMap<Integer, String>();
        t.put(4, "hoge3");
        h.graph.put(3, t);

        String json = JSONLens.toJSON(h);
        _logger.debug(json);

        HogeHoge h2 = new HogeHoge();
        JSONLens.loadJSON(h2, json);
        _logger.debug(JSONLens.toJSON(h2));

        assertEquals(h.getMap(), h2.getMap());
        assertEquals(h.getGraph().toString(), h2.getGraph().toString());
    }

    @SuppressWarnings("serial")
    public static class UnknownTypeMap extends TreeMap
    {
        String mapName;

        public UnknownTypeMap() {}

        /**
         * @param mapName
         */
        public UnknownTypeMap(String mapName) {
            this.mapName = mapName;
        }

        public String getMapName() {
            return mapName;
        }

        public void setMapName(String mapName) {
            this.mapName = mapName;
        }

    }

    @SuppressWarnings("unchecked")
    @Ignore
    @Test
    public void unknwonTypeMap() throws XerialException, IOException {
        UnknownTypeMap u1 = new UnknownTypeMap("rank");
        u1.put("good", 50);
        u1.put("excellent", 100);

        String json = JSONLens.toJSON(u1);
        _logger.debug(json);

        UnknownTypeMap u2 = new UnknownTypeMap();
        JSONLens.loadJSON(u2, json);

        assertEquals(u1.size(), u2.size());
        assertEquals(u1.getMapName(), u2.getMapName());
        assertEquals("50", u2.get("good"));
        assertEquals("100", u2.get("excellent"));
    }

    @SuppressWarnings("serial")
    public class PersonTable extends TreeMap<Integer, Person>
    {
        public PersonTable() {
            super();
        }
    }

    @SuppressWarnings("serial")
    public class ComplexMap extends TreeMap<Integer, PersonTable>
    {
        private String name = "n/a";

        public ComplexMap() {
            super();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return JSONUtil.toJSON(this);
        }

    }

    @Ignore
    @Test
    public void complexMap() throws XerialException, JSONException, IOException {
        PersonTable p = new PersonTable();
        p.put(1, new Person(100, "leo"));
        p.put(2, new Person(101, "ahsan"));
        ComplexMap m = new ComplexMap();
        m.put(1234, p);

        String json = JSONLens.toJSON(m);
        _logger.debug(json);

        ComplexMap m2 = new ComplexMap();
        JSONLens.loadJSON(m2, json);

        String json2 = JSONLens.toJSON(m2);
        _logger.debug(json2);

        assertEquals(json, json2);

        @SuppressWarnings("unused")
        JSONObject jsonObj = new JSONObject(json);

    }

    class NonConstructableClass
    {
        public NonConstructableClass() {}

        public void setName(String value) {

        }
    }

    @Ignore
    @Test
    public void constructorCheck() throws IOException {
        try {
            // NonConstructableClass c = new NonConstructableClass();
            ArrayList<NonConstructableClass> a = new ArrayList<NonConstructableClass>();
            JSONLens.loadJSON(a, "{\"-c\":[{\"name\":\"leo\"}]}");
        }
        catch (XerialException e) {
            return;
        }
        fail("cannot reach here");
    }

    @Ignore
    @Test
    public void constructorCheck2() throws IOException {
        try {
            Map<Integer, NonConstructableClass> m = new TreeMap<Integer, NonConstructableClass>();
            JSONLens.loadJSON(m, "{\"-m\":[[1, {\"name\":\"leo\"}]]}");
        }
        catch (XerialException e) {
            return;
        }
        fail("cannot reach here");
    }

    @Ignore
    @Test
    public void constructorCheck3() throws IOException {
        try {
            Map<NonConstructableClass, String> m = new TreeMap<NonConstructableClass, String>();
            JSONLens.loadJSON(m, "{\"-m\":[[{\"name\":\"leo\"},\"value\"]]}");
        }
        catch (XerialException e) {
            return;
        }
        fail("cannot reach here");
    }

    @SuppressWarnings("serial")
    public class PersonVector extends Vector<Person>
    {
        public PersonVector() {}

    }

    @Ignore
    @Test
    public void extendedCollection() throws XerialException, IOException {
        PersonVector pv = new PersonVector();
        pv.add(new Person(1, "leo"));

        // Subclass of Array cannot be JSONObject, so explicit conversion to JSONObject must be used
        String json = JSONLens.toJSON(pv);

        PersonVector pv2 = new PersonVector();
        JSONLens.loadJSON(pv2, json);

        assertEquals(1, pv2.size());
        assertEquals(pv, pv2);
    }

    public class PersonList2
    {
        ArrayList personList = new ArrayList();

        public PersonList2() {}

        public void addPerson(Person person) {
            personList.add(person);
        }

        public ArrayList getPerson() {
            return personList;
        }

    }

    @Test
    public void adderTest2() throws XerialException, IOException {
        PersonList2 pl = new PersonList2();
        pl.addPerson(new Person(1, "leo"));
        pl.addPerson(new Person(2, "yui"));

        String json = JSONLens.toJSON(pl);

        PersonList2 pl2 = new PersonList2();
        JSONLens.loadJSON(pl2, json);
        String json2 = JSONLens.toJSON(pl2);
        _logger.debug(json2);

        String j3 = JSONUtil.toJSON(pl2);
        _logger.debug(j3);

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
        String str = JSONLens.toJSON(new Book("Data on the Web", new String[] { "Abiteboul", "Buneman" }));
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
        JSONLens.loadJSON(Gene.class, FileResource.open(BeanUtilTest.class, "sample/genelist.json"),
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
        JSONLens.findFromJSON(FileResource.open(BeanUtilTest.class, "sample/genelist.json"), "gene", GenePartial.class,
                new ObjectHandler<GenePartial>() {
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

    public static class ArrayData
    {
        public List<String> list = new ArrayList<String>();
    }

    @Test
    public void toJSONTest() throws Exception {
        ArrayData d = new ArrayData();
        assertEquals("{\"list\":[]}", JSONLens.toJSON(d));
    }

    @Test
    public void mapTest() throws Exception {
        ExtMap extMap = new ExtMap();
        extMap.put(1, "hello");
        extMap.put(10, "world");
        String json = JSONLens.toJSON(extMap);
        _logger.debug(json);

        ExtMap extMap2 = JSONLens.loadJSON(ExtMap.class, new StringReader(json));
        _logger.debug(JSONLens.toJSON(extMap2));

        assertEquals(extMap, extMap2);
    }

    public static class ExtList extends ArrayList<Integer>
    {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        public String             name             = "ext-list";

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ExtList))
                return false;

            ExtList other = (ExtList) o;

            return name.equals(other.name) && super.equals(other);

        }
    }

    public static class ExtMap extends TreeMap<Integer, String>
    {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        public String             name             = "ext-map";

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ExtMap))
                return false;

            ExtMap other = (ExtMap) o;

            return name.equals(other.name) && super.equals(other);

        }
    }

    @Test
    public void arrayTest() throws Exception {
        ExtList extList = new ExtList();

        extList.add(10);
        extList.add(14);

        String json = JSONLens.toJSON(extList);
        _logger.debug(json);

        ExtList extList2 = JSONLens.loadJSON(ExtList.class, new StringReader(json));
        _logger.debug(JSONLens.toJSON(extList2));

        assertEquals(extList, extList2);

    }

}
