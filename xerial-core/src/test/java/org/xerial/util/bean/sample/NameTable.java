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
// NameTable.java
// Since: Dec 19, 2007 6:33:40 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.Map;
import java.util.TreeMap;


public class NameTable
{
    Map<Integer, String> nameTable = new TreeMap<Integer, String>();
    
    public NameTable() {}
    public NameTable(Map<Integer, String> nameTable)
    {
        this.nameTable = nameTable;
    }
    
    public String getNameTable(Integer key) 
    {
        return nameTable.get(key);
    }

    public void putNameTable(Integer key, String value)
    {
        nameTable.put(key, value);
    }
    
    public Map<Integer, String> getNameTable() {
        return nameTable;
    }
    public void setNameTable(Map<Integer, String> nameTable) {
        this.nameTable = nameTable;
    }
}

