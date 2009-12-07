/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// SilkNode.java
// Since: Feb 2, 2009 10:41:58 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import org.xerial.silk.model.SilkElement;

/**
 * Event data of {@link SilkLinePullParser}
 * 
 * @author leo
 * 
 */
public class SilkEvent
{
    private final SilkEventType type;
    private final SilkElement element;

    public SilkEvent(SilkEventType type, SilkElement element)
    {
        this.type = type;
        this.element = element;
    }

    public SilkEventType getType()
    {
        return type;
    }

    public SilkElement getElement()
    {
        return element;
    }

    @Override
    public String toString()
    {
        if (element == null)
            return String.format("[%s]", type);
        else
            return String.format("[%s] %s", type, element);
    }

}
