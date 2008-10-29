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

import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.Algorithm;
import org.xerial.util.Mapper;
import org.xerial.util.Range;
import org.xerial.util.Reducer;

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

    public void printUsage(OutputStream out)
    {
        PrintWriter writer = new PrintWriter(out);
        
        int longestLongOptionNameSize = 
            Algorithm.mapReduce(optionItemList, 
                    new Mapper<OptionItem, Integer>(){
                public Integer map(OptionItem input)
                {
                    Option opt = input.getOption();
                    if(opt.longName() != null)
                        return opt.longName().length();
                    else
                        return 0;
                }},
                new Reducer<Integer, Integer>() {
                    public Integer reduce(Iterable<Integer> input)
                    {
                        int sum = 0;
                        for(int each : input)
                            sum += each;
                        return sum;
                    }
                }
            );
        
        
        //String optionHelpFormat = String.format(" %%%ds %%%ds %%s", longestLongOptionNameSize + "s %s";
        
        for(OptionItem each : optionItemList)
        {
            Option eachOpt = each.getOption(); 
            String shortOptionName = eachOpt.name().length() > 0 ? "-" + eachOpt.name() : "";
            String longOptionName = eachOpt.longName().length() > 0 ? "--" + eachOpt.longName() : "";
            String description = eachOpt.description();
            
            writer.println(String.format(" %s %s %s", shortOptionName, longOptionName, description));
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
            if (optionName.equals(opt.name()))
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
            if (arg.index() > argumentIndex && each.takesMultipleArguments())
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
        Range newRange = getRangeOf(newArg);
        for (ArgumentItem each : argumentItemList)
        {
            Range r = getRangeOf(each);
            if (r.overlaps(newRange))
                throw new XerialError(XerialErrorCode.DUPLICATE_OPTION, String.format(
                        "argument %s and %s have an overlap", each, newArg));
        }
    }

    static Range getRangeOf(ArgumentItem arg)
    {
        int start = arg.getArgumentDescriptor().index();
        int end = arg.takesMultipleArguments() ? Integer.MAX_VALUE : start;
        return new Range(start, end);
    }

}
