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
// ReflectionUtil.java
// Since: Feb 9, 2009 5:58:47 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.Pair;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.bean.TypeInfo;

/**
 * Reflection utilities
 * 
 * @author leo
 * 
 */
public class ReflectionUtil
{

    /**
     * Set the value of the bean using the given setter
     * 
     * @param bean
     * @param setter
     * @param value
     */
    public static void setValue(Object bean, Method setter, Object value)
    {
        try
        {
            try
            {
                setter.invoke(bean, value);
            }
            catch (IllegalAccessException e)
            {
                setter.setAccessible(true);
                try
                {
                    setter.invoke(bean, value);
                }
                catch (IllegalAccessException e2)
                {
                    throw new IllegalAccessError(e2.getMessage());
                }
            }
        }
        catch (InvocationTargetException e)
        {
            throw new XerialError(XerialErrorCode.WRONG_DATA_TYPE, e);
        }
    }

    /**
     * Retrieve the field value
     * 
     * @param bean
     * @param field
     * @return
     */
    public static Object getFieldValue(Object bean, Field field)
    {
        Object value = null;
        try
        {
            value = field.get(bean);
        }
        catch (IllegalAccessException e)
        {
            field.setAccessible(true);
            try
            {
                value = field.get(bean);
            }
            catch (IllegalAccessException e1)
            {
                throw new IllegalAccessError(e1.getMessage());
            }
        }
        return value;
    }

    public static Object invokeGetter(Object bean, Method getter)
    {
        try
        {
            return getter.invoke(bean);
        }
        catch (IllegalArgumentException e)
        {
            throw new XerialError(XerialErrorCode.INVALID_STATE, "not a getter (0-arg public method): " + getter);
        }
        catch (IllegalAccessException e)
        {
            throw new IllegalAccessError(e.getMessage());
        }
        catch (InvocationTargetException e)
        {
            throw new XerialError(XerialErrorCode.WRONG_DATA_TYPE, e);
        }
    }

    /**
     * Get the generic element type of the field that has a collection type. For
     * example, for a field <em>f</em>
     * 
     * <pre>
     * List&lt;String&gt;
     * </pre>
     * 
     * getGenericCollectionElementType(f) returns String.class.
     * 
     * @param field
     * @return the generic element type
     */
    public static Type getGenericCollectionElementType(Field field)
    {
        if (!TypeInfo.isCollection(field.getType()))
            throw new XerialError(XerialErrorCode.NOT_A_COLLECTION, field.getType().getName());

        Type fieldType = field.getGenericType();

        if (hasGenericTypes(fieldType))
        {
            ParameterizedType pt = ParameterizedType.class.cast(fieldType);
            return pt.getActualTypeArguments()[0];
        }
        else
            return Object.class;
    }

    public static boolean hasGenericTypes(Type t)
    {
        return ParameterizedType.class.isInstance(t);
    }

    public static Type[] getGenericParameterTypes(Type t)
    {
        if (ParameterizedType.class.isInstance(t))
        {
            ParameterizedType pt = ParameterizedType.class.cast(t);
            return pt.getActualTypeArguments();
        }
        else
            return null;
    }

    public static Class< ? > getGenericArgumentType(Method method, int argIndex)
    {
        Type[] argTypes = method.getGenericParameterTypes();
        if (argTypes.length < argIndex)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, method.toGenericString());

