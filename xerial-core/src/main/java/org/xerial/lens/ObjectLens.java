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

import org.xerial.json.JSONString;
import org.xerial.json.JSONWriter;
import org.xerial.util.Pair;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.log.Logger;
import org.xerial.util.reflect.ReflectionUtil;

/**
 * Tree to Object lens
 * 
 * @author leo
 * 
 */
public class ObjectLens
{
    private static Logger _logger = Logger.getLogger(ObjectLens.class);

    private static HashMap<Class< ? >, ObjectLens> cache = new HashMap<Class< ? >, ObjectLens>();

    /**
     * Get the lens of the target type
     * 
     * @param target
     * @return lens of the target type
     */
    public static ObjectLens getObjectLens(Class< ? > target)
    {
        if (cache.containsKey(target))
            return cache.get(target);
        else
        {
            cache.put(target, new ObjectLens(target));
            return getObjectLens(target);
        }
    }

    private Class< ? > targetType;

    private List<ParameterGetter> getterContainer = new ArrayList<ParameterGetter>();
    private List<ParameterSetter> setterContainer = new ArrayList<ParameterSetter>();
    private List<RelationSetter> relationSetterContainer = new ArrayList<RelationSetter>();

    public List<ParameterSetter> getSetterList()
    {
        return Collections.unmodifiableList(setterContainer);
    }

    public List<RelationSetter> getRelationSetterList()
    {
        return Collections.unmodifiableList(relationSetterContainer);
    }

    public List<ParameterGetter> getGetterContainer()
    {
        return Collections.unmodifiableList(getterContainer);
    }

    protected ObjectLens(Class< ? > targetType)
    {
        this.targetType = targetType;
        createBindRules(targetType);
    }

    public Class< ? > getTargetType()
    {
        return targetType;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", setterContainer, relationSetterContainer);
    }

    private void createBindRules(Class< ? > targetType)
    {
        // look for all super classes
        // scan public fields
        for (Field eachField : targetType.getFields())
        {
            // ignore fields defined in the Object class
            if (eachField.getDeclaringClass() == Object.class)
                continue;

            int fieldModifier = eachField.getModifiers();
            if (Modifier.isPublic(fieldModifier) && !Modifier.isTransient(fieldModifier))
            {
                Class< ? > fieldType = eachField.getType();
                String paramName = getCanonicalParameterName(eachField.getName());

                if (TypeInfo.isArray(fieldType))
                {
                    // ignore the array field
                    continue;
                }
                else if (TypeInfo.isMap(fieldType))
                {
                    // TODO map putter
                    Pair<Type, Type> keyValueTypes = ReflectionUtil.getGenericMapElementType(eachField);
                    Pair<String, String> keyValueNames = pickRelationName(eachField.getName());
                    if (keyValueNames == null)
                    {
                        // infer key and value names from type parameters in Map<Key, Value>

                    }

                }
                else if (TypeInfo.isCollection(fieldType))
                {
                    Class< ? > elementType = ReflectionUtil.getRawClass(ReflectionUtil
                            .getGenericCollectionElementType(eachField));
                    setterContainer.add(ParameterSetter.newSetter(elementType, paramName, eachField));
                    getterContainer.add(ParameterGetter.newFieldGetter(eachField, paramName));
                }
                else
                {
                    setterContainer.add(ParameterSetter.newSetter(fieldType, paramName, eachField));
                    getterContainer.add(ParameterGetter.newFieldGetter(eachField, paramName));
                }

            }

        }

        // scan methods
        for (Method eachMethod : targetType.getMethods())
        {

            String methodName = eachMethod.getName();
            String paramName = pickPropertyName(methodName);

            if (methodName.startsWith("add") || methodName.startsWith("set") || methodName.startsWith("put"))
            {
                Class< ? >[] argTypes = eachMethod.getParameterTypes();
                switch (argTypes.length)
                {
                case 1:
                {
                    addNewSetter(setterContainer, paramName, eachMethod);
                    break;
                }
                case 2:
                {
                    // relation adder
                    Pair<String, String> relName = pickRelationName(paramName);
                    if (relName == null)
                    {
                        // infer relation node names
                        relName = new Pair<String, String>(getCanonicalParameterName(argTypes[0].getSimpleName()),
                                getCanonicalParameterName(argTypes[1].getSimpleName()));
                    }

                    relationSetterContainer.add(RelationSetter.newRelationSetter(relName.getFirst(), relName
                            .getSecond(), eachMethod));
                    break;
                }
                }

                continue;

            }
            else if (methodName.startsWith("append"))
            {
                addNewSetter(setterContainer, paramName, eachMethod);
                continue;
            }
            else if (methodName.startsWith("get"))
            {
                if (eachMethod.getParameterTypes().length == 0)
                {
                    // ignore getters defined in the Object.class
                    if (Object.class == eachMethod.getDeclaringClass())
                        continue;

                    getterContainer.add(ParameterGetter.newGetter(eachMethod, paramName));
                }

            }

        }

    }

