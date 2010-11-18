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
// BeanUtil.java
// Since: 2007/03/29
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Element;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.Pair;
import org.xerial.util.bean.impl.Appender;
import org.xerial.util.bean.impl.ArraySetter;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.bean.impl.CollectionAdder;
import org.xerial.util.bean.impl.CollectionSetter;
import org.xerial.util.bean.impl.Getter;
import org.xerial.util.bean.impl.MapPutter;
import org.xerial.util.bean.impl.MapSetter;
import org.xerial.util.bean.impl.Setter;
import org.xerial.util.xml.XMLGenerator;

/**
 * BeanUtil class supports data binding between JSON data and a bean class.
 * 
 * A bean class must have the followings: - A public default (no argument)
 * constructor - To bind data object to a class, there must be public
 * getter/seter methods in the target class, prefixd with get/set. -- Allowable
 * data classes are: ---- primitive types: int/Integer, double/Double,
 * float/Float, boolean/Boolean, String ---- bean classes ---- Collection of
 * allowable data classes. e.g. List<String>, Set<Integer>, etc. ---- Map with
 * key and value classes. key and value also must be allowable classes. ------
 * to bind JSON data to map object, putSomething() method is requried. See the
 * following description.
 * 
 * For example, a Person class with integer id and string name values must have
 * <code>public int getId()</code> and <code>public String getName()</code>, and
 * <code>public void setId(int id)</code> and
 * <code>public void setName(String name)</code> methods.
 * 
 * Usage Example. <code>
 * class Person {
 *   int id;
 *   String name;
 *   public Person();
 *   public Person(int id, String name)
 *   { this.id = id; this.name = name; } 
 *   
 *   public int getId() { return id; }
 *   public String getName() { return name; }
 *   public void setId(int id) { this.id = id; }
 *   public void setName(String name) { this.name = name; }
 * }
 * 
 * Person p1 = new Person(1, "leo");
 * String json = BeanUtil.toJSON(p1); // it will give a json string { "id" : 1, "name" : "leo"}
 * 
 * Person p2 = new Person() // empty data
 * BeanUtil.populate(p2, json);	// fill p2 with a give json data
 * // p2.id = 1, p2.name = "leo"
 * 
 * </code>
 * 
 * 
 * 
 * In the GWT (Google Web Toolkit) of the current version (1.3.3, Mar 2007), the
 * generics feature of Jave (since JDK1.5) cannot be used within the client Java
 * codes. This is a problematic since GWT cannot compile the following method:
 * <code>
 * void setPersonList(List<Person> personList) { this.personList = personList; }
 * </code> So you have to change the argument of the avobe method as: <code>
 * void setPersonList(List personList) { ... }
 * </code> But, with this setter method, we have no information about the
 * element type contained in the List class. So given a JSON data, e.g.,{
 * "personList" : [ {"id":1, "name":"leo"}, {"id":2, "name":"taro"}] }, BeanUtil
 * class cannot instantiate any Person classes.
 * 
 * To resolve this problem, BeanUtil supports data binding via adder methods.
 * For example, instead of using setters, by using the follwing adder, you can
 * load several Person class data as a collection:
 * <code>void addPersonList(Person person) { personList.add(person); }</code>
 * 
 * Note that, in order to use adders correctly, the target of an adder, that is,
 * a collection class, must be initialized before the invocation of the adder.
 * For example, <code> 
 * public PersonList {
 *   Vector<Person> personList = new Vector<Person>();	// it must be initialized. 
 *   public PersonList() {}
 *   void addPersonList(Person p) { personList.add(p); }
 *   public getPersonList() { return personList; } 
 * }
 * </code>
 * 
 * Otherwise, BeanUtil.populate method cuases NullPointerException or some other
 * undisired effects.
 * 
 * In BeanUtil, a setter method, whose argument has no generic type parameter,
 * e.g., <code>public void setList(List l)</code> never be used to bind JSON
 * data to a class instance.
 * 
 * 
 * In order to use a Bean class with Map<K, V> objects, you must define
 * <code>public Map getSomething()</code> and
 * <code>public void putSomething(KeyType key, ValueType value)</code> methods,
 * since BeanUtil learns class types K, V from the putSomething(K key, V value)
 * methods. If a method <code>public void setSomething(Map map)</code> exists,
 * BeanUtil simply ignores it.
 * 
 * 
 * The following is an example of a bean class with Map object. <code>
 * public MapBean
 * {
 *   Map entry = new TreeMap();
 *   
 *   public MapBean(){}
 *   
 *   public void putEntry(Key key, Value v)
 *   {
 *      entry.put(key, value);
 *   }
 *   
 *   public Map getEntry()
 *   {
 *      return entry;
 *   }
 * }
 * </code>
 * 
 * @author leo
 * 
 */
