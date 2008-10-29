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
// CUIOption.java
// Since: Oct 27, 2008 4:10:08 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.cui.OptionParserException;

/**
 * OptionItem
 * 
 * @author leo
 * 
 */
public class OptionItem
{
    private final Option       optionDescriptor;
    private final OptionSetter optionSetter;

    public OptionItem(Method method)
    {
        Option option = method.getAnnotation(Option.class);
        if (option == null)
            throw new IllegalArgumentException(method + " is not an option item");

        this.optionDescriptor = option;
        this.optionSetter = new OptionSetterViaMethod(method);
    }

    public OptionItem(Field field)
    {
        Option option = field.getAnnotation(Option.class);
        if (option == null)
            throw new IllegalArgumentException(field + " is not an option item");

        this.optionDescriptor = option;
        this.optionSetter = new OptionSetterViaField(field);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof OptionItem)
        {
            OptionItem other = (OptionItem) obj;
            return optionDescriptor.equals(other.optionDescriptor);
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        return optionDescriptor.hashCode();
    }

    public boolean needsArgument()
    {
        return optionSetter.takesArgument();
    }

    public boolean hasSymbol()
    {
        return optionDescriptor.symbol() != null && optionDescriptor.symbol().length() > 0;
    }

    public boolean hasLongName()
    {
        return optionDescriptor.longName() != null && optionDescriptor.longName().length() > 0;
    }

    public Option getOption()
    {
        return optionDescriptor;
    }

    public void setOption(Object bean, String value) throws OptionParserException
    {
        Class< ? > optionType = optionSetter.getOptionDataType();
        try
        {
            Object convertedValue = TypeConverter.convertType(optionType, value);
            optionSetter.setOption(bean, convertedValue);
        }
        catch (BeanException e)
        {
            throw new OptionParserException(ShellError.WRONG_DATA_TYPE, e);
        }

    }

}
