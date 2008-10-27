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
// OptionSchema.java
// Since: Oct 27, 2008 11:48:24 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * 
 * @author leo
 * 
 */
public class OptionSchema
{

    public void addOptionSetter(Method setter)
    {

    }

    public void addOptionField(Field field)
    {

    }

    public void addArgumentSetter(Method setter)
    {

    }

    public void addArgumentField(Field field)
    {

    }

}

interface OptionSetter
{
    void setOption(Object bean, String value);

    Class< ? > getType();
}

final class OptionSetterMethod implements OptionSetter
{
    private Method m;

    public OptionSetterMethod(Method m)
    {
        this.m = m;
        //if(m.getParameterTypes().length != 1)
        //throw new 

    }

    public void setOption(Object bean, String value)
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
            throw new IllegalStateException(e);
        }

    }

    public Class< ? > getType()
    {
        return m.getParameterTypes()[0];
    }

}
