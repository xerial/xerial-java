/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// FieldSetter.java
// Since: Oct 27, 2008 3:28:03 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.cui.OptionParserException;

/**
 * Option setter that bind arguments directory to a field variable
 * 
 * @author leo
 * 
 */
public class OptionSetterViaField implements OptionSetter
{
    private final Field field;

    public OptionSetterViaField(Field field)
    {
        this.field = field;
    }

    public Class< ? > getOptionDataType()
    {
        return field.getType();
    }

    private Class< ? > getCollectionElementType()
    {
        if (!TypeInformation.isCollection(getOptionDataType()))
            throw new XerialError(XerialErrorCode.NOT_A_COLLECTION, field.toString());

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

    protected Object getValue(Object bean)
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

    protected void setValue(Object bean, Object value)
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

    public void setOption(Object bean, Object value) throws OptionParserException
    {
        try
        {
            if (setterTakesMultipleArguments())
            {
                Object collection = getValue(bean);
                if (collection == null)
                {
                    throw new XerialError(XerialErrorCode.NOT_INITIALIZED);
                }

                // use adder
                try
                {
                    Method adder = getOptionDataType().getMethod("add", Object.class);
                    Class< ? > elementType = getCollectionElementType();

                    Object convertedValue = TypeConverter.convertType(elementType, value);
                    adder.invoke(collection, convertedValue);
                }
                catch (SecurityException e)
                {
                    throw new XerialError(XerialErrorCode.INACCESSIBLE_METHOD, "add of "
                            + getOptionDataType().toString());
                }
                catch (NoSuchMethodException e)
                {
                    throw new XerialError(XerialErrorCode.NOT_A_COLLECTION, getOptionDataType().toString());
                }
                catch (IllegalAccessException e)
                {
                    throw new XerialError(XerialErrorCode.INACCESSIBLE_METHOD, "add of "
                            + getOptionDataType().toString());
                }
                catch (InvocationTargetException e)
                {
                    throw new XerialError(XerialErrorCode.INACCESSIBLE_METHOD, e);
                }
            }
            else
            {
                Class< ? > optionType = getOptionDataType();
                Object convertedValue = TypeConverter.convertType(optionType, value);
                setValue(bean, convertedValue);
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new OptionParserException(ShellError.WRONG_DATA_TYPE, e);
        }
        catch (BeanException e)
        {
            throw new OptionParserException(ShellError.WRONG_DATA_TYPE, e);
        }

    }

    boolean setterTakesMultipleArguments()
    {
        return TypeInformation.isCollection(getOptionDataType());
    }

    public boolean takesArgument()
    {
        Class< ? > type = getOptionDataType();
        return !TypeInformation.isBoolean(type);
    }

    public void initialize(Object bean) throws OptionParserException
    {
        try
        {
            if (setterTakesMultipleArguments())
            {
                Object collection = getValue(bean);

                // initialize the array
                if (collection == null)
                {
                    collection = TypeInformation.createInstance(getOptionDataType());
                    setValue(bean, collection);
                }
            }
        }
        catch (BeanException e)
        {
            throw new OptionParserException(e.getErrorCode());
        }
    }

}
