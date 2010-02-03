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
// SilkBlockInputFormat.java
// Since: Feb 3, 2010 11:30:18 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.hadoop;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.LineReader;
import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.log.Logger;

public class SilkBlockInputFormat extends FileInputFormat<LongWritable, Iterator<String>> {

    public static class BlockReader extends RecordReader<LongWritable, Iterator<String>> {

        private static Logger _logger = Logger.getLogger(SilkBlockInputFormat.BlockReader.class);

        private long start;
        private long pos;
        private long end;
        private LineReader in;

        @Override
        public void initialize(InputSplit genericSplit, TaskAttemptContext context)
                throws IOException, InterruptedException {

            FileSplit split = FileSplit.class.cast(genericSplit);
            Configuration conf = context.getConfiguration();

            // split (start, end)
            start = split.getStart();
            end = start + split.getLength();

            // find compression type of the input
            final Path file = split.getPath();

            // open the file, then seek to the start of the split
            FileSystem fs = file.getFileSystem(conf);
            FSDataInputStream fin = fs.open(split.getPath());
            boolean skipFirstLine = false;
            if (start != 0) {
                // if the block starts at the middle of the line, skip the first line
                skipFirstLine = true;
                --start;
                fin.seek(start);
            }
            in = new LineReader(fin, conf);

            if (skipFirstLine) {
                // skip the first line since it belongs to the previous split
                start += in.readLine(new Text(), 0, (int) Math.min(Integer.MAX_VALUE, end - start));
            }

            this.pos = start;
        }

        @Override
        public void close() throws IOException {
            if (in != null)
                in.close();
        }

        private LongWritable key = null;
        private Cursor value = null;
        private boolean hasNext = true;

        public class Cursor implements Iterator<String> {

            String line;

            public Cursor() {

            }

            public boolean hasNext() {
                try {

                    int newSize = 0;
                    if (pos < end) {
                        Text v = new Text();
                        newSize = in.readLine(v, Integer.MAX_VALUE, Math.max((int) Math.min(
                                Integer.MAX_VALUE, end - pos), Integer.MAX_VALUE));

                        pos += newSize;
                        line = v.toString();
                    }

                    if (newSize == 0)
                        return false;
                    else
                        return true;
                }
                catch (IOException e) {
                    _logger.error(e);
                }

                return false;
            }

            public String next() {
                return line;
            }

            public void remove() {
                throw new XerialError(XerialErrorCode.UNSUPPORTED, "remove");
            }

        }

        @Override
        public boolean nextKeyValue() throws IOException, InterruptedException {
            if (!hasNext) {
                return false;
            }

            key = new LongWritable(pos);
            value = new Cursor();
            hasNext = false;
            return true;
        }

        @Override
        public LongWritable getCurrentKey() throws IOException, InterruptedException {
            return key;
        }

        @Override
        public Iterator<String> getCurrentValue() throws IOException, InterruptedException {
            return value;
        }

        @Override
        public float getProgress() throws IOException, InterruptedException {
            if (start == end) {
                return 0.0f;
            }
            else {
                return Math.min(1.0f, (pos - start) / (float) (end - start));
            }
        }

    }

    @Override
    public RecordReader<LongWritable, Iterator<String>> createRecordReader(InputSplit split,
            TaskAttemptContext context) throws IOException, InterruptedException {

        return new BlockReader();
    }

}
