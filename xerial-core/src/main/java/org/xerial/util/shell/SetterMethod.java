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
// SetterMethod.java
// Since: Oct 27, 2008 3:48:55 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xerial.core.XerialError;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.cui.OptionParserException;

public class SetterMethod implements OptionSetter
{
    private Method m;

    public SetterMethod(Method m)
    {
        this.m = m;
        //if(m.getParameterTypes().length != 1)
        //throw new 

    }

    public void setOption(Object bean, String value) throws OptionParserException
    {
        try
        {
            try
            {
                m.invoke(bean, value);
            }
            catch (IllegalAccessException e)
            {
                m.setAccessible(true);
                try
                {
                    m.invoke(bean, value);
                }
                catch (IllegalAccessException e2)
                {
                    throw new IllegalAccessError(e2.getMessage());
                }
            }
        }
        catch (InvocationTargetException e)
        {
            throw new OptionParserException(ShellError.WRONG_DATA_TYPE, e);
        }

    }

    public Class< ? > getOptionDataType()
    {
        return m.getParameterTypes()[0];
    }

    public boolean takesArgument()
    {
        return !TypeInformation.isBoolean(getOptionDataType());
    }

    public Option getOption()
    {
        Option option = m.getAnnotation(Option.class);
        if (option == null)
            throw new XerialError(ShellError.NO_OPTION_ANNOTATION_IS_FOUND);
        return option;
    }

}
