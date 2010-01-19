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
// FastBufferedReaderTest.java
// Since: Jan 19, 2010 2:49:25 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.silk.SilkWalkerTest;
import org.xerial.util.log.Logger;

public class FastBufferedReaderTest {

    private static Logger _logger = Logger.getLogger(FastBufferedReaderTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void performance() throws Exception {

        StopWatch s = new StopWatch();

        String line = null;
        final int N = 1;

        Pattern p = Pattern.compile("\t");

        //        s.reset();
        //        for (int i = 0; i < N; i++) {
        //            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(
        //                    SilkWalkerTest.class, "scaffold1.silk").openStream()));
        //
        //            while ((line = br.readLine()) != null) {
        //                String[] tab = p.split(line);
        //            }
        //        }
        //        _logger.info("default split:" + s.getElapsedTime());

        //        s.reset();
        //        for (int i = 0; i < N; i++) {
        //            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(
        //                    SilkWalkerTest.class, "scaffold1.silk").openStream()));
        //
        //            while ((line = br.readLine()) != null) {
        //                Scanner scan = new Scanner(line);
        //                scan.useDelimiter(p);
        //                ArrayList<String> tokens = new ArrayList<String>();
        //                while (scan.hasNext()) {
        //                    tokens.add(scan.next());
        //                }
        //            }
        //        }
        //        _logger.info("scanner split:" + s.getElapsedTime());

        s.reset();
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(
                    SilkWalkerTest.class, "scaffold1.silk").openStream()));

            while ((line = br.readLine()) != null) {
                ArrayList<String> tokens = StringUtil.splitAtTab(line);
            }
        }
        _logger.info("my split:" + s.getElapsedTime());

        s.reset();
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(
                    SilkWalkerTest.class, "scaffold1.silk").openStream()));

            while ((line = br.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, "\t");
                ArrayList<String> tokens = new ArrayList<String>();
                while (t.hasMoreTokens()) {
                    tokens.add(t.nextToken());
                }
            }
        }
        _logger.info("tokenizer split:" + s.getElapsedTime());

        //        s.reset();
        //        for (int i = 0; i < N; i++) {
        //            FastBufferedReader fb = new FastBufferedReader(new InputStreamReader(FileResource.find(
        //                    SilkWalkerTest.class, "scaffold1.silk").openStream()));
        //
        //            while ((line = fb.readLine()) != null) {
        //                String[] tab = p.split(line);
        //            }
        //        }
        //        _logger.info("fast reader:" + s.getElapsedTime());

    }

}
