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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.LensTest.Gene;
import org.xerial.silk.SilkParser;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class ObjectMapperTest
{
    private static Logger _logger = Logger.getLogger(ObjectMapperTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    public static class CoordinateData
    {
        public String group;
        public String name;
        public String species;
        public String revision;

        @Override
        public String toString()
        {
            return String.format("group=%s, name=%s, species=%s, revision=%s", group, name, species, revision);
        }

    }

    // query: (gene, name, start, end, strand)
    public static class GeneData
    {
        public final int id;
        public final String name;
        public final long start;
        public final long end;
        public final String strand;

        private StringBuilder sequence = new StringBuilder();

        public GeneData(int id, String name, long start, long end, String strand)
        {
            this.id = id;
            this.name = name;
            this.start = start;
            this.end = end;
            this.strand = strand;
        }

        public void appendSequence(String seq)
        {
            sequence.append(seq);
        }

        @Override
        public String toString()
        {
            return String.format("id=%d, name=%s, start=%s, end=%s, strand=%s, sequence=%s", id, name, start, end,
                    strand, sequence.toString());
        }
    }

    public static class GeneDB
    {
        public final String description;

        public GeneDB(String description)
        {
            this.description = description;
        }

        public void addCoordinate_Gene(CoordinateData c, GeneData g)
        {
            _logger.debug(String.format("c(%s), g(%s)", c, g));
        }

        public void addCoordinate(CoordinateData c)
        {
            _logger.debug(c);
        }

        public void addGene(GeneData g)
        {
            _logger.debug(g);
        }

    }

    @Test
    public void map() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper(GeneDB.class);
        GeneDB gdb = mapper.map(GeneDB.class, new SilkParser(FileResource.find(ObjectMapperTest.class, "gene.silk")));

        assertEquals("gene data", gdb.description);
    }

    public static enum MARK {
        SPADE, HEART, CLOVER, DIAMOND
    }

    public static class EnumData
    {
        public List<MARK> mark;
    }

    @Test
    public void enumBind() throws Exception
    {
        EnumData ret = Lens.loadSilk(EnumData.class, FileResource.find(ObjectMapperTest.class, "enum.silk"));
        assertEquals(6, ret.mark.size());

    }

    public static class Read
    {
        public long viewstart;
        public long viewend;
    }

    @Test
    public void primitiveTypeBind() throws Exception
    {
        Read r = Lens.loadSilk(Read.class, FileResource.find(ObjectMapperTest.class, "long.silk"));
        assertEquals(1721L, r.viewstart);
        assertEquals(2871L, r.viewend);
    }

    public static class MyGene extends Gene
    {

    }

    public static class Rename
    {
        ArrayList<MyGene> genes = new ArrayList<MyGene>();

        public void addCoordinate_Gene(Coordinate c, MyGene g)
        {
            genes.add(g);
        }

    }

    @Test
    public void rename() throws Exception
    {
        Rename r = Lens.loadSilk(Rename.class, FileResource.find(ObjectMapperTest.class, "gene.silk"));
        assertEquals(2, r.genes.size());

    }

}
