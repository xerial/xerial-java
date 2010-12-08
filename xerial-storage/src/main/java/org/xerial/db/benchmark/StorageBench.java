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
// StorageBench.java
// Since: Jun 21, 2009 2:17:30 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.benchmark;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Random;

import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;

/**
 * Storage performance bench mark
 * 
 * @author leo
 * 
 */
public class StorageBench
{
    private static Logger _logger = Logger.getLogger(StorageBench.class);
    private final Config config;

    public StorageBench(Config config)
    {
        this.config = config;
    }

    public static void main(String[] args)
    {
        Config opt = new Config();
        OptionParser parser = new OptionParser(opt);
        try
        {
            parser.parse(args);
            new StorageBench(opt).run();
        }
        catch (OptionParserException e)
        {
            System.err.println(e);
            parser.printUsage();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }

    }

    public static class Config
    {
        @Option(symbol = "d", description = "target disk drive name")
        public String directory = "C:";

        @Option(symbol = "b", description = "block size in KB (default = 8)")
        public int blockSizeInKB = 4; // 4KB

        @Option(symbol = "t", description = "total target data size in MB (default = 100)")
        public int tmpFileSizeInMB = 100;

        public int numTrial = 1000;

        public int repeat = 1;
    }

    public void run() throws Exception
    {

        StopWatch timer = new StopWatch();

        byte[] buf = new byte[config.blockSizeInKB * 1024];
        for (int i = 0; i < buf.length; ++i)
        {
            buf[i] = (byte) i;
        }

        File tmp = null;
        try
        {
            File tmpDir = new File(config.directory, "bench");
            tmpDir.mkdirs();

            tmp = File.createTempFile("storage-bench", ".bench", tmpDir);
            _logger.info("preparing a test bench file: " + tmp.getAbsolutePath());
            int tmpFileSize = config.tmpFileSizeInMB * 1024 * 1024;
            RandomAccessFile file = new RandomAccessFile(tmp, "rwd");

            int wroteByteSize = 0;
            int pageCount = 0;
            while (wroteByteSize < tmpFileSize)
            {
                file.write(buf);
                wroteByteSize += config.blockSizeInKB * 1024;
                pageCount++;
            }
            _logger.info("preparation done. page count = " + pageCount);

            final int pageNumberMax = tmpFileSize / (config.blockSizeInKB * 1024);
            file.close();

            file = new RandomAccessFile(tmp, "rwd");

            // sequential read
            byte[] cache = new byte[config.blockSizeInKB * 1024];
            timer.reset();
            for (int k = 0; k < config.repeat; k++)
            {
                file.seek(0);
                for (int i = 0; i < pageCount; i++)
                {
                    file.readFully(buf);
                }
            }
            reportMBSec("sequential scan", timer.getElapsedTime());

            // sequential write
            timer.reset();
            for (int k = 0; k < config.repeat; k++)
            {
                file.seek(0);
                for (int i = 0; i < pageCount; i++)
                {
                    file.write(buf);
                }
            }
            reportMBSec("sequential write", timer.getElapsedTime());

            // random read
            file.seek(0);
            Random r = new Random();

            timer.reset();
            for (int k = 0; k < config.repeat; k++)
            {
                for (int i = 0; i < pageCount; i++)
                {
                    int pageID = r.nextInt(pageNumberMax);
                    file.seek(config.blockSizeInKB * pageID);
                    file.readFully(cache);
                }
            }
            reportIOPS("random read", timer.getElapsedTime());

            // random write
            r = new Random();
            timer.reset();
            for (int k = 0; k < config.repeat; k++)
            {
                for (int i = 0; i < pageCount; i++)
                {
                    int pageID = r.nextInt(pageNumberMax);
                    file.seek(config.blockSizeInKB * pageID);
                    file.write(buf);
                }
            }
            reportIOPS("random write", timer.getElapsedTime());

            file.close();
        }
        finally
        {
            if (tmp != null)
                tmp.delete();
        }

    }

    private void reportMBSec(String name, double elapsedTime)
    {
        int pageNumberMax = config.tmpFileSizeInMB * 1024 / config.blockSizeInKB;
        int totalDataSize = pageNumberMax * config.blockSizeInKB * 1024 * config.repeat;
        double timeMBPerSec = (totalDataSize / 1024 / 1024) / elapsedTime;

        _logger.info(String.format("%10s\t%5.2f MB/sec.", name, timeMBPerSec));
    }

    private void reportIOPS(String name, double elapsedTime)
    {
        int pageNumberMax = config.tmpFileSizeInMB * 1024 * 1024 / (config.blockSizeInKB * 1024);
        int numIOs = pageNumberMax * config.repeat;
        double iops = numIOs / elapsedTime;

        _logger.info(String.format("%10s:\t%8.2f IOPS.", name, iops));
    }

}
