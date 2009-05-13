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
// Cell.java
// Since: 2009/05/13 9:20:19
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

/**
 * Table element
 * 
 * @author leo
 * 
 */
/**
 * @author leo
 * 
 */
public interface Cell
{
    /**
     * Returns true if this cell is a singleton node
     * 
     * @return
     */
    public boolean isAtom();

    /**
     * Returns true if this cell is a node tuple
     * 
     * @return
     */
    public boolean isTuple();

    /**
     * Get the number of elements contained in this cell. When this cell is an
     * atom, the size will be 1. When a tuple, the returned size is the tuple
     * size.
     * 
     * @return
     */
    public int size();

    /**
     * Get the cell at the specified index
     * 
     * @param index
     * @return
     */
    Cell get(TupleIndex index);

    /**
     * If the cell at the specified index is a node, then return the node,
     * otherwise return null
     * 
     * @param index
     * @return node
     */
    Node getNode(TupleIndex index);

    /**
     * if this cell is node, then return node. otherwise return null
     * 
     * @return
     */
    Node getNode();

    /**
     * If this cell is tuple, then return tuple. otherwise return null
     * 
     * @return
     */
    Tuple getTuple();

    /**
     * Accept the visitor
     * 
     * @param visitor
     */
    void accept(CellVisitor visitor);

}
