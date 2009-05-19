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
// ObjectMapperTest.java
// Since: May 19, 2009 1:33:50 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.silk.SilkWalker;
import org.xerial.util.FileResource;

public class ObjectMapperTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    public static class CoordinateData
    {
        public final String name;
        public final String species;

        public CoordinateData(String name, String species)
        {
            this.name = name;
            this.species = species;
        }

    }

    public static class GeneData
    {
        public final String name;
        public final long start;
        public final long end;
        public final String strand;

        public GeneData(String name, long start, long end, String strand)
        {
            this.name = name;
            this.start = start;
            this.end = end;
            this.strand = strand;
        }
    }

    public static class GeneDB
    {
        public final String name = null;

        public void addCoordinate_Gene(CoordinateData c, GeneData g)
        {}
    }

    @Test
    public void map() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        GeneDB gdb = mapper.map(GeneDB.class, new SilkWalker(FileResource.find(ObjectMapperTest.class, "gene.silk")));

    }
}
