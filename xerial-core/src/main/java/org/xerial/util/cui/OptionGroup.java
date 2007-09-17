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


import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;


/**
 * OptionGroup creates a bundle of options
 * 
 * By setting some OptionGroup as exclusive, you can prevent multiple exclusive
 * OptionGroups will be activated at the same time.
 * 
 * <h3>usage </h3>
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
     * @param groupName the group name
     * @param isExclusive true when you forbid the activation of other option groups, which belong to the same level with this option group     
     *  */
    public OptionGroup(String groupName, boolean isExclusive)
    {
        super(null);
        _groupName = groupName;
        _isExclusive = isExclusive;
    }
    
    /** 
     * Adds an option to this option group
     * @param optionID  the option ID
     * @param shortOptionName 
     * @param longOptionName
     * @param description
     */
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description)
    {
        addOption(new Option<OptionID>(this, optionID, shortOptionName, longOptionName, description));
    }
    public void addOption(OptionID optionID, String shortOptionName, String longOptionName, String description, boolean presetValue)
    {
        addOption(new Option<OptionID>(this, optionID, shortOptionName, longOptionName, description, presetValue));
    }
    public void addOption(Option<OptionID> option)
    {
    	_contents.add(option);
    }

    public void addOptionWithArgment(OptionID optionID, String shortOptionName, String longOptionName, String argumentName, String description)
    {
        _contents.add(new OptionWithArgument<OptionID>(this, optionID, shortOptionName, longOptionName, argumentName, description));        
    }
    public void addOptionWithArgment(OptionID optionID, String shortOptionName, String longOptionName, String argumentName, String description, Object defaultValue)
    {
        _contents.add(new OptionWithArgument<OptionID>(this, optionID, shortOptionName, longOptionName, argumentName, description, defaultValue));                
    }
    public void addOptionGroup(OptionGroup<OptionID> optionGroup)
    {
        optionGroup.setParent(this);
        _contents.add(optionGroup);
    }
    
    protected void collectOptionDescriptions(OptionDescriptionContainer container)
    {
        if(!_groupName.equals(""))  
            container.addDescription("[" + _groupName + "]");
        for(OptionBase<OptionID> opt : getChildren())
        {
           opt.collectOptionDescriptions(container);
        }
    }

    
    
    List<OptionBase<OptionID>> getChildren()
    {
        return _contents;
    }
    
    // @see lab.cb.common.cui.OptionComposite#findByLongOptionName(java.lang.String)
    protected Option<OptionID> findByLongOptionName(String longOption)
    {
        for(OptionBase<OptionID> opt : getChildren())
        {
            Option<OptionID> searchResult = opt.findByLongOptionName(longOption);
            if(searchResult != null)
                return searchResult;
        }
        return null;
    }

    // @see lab.cb.common.cui.OptionComposite#findByShortOptionName(java.lang.String)
    protected Option<OptionID> findByShortOptionName(String shortOption)
    {
        for(OptionBase<OptionID> opt : getChildren())
        {
            Option<OptionID> searchResult = opt.findByShortOptionName(shortOption);
            if(searchResult != null)
                return searchResult;
        }
        return null;
    }

    // @see lab.cb.common.cui.OptionComposite#findOption(java.lang.Comparable)
    protected Option<OptionID> findOption(OptionID optionID)
    {
        for(OptionBase<OptionID> opt : getChildren())
        {
            Option<OptionID> searchResult = opt.findOption(optionID);
            if(searchResult != null)
                return searchResult;
        }
        return null;
    }

    // @see lab.cb.common.cui.OptionComposite#collectOptionID(java.util.List)
    protected void collectOptionID(List<OptionID> optionIDList)
    {
        for(OptionBase<OptionID> opt : getChildren())
        {
            opt.collectOptionID(optionIDList);
        }
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
     * Tests there are exclusive option groups that are simultaneously activated in the same level (depth)
     * @throws OptionParserException when exclusive option groups are activated at the same time
     */
    void validateExclusiveness() throws OptionParserException
    {
        TreeSet<String> activeAndIncompatibleGroups = new TreeSet<String>();
        for(OptionBase<OptionID> opt : _contents)
        {
            if(opt instanceof OptionGroup)
            {
                OptionGroup<OptionID> optGroup = (OptionGroup<OptionID>) opt;
                if(optGroup.isExclusive() && optGroup.isActive())
                {
                    activeAndIncompatibleGroups.add(optGroup.getGroupName());
                }
                optGroup.validateExclusiveness();
            }
        }
        if(activeAndIncompatibleGroups.size() > 1)
            throw new OptionParserException("options in groups " + activeAndIncompatibleGroups + " cannot be set simultaneously");
    }
    
	public void handle(String[] args, int argIndex) {
    	// do nothing in default
	}


}



  