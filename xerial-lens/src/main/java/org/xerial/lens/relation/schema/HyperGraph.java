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
// HyperGraph.java
// Since: Oct 13, 2009 11:36:16 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Graph;

/**
 * HyperGraph schema for tree-structured data
 * 
 * @author leo
 * 
 */
public class HyperGraph {

    public static class HyperGraphNode {
        public final int id;
        public final String name;

        public HyperGraphNode(int id, String name) {

            assert (name != null);

            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null)
                return false;

            if (!HyperGraphNode.class.isInstance(obj))
                return false;

            HyperGraphNode other = HyperGraphNode.class.cast(obj);
            return (id == other.id) && (name.equals(other.name));
        }

        @Override
        public int hashCode() {

            int h = id * 137;
            h += name.hashCode() * 137;
            return h % 1987;
        }
    }

    private Graph<HyperGraphNode, String> hg = new AdjacencyList<HyperGraphNode, String>();

}
