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
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.Token;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.json.impl.JSONLexer;
import org.xerial.util.FileResource;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

public class JSONStreamWalkerTest
{
    private static Logger _logger = Logger.getLogger(JSONStreamWalkerTest.class);

    class MyVisitor implements TreeVisitor
    {

        public void finish(TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void init(TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void visitNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

        public void text(String nodeName, String nodeValue, TreeWalker walker) throws XerialException {
            // TODO Auto-generated method stub

        }

    }

    private StopWatch stopWatch = new StopWatch();

    public Reader getSampleData() throws IOException {
        return FileResource.open(JSONStreamWalkerTest.class, "chr1.json");
    }

    @Test
    public void walk() throws IOException, XerialException {
        JSONStreamWalker walker = new JSONStreamWalker(getSampleData());

        stopWatch.reset();
        walker.walk(new MyVisitor());
        _logger.debug("walk time: " + stopWatch.getElapsedTime());
    }

    @Test
    public void lexerPerf() throws IOException {
        JSONLexer lexer = new JSONLexer(new ANTLRReaderStream(getSampleData()));
        stopWatch.reset();
        while ((lexer.nextToken() != Token.EOF_TOKEN)) {

        }
        _logger.debug("lexical analysis time: " + stopWatch.getElapsedTime());

    }

    @Test
    public void pullParserPerf() throws IOException, JSONException {
        JSONPullParser parser = new JSONPullParser(getSampleData());
        stopWatch.reset();
        while (parser.next() != JSONEvent.EndJSON) {

        }
        _logger.debug("pull parsing time: " + stopWatch.getElapsedTime());
    }

    //    @Test
    //    public void loadJSONPerf() throws XerialException, IOException {
    //        stopWatch.reset();
    //        JSONLens.loadJSON(Gene.class, getSampleData(), new ObjectHandlerBase<Gene>() {
    //
    //            public void handle(Gene bean) throws Exception {
    //                // TODO Auto-generated method stub
    //
    //            }
    //
    //            public void handleException(Exception e) {
    //                _logger.error(e);
    //            }
    //
    //        });
    //        _logger.debug("loadJSON time: " + stopWatch.getElapsedTime());
    //    }

}
