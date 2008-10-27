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
// Phenome Commons Project
//
// OptionGroup.java
// Since: 2005/01/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.xerial.core.StandardErrorCode;

/**
 * OptionGroup creates a bundle of options
 * 
 * By setting some OptionGroup as exclusive, you can prevent multiple exclusive
 * OptionGroups will be activated at the same time.
 * 
 * <h3>usage</h3>
 * 
 * <pre>
 *    enum Opt { &quot;cui&quot;, &quot;gui&quot; }
 *    OptionGroup&lt;Opt&gt; cuiGroup = new OptionGroup&lt;Opt&gt;(&quot;cui&quot;, true);
 *    cuiGroup.addOption(Opt.cui, &quot;c&quot;, &quot;cui&quot;, &quot;CUI mode&quot;);
 *    OptionGroup&lt;Opt&gt; guiGroup = new OptionGroup&lt;Opt&gt;(&quot;gui&quot;, true);
 *    guiGroup.addOption(Opt.gui, &quot;g&quot;, &quot;gui&quot;, &quot;GUI mode&quot;);
 *    
 *    OptionParser&lt;Opt&gt; parser = new OptionParser&lt;Opt&gt;();
 *    parser.addOptionGroup(cuiGroup);
 *    parser.addOptionGroup(guiGroup);
 *    
 *    parser.parse(new String[] {&quot;--cui&quot;, &quot;--gui&quot; }); // throws OptionParserException
 * 
 * </pre>
 * 
 * @author leo
 * 
 */
public class OptionGroup<OptionID extends Comparable> extends OptionBase<OptionID>
{
    private LinkedList<OptionBase<OptionID>> _contents = new LinkedList<OptionBase<OptionID>>();
    private String _groupName;
    private boolean _isActive = false;
    private boolean _isExclusive = false;
    private HashMap<OptionID, OptionHandler> _optionHandlerTable = new HashMap<OptionID, OptionHandler>();

    /**
     * 
     */
    public OptionGroup(String groupName)
    {
        super(null);
        _groupName = groupName;
    }

    /**
     * Creates an option group
     * 
     * @param groupName
     *            the group name
     * @param isExclusive
     *            true when you forbid the activation of other option groups,
     *            which belong to the same level with this option group
     * */
    public OptionGroup(String groupName, boolean isExclusive)
    {
        super(null);
        _groupName = groupName;
        _isExclusive = isExclusive;
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "h" as the argument,
     *            "-h" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "help" as the argument,
     *            "--help" can be used as a command line option
     * @param description
     *            the description of this option
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description)
    {
        addOption(new OptionWithNoArgument<OptionID>(this, optionID, shortOptionName, longOptionName, description));
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "h" as the argument,
     *            "-h" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "help" as the argument,
     *            "--help" can be used as a command line option
     * @param description
     *            the description of this option
     * @param presetValue
     *            true: this option is on in default, false: off
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description,
            boolean presetValue)
    {
        addOption(new OptionWithNoArgument<OptionID>(this, optionID, shortOptionName, longOptionName, description,
                presetValue));
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "h" as the argument,
     *            "-h" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "help" as the argument,
     *            "--help" can be used as a command line option
     * @param description
     *            the description of this option
     * @param handler
     *            {@link OptionHandler} invoked when this option is set
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description,
            OptionHandler<OptionID> handler)
    {
        addOption(new OptionWithNoArgument<OptionID>(this, optionID, shortOptionName, longOptionName, description),
                handler);
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "h" as the argument,
     *            "-h" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "help" as the argument,
     *            "--help" can be used as a command line option
     * @param description
     *            the description of this option
     * @param presetValue
     *            true: this option is on in default, false: off
     * @param handler
     *            {@link OptionHandler} invoked when this option is set
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description,
            boolean presetValue, OptionHandler<OptionID> handler)
    {
        addOption(new OptionWithNoArgument<OptionID>(this, optionID, shortOptionName, longOptionName, description,
                presetValue), handler);
    }

    void addOption(OptionWithNoArgument<OptionID> option, OptionHandler<OptionID> optionHandler)
    {
        addOptionHandler(option.getOptionID(), optionHandler);
        _contents.add(option);
    }

