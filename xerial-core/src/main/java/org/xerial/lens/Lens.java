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
// Lens.java
// Since: Feb 23, 2009 5:50:49 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Lens is an O-X mapping utility. O stands for Objects, and X for structured
 * data including XML, JSON, Silk, etc.
 * 
 * @author leo
 * 
 */
public class Lens
{

    /**
     * Translate the specified Silk file into an instance of the target object.
     * 
     * @param <Result>
     * @param silkFileResource
     *            resource path to the input Silk file
     * @param targetClass
     *            target class to which the input Silk format will be converted
     * 
     * @return translated object of the targetClass type
     */
    public static <Result> Result translateSilk(URL silkFileResource, Class<Result> targetClass)
    {

        // TODO impl
        return null;
    }

    private static void retrievesObjectAttributes(Class< ? > type)
    {
        List<Field> publicFieldList = new ArrayList<Field>();

        // look for all super classes
        for (Class< ? > eachClass = type; eachClass != null; eachClass = type.getSuperclass())
        {
            // scan fields
            for (Field eachField : eachClass.getFields())
            {
                int fieldModifier = eachField.getModifiers();
                if (Modifier.isPublic(fieldModifier) || !Modifier.isTransient(fieldModifier))
                {
                    publicFieldList.add(eachField);
                }
            }

            // scan methods
            for (Method eachMethod : eachClass.getMethods())
            {
                String methodName = eachMethod.getName();
                if (methodName.startsWith("add"))
                {
                    // adder
                }
                else if (methodName.startsWith("set"))
                {
                    // setter

                }
                else if (methodName.startsWith("get"))
                {

                }
                else if (methodName.startsWith("put"))
                {

                }
                else if (methodName.startsWith("append"))
                {
                    // appender 
                }

            }

        }

    }
}
