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
// HogeHoge.java
// Since: Dec 19, 2007 6:34:41 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class HogeHoge
{
    public SortedMap<Integer, String> map = new TreeMap<Integer, String>();
    public SortedMap<Integer, SortedMap<Integer, String>> graph = new TreeMap<Integer, SortedMap<Integer, String>>();

    public HogeHoge()
    {}

    public Map<Integer, String> getMap()
    {
        return map;
    }

    public void putMap(Integer key, String value)
    {
        map.put(key, value);
    }

    public Map getGraph()
    {
        return graph;
    }

    public void putGraph(Integer index, SortedMap<Integer, String> graphData)
    {
        graph.put(index, graphData);
    }

}
