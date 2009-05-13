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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.util.bean.TypeInformation;
import org.xerial.util.bean.impl.Setter;

public class ObjectLens
{
    public ObjectLens(Class< ? > targetType)
    {
        createBindRules(targetType);
    }

    private static void createBindRules(Class< ? > targetType)
    {
        List<Setter> setterContainer = new ArrayList<Setter>();

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

                    setterContainer.add(new Setter(eachClass, paramName, eachField, setterType));

                }

            }

            // scan methods
            for (Method eachMethod : eachClass.getMethods())
            {
                String methodName = eachMethod.getName();
                String parametrName = pickPropertyName(methodName);
                if (methodName.startsWith("add"))
                {
                    // adder
                    String paramName = getCanonicalParameterName(methodName.substring(3));
                    setterContainer.add(ParameterSetter.newSetter(paramName, eachMethod, SetterType.ADDER));

                }
                else if (methodName.startsWith("set"))
                {
                    // setter
                    String paramName = getCanonicalParameterName(methodName.substring(3));

                }
                else if (methodName.startsWith("get"))
                {
                    // we cannot use any getter that requires some arguments
                    Class< ? >[] parameterType = eachMethod.getParameterTypes();
                    if (parameterType.length != 0)
                        continue;

                }
                else if (methodName.startsWith("put"))
                {

                }
                else if (methodName.startsWith("append"))
                {
                    // appender for a large text value split into chunks

                }

            }

        }

    }

    static private Pattern propertyNamePattern = Pattern.compile("^(set|get|add|put|append)((\\S)(\\S*))?");

    public static String pickPropertyName(String methodName)
    {
        Matcher m = null;
        m = propertyNamePattern.matcher(methodName);
        if (!m.matches())
            return null;
        else
        {
            if (m.group(2) != null)
                return m.group(3).toLowerCase() + m.group(4);
            else
                return "";
        }
    }

    public static String getCanonicalParameterName(String paramName)
    {
        paramName = paramName.replaceAll("\\s", "_");
        paramName = paramName.replaceAll("-", "_");
        return paramName.toLowerCase();
    }

    private enum SetterType {
        ADDER, SETTER, PUTTER, APPENDER
    };

    private static class Getter
    {
        Field target;
        Method setter;
        String paremterName;

    }

}
