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
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeEventHandlerBase;
import org.xerial.util.tree.TreeEvent.EventType;
import org.xerial.xml.pullparser.PullParserUtil;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;

public class SilkParserPerformanceTest {
    private static Logger _logger = Logger.getLogger(SilkParserPerformanceTest.class);

    private static final URL largeFile = FileResource.find(SilkParserPerformanceTest.class,
            "scaffold1.silk");
    private static final int largeFileSize = 30593075;
    private static final double largeFileLines = 111965;
    private static final int numNodes = 5826313;

    private SilkParserConfig config;

    @Before
    public void setUp() throws Exception {
        config = new SilkParserConfig();
        config.bufferSize = 1024 * 1024 * 8; // 8MB
        config.numWorkers = 2;
    }

    @After
    public void tearDown() throws Exception {}

    @Ignore
    @Test
    public void xmlReadTest() throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Set namespaceAware to true to get a parser that corresponds to
        // the default SAX2 namespace feature setting.  This is necessary
        // because the default value from JAXP 1.0 was defined to be false.
        spf.setNamespaceAware(true);

        // Validation part 1: set whether validation is on
        //spf.setValidating(dtdValidate || xsdValidate);

        // Create a JAXP SAXParser
        SAXParser saxParser = spf.newSAXParser();

        // Get the encapsulated SAX XMLReader
        XMLReader xmlReader = saxParser.getXMLReader();

