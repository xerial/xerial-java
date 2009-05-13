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
// Tuple.java
// Since: 2009/05/13 9:19:34
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

import java.util.ArrayList;

public class Tuple implements Cell
{
    private final static ArrayList<Cell> EMPTY_TUPLE = new ArrayList<Cell>(0);

    private final ArrayList<Cell> tuple;

    public Tuple()
    {
        this.tuple = EMPTY_TUPLE;
    }

    public boolean isAtom()
    {
        return false;
    }

    public boolean isTuple()
    {
        return true;
    }

    public int size()
    {
        return tuple.size();
    }

    public void accept(CellVisitor visitor)
    {
        visitor.visitTuple(this);
    }

    public Cell get(TupleIndex index)
    {
        return null;
    }

    public Node getNode(TupleIndex index)
    {
        return null;
    }

    public Node getNode()
    {
        return null;
    }

    public Tuple getTuple()
    {
        return this;
    }

}
