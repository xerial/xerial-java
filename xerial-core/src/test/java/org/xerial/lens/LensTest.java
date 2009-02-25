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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

    @Test
    public void testTranslateSilk()
    {}

    static class GeneTableOneToMany
    {
        @OneToMany(key = "coordinate", value = "gene")
        public Map<Coordinate, List<GeneSequence>> sequenceTable;
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
        private Map<Coordinate, List<GeneSequence>> sequenceTable;

        @OneToMany(key = "coordinate", value = "gene")
        public void add(Coordinate coordinate, GeneSequence gene)
        {
            List<GeneSequence> geneList = sequenceTable.get(coordinate);
            if (geneList == null)
            {
                geneList = new ArrayList<GeneSequence>();
                sequenceTable.put(coordinate, geneList);
            }
            geneList.add(gene);
        }
    }

    static class GeneTableOneToOne
    {
        @OneToMany(key = "coordinate", value = "gene")
        public List<Pair<Coordinate, GeneSequence>> geneList;
    }

    static class GeneTableOneToOneWithAdder
    {
        public List<Pair<Coordinate, GeneSequence>> geneList;

        @OneToMany(key = "coordinate", value = "gene")
        public void add(Coordinate coordinate, GeneSequence gene)
        {
            geneList.add(Pair.newPair(coordinate, gene));
        }
    }

    static class GeneSequence
    {
        private String name;
        private long start;
        private String strand;
        private String sequence;
    }

    @Test
    public void testMapping() throws Exception
    {
        Coordinate c = Lens.translateSilk(FileResource.find(SilkUtilTest.class, "sequence.silk"), Coordinate.class);
        _logger.info(c);
        assertEquals("utgb", c.group);
        assertEquals("human", c.species);
        assertEquals("hg18", c.revision);
        assertEquals("chr1", c.name);

    }
}
