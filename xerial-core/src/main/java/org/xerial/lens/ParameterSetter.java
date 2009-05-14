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
// ParameterSetter.java
// Since: 2009/05/12 19:59:19
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.xerial.core.XerialException;
import org.xerial.util.reflect.ReflectionUtil;

/**
 * Object setter base class.
 * 
 * @author leo
 * 
 */
public abstract class ParameterSetter
{
    private final Class< ? > targetClass;
    private final String parameterName;

    public ParameterSetter(Class< ? > targetClass, String parameterName)
    {
        this.targetClass = targetClass;
        this.parameterName = parameterName;
    }

    public abstract void bind(Object object, Object value) throws XerialException;

    public Class< ? > getTargetClass()
    {
        return targetClass;
    }

    public String getParameterName()
    {
        return parameterName;
    }

    @Override
    public boolean equals(Object obj)
    {
        ParameterSetter other = ParameterSetter.class.cast(obj);
        if (other == null)
            return false;
        return parameterName.equals(other.parameterName);
    }

    @Override
    public int hashCode()
    {
        return parameterName.hashCode();
    }

    public static ParameterSetter newSetter(Class< ? > targetClass, String parameterName, Field targetField)
    {
        return new FieldSetter(targetClass, parameterName, targetField);
    }

    public static ParameterSetter newSetter(Class< ? > targetClass, String parameterName, Method setterMethod)
    {
        return new MethodSetter(targetClass, parameterName, setterMethod);
    }

    private static class FieldSetter extends ParameterSetter
    {
        private final Field targetField;

        public FieldSetter(Class< ? > targetClass, String parameterName, Field targetField)
        {
            super(targetClass, parameterName);
            this.targetField = targetField;

            if (!targetField.isAccessible())
                targetField.setAccessible(true);
        }

        @Override
        public void bind(Object object, Object value) throws XerialException
        {
            ReflectionUtil.setFieldValue(object, targetField, value);
        }

    }

    private static class MethodSetter extends ParameterSetter
    {
        private final Method setterMethod;

        public MethodSetter(Class< ? > targetClass, String parameterName, Method setterMethod)
        {
            super(targetClass, parameterName);
            this.setterMethod = setterMethod;
        }

        @Override
        public void bind(Object object, Object value) throws XerialException
        {
            ReflectionUtil.setValue(object, setterMethod, value);
        }

    }

}
