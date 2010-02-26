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
// NTuple.java
// Since: Feb 26, 2010 3:31:21 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

import java.util.List;

/**
 * NestedTuple (NTuple) is a wrapper of the Tuple<TupleElement<Node>> class
 * 
 * @author leo
 * 
 */
public class NTuple extends Tuple<Node> {

    public NTuple() {
        super();
    }

    public NTuple(int tupleSize) {
        super(tupleSize);
    }

    public NTuple(List<TupleElement<Node>> nodeList) {
        super(nodeList);
    }

    public NTuple(Tuple<Node> other) {
        super(other);
    }

}