    void addOption(OptionWithNoArgument<OptionID> option)
    {
        _contents.add(option);
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "h" as the argument,
     *            "-h" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "help" as the argument,
     *            "--help" can be used as a command line option
     * @param argumentName
     *            argument name of this option. This argument is used only for
     *            displaying the help message.
     * @param description
     *            the description of this option
     * @param handler
     *            {@link OptionHandler} invoked when this option is set
     */
    public void addOptionWithArgment(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description)
    {
        _contents.add(new OptionWithArgument<OptionID>(this, optionID, shortOptionName, longOptionName, argumentName,
                description));
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "l" as the argument,
     *            "-l" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "loglevel" as the
     *            argument, "--loglevel" can be used as a command line option
     * @param argumentName
     *            argument name of this option. This argument is used only for
     *            displaying the help message.
     * @param description
     *            the description of this option
     * @param handler
     *            {@link OptionHandler} invoked when this option is set
     */
    public void addOptionWithArgment(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description, OptionHandler<OptionID> handler)
    {
        addOptionHandler(optionID, handler);
        _contents.add(new OptionWithArgument<OptionID>(this, optionID, shortOptionName, longOptionName, argumentName,
                description));
    }

    /**
     * Adds an option to this option group
     * 
     * @param optionID
     *            the option ID
     * @param shortOptionName
     *            the short option name. If you specified "h" as the argument,
     *            "-h" can be used as a command line option
     * @param longOptionName
     *            the long option name. If you specified "help" as the argument,
     *            "--help" can be used as a command line option
     * @param argumentName
     *            argument name of this option. This argument is used only for
     *            displaying the help message.
     * @param description
     *            the description of this option
     * @param defaultValue
     *            the default value of this option
     */
    public void addOptionWithArgment(OptionID optionID, String shortOptionName, String longOptionName,
            String argumentName, String description, String defaultValue)
    {
        _contents.add(new OptionWithArgument<OptionID>(this, optionID, shortOptionName, longOptionName, argumentName,
                description, defaultValue));
    }

    public void addOptionGroup(OptionGroup<OptionID> optionGroup)
    {
        optionGroup.setParent(this);
        _contents.add(optionGroup);
    }

    public void addOptionHandler(OptionID optionID, OptionHandler<OptionID> handler)
    {
        if (handler == null)
            throw new IllegalArgumentException("handler is null: " + optionID.toString());

        _optionHandlerTable.put(optionID, handler);
    }

    protected void collectOptionDescriptions(OptionDescriptionContainer container)
    {
        if (!_groupName.equals(""))
            container.addDescription("[" + _groupName + "]");
        for (OptionBase<OptionID> opt : getChildren())
        {
            opt.collectOptionDescriptions(container);
        }
    }

    List<OptionBase<OptionID>> getChildren()
    {
        return _contents;
    }

    // @see lab.cb.common.cui.OptionComposite#findByLongOptionName(java.lang.String)
    protected OptionWithNoArgument<OptionID> findByLongOptionName(String longOption)
    {
        for (OptionBase<OptionID> opt : getChildren())
        {
            OptionWithNoArgument<OptionID> searchResult = opt.findByLongOptionName(longOption);
            if (searchResult != null)
                return searchResult;
        }
        return null;
    }

    // @see lab.cb.common.cui.OptionComposite#findByShortOptionName(java.lang.String)
    protected OptionWithNoArgument<OptionID> findByShortOptionName(String shortOption)
    {
        for (OptionBase<OptionID> opt : getChildren())
        {
            OptionWithNoArgument<OptionID> searchResult = opt.findByShortOptionName(shortOption);
            if (searchResult != null)
                return searchResult;
        }
        return null;
    }

    // @see lab.cb.common.cui.OptionComposite#findOption(java.lang.Comparable)
    protected OptionWithNoArgument<OptionID> findOption(OptionID optionID)
    {
        for (OptionBase<OptionID> opt : getChildren())
        {
            OptionWithNoArgument<OptionID> searchResult = opt.findOption(optionID);
            if (searchResult != null)
                return searchResult;
        }
        return null;
    }

    // @see lab.cb.common.cui.OptionComposite#collectOptionID(java.util.List)
    protected void collectOptionID(List<OptionID> optionIDList)
    {
        for (OptionBase<OptionID> opt : getChildren())
        {
            opt.collectOptionID(optionIDList);
        }
    }

    /**
     * Finds the option handler of the specified optionID. This method
     * recursively searches nested option groups
     * 
     * @param optionID
     *            the option ID
     * @return the option handler
     */
    public OptionHandler<OptionID> getOptionHandler(OptionID optionID)
    {
        OptionHandler<OptionID> optionHandler = _optionHandlerTable.get(optionID);
        if (optionHandler != null)
            return optionHandler;

        for (OptionBase<OptionID> opt : getChildren())
        {
            if (opt instanceof OptionGroup)
            {
                OptionGroup<OptionID> optionGroup = (OptionGroup<OptionID>) opt;
                optionHandler = optionGroup.getOptionHandler(optionID);
                if (optionHandler != null)
                    return optionHandler;
            }
        }
        return null;
    }

    public boolean isActive()
    {
        return _isActive;
    }

    public void activate()
    {
        _isActive = true;
    }

    public String getGroupName()
    {
        return _groupName;
    }

    boolean isExclusive()
    {
        return _isExclusive;
    }

    /**
     * Tests there are exclusive option groups that are simultaneously activated
     * in the same level (depth)
     * 
     * @throws OptionParserException
     *             when exclusive option groups are activated at the same time
     */
    void validateExclusiveness() throws OptionParserException
    {
        TreeSet<String> activeAndIncompatibleGroups = new TreeSet<String>();
        for (OptionBase<OptionID> opt : _contents)
        {
            if (opt instanceof OptionGroup)
            {
                OptionGroup<OptionID> optGroup = (OptionGroup<OptionID>) opt;
                if (optGroup.isExclusive() && optGroup.isActive())
                {
                    activeAndIncompatibleGroups.add(optGroup.getGroupName());
                }
                optGroup.validateExclusiveness();
            }
        }
        if (activeAndIncompatibleGroups.size() > 1)
            throw new OptionParserException(StandardErrorCode.INVALID_STATE, String.format(
                    "options in groups %s cannot be set simultaneously", activeAndIncompatibleGroups));
    }

    public void handle(String[] args, int argIndex)
    {
    // do nothing in default
    }

}
