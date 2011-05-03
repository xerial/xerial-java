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
// Person.java
// Since: Feb 1, 2008 11:19:39 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.util.ArrayList;

public class Person
{
    private int id;
    private String name;
    private ArrayList<String> phoneList = new ArrayList<String>();

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getPhoneList()
    {
        return phoneList;
    }

    public void addPhone(String phone)
    {
        phoneList.add(phone);
    }

}
