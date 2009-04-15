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
// ChainMap.java
// Since: Mar 30, 2009 6:38:46 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.xerial.util.impl.Chain;

/**
 * Map structure key -> [value1, value2, ...]
 * 
 * 
 * @author leo
 * 
 */
public class HashedArrayList<Key, Value> extends Chain<Key, Value, ArrayList<Value>>
{
    @Override
    protected Map<Key, ArrayList<Value>> newMap()
    {
        return new HashMap<Key, ArrayList<Value>>();
    }

    @Override
    protected ArrayList<Value> newValueChain()
    {
        return new ArrayList<Value>();
    }

}
