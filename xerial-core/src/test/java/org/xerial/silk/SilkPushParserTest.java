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
// SilkPushParserTest.java
// Since: 2009/05/28 19:46:26
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;

public class SilkPushParserTest
{
    private static Logger _logger = Logger.getLogger(SilkPushParserTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void performanceTest() throws Exception
    {
        StopWatch timer = new StopWatch();

        for (int i = 0; i < 2; i++)
        {
            SilkPushParser parser = new SilkPushParser(FileResource.find(SilkPushParserTest.class, "scaffold1.silk"));
            _logger.info("parsing start");
            timer.reset();
            parser.parse(new SilkEventHandler() {

                public void handle(SilkEvent event) throws XerialException
                {

                }
            });
            double t = timer.getElapsedTime();
            long lines = parser.getNumReadLine();
            _logger.info(String.format("time = %.2f sec. %.0f lines/sec", t, lines / t));

        }

    }

}
