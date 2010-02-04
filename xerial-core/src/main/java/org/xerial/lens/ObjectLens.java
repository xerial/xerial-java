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
// ObjectLens.java
// Since: 2009/05/12 19:52:38
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.core.XerialException;
import org.xerial.json.JSONString;
import org.xerial.json.JSONWriter;
import org.xerial.lens.impl.ParameterGetter;
import org.xerial.lens.impl.ParameterSetter;
import org.xerial.lens.impl.RelationSetter;
import org.xerial.silk.SilkWriter;
import org.xerial.util.Pair;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.log.Logger;
import org.xerial.util.reflect.ReflectionUtil;

/**
 * Tree to Object lens
 * 
 * @author leo
 * 
 */
public class ObjectLens {

    private static Logger _logger = Logger.getLogger(ObjectLens.class);

    private static HashMap<Class< ? >, ObjectLens> cache = new HashMap<Class< ? >, ObjectLens>();

    /**
     * Get the lens of the target type
     * 
     * @param target
     * @return lens of the target type
     */
    public static ObjectLens getObjectLens(Class< ? > target) {
        if (cache.containsKey(target))
            return cache.get(target);
        else {
            cache.put(target, new ObjectLens(target));
            return getObjectLens(target);
        }
    }

    private final Class< ? > targetType;

    private final List<ParameterGetter> getterContainer = new ArrayList<ParameterGetter>();
    private final List<ParameterSetter> setterContainer = new ArrayList<ParameterSetter>();

    private final HashMap<String, ParameterGetter> getterIndex = new HashMap<String, ParameterGetter>();
    private final HashMap<String, ParameterSetter> setterIndex = new HashMap<String, ParameterSetter>();

    private final List<RelationSetter> relationSetterContainer = new ArrayList<RelationSetter>();
    private ParameterSetter valueSetter = null;

    private RelationSetter propertySetter = null;
    private ParameterGetter propertyGetter = null;

    public Object getParameter(Object target, String parameterName) throws XerialException {
        ParameterGetter getter = getterIndex.get(getCanonicalParameterName(parameterName));
        if (getter == null)
            return null;

        return getter.get(target);
    }

    public void setParameter(Object target, String parameterName, Object value)
            throws XerialException {

        ParameterSetter setter = setterIndex.get(getCanonicalParameterName(parameterName));
        if (setter == null)
            return;

        setter.bind(target, value);
    }

    public boolean hasPropertySetter() {
        return propertySetter != null;
    }

    RelationSetter getPropertySetter() {
        return propertySetter;
    }

    public Object getProperty(Object target, String key) throws XerialException {
        if (propertyGetter == null)
            return null;

        return propertyGetter.get(target, key);
    }

    /**
     * Invoke property setter put(key, value) of the target object
     * 
     * @param target
     * @param key
     * @param value
     * @throws XerialException
     */
    public void setProperty(Object target, Object key, Object value) throws XerialException {
        if (propertySetter == null)
            return;

        propertySetter.bind(target, key, value);
    }

    public List<ParameterSetter> getSetterList() {
        return Collections.unmodifiableList(setterContainer);
    }

    public List<RelationSetter> getRelationSetterList() {
        return Collections.unmodifiableList(relationSetterContainer);
    }

    public List<ParameterGetter> getGetterContainer() {
        return Collections.unmodifiableList(getterContainer);
    }

    public ParameterSetter getValueSetter() {
        return valueSetter;
    }

    public boolean hasAttributes() {
        return !getterContainer.isEmpty();
    }

    protected ObjectLens(Class< ? > targetType) {
        this.targetType = targetType;
        prepareBindRules(targetType);
    }

    public Class< ? > getTargetType() {
        return targetType;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", setterContainer, relationSetterContainer);
    }

