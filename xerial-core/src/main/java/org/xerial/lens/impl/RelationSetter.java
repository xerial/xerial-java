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
// RelationSetter.java
// Since: 2009/05/12 20:14:43
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.Pair;
import org.xerial.util.ReflectionUtil;
import org.xerial.util.bean.TypeInfo;

/**
 * RelationSetter is for setting a node tuple to an object
 * 
 * @author leo
 * 
 */
public abstract class RelationSetter {
    private final Class< ? > coreNodeType;
    private final Class< ? > attributeNodeType;

    private final String coreNodeName;
    private final String attributeNodeName;

    protected RelationSetter(Class< ? > coreNodeType, String coreNodeName,
            Class< ? > attributeNodeType, String attributeNodeName) {
        this.coreNodeType = coreNodeType;
        this.attributeNodeType = attributeNodeType;
        this.coreNodeName = coreNodeName;
        this.attributeNodeName = attributeNodeName;
    }

    public Class< ? > getCoreNodeType() {
        return coreNodeType;
    }

    public Class< ? > getAttributeNodeType() {
        return attributeNodeType;
    }

    public String getCoreNodeName() {
        return coreNodeName;
    }

    public String getAttributeNodeName() {
        return attributeNodeName;
    }

    @Override
    public String toString() {
        return String.format("(%s[%s], %s[%s])", coreNodeName, coreNodeType.getSimpleName(),
                attributeNodeName, attributeNodeType.getSimpleName());
    }

    @Override
    public boolean equals(Object obj) {
        RelationSetter other = RelationSetter.class.cast(obj);
        if (other == null)
            return false;
        boolean eq = this.coreNodeName.equals(other.coreNodeName);
        return eq ? this.attributeNodeName.equals(other.attributeNodeName) : false;
    }

    @Override
    public int hashCode() {
        return coreNodeName.hashCode() + attributeNodeName.hashCode();
    }

    public abstract void bind(Object object, Object coreValue, Object attributeValue)
            throws XerialException;

    public static RelationSetter newRelationSetter(String coreNodeName, String attributeNodeName,
            Method setterMethod) {
        Class< ? >[] argType = setterMethod.getParameterTypes();
        if (argType.length != 2)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, setterMethod.toString());
        return new MethodRelationSetter(argType[0], coreNodeName, argType[1], attributeNodeName,
                setterMethod);
    }

    private static class MethodRelationSetter extends RelationSetter {
        private final Method setter;

        public MethodRelationSetter(Class< ? > coreNodeType, String coreNodeName,
                Class< ? > attributeNodeType, String attributeNodeName, Method setter) {
            super(coreNodeType, coreNodeName, attributeNodeType, attributeNodeName);
            this.setter = setter;
        }

        @Override
        public void bind(Object object, Object coreValue, Object attributeValue)
                throws XerialException {
            try {
                setter.invoke(object, coreValue, attributeValue);
            }
            catch (IllegalArgumentException e) {
                throw new XerialException(XerialErrorCode.WRONG_DATA_TYPE, e);
            }
            catch (IllegalAccessException e) {
                throw new XerialException(XerialErrorCode.INVALID_INPUT, e);
            }
            catch (InvocationTargetException e) {
                throw new XerialError(XerialErrorCode.WRONG_DATA_TYPE, e);
            }

        }
    }

    public static RelationSetter newMapSetter(String keyNodeName, String valueNodeName,
            Field mapField) {
        Pair<Class< ? >, Class< ? >> mapElementType = ReflectionUtil
                .getGenericMapElementClasses(mapField);

        return new MapFieldSetter(mapElementType.getFirst(), keyNodeName, mapElementType
                .getSecond(), valueNodeName, mapField);
    }

    private static class MapFieldSetter extends RelationSetter {
        private final Field mapField;
        private final ParameterGetter mapTypeGetter;
        private final Method putter;

        public MapFieldSetter(Class< ? > coreNodeType, String coreNodeName,
                Class< ? > attributeNodeType, String attributeNodeName, Field mapField) {
            super(coreNodeType, coreNodeName, attributeNodeType, attributeNodeName);
            this.mapField = mapField;
            this.mapTypeGetter = ParameterGetter.newFieldGetter(this.mapField, null);

            Class< ? > mapType = this.mapField.getType();
            if (!TypeInfo.isMap(mapType))
                throw new XerialError(XerialErrorCode.InvalidType, String.format(
                        "field: %s is not a Map type", mapField));

            try {
                this.putter = mapType.getMethod("put", Object.class, Object.class);
            }
            catch (Exception e) {
                throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                        "putter method is not found in %s", mapType));
            }

        }

        @Override
        public void bind(Object object, Object coreValue, Object attributeValue)
                throws XerialException {
            try {
                Object map = Map.class.cast(mapTypeGetter.get(object));
                if (map == null) {
                    map = TypeInfo.createInstance(mapField.getType());
                    ReflectionUtil.setFieldValue(object, mapField, map);
                }

                putter.invoke(map, coreValue, attributeValue);
            }
            catch (IllegalArgumentException e) {
                throw new XerialException(XerialErrorCode.WRONG_DATA_TYPE, e);
            }
            catch (IllegalAccessException e) {
                throw new XerialException(XerialErrorCode.INVALID_INPUT, e);
            }
            catch (InvocationTargetException e) {
                throw new XerialError(XerialErrorCode.WRONG_DATA_TYPE, e);
            }

        }

    }

}
