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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkUtilTest;
import org.xerial.util.FileResource;
import org.xerial.util.Pair;
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

    static class GeneTableOneToMany
    {
        public String trackName;
        public Map<Coordinate, List<Gene>> sequenceTable;
    }

    /**
     * Example of showing that adder with two arguments corresponds to a
     * Map<Key, Collection<Value>> parameter.
     * 
     * @author leo
     * 
     */
    static class GeneTableWithMapAdder
    {
        private Map<Coordinate, List<Gene>> sequenceTable;

        public void add(@Name("coordinate") Coordinate coordinate, @Name("gene") Gene gene)
        {
            List<Gene> geneList = sequenceTable.get(coordinate);
            if (geneList == null)
            {
                geneList = new ArrayList<Gene>();
                sequenceTable.put(coordinate, geneList);
            }
            geneList.add(gene);
        }
    }

    static class GeneTableOneToOne
    {
        public List<Pair<Coordinate, Gene>> geneList;
    }

    static class GeneTableOneToOneWithAdder
    {
        public List<Pair<Coordinate, Gene>> geneList;

        public void add(@Name(aliases = { "coordinate" }) Coordinate coordinate, @Name("gene") Gene gene)
        {
            geneList.add(Pair.newPair(coordinate, gene));
        }
    }

    static class Gene
    {
        private String name;
        private long start;
        private String strand;
        private String sequence;
    }

    @Ignore
    @Test
    public void testTranslateSilk() throws IOException, XerialException
    {
        GeneTableOneToMany g = Lens.translateSilk(FileResource.find(LensTest.class, "../silk/sequence.silk"),
                GeneTableOneToMany.class);

        assertNotNull(g);
        assertEquals(2, g.sequenceTable.size());

    }

    @Ignore
    @Test
    public void testMapping() throws Exception
    {
        Coordinate c = Lens.translateSilk(FileResource.find(SilkUtilTest.class, "../silk/sequence.silk"),
                Coordinate.class);
        _logger.info(c);
        assertNotNull(c);
        assertEquals("utgb", c.group);
        assertEquals("human", c.species);
        assertEquals("hg18", c.revision);
        assertEquals("chr1", c.name);

    }
}