    /**
     * Scans the field and getter/setter definitions in the given class, then
     * generates the mapping rules in the form of {@link ParameterSetter},
     * {@link ParameterGetter} and {@link RelationSetter}.
     * 
     * @param targetType
     */
    private void prepareBindRules(Class< ? > targetType) {
        // search for object parameters including superclass's ones 

        // scan public fields
        for (Field eachField : targetType.getFields()) {
            // ignore fields defined in the Object class
            Class< ? > parentClassOfTheField = eachField.getDeclaringClass();
            if (parentClassOfTheField == Object.class)
                continue;

            // looking for only public fields
            int fieldModifier = eachField.getModifiers();
            if (Modifier.isPublic(fieldModifier) && !Modifier.isTransient(fieldModifier)
                    && !Modifier.isStatic(fieldModifier)) {

                Class< ? > fieldType = eachField.getType();
                String paramName = getCanonicalParameterName(eachField.getName());

                if (TypeInfo.isArray(fieldType)) {
                    // ignore the array field except the byte[] type
                    Class< ? > arrayElementType = TypeInfo.getArrayElementType(fieldType);
                    if (arrayElementType != null && byte.class == arrayElementType) {
                        // byte[] getter & setter
                        getterContainer.add(ParameterGetter.newFieldGetter(eachField, paramName));
                        setterContainer.add(ParameterSetter.newSetter(fieldType, paramName,
                                eachField));
                    }
                    continue;
                }
                else if (TypeInfo.isMap(fieldType)) {
                    Pair<String, String> keyValueName = pickRelationName(eachField.getName());
                    if (keyValueName == null) {
                        // infer key, value names from the class type
                        Pair<Type, Type> mapElementType = ReflectionUtil
                                .getGenericMapElementType(eachField);

                        Class< ? > keyType = Class.class.cast(mapElementType.getFirst());
                        Class< ? > valueType = Class.class.cast(mapElementType.getSecond());

                        keyValueName = new Pair<String, String>(keyType.getSimpleName(), valueType
                                .getSimpleName());
                    }
                    else if (keyValueName.getFirst().equals("")
                            && keyValueName.getSecond().equals("")) {
                        // property (key, value) setter

                        propertySetter = RelationSetter.newMapSetter("key", "value", eachField);
                        getterContainer.add(ParameterGetter.newFieldGetter(eachField, paramName));
                        propertyGetter = ParameterGetter.newPropertyFieldGetter(eachField,
                                paramName);
                        continue;
                    }

                    relationSetterContainer.add(RelationSetter.newMapSetter(
                            keyValueName.getFirst(), keyValueName.getSecond(), eachField));
                }
                else if (TypeInfo.isCollection(fieldType)) {
                    Class< ? > elementType = ReflectionUtil.getRawClass(ReflectionUtil
                            .getGenericCollectionElementType(eachField));
                    setterContainer.add(ParameterSetter
                            .newSetter(elementType, paramName, eachField));
                    getterContainer.add(ParameterGetter.newFieldGetter(eachField, paramName));
                }
                else {
                    if (!paramName.equals("value"))
                        setterContainer.add(ParameterSetter.newSetter(fieldType, paramName,
                                eachField));
                    else
                        valueSetter = ParameterSetter.newSetter(fieldType, paramName, eachField);
                    getterContainer.add(ParameterGetter.newFieldGetter(eachField, paramName));
                }

            }

        }

        // -- scan methods
        // Parameter names used in setter/putter/adder/getter in the class definition 
        // overrides getter/setter defined for field parameters 
        for (Method eachMethod : targetType.getMethods()) {
            String methodName = eachMethod.getName();

            if (methodName.startsWith("add") || methodName.startsWith("set")) {
                Class< ? >[] argTypes = eachMethod.getParameterTypes();
                switch (argTypes.length) {
                case 1: {
                    String paramName = pickPropertyName(methodName);
                    Class< ? > parentOfTheSetter = eachMethod.getDeclaringClass();
                    if ((TypeInfo.isCollection(parentOfTheSetter) || TypeInfo
                            .isMap(parentOfTheSetter))
                            && paramName.equals("all"))
                        break;

                    if (paramName.length() <= 0 && TypeInfo.isCollection(parentOfTheSetter)) {
                        Class< ? > elementType = BeanUtil.resolveActualTypeOfCollectionElement(
                                targetType, argTypes[0]);
                        setterContainer.add(ParameterSetter.newSetter(elementType, "entry",
                                eachMethod));
                    }
                    else
                        addNewSetter(setterContainer, paramName, eachMethod);
                    break;
                }
                case 2: {
                    if (TypeInfo.isCollection(eachMethod.getDeclaringClass())) {
                        break;
                    }

                    // relation adder

                    Pair<String, String> relName = pickRelationName(pickPropertyName(methodName,
                            false));
                    if (relName == null) {
                        // infer relation node names
                        if (TypeInfo.isMap(eachMethod.getDeclaringClass())) {

                            Class< ? >[] mapElementType = BeanUtil.resolveActualTypeOfMapElement(
                                    targetType, eachMethod.getParameterTypes());

                            // map.put(Key, Value)
                            setterContainer.add(ParameterSetter.newMapEntrySetter(
                                    mapElementType[0], mapElementType[1]));

                            // (entry, key)
                            setterContainer.add(ParameterSetter.newKeySetter(mapElementType[0]));
                            // (entry, value)
                            setterContainer.add(ParameterSetter.newValueSetter(mapElementType[1]));
                            continue;
                        }
                        else {
                            relName = new Pair<String, String>(
                                    getCanonicalParameterName(argTypes[0].getSimpleName()),
                                    getCanonicalParameterName(argTypes[1].getSimpleName()));
                        }
                    }

                    relationSetterContainer.add(RelationSetter.newRelationSetter(
                            relName.getFirst(), relName.getSecond(), eachMethod));
                    break;
                }
                }

                continue;

            }
            else if (methodName.startsWith("put")) {
                Class< ? >[] argTypes = eachMethod.getParameterTypes();
                if (argTypes.length != 2)
                    continue;

                if (TypeInfo.isCollection(eachMethod.getDeclaringClass()))
                    continue;

                // relation adder
                Pair<String, String> relName = pickRelationName(pickPropertyName(methodName, false));
                if (relName == null) {
                    // infer relation node names
                    if (TypeInfo.isMap(eachMethod.getDeclaringClass())) {

                        Class< ? >[] mapElementType = BeanUtil.resolveActualTypeOfMapElement(
                                targetType, eachMethod.getParameterTypes());

                        // map.put(Key, Value)
                        setterContainer.add(ParameterSetter.newMapEntrySetter(mapElementType[0],
                                mapElementType[1]));

                        // (entry, key)
                        setterContainer.add(ParameterSetter.newKeySetter(mapElementType[0]));
                        // (entry, value)
                        setterContainer.add(ParameterSetter.newValueSetter(mapElementType[1]));
                        continue;
                    }
                    else {
                        propertySetter = RelationSetter.newRelationSetter("key", "value",
                                eachMethod);
                        continue;
                    }
                }

                relationSetterContainer.add(RelationSetter.newRelationSetter(relName.getFirst(),
                        relName.getSecond(), eachMethod));

                continue;
            }
            else if (methodName.startsWith("append")) {
                String paramName = pickPropertyName(methodName);
                addNewSetter(setterContainer, paramName, eachMethod);
                continue;
            }
            else if (methodName.startsWith("get")) {
                if (eachMethod.getParameterTypes().length == 0) {
                    // ignore getters defined in the Object.class
                    if (Object.class == eachMethod.getDeclaringClass())
                        continue;

                    String paramName = pickPropertyName(methodName);
                    getterContainer.add(ParameterGetter.newGetter(eachMethod, paramName));
                }

            }

        }

        // create indexes
        for (ParameterSetter each : setterContainer)
            setterIndex.put(each.getParameterName(), each);

        for (ParameterGetter each : getterContainer)
            getterIndex.put(each.getParamName(), each);

    }

