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
// SilkArchiver.java
// Since: 2009/12/29 20:09:40
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.sica;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkEnv;
import org.xerial.silk.SilkEvent;
import org.xerial.silk.SilkLinePushParser;
import org.xerial.silk.impl.SilkLineLexer;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;

public class SilkArchiver {

    @Option(symbol = "h", longName = "help", description = "display help message")
    private boolean displayHelp = false;

    private OptionParser parser = new OptionParser(this);

    public static void main(String[] args) {

        new SilkArchiver().run(args);
    }

    public void run(String[] args) {
        try {
            parser.parse(args);

            if (displayHelp) {
                parser.printUsage();
                return;
            }

            // Configure Hadoop Job
            Configuration conf = new Configuration();
            Job job = new Job(conf, "silk archiver");

            job.setInputFormatClass(TextInputFormat.class);
            job.setMapperClass(SilkLineMapper.class);
            job.setCombinerClass(SilkEventReducer.class);
            job.setReducerClass(SilkEventReducer.class);
            job.setGroupingComparatorClass(BlockGroupingComparator.class);

        }
        catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

    /**
     * Define a pair of integers that are writable. They are serialized in a
     * byte comparable format.
     */
    public static class Block implements WritableComparable<Block> {
        private int first;
        private int second;

        public Block(long bytePosInFile) {
            final int blockSize = 512 * 1024 * 1024;
            this.first = (int) (bytePosInFile / blockSize);
            this.second = (int) (bytePosInFile % blockSize);
        }

        /**
         * Read the two integers. Encoded as: MIN_VALUE -> 0, 0 -> -MIN_VALUE,
         * MAX_VALUE-> -1
         */
        public void readFields(DataInput in) throws IOException {
            first = in.readInt() + Integer.MIN_VALUE;
            second = in.readInt() + Integer.MIN_VALUE;
        }

        public void write(DataOutput out) throws IOException {
            out.writeInt(first - Integer.MIN_VALUE);
            out.writeInt(second - Integer.MIN_VALUE);
        }

        @Override
        public int hashCode() {
            return first * 157 + second;
        }

        @Override
        public boolean equals(Object right) {
            if (right instanceof Block) {
                Block r = (Block) right;
                return r.first == first && r.second == second;
            }
            else {
                return false;
            }
        }

        /** A Comparator that compares serialized IntPair. */
        public static class Comparator extends WritableComparator {
            public Comparator() {
                super(Block.class);
            }

            public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
                return compareBytes(b1, s1, l1, b2, s2, l2);
            }
        }

        static { // register this comparator
            WritableComparator.define(Block.class, new Comparator());
        }

        public int compareTo(Block o) {
            if (first != o.first) {
                return first < o.first ? -1 : 1;
            }
            else if (second != o.second) {
                return second < o.second ? -1 : 1;
            }
            else {
                return 0;
            }
        }

    }

    public static class BlockGroupingComparator implements RawComparator<Block> {
        public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
            return WritableComparator.compareBytes(b1, s1, Integer.SIZE / 8, b2, s2,
                    Integer.SIZE / 8);
        }

        public int compare(Block o1, Block o2) {
            int l = o1.first;
            int r = o2.first;
            return l == r ? 0 : (l < r ? -1 : 1);
        }
    }

    public static class SilkLineMapper extends Mapper<LongWritable, Text, Block, SilkEvent> {
        protected void map(LongWritable bytePosInFile, Text line,
                Mapper<LongWritable, Text, Block, SilkEvent>.Context context) throws IOException,
                InterruptedException {

            SilkLineLexer lexer = new SilkLineLexer();
            try {
                SilkEvent e = SilkLinePushParser.parseLine(lexer, line.toString());
                context.write(new Block(bytePosInFile.get()), e);
            }
            catch (XerialException e) {
                e.printStackTrace();
            }

        };
    }

    public static class SilkEventReducer extends Reducer<Block, SilkEvent, Block, SilkEnv> {

        protected void reduce(Block block, java.lang.Iterable<SilkEvent> events,
                Reducer<Block, SilkEvent, Block, SilkEnv>.Context context) throws IOException,
                InterruptedException {

        };
    }

}
