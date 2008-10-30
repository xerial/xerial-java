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
package org.xerial.util.opt;

import java.io.OutputStream;
import java.util.HashSet;

import org.xerial.core.XerialErrorCode;

/**
 * A command-line option and argument parser
 * 
 * @author leo
 * 
 */
public class OptionParser
{
    private boolean            ignoreUnknownOption = false;
    private final OptionSchema schema;
    private final Object       optionHolder;

    public <T> OptionParser(T optionHolder)
    {
        this.optionHolder = optionHolder;
        schema = OptionSchema.newOptionSchema(optionHolder);
    }

    OptionItem findOptionItem(OptionSchema schema, String optionName) throws OptionParserException
    {
        OptionItem optionItem = schema.getOption(optionName);
        if (optionItem == null)
        {
            if (!ignoreUnknownOption)
            {
                throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option: " + optionName);
            }
        }
        return optionItem;
    }

    public void printUsage()
    {
        printUsage(System.out);
    }

    public void printUsage(OutputStream out)
    {
        assert schema != null;

    }

    public void parse(String[] args) throws OptionParserException
    {
        // initialize collections in the OptionHolder
        for (OptionItem each : schema.getOptionItemList())
        {
            each.initialize(optionHolder);
        }
        for (ArgumentItem each : schema.getArgumentItemList())
        {
            each.initialize(optionHolder);
        }

        HashSet<Option> activatedOption = new HashSet<Option>();
        HashSet<Argument> activatedArgument = new HashSet<Argument>();

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
                    if (optionItem == null)
                        continue;

                    if (optionItem.needsArgument())
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                "parameter value is required for --" + longOptionName);

                    optionItem.setOption(optionHolder, "true");

                    if (!optionItem.takesMultipleArguments() && activatedOption.contains(optionItem.getOption()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION, optionItem.getOption()
                                .toString());

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

                    if (!optionItem.needsArgument())
                    {
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "syntax error --"
                                + longOptionName);
                    }

                    optionItem.setOption(optionHolder, value);
                    if (!optionItem.takesMultipleArguments() && activatedOption.contains(optionItem.getOption()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION, optionItem.getOption()
                                .toString());

                    activatedOption.add(optionItem.getOption());
                }

            }
            else if (currentArg.startsWith("-"))
            {
                // option with a leading hyphen (e.g. "-txvf" is equivalent to "-t", "-x", "-v" and "-f")
                String shortOptionList = currentArg.substring(1);
                for (int i = 0; i < shortOptionList.length(); i++)
                {
                    String shortOptionName = shortOptionList.substring(i, i + 1);
                    OptionItem optionItem = findOptionItem(schema, shortOptionName);
                    if (optionItem == null)
                        continue;

                    if (optionItem.needsArgument())
                    {
                        if (shortOptionList.length() != 1)
                            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, String.format(
                                    "short name option -%s with an arguments must be a single notation",
                                    shortOptionName));

                        optionItem.setOption(optionHolder, args[++index]);
                    }
                    else
                        optionItem.setOption(optionHolder, "true");

                    if (!optionItem.takesMultipleArguments() && activatedOption.contains(optionItem.getOption()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION, optionItem.getOption()
                                .toString());

                    activatedOption.add(optionItem.getOption());
                }
            }
            else
            {
                // general argument
                ArgumentItem argItem = schema.getArgument(argIndex);
                if (argItem == null)
                    throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unused argument: " + currentArg);

                argItem.set(optionHolder, currentArg);
                if (!argItem.takesMultipleArguments() && activatedArgument.contains(argItem.getArgumentDescriptor()))
                    throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION, argItem.getArgumentDescriptor()
                            .toString());

                activatedArgument.add(argItem.getArgumentDescriptor());
                argIndex++;
            }

        }

        // verify missing options & arguments
        for (ArgumentItem argItem : schema.getArgumentItemList())
        {
            if (argItem.getArgumentDescriptor().required()
                    && !activatedArgument.contains(argItem.getArgumentDescriptor()))
                throw new OptionParserException(XerialErrorCode.MISSING_ARGUMENT, argItem.toString());
        }
    }

    public void setIgnoreUnknownOption(boolean ignore)
    {
        ignoreUnknownOption = ignore;
    }

}
