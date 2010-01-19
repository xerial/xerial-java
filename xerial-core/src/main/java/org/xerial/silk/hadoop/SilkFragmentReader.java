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
// SilkFragmentReader.java
// Since: 2009/12/29 20:34:10
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.RecordReader;

public class SilkFragmentReader implements RecordReader<Text, Text> {

    public void close() throws IOException {
    // TODO Auto-generated method stub

    }

    public Text createKey() {
        // TODO Auto-generated method stub
        return null;
    }

    public Text createValue() {
        // TODO Auto-generated method stub
        return null;
    }

    public long getPos() throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

    public float getProgress() throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean next(Text arg0, Text arg1) throws IOException {
        // TODO Auto-generated method stub
        return false;
    }

}
