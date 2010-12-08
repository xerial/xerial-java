/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// Since: Jun 27, 2008 11:36:56 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

public class Person implements Comparable<Person>
{
    int id = -1;
    String name;
    String address;

    public Person()
    {}

    public Person(int id)
    {
        this.id = id;
    }

    /**
     * @param id
     * @param name
     */
    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Person(String name)
    {
        this.name = name;
    }

    public Person(String name, String address)
    {
        super();
        this.name = name;
        this.address = address;
    }

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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return String.format("id=%s, name=%s, address=%s", id, name, address);
    }

    public int compareTo(Person o)
    {
        return this.id - o.id;
    }

}
