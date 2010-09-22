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
// Xerial Silk Weaver Project 
//
// Copy.java
// Since: 2009/07/22 16:33:09
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

import java.io.File;

import org.xerial.util.StopWatch;
import org.xerial.util.io.FileCopy;
import org.xerial.util.io.FileCopy.Config;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;

/**
 * File copy command
 * 
 * @author leo
 * 
 */
public class Copy implements SilkWeaverCommand {

    private static Logger _logger = Logger.getLogger(Copy.class);

    @Argument(index = 0, name = "src")
    private String src;
    @Argument(index = 1, name = "dest")
    private String dest;

    @Option(symbol = "b", longName = "buffersize", varName = "KB", description = "buffer size in KB (default = 64KB)")
    private int bufferSizeInKB = 64;

    public int execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {

        StopWatch timer = new StopWatch();
        timer.reset();
        _logger.debug(String.format("copy from %s to %s", src, dest));
        _logger.debug(String.format("buffer size = %d KB", bufferSizeInKB));
        File s = new File(src);
        File t = new File(dest);

        Config config = new Config();
        config.BLOCK_SIZE = bufferSizeInKB * 1024;
        FileCopy.copy(s, t, config);

        double time = timer.getElapsedTime();
        double mbPerSec = (s.length() / (double) (1024 * 1024)) / time;
        _logger.debug(String.format("elapsed time: %.2f sec. %.2f MB/sec", time, mbPerSec));

        return ReturnCode.SUCCESS.toInt();
    }

    public String getCommandName() {
        return "cp";
    }

    public String getOneLineDescription() {
        return "fast file copy";
    }

}
