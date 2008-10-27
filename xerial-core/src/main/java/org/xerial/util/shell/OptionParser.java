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
// OptionParser.java
// Since: Oct 27, 2008 11:11:28 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A command-line option and argument parser
 * 
 * @author leo
 * 
 */
public class OptionParser
{
    public <OptionBean> OptionBean parse(String[] args, OptionBean bean)
    {

        return null;
    }

    public static <OptionBean> OptionSchema newOptionSchema(OptionBean bean)
    {
        OptionSchema optionSchema = new OptionSchema();

        // traverses through super classes
        for (Class< ? > beanClass = bean.getClass(); beanClass != null; beanClass = beanClass.getSuperclass())
        {
            // looks for bean methods annotated with Option or Argument 
            for (Method eachMethod : beanClass.getDeclaredMethods())
            {
                Option option = eachMethod.getAnnotation(Option.class);
                if (option != null)
                    optionSchema.addOptionSetter(eachMethod);

                Argument argument = eachMethod.getAnnotation(Argument.class);
                if (argument != null)
                    optionSchema.addArgumentSetter(eachMethod);

            }

            // looks for bean fields annotated with Option or Argument 
            for (Field f : beanClass.getFields())
            {
                Option option = f.getAnnotation(Option.class);
                if (option != null)
                    optionSchema.addOptionField(f);

                Argument argument = f.getAnnotation(Argument.class);
                if (argument != null)
                    optionSchema.addArgumentField(f);
            }

        }

        return optionSchema;
    }
}