    private static void addNewSetter(List<ParameterSetter> setterContainer, String paramPart, Method m)
    {
        Class< ? >[] argTypes = m.getParameterTypes();
        if (argTypes.length != 1)
            return;

        assert (argTypes.length == 1);

        String paramName = getCanonicalParameterName(paramPart);
        if (paramName.length() <= 0)
        {
            // infer parameter name from argument type
            paramName = getCanonicalParameterName(argTypes[0].getSimpleName());
        }
        setterContainer.add(ParameterSetter.newSetter(argTypes[0], paramName, m));
        return;
    }

    static private Pattern propertyNamePattern = Pattern.compile("^(set|get|add|put|append)((\\S)(\\S*))?");
    static private Pattern pairedNamePattern = Pattern.compile("([A-Za-z0-9]*)_([A-Za-z0-9]*)");

    static String pickPropertyName(String methodName)
    {
        Matcher m = null;
        m = propertyNamePattern.matcher(methodName);
        if (!m.matches())
            return null;
        else
        {
            if (m.group(2) != null)
                return getCanonicalParameterName(m.group(2));
            else
                return "";
        }
    }

    static Pair<String, String> pickRelationName(String pairedName)
    {
        Matcher m = null;
        m = pairedNamePattern.matcher(pairedName);
        if (!m.matches())
            return null;
        else
            return new Pair<String, String>(getCanonicalParameterName(m.group(1)),
                    getCanonicalParameterName(m.group(2)));
    }

    static private Pattern paramNameReplacePattern = Pattern.compile("[\\s-_]");

    public static String getCanonicalParameterName(String paramName)
    {
        Matcher m = paramNameReplacePattern.matcher(paramName);
        return m.replaceAll("").toLowerCase();
    }

    public static String toJSON(Object obj)
    {
        if (obj == null)
            return "null";

        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c))
        {
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

    private static void toJSON(JSONWriter json, Object obj)
    {
        Class< ? > c = obj.getClass();

        if (TypeInfo.isCollection(c))
        {
            json.startArray();
            Collection< ? > collection = (Collection< ? >) obj;
            for (Object elem : collection)
            {
                toJSON(json, elem);
            }
            json.endArray();
        }
        else if (TypeInfo.isMap(c))
        {
            json.startArray();
            Map< ? , ? > map = (Map< ? , ? >) obj;

            json.startArray();
            for (Entry< ? , ? > each : map.entrySet())
            {
                json.startObject();
                json.putObject("key", each.getKey());
                json.putObject("value", each.getValue());
                json.endObject();
            }
            json.endArray();

            json.endArray();
        }
        else
        {
            ObjectLens lens = getObjectLens(obj.getClass());
            json.startObject();
            for (ParameterGetter getter : lens.getGetterContainer())
            {
                json.putObject(getter.getParamName(), getter.get(obj));
            }
            json.endObject();
        }
    }

}
