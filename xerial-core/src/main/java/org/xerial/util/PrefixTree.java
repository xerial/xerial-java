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
// PrefixTree.java
// Since: 2010/03/25 23:11:30
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class PrefixTree<T> {

    private TreeMap<String, T> holder = new TreeMap<String, T>();

    public void clear() {
        holder.clear();
    }

    public void add(String key, T entry) {
        holder.put(key, entry);
    }

    public T findBy(String prefix) {
        String nextKey = holder.ceilingKey(prefix);
        if (nextKey == null)
            return null;

        SortedMap<String, T> tail = holder.tailMap(nextKey);
        for (String key : tail.keySet()) {
            if (key.startsWith(prefix)) {
                return tail.get(key);
            }
        }
        return null;
    }

    public T get(String key) {
        return holder.get(key);
    }

    public Set<String> keySet() {
        return holder.keySet();
    }

}
