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

import org.xerial.util.bean.TypeInformation;
import org.xerial.util.cui.OptionParserException;

/**
 * FieldSetter sets an option using a Field variable
 * 
 * @author leo
 * 
 */
public class FieldSetter implements OptionSetter
{
    private final Field field;

    public FieldSetter(Field field)
    {
        this.field = field;
    }

    public Class< ? > getOptionDataType()
    {
        field.getType();
        return null;
    }

    public void setOption(Object bean, String value) throws OptionParserException
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
        catch (IllegalArgumentException e)
        {
            throw new OptionParserException(ShellError.WRONG_DATA_TYPE, e);
        }

    }

    public boolean takesArgument()
    {
        Class< ? > type = getOptionDataType();
        return !TypeInformation.isBoolean(type);
    }
}
