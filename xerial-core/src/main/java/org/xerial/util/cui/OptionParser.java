/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// XerialJ Project
//
// OptionParser.java
// Since: 2005/01/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import org.xerial.core.XerialErrorCode;

/**
 * <p>
 * {@link OptionParser} parses command line arguments
 * </p>
 * 
 * <h3>Usage:</h3>
 * 
 * <pre>
 * 
 *  public static void main(String[] args)
 *  {
 *       enum Opt { HELP, OUTDIR } 
 *       OptionParser&lt;Opt&gt; p = new OptionParser&lt;Opt&gt;();
 *       p.addOption(Opt.HELP, &quot;h&quot;, &quot;help&quot;, &quot;display help message&quot;);
 *       // adds an option with an argument whose default value is &quot;.&quot;     
 *       p.addOptionWithArgument(Opt.OUTDIR, &quot;o&quot;, &quot;outdir&quot;, &quot;DIR&quot;, &quot;specify output direcotry&quot;, &quot;.&quot;);
 *       
 *       p.parse(args);
 *       
 *       if(p.isSet(Opt.HELP))
 *       {
 *          // print help message
 *          System.out.println(p.helpMessage());
 *          return; 
 *       }
 *       
 *       if(p.isSet(Opt.OUTDIR))
 *       {
 *           String outDir = p.getValue(Opt.OUTDIR);
 *       }
 *   }
 * 
 * </pre>
 * 
 * @param OptionID
 *            A {@link Integer} or {@link Enum} class that can be used IDs for
 *            options. OptionID must implement {@link Comparable} interface.
 * 
 * @author leo
 * 
 * @see no longer maintained. Use {@link org.xerial.util.opt.OptionParser},
 *      which is easier to use, instead.
 * 
 * 
 */
public class OptionParser<OptionID extends Comparable>
{

    private OptionGroup<OptionID> _rootOptionGroup    = new OptionGroup<OptionID>("");
    private Vector<String>        _argumentList       = new Vector<String>();
    private TreeSet<String>       _activeGroupSet     = new TreeSet<String>();
    private TreeSet<OptionID>     _optionIDSet        = new TreeSet<OptionID>();

    private boolean               ignoreUnknownOption = false;

    /**
     * A constructor
     */
    public OptionParser()
    {}

    /**
     * Adds an option to detect
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description)
    {
        addNewOptionID(optionID);
        _rootOptionGroup.addOption(optionID, shortOptionName, longOptionName, description);
    }

    /**
     * Adds an option to detect
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     * @param handler
     *            the option argument handler invoked when the option is set
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description,
            OptionHandler handler)
    {
        addNewOptionID(optionID);

        _rootOptionGroup.addOptionHandler(optionID, handler);
        _rootOptionGroup.addOption(optionID, shortOptionName, longOptionName, description);
    }

    /**
     * @param option
     * @deprecated use
     *             {@link #addOption(Comparable, String, String, String, OptionHandler)}
     *             instead.
     */
    public void addOption(OptionWithNoArgument<OptionID> option)
    {
        option.setParent(_rootOptionGroup);
        addNewOptionID(option.getOptionID());
        _rootOptionGroup.addOption(option);
    }

    /**
     * Adds an option with the default argument (set or not set)
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     * @param presetValue
     *            when true, the option is assumed to be set in default,
     *            otherwise false
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description,
            boolean presetValue)
    {
        addNewOptionID(optionID);
        _rootOptionGroup.addOption(optionID, shortOptionName, longOptionName, description, presetValue);
    }

    /**
     * Adds an option that takes an argument value
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     */
    public void addOptionWithArgument(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description)
    {
        addNewOptionID(optionID);
        _rootOptionGroup.addOptionWithArgment(optionID, shortOptionName, longOptionName, argumentName, description);
    }

    /**
     * Adds an option that takes an argument value
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     * @param handler
     *            the option argument handler invoked when the option is set
     */
    public void addOptionWithArgument(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description, OptionHandler<OptionID> handler)
    {
        addNewOptionID(optionID);
        _rootOptionGroup.addOptionHandler(optionID, handler);
        _rootOptionGroup.addOptionWithArgment(optionID, shortOptionName, longOptionName, argumentName, description);
    }

    /**
     * Adds an option that takes an argument value
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     * @param defaultValue
     *            the default value of the option
     */
    public void addOptionWithArgument(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description, String defaultValue)
    {
        addNewOptionID(optionID);
        _rootOptionGroup.addOptionWithArgment(optionID, shortOptionName, longOptionName, argumentName, description,
                defaultValue);
    }

