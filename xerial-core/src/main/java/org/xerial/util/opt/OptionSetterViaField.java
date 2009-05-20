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
package org.xerial.util.opt;

import java.lang.reflect.Field;

import org.xerial.core.XerialException;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.reflect.ReflectionUtil;

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

    public void setOption(Object bean, Object value) throws OptionParserException
    {
        try
        {
            ReflectionUtil.setFieldValue(bean, field, value);
        }
        catch (XerialException e)
        {
            throw new OptionParserException(e.getErrorCode(), e.getMessage());
        }

    }

    public boolean takesArgument()
    {
        Class< ? > type = getOptionDataType();
        return !TypeInfo.isBoolean(type);
    }

    public void initialize(Object bean) throws OptionParserException
    {
        try
        {
            ReflectionUtil.initializeCollectionField(bean, field);
        }
        catch (XerialException e)
        {
            throw new OptionParserException(e.getErrorCode(), e.getMessage());
        }
    }

    public String getParameterName()
    {
        return field.getName();
    }

}
