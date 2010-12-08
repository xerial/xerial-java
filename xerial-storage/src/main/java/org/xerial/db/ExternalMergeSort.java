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
// ExternalSort.java
// Since: Sep 1, 2008 9:55:04 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * External merge sort algorithm.
 * 
 * <pre>
 * while until no more tuple from the iterator
 *      TupleIterator -&gt; tuple -&gt; container 
 *      if(container is full)
 *          sort the tuples in the contaienr
 *          write the tuples to the disk
 *       
 * 
 * 
 * </pre>
 * 
 * @author leo
 * 
 */
public class ExternalMergeSort
{
    private int numBufferPage = 64;
    private BufferPool bufferPool;

    public ExternalMergeSort()
    {
        bufferPool = new BufferPool(numBufferPage);
    }

    public void sort(TupleIterator tupleIterator, TupleComparator tupleComparator)
    {
        TupleList tupleList = new TupleList();

        // retrieve all tuple from the iterator, then store these tuples into the buffer 
        for (; tupleIterator.hasNext();)
        {
            Tuple tuple = tupleIterator.next();

            if (tupleList.hasCapacityFor(tuple))
                tupleList.add(tuple);
            else
            {
                // When no more room for accepting the tuple, sort the inserted tuples
                Collections.sort(tupleList, tupleComparator);
                // Then, output them to the disk pages

            }
        }

    }

    public void mergeSort(Iterable<Tuple> input, Comparator<Tuple> comparator, List<Tuple> output)
    {

    }

    public void mergeSort(List<Iterable<Tuple>> inputIterartorList, Comparator<Tuple> comparator,
            List<Tuple> outputHolder)
    {

    }

}