public class BeanUtil {

    private static HashMap<Class< ? >, BinderSet> _beanOutputRuleRegistry = new HashMap<Class< ? >, BinderSet>();

    private static HashMap<Class< ? >, BinderSet> _beanLoadRuleRegistry = new HashMap<Class< ? >, BinderSet>();

    public static BeanBinderSet getBeanOutputRule(Class< ? > c) throws XerialException {
        if (_beanOutputRuleRegistry.containsKey(c))
            return _beanOutputRuleRegistry.get(c);
        else {
            BinderSet beanOutputRule = inspectGetters(c);
            _beanOutputRuleRegistry.put(c, beanOutputRule);
            return beanOutputRule;
        }
    }

    public static BeanBinderSet getBeanLoadRule(Class< ? > c) throws XerialException {
        if (_beanLoadRuleRegistry.containsKey(c))
            return _beanLoadRuleRegistry.get(c);
        else {
            BinderSet beanLoadRule = inspectSetter(c);
            _beanLoadRuleRegistry.put(c, beanLoadRule);
            return beanLoadRule;
        }
    }

    /**
     * retrieve getter methods fo the form: getSomething(), then define how to
     * use these methods according to the return type of the getter.
     * 
     * If the return type is: - primitiveType type: crate a rule that simply
     * invokes getSomething() method, and recieves a value. - collection iterate
     * for each element in the collection
     * 
     * @param bean
     * @throws UTGBException
     */
    private static BinderSet inspectGetters(Class< ? > beanClass) throws XerialException {
        BinderSet outputRuleSet = new BinderSet(beanClass);

        Method[] method = beanClass.getMethods();
        for (Method m : method) {
            if (!Modifier.isPublic(m.getModifiers())) // is public?
                continue;
            String methodName = m.getName();
            String parameterName = BeanUtil.pickPropertyName(methodName);
            if (parameterName == null || parameterName.length() == 0)
                continue;

            if (!methodName.startsWith("get") || methodName.equals("getClass"))
                continue; // Object

            Class< ? >[] parameterType = m.getParameterTypes();
            if (parameterType.length != 0) // we cannot use the getter unless
                // it requires no argument.
                continue;
            outputRuleSet.addRule(new Getter(m, parameterName));
        }

        return outputRuleSet;
    }

