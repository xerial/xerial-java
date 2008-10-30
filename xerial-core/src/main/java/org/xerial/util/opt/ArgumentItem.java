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
// ArgumentItem.java
// Since: 2008/10/27 23:49:28
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.xerial.util.Range;
import org.xerial.util.bean.TypeInformation;

/**
 * ArgumentItem
 * 
 * @author leo
 * 
 */
public class ArgumentItem
{
    private final Argument     argumentDescriptor;
    private final OptionSetter argumentSetter;

    public ArgumentItem(Method setter)
    {
        argumentDescriptor = setter.getAnnotation(Argument.class);
        if (argumentDescriptor == null)
            throw new IllegalArgumentException(setter + " is not for an option argument");

        argumentSetter = new OptionSetterViaMethod(setter);
    }

    public ArgumentItem(Field field)
    {
        argumentDescriptor = field.getAnnotation(Argument.class);
        if (argumentDescriptor == null)
            throw new IllegalArgumentException(field + " is not for an option argument");

        argumentSetter = new OptionSetterViaField(field);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof ArgumentItem)
        {
            ArgumentItem other = (ArgumentItem) obj;
            return argumentDescriptor.equals(other.argumentDescriptor);
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        return argumentDescriptor.hashCode();
    }

    public boolean takesMultipleArguments()
    {
        return TypeInformation.isCollection(argumentSetter.getOptionDataType());
    }

    public static Range getRangeOf(ArgumentItem arg)
    {
        int start = arg.getArgumentDescriptor().index();
        int end = arg.takesMultipleArguments() ? Integer.MAX_VALUE : start;
        return new Range(start, end);
    }

    public Range getRange()
    {
        return getRangeOf(this);
    }

    public void set(Object bean, Object value) throws OptionParserException
    {
        argumentSetter.setOption(bean, value);
    }

    public Argument getArgumentDescriptor()
    {
        return argumentDescriptor;
    }

    public void initialize(Object optionHolder) throws OptionParserException
    {
        argumentSetter.initialize(optionHolder);
    }

    @Override
    public String toString()
    {
        return String.format("name=%s, index=%s, required=%s", argumentDescriptor.name(), getRange().toString(),
                argumentDescriptor.required());
    }

    public String getArgumentName()
    {
        String name = argumentDescriptor.name();
        if (name == null || name.length() <= 0)
            name = argumentSetter.getParameterName();

        return name;
    }

}
