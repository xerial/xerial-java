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
// JSONStreamReaderTest.java
// Since: Mar 31, 2009 2:49:53 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.json.impl.JSONLexer;
import org.xerial.json.impl.JSONTokenizer;
import org.xerial.util.FileResource;
import org.xerial.util.HashedArrayList;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEvent;

public class JSONStreamReaderTest
{
    private static Logger _logger = Logger.getLogger(JSONStreamReaderTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    HashedArrayList<String, String> parse(String file) throws Exception
    {
        JSONStreamReader reader = new JSONStreamReader(FileResource.open(JSONStreamReaderTest.class, file));
        TreeEvent e;

        HashedArrayList<String, String> data = new HashedArrayList<String, String>();

        while ((e = reader.next()) != null)
        {
            _logger.debug(e);

            if (e.isVisit())
                data.put(e.nodeName, e.nodeValue);
        }

        return data;
    }

    @Test
    public void testNext() throws Exception
    {
        HashedArrayList<String, String> data = parse("sample.json");

        assertEquals("Leo", data.get("name").get(0));
        assertEquals("100", data.get("id").get(0));
    }

    @Test
    public void testArray() throws Exception
    {
        HashedArrayList<String, String> data = parse("array.json");

        assertEquals(2, data.get("author").size());
        assertEquals("leo", data.get("author").get(0));
        assertEquals("yui", data.get("author").get(1));

        assertEquals("Relational-Style XML Query", data.get("title").get(0));
        assertNull(data.get("paper").get(0));

    }

    @Test
    public void testParse() throws Exception
    {

        // generate a sample JSON array
        StringBuilder sample = new StringBuilder();
        sample.append("[");
        int i = 0;
        final int N = 5000;
        for (; i < N; i++)
        {
            sample.append(i);
            sample.append(",");
        }
        sample.append(i);
        sample.append("]");

        String json = sample.toString();

        StopWatch timer = new StopWatch();

        for (int n = 0; n < 500; n++)
        {
            JSONPullParser parser = new JSONPullParser(json);

            JSONEvent e;
            while ((e = parser.next()) != JSONEvent.EndJSON)
            {}

        }
        _logger.info("time: " + timer.getElapsedTime());

    }

    @Test
    public void testLexerPerformance() throws Exception
    {

        // generate a sample JSON array
        StringBuilder sample = new StringBuilder();
        sample.append("[");
        int i = 0;
        final int N = 5000;
        for (; i < N; i++)
        {
            sample.append(i);
            sample.append(",");
        }
        sample.append(i);
        sample.append("]");

        String json = sample.toString();

        StopWatch timer = new StopWatch();

        for (int n = 0; n < 500; n++)
        {
            JSONLexer lexer = new JSONLexer(new ANTLRStringStream(json));

            Token t;
            while ((t = lexer.nextToken()).getType() != Token.EOF)
            {}

        }
        _logger.info("time: " + timer.getElapsedTime());

    }

    @Test
    public void testJSONTokenerPeformance() throws Exception
    {

        // generate a sample JSON array
        StringBuilder sample = new StringBuilder();
        sample.append("[");
        int i = 0;
        final int N = 5000;
        for (; i < N; i++)
        {
            sample.append(i);
            sample.append(",");
        }
        sample.append(i);
        sample.append("]");

        String json = sample.toString();

        StopWatch timer = new StopWatch();

        for (int n = 0; n < 500; n++)
        {
            JSONTokenizer tokenizer = new JSONTokenizer(json);

            parseArray(tokenizer);

        }
        _logger.info("time: " + timer.getElapsedTime());

        // i:1000, n:100   time=18.4 sec (2009.4.23 using ANTLR JSON.g)
        // i:1000, n:100   time=2.248 (2009. 4.23 using JSONTokener)

    }

    public void parseArray(JSONTokenizer tokenizer) throws JSONException
    {
        char c = tokenizer.nextClean();
        char q;
        if (c == '[')
        {
            q = ']';
        }
        else if (c == '(')
        {
            q = ')';
        }
        else
        {
            throw tokenizer.syntaxError("A JSONArray text must start with '['");
        }
        if (tokenizer.nextClean() == ']')
        {
            return;
        }
        tokenizer.back();
        for (;;)
        {
            if (tokenizer.nextClean() == ',')
            {
                tokenizer.back();
                //_array.add(null);
            }
            else
            {
                tokenizer.back();
                tokenizer.nextValue();
                //_array.add(tokenizer.nextValue());
            }
            c = tokenizer.nextClean();
            switch (c)
            {
            case ';':
            case ',':
                if (tokenizer.nextClean() == ']')
                {
                    return;
                }
                tokenizer.back();
                break;
            case ']':
            case ')':
                if (q != c)
                {
                    throw tokenizer.syntaxError("Expected a '" + new Character(q) + "'");
                }
                return;
            default:
                throw tokenizer.syntaxError("Expected a ',' or ']'");
            }
        }
    }

}
