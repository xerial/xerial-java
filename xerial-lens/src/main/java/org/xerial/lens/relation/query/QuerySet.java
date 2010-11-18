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
// Xerial Raquel Project
//
// QuerySet.java
// Since: 2009/03/15 14:13:50
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaSet;
import org.xerial.lens.relation.schema.XMLSkeltonNode;
import org.xerial.util.IndexedSet;

/**
 * Set of target queries for the stream amoeba join.
 * 
 * @author leo
 * 
 */
public class QuerySet {
    private final IndexedSet<Schema> queryTarget = new IndexedSet<Schema>();
    private final Set<String> treeNodeSet = new HashSet<String>();

    public QuerySet() {}

    private QuerySet(Collection<Schema> schemaSet) {
        for (Schema eachSchema : schemaSet) {
            queryTarget.add(eachSchema);
        }
    }

    public QuerySet(SchemaSet schema) {
        for (String eachTreeNode : schema.getTreeNodeSet())
            treeNodeSet.add(eachTreeNode);

        for (XMLSkeltonNode eachSkelton : schema.getSkelton().getStateSet()) {
            for (Schema eachSchema : eachSkelton) {
                queryTarget.add(eachSchema);
            }
        }
    }

    public Set<Schema> getTargetQuerySet() {
        return queryTarget;
    }

    public boolean isTreeNode(String nodeName) {
        return treeNodeSet.contains(nodeName);
    }

    @Override
    public String toString() {
        return queryTarget.toString();
    }

    public static class QuerySetBuilder {
        List<Schema> schemaList = new ArrayList<Schema>();
        Set<String> treeNodeSet = new HashSet<String>();

        public void addTreeNode(String treeNode) {
            treeNodeSet.add(treeNode);
        }

        public void addQueryTarget(Schema schema) {
            schemaList.add(schema);
        }

        public QuerySet build() {
            return new QuerySet(schemaList);
        }

    }

}
