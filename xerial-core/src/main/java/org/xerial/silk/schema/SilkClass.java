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
// SilkClass.java
// Since: Jul 3, 2009 2:41:11 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class definition
 * 
 * @author leo
 * 
 */
public class SilkClass {
    public String name;

    public String parent = null;
    public String belongsTo = null;

    public List<String> mixin;
    public List<SilkAttribute> attribute = new ArrayList<SilkAttribute>();

    public List<SilkIndexTarget> index = new ArrayList<SilkIndexTarget>();

    private List<SilkAttribute> visibleAttributes = null;

    public SilkClass getParent(SilkSchema schema) {
        if (parent == null)
            return null;

        return schema.getSilkClass(parent);
    }

    /**
     * Returns all attributes including inherited ones.
     * 
     * @param schema
     * @return list of visible attributes from this class definition
     */
    public List<SilkAttribute> getInheritedAttributes(SilkSchema schema) {

        if (visibleAttributes != null)
            return visibleAttributes;

        Map<String, SilkAttribute> table = new HashMap<String, SilkAttribute>();
        // from parent
        if (parent != null)
            collectInheritedAttributes(table, schema, parent);

        // from mixin
        if (mixin != null && !mixin.isEmpty()) {
            for (String each : mixin)
                collectInheritedAttributes(table, schema, each);
        }

        // from this class's own attributes
        for (SilkAttribute each : attribute) {
            table.put(each.name, each);
        }

        List<SilkAttribute> result = new ArrayList<SilkAttribute>();
        result.addAll(table.values());
        visibleAttributes = result;

        return visibleAttributes;
    }

    private static void collectInheritedAttributes(Map<String, SilkAttribute> result,
            SilkSchema schema, String className) {
        SilkClass c = schema.getSilkClass(className);
        if (c != null) {
            List<SilkAttribute> parentAttributes = c.getInheritedAttributes(schema);
            for (SilkAttribute each : parentAttributes)
                result.put(each.name, each);
        }
    }

}
