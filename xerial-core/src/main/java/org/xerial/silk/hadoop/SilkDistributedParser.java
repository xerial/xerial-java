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
// SilkDistributedParser.java
// Since: Feb 2, 2010 2:18:00 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkEvent;
import org.xerial.silk.SilkLinePushParser;
import org.xerial.silk.impl.SilkLineLexer;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;

public class SilkDistributedParser {

    private static Logger _logger = Logger.getLogger(SilkDistributedParser.class);

    public static class Config {

        @Option(symbol = "h", longName = "help", description = "display help message")
        boolean displayHelp = false;

        @Argument
        String inputFile = null;

        @Option(symbol = "o", description = "output file name")
        String outputFile = null;

        @Option(symbol = "v", description = "display verbose messages")
        boolean displayVerboseMessage = false;
    }

    public void execute(Config config) throws Exception {

        if (config.inputFile == null) {
            _logger.error("no input file is given");
            return;
        }
        if (config.outputFile == null) {
            config.outputFile = config.inputFile + ".out";
        }

        Configuration hadoopConf = new Configuration();
        // Delete the output folder if exists
        FileSystem fs = FileSystem.get(hadoopConf);
        Path targetDir = new Path(config.outputFile);
        if (fs.exists(targetDir))
            fs.delete(new Path(config.outputFile), true);

        Job job = new Job(hadoopConf, "Silk distributed parser");
        job.setJarByClass(SilkDistributedParser.class);

        // input split

        // mapper
        job.setMapperClass(SilkBlockMapper.class);
        job.setMapOutputKeyClass(LinePos.class);
        job.setMapOutputValueClass(Text.class);

        job.setPartitionerClass(BlockPartitioner.class);
        job.setGroupingComparatorClass(BlockComparator.class);

        // reducer
        job.setReducerClass(SilkBlockReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(config.inputFile));
        FileOutputFormat.setOutputPath(job, new Path(config.outputFile));

        boolean hasFinished = job.waitForCompletion(config.displayVerboseMessage);
    }

    public static class LinePos implements WritableComparable<LinePos> {

        public int block;
        public int offset;

        public LinePos() {}

        public LinePos(int block, int offset) {
            this.block = block;
            this.offset = offset;
        }

        public void readFields(DataInput in) throws IOException {
            block = in.readInt();
            offset = in.readInt();
        }

        public void write(DataOutput out) throws IOException {
            out.writeInt(block);
            out.writeInt(offset);
        }

        @Override
        public int hashCode() {
            return block * 157 + offset;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof LinePos) {
                LinePos o = LinePos.class.cast(obj);
                return block == o.block & offset == o.offset;
            }
            else
                return false;
        }

        public int compareTo(LinePos o) {
            int diff = block - o.block;
            if (diff == 0)
                return diff;
            else
                return offset - o.offset;
        }

        @Override
        public String toString() {
            return String.format("%d(%d)", block, offset);
        }

        public static class Comparator extends WritableComparator {
            public Comparator() {
                super(LinePos.class);
            }

            @Override
            public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
                return compareBytes(b1, s1, l1, b2, s2, l2);
            }
        }

        static {
            WritableComparator.define(LinePos.class, new Comparator());
        }

    }

    public static class BlockPartitioner extends Partitioner<LinePos, Text> {

        @Override
        public int getPartition(LinePos pos, Text value, int numPartitions) {
            return (pos.block * 127) % numPartitions;
        }

    }

    public static class BlockComparator implements RawComparator<LinePos> {

        public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
            return WritableComparator.compareBytes(b1, s1, Integer.SIZE / 8, b2, s2,
                    Integer.SIZE / 8);
        }

        public int compare(LinePos o1, LinePos o2) {
            return o1.block - o2.block;
        }

    }

    public static class SilkBlockMapper extends Mapper<LongWritable, Text, LinePos, Text> {

        //final int blockSize = 64 * 1024 * 1024; // 64MB 
        final int blockSize = 1024;

        private final SilkLineLexer lexer = new SilkLineLexer();

        @Override
        protected void map(LongWritable key, Text value,
                Mapper<LongWritable, Text, LinePos, Text>.Context context) throws IOException,
                InterruptedException {
            _logger.info(String.format("map: (%s, %s)", key.toString(), value.toString()));

            try {
                SilkEvent e = SilkLinePushParser.parseLine(lexer, value.toString());
                context.progress();
                long bytePos = key.get();
                context.write(
                        new LinePos((int) (bytePos / blockSize), (int) (bytePos % blockSize)),
                        new Text(e.getType().toString()));

            }
            catch (XerialException e) {
                e.printStackTrace();
            }

        };
    }

    public static class SilkBlockReducer extends Reducer<LinePos, Text, IntWritable, Text> {

        @Override
        protected void reduce(LinePos key, Iterable<Text> values,
                Reducer<LinePos, Text, IntWritable, Text>.Context context) throws IOException,
                InterruptedException {

            _logger.info("reducer is invoked");
            for (Text each : values) {
                _logger.info(String.format("reduce: (%s, %s)", key.toString(), each.toString()));
            }

            context.write(new IntWritable(key.block), new Text(""));
        };
    }

    public static void main(String[] args) {

        OptionParser opt = new OptionParser(Config.class);
        try {
            opt.parse(args);
            Config config = opt.getOptionHolder();
            if (config.displayHelp) {
                opt.printUsage();
                return;
            }

            SilkDistributedParser parser = new SilkDistributedParser();
            parser.execute(config);
        }
        catch (Exception e) {
            _logger.error(e);
        }

    }

}
