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
// Element.java
// Since: Oct 30, 2008 4:18:35 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.xml.dtd;

import org.xerial.lens.xml.dtd.ChildList;

public class Element
{
    private String    name        = null;
    private ChildList elementList = new ChildList();

    public Element()
    {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setChildList(ChildList elementList)
    {
        this.elementList = elementList;
    }

    public ChildList getChildList()
    {
        return elementList;
    }
}
