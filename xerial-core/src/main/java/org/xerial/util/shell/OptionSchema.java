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

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.Algorithm;
import org.xerial.util.Mapper;
import org.xerial.util.Range;
import org.xerial.util.ResourcePath;
import org.xerial.util.StringUtil;
import org.xerial.util.template.Template;

/**
 * Option Structure
 * 
 * @author leo
 * 
 */
public class OptionSchema
{
    private final ArrayList<OptionItem>   optionItemList   = new ArrayList<OptionItem>();
    private final ArrayList<ArgumentItem> argumentItemList = new ArrayList<ArgumentItem>();
    private Usage                         usage            = null;

    List<OptionItem> getOptionItemList()
    {
        return optionItemList;
    }

    List<ArgumentItem> getArgumentItemList()
    {
        return argumentItemList;
    }

    Usage getUsage()
    {
        return usage;
    }

    protected static String optionDescription(OptionItem optionItem)
    {
        StringBuilder line = new StringBuilder();
        Option opt = optionItem.getOption();
        if (optionItem.hasSymbol())
        {
            line.append(String.format("-%s", opt.symbol()));
            if (optionItem.hasLongName())
            {
                line.append(String.format(", --%s", opt.longName()));

                if (optionItem.needsArgument())
                    line.append(String.format("=%s", opt.varName()));
            }
            else
            {
                if (optionItem.needsArgument())
                    line.append(String.format(" ", opt.varName()));
            }
        }
        else if (optionItem.hasLongName())
        {
            line.append(String.format("    --%s", opt.longName()));
            if (optionItem.needsArgument())
                line.append(String.format("=%s", opt.varName()));
        }
        else
        {
            throw new XerialError(XerialErrorCode.NO_OPTION, optionItem.toString());
        }

        return line.toString();

    }

    protected static String argumentExpression(ArgumentItem argItem)
    {
        StringBuilder line = new StringBuilder();

        Argument arg = argItem.getArgumentDescriptor();
        String format;

        if (arg.required())
            format = argItem.takesMultipleArguments() ? "%s ..." : "%s";
        else
            format = argItem.takesMultipleArguments() ? "[%s ...]" : "[%s]";

        String name = arg.name();
        if (name == null || name.length() <= 0)
            name = "ARG";

        line.append(String.format(format, name));

        return line.toString();
    }

    public void printUsage(OutputStream out) throws IOException
    {
        printUsage(new OutputStreamWriter(out));
    }

    private enum TemplateVariable {
        COMMAND, ARGUMENT_LIST, DESCRIPTION, OPTION_LIST
    }

    public void printUsage(Writer out) throws IOException
    {
        Properties helpMessageTemplateValue = new Properties();

        // argument list
        Collections.sort(argumentItemList, new Comparator<ArgumentItem>() {
            public int compare(ArgumentItem o1, ArgumentItem o2)
            {
                return o1.getRange().compareTo(o2.getRange());
            }
        });

        List<String> argExpressionList = Algorithm.map(argumentItemList, new Mapper<ArgumentItem, String>() {
            public String map(ArgumentItem input)
            {
                return argumentExpression(input);
            }
        });

        // usage information
        if (usage != null)
        {
            helpMessageTemplateValue.put(TemplateVariable.COMMAND.name(), usage.command());
            if (usage.description() != null && usage.description().length() > 0)
                helpMessageTemplateValue.put(TemplateVariable.DESCRIPTION.name(), usage.description());
        }

        helpMessageTemplateValue.put(TemplateVariable.ARGUMENT_LIST.name(), StringUtil.join(argExpressionList, " "));

        // option list
        Collections.sort(optionItemList, new Comparator<OptionItem>() {
            public int compare(OptionItem o1, OptionItem o2)
            {
                Option opt1 = o1.getOption();
                Option opt2 = o2.getOption();

                // prefer options that have a short name 
                if (o1.hasSymbol())
                {
                    if (!o2.hasSymbol())
                        return -1;
                }
                else if (o2.hasSymbol())
                    return 1;

                int diff = opt1.symbol().compareTo(opt2.symbol());
                if (diff == 0)
                    return opt1.longName().compareTo(opt2.longName());
                else
                    return diff;
            }
        });

        List<String> descriptionList = Algorithm.map(optionItemList, new Mapper<OptionItem, String>() {
            public String map(OptionItem input)
            {
                return optionDescription(input);
            }
        });

        int maxDescriptionLength = 15;
        for (String each : descriptionList)
            if (each.length() > maxDescriptionLength)
                maxDescriptionLength = each.length();

        String optionHelpFormat = String.format(" %%-%ds  %%s", maxDescriptionLength);

        StringWriter optionListHelpWriter = new StringWriter();
        for (int i = 0; i < optionItemList.size(); ++i)
        {
            OptionItem optionItem = optionItemList.get(i);
            String optionHelp = descriptionList.get(i);
            String line = String.format(optionHelpFormat, optionHelp, optionItem.getOption().description());
            optionListHelpWriter.append(line);
            optionListHelpWriter.append(StringUtil.newline());
        }
        helpMessageTemplateValue.put(TemplateVariable.OPTION_LIST.name(), optionListHelpWriter.toString());

        // render help messages using template

        ResourcePath rp = usage != null ? new ResourcePath(usage.templatePath()) : new ResourcePath(
                Usage.DEFAULT_TEMPLATE);

        try
        {
            Template helpMessageTemplate = new Template(rp.openBinaryStream());
            String helpMessage = helpMessageTemplate.apply(helpMessageTemplateValue);
            out.append(helpMessage);
            out.flush();
        }
        catch (XerialException e)
        {
            throw new XerialError(e);
        }

    }

