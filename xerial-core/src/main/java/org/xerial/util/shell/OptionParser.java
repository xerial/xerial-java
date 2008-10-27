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
import java.util.HashSet;

import org.xerial.core.StandardErrorCode;
import org.xerial.util.cui.OptionParserException;
import org.xerial.util.cui.OptionWithNoArgument;

/**
 * A command-line option and argument parser
 * 
 * @author leo
 * 
 */
public class OptionParser
{
    private boolean ignoreUnknownOption = false;

    public <OptionBean> OptionBean parse(String[] args, OptionBean bean)
    {
        OptionSchema schema = newOptionSchema(bean);

        HashSet<Option> activatedOption = new HashSet<Option>();

        int index = 0; // index in the args array
        int argIndex = 0; // argument index
        for (; index < args.length; index++)
        {
            String currentArg = args[index];
            if (currentArg.startsWith("--"))
            {
                // long name option
                int splitPos = currentArg.indexOf('=');
                String longOptionName;
                String value;
                if (splitPos == -1)
                {
                    // no value is found
                    longOptionName = currentArg.substring(2);

                    OptionSetter setter = schema.getOptionSetter(longOptionName);
                    if (setter == null)
                    {
                        if (ignoreUnknownOption)
                        {
                            index++;
                            continue;
                        }
                        else
                        {
                            throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR, "unknown option --"
                                    + longOptionName);
                        }
                    }

                    if (setter.takesArgument())
                        throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR,
                                "parameter value is required for --" + longOptionName);

                    setter.setOption(bean, args[++index]);
                    activatedOptionSet.add(opt.getOptionID());
                }
                else
                {
                    // a matching argument value is found
                    longOptionName = arg.substring(2, splitPos);
                    value = arg.substring(splitPos + 1);
                    OptionWithNoArgument<OptionID> opt = _rootOptionGroup.findByLongOptionName(longOptionName);
                    if (opt == null)
                        if (ignoreUnknownOption)
                        {
                            index++;
                            continue;
                        }
                        else
                            throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR, "unknown option --"
                                    + longOptionName);
                    if (opt instanceof OptionWithArgument)
                    {
                        OptionWithArgument<OptionID> optWithArg = (OptionWithArgument<OptionID>) opt;
                        optWithArg.setArgumentValue(value);
                        optWithArg.set(args, index);
                        activatedOptionSet.add(optWithArg.getOptionID());
                    }
                    else
                        throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR, "syntax error --"
                                + longOptionName);
                }

            }
            else if (currentArg.startsWith("-"))
            {

            }

        }

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
                    optionSchema.addOptionSetter(option, eachMethod);

                Argument argument = eachMethod.getAnnotation(Argument.class);
                if (argument != null)
                    optionSchema.addArgumentSetter(argument, eachMethod);

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
