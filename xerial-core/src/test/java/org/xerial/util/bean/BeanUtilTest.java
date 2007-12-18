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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
//import org.xerial.db.Value;
//import org.xerial.db.ValueDomain;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.util.log.LogLevel;
import org.xerial.util.log.Logger;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.XMLException;

/**
 * Sample class for BeanUtilTest
 * @author leo
 *
 */
class Person implements Comparable<Person>
{
    int id;
    String name;
    
    public Person()
    {}
    
    public Person(int id, String name)
    {
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

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}

@SuppressWarnings("serial")
class PersonTable extends TreeMap<Integer, Person>
{
	public PersonTable() 
	{ super(); }
}

@SuppressWarnings("serial")
class ComplexMap extends TreeMap<Integer, PersonTable>
{
	public ComplexMap()
	{
		super();
	}

}

class ComplexType 
{
	Map table = new ComplexMap();

	public ComplexType() {}
	
	public Map getTable() {
		return table;
	}
	public void setTable(ComplexMap table) {
		this.table = table;
	}
}


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
    	String getterName =	BeanUtil.pickPropertyName("getSomething");
    	assertEquals("something", getterName);
    	String setterName = BeanUtil.pickPropertyName("setPersonName");
    	assertEquals("personName", setterName);
    	String adderName = BeanUtil.pickPropertyName("addObject");
    	assertEquals("object", adderName);
    	
