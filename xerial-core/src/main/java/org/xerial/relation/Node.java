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
// Node.java
// Since: 2009/05/13 9:18:34
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

/**
 * Node is a relation element.
 * 
 * @author leo
 * 
 */
public class Node implements Cell
{

    public boolean isAtom()
    {
        return true;
    }

    public boolean isTuple()
    {
        return false;
    }

    /**
     * 
     * @return
     */
    public int size()
    {
        return 1;
    }

    public void accept(CellVisitor visitor)
    {
        visitor.visitNode(this);
    }

    public Cell get(TupleIndex index)
    {
        return null;
    }

    public Node getNode(TupleIndex index)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Node getNode()
    {
        return this;
    }

    public Tuple getTuple()
    {
        return null;
    }

}
