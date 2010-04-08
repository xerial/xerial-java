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
// Xerial Silk Weaver Project 
//
// SecondAlignment.java
// Since: 2010/03/16 9:21:20
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.bio.bisulfite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.Properties;

import org.utgenome.UTGBException;
import org.utgenome.format.fasta.CompactFASTA;
import org.utgenome.format.fasta.GenomeSequence;
import org.utgenome.format.sam.CIGAR;
import org.utgenome.format.sam.SAM2SilkReader;
import org.utgenome.format.sam.SAMEntry;
import org.utgenome.format.sam.CIGAR.Type;
import org.utgenome.util.aligner.SmithWatermanAligner;
import org.utgenome.util.aligner.SmithWatermanAligner.Alignment;
import org.utgenome.util.aligner.SmithWatermanAligner.Config;
import org.xerial.core.XerialErrorCode;
import org.xerial.lens.Lens;
import org.xerial.lens.ObjectHandler;
import org.xerial.silk.SilkWriter;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.Usage;
import org.xerial.weaver.SilkWeaverException;
import org.xerial.weaver.core.cui.SilkWeaverCommand;
import org.xerial.weaver.core.cui.SilkWeaverModule;

/**
 * @author leo
 * 
 */
@Usage(command = "sw [option]", description = "perform the second alignment from an input SAM with SmithWaterman")
public class SecondAlignment implements SilkWeaverCommand {

    private static Logger _logger = Logger.getLogger(SecondAlignment.class);

    @Argument(index = 0, name = "(ref pac)", required = true)
    private String pacReferenceSequencePrefix;

    @Argument(index = 1, name = "(query pac)", required = true)
    private String pacQuerySequencePrefix;

    @Argument(index = 2, name = "(sam)", required = true)
    private String inputSAM;

    private Config config = new SmithWatermanAligner.Config();

    @Option(symbol = "m", longName = "mismatch", description = "mismatch penalty")
    private int mismatchPenalty = config.MISMATCH_PENALTY;
    @Option(symbol = "g", longName = "gap", description = "gap open penalty")
    private int gapOpenPenalty = 1;

    @Option(longName = "memory", description = "load the entire sequence into memory")
    private boolean loadIntoMemory = false;

    private CompactFASTA rseq;
    private CompactFASTA qseq;

    private SilkWriter out;

    public void execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {

        out = new SilkWriter(new BufferedOutputStream(System.out));

        _logger.info("Smith-Waterman Alignment from an input SAM file");

        if (pacReferenceSequencePrefix == null)
            throw new SilkWeaverException(XerialErrorCode.MISSING_ARGUMENT,
                    "no input pac file for reference sequence");

        if (pacQuerySequencePrefix == null)
            throw new SilkWeaverException(XerialErrorCode.MISSING_ARGUMENT,
                    "no input pac file for query sequence");

        if (inputSAM == null)
            throw new SilkWeaverException(XerialErrorCode.MISSING_ARGUMENT, "no input SAM file");

        _logger.debug("input file: " + inputSAM);
        _logger.debug("mismatch penalty: " + mismatchPenalty);
        _logger.debug("gap open penalty: " + gapOpenPenalty);
        config.MISMATCH_PENALTY = mismatchPenalty;
        config.GAPOPEN_PENALTY = gapOpenPenalty;
        config.BSS_ALIGNMENT = true; // the behavior of SW algorithm

        out.leaf("description", "Smith-Waterman Alignment for BSS");
        out.leaf("reference", pacReferenceSequencePrefix);
        out.leaf("query", pacQuerySequencePrefix);
        out.leaf("input SAM:", inputSAM);
        out.leaf("config", config);
        out.flush();

        if (loadIntoMemory)
            _logger.info("loading sequences into memory");

        // load genome sequences (.pac)
        _logger.info("loading reference sequence indexes...");
        rseq = loadIntoMemory ? CompactFASTA.loadIntoMemory(pacReferenceSequencePrefix)
                : new CompactFASTA(pacReferenceSequencePrefix);
        _logger.info("loading query sequence indexes...");
        qseq = loadIntoMemory ? CompactFASTA.loadIntoMemory(pacQuerySequencePrefix)
                : new CompactFASTA(pacQuerySequencePrefix);

        _logger.info("started the alignment process");
        SAM2SilkReader samReader = new SAM2SilkReader(new BufferedInputStream(new FileInputStream(
                inputSAM)));
        Lens.findFromSilk(samReader, "record", SAMEntry.class, new ObjectHandler<SAMEntry>() {
            public void handle(SAMEntry input) throws Exception {
                CIGAR cigar = new CIGAR(input.cigar);
                int start = input.start;
                int end = input.end;

                // extend the alignment region for covering soft/hard clipped sequences 
                for (int i = 0; i < cigar.size(); ++i) {
                    CIGAR.Element each = cigar.get(i);
                    if (each.type == Type.SoftClip || each.type == Type.HardClip)
                        start -= each.length;
                    else
                        break;
                }
                for (int i = cigar.size() - 1; i >= 0; --i) {
                    CIGAR.Element each = cigar.get(i);
                    if (each.type == Type.SoftClip || each.type == Type.HardClip)
                        end += each.length;
                    else
                        break;
                }

                final int PADDING = 5;
                start -= PADDING;
                end += PADDING;

                if (start < 0)
                    start = 0;

                if (_logger.isDebugEnabled()) {
                    _logger.debug(String.format("read: %s, target: %s:%d-%d", input.qname,
                            input.rname, start, end));
                }

                GenomeSequence refSequence = rseq.getSequence(input.rname, start, end);
                // we have to read the original sequence from the database, since C->T conversion is applied 
                GenomeSequence querySequence = qseq.getSequence(input.qname);

                //_logger.info("ref seq: " + refSequence);
                //_logger.info("query seq: " + querySequence);

                SmithWatermanAligner sw = new SmithWatermanAligner(config);
                Alignment alignment = sw.align(refSequence, querySequence);
                reportAlignment(alignment, input, input.rname, start, end);

            }
        });

        out.endDocument();

        rseq.close();
        qseq.close();
        out.close();
    }

