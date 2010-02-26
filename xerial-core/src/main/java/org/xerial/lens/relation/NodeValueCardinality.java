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
// NodeCount.java
// Since: Mar 16, 2009 1:03:06 PM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/query/NodeValueCardinality.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation;

public class NodeValueCardinality implements Comparable<NodeValueCardinality> {
    public final String nodeName;
    public final int distinctCount;
    public final TupleIndex relationIndex;

    public NodeValueCardinality(String nodeName, int distinctCount, TupleIndex relationIndex) {
        this.nodeName = nodeName;
        this.distinctCount = distinctCount;
        this.relationIndex = relationIndex;
    }

    public int compareTo(NodeValueCardinality other) {
        int diff = this.distinctCount - other.distinctCount;
        if (diff != 0)
            return diff;

        int indexDiff = this.relationIndex.compareTo(other.relationIndex);
        assert indexDiff != 0;
        return diff;
    }

    @Override
    public String toString() {
        return String.format("%s<%d>", nodeName, distinctCount);
    }
}
