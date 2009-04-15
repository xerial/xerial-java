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

/**
 * Base implementation of the table of collections:
 * 
 * <pre>
 *  {
 *   key1 =&gt; [v1, v2, ...],
 *   key2 =&gt; [v3, ...]
 *  }
 * </pre>
 * 
 * @author leo
 * 
 * @param <Key>
 * @param <Value>
 */
public abstract class Chain<Key, Value, ValueChain extends Collection<Value>>
{
    private Map<Key, ValueChain> map;

    protected abstract Map<Key, ValueChain> newMap();

    protected abstract ValueChain newValueChain();

    protected Chain()
    {
        map = newMap();
    }

    protected Map<Key, ValueChain> getMap()
    {
        return map;
    }

    /**
     * Returns true when ValueChain for the specified key exists, otherwise
     * returns false.
     * 
     * @param key
     *            key value of the chain
     * @return
     */
    public boolean containsKey(Key key)
    {
        return map.containsKey(key);
    }

    public ValueChain put(Key key, Value value)
    {
        ValueChain target = this.get(key);
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

    /**
     * Returns the chain of the specified key
     * 
     * @param key
     *            key value of the chain
     * @return chain corresponding to the specified key
     */
    public ValueChain get(Key key)
    {
        ValueChain target = map.get(key);
        if (target == null)
        {
            target = newValueChain();
            map.put(key, target);
        }
        return target;
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
