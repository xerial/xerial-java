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

/**
 * A command-line option and argument parser
 * 
 * @author leo
 * 
 */
public class OptionParser
{
    private boolean ignoreUnknownOption = false;

    public OptionItem findOptionItem(OptionSchema schema, String optionName) throws OptionParserException
    {
        OptionItem optionItem = schema.getOption(optionName);
        if (optionItem == null)
        {
            if (!ignoreUnknownOption)
            {
                throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR, "unknown option: "
                        + optionName);
            }
        }
        return optionItem;
    }
    
    enum ArgumentType { OPTION, ARGUMENT }  
    
    static class CommandLineToken
    {
        final ArgumentType optionOrArgument;
        final String key;
        final String value;
        
        public CommandLineToken(ArgumentType optionOrArgument, String key, String value)
        {
            this.optionOrArgument = optionOrArgument;
            this.key = key;
            this.value = value;
        }

    }
    
//    static class CommandLineScanner
//    {
//        private final String args[];
//        private final OptionSchema schema;
//        private int cursor = 0;
//        
//        public CommandLineScanner(String[] args, OptionSchema schema)
//        {
//            this.args = args;
//            this.schema = schema;
//        }
//     
//        public boolean hasNext()
//        {
//            return cursor < args.length;
//        }
//        
//        public CommandLineToken nextToken()
//        {
//            String currentArg = args[cursor];
//            if(currentArg.startsWith("--"))
//            {
//                String body = currentArg.substring(2);
//                int splitPos = currentArg.indexOf('=');
//                if (splitPos == -1)
//                {
//                    // no value is found
//                    String longOptionName = currentArg.substring(2);
//                    OptionItem optionItem = findOptionItem(schema, longOptionName); 
//                }
//                
//            }
//            
//            cursor++;
//            
//            return null;
//        }
//         
//        private OptionItem findOption(String name)
//        {
//        }
//         
//        
//        
//        
//        
//    }
    
    
    public <OptionBean> OptionBean parse(String[] args, OptionBean bean) throws OptionParserException
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
                if (splitPos == -1)
                {
                    // no value is found
                    String longOptionName = currentArg.substring(2);
                    OptionItem optionItem = findOptionItem(schema, longOptionName); 
                    if(optionItem == null)
                        continue;
                    
                    if (optionItem.needsArgument())
                        throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR,
                                "parameter value is required for --" + longOptionName);

                    optionItem.setOption(bean, "true");
                    activatedOption.add(optionItem.getOption());
                }
                else
                {
                    // option is a (key, value) pair
                    String longOptionName = currentArg.substring(2, splitPos);
                    String value = currentArg.substring(splitPos + 1);
                    OptionItem optionItem = findOptionItem(schema, longOptionName);
                    if (optionItem == null)
                        continue;

                    if(!optionItem.needsArgument())
                    {
                        throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR, "syntax error --"
                                + longOptionName);
                    }

                    optionItem.setOption(bean,args[++index]);
                    activatedOption.add(optionItem.getOption());
                }

            }
            else if (currentArg.startsWith("-"))
            {
                // option with a leading hyphen
                String shortOptionList = currentArg.substring(1);
                for(int i=0; i<shortOptionList.length(); i++)
                {
                    String shortOptionName = shortOptionList.substring(i, i+1);
                    OptionItem optionItem = findOptionItem(schema, shortOptionName);
                    if(optionItem == null)
                        continue;
                    
                    if(optionItem.needsArgument()){
                        if(shortOptionList.length() != 1)
                            throw new OptionParserException(StandardErrorCode.SYNTAX_ERROR, String.format("short name option -%s with an arguments must be isolated", shortOptionName));
                        
                        optionItem.setOption(bean,args[++index]);
                    }
                    else
                        optionItem.setOption(bean, "true");
                    
                    activatedOption.add(optionItem.getOption());
                }
            }
            else
            {
                // general argument
                
                
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
                if (eachMethod.getAnnotation(Option.class) != null)
                    optionSchema.addOptionItem(eachMethod);

                if (eachMethod.getAnnotation(Argument.class) != null)
                    optionSchema.addArgumentItem(eachMethod);
            }

            // looks for bean fields annotated with Option or Argument 
            for (Field f : beanClass.getFields())
            {
                if (f.getAnnotation(Option.class) != null)
                    optionSchema.addOptionItem(f);

                if (f.getAnnotation(Argument.class) != null)
                    optionSchema.addArgumentItem(f);
            }
        }
        
        

        return optionSchema;
    }
}
