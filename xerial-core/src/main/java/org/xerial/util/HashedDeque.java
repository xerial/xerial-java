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
// HashedDeque.java
// Since: 2009/04/14 8:38:46
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.HashMap;
import java.util.Map;

import org.xerial.util.impl.ChainBase;

/**
 * Hash table of deques.
 * 
 * 
 * @author leo
 * 
 * @param <Key>
 * @param <Value>
 */
public class HashedDeque<Key, Value> extends ChainBase<Key, Value, Deque<Value>>
{

    @Override
    protected Map<Key, Deque<Value>> newMap()
    {
        return new HashMap<Key, Deque<Value>>();
    }

    @Override
    protected Deque<Value> newValueChain()
    {
        return new ArrayDeque<Value>();
    }

}
