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
// XerialJ
//
// TupleList.java
// Since: Sep 1, 2008 10:48:22 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import java.util.ArrayList;

/**
 * A list of tuples
 * 
 * @author leo
 * 
 */
public class TupleList extends ArrayList<Tuple> implements TupleContainer
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int capacity = 8 * 1024; // 8K capacity in default
    private int currentTupleSizeTotal = 0;

    public TupleList()
    {

    }

    @Override
    public boolean add(Tuple tuple)
    {
        int tupleByteSize = tuple.getByteSize();
        if (!hasCapacityFor(tuple))
            throw new DBError(DBErrorCode.ExceedsTheCapacity, "exceeds the container capacity");

        capacity -= tupleByteSize;
        return super.add(tuple);
    }

    public boolean hasCapacityFor(Tuple tuple)
    {
        return currentTupleSizeTotal + tuple.getByteSize() < capacity;
    }

}
