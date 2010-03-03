/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// Xerial Raquel Project
//
// RelationDefinition.java
// Since: Oct 6, 2008 2:52:59 PM
//
// $URL: http://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/expr/RelationExpr.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;
import java.util.List;

import org.xerial.lens.ObjectLens;
import org.xerial.util.StringUtil;

/**
 * A common interface for {@link RelationSchema} and {@link RelationAttribute}
 * 
 * @author leo
 * 
 */
public class RelationExpr {

    private String relationName;

    private final ArrayList<RelationAttribute> attributeList = new ArrayList<RelationAttribute>();

    public static class TreeDefinition {
        private String name;

        public TreeDefinition() {}

        public TreeDefinition(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("tree: %s", name);
        }

    }

    public void addRelationAttribute(RelationAttribute attribute) {
        this.attributeList.add(attribute);
    }

    public String getName() {
        return relationName;
    }

    /**
     * Set the relation name
     * 
     * @param name
     */
    public void setName(String name) {
        this.relationName = ObjectLens.getCanonicalParameterName(name);
    }

    public List<RelationAttribute> getAttributeList() {
        return attributeList;
    }

    @Override
    public String toString() {
        return String
                .format("relation %s (%s)", relationName, StringUtil.join(attributeList, ", "));
    }

}