        if (ParameterizedType.class.isInstance(argTypes[argIndex]))
        {
            ParameterizedType pt = ParameterizedType.class.cast(argTypes[argIndex]);
            return toClassType(pt.getActualTypeArguments()[0]);
        }
        else
            return Object.class;

    }

    public static Type getGenericCollectionElementRawType(Field collectionType)
    {
        if (!TypeInfo.isCollection(collectionType.getType()))
            throw new XerialError(XerialErrorCode.NOT_A_COLLECTION, collectionType.getType().getName());

        Type optionFieldType = collectionType.getGenericType();

        if (ParameterizedType.class.isInstance(optionFieldType))
        {
            ParameterizedType pt = ParameterizedType.class.cast(optionFieldType);
            return pt.getActualTypeArguments()[0];
        }
        else
            return Object.class;

    }

    private static Class< ? > toClassType(Type genericType)
    {
        if (Class.class.isInstance(genericType))
            return (Class< ? >) genericType;
        else
            return Object.class;
    }

    public static Class< ? > getRawClass(Type type)
    {
        if (ParameterizedType.class.isInstance(type))
        {
            ParameterizedType pt = ParameterizedType.class.cast(type);
            return toClassType(pt.getRawType());
        }
        else
            return toClassType(type);
    }

    public static Pair<Type, Type> getGenericMapElementType(Field field)
    {
        if (!TypeInfo.isMap(field.getType()))
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "not a map type: " + field);

        Type fieldType = field.getGenericType();

        if (ParameterizedType.class.isInstance(fieldType))
        {
            ParameterizedType pt = ParameterizedType.class.cast(fieldType);
            Type[] keyValueType = pt.getActualTypeArguments();

            // TODO look up parent classes?
            if (keyValueType.length != 2)
                throw new XerialError(XerialErrorCode.INVALID_STATE, "not a Map<Key, Value> type: " + field);

            return new Pair<Type, Type>(keyValueType[0], keyValueType[1]);
        }

        return new Pair<Type, Type>(Object.class, Object.class);
    }

    /**
     * If the field value is null, initialize the field with a new collection
     * 
     * @param bean
     *            the target bean containing the field
     * @param field
     *            the field to initialize. This field must have a collection
     *            type
     * @throws XerialException
     *             when failed to create a new instance of the field type
     */
    public static void initializeCollectionField(Object bean, Field field) throws XerialException
    {
        Class< ? > t = field.getType();
        if (!TypeInfo.isCollection(t))
            return; // not a collection field

        try
        {
            Object collection = getFieldValue(bean, field);
            if (collection == null)
            {
                collection = TypeInfo.createInstance(t);
                ReflectionUtil.setFieldValue_internal(bean, field, collection);
            }
        }
        catch (BeanException e)
        {
            throw new XerialException(e);
        }
    }

    /**
     * Set the field value of the bean using the given value
     * 
     * @param bean
     *            the target object
     * @param field
     *            the target field
     * @param value
     *            the value to set
     * @throws XerialException
     */
    public static void setFieldValue(Object bean, Field field, Object value) throws XerialException
    {
        try
        {
            Class< ? > t = field.getType();
            if (TypeInfo.isCollection(t))
            {
                Object collection = getFieldValue(bean, field);
                if (collection == null)
                {
                    collection = TypeInfo.createInstance(t);
                    ReflectionUtil.setFieldValue_internal(bean, field, collection);
                }

                // use adder
                try
                {
                    Method adder = field.getType().getMethod("add", Object.class);
                    Type elementType = getGenericCollectionElementType(field);

                    Object convertedValue = TypeConverter.convertType(getRawClass(elementType), value);
                    adder.invoke(collection, convertedValue);
                }
                catch (SecurityException e)
                {
                    throw new XerialError(XerialErrorCode.INACCESSIBLE_METHOD, "add() of " + t.getName());
                }
                catch (NoSuchMethodException e)
                {
                    throw new XerialError(XerialErrorCode.NOT_A_COLLECTION, t.getName());
                }
                catch (IllegalAccessException e)
                {
                    throw new XerialError(XerialErrorCode.INACCESSIBLE_METHOD, "add() of " + t.getName());
                }
                catch (InvocationTargetException e)
                {
                    throw new XerialError(XerialErrorCode.INACCESSIBLE_METHOD, e);
                }
            }
            else
            {
                Object convertedValue = TypeConverter.convertType(t, value);
                setFieldValue_internal(bean, field, convertedValue);
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new XerialException(XerialErrorCode.WRONG_DATA_TYPE, e);
        }
        catch (BeanException e)
        {
            throw new XerialException(e);
        }
    }

    private static void setFieldValue_internal(Object bean, Field field, Object value)
    {
        try
        {
            field.set(bean, value);
        }
        catch (IllegalAccessException e)
        {
            field.setAccessible(true);
            try
            {
                field.set(bean, value);
            }
            catch (IllegalAccessException e1)
            {
                throw new IllegalAccessError(e1.getMessage());
            }
        }
    }

}
