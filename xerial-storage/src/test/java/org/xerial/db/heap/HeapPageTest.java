/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// HeapPageTest.java
// Since: Sep 20, 2007 1:40:45 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.heap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.db.AbstractTuple;
import org.xerial.db.Relation;
import org.xerial.db.Tuple;
import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;

public class HeapPageTest
{
    HeapPage heapPage;

    class SampleTuple extends AbstractTuple
    {

        public SampleTuple(Relation relation)
        {
            super(relation);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Object getValue(int relationIndex)
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setValue(int relationIndex, Object value)
        {
        // TODO Auto-generated method stub

        }

        public int getByteSize()
        {
            // TODO Auto-generated method stub
            return 0;
        }

        public int load(BufferReader reader)
        {
            // TODO Auto-generated method stub
            return 0;
        }

        public int save(BufferWriter writer)
        {
            // TODO Auto-generated method stub
            return 0;
        }
    }

    @Before
    public void setUp() throws Exception
    {
        heapPage = new HeapPage(1024);
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testGetHeaderSize()
    {
        assertTrue(heapPage.getHeaderSize() < 1024);

    }

    @Test
    public void testAppend()
    {
        
    }

    @Test
    public void testSortTuples()
    {
        //heapPage.sortTuples(comparator)
    }

    @Test
    public void testLoadFrom()
    {
        //fail("Not yet implemented");
    }

    @Test
    public void testSaveTo()
    {
        //fail("Not yet implemented");
    }

}
