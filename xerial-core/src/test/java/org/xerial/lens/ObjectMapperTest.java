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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.json.JSONLens;
import org.xerial.lens.LensTest.Gene;
import org.xerial.silk.SilkLens;
import org.xerial.silk.SilkParser;
import org.xerial.util.FileResource;
import org.xerial.util.ObjectHandlerBase;
import org.xerial.util.log.Logger;

public class ObjectMapperTest {
    private static Logger _logger = Logger.getLogger(ObjectMapperTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public static class CoordinateData {
        public String group;
        public String name;
        public String species;
        public String revision;

        @Override
        public String toString() {
            return String.format("group=%s, name=%s, species=%s, revision=%s", group, name,
                    species, revision);
        }

    }

    // query: (gene, name, start, end, strand)
    public static class GeneData {
        public final int id;
        public final String name;
        public final long start;
        public final long end;
        public final String strand;

        private StringBuilder sequence = new StringBuilder();

        public GeneData(int id, String name, long start, long end, String strand) {
            this.id = id;
            this.name = name;
            this.start = start;
            this.end = end;
            this.strand = strand;
        }

        public void appendSequence(String seq) {
            sequence.append(seq);
        }

        @Override
        public String toString() {
            return String.format("id=%d, name=%s, start=%s, end=%s, strand=%s, sequence=%s", id,
                    name, start, end, strand, sequence.toString());
        }
    }

    public static class GeneDB {
        public final String description;

        public GeneDB(String description) {
            this.description = description;
        }

        public void addCoordinate_Gene(CoordinateData c, GeneData g) {
            _logger.debug(String.format("c(%s), g(%s)", c, g));
        }

        public void addCoordinate(CoordinateData c) {
            _logger.debug(c);
        }

        public void addGene(GeneData g) {
            _logger.debug(g);
        }

    }

    @Test
    public void map() throws Exception {
        ObjectMapper mapper = new ObjectMapper(GeneDB.class);
        GeneDB gdb = mapper.map(GeneDB.class,
                new SilkParser(FileResource.find(ObjectMapperTest.class, "gene.silk")));

        assertEquals("gene data", gdb.description);
    }

    public static enum MARK {
        SPADE, HEART, CLOVER, DIAMOND
    }

    public static class EnumData {
        public List<MARK> mark;
    }

    @Test
    public void enumBind() throws Exception {
        EnumData ret = SilkLens.loadSilk(EnumData.class,
                FileResource.find(ObjectMapperTest.class, "enum.silk"));
        assertEquals(6, ret.mark.size());

    }

    public static class Read {
        public long viewstart;
        public long viewend;
    }

    @Test
    public void primitiveTypeBind() throws Exception {
        Read r = SilkLens.loadSilk(Read.class,
                FileResource.find(ObjectMapperTest.class, "long.silk"));
        assertEquals(1721L, r.viewstart);
        assertEquals(2871L, r.viewend);
    }

    public static class MyGene extends Gene {

    }

    public static class Rename {
        ArrayList<MyGene> genes = new ArrayList<MyGene>();

        public void addCoordinate_Gene(Coordinate c, MyGene g) {
            genes.add(g);
        }

    }

    @Test
    public void rename() throws Exception {
        Rename r = SilkLens.loadSilk(Rename.class,
                FileResource.find(ObjectMapperTest.class, "gene.silk"));
        assertEquals(2, r.genes.size());

    }

    public static class PropReader {
        Properties prop = new Properties();

        public void put(String key, String value) {
            prop.put(key, value);
        }
    }

    @Test
    public void property() throws Exception {
        PropReader p = SilkLens.loadSilk(PropReader.class,
                FileResource.open(ObjectMapperTest.class, "property.silk"));

        assertEquals(2, p.prop.size());
        assertEquals("hello", p.prop.get("db.name"));
        assertEquals("sqlite", p.prop.get("db.type"));
    }

    public static class PropField {
        public Properties _ = new Properties();
    }

    @Test
    public void propFieldTest() throws Exception {

        PropField p = SilkLens.loadSilk(PropField.class,
                FileResource.open(ObjectMapperTest.class, "property.silk"));

        _logger.info(SilkLens.toSilk(p));

        assertEquals(2, p._.size());
        assertEquals("hello", p._.get("db.name"));
        assertEquals("sqlite", p._.get("db.type"));

    }

    @Test
    public void propFieldOfMultiLinesTest() throws Exception {

        PropField p = SilkLens.loadSilk(PropField.class,
                FileResource.open(ObjectMapperTest.class, "property2.silk"));

        _logger.info(SilkLens.toSilk(p));

        assertEquals(1, p._.size());
        assertTrue(p._.containsKey("sequenceList"));
    }

    public static class TrackList {
        public Track track;

        public static class Track {
            public String id;
            public Properties _ = new Properties();
        }
    }

    @Test
    public void propFiledOFMultiLinesInNestedNode() throws Exception {
        TrackList l = SilkLens.loadSilk(TrackList.class,
                FileResource.find(ObjectMapperTest.class, "nested-property.silk"));

        assertNotNull(l.track);
        assertEquals("t1", l.track.id);
        assertTrue(!l.track._.isEmpty());
        assertTrue(l.track._.containsKey("sequenceList"));
        assertEquals("ACCTTTTG", l.track._.getProperty("sequenceList"));
    }

    public static class MapField {
        public Map<Integer, String> id_name;
    }

    @Test
    public void mapPutter() throws Exception {
        MapField m = SilkLens.loadSilk(MapField.class,
                FileResource.open(ObjectMapperTest.class, "map.silk"));
        assertNotNull(m.id_name);
        assertEquals(2, m.id_name.size());
        String n1 = m.id_name.get(1);
        String n2 = m.id_name.get(2);
        assertEquals("leo", n1);
        assertEquals("yui", n2);
    }

    public static class Person {
        public int id;
        public String name;

        @Override
        public String toString() {
            return JSONLens.toJSON(this);
        }
    }

    public static class ClassRoom {
        public String name;

        @Override
        public String toString() {
            return JSONLens.toJSON(this);
        }
    }

    public static class ComplexMapField {
        public Map<Person, ClassRoom> classes;
    }

    @Test
    public void complexMapField() throws Exception {
        ComplexMapField m = SilkLens.loadSilk(ComplexMapField.class,
                FileResource.open(ObjectMapperTest.class, "map2.silk"));
        assertEquals(2, m.classes.size());

        _logger.debug(JSONLens.toJSON(m.classes));

    }

    static class FindHandler extends ObjectHandlerBase<Person> {

        public void handle(Person input) throws Exception {
            _logger.info("find: person " + input);
        }

    }

    @Test
    public void buildFindQuery() throws Exception {

        ObjectMapper mapper = new ObjectMapper(Person.class, "person");
        _logger.info(mapper.qs);

    }

    @Test
    public void find() throws Exception {
        SilkLens.findFromSilk(FileResource.find(ObjectMapperTest.class, "map2.silk"), "person",
                Person.class, new FindHandler());

    }

    public static class SAMEntry {
        //schema record(qname, flag, rname, start, end, mapq, cigar, mrnm, mpos, isize, seq, qual, tag*)
        public String qname;
        public int flag;
        public String rname;
        public int start;
        public int end;
        public int mapq;
        public String cigar;
        public String mrnm; // mate reference nameh
        public int iSize;
        public String seq;
        public String qual;
        public HashMap<String, Object> tag;

    }

    @Test
    public void sam() throws Exception {

        SilkLens.findFromSilk(FileResource.find(ObjectMapperTest.class, "sam-sample.silk"),
                "record", SAMEntry.class, new ObjectHandlerBase<SAMEntry>() {
                    public void handle(SAMEntry input) throws Exception {
                        _logger.debug(SilkLens.toSilk(input));
                        for (String each : new String[] { "Nm", "RG", "H1", "MF", "H0" })
                            assertTrue(input.tag.containsKey(each));
                        if (input.qname.equals("read_28701_28881_323b")) {}
                    }
                });

    }

}