    /**
     * Adds an option that takes an argument value
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name, e.g. "h", which corresponds to "-h" in
     *            the command line arguments.
     * @param longOptionName
     *            the long option name, e.g. "help", which corresponds to
     *            "--help" in the command line arguments.
     * @param description
     *            the description of the option, which is used to generate the
     *            help message of this option
     * @param defaultValue
     *            the default value of the option
     * @param handler
     *            the option argument handler invoked when the option is set
     */
    public void addOptionWithArgument(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description, String defaultValue, OptionHandler<OptionID> handler)
    {
        addNewOptionID(optionID);
        _rootOptionGroup.addOptionHandler(optionID, handler);
        _rootOptionGroup.addOptionWithArgment(optionID, shortOptionName, longOptionName, argumentName, description,
                defaultValue);
    }

    /**
     * Adds an option group
     * 
     * @param optionGroup
     *            the option group
     */
    public void addOptionGroup(OptionGroup<OptionID> optionGroup)
    {
        LinkedList<OptionID> optionIDList = new LinkedList<OptionID>();
        optionGroup.collectOptionID(optionIDList);
        for (OptionID optID : optionIDList)
            addNewOptionID(optID);
        _rootOptionGroup.addOptionGroup(optionGroup);
    }

    /**
     * Parses the command line arguments. After calling this method, you can
     * retrieve the status of options via {@link #isSet(Comparable)} or
     * {@link #getValue(Comparable)} methods, etc.
     * 
     * @param args
     *            the command line arguments, which is given by the
     *            main(String[] args) method
     * @throws OptionParserException
     *             when the given command line has invalid syntax or when
     *             incompatible options are set at the same time.
     */
    public void parse(String[] args) throws OptionParserException
    {
        int index = 0;

        TreeSet<OptionID> activatedOptionSet = new TreeSet<OptionID>();

        while (index < args.length)
        {
            String arg = args[index];
            if (arg.startsWith("--"))
            {
                // long name option
                int splitPos = arg.indexOf('=');
                String longOptionName, value;
                if (splitPos == -1)
                {
                    // no value is found
                    longOptionName = arg.substring(2);
                    OptionWithNoArgument<OptionID> opt = _rootOptionGroup.findByLongOptionName(longOptionName);
                    if (opt == null)
                        if (ignoreUnknownOption)
                        {
                            index++;
                            continue;
                        }
                        else
                            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option --"
                                    + longOptionName);
                    if (opt.takeArgument())
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                "parameter value is required for --" + longOptionName);
                    opt.set(args, index);
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
                            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option --"
                                    + longOptionName);
                    if (opt instanceof OptionWithArgument)
                    {
                        OptionWithArgument<OptionID> optWithArg = (OptionWithArgument<OptionID>) opt;
                        optWithArg.setArgumentValue(value);
                        optWithArg.set(args, index);
                        activatedOptionSet.add(optWithArg.getOptionID());
                    }
                    else
                        throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "syntax error --"
                                + longOptionName);
                }
            }
            else if (arg.startsWith("-"))
            {
                // short name option
                String shortOptionList = arg.substring(1);
                for (int i = 0; i < shortOptionList.length(); i++)
                {
                    String shortOption = shortOptionList.substring(i, i + 1);
                    OptionWithNoArgument<OptionID> opt = _rootOptionGroup.findByShortOptionName(shortOption);
                    if (opt == null)
                        if (ignoreUnknownOption)
                        {
                            index++;
                            continue;
                        }
                        else
                            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option -"
                                    + shortOption);
                    if (opt.takeArgument())
                    {
                        if (shortOptionList.length() != 1)
                            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                    "options with argument must be isolated: -" + shortOption);
                        if (opt instanceof OptionWithArgument)
                        {
                            OptionWithArgument optWithArg = (OptionWithArgument) opt;
                            if (++index < args.length)
                                optWithArg.setArgumentValue(args[index]);
                            else
                                throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR,
                                        "parameter value is required for -" + shortOption);
                        }
                    }
                    opt.set(args, index);
                    activatedOptionSet.add(opt.getOptionID());
                }
            }
            else
            {
                // plain argument
                _argumentList.add(arg);
            }
            index++;
        }

        // validate whether incompatible options are set at the same time
        _rootOptionGroup.validateExclusiveness();

        // invokes option handlers
        for (OptionID optID : activatedOptionSet)
        {
            OptionHandler handler = _rootOptionGroup.getOptionHandler(optID);
            if (handler != null)
            {
                handler.handle(this);
            }
        }
    }

    /**
     * Get the list of command-line arguments except option related ones
     * 
     * @return
     */
    public List<String> getArgument()
    {
        return _argumentList;
    }

    /**
     * Get a command line argument
     * 
     * @param index
     *            argumetn index (0 origin)
     * @return the command line argument at the index
     */
    public String getArgument(int index)
    {
        return _argumentList.get(index);
    }

    /**
     * Get the argument length (except option related ones)
     * 
     * @return the number of arguments
     */
    public int getArgumentLength()
    {
        return _argumentList.size();
    }

    /**
     * Test whether the option is set in the command line argument
     * 
     * @param optionID
     *            the target option
     * @return true if the option is set in the command line, otherwise false
     * @throws OptionParserException
     *             if unknown option ID is given in the argument
     */
    public boolean isSet(OptionID optionID) throws OptionParserException
    {
        OptionWithNoArgument<OptionID> option = findOption(optionID);
        if (option == null)
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option " + optionID);
        return option.isSet();
    }

    /**
     * Get the integer value of the option (ex. if the option is --width=100,
     * return 100 (int))
     * 
     * @param optionID
     * @return the integer value of the option value
     * @throws OptionParserException
     *             if no corresponding option ID is found in the
     *             {@link OptionParser}, or the specified option cannot take any
     *             argument. Or the argument value cannot be translated into
     *             integer.
     */
    public int getIntValue(OptionID optionID) throws OptionParserException
    {
        try
        {
            return Integer.parseInt(getValue(optionID));
        }
        catch (NumberFormatException e)
        {
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, e);
        }
    }

    /**
     * Get the option value in double format
     * 
     * @param optionID
     *            the option ID
     * @return the double value of the option
     * @throws OptionParserException
     *             if no corresponding option ID is found in the
     *             {@link OptionParser}, or the specified option cannot take any
     *             argument. Or the option value cannot be translated into
     *             double.
     */
    public double getDoubleValue(OptionID optionID) throws OptionParserException
    {
        try
        {
            return Double.parseDouble(getValue(optionID));
        }
        catch (NumberFormatException e)
        {
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, e);
        }

    }

    /**
     * Get the option value in float format
     * 
     * @param optionID
     *            the option ID
     * @return the float value of the option
     * @throws OptionParserException
     *             if no corresponding option ID is found in the
     *             {@link OptionParser}, or the specified option cannot take any
     *             argument. Or the option value cannot be translated into
     *             float.
     */
    public float getFloatValue(OptionID optionID) throws OptionParserException
    {
        try
        {
            return Float.parseFloat(getValue(optionID));
        }
        catch (NumberFormatException e)
        {
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, e);
        }
    }

    /**
     * Gets the option argument value as a {@link String}
     * 
     * @param optionID
     *            the target option that takes argument value
     * @return the string value of the specified option argument
     * @throws OptionParserException
     *             if the specified option ID is not found or if the option
     *             cannot take arguments
     */
    public String getValue(OptionID optionID) throws OptionParserException
    {
        OptionWithNoArgument<OptionID> targetOption = _rootOptionGroup.findOption(optionID);
        if (targetOption == null)
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option: " + optionID);
        if (!(targetOption instanceof OptionWithArgument))
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "option " + optionID
                    + " cannot take any argument");

        OptionWithArgument<OptionID> optWithArg = (OptionWithArgument<OptionID>) (targetOption);
        return optWithArg.getArgumentValue();
    }

    /**
     * Gets the option argument value as a {@link String}
     * 
     * @param optionID
     *            the target option that takes argument value
     * @param defaultValue
     *            the default value to be returned when this option is not
     *            present in the command line arguments
     * @return the string value of the specified option argument
     * @throws OptionParserException
     *             if the specified option ID is not found or if the option
     *             cannot take arguments
     */
    public String getValue(OptionID optionID, String defaultValue) throws OptionParserException
    {
        OptionWithNoArgument<OptionID> targetOption = _rootOptionGroup.findOption(optionID);
        if (targetOption == null)
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "unknown option: " + optionID);
        if (!(targetOption instanceof OptionWithArgument))
            throw new OptionParserException(XerialErrorCode.SYNTAX_ERROR, "option " + optionID
                    + " cannot take any argument");

        OptionWithArgument<OptionID> optWithArg = (OptionWithArgument<OptionID>) (targetOption);
        String value = optWithArg.getArgumentValue();
        return (value == null) ? defaultValue : value;
    }

    /**
     * Generates the help message for this option parser
     * 
     * @return the help message that can be used as a list of command line
     *         options
     */
    public String helpMessage()
    {
        OptionDescriptionContainer container = new OptionDescriptionContainer();
        _rootOptionGroup.collectOptionDescriptions(container);

        return container.toString();
    }

    private OptionWithNoArgument<OptionID> findOption(OptionID optionID)
    {
        return _rootOptionGroup.findOption(optionID);
    }

    private void addNewOptionID(OptionID newOptionID)
    {
        if (_optionIDSet.contains(newOptionID))
            throw new IllegalArgumentException("duplicate addition of OptionID: " + newOptionID);

        _optionIDSet.add(newOptionID);
    }

    public void setIgnoreUnknownOption(boolean ignore)
    {
        ignoreUnknownOption = ignore;
    }

}
