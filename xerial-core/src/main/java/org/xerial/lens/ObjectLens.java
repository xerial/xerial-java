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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.util.Pair;
import org.xerial.util.bean.TypeInformation;

/**
 * Tree to Object lens
 * 
 * @author leo
 * 
 */
public class ObjectLens
{
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
    private List<ParameterSetter> setterContainer = new ArrayList<ParameterSetter>();
    private List<RelationSetter> relationSetterContainer = new ArrayList<RelationSetter>();

    public List<ParameterSetter> getSetterList()
    {
        return setterContainer;
    }

    public List<RelationSetter> getRelationSetterList()
    {
        return relationSetterContainer;
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

    public void bindParameter(Object target, String parameterName, Object value)
    {

    }

    public void bindRelation(Object target, String relationName, Object coreNode, Object attributeNode)
    {

    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", setterContainer, relationSetterContainer);
    }

    private void createBindRules(Class< ? > targetType)
    {
        // look for all super classes
        for (Class< ? > eachClass = targetType; eachClass != null; eachClass = eachClass.getSuperclass())
        {
            // scan public fields
            for (Field eachField : eachClass.getFields())
            {
                int fieldModifier = eachField.getModifiers();
                if (Modifier.isPublic(fieldModifier) || !Modifier.isTransient(fieldModifier))
                {
                    Class< ? > fieldType = eachField.getType();
                    String paramName = getCanonicalParameterName(eachField.getName());
                    SetterType setterType = SetterType.SETTER;

                    if (TypeInformation.isArray(fieldType))
                    {
                        // ignore the array field
                        continue;
                    }
                    else if (TypeInformation.isMap(fieldType))
                    {
                        setterType = SetterType.PUTTER;
                    }
                    if (TypeInformation.isCollection(fieldType))
                    {
                        setterType = SetterType.ADDER;
                    }

                    setterContainer.add(ParameterSetter.newSetter(fieldType, paramName, eachField));

                }

            }

            // scan methods
            for (Method eachMethod : eachClass.getMethods())
            {
                String methodName = eachMethod.getName();
                String paramPart = pickPropertyName(methodName);

                if (methodName.startsWith("add") || methodName.startsWith("set") || methodName.startsWith("put"))
                {
                    Class< ? >[] argTypes = eachMethod.getParameterTypes();
                    switch (argTypes.length)
                    {
                    case 1:
                    {
                        addNewSetter(setterContainer, paramPart, eachMethod);
                        break;
                    }
                    case 2:
                    {
                        // relation adder
                        Pair<String, String> relName = pickRelationName(paramPart);
                        relationSetterContainer.add(RelationSetter.newRelationSetter(relName.getFirst(), relName
                                .getSecond(), eachMethod));
                        break;
                    }
                    default:
                        continue;
                    }

                }
                else if (methodName.startsWith("append"))
                {
                    addNewSetter(setterContainer, paramPart, eachMethod);
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

    static String getCanonicalParameterName(String paramName)
    {
        paramName = paramName.replaceAll("\\s", "");
        paramName = paramName.replaceAll("-", "");
        return paramName.toLowerCase();
    }

    private enum SetterType {
        ADDER, SETTER, PUTTER, APPENDER
    };

}