        // Set the ContentHandler of the XMLReader
        xmlReader.setContentHandler(new ContentHandler() {

            public void characters(char[] ch, int start, int length) throws SAXException {

            }

            public void endDocument() throws SAXException {

            }

            public void endElement(String uri, String localName, String name) throws SAXException {

            }

            public void endPrefixMapping(String prefix) throws SAXException {

            }

            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

            }

            public void processingInstruction(String target, String data) throws SAXException {

            }

            public void setDocumentLocator(Locator locator) {

            }

            public void skippedEntity(String name) throws SAXException {

            }

            public void startDocument() throws SAXException {

            }

            public void startElement(String uri, String localName, String name, Attributes atts)
                    throws SAXException {

            }

            public void startPrefixMapping(String prefix, String uri) throws SAXException {

            }
        });

        // Set an ErrorHandler before parsing
        //xmlReader.setErrorHandler(new MyErrorHandler(System.err));

        // Tell the XMLReader to parse the XML document
        StopWatch timer = new StopWatch();
        xmlReader.parse("f:/cygwin/home/leo/work/t2k/xmark-1.0.xml");
        _logger.info("time: " + timer.getElapsedTime());

        // 104.5 sec. (Xeon)
    }

    @Ignore
    @Test
    public void xmlPullPerformance() throws Exception {
        XmlPullParser parser = PullParserUtil.newParser(new BufferedReader(new FileReader(
                "f:/cygwin/home/leo/work/t2k/xmark-1.0.xml")));

        StopWatch timer = new StopWatch();
        while (parser.next() != XmlPullParser.END_DOCUMENT) {}
        _logger.info("time: " + timer.getElapsedTime());

        // 125.3 sec. (Xeon)

    }

    public static void reportNodeCountStat(int count, double time) {
        double percentage = ((double) count / numNodes) * 100;
        double speed = numNodes / time;

        _logger.debug(String
                .format("%2.2f%%, time=%5.2f, %,10.0f nodes/s", percentage, time, speed));

    }

    public static void reportTotalSpeed(String name, double time) {
        reportTotalSpeed(name, numNodes, time);
    }

    public static void reportTotalSpeed(String name, int count, double time) {
        double speedPerNode = (count) / time;
        double speedPerLine = (largeFileLines) / time;
        double speedInMBS = largeFileSize / 1024 / 1024 / time;
        _logger.info(String.format("[%-20s] time=%5.2f %,10.0f nodes/s, %5.2f MB/s %7.0f lines/s",
                name, time, speedPerNode, speedInMBS, speedPerLine));
    }

    @Test
    public void maxReadSpeed() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(largeFile.openStream()),
                config.bufferSize);
        int lineCount = 0;
        String line = null;
        StopWatch timer = new StopWatch();
        while ((line = reader.readLine()) != null) {
            lineCount++;
            if (lineCount % 100000 == 0) {
                double percentage = (lineCount / largeFileLines) * 100;
                double time = timer.getElapsedTime();
                double speed = lineCount / time;
                _logger.debug(String.format("%2.2f%%, line=%d, time=%s, %2.2f lines/s", percentage,
                        lineCount, time, speed));
            }
        }
        reportTotalSpeed("BufferedReader", timer.getElapsedTime());

        // best time: 60,000 lines/sec
        // 80000 lines/sec (Xeon 3.0 * dual) 

    }

    @Test
    public void maxReadSpeedWithoutParsingNewLine() throws Exception {
        Reader reader = new InputStreamReader(largeFile.openStream());
        int lineCount = 0;

        StopWatch timer = new StopWatch();
        char[] buf = new char[config.bufferSize];
        int numBytes = 0;
        int numReadBytes = 0;
        while ((numReadBytes = reader.read(buf, 0, config.bufferSize)) != -1) {
            numBytes += numReadBytes;
        }
        reportTotalSpeed("Reader", timer.getElapsedTime());

        // best time: 60,000 lines/sec
        // 80000 lines/sec (Xeon 3.0 * dual) 

    }

    @Ignore
    @Test
    public void maxReadSpeedTest3() throws Exception {
        int unit = 1024 * 1024;

        FileInputStream fin = new FileInputStream("scaffold1.txt");

        FileChannel channel = fin.getChannel();
        int lineCount = 0;

        ByteBuffer buf = ByteBuffer.allocate(unit);
        StopWatch timer = new StopWatch();
        int pos = 0;
        while (true) {
            buf.rewind();
            if (channel.read(buf) <= -1) {
                break;
            }
        }
        reportTotalSpeed("", timer.getElapsedTime());

        channel.close();

    }

    @Ignore
    @Test
    public void silkStreamReaderPerformance() throws Exception {
        SilkPullParser reader = new SilkPullParser(largeFile);
        StopWatch timer = new StopWatch();
        int count = 0;
        TreeEvent e;
        while ((e = reader.next()) != null) {
            if (e.event == EventType.VISIT) {
                count++;
                if (count % 1000000 == 0)
                    reportNodeCountStat(count, timer.getElapsedTime());
            }

        }
        reportTotalSpeed("SilkStreamReader", count, timer.getElapsedTime());

        // best time: 4200 lines/sec (2009 Apr. 23)
        // 6585 lines/sec (after threading SilkPullParser)
        // 6200 lines/sec (2009 Apr.23 Push+Pull)

        // 7738 lines/sec (PullParser implementation using PushPaser on Xeon 3.0GHz dual)

        // 8000 lines/sec (Recursive Parser on Xeon 3.0GHz dual)

    }

    @Test
    public void pullParserPerformanceTest() throws Exception {
        SilkLinePullParser reader = new SilkLinePullParser(largeFile);
        StopWatch timer = new StopWatch();
        int count = 0;
        SilkEvent e;
        while ((e = reader.next()) != null) {

        }
        reportTotalSpeed("SilkLinePullParser", timer.getElapsedTime());

        // best time: 13000 lines/sec
        // 12500 - 14700 lines/sec (after threading SilkPullParser)
        // 12800 lines/sec (SilkPushParser + SilkPullParser)

        // 18500 lines/sec (Xeon 3.0 * dual) 
        // 17411 lines/sec (Xeon 3.0 * dual) (PullParser implementation using PushPaser)

        // 30000 lines/sec (Xeon 3.0 * dual) (PullParser using SilkNodeParser (recursive descent parser)) 
    }

    @Test
    public void pushParserPerformance() throws Exception {
        final SilkLinePushParser reader = new SilkLinePushParser(largeFile, config);
        final StopWatch timer = new StopWatch();

        reader.parse(new SilkEventHandler() {
            int lineCount = 0;

            public void handle(SilkEvent event) {
                lineCount++;

                if (event.getType() == SilkEventType.END_OF_FILE) {
                    _logger.debug("line count = " + lineCount);
                }

            }
        });
        reportTotalSpeed("SilkLinePushParser", timer.getElapsedTime());

        // 20000 lines/sec (Xeon 3.0 * dual) 
        // 45000 lines/sec (Xeon 3.0 * dual when using recursive descent parser)

        // time= 1.63  3,569,374 nodes/s, 17.77 MB/s   68593 lines/s (VAIO Z)

    }

    @Test
    public void fastPushParserPerformance() throws Exception {
        SilkLineFastParser parser = new SilkLineFastParser(largeFile, config);
        StopWatch timer = new StopWatch();
        parser.parse(new SilkEventHandler() {

            long lineCount = 0;

            public void handle(SilkEvent event) throws Exception {
                lineCount++;

                if (event.getType() == SilkEventType.END_OF_FILE) {
                    _logger.debug("line count = " + lineCount);
                }
            }
        });

        reportTotalSpeed("SilkFastPushParser", timer.getElapsedTime());
    }

    int count = 0;

    @Test
    public void parserPerformance() throws Exception {
        SilkParser parser = new SilkParser(largeFile, config);
        final StopWatch timer = new StopWatch();

        count = 0;
        parser.parse(new TreeEventHandlerBase() {

            @Override
            public void visitNode(String nodeName, String immediateNodeValue) throws Exception {
                count++;
                if (count % 1000000 == 0)
                    reportNodeCountStat(count, timer.getElapsedTime());
            }

        });

        reportTotalSpeed("SilkParser", count, timer.getElapsedTime());
    }

    @Ignore
    @Test
    public void pullParserPerformance() throws Exception {
        SilkPullParser parser = new SilkPullParser(largeFile, config);
        final StopWatch timer = new StopWatch();

        int count = 0;
        TreeEvent e = null;
        while ((e = parser.next()) != null) {
            if (e.event == EventType.VISIT) {
                count++;
                if (count % 1000000 == 0)
                    reportNodeCountStat(count, timer.getElapsedTime());
            }
        }

        reportTotalSpeed("SilkPullParser", count, timer.getElapsedTime());
    }

}