    	assertNotNull(BeanUtil.pickPropertyName("put"));
    }
    
    class Book
    {
        String title;
        String[] author;

        public Book() {}
        public Book(String title, String[] author)
        {
            this.title = title;
            this.author = author;
        }

        public String[] getAuthor()
        {
            return author;
        }
        public void setAuthor(String[] author)
        {
            this.author = author;
        }
        public String getTitle()
        {
            return title;
        }
        public void setTitle(String title)
        {
            this.title = title;
        }
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
        Class[] basicType =
        {
            int.class, double.class, float.class, boolean.class, String.class, Integer.class, Double.class, Float.class, Boolean.class   
        };
        for(Class c : basicType)
            assertTrue(TypeInformation.isBasicType(c));

        Class[] basicArrayType =
        {
            int[].class, double[].class, float[].class, boolean[].class, String[].class, Integer[].class, Double[].class, Float[].class, Boolean[].class   
        };

        for(Class c : basicArrayType)
        {
            assertTrue(TypeInformation.isBasicType(c));
        }
    }
    
    /**
     * Test method for {@link org.utgenome.util.bean.BeanUtil#toJSON(java.lang.Object)}.
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
        String str = BeanUtil.toJSON(new Book("Data on the Web", new String[] {"Abiteboul", "Buneman"}));
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
        // Since getValue() methods is private, BeanUtil.toJSON() method should not output the value 1.34 
        assert(!json.hasKey("value"));
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
        Book s1 = new Book("Data on the Web", new String[] {"Abiteboul", "Buneman"});
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
    
    class CollectionParam
    {
    	Vector<String> nameList = new Vector<String>(); 
    	ArrayList<Integer> idList = new ArrayList<Integer>();
		
    	public CollectionParam(Vector<String> nameList, ArrayList<Integer> idList) {
			this.nameList = nameList;
			this.idList = idList;
		}
    	
		public CollectionParam() {
		}

		public ArrayList<Integer> getIdList() {
			return idList;
		}
		public void setIdList(ArrayList<Integer> idList) {
			this.idList = idList;
		}
		public Vector<String> getNameList() {
			return nameList;
		}
		public void setNameList(Collection<String> nameList) {
			this.nameList.clear();
			this.nameList.addAll(nameList);
		}
    }
    
    @Test 
    public void beanWithCollectionParameters() throws BeanException 
    {
    	String[] name = {"taro", "leo"};
    	Vector<String> v = new Vector<String>();
    	for(String s : name)
    		v.add(s);
    	
    	Integer[] idList = {10, 12, 13};
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	for(int id : idList)
    		a.add(id);
    	CollectionParam c = new CollectionParam(v, a);
    	String json = BeanUtil.toJSON(c);
    	
    	CollectionParam c2 = new CollectionParam();
    	BeanUtil.populateBean(c2, json);
    	
    	assertEquals(v.size(), c2.getNameList().size());
    	for(int i=0; i<c.getNameList().size(); i++)
    		assertEquals(c.getNameList().get(i), c2.getNameList().get(i));
    	
    	assertEquals(a.size(), c2.getIdList().size());
    	for(int i=0; i<c.getIdList().size(); i++)
    		assertEquals(c.getIdList().get(i), c2.getIdList().get(i));
    		
    	
    }
    
    class Address
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
    
    class PersonList
    {
    	Vector<Person> personList = null;
    	

		public PersonList() {
		}

		public PersonList(Vector<Person> personList) {
			this.personList = personList;
		}

		public Vector<Person> getPersonList() {
			return personList;
		}
		public void setPersonList(Vector<Person> personList) {
			this.personList = personList;
		}
    }
    
    @Test
    public void beanCollection() throws BeanException
    {
    	Person[] pa = { new Person(1, "leo"), new Person(3, "taro") };
    	Vector<Person> pv = new Vector<Person>();
    	for(Person p : pa)
    		pv.add(p);
    	
    	PersonList pl = new PersonList(pv);
    	String json = BeanUtil.toJSON(pl);
    	
    	PersonList pl2 = new PersonList();
    	BeanUtil.populateBean(pl2, json);
    	
    	assertNotNull(pl2.getPersonList());
    	assertEquals(pl.getPersonList().size(), pl2.getPersonList().size());
    	for(int i=0; i<pl.getPersonList().size(); i++)
    	{
    		Person p1 = pl.getPersonList().get(i);
    		Person p2 = pl2.getPersonList().get(i);
    		assertEquals(p1, p2);
    	}
    }
    
    /*
    @Test
    public void addBean() throws InvalidJSONDataException, InvalidBeanException 
    {
    	Value[] va = {new Value("1"), new Value("2"), new Value("invalid", "-1")};
    	Vector<Value> v = new Vector<Value>();
    	for(Value value : va)
    		v.add(value);
    	ValueDomain vd = new ValueDomain(v);
    	String json = BeanUtil.toJSON(vd);
    	
    	ValueDomain vd2 = new ValueDomain();
    	BeanUtil.populateBean(vd2, json);
    	int i =0;
    	assertEquals(va.length, vd2.getValueList().size());
    	for(Object obj : vd2.getValueList())
    	{
    		Value val = (Value) obj;
    		assertEquals(va[i].getLabel(), val.getLabel());
    		assertEquals(va[i].getValue(), val.getValue());
    		i++;
    	}
    }
    */
    
    class PrimitiveAdder 
    {
    	Vector<Integer> valueList = new Vector<Integer>();
    	public PrimitiveAdder()
    	{}
    	
    	public void addValueList(Integer value)
    	{
    		valueList.add(value);
    	}
    	public Vector<Integer> getValueList() { return valueList; }
    	
    	@SuppressWarnings("unchecked")
		public void setValueList(Vector valueList)
    	{
    		// this setter must be ignored, so we set invalid values to the valueList
    		valueList.clear();
    		valueList.add(434);
    		valueList.add(4134);
    	}
    }
    
    @Test
    public void adder() throws BeanException
    {
    	int[] ans = { 1, 2, 3 };
    	PrimitiveAdder p = new PrimitiveAdder();
    	for(int v : ans)
    		p.addValueList(v);
    	
    	String json = BeanUtil.toJSON(p);
    	PrimitiveAdder p2 = new PrimitiveAdder();
    	BeanUtil.populateBean(p2, json);
    	
    	assertEquals(ans.length, p2.getValueList().size());
    	int index = 0;
    	for(int v : ans)
    	{
    		assertEquals(v, p2.getValueList().get(index++));
    	}
    	
    }
    
    class NameTable
    {
    	Map<Integer, String> nameTable = new TreeMap<Integer, String>();
    	
    	public NameTable() {}
    	public NameTable(Map<Integer, String> nameTable)
    	{
    		this.nameTable = nameTable;
    	}
    	
    	public String getNameTable(Integer key) 
    	{
    		return nameTable.get(key);
    	}

    	public void putNameTable(Integer key, String value)
    	{
    		nameTable.put(key, value);
    	}
		
    	public Map<Integer, String> getNameTable() {
			return nameTable;
		}
		public void setNameTable(Map<Integer, String> nameTable) {
			this.nameTable = nameTable;
		}
    }
    
    @Test 
    public void mapBean() throws BeanException
    {
    	String[] data = {"apple", "banana", "coconut"};
    	NameTable n1 = new NameTable();
    	for(int i=0; i<data.length; i++)
    		n1.putNameTable(i, data[i]);
    	
    	// json string should have the form: { "nameTable":[ [1, "apple"], [2, "banana"], [3, "coconut"] ] }
    	String json = BeanUtil.toJSON(n1);
    	
    	NameTable n2 = new NameTable();
    	BeanUtil.populateBean(n2, json);
    	
    	for(int i=0; i<data.length; i++)
    	{
    		assertNotNull(n2.getNameTable(i));
    		assertEquals(data[i], n2.getNameTable(i));
    	}
    }
    
    class Mate
    {
    	Map<Person, Person> pair = new TreeMap<Person, Person>();
    	public Mate() {}
		
    	public Map<Person, Person> getPair() {
			return pair;
		}
		public void setPair(Map<Person, Person> pair) {
			this.pair = pair;
		}
		
		public void putPair(Person p1, Person p2)
		{
			pair.put(p1, p2);
		}
		public Person getPair(Person p1)
		{
			return pair.get(p1);
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
    	
    	// json = { "pair":[[{"id":1, "name":"leo"}, {"id":2, "name":"naoko"}], [{"id":3, "name":"json"}, {"id":4, "name":"xml"}]]}
    	String json = BeanUtil.toJSON(m1);
    	
    	Mate m2 = new Mate();
    	BeanUtil.populateBean(m2, json);
    	assertEquals(m1.getPair(pair1[0]), m2.getPair(pair1[0]));
    	assertEquals(m1.getPair(pair2[0]), m2.getPair(pair2[0]));
    }
    
    class HogeHoge
    {
    	SortedMap<Integer, String> map = new TreeMap<Integer, String>();
    	SortedMap<Integer, SortedMap<Integer, String>> graph = new TreeMap<Integer, SortedMap<Integer, String>>();
    	
    	public HogeHoge()
    	{}

		public void setMap(SortedMap<Integer, String> map) {
			this.map = map;
		}
		
		public Map<Integer, String> getMap()
		{
			return map;
		}

		public void setMap(Map m)
		{
			this.map = (TreeMap<Integer, String>) m;
		}


		public Map getGraph() { return graph; }
		public void setGraph(SortedMap<Integer, SortedMap<Integer, String>> graph)
		{
			this.graph = graph;
		}

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
    	
    	HogeHoge h2 = new HogeHoge();
    	BeanUtil.populateBean(h2, json);
    
    	assertEquals(h.getMap(), h2.getMap());
    	assertEquals(h.getGraph().toString(), h2.getGraph().toString());
    }
    
    
    @SuppressWarnings("serial")
	class UnknownTypeMap extends TreeMap
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
	@Test
    public void unknwonTypeMap() throws BeanException
    {
    	UnknownTypeMap u1 = new UnknownTypeMap("rank");
    	u1.put("good", 50);
    	u1.put("excellent", 100);
    	
    	String json = BeanUtil.toJSON(u1);
    	
    	UnknownTypeMap u2 = new UnknownTypeMap();
    	BeanUtil.populateBean(u2,json); 
    	
    	assertEquals(u1.size(), u2.size());
    	assertEquals(u1.mapName, u2.mapName);
    	assertEquals(50, u2.get("good"));
    	assertEquals(100, u2.get("excellent"));
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
     
     
     @Ignore @Test
     public void constructorCheck() 
     {
    	 try
    	 {
    		NonConstructableClass c = new NonConstructableClass();
    		ArrayList<NonConstructableClass> a = new ArrayList<NonConstructableClass>();
    		BeanUtil.populateBean(a, "{\"-c\":[{\"name\":\"leo\"}]}");
    	 }
    	 catch(BeanException e)
    	 {
    		 return;	
    	 }
    	 fail("cannot reach here");
     }
     
     
     @Ignore @Test 
     public void constructorCheck2() 
     {
    	 try
    	 {
    		Map<Integer, NonConstructableClass> m = new TreeMap<Integer, NonConstructableClass>();
    		BeanUtil.populateBean(m, "{\"-m\":[[1, {\"name\":\"leo\"}]]}");
    	 }
    	 catch(BeanException e)
    	 {
    		 return;	
    	 }
    	 fail("cannot reach here");
     }
     
     @Ignore @Test 
     public void constructorCheck3() 
     {
    	 try
    	 {
    		Map<NonConstructableClass, String> m = new TreeMap<NonConstructableClass, String>();
    		BeanUtil.populateBean(m, "{\"-m\":[[{\"name\":\"leo\"},\"value\"]]}");
    	 }
    	 catch(BeanException e)
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
    	 
    	 assertTrue(true);
     }
     
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
     
     
     class PersonList2
     {
         ArrayList personList = new ArrayList();
         public PersonList2()
         {}
         
         public void addPerson(Person person)
         {
             personList.add(person);
         }
         
         public ArrayList getPerson()
         {
             return personList;
         }
         
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
         
         String xml = BeanUtil.toXML("personList", pl);
         
     }
     
}


@SuppressWarnings("serial")
class PersonVector extends Vector<Person>
{
	public PersonVector() {}
	
	
}


class TrackInfo 
{
	String name;
	boolean pack = true;
	HashMap property = new HashMap();
	
	public TrackInfo()
	{}

	public TrackInfo(String name, boolean pack) {
		super();
		this.name = name;
		this.pack = pack;
	}
	
	public void putProperty(String key, String value)
	{
		property.put(key, value);
	}
	public HashMap getProperty()
	{
		return property;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getPack() {
		return pack;
	}

	public void setPack(boolean pack) {
		this.pack = pack;
	}

}
