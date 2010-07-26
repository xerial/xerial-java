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

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.ObjectHandlerBase;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.NodeBase;
import org.xerial.lens.relation.Tuple;
import org.xerial.util.FileResource;
import org.xerial.util.HashedArrayList;
import org.xerial.util.StopWatch;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

public class LensTest {
    private static Logger _logger = Logger.getLogger(LensTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public static class GeneTable {
        private HashedArrayList<Coordinate, Gene> sequenceTable = new HashedArrayList<Coordinate, Gene>();

        public void add(Coordinate coordinate, Gene gene) {
            sequenceTable.put(coordinate, gene);
        }
    }

    static class Gene {
        private String name;
        private long start;
        private String strand;
        private StringBuilder sequence = new StringBuilder();

        public void appendSequence(String sequence) {}
    }

    @Test
    public void testTranslateSilk() throws IOException, XerialException {
        GeneTable g = Lens.loadSilk(GeneTable.class, FileResource.find(LensTest.class,
                "sequence.silk"));

        assertNotNull(g);
        assertEquals(2, g.sequenceTable.size());
        for (Coordinate each : g.sequenceTable.keySet()) {
            List<Gene> gl = g.sequenceTable.get(each);
            assertEquals(2, gl.size());
        }

    }

    @Ignore
    @Test
    public void testNestedScope() throws Exception {
        // TODO: Resolving nested scope even when the information of gene class is not available. 
        // -coordinate(name:chr1)
        //   -gene(name:gene1)
        // In the above example, two amoebas (coordinate, name:chr1), (coordinate, (gene), name:gene1) will be found.

        Coordinate c = Lens.loadSilk(Coordinate.class, FileResource.find(LensTest.class,
                "sequence.silk"));

        _logger.info(c);
        assertNotNull(c);
        assertEquals("utgb", c.group);
        assertEquals("human", c.species);
        assertEquals("hg18", c.revision);
        assertEquals("chr1", c.name);
    }

    @Test
    public void testBED() throws Exception {
        BEDQuery result = new BEDQuery("chr7", 1L, 1000000000L);
        Lens.loadSilk(result, FileResource.find(LensTest.class, "sample.bed.silk"));

        _logger.debug(StringUtil.join(result.geneList, "\n"));

        assertEquals("Item,RGB,Demo2", result.track.name);
        assertEquals("Item RGBdemonstration2", result.track.description);
        assertEquals(2, result.track.visibility);
        assertEquals("On", result.track.itemRgb);
        assertEquals(1, result.track.useScore);
        assertEquals("0,128,0", result.track.color);
        assertEquals("http://genome.ucsc.edu/goldenPath/help/clones.html#$$", result.track.url);
    }

    public static class Locus {
        public long start;
        public long end;

        public Locus() {}

        public Locus(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public boolean hasOverlap(Locus other) {
            return (this.start <= other.end) && (this.end >= other.start);
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", start, end);
        }
    }

    public static class CDS extends Locus {

    }

    public static class Exon extends Locus {

    }

    public static class BEDGene extends Locus {
        public String coordinate;
        public String name;
        public String color;
        public String strand;
        public List<CDS> cds;
        public List<Exon> exon;

        @Override
        public String toString() {
            return ObjectLens.toJSON(this);
        }
    }

    public static class BEDTrack {
        public String name;
        public String description;
        public String itemRgb;
        public int visibility;
        public String color;
        public int useScore;
        public String url;
    }

    public static class BEDQuery {
        private String coordinate;
        private Locus queryRange;
        private List<BEDGene> geneList = new ArrayList<BEDGene>();

        public BEDTrack track;

        public BEDQuery(String coordinate, long startOnGenome, long endOnGenome) {
            this.coordinate = coordinate;
            this.queryRange = new Locus(startOnGenome, endOnGenome);
        }

        public void addGene(BEDGene gene) {
            // where conditions
            if (coordinate.equals(gene.coordinate) && queryRange.hasOverlap(gene)) {
                // draw the gene on the canvas
                geneList.add(gene);
            }
        }
    }

    public static class DASFeature {
        public DASGFF gff;
        public Segment segment;

        @Override
        public String toString() {
            return ObjectLens.toJSON(this);
        }

    }

    public static class DASGFF {
        public String version;
        public String href;

    }

    public static class Segment {
        public String id;
        public long start;
        public long stop;
        public List<Feature> feature;
    }

    public static class Feature {
        public String id;
        public long start;
        public long end;

        public String score;
        public String orientation;

        public Method method;
        public FeatureType type;
        public Group group;
        public Target target;

    }

    public static class Target {
        public String id;
        public long start;
        public long stop;
    }

    public static class FeatureType {
        public String id;
        public String category;
        public String value;

    }

    public static class Group {
        public String id;
        public String type;
        public String label;
        public Link link;

    }

    public static class Link {
        public String href;
        public String value;
    }

    public static class Method {
        public String id;
        public String value;
    }

    /*
     * <pre>
    <SEGMENT id="13" start="1800000" stop="18100000"> 
    <FEATURE id="ENSE00001471274"> 
    <START>17957458</START> 
    <END>17957578</END> 
    <TYPE id="exon:coding:ensembl" category="transcription">exon:coding:ensembl</TYPE> 
    <METHOD id="ensembl">ensembl</METHOD> 
    <SCORE>-</SCORE> 
    <ORIENTATION>-</ORIENTATION> 
    <GROUP id="ENST00000342944" type="transcript:ensembl" label="ENST00000342944 (AL138715.11-201)"> 
      <LINK href="http://www.ensembl.org/Homo_sapiens/Transcript/Summary?t=ENST00000342944;db=core">TransView ENST00000342944</LINK> 
    </GROUP> 
    <TARGET id="ENST00000342944" start="1" stop="121" /> 
    </FEATURE> 
    </SEGMENT> 
    </pre>
     */
    @Test
    public void dasTest() throws Exception {
        DASFeature das = Lens.loadXML(DASFeature.class, FileResource
                .find(LensTest.class, "das.xml"));
        assertEquals(1, das.segment.feature.size());
        Feature f = das.segment.feature.get(0);
        _logger.debug(das);
        assertEquals("ENSE00001471274", f.id);
        assertEquals(17957458L, f.start);
        assertEquals(17957578L, f.end);
        assertEquals("-", f.score);
        assertEquals("-", f.orientation);
        Target t = f.target;
        assertEquals("ENST00000342944", t.id);
        assertEquals(1L, t.start);
        assertEquals(121L, t.stop);

    }

    public static class Text {
        public String value;
    }

    public static class TextQuery {
        public Text text;
    }

    @Test
    public void textData() throws Exception {
        TextQuery q = Lens
                .loadSilk(TextQuery.class, FileResource.find(LensTest.class, "text.silk"));
        assertNotNull(q.text);
        assertEquals("hello world", q.text.value);
    }

    public static class ArrayData {
        public List<String> list = new ArrayList<String>();
    }

    @Test
    public void toJSONTest() throws Exception {
        ArrayData d = new ArrayData();
        assertEquals("{\"list\":[]}", Lens.toJSON(d));
    }

    public static class MyGene {
        public String name;
        public long start;
        public String link;
        public String sequence;
    }

    public static class MyGeneQuery {
        private List<MyGene> geneList = new ArrayList<MyGene>();

        public void addGene_Coordinate(MyGene gene, Chr c) {
            if (c.name.equals("chr1"))
                geneList.add(gene);
        }

        public List<MyGene> getGeneList() {
            return geneList;
        }
    }

    public static class Chr {
        public String name;
    }

    @Test
    public void testLens() throws Exception {

        MyGeneQuery result = Lens.loadSilk(MyGeneQuery.class, FileResource.open(LensTest.class,
                "sequence.silk"));

        _logger.debug(Lens.toJSON(result));
    }

    @Test
    public void testFind() throws Exception {
        Lens.findFromSilk(FileResource.find(LensTest.class, "sequence.silk"), "gene", MyGene.class,
                new ObjectHandlerBase<MyGene>() {
                    public void handle(MyGene input) throws Exception {
                        _logger.info(Lens.toJSON(input));
                    }
                });
    }

    public static class TupleNode extends NodeBase<TupleNode> {
        public final int id;
        public final String name;

        public TupleNode(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    public void testToSilkTuple() throws Exception {
        Tuple<TupleNode> t = new Tuple<TupleNode>();
        t.add(new TupleNode(1, "A"));
        t.add(new TupleNode(2, "B"));

        String s = Lens.toSilk(t);
        _logger.debug(s);
    }

    public static class Record {
        public String name;
        public String description;
        public long length;
        public long offset;
    }

    @Test
    public void readingSilkIndexes() throws Exception {
        StopWatch sw = new StopWatch();
        Lens.findFromSilk(FileResource.find(LensTest.class, "index.silk"), "sequence",
                Record.class, new ObjectHandlerBase<Record>() {
                    public void handle(Record input) throws Exception {

                    }
                });
        _logger.info("index reading time: " + sw.getElapsedTime());
    }

}
