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
// ObjectHandlerTest.java
// Since: Jul 26, 2010 10:45:04 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.xerial.util.FileResource;

public class ObjectHandlerTest {

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
        Lens.findFromSilk(FileResource.open(ObjectHandlerTest.class, "sam-sample.silk"), "record",
                SAMEntry.class, h);

        assertTrue(h.isInitialized);
        assertTrue(h.isFinished);

    }
}
