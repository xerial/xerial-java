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
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SilkStreamReaderTest
{
    private static Logger _logger = Logger.getLogger(SilkStreamReaderTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    //private static final String largeFile = "file:///c:/Users/leo/work/t2k/hdrr_hni_allaxt_revised.silk";

    //private static final String largeFile = "file:///f:/cygwin/home/leo/work/t2k/hdrr_hni_allaxt_revised.silk";

    private static final URL largeFile = FileResource.find(SilkStreamReaderTest.class, "scaffold1.silk");
    private static final int largeFileSize = 30593075;
    private static final double largeFileLines = 111965;
    private static final int numNodes = 5826313;

    //private static final String largeFile = "file:///d:/tmp/hdrr_hni_allaxt_revised.silk";
    //private static final String largeFile = "file:///f:/cygwin/home/leo/work/t2k/hdrr_hni_allaxt_revised.silk";

    @Test
    public void dummy()
    {

    }

    @Ignore
    @Test
    public void xmlReadTest() throws Exception
    {
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

            public void characters(char[] ch, int start, int length) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void endDocument() throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void endElement(String uri, String localName, String name) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void endPrefixMapping(String prefix) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void processingInstruction(String target, String data) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void setDocumentLocator(Locator locator)
            {
            // TODO Auto-generated method stub

            }

            public void skippedEntity(String name) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void startDocument() throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException
            {
            // TODO Auto-generated method stub

            }

            public void startPrefixMapping(String prefix, String uri) throws SAXException
            {
            // TODO Auto-generated method stub

            }
        });

        // Set an ErrorHandler before parsing
        //xmlReader.setErrorHandler(new MyErrorHandler(System.err));

        // Tell the XMLReader to parse the XML document
        StopWatch timer = new StopWatch();
        xmlReader.parse("f:/cygwin/home/leo/work/t2k/xmark-1.0.xml");
        _logger.info("time: " + timer.getElapsedTime());
    }

    public static void reportNodeCountStat(int count, double time)
    {
        double percentage = ((double) count / numNodes) * 100;
        double speed = numNodes / time;

        _logger.info(String.format("%2.2f%%, time=%5.2f, %,10.0f nodes/s", percentage, time, speed));

    }

    public static void reportTotalSpeed(String name, double time)
    {
        reportTotalSpeed(name, numNodes, time);
    }

    public static void reportTotalSpeed(String name, int count, double time)
    {
        double speedPerNode = ((double) count) / time;
        double speedInMBS = largeFileSize / 1024 / 1024 / time;
        _logger.info(String.format("[%-15s] time=%.2f, %,10.0f nodes/s, %3.2f MB/s", name, time, speedPerNode,
                speedInMBS));
    }

    @Test
    public void maxReadSpeedTest() throws Exception
    {
        int unit = 1024 * 1024;
        BufferedReader reader = new BufferedReader(new InputStreamReader(largeFile.openStream()));
        int lineCount = 0;
        String line = null;
        StopWatch timer = new StopWatch();
        while ((line = reader.readLine()) != null)
        {
            lineCount++;
            if (lineCount % 100000 == 0)
            {
                double percentage = (lineCount / largeFileLines) * 100;
                double time = timer.getElapsedTime();
                double speed = lineCount / time;
                _logger.info(String.format("%2.2f%%, line=%d, time=%s, %2.2f lines/s", percentage, lineCount, time,
                        speed));
            }
        }
        reportTotalSpeed("BufferedReader", timer.getElapsedTime());

        // best time: 60,000 lines/sec
        // 80000 lines/sec (Xeon 3.0 * dual) 

    }

    @Test
    public void maxReadSpeedTest2() throws Exception
    {
        int unit = 1024 * 1024 * 16;

        Reader reader = new InputStreamReader(largeFile.openStream());
        int lineCount = 0;

        StopWatch timer = new StopWatch();
        char[] buf = new char[unit];
        int numBytes = 0;
        int numReadBytes = 0;
        while ((numReadBytes = reader.read(buf, 0, unit)) != -1)
        {
            numBytes += numReadBytes;
        }
        reportTotalSpeed("Reader", timer.getElapsedTime());

        // best time: 60,000 lines/sec
        // 80000 lines/sec (Xeon 3.0 * dual) 

    }

    @Ignore
    @Test
    public void maxReadSpeedTest3() throws Exception
    {
        int unit = 1024 * 1024;

        FileInputStream fin = new FileInputStream("scaffold1.txt");

        FileChannel channel = fin.getChannel();
        int lineCount = 0;

        ByteBuffer buf = ByteBuffer.allocate(unit);
        StopWatch timer = new StopWatch();
        int pos = 0;
        while (true)
        {
            buf.rewind();
            if (channel.read(buf) <= -1)
            {
                break;
            }
        }
        reportTotalSpeed("", timer.getElapsedTime());

        channel.close();

    }

    @Test
    public void silkStreamReaderPerformance() throws Exception
    {
        SilkStreamReader reader = new SilkStreamReader(largeFile);
        StopWatch timer = new StopWatch();
        int count = 0;
        TreeEvent e;
        while ((e = reader.next()) != null)
        {
            if (e.event == EventType.VISIT)
            {
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

    int count = 0;

    @Test
    public void parserPerformance() throws Exception
    {
        SilkParser parser = new SilkParser(largeFile);
        final StopWatch timer = new StopWatch();

        count = 0;
        parser.parse(new TreeEventHandlerBase() {

            @Override
            public void visitNode(String nodeName, String immediateNodeValue) throws Exception
            {
                count++;
                if (count % 1000000 == 0)
                    reportNodeCountStat(count, timer.getElapsedTime());
            }

        });

        reportTotalSpeed("SilkParser", count, timer.getElapsedTime());

    }

    @Test
    public void pullParserPerformanceTest() throws Exception
    {
        SilkLinePullParser reader = new SilkLinePullParser(largeFile);
        StopWatch timer = new StopWatch();
        int count = 0;
        SilkEvent e;
        while ((e = reader.next()) != null)
        {

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
    public void pushParserPerformanceTest() throws Exception
    {
        final SilkLinePushParser reader = new SilkLinePushParser(largeFile);
        final StopWatch timer = new StopWatch();

        reader.parse(new SilkEventHandler() {
            int count = 0;

            public void handle(SilkEvent event)
            {

            }
        });
        reportTotalSpeed("SilkLinePushParser", timer.getElapsedTime());

        // 20000 lines/sec (Xeon 3.0 * dual) 
        // 45000 lines/sec (Xeon 3.0 * dual when using recursive descent parser)
    }

}
