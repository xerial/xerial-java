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
// JSONStreamWalkerTest.java
// Since: Jan 23, 2008 10:42:40 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

public class JSONStreamWalkerTest {
    private static Logger _logger = Logger.getLogger(JSONStreamWalkerTest.class);

    class MyVisitor implements TreeVisitor {

        public void finish(TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void init(TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void visitNode(String nodeName, String nodeValue, TreeWalker walker)
                throws XerialException {
            // TODO Auto-generated method stub

        }

        public void text(String nodeName, String nodeValue, TreeWalker walker)
                throws XerialException {
            // TODO Auto-generated method stub

        }

    }

    private StopWatch stopWatch = new StopWatch();

    public InputStream getSampleDataInputStream() throws IOException {
        return FileResource.openByteStream(JSONStreamWalkerTest.class, "chr1.json");
    }

    public InputStream getSampleDataReader() throws IOException {
        return FileResource.openByteStream(JSONStreamWalkerTest.class, "chr1.json");
    }

    @Test
    public void walk() throws IOException, XerialException {
        JSONStreamWalker walker = new JSONStreamWalker(getSampleDataInputStream());

        stopWatch.reset();
        walker.walk(new MyVisitor());
        _logger.debug("walk time: " + stopWatch.getElapsedTime());
    }

    @Test
    public void lexerPerfWithReader() throws Exception {
        JSONLexer lexer = new JSONLexer(getSampleDataReader());
        stopWatch.reset();
        while ((lexer.nextToken() != null)) {

        }
        _logger.debug("lexical analysis time with Reader: " + stopWatch.getElapsedTime());

    }

    @Test
    public void lexerPerfwithInputStream() throws Exception {
        JSONLexer lexer = new JSONLexer(getSampleDataInputStream());
        stopWatch.reset();
        while ((lexer.nextToken() != null)) {

        }
        _logger.debug("lexical analysis time with InputStream: " + stopWatch.getElapsedTime());

    }

    @Test
    public void pullParserPerf() throws IOException, JSONException {
        JSONPullParser parser = new JSONPullParser(getSampleDataInputStream());
        stopWatch.reset();
        while (parser.next() != JSONEvent.EndJSON) {

        }
        _logger.debug("pull parsing time: " + stopWatch.getElapsedTime());
    }

}
