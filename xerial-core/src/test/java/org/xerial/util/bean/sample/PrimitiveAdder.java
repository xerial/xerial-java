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
// PrimitiveAdder.java
// Since: Dec 19, 2007 6:33:20 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.Vector;


public class PrimitiveAdder 
{
    Vector<Integer> valueList = new Vector<Integer>();
    public PrimitiveAdder()
    {}
    
    public void addValueList(Integer value)
    {
        valueList.add(value);
    }
    public Vector<Integer> getValueList() { return valueList; }
    
    @SuppressWarnings("unchecked")
    public void setValueList(Vector valueList)
    {
        // this setter must be ignored, so we set invalid values to the valueList
        valueList.clear();
        valueList.add(434);
        valueList.add(4134);
    }
}