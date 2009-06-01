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
// SilkParserTest.java
// Since: Jun 1, 2009 3:20:52 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEventHandlerBase;

public class SilkParserTest
{
    private static Logger _logger = Logger.getLogger(SilkParserTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testParse() throws Exception
    {
        final StopWatch timer = new StopWatch();

        final SilkParser parser = new SilkParser(FileResource.open(SilkParserTest.class, "example.silk"));
        parser.parse(new TreeEventHandlerBase() {

            long count = 0;

            public void visitNode(String nodeName, String immediateNodeValue) throws Exception
            {
                count++;
                if (count % 100000 == 0)
                {
                    double t = timer.getElapsedTime();
                    long lines = parser.getNumReadLine();
                    _logger.info(String.format("node count=%d, time = %.2f sec. %.0f lines/sec", count, t, lines / t));
                }
            }
        });
    }

    @Test
    public void testPerformance() throws Exception
    {
        //String largeFile = "file:///c:/Users/leo/work/t2k/hdrr_hni_allaxt_revised.silk";
        String largeFile = "file:///f:/cygwin/home/leo/work/t2k/hdrr_hni_allaxt_revised.silk";

        final SilkParser parser = new SilkParser(new URL(largeFile));
        parser.parse(new TreeEventHandlerBase() {

            long count = 0;
            StopWatch timer = new StopWatch();

            @Override
            public void init() throws Exception
            {
                timer.reset();
            }

            public void visitNode(String nodeName, String immediateNodeValue) throws Exception
            {
                count++;
                if (count % 100000 == 0)
                {
                    double t = timer.getElapsedTime();
                    long lines = parser.getNumReadLine();
                    _logger.info(String.format("node count=%d, time = %.2f sec. %.0f lines/sec", count, t, lines / t));
                }
            }
        });

        // 8700 lines/sec (Recursive Parser on Xeon 3.0GHz dual)

    }

}