    public static BinderSet inspectSetter(Class< ? > beanClass) throws XerialException {
        BinderSet inputRuleSet = new BinderSet(beanClass);

        // create a rule set of binding rules from setters of the bean class
        for (Method method : beanClass.getMethods()) {
            String methodName = method.getName();

            String parameterName = BeanUtil.pickPropertyName(methodName); // retrieve
            // setter,
            // getter,
            // adder,
            // putter
            // parameter
            // name
            if (parameterName == null)
                continue;

            if (!Modifier.isPublic(method.getModifiers())) // is public
                // setter/adder/putter?
                continue;

            Class< ? >[] parameterType = method.getParameterTypes();
            if (methodName.startsWith("put")) {
                if (parameterType.length != 2)
                    continue;

                Class< ? >[] mapElementType = resolveActualTypeOfMapElement(beanClass,
                        parameterType);

                if (parameterName.length() == 0 && TypeInfo.isMap(beanClass)) {
                    // bean.put(Key k, Value v)
                    inputRuleSet.addRule(new MapPutter(method, "elem", mapElementType[0],
                            mapElementType[1]));
                }
                else {
                    // putSomething(Key k, Value v)
                    inputRuleSet.addRule(new MapPutter(method, parameterName, mapElementType[0],
                            mapElementType[1]));
                }
                continue;
            }

            if (methodName.startsWith("add")) {
                if (parameterType.length != 1)
                    continue;

                Class< ? > addType = resolveActualTypeOfCollectionElement(beanClass,
                        parameterType[0]);

                if (parameterName.length() == 0 && TypeInfo.isCollection(beanClass)) {
                    // bean.add(E element)
                    inputRuleSet.addRule(new CollectionAdder(method, "elem", addType));
                }
                else {
                    // bean.addSomething(E element)
                    inputRuleSet.addRule(new CollectionAdder(method, parameterName, addType));
                }
                continue;
            }

            if (methodName.startsWith("append")) {
                if (parameterType.length != 1)
                    continue;

                Class< ? > addType = resolveActualTypeOfCollectionElement(beanClass,
                        parameterType[0]);
                inputRuleSet.addRule(new Appender(addType, method, parameterName));
                continue;
            }

            if (methodName.startsWith("set")) {
                if (parameterType.length != 1 || parameterName.length() == 0)
                    continue;

                Class< ? > inputTypeOfTheSetter = parameterType[0];

                if (inputTypeOfTheSetter.isArray()) {
                    // setSomething(int[] array) etc
                    Class< ? > componentType = inputTypeOfTheSetter.getComponentType();
                    inputRuleSet.addRule(new ArraySetter(method, parameterName, componentType));
                }
                else if (TypeInfo.isCollection(inputTypeOfTheSetter)) {
                    if (method.getGenericParameterTypes()[0] instanceof ParameterizedType) {
                        ParameterizedType genericSetterArgumentType = (ParameterizedType) method
                                .getGenericParameterTypes()[0];
                        Type[] actualTypeList = genericSetterArgumentType.getActualTypeArguments();
                        if (actualTypeList.length > 0) {
                            Class< ? > elementType = resolveRawType(actualTypeList[0]);
                            inputRuleSet.addRule(new CollectionSetter(method, parameterName,
                                    inputTypeOfTheSetter, elementType));
                        }
                    }
                    // setSomething(Collection) method wihtout any type
                    // parameter cannot be used to bind JSON data, thus skip
                }
                else if (TypeInfo.isMap(inputTypeOfTheSetter)) {
                    // setSomething(Map<K, V> map) method
                    Pair<Class< ? >, Class< ? >> keyValueTypePair = getGenericMapTypesOfMethodArgument(
                            method, 0);
                    if (keyValueTypePair != null) {
                        inputRuleSet.addRule(new MapSetter(method, parameterName,
                                inputTypeOfTheSetter, keyValueTypePair.getFirst(), keyValueTypePair
                                        .getSecond()));
                        continue;
                    }
                    // setMap(Map map) without any type parameter cannot be used
                }
                else {
                    inputRuleSet.addRule(new Setter(method, parameterName, inputTypeOfTheSetter));
                }
            }
        }

        return inputRuleSet;
    }

    public static Pair<Class< ? >, Class< ? >> getGenericMapTypesOfMethodArgument(Method method,
            int argIndex) {

        ParameterizedType genericSetterArgumentType = getParentParameterizedType(
                method.getGenericParameterTypes()[argIndex], Map.class);

        if (genericSetterArgumentType != null) {
            Type[] actualTypeList = genericSetterArgumentType.getActualTypeArguments();
            if (actualTypeList.length >= 2) {
                Class< ? > keyType = resolveRawType(actualTypeList[0]);
                Class< ? > valueType = resolveRawType(actualTypeList[1]);
                return new Pair<Class< ? >, Class< ? >>(keyType, valueType);
            }
        }

        return null;

    }

    public static ParameterizedType getParameterizedType(Type t) {
        if (t == null)
            return null;

        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            return pt;
        }
        if (t instanceof Class)
            return getParameterizedType(((Class< ? >) t).getGenericSuperclass());
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    public static ParameterizedType getParentParameterizedType(Type t, Class target) {
        if (t == null)
            return null;

        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            if (target.isAssignableFrom((Class) pt.getRawType())) {
                return pt;
            }
        }

