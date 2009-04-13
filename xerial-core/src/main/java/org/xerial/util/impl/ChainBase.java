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
// ChainBase.java
// Since: Mar 30, 2009 6:47:58 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.xerial.util.HashedArrayList;

/**
 * A base implementation of {@link HashedArrayList}
 * 
 * @author leo
 * 
 * @param <Key>
 * @param <Value>
 */
public abstract class ChainBase<Key, Value, ValueChain extends Collection<Value>>
{
    private Map<Key, ValueChain> map;

    protected abstract Map<Key, ValueChain> newMap();

    protected abstract ValueChain newValueChain();

    public ChainBase()
    {
        map = newMap();
    }

    public boolean containsKey(Key key)
    {
        return map.containsKey(key);
    }

    public ValueChain put(Key key, Value value)
    {
        ValueChain target = map.get(key);
        if (target == null)
        {
            target = newValueChain();
            map.put(key, target);
        }
        target.add(value);

        return target;
    }

    public ValueChain remove(Key key)
    {
        return map.remove(key);
    }

    public int size()
    {
        return map.size();
    }

    public ValueChain get(Key key)
    {
        return map.get(key);
    }

    public Set<Key> keySet()
    {
        return map.keySet();
    }

    public Collection<ValueChain> values()
    {
        return map.values();
    }
}