    /**
     * @param optionName
     * @return
     */
    public OptionItem getOption(String optionName)
    {
        for (OptionItem eachOption : optionItemList)
        {
            Option opt = eachOption.getOption();
            if (optionName.equals(opt.symbol()))
                return eachOption;

            String longName = opt.longName();
            if (longName != null && optionName.equals(longName))
                return eachOption;
        }

        return null;
    }

    public ArgumentItem getArgument(int argumentIndex)
    {
        for (ArgumentItem each : argumentItemList)
        {
            Argument arg = each.getArgumentDescriptor();
            if (arg.index() == argumentIndex)
                return each;
            if (arg.index() < argumentIndex && each.takesMultipleArguments())
                return each;
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
        validate(newArg);
        argumentItemList.add(newArg);
    }

    public void addArgumentItem(Field field)
    {
        ArgumentItem newArg = new ArgumentItem(field);
        validate(newArg);
        argumentItemList.add(newArg);
    }

    private void validate(ArgumentItem newArg)
    {
        Range newRange = newArg.getRange();
        for (ArgumentItem each : argumentItemList)
        {
            Range r = each.getRange();
            if (r.overlaps(newRange))
                throw new XerialError(XerialErrorCode.DUPLICATE_OPTION, String.format(
                        "argument %s and %s have an overlap", each, newArg));
        }
    }

    public static OptionSchema newOptionSchema(Class< ? > optionHolderType)
    {
        OptionSchema optionSchema = new OptionSchema();

        // traverses through super classes
        for (Class< ? > optionHolderClass = optionHolderType; optionHolderClass != null; optionHolderClass = optionHolderClass
                .getSuperclass())
        {
            // looks for bean methods annotated with Option or Argument 
            for (Method eachMethod : optionHolderClass.getDeclaredMethods())
            {
                if (eachMethod.getAnnotation(Option.class) != null)
                    optionSchema.addOptionItem(eachMethod);

                if (eachMethod.getAnnotation(Argument.class) != null)
                    optionSchema.addArgumentItem(eachMethod);
            }

            // looks for bean fields annotated with Option or Argument 
            for (Field f : optionHolderClass.getDeclaredFields())
            {
                if (f.getAnnotation(Option.class) != null)
                    optionSchema.addOptionItem(f);

                if (f.getAnnotation(Argument.class) != null)
                    optionSchema.addArgumentItem(f);
            }

            if (optionHolderClass.getAnnotation(Usage.class) != null)
            {
                optionSchema.setUsage(optionHolderClass);
            }
        }

        return optionSchema;
    }

    private void setUsage(Class< ? > optionHolderClass)
    {
        Usage newUsage = optionHolderClass.getAnnotation(Usage.class);
        if (newUsage == null)
            throw new XerialError(XerialErrorCode.NO_USAGE_ANNOTATION, optionHolderClass.toString());

        if (usage == null)
            usage = newUsage;
    }

    public static <OptionHolder> OptionSchema newOptionSchema(OptionHolder optionHolder)
    {
        return newOptionSchema(optionHolder.getClass());
    }

}
