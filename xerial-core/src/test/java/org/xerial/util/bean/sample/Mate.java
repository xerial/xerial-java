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
// Mate.java
// Since: Dec 19, 2007 6:34:06 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.Map;
import java.util.TreeMap;

public class Mate
{
    Map<Person, Person> pair = new TreeMap<Person, Person>();
    public Mate() {}
    
    public Map<Person, Person> getPair() {
        return pair;
    }
    public void setPair(Map<Person, Person> pair) {
        this.pair = pair;
    }
    
    public void putPair(Person p1, Person p2)
    {
        pair.put(p1, p2);
    }
    public Person getPair(Person p1)
    {
        return pair.get(p1);
    }
}
