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
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 
 * 
 * @author leo
 * 
 */
public class OptionSchema
{
    private final HashMap<String, OptionSetter> optionIndex = new HashMap<String, OptionSetter>();
    private final HashMap<Integer, OptionSetter> argumentIndex = new HashMap<Integer, OptionSetter>();

    public OptionSetter getOption(String optionName)
    {
        return optionIndex.get(optionName);
    }

    public void addOptionSetter(Option option, Method setter)
    {
        optionIndex.put(option.name(), new SetterMethod(setter));
    }

    public void addOptionField(Option option, Field field)
    {
        optionIndex.put(option.name(), new FieldSetter(field));
    }

    public void addArgumentSetter(Argument argument, Method setter)
    {
        argument.index()
    }

    public void addArgumentField(Argument argument, Field field)
    {

    }

}
