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
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.bean.TypeInformation;

/**
 * Reflection utilities
 * 
 * @author leo
 * 
 */
public class ReflectionUtil
{

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

    /**
     * Get the generic element type of the field that has a collection type. For
     * example, for a field <em>f</em> List<String>,
     * getGenericCollectionElementType(f) returns String.
     * 
     * @param field
     * @return the generic element type
     */
    public static Class< ? > getGenericCollectionElementType(Field field)
    {
        if (!TypeInformation.isCollection(field.getType()))
            throw new XerialError(XerialErrorCode.NOT_A_COLLECTION, field.getType().getName());

        Type optionFieldType = field.getGenericType();

        if (ParameterizedType.class.isInstance(optionFieldType))
        {
            ParameterizedType pt = ParameterizedType.class.cast(optionFieldType);
            Type elementType = pt.getActualTypeArguments()[0];
            if (Class.class.isInstance(elementType))
                return (Class< ? >) elementType;
            else
                return Object.class;
        }
        else
            return Object.class;
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
        if (!TypeInformation.isCollection(t))
            return; // not a collection field

        try
        {
            Object collection = getFieldValue(bean, field);
            if (collection == null)
            {
                collection = TypeInformation.createInstance(t);
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
            if (TypeInformation.isCollection(t))
            {
                Object collection = getFieldValue(bean, field);
                if (collection == null)
                {
                    collection = TypeInformation.createInstance(t);
                    ReflectionUtil.setFieldValue_internal(bean, field, collection);
                }

                // use adder
                try
                {
                    Method adder = field.getType().getMethod("add", Object.class);
                    Class< ? > elementType = getGenericCollectionElementType(field);

                    Object convertedValue = TypeConverter.convertType(elementType, value);
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
            throw new XerialException(XerialErrorCode.WRONG_DATA_TYPE, e);
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
