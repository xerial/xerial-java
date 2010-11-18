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
// MapTreeParser.java
// Since: Jun 5, 2009 6:40:10 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.tree;

import java.util.Collection;
import java.util.Map;

import org.xerial.util.bean.TypeInfo;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeParser;

/**
 * TreeParse implementation for {@link Map} type data
 * 
 * @author leo
 * 
 */
public class MapTreeParser implements TreeParser {
    private final Map< ? , ? > map;

    public MapTreeParser(Map< ? , ? > map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    private Object currentKey;

    public void parse(TreeEventHandler handler) throws Exception {
        handler.init();
        walk(null, map, handler);
        handler.finish();
    }

    private void walk(String nodeName, Object value, TreeEventHandler handler) throws Exception {
        if (value == null) {
            handler.visitNode(nodeName, null);
            handler.leaveNode(nodeName);
            return;
        }

        assert value != null;

        Class< ? > valueType = value.getClass();
        if (TypeInfo.isArray(valueType)) {
            for (Object each : (Object[]) value) {
                walk(nodeName, each, handler);
            }
        }
        else if (TypeInfo.isCollection(valueType)) {
            for (Object each : (Collection< ? >) value) {
                walk(nodeName, each, handler);
            }
        }
        else if (TypeInfo.isMap(valueType)) {
            handler.visitNode(nodeName, null);
            Map< ? , ? > mapValue = (Map< ? , ? >) value;
            for (Object key : mapValue.keySet()) {
                currentKey = key;
                String entryName = key.toString();
                Object entryValue = map.get(key);
                walk(entryName, entryValue, handler);
            }
            handler.leaveNode(nodeName);
        }
        else {
            handler.visitNode(nodeName, value.toString());
            handler.leaveNode(nodeName);
        }

    }

}
