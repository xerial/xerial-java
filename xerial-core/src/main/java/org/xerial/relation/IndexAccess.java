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
// IndexAccess.java
// Since: 2009/05/14 9:24:54
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

public interface IndexAccess<NodeType>
{
    /**
     * Get the cell at the specified index
     * 
     * @param index
     * @return
     */
    TupleCell<NodeType> get(TupleIndex index);

    /**
     * If the cell at the specified index is a node, then return the node,
     * otherwise return null
     * 
     * @param index
     * @return node
     */
    NodeType getNode(TupleIndex index);

    /**
     * if this cell is node, then return node. otherwise return null
     * 
     * @return
     */
    NodeType getNode();

    /**
     * If this cell is tuple, then return tuple. otherwise return null
     * 
     * @return
     */
    IndexAccess<NodeType> getTuple();

    /**
     * Accept the visitor
     * 
     * @param visitor
     */
    void accept(CellVisitor<NodeType> visitor);

}
