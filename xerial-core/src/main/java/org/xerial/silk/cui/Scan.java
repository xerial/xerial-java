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
// Scan.java
// Since: Apr 23, 2009 6:50:10 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import java.io.File;

import org.xerial.silk.SilkStreamReader;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Usage;
import org.xerial.util.tree.TreeEvent;

/**
 * Scan command
 * 
 * @author leo
 * 
 */
@Usage(command = "silk scan", description = "silk file scanner")
public class Scan implements SilkCommand
{
    private static Logger _logger = Logger.getLogger(Scan.class);

    @Argument(index = 0)
    private String inputSilkFile = null;

    public void execute() throws Exception
    {
        SilkStreamReader reader = new SilkStreamReader(new File(inputSilkFile).toURL());
        TreeEvent e;
        int count = 0;
        StopWatch timer = new StopWatch();
        while ((e = reader.next()) != null)
        {
            count++;
            if (count % 1000000 == 0)
            {
                long line = reader.getNumReadLine();

                double time = timer.getElapsedTime();
                double speed = line / time;
                _logger.info(String.format("line=%d, count=%d, time=%s, %2.2f lines/sec", line, count, time, speed));
            }

        }
        _logger.info(String.format("elapsed time: %.1f sec.", timer.getElapsedTime()));
    }

    public String getName()
    {
        return "scan";
    }

    public String getOneLineDescription()
    {
        return "scanning the input Silk file";
    }

}
