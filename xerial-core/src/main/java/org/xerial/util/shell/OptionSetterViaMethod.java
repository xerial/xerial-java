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
// OptionSetterViaMethod.java
// Since: 2008/10/27 23:33:35
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xerial.util.bean.TypeInformation;
import org.xerial.util.cui.OptionParserException;

/**
 * Option setter using a class method.
 * @author leo
 *
 */
class OptionSetterViaMethod implements OptionSetter
{
    private Method m;

    public OptionSetterViaMethod(Method m)
    {
        this.m = m;
    }

    public void setOption(Object bean, Object value) throws OptionParserException
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

}


