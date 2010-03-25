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
package org.xerial.lens.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.ObjectLens;
import org.xerial.util.log.Logger;
import org.xerial.util.reflect.ReflectionUtil;

/**
 * Object setter base class.
 * 
 * @author leo
 * 
 */
public abstract class ParameterSetter {
    private static Logger _logger = Logger.getLogger(ParameterSetter.class);

    private final Class< ? > parameterType;
    private final String cParamName;

    public ParameterSetter(Class< ? > parameterType, String parameterName) {
        this.parameterType = parameterType;
        this.cParamName = ObjectLens.getCanonicalParameterName(parameterName);
    }

    public abstract void bind(Object object, Object value) throws XerialException;

    public Class< ? > getParameterType() {
        return parameterType;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", cParamName, parameterType.getSimpleName());
    }

    public String getCanonicalParameterName() {
        return cParamName;
    }

    @Override
    public boolean equals(Object obj) {
        ParameterSetter other = ParameterSetter.class.cast(obj);
        if (other == null)
            return false;
        return cParamName.equals(other.cParamName);
    }

    @Override
    public int hashCode() {
        return cParamName.hashCode();
    }

    public static ParameterSetter newSetter(Class< ? > parameterType, String parameterName,
            Field targetField) {
        return new FieldSetter(parameterType, parameterName, targetField);
    }

    public static ParameterSetter newSetter(Class< ? > parameterType, String parameterName,
            Method setterMethod) {
        return new MethodSetter(parameterType, parameterName, setterMethod);
    }

    public static ParameterSetter newKeySetter(Class< ? > keyType) {
        return new MapEntryBinder(keyType, "key");
    }

    public static ParameterSetter newValueSetter(Class< ? > valueType) {
        return new MapEntryBinder(valueType, "value");
    }

    public static ParameterSetter newMapEntrySetter(Class< ? > keyType, Class< ? > valueType) {
        return new MapEntrySetter(keyType, valueType);
    }

    private static class FieldSetter extends ParameterSetter {
        private final Field targetField;

        public FieldSetter(Class< ? > parameterType, String parameterName, Field targetField) {
            super(parameterType, parameterName);
            this.targetField = targetField;

            // make the final fields accessible
            if (!targetField.isAccessible())
                targetField.setAccessible(true);

        }

        @Override
        public void bind(Object object, Object value) throws XerialException {
            ReflectionUtil.setFieldValue(object, targetField, value);
        }

        public Object get(Object object) throws XerialException {
            return ReflectionUtil.getFieldValue(object, targetField);
        }

    }

    private static class MethodSetter extends ParameterSetter {
        private final Method setterMethod;

        public MethodSetter(Class< ? > parameterType, String parameterName, Method setterMethod) {
            super(parameterType, parameterName);
            this.setterMethod = setterMethod;
        }

        @Override
        public void bind(Object object, Object value) throws XerialException {
            ReflectionUtil.setValue(object, setterMethod, value);
        }

    }

    public static class MapEntryBinder extends ParameterSetter {
        private final Field targetField;

        public MapEntryBinder(Class< ? > parameterType, String parameterName) {
            super(parameterType, parameterName);

            try {
                targetField = MapEntry.class.getField(parameterName);
            }
            catch (Exception e) {
                throw new XerialError(XerialErrorCode.INVALID_STATE, e);
            }

        }

        @Override
        public void bind(Object entry, Object key) throws XerialException {
            ReflectionUtil.setFieldValue(entry, targetField, key);
        }

    }

    private static class MapEntrySetter extends ParameterSetter {
        final Class< ? > keyType;
        final Class< ? > valueType;

        public MapEntrySetter(Class< ? > keyType, Class< ? > valueType) {
            super(MapEntry.class, "entry");

            this.keyType = keyType;
            this.valueType = valueType;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void bind(Object mapObject, Object entryObject) throws XerialException {
            Map map = Map.class.cast(mapObject);
            if (map == null) {
                _logger.warn("not a map type: " + mapObject);
                return;
            }

            MapEntry entry = MapEntry.class.cast(entryObject);
            if (entry == null) {
                _logger.warn("not a map entry type: " + entryObject);
                return;
            }

            try {
                if (entry.key != null)
                    map.put(keyType.cast(entry.key), valueType.cast(entry.value));
            }
            catch (ClassCastException e) {
                _logger.warn("cannot convert type: " + e);
                return;
            }
        }

    }

}
