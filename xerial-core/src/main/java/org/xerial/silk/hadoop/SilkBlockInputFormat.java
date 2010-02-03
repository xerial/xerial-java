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

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class SilkBlockInputFormat extends FileInputFormat<LongWritable, Text> {

    public static class BlockReader extends RecordReader<LongWritable, Text> {

        @Override
        public void close() throws IOException {
        // TODO Auto-generated method stub

        }

        @Override
        public LongWritable getCurrentKey() throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Text getCurrentValue() throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public float getProgress() throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void initialize(InputSplit split, TaskAttemptContext context) throws IOException,
                InterruptedException {
        // TODO Auto-generated method stub

        }

        @Override
        public boolean nextKeyValue() throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            return false;
        }

    }

    @Override
    public RecordReader<LongWritable, Text> createRecordReader(InputSplit split,
            TaskAttemptContext context) throws IOException, InterruptedException {

        return new BlockReader();
    }

}
