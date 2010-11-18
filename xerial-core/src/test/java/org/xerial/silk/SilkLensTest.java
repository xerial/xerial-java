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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.xerial.lens.Coordinate;
import org.xerial.lens.Lens;
import org.xerial.util.FileResource;
import org.xerial.util.ObjectHandler;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.BeanUtilTest;
import org.xerial.util.log.Logger;

public class SilkLensTest {

    private static Logger _logger = Logger.getLogger(SilkLensTest.class);

    public static class ReferenceSeq {
        long start;
        String name;
        String strand;
        String sequence;
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
            return String.format("name=%s, start=%d, strand=%s, sequence=%s\nread:\n%s", name,
                    start, strand, sequence, StringUtil.join(reads, "\n"));
        }
    }

    public static class Read {
        String name;
        long start;
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
            return String.format("name=%s, start=%s, strand=%s, QV=%s, sequence=%s", name, start,
                    strand, QV, sequence);
        }

    }

    public static class ReadSet {
        Coordinate coord;
        List<ReferenceSeq> references = new ArrayList<ReferenceSeq>();

        public void addCoordinate(Coordinate coord) {
            this.coord = coord;
        }

        public void addReference(ReferenceSeq reference) {
            references.add(reference);
        }

        @Override
        public String toString() {
            return String.format("coordinate: %s\nreference:\n%s", coord,
                    StringUtil.join(references, "\n"));
        }
    }

    @Test
    public void testSilkBean() throws Exception {
        ReadSet r = SilkUtil.createSilkBean(ReadSet.class,
                FileResource.find(BeanUtilTest.class, "readset.silk"));
        _logger.debug(r.toString());
    }

    public static class Sequence {
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

    public static class SAMEntry {
        //schema record(qname, flag, rname, start, end, mapq, cigar, mrnm, mpos, isize, seq, qual, tag*)
        public String qname;
        public int flag;
        public String rname;
        public int start;
        public int end;
        public int mapq;
        public String cigar;
        public String mrnm; // mate reference name
        public int iSize;
        public String seq;
        public String qual;
        public HashMap<String, Object> tag;

    }

    public static class Handler<SAMEntry> implements ObjectHandler<SAMEntry> {

        public boolean isInitialized = false;
        public boolean isFinished = false;
        public int count = 0;

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
        SilkLens.findFromSilk(FileResource.open(Lens.class, "sam-sample.silk"), "record",
                SAMEntry.class, h);

        assertTrue(h.isInitialized);
        assertTrue(h.isFinished);

    }
}
