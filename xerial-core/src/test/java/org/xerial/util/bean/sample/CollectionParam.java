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
// CollectionParam.java
// Since: Dec 19, 2007 6:30:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CollectionParam
{
    Vector<String> nameList = new Vector<String>(); 
    ArrayList<Integer> idList = new ArrayList<Integer>();
    
    public CollectionParam(Vector<String> nameList, ArrayList<Integer> idList) {
        this.nameList = nameList;
        this.idList = idList;
    }
    
    public CollectionParam() {
    }

    public ArrayList<Integer> getIdList() {
        return idList;
    }
    public void setIdList(ArrayList<Integer> idList) {
        this.idList = idList;
    }
    public Vector<String> getNameList() {
        return nameList;
    }
    public void setNameList(Collection<String> nameList) {
        this.nameList.clear();
        this.nameList.addAll(nameList);
    }
}