    public static class AlignmentResult {

        public String qName;
        public String rName;

        public int refStart;
        public int refEnd;

        public int alnStart;
        public int alnEnd;
        public int alnLength = 0;

        public String cigar;
        public String rseq;
        public String diff;
        public String qseq;

        public int bwaScore;
        public int swScore;

        public int bwaFlag;
        public Properties tag;

        public AlignmentResult(Alignment aln, SAMEntry entry, int refStart, int refEnd) {
            this.qName = entry.qname;
            this.rName = entry.rname;
            this.refStart = refStart;
            this.refEnd = refEnd;
            this.alnStart = refStart + aln.pos;
            try {
                CIGAR c = new CIGAR(aln.cigar);
                for (int i = 0; i < c.size(); ++i) {
                    CIGAR.Element e = c.get(i);
                    switch (e.type) {
                    case SoftClip:
                    case HardClip:
                        break;
                    case Deletions:
                    case Insertions:
                    case Matches:
                    case Padding:
                    case SkippedRegion:
                        this.alnLength += e.length;
                        break;
                    }
                }
            }
            catch (UTGBException e) {
                _logger.warn(String.format("invalid cigar sequence for query %s : %s", entry.qname,
                        aln.cigar));
            }
            this.alnEnd = alnStart + alnLength;

            this.cigar = aln.cigar;
            this.rseq = aln.rseq;
            this.qseq = aln.qseq;
            // take diff
            this.diff = takeDiff(this.rseq, this.qseq);

            this.swScore = aln.score;
            this.bwaScore = entry.mapq;
            this.bwaFlag = entry.flag;
            this.tag = entry.tag;
        }

        public static String takeDiff(String ref, String query) {
            StringBuilder diff = new StringBuilder();
            int index = 0;
            while (index < ref.length() || index < query.length()) {
                char r = index < ref.length() ? ref.charAt(index) : ' ';
                char q = index < query.length() ? query.charAt(index) : ' ';

                if (r == ' ' || q == ' ')
                    diff.append(' ');
                else if (r == '-' || q == '-')
                    diff.append('-');
                else if (r == q) {
                    if (r == 'C')
                        diff.append('C');
                    else if (r == 'G')
                        diff.append('G');
                    else
                        diff.append('|');
                }
                else {
                    if (r == 'C') {
                        if (q == 'T')
                            diff.append(q);
                        else
                            diff.append(Character.isLowerCase(q) ? ' ' : 'X');
                    }
                    else if (r == 'G') {
                        if (q == 'A')
                            diff.append(q);
                        else
                            diff.append(Character.isLowerCase(q) ? ' ' : 'X');
                    }
                    else
                        diff.append(Character.isLowerCase(q) ? ' ' : 'X');
                }

                index++;
            }

            return diff.toString();
        }
    }

    public void reportAlignment(Alignment alignment, SAMEntry entry, String chr, int start, int end) {
        AlignmentResult alignmentResult = new AlignmentResult(alignment, entry, start, end);
        out.leaf("result", alignmentResult);
    }

    public String getCommandName() {
        return "sw";
    }

    public String getOneLineDescription() {
        return "perform SmithWaterman alignment";
    }

}