        if (t instanceof Class) {
            Class c = (Class) t;
            return getParentParameterizedType(c.getGenericSuperclass(), target);
        }
        else
            return null;
    }

    public static Class< ? > resolveActualTypeOfCollectionElement(Type type, Class< ? > orig) {
        ParameterizedType pt = getParentParameterizedType(type, Collection.class);
        if (pt != null) {
            Type[] actualType = pt.getActualTypeArguments();
            if (actualType.length > 0)
                return resolveRawType(actualType[0], orig);
        }
        return orig;
    }

    public static Class< ? >[] resolveActualTypeOfMapElement(Type type, Class< ? >[] orig) {
        ParameterizedType pt = getParentParameterizedType(type, Map.class);
        if (pt != null) {
            Type[] actualType = pt.getActualTypeArguments();
            if (actualType.length > 0)
                return new Class[] { resolveRawType(actualType[0], orig[0]),
                        resolveRawType(actualType[1], orig[1]) };
        }
        return orig;
    }

    private static Class< ? > resolveRawType(Type type, Class< ? > orig) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return resolveRawType(pt.getRawType(), orig);
        }
        else if (type instanceof Class)
            return (Class< ? >) type;
        else
            return orig;
    }

    private static Class< ? > resolveRawType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return resolveRawType(pt.getRawType());
        }
        else if (type instanceof Class)
            return (Class< ? >) type;
        else
            return Object.class;
    }

    // non constructable
    private BeanUtil() {}

    /**
     * @param methodName
     *            method name of getter or setters. e.g. setSomething,
     *            getSomething
     * @param patternType
     *            set(ter) or get(ter)
     * @return property name of the method name
     * 
     * 
     * 
     */
    public static String pickPropertyName(String methodName) {
        Matcher m = null;
        m = _setGetAddMethodPattern.matcher(methodName);
        if (!m.matches())
            return null;
        else {
            if (m.group(2) != null)
                return m.group(3).toLowerCase() + m.group(4);
            else
                return "";
        }
    }

    static private Pattern _setGetAddMethodPattern = Pattern
            .compile("^(set|get|add|put|append)((\\S)(\\S*))?");

    private static class BeanToXMLProcess {
        private ByteArrayOutputStream _buffer = new ByteArrayOutputStream();

        private XMLGenerator _out = new XMLGenerator(_buffer);

        public BeanToXMLProcess() {

        }

        public String generateXML(String tagName, Object bean) throws XerialException {
            try {
                toXML(tagName, bean);
                _out.endDocument();
                _out.flush();
                return _buffer.toString();
            }
            catch (IllegalArgumentException e) {
                throw new XerialException(XerialErrorCode.IllegalArgument, e);
            }
        }

        private void toXML(String tagName, Object bean) throws XerialException {
            if (bean == null)
                return;

            Class< ? > beanClass = bean.getClass();

            if (beanClass.isArray()) {
                Object[] array = (Object[]) bean;
                int i = 0;
                for (; i < array.length - 1; i++) {
                    toXML(tagName, array[i]);
                    _out.text(",");
                }
                toXML(tagName, array[i]);
            }
            else if (TypeInfo.isBasicType(beanClass)) {
                _out.element(tagName, bean.toString());
            }
            else {
                if (TypeInfo.isCollection(beanClass)) {
                    Collection< ? > collection = (Collection< ? >) bean;
                    for (Object elem : collection) {
                        toXML(tagName, elem);
                    }
                }
                else if (TypeInfo.isMap(beanClass)) {
                    Map< ? , ? > map = (Map< ? , ? >) bean;

                    for (Object key : map.keySet()) {
                        _out.startTag(tagName);
                        _out.element("key", key.toString());
                        _out.element("value", map.get(key).toString());
                        _out.endTag();
                    }
                }
                else {
                    // return an XML elemenet
                    _out.startTag(tagName);
                    BeanBinderSet outputRuleSet = BeanUtil.getBeanOutputRule(beanClass);
                    for (BeanBinder rule : outputRuleSet.getBindRules()) {
                        Method getter = rule.getMethod();
                        String parameterName = rule.getParameterName();

                        Object parameterValue = invokeGetterMethod(getter, bean);
                        toXML(parameterName, parameterValue);
                    }
                    _out.endTag();
                }
            }

        }
    }

    public static String toXML(String tagName, Object bean) throws XerialException {
        BeanToXMLProcess bp = new BeanToXMLProcess();
        return bp.generateXML(tagName, bean);
    }

    public static String toJSONFromResultSet(ResultSet resultSet) throws SQLException {
        StringBuilder builder = new StringBuilder();
        ResultSetMetaData metadata = resultSet.getMetaData();
        int colCount = metadata.getColumnCount();
        builder.append("{");
        for (int i = 1; i <= colCount; i++) {
            if (i >= 2)
                builder.append(",");
            Object value = resultSet.getObject(i);
            builder.append("\"");
            builder.append(metadata.getColumnName(i));
            builder.append("\":");
            if (value != null) {
                builder.append("\"");
                builder.append(value.toString());
                builder.append("\"");
            }
            else
                builder.append("null");
        }
        builder.append("}");
        return builder.toString();
    }

    private static boolean hasGetter(Class< ? > beanClass) throws XerialException {
        BeanBinderSet outputRuleSet = BeanUtil.getBeanOutputRule(beanClass);
        return outputRuleSet.getBindRules().size() > 0;
    }

    private static Object invokeGetterMethod(Method getter, Object bean) throws XerialException {
        try {
            return getter.invoke(bean);
        }
        catch (IllegalArgumentException e) {
            throw new XerialException(XerialErrorCode.IllegalArgument, e);
        }
        catch (IllegalAccessException e) {
            throw new XerialException(XerialErrorCode.IllegalAccess, e);
        }
        catch (InvocationTargetException e) {
            throw new XerialException(XerialErrorCode.InvocationTargetException, e);
        }
    }

    public static void populateBeanWithMap(Object bean, Map< ? , ? > map) throws XerialException {
        BeanUtilImpl.populateBeanWithMap(bean, map);
    }

    public static void populateBeanWithXML(Object bean, Reader xmlReader) throws XerialException {
        if (bean == null)
            throw new XerialException(XerialErrorCode.BeanObjectIsNull);

        BeanUtilImpl.populateBeanWithXML(bean, xmlReader);

    }

    public static void populateBeanWithXML(Object bean, String xmlData) throws XerialException {
        populateBeanWithXML(bean, new StringReader(xmlData));
    }

    public static void populateBeanWithXML(Object bean, Element xmlElement) throws XerialException {
        if (xmlElement == null)
            return; // there is nothing to bind

        BeanUtilImpl.populateBeanWithXML(bean, xmlElement);
    }

    public static Object createInstance(Class< ? > c) throws XerialException {
        return TypeInfo.createInstance(c);
    }

    public static <E> E createXMLBean(Class<E> valueType, Reader xmlReader) throws XerialException,
            IOException, XerialException {

        return BeanUtilImpl.createBeanFromXML(valueType, xmlReader);
    }

    public static Object createXMLBean(Class< ? > valueType, String xmlData) throws XerialException {
        Object bean;
        bean = createInstance(valueType);
        populateBeanWithXML(bean, xmlData);
        return bean;
    }

}

