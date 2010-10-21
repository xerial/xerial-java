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
// SilkWriterTest.java
// Since: Jul 28, 2009 12:08:53 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.Lens;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.silk.SilkWriter.FormatConfig;
import org.xerial.util.FileResource;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

public class SilkWriterTest {
    private static Logger _logger = Logger.getLogger(SilkWriterTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void toSilk() throws Exception {
        StringWriter buf = new StringWriter();
        SilkWriter w = new SilkWriter(buf);

        FormatConfig fc = new FormatConfig();
        fc.insertSpaceAfterColon = true;
        w.setFormatConfig(fc);

        w.commentLine("utgb config format");
        SilkWriter config = w.node("config").attribute("version", "1.0");
        config.leaf("project name", "utgb-shell");
        config.leaf("version", "2.0");
        config.leaf("group", "utgb");
        w.commentLine("database connection settings");

        SilkWriter dbNode = w.node("database").attribute("dbms", "sqlite")
                .attribute("scope", "debug");
        dbNode.leaf("address", "db/sample.db");

        SilkWriter t = w.tabDataSchema("gene").attribute("id").attribute("start").attribute("end");
        t.dataLine("g1\t10\t20000");
        t.dataLine("g2\t1000\t30000");

        SilkWriter g = w.node("gene").attribute("id", "g1");
        g.multilineData("sequence");
        g.dataLine("ACCGGCCGCCC");
        g.dataLine("CCGCAGGGAAA");
        w.endDocument();

        String s = buf.toString();
        _logger.debug(s);

        TreeWalkLog l1 = new TreeWalkLog();
        TreeWalkLog l2 = new TreeWalkLog();

        SilkWalker s1 = new SilkWalker(
                FileResource.open(SilkWriterTest.class, "writer-result.silk"));
        SilkWalker s2 = new SilkWalker(new StringReader(s));

        s1.walk(l1);
        s2.walk(l2);

        boolean cmp = TreeWalkLog.compare(l1, l2);
        assertTrue(cmp);
    }

    static class A {
        public String name;
        public boolean flag = true;
        public List<B> b = new ArrayList<B>();
    }

    static class B {
        public int id;
        public String type = "B";
        public List<String> item = new ArrayList<String>();

        public B(int id) {
            this.id = id;
        }

    }

    @Test
    public void toSilkObject() throws Exception {
        StringWriter buf = new StringWriter();
        SilkWriter w = new SilkWriter(buf);
        w = w.node("silk");

        A a = new A();
        a.name = "leo";
        a.b.add(new B(10));
        B b = new B(20);
        a.b.add(b);

        b.item.add("hello");
        b.item.add("world");

        a.b.add(new B(30));

        w.toSilk(a);
        w.endDocument();

        _logger.debug(buf.toString());
    }

    @Test
    public void tupleIndex() throws Exception {
        TupleIndex i = new TupleIndex(1);
        String s = Lens.toSilk(i);
        _logger.debug(s);
    }

    @Test
    public void array() throws Exception {
        ArrayList<String> input = new ArrayList<String>();
        input.add("hello");
        input.add("world");
        String s = Lens.toSilk(input);
        _logger.debug(s);
    }

    static class Person {
        public int id;
        public String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }

    @Test
    public void objectArray() throws Exception {

        /*
         * expect
         * <pre>
         * -(id:1, name:leo)
         * -(id:2, name:yui)
         * </pre>
         */
        ArrayList<Person> p = new ArrayList<Person>();
        p.add(new Person(1, "leo"));
        p.add(new Person(2, "yui"));
        String s = Lens.toSilk(p);
        _logger.info(s);
    }

    @Test
    public void sanitize() throws Exception {

        String[] v = new String[] { "this is a node(0)'s value", "this is a node, value",
                "this is a node |value|", "this is a {node} value", "this is a node*",
                "invalid value:" };

        for (String each : v) {
            String s = SilkWriter.sanitizeInLineNodeValue(each);
            assertEquals(StringUtil.doubleQuote(each), s);
        }

        String[] safe = new String[] { "this is a node value", "safe value 1.2.4" };

        for (String each : safe) {
            String s = SilkWriter.sanitizeInLineNodeValue(each);
            assertEquals(each, s);
        }

    }

    @Test
    public void escapeText() throws Exception {
        String s = SilkWriter.escapeText("-A(id:1)\n  -B");

        String[] l = s.split("\r?\n");

        assertEquals("\\-A(id:1)", l[0]);
        assertEquals("  \\-B", l[1]);

    }

    @Test
    public void escapeBackSlash() throws Exception {
        String e = SilkWriter.escapeText("\\-already escaped");
        assertEquals("\\-already escaped", e);

    }

    @Test
    public void node() throws Exception {
        StringWriter buf = new StringWriter();
        SilkWriter w = new SilkWriter(buf);
        w.node("A").node("B");
        _logger.debug(buf.toString());
    }

    @Test
    public void preamble() throws Exception {
        StringWriter buf = new StringWriter();
        SilkWriter w = new SilkWriter(buf);

        w.preamble();
        w.schema("sequence").attribute("name").attribute("length").attribute("offset");
        w.schema("sequence", "name", "length", "offset");
        w.sortInfo("sequence", "offset");
        w.node("A");
        _logger.debug(buf.toString());
    }

    @Test
    public void arrayNoNameNode() throws Exception {
        StringWriter buf = new StringWriter();
        SilkWriter w = new SilkWriter(buf);

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "leo"));
        persons.add(new Person(2, "yui"));
        w.toSilk(persons);
        w.flush();
        _logger.info(buf.toString());

    }

}
