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
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.TypeInfo;

/**
 * A command-line option and argument parser
 * 
 * @author leo
 * 
 */
public class OptionParser {
    private final OptionSchema schema;
    private final Object optionHolder;

    private boolean ignoreUnknownOption = false;
    private HashSet<Option> activatedOption = new HashSet<Option>();
    private HashSet<Argument> activatedArgument = new HashSet<Argument>();
    private List<String> unusedArgument = new ArrayList<String>();

    private boolean ignoreAfterTheFirstArgument = false;

    public <T> OptionParser(T optionHolder) {
        this.optionHolder = optionHolder;
        schema = OptionSchema.newOptionSchema(optionHolder);
    }

    public <T> OptionParser(Class<T> optionHolderType) {
        try {
            this.optionHolder = TypeInfo.createInstance(optionHolderType);
        }
        catch (XerialException e) {
            throw new XerialError(XerialErrorCode.INVALID_ARGUMENT, e);
        }

        schema = OptionSchema.newOptionSchema(optionHolder);
    }

    @SuppressWarnings("unchecked")
    public <T> T getOptionHolder() {
        return (T) optionHolder;
    }

    OptionItem findOptionItem(OptionSchema schema, String optionName) throws OptionParserException {
        OptionItem optionItem = schema.getOption(optionName);
        if (optionItem == null) {
            if (!ignoreUnknownOption) {
                throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option: "
                        + optionName);
            }
        }
        return optionItem;
    }

    public void printUsage() {
        printUsage(System.out);
    }

    public void printUsage(Writer out) {
        assert schema != null;
        schema.printUsage(out);
    }

    public void printUsage(OutputStream out) {
        assert schema != null;
        schema.printUsage(out);
    }

    public String getUsage() {
        StringWriter buf = new StringWriter();
        printUsage(buf);
        return buf.toString();
    }

    /**
     * Return the unused option arguments after the invocation of the
     * {@link #parse(String[])} method
     * 
     * @return
     */
    public String[] getUnusedArguments() {
        String[] result = new String[unusedArgument.size()];
        for (int i = 0; i < unusedArgument.size(); ++i)
            result[i] = unusedArgument.get(i);
        return result;
    }

    /**
     * Parse the command-line arguments and bind them to the field value of the
     * optionHolder
     * 
     * @param args
     * @param ignoreUnknownOption
     *            when true, the option parser ignore unknown commands. When
     *            false, OptionParserException will be thrown when unknown
     *            options are found.
     * @throws OptionParserException
     */
    public void parse(String[] args, boolean ignoreUnknownOption) throws OptionParserException {
        setIgnoreUnknownOption(ignoreUnknownOption);
        parse(args);
    }

    /**
     * Parse until the first argument is found. This method is useful to
     * implement sub commands, e.g.,;
     * 
     * <pre>
     * &gt; [global option] (sub command name) [sub command option]
     * </pre>
     * 
     * @param <OptionHolder>
     * @param args
     * @return
     * @throws OptionParserException
     */
    public void parseUntilTheFirstArgument(String[] args) throws OptionParserException {
        ignoreAfterTheFirstArgument = true;
        try {
            parse(args);
        }
        finally {
            ignoreAfterTheFirstArgument = false;
        }
    }

    /**
     * Parse the command-line arguments and bind them to the field value of the
     * optionHolder
     * 
     * @param args
     * @throws OptionParserException
     */
    public void parse(String[] args) throws OptionParserException {
        // clear
        unusedArgument.clear();
        activatedOption.clear();
        activatedArgument.clear();

        // initialize collections in the OptionHolder
        for (OptionItem each : schema.getOptionItemList()) {
            each.initialize(optionHolder);
        }
        for (ArgumentItem each : schema.getArgumentItemList()) {
            each.initialize(optionHolder);
        }

        int index = 0; // index in the args array
        int argIndex = 0; // argument index
        for (; index < args.length; index++) {
            String currentArg = args[index];

            if (currentArg.startsWith("--")) {
                // long name option
                int splitPos = currentArg.indexOf('=');
                if (splitPos == -1) {
                    // no value is found
                    String longOptionName = currentArg.substring(2);
                    OptionItem optionItem = findOptionItem(schema, longOptionName);
                    if (optionItem == null) {
                        unusedArgument.add(currentArg);
                        continue;
                    }

                    if (optionItem.needsArgument())
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                "parameter value is required for --" + longOptionName);

                    setOption(optionItem, "true");

                    if (!optionItem.takesMultipleArguments()
                            && activatedOption.contains(optionItem.getOption()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION,
                                optionItem.getOption().toString());

                    activatedOption.add(optionItem.getOption());
                }
                else {
                    // option is a (key, value) pair
                    String longOptionName = currentArg.substring(2, splitPos);
                    String value = currentArg.substring(splitPos + 1);
                    OptionItem optionItem = findOptionItem(schema, longOptionName);
                    if (optionItem == null) {
                        unusedArgument.add(currentArg);
                        continue;
                    }

                    if (!optionItem.needsArgument()) {
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                "syntax error --" + longOptionName);
                    }

                    setOption(optionItem, value);
                    if (!optionItem.takesMultipleArguments()
                            && activatedOption.contains(optionItem.getOption()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION,
                                optionItem.getOption().toString());

                    activatedOption.add(optionItem.getOption());
                }

            }
            else if (currentArg.startsWith("-")) {
                // option with a leading hyphen (e.g. "-txvf" is equivalent to "-t", "-x", "-v" and "-f")
                String shortOptionList = currentArg.substring(1);
                for (int i = 0; i < shortOptionList.length(); i++) {
                    String shortOptionName = shortOptionList.substring(i, i + 1);
                    OptionItem optionItem = findOptionItem(schema, shortOptionName);
                    if (optionItem == null) {
                        unusedArgument.add(currentArg);
                        continue;
                    }

                    if (optionItem.needsArgument()) {
                        if (shortOptionList.length() != 1)
                            throw new OptionParserException(
                                    XerialErrorCode.SYNTAX_ERROR,
                                    String
                                            .format(
                                                    "short name option -%s with an arguments must be a single notation",
                                                    shortOptionName));

                        setOption(optionItem, args[++index]);
                    }
                    else
                        setOption(optionItem, "true");

                    if (!optionItem.takesMultipleArguments()
                            && activatedOption.contains(optionItem.getOption()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION,
                                optionItem.getOption().toString());

                    activatedOption.add(optionItem.getOption());
                }
            }
            else {
                // general argument
                ArgumentItem argItem = schema.getArgument(argIndex);
                if (argItem == null) {
                    if (ignoreUnknownOption) {
                        unusedArgument.add(currentArg);
                    }
                    else
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                "unused argument: " + currentArg);
                }
                else {
                    try {
                        argItem.set(optionHolder, currentArg);
                    }
                    catch (XerialException e) {
                        throw new OptionParserException(XerialErrorCode.INVALID_ARGUMENT, e
                                .getMessage());
                    }

                    // when duplicate values for the argument variable have found
                    if (!argItem.takesMultipleArguments()
                            && activatedArgument.contains(argItem.getArgumentDescriptor()))
                        throw new OptionParserException(XerialErrorCode.DUPLICATE_OPTION, argItem
                                .getArgumentDescriptor().toString());

                    activatedArgument.add(argItem.getArgumentDescriptor());
                    argIndex++;
                }

                if (ignoreAfterTheFirstArgument) {
                    // put all the arguments after the current argument to the list, and exits the loop
                    index++;
                    for (; index < args.length; index++) {
                        unusedArgument.add(args[index]);
                    }
                }
            }

        }

        // verify missing options & arguments
        for (ArgumentItem argItem : schema.getArgumentItemList()) {
            if (argItem.getArgumentDescriptor().required()
                    && !activatedArgument.contains(argItem.getArgumentDescriptor()))
                throw new OptionParserException(XerialErrorCode.MISSING_ARGUMENT, argItem
                        .toString());
        }

    }

    private void setOption(OptionItem item, String value) throws OptionParserException {
        try {
            item.setOption(optionHolder, value);
        }
        catch (XerialException e) {
            XerialErrorCode be = e.getErrorCode();
            switch (be) {
            case InvalidFormat:
                throw new OptionParserException(XerialErrorCode.INVALID_ARGUMENT, String.format(
                        "cannot set %s to %s", value, item.toString()));
            default:
                throw new OptionParserException(e.<XerialErrorCode> getErrorCode(), e.getMessage());
            }
        }
    }

    /**
     * Set this true when ignoring unknown options and arguments that match the
     * input arguments
     * 
     * @param ignore
     */
    public void setIgnoreUnknownOption(boolean ignore) {
        ignoreUnknownOption = ignore;
    }

}
