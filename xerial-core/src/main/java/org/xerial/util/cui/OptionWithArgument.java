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
// OptionWithArgument.java
// Since: 2005/01/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;


/**
 * 
 * A command line option that takes arguments
 * 
 * @author leo
 *
 */
class OptionWithArgument<OptionID extends Comparable> extends Option<OptionID>
{

    /**
     * 
     */
    public OptionWithArgument(OptionGroup<OptionID> parentGroup, OptionID optionID, String shortOptionName, String longOptionName, String argumentName, String description)
    {
        super(parentGroup, optionID, shortOptionName, longOptionName, description);
        _argumentName = argumentName;
    }

    public OptionWithArgument(OptionGroup<OptionID> parentGroup, OptionID optionID, String shortOptionName, String longOptionName, String argumentName, String description, Object defaultValue)
    {
        super(parentGroup, optionID, shortOptionName, longOptionName, description);
        _argumentName = argumentName;
        _argumentValue = defaultValue.toString();
    }

    public String getArgumentValue()
    {
        return _argumentValue;
    }
    
    public void setArgumentValue(String value)
    {
        _argumentValue = value;
    }
    
    // @see lab.cb.common.cui.Option#takeArgument()
    public boolean takeArgument()
    {
        return true;
    }
    
    public String getShortOptionName()
    {
        return _shortName.equals("") ? "" :  "-" + _shortName + (_longName.equals("") ? " " + _argumentName : ", ");
    }
    
    public String getLongOptionName()
    {
        return _longName.equals("") ? "" : "--" + _longName + "=" + _argumentName;
    }
    
    
    private String _argumentValue = null;
    private String _argumentName;
}




