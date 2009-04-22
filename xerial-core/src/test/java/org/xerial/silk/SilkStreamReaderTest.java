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
// SilkStreamReaderTest.java
// Since: 2009/04/22 22:55:47
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;

public class SilkStreamReaderTest
{
    private static Logger _logger = Logger.getLogger(SilkStreamReaderTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    private static final String largeFile = "file:///c:/Users/leo/work/t2k/hdrr_hni_allaxt_revised.silk";

    @Test
    public void maxReadSpeedTest() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(largeFile).openStream()));
        int lineCount = 0;
        String line = null;
        StopWatch timer = new StopWatch();
        while ((line = reader.readLine()) != null)
        {
            lineCount++;
            if (lineCount % 100000 == 0)
            {
                double percentage = (lineCount / 10145176.0) * 100;
                double time = timer.getElapsedTime();
                double speed = lineCount / time;
                _logger.info(String.format("%2.2f%%, line=%d, time=%s, %2.2f lines/sec", percentage, lineCount, time,
                        speed));
            }
        }
        _logger.info(String.format("time=%s", timer.getElapsedTime()));

    }

    @Test
    public void performanceTest() throws Exception
    {
        SilkStreamReader reader = new SilkStreamReader(new URL(largeFile));
        StopWatch timer = new StopWatch();
        int count = 0;
        TreeEvent e;
        while ((e = reader.next()) != null)
        {
            count++;
            if (count % 10000 == 0)
            {
                int line = reader.getNumReadLine();
                double percentage = (line / 10145176.0) * 100;
                double time = timer.getElapsedTime();
                double speed = line / time;
                _logger.info(String.format("%2.2f%%, line=%d, count=%d, time=%s, %2.2f lines/sec", percentage, line,
                        count, time, speed));
            }
        }
        _logger.info(String.format("time=%s", timer.getElapsedTime()));
    }

}