enum BeanParameterType {
    primitiveType, primitiveTypeCollection, primitiveTypeArray, nestedBean, beanArray,
    beanCollection, unknownTypeCollection, primitiveTypeAdder, beanAdder, primitiveTypeArrayAdder,
    beanArrayAdder, map
}

/**
 * TODO A hash structure may have better performance, especially for findRule()
 * method.
 * 
 * @author leo
 * 
 */
class BinderSet implements BeanBinderSet {
    Class< ? > beanClass;

    Vector<BeanBinder> _bindRule = new Vector<BeanBinder>();

    public BinderSet(Class< ? > beanClass) {
        this.beanClass = beanClass;
    }

    // @see org.utgenome.util.BeanBinderSet#addRule(org.utgenome.util.Binder)
    public void addRule(BeanBinder binder) {
        _bindRule.add(binder);
    }

    // @see org.utgenome.util.BeanBinderSet#getBindRules()
    public Vector<BeanBinder> getBindRules() {
        return _bindRule;
    }

    // @see org.utgenome.util.BeanBinderSet#findRule(java.lang.String)
    public BeanBinder findRule(String name) {
        for (BeanBinder rule : _bindRule) {
            if (rule.getParameterName().equalsIgnoreCase(name))
                return rule;
        }
        return null;
    }

    public MapPutter getStandardMapPutter() {
        for (BeanBinder rule : _bindRule) {
            if (rule.getMethod().getName().equals("put"))
                return MapPutter.class.cast(rule);
        }
        return null;
    }
}