    private static void addNewSetter(List<ParameterSetter> setterContainer, String paramPart,
            Method m) {
        Class< ? >[] argTypes = m.getParameterTypes();
        if (argTypes.length != 1)
            return;

        assert (argTypes.length == 1);

        String paramName = getCanonicalParameterName(paramPart);
        if (paramName.length() <= 0) {
            // infer parameter name from argument type
            paramName = getCanonicalParameterName(argTypes[0].getSimpleName());
        }
        setterContainer.add(ParameterSetter.newSetter(argTypes[0], paramName, m));
        return;
    }

    static private Pattern propertyNamePattern = Pattern
            .compile("^(set|get|add|put|append)((\\S)(\\S*))?");
    static private Pattern pairedNamePattern = Pattern.compile("([A-Za-z0-9]*)_([A-Za-z0-9]*)");

    static String pickPropertyName(String methodName, boolean canonicalize) {
        Matcher m = null;
        m = propertyNamePattern.matcher(methodName);
        if (!m.matches())
            return null;
        else {
            if (m.group(2) != null)
                return canonicalize ? getCanonicalParameterName(m.group(2)) : m.group(2);
            else
                return "";
        }

    }

    static String pickPropertyName(String methodName) {
        Matcher m = null;
        m = propertyNamePattern.matcher(methodName);
        if (!m.matches())
            return null;
        else {
            if (m.group(2) != null)
                return getCanonicalParameterName(m.group(2));
            else
                return "";
        }
    }

