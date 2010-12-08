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
// ExternalMergeSortTest.java
// Since: Sep 1, 2008 11:27:04 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;

public class ExternalMergeSortTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    class IntOnlyTuple implements Tuple
    {
        int value;

        public IntOnlyTuple(int value)
        {
            this.value = value;
        }

        public int getByteSize()
        {
            return 4;
        }

        public Object getValue(int columnIndex)
        {
            if (columnIndex != 0)
                throw new DBError(DBErrorCode.OutOfIndex);
            return value;
        }

        public int load(BufferReader reader)
        {
            value = reader.readInt();
            return 4;
        }

        public int save(BufferWriter writer)
        {
            writer.writeInt(value);
            return 4;
        }

        public void setValue(int columnIndex, Object value)
        {
            throw new DBError(DBErrorCode.NotSupported);
        }

    }

    class MyTupleComparaotr implements Comparator<Tuple>
    {

        public int compare(Tuple o1, Tuple o2)
        {
            return 0;
        }

    }

    @Ignore
    @Test
    public void mergeSortTest()
    {
        int[] input = new int[] { 3, 4, 6, 2, 9, 4, 8, 7, 5, 6, 3, 1, 2 };
        int[] result = new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 9 };

        // prepare input set
        ArrayList<Tuple> inputTupleList = new ArrayList<Tuple>();
        for (int e : input)
            inputTupleList.add(new IntOnlyTuple(e));

        ArrayList<Tuple> outputList = new ArrayList<Tuple>();
        ExternalMergeSort sorter = new ExternalMergeSort();
        Comparator<Tuple> comparator = new PrimaryKeyComparator();
        sorter.mergeSort(inputTupleList, comparator, outputList);

        // assertion
        assertEquals(result.length, outputList.size());
        for (int i = 0; i < result.length; i++)
        {
            Tuple outputTuple = outputList.get(i);
            assertEquals(0, comparator.compare(outputTuple, new IntOnlyTuple(result[i])));
        }
    }
}
