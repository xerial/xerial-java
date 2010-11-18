/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// SilkLensTest.java
// Since: 2010/11/18 16:10:44
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.json.JSONLens;
import org.xerial.lens.Coordinate;
import org.xerial.lens.Lens;
import org.xerial.lens.LensTest;
import org.xerial.lens.LensTest.MyGene;
import org.xerial.lens.ObjectLens;
import org.xerial.lens.ObjectLensTest;
import org.xerial.lens.relation.NodeBase;
import org.xerial.lens.relation.Tuple;
import org.xerial.util.FileResource;
import org.xerial.util.HashedArrayList;
import org.xerial.util.ObjectHandler;
import org.xerial.util.ObjectHandlerBase;
import org.xerial.util.StopWatch;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.BeanUtilTest;
import org.xerial.util.log.Logger;

public class SilkLensTest
{

    private static Logger _logger = Logger.getLogger(SilkLensTest.class);

    public static class ReferenceSeq
    {
        long       start;
        String     name;
        String     strand;
        String     sequence;
        List<Read> reads = new ArrayList<Read>();

        public void setStart(long start) {
            this.start = start;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStrand(String strand) {
            this.strand = strand;
        }

        public void setSequence(String sequence) {
            this.sequence = sequence;
        }

        public void addRead(Read read) {
            reads.add(read);
        }

        @Override
        public String toString() {
            return String.format("name=%s, start=%d, strand=%s, sequence=%s\nread:\n%s", name, start, strand, sequence,
                    StringUtil.join(reads, "\n"));
        }
    }

    public static class Read
    {
        String name;
        long   start;
        String strand;
        String sequence;
        String QV;

        public void setName(String name) {
            this.name = name;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public void setStrand(String strand) {
            this.strand = strand;
        }

        public void setSequence(String sequence) {
            this.sequence = sequence;
        }

        public void setQV(String qv) {
            QV = qv;
        }

        @Override
        public String toString() {
            return String.format("name=%s, start=%s, strand=%s, QV=%s, sequence=%s", name, start, strand, QV, sequence);
        }

    }

    public static class ReadSet
    {
        Coordinate         coord;
        List<ReferenceSeq> references = new ArrayList<ReferenceSeq>();

        public void addCoordinate(Coordinate coord) {
            this.coord = coord;
        }

        public void addReference(ReferenceSeq reference) {
            references.add(reference);
        }

        @Override
        public String toString() {
            return String.format("coordinate: %s\nreference:\n%s", coord, StringUtil.join(references, "\n"));
        }
    }

    @Test
    public void testSilkBean() throws Exception {
        ReadSet r = SilkUtil.createSilkBean(ReadSet.class, FileResource.find(BeanUtilTest.class, "readset.silk"));
        _logger.debug(r.toString());
    }

    public static class Sequence
    {
        private StringBuilder buf = new StringBuilder();

        public void appendSeq(String sequence) {
            buf.append(sequence);
        }

        public String getSeq() {
            return buf.toString();
        }
    }

    @Test
    public void appenderTest() throws Exception {
        Sequence seq = new Sequence();
        SilkUtil.populateBeanWithSilk(seq, FileResource.find(BeanUtilTest.class, "seq.silk"));
        assertEquals("ABCDEFGHIJ", seq.getSeq());
    }

    public static class SAMEntry
    {
        //schema record(qname, flag, rname, start, end, mapq, cigar, mrnm, mpos, isize, seq, qual, tag*)
        public String                  qname;
        public int                     flag;
        public String                  rname;
        public int                     start;
        public int                     end;
        public int                     mapq;
        public String                  cigar;
        public String                  mrnm; // mate reference name
        public int                     iSize;
        public String                  seq;
        public String                  qual;
        public HashMap<String, Object> tag;

    }

    public static class Handler<SAMEntry> implements ObjectHandler<SAMEntry>
    {

        public boolean isInitialized = false;
        public boolean isFinished    = false;
        public int     count         = 0;

        @Override
        public void finish() throws Exception {
            if (count != 2)
                throw new Exception("finish phase must be invoked after reading all entries");

            isFinished = true;
        }

        @Override
        public void handle(SAMEntry input) throws Exception {
            count++;
        }

        @Override
        public void init() throws Exception {
            if (count != 0)
                throw new Exception("initialization must start before reading objects");

            isInitialized = true;
        }

    }

    @Test
    public void initTest() throws Exception {

        Handler<SAMEntry> h = new Handler<SAMEntry>();
        SilkLens.findFromSilk(FileResource.open(Lens.class, "sam-sample.silk"), "record", SAMEntry.class, h);

        assertTrue(h.isInitialized);
        assertTrue(h.isFinished);

    }

    public static class GeneTable
    {
        private HashedArrayList<Coordinate, Gene> sequenceTable = new HashedArrayList<Coordinate, Gene>();

        public void add(Coordinate coordinate, Gene gene) {
            sequenceTable.put(coordinate, gene);
        }
    }

