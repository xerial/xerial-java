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
// CUIOption.java
// Since: Oct 27, 2008 4:10:08 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

/**
 * @author leo
 * 
 */
class CUIOption
{
    final Option optionDescriptor;
    final OptionSetter optionSetter;

    public CUIOption(Option optionDescriptor, OptionSetter optionSetter)
    {
        this.optionDescriptor = optionDescriptor;
        this.optionSetter = optionSetter;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof CUIOption)
        {
            CUIOption other = (CUIOption) obj;
            return optionDescriptor.equals(obj);
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        return optionDescriptor.hashCode();
    }

}
