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
// Option.java
// Since: 2005/01/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;

import java.util.List;


/**
 * {@link Option} represents a command line option
 * 
 * @author leo
 *
 */
public class Option<OptionID extends Comparable> extends OptionBase<OptionID>
{
    private OptionID _optionID;
    private boolean _flag = false;
    protected String _shortName;
    protected String _longName;
    private String _description;

    /**
     * 
     */
    public Option(OptionID optionID, String shortOptionName, String longOptionName, String description)
    {
        super(null);
        setValue(optionID, shortOptionName, longOptionName, description, false);
    }
    Option(OptionGroup<OptionID> parentGroup, OptionID optionID, String shortOptionName, String longOptionName, String description)
    {
        super(parentGroup);
        setValue(optionID, shortOptionName, longOptionName, description, false);
    }
    Option(OptionGroup<OptionID> parentGroup, OptionID optionID, String shortOptionName, String longOptionName, String description, boolean presetValue)
    {
        super(parentGroup);
        setValue(optionID, shortOptionName, longOptionName, description, presetValue);
    }
    
    private void setValue(OptionID optionID, String shortOptionName, String longOptionName, String description, boolean presetValue)
    {
        _optionID = optionID; 
        _shortName = shortOptionName;
        _longName = longOptionName;
        _description = description;
        _flag = presetValue;
    }
    
    public boolean isSet()
    {
        return _flag;
    }
    public void set(String[] args, int argIndex)
    {
        _flag = true; 
        this.activateParentGroup();
    }
     
    public OptionID getOptionID() 
    {
        return _optionID;
    }
    
    public boolean takeArgument()
    {
        return false;
    }
    
    // @see lab.cb.common.cui.OptionComposite#findByLongOptionName(java.lang.String)
    protected Option<OptionID> findByLongOptionName(String longOption)
    {
        if(_longName.equals(longOption))
            return this;
        else
            return null;
    }


    // @see lab.cb.common.cui.OptionComposite#findByShortOptionName(java.lang.String)
    protected Option<OptionID> findByShortOptionName(String shortOption)
    {
        if(_shortName.equals(shortOption))
            return this;
        else
            return null;
    }


    // @see lab.cb.common.cui.OptionComposite#findOption(java.lang.Comparable)
    protected Option<OptionID> findOption(OptionID optionID)
    {
        if(optionID.compareTo(_optionID) == 0)
            return this;
        else
            return null;
    }
    
    // @see lab.cb.common.cui.OptionComposite#collectOptionID(java.util.List)
    protected void collectOptionID(List<OptionID> optionIDList)
    {
        optionIDList.add(_optionID);
    }
    // @see lab.cb.common.cui.OptionComposite#collectOptionDescriptions(lab.cb.common.cui.OptionDescriptionContainer)
    protected void collectOptionDescriptions(OptionDescriptionContainer container)
    {
        container.addDescription(getShortOptionName(), getLongOptionName(), getDescription());
    }
    public String getLongOptionName()
    {
        return _longName.equals("") ? "" : "--" + _longName;  
    }
    public String getShortOptionName()
    {
        return _shortName.equals("") ? "" : "-" + _shortName + (_longName.equals("") ? " " : ", ");
    }
    public String getDescription()
    {
        return _description;
    }
    

    
}