    static class Gene
    {
        private String        name;
        private long          start;
        private String        strand;
        private StringBuilder sequence = new StringBuilder();

        public void appendSequence(String sequence) {}
    }

    @Test
    public void testTranslateSilk() throws IOException, XerialException {
        GeneTable g = SilkLens.loadSilk(GeneTable.class, FileResource.find(LensTest.class, "sequence.silk"));

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

        Coordinate c = SilkLens.loadSilk(Coordinate.class, FileResource.find(LensTest.class, "sequence.silk"));

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
        SilkLens.loadSilk(result, FileResource.find(LensTest.class, "sample.bed.silk"));

        _logger.debug(StringUtil.join(result.geneList, "\n"));

        assertEquals("Item,RGB,Demo2", result.track.name);
        assertEquals("Item RGBdemonstration2", result.track.description);
        assertEquals(2, result.track.visibility);
        assertEquals("On", result.track.itemRgb);
        assertEquals(1, result.track.useScore);
        assertEquals("0,128,0", result.track.color);
        assertEquals("http://genome.ucsc.edu/goldenPath/help/clones.html#$$", result.track.url);
    }

    public static class Locus
    {
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

    public static class CDS extends Locus
    {

    }

    public static class Exon extends Locus
    {

    }

    public static class BEDGene extends Locus
    {
        public String     coordinate;
        public String     name;
        public String     color;
        public String     strand;
        public List<CDS>  cds;
        public List<Exon> exon;

        @Override
        public String toString() {
            return JSONLens.toJSON(this);
        }
    }

    public static class BEDTrack
    {
        public String name;
        public String description;
        public String itemRgb;
        public int    visibility;
        public String color;
        public int    useScore;
        public String url;
    }

    public static class BEDQuery
    {
        private String        coordinate;
        private Locus         queryRange;
        private List<BEDGene> geneList = new ArrayList<BEDGene>();

        public BEDTrack       track;

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

    public static class Text
    {
        public String value;
    }

    public static class TextQuery
    {
        public Text text;
    }

    @Test
    public void textData() throws Exception {
        TextQuery q = SilkLens.loadSilk(TextQuery.class, FileResource.find(LensTest.class, "text.silk"));
        assertNotNull(q.text);
        assertEquals("hello world", q.text.value);
    }

    public static class PropTest
    {
        public Properties prop = new Properties();
    }

    @Test
    public void propertyGetter() throws Exception {

        PropTest p = new PropTest();
        ObjectLens lens = new ObjectLens(PropTest.class);
        lens.setParameter(p, "prop", "hello", "world");
        assertEquals("world", lens.getParameter(p, "prop", "hello"));

        String silk = SilkLens.toSilk(p);

        PropTest p2 = SilkLens.loadSilk(PropTest.class, new StringReader(silk));
        assertTrue(p2.prop.containsKey("hello"));
        assertEquals("world", p2.prop.getProperty("hello"));

    }

    @Ignore
    @Test
    public void longProp() throws Exception {
        PropTest p = SilkLens.loadSilk(PropTest.class, FileResource.open(ObjectLensTest.class, "longprop.silk"));
        assertTrue(p.prop.containsKey("sequenceList"));

        _logger.info(SilkLens.toSilk(p));

    }

    public static class MyGeneQuery
    {
        private List<MyGene> geneList = new ArrayList<MyGene>();

        public void addGene_Coordinate(MyGene gene, Chr c) {
            if (c.name.equals("chr1"))
                geneList.add(gene);
        }

        public List<MyGene> getGeneList() {
            return geneList;
        }
    }

    public static class Chr
    {
        public String name;
    }

    @Test
    public void testLens() throws Exception {

        MyGeneQuery result = SilkLens.loadSilk(MyGeneQuery.class, FileResource.open(LensTest.class, "sequence.silk"));

        _logger.debug(JSONLens.toJSON(result));
    }

    @Test
    public void testFind() throws Exception {
        SilkLens.findFromSilk(FileResource.find(LensTest.class, "sequence.silk"), "gene", MyGene.class,
                new ObjectHandlerBase<MyGene>() {
                    public void handle(MyGene input) throws Exception {
                        _logger.info(JSONLens.toJSON(input));
                    }
                });
    }

    public static class TupleNode extends NodeBase<TupleNode>
    {
        public final int    id;
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

        String s = SilkLens.toSilk(t);
        _logger.debug(s);
    }

    public static class Record
    {
        public String name;
        public String description;
        public long   length;
        public long   offset;
    }

    @Test
    public void readingSilkIndexes() throws Exception {
        StopWatch sw = new StopWatch();
        SilkLens.findFromSilk(FileResource.find(LensTest.class, "index.silk"), "sequence", Record.class,
                new ObjectHandlerBase<Record>() {
                    public void handle(Record input) throws Exception {

                    }
                });
        _logger.info("index reading time: " + sw.getElapsedTime());
    }

}
