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
import java.util.ArrayList;

/**
 * 
 * 
 * @author leo
 * 
 */
public class OptionSchema
{
    private final ArrayList<OptionItem> optionItemList = new ArrayList<OptionItem>();
    private final ArrayList<ArgumentItem> argumentItemList = new ArrayList<ArgumentItem>();

    /**
     * @param optionName
     * @return 
     */
    public OptionItem getOption(String optionName)
    {
        for(OptionItem eachOption : optionItemList)
        {
            Option opt = eachOption.getOption();
            if(optionName.equals(opt.name()))
                return eachOption;
            
            String longName = opt.longName();
            if(longName != null && optionName.equals(longName))
                return eachOption;
        }
        
        return null;
    }

    public void addOptionItem(Method setter)
    {
        OptionItem newOption = new OptionItem(setter);
        optionItemList.add(newOption);
    }

    public void addOptionItem(Field field)
    {
        OptionItem newOption = new OptionItem(field);
        optionItemList.add(newOption);
    }

    public void addArgumentItem(Method setter)
    {
        ArgumentItem newArg = new ArgumentItem(setter);
        argumentItemList.add(newArg);
    }

    public void addArgumentItem(Field field)
    {
        ArgumentItem newArg = new ArgumentItem(field);
        argumentItemList.add(newArg);
    }

}