    static Pair<String, String> pickRelationName(String pairedName) {
        Matcher m = null;
        m = pairedNamePattern.matcher(pairedName);
        if (!m.matches())
            return null;
        else
            return new Pair<String, String>(getCanonicalParameterName(m.group(1)),
                    getCanonicalParameterName(m.group(2)));
    }

    static private Pattern paramNameReplacePattern = Pattern.compile("[\\s-_]");

    public static String getCanonicalParameterName(String paramName) {
        if (paramName == null)
            return paramName;

        Matcher m = paramNameReplacePattern.matcher(paramName);
        return m.replaceAll("").toLowerCase();
    }

    public static String toSilk(Object obj) {
        StringWriter buf = new StringWriter();
        SilkWriter writer = new SilkWriter(buf);
        writer.toSilk(obj);
        writer.flush();
        return buf.toString();
    }

    public static String toJSON(Object obj) {
        if (obj == null)
            return "null";

        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c)) {
            if (c == String.class)
                return JSONString.toJSONString(obj.toString());
            else
                return obj.toString();
        }

        StringWriter buf = new StringWriter();
        JSONWriter json = new JSONWriter(buf);

        toJSON(json, obj);

        json.flush();
        return buf.toString();
    }

    private static void toJSON(JSONWriter json, Object obj) {
        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c)) {
            json.addObject(obj);
            return;
        }

        ObjectLens lens = getObjectLens(obj.getClass());

        if (TypeInfo.isCollection(c)) {
            Collection< ? > collection = (Collection< ? >) obj;
            boolean hasAttributes = lens.hasAttributes();

            boolean bracketIsOpen = false;

            if (hasAttributes) {
                json.startObject();
                outputParemters(json, obj);

                if (!collection.isEmpty()) {
                    json.startArray("entry");
                    bracketIsOpen = true;
                }
            }
            else {
                json.startArray();
                bracketIsOpen = true;
            }

            for (Object elem : collection) {
                toJSON(json, elem);
            }

            if (bracketIsOpen)
                json.endArray();

            if (hasAttributes)
                json.endObject();

        }
        else if (TypeInfo.isMap(c)) {
            Map< ? , ? > map = (Map< ? , ? >) obj;
            boolean hasAttributes = lens.hasAttributes();

            if (hasAttributes) {
                json.startObject();
                outputParemters(json, obj);

                if (!map.isEmpty())
                    json.startArray("entry");
            }
            else if (!map.isEmpty())
                json.startArray();

            for (Entry< ? , ? > each : map.entrySet()) {
                json.startObject();
                json.putObject("key", each.getKey());
                json.putObject("value", each.getValue());
                json.endObject();
            }

            if (!map.isEmpty())
                json.endArray();

            if (hasAttributes)
                json.endObject();
        }
        else {
            if (!lens.getterContainer.isEmpty()) {
                json.startObject();
                outputParemters(json, obj);
                json.endObject();
            }
            else {
                // empty getter object. try toString()
                json.startString();
                json.append(obj.toString());
                json.endString();
            }
        }
    }

    private static void outputParemters(JSONWriter json, Object obj) {
        ObjectLens lens = getObjectLens(obj.getClass());
        for (ParameterGetter getter : lens.getGetterContainer()) {
            json.putObject(getter.getParamName(), getter.get(obj));
        }
    }

}
