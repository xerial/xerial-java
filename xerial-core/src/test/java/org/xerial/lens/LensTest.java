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
// LensTest.java
// Since: Feb 23, 2009 6:02:27 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkUtilTest;
import org.xerial.util.FileResource;
import org.xerial.util.HashedArrayList;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

public class LensTest
{
    private static Logger _logger = Logger.getLogger(LensTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    static class GeneTable
    {
        private HashedArrayList<Coordinate, Gene> sequenceTable = new HashedArrayList<Coordinate, Gene>();

        public void add(Coordinate coordinate, Gene gene)
        {
            sequenceTable.put(coordinate, gene);
        }
    }

    static class Gene
    {
        private String name;
        private long start;
        private String strand;
        private StringBuilder sequence = new StringBuilder();

        public void appendSequence(String sequence)
        {}
    }

    @Test
    public void testTranslateSilk() throws IOException, XerialException
    {
        GeneTable g = Lens.loadSilk(GeneTable.class, FileResource.find(LensTest.class, "sequence.silk"));

        assertNotNull(g);
        assertEquals(2, g.sequenceTable.size());
        for (Coordinate each : g.sequenceTable.keySet())
        {
            List<Gene> gl = g.sequenceTable.get(each);
            assertEquals(2, gl.size());
        }

    }

    @Ignore
    @Test
    public void testMapping() throws Exception
    {
        // TODO: How to resolve nested scope when the information of gene class is not available  
        // -coordinate(name:chr1)
        //   -gene(name:gene1)

        Coordinate c = Lens.loadSilk(Coordinate.class, FileResource.find(SilkUtilTest.class, "sequence.silk"));

        _logger.info(c);
        assertNotNull(c);
        assertEquals("utgb", c.group);
        assertEquals("human", c.species);
        assertEquals("hg18", c.revision);
        assertEquals("chr1", c.name);

    }

    @Test
    public void testBED() throws Exception
    {
        BEDQuery g = Lens.loadSilk(BEDQuery.class, FileResource.find(LensTest.class, "sample.bed.silk"));
        _logger.info(StringUtil.join(g.gene, "\n"));
    }

    public static class Locus
    {
        public long start;
        public long end;

        @Override
        public String toString()
        {
            return String.format("(%s, %s)", start, end);
        }
    }

    public static class CDS extends Locus
    {

    }

    public static class Exon extends Locus
    {

    }

    public static class BEDGene extends Locus
    {
        public String coordinate;
        public String name;
        public List<CDS> cds;
        public List<Exon> exon;

        @Override
        public String toString()
        {
            return String.format("%s %s (%s, %s), cds=%s, exon=%s", coordinate, name, start, end, cds, exon);
        }
    }

    public static class BEDQuery
    {
        public List<BEDGene> gene;
    }

}
