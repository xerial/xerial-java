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
// SilkLineMapper.java
// Since: 2009/12/29 20:40:05
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.xerial.silk.model.SilkElement;

public class SilkLineMapper extends Mapper<LongWritable, Text, LongWritable, SilkElement> {

    @Override
    protected void map(
            LongWritable byteOffset,
            Text line,
            org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, LongWritable, SilkElement>.Context context)
            throws java.io.IOException, InterruptedException {

    };

}
