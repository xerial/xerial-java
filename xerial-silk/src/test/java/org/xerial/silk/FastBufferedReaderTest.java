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
package org.xerial.silk;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.FastBufferedInputStream;
import org.xerial.util.FastBufferedReader;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.StringUtil;
import org.xerial.util.UTF8String;
import org.xerial.util.io.BufferedScanner;
import org.xerial.util.log.Logger;

public class FastBufferedReaderTest
{

    private static Logger _logger = Logger.getLogger(FastBufferedReaderTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void performanceOfCSVSplit() throws Exception {

        StopWatch s = new StopWatch();

        String line = null;
        final int N = 1;
        Pattern p = Pattern.compile(",");

        s.reset();
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(SilkWalkerTest.class,
                    "scaffold1.silk").openStream()));

            while ((line = br.readLine()) != null) {
                ArrayList<String> csv = StringUtil.splitCSV(line);
            }
        }
        _logger.info("OpenCSV split:" + s.getElapsedTime());
    }

    @Test
    public void performanceOfTabSplit() throws Exception {

        StopWatch s = new StopWatch();

        String line = null;
        final int N = 1;

        Pattern p = Pattern.compile("\t");

        s.reset();
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(SilkWalkerTest.class,
                    "scaffold1.silk").openStream()));

            while ((line = br.readLine()) != null) {
                String[] tab = p.split(line);
            }
        }
        _logger.info("default tab split:" + s.getElapsedTime());

        s.reset();
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(SilkWalkerTest.class,
                    "scaffold1.silk").openStream()));

            while ((line = br.readLine()) != null) {
                ArrayList<String> tokens = StringUtil.splitAtTab(line);
            }
        }
        _logger.info("my tab split:" + s.getElapsedTime());

        s.reset();
        for (int i = 0; i < N; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileResource.find(SilkWalkerTest.class,
                    "scaffold1.silk").openStream()));

            while ((line = br.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, "\t");
                ArrayList<String> tokens = new ArrayList<String>();
                while (t.hasMoreTokens()) {
                    tokens.add(t.nextToken());
                }
            }
        }
        _logger.info("tokenizer tab split:" + s.getElapsedTime());

        s.reset();
        for (int i = 0; i < N; i++) {
            FastBufferedReader fb = new FastBufferedReader(new InputStreamReader(FileResource.find(
                    SilkWalkerTest.class, "scaffold1.silk").openStream()));

            while ((line = fb.readLine()) != null) {
                ArrayList<String> tab = StringUtil.splitAtTab(line);
            }
        }
        _logger.info("fast reader:" + s.getElapsedTime());

    }

    @Test
    public void perfTest() throws Exception {
        StopWatch s = new StopWatch();

        File in = FileResource.copyToTemp(SilkWalkerTest.class, "scaffold1.silk", new File("target"));
        final int N = 10;

        {
            s.reset();
            int lineCount = 0;
            char[] buf = new char[8192];
            for (int i = 0; i < N; i++) {
                BufferedReader fb = new BufferedReader(new FileReader(in));
                for (int readSize = 0; (readSize = fb.read(buf)) != -1;) {
                    for (int c = 0; c < readSize; c++) {
                        if (buf[c] == '\r') {
                            lineCount++;
                            if (c + 1 < readSize && buf[c + 1] == '\n') {
                                c++;
                            }
                        }
                        else if (buf[c] == '\n') {
                            lineCount++;
                        }
                    }
                }
            }
            _logger.info(String.format("BufferedReader: %.2f", s.getElapsedTime()));
        }

        {
            s.reset();
            int lineCount = 0;
            for (int i = 0; i < N; i++) {
                BufferedReader fb = new BufferedReader(new FileReader(in));
                for (String line; (line = fb.readLine()) != null; lineCount++) {}
            }
            _logger.info(String.format("BufferedReader readLine: %.2f, line:%d", s.getElapsedTime(), lineCount));
        }

        {
            s.reset();
            int lineCount = 0;
            for (int i = 0; i < N; i++) {
                BufferedScanner fb = new BufferedScanner(new FileInputStream(in));
                for (UTF8String line; (line = fb.nextLine()) != null; lineCount++) {}
            }
            _logger.info(String.format("BufferedScanner nextLine: %.2f, line:%d", s.getElapsedTime(), lineCount));
        }

        {
            s.reset();
            int lineCount = 0;
            char[] buf = new char[8192];
            for (int i = 0; i < N; i++) {
                FastBufferedReader fb = new FastBufferedReader(new FileReader(in));
                for (int readSize = 0; (readSize = fb.read(buf)) != -1;) {
                    for (int c = 0; c < readSize; c++) {
                        if (buf[c] == '\r') {
                            lineCount++;
                            if (c + 1 < readSize && buf[c + 1] == '\n') {
                                c++;
                            }
                        }
                        else if (buf[c] == '\n') {
                            lineCount++;
                        }
                    }
                }
            }
            _logger.info(String.format("FastBufferedReader: %.2f", s.getElapsedTime()));
        }

        {
            s.reset();
            int lineCount = 0;
            byte[] buf = new byte[8192];
            for (int i = 0; i < N; i++) {
                BufferedInputStream fb = new BufferedInputStream(new FileInputStream(in));
                for (int readSize = 0; (readSize = fb.read(buf)) != -1;) {
                    for (int c = 0; c < readSize; c++) {
                        if (buf[c] == '\r') {
                            lineCount++;
                            if (c + 1 < readSize && buf[c + 1] == '\n') {
                                c++;
                            }
                        }
                        else if (buf[c] == '\n') {
                            lineCount++;
                        }
                    }

                }
            }
            _logger.info(String.format("BufferedInputStream: %.2f", s.getElapsedTime()));
        }

        {
            s.reset();
            int lineCount = 0;
            byte[] buf = new byte[8192];
            for (int i = 0; i < N; i++) {
                FastBufferedInputStream fb = new FastBufferedInputStream(new FileInputStream(in));
                for (int readSize = 0; (readSize = fb.read(buf)) != -1;) {
                    for (int c = 0; c < readSize; c++) {
                        if (buf[c] == '\r') {
                            lineCount++;
                            if (c + 1 < readSize && buf[c + 1] == '\n') {
                                c++;
                            }
                        }
                        else if (buf[c] == '\n') {
                            lineCount++;
                        }
                    }

                }
            }
            _logger.info(String.format("FastBufferedInputStream: %.2f", s.getElapsedTime()));
        }

    }

}
