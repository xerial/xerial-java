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
// SortedArrayList.java
// Since: Mar 30, 2009 6:55:18 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.xerial.util.impl.ChainBase;

/**
 * sorted key -> [value1, value2, .. ]
 * 
 * 
 * @author leo
 * 
 * @param <Key>
 * @param <Value>
 */
public class SortedArrayList<Key extends Comparable<Key>, Value> extends ChainBase<Key, Value, ArrayList<Value>>
{

    @Override
    protected Map<Key, ArrayList<Value>> newMap()
    {
        return new TreeMap<Key, ArrayList<Value>>();
    }

    @Override
    protected ArrayList<Value> newValueChain()
    {
        return new ArrayList<Value>();
    }
}
