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
// ParameterGetter.java
// Since: May 21, 2009 11:15:16 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.reflect.ReflectionUtil;

/**
 * For retrieving object parameter values
 * 
 * @author leo
 * 
 */
public abstract class ParameterGetter {
    private final String paramName;

    public ParameterGetter(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }

    public abstract Object get(Object obj);

    public abstract Object get(Object obj, String key);

    public static ParameterGetter newFieldGetter(Field field, String paramName) {
        return new FieldGetter(field, paramName);
    }

    public static ParameterGetter newPropertyFieldGetter(Field field, String paramName) {
        return new PropertyFieldGetter(field, paramName);
    }

    public static ParameterGetter newGetter(Method getter, String paramName) {
        return new GetterMethod(getter, paramName);
    }

    public abstract Class< ? > getReturnType();

    @Override
    public String toString() {
        return paramName;
    }

    private static class FieldGetter extends ParameterGetter {
        final Field field;

        public FieldGetter(Field field, String paramName) {
            super(paramName);
            this.field = field;
        }

        @Override
        public Object get(Object obj) {
            return ReflectionUtil.getFieldValue(obj, field);
        }

        @Override
        public Object get(Object arg0, String arg1) {
            throw new UnsupportedOperationException("get(Object, String)");
        }

        @Override
        public Class< ? > getReturnType() {
            return field.getType();
        }
    }

    private static class PropertyFieldGetter extends ParameterGetter {
        final Field field;

        public PropertyFieldGetter(Field field, String paramName) {
            super(paramName);
            this.field = field;
        }

        @Override
        public Object get(Object obj) {
            return ReflectionUtil.getFieldValue(obj, field);
        }

        @Override
        public Object get(Object obj, String key) {
            Object map = ReflectionUtil.getFieldValue(obj, field);
            if (map != null && Map.class.isAssignableFrom(map.getClass())) {
                Map< ? , ? > m = Map.class.cast(map);
                return m.get(key);
            }
            else
                throw new UnsupportedOperationException("get(Object, String)");
        }

        @Override
        public Class< ? > getReturnType() {
            return field.getType();
        }
    }

    private static class GetterMethod extends ParameterGetter {
        final Method getter;

        public GetterMethod(Method getter, String paramName) {
            super(paramName);

            this.getter = getter;

            if (getter.getParameterTypes().length != 0)
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "not a getter");

        }

        @Override
        public Object get(Object obj) {
            return ReflectionUtil.invokeGetter(obj, getter);
        }

        @Override
        public Object get(Object arg0, String arg1) {
            throw new UnsupportedOperationException("get(Object, String)");
        }

        @Override
        public Class< ? > getReturnType() {
            return getter.getReturnType();
        }
    }

}
