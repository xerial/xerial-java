/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// StopWatchTest.java
// Since: 2008/10/23 23:25:13
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.xerial.util.log.Logger;

public class StopWatchTest
{
    private static Logger _logger = Logger.getLogger(StopWatchTest.class);

    @Test
    public void testStopWatch() throws InterruptedException
    {
        double waitingTime = 0.5;
        StopWatch sw = new StopWatch();
        sw.reset();
        Thread.sleep((long) (waitingTime * 1000));
        double time = sw.getElapsedTime();
        assertEquals(waitingTime, time, 0.01);
    }

}
