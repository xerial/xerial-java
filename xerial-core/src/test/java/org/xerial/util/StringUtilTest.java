/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XerialJ Project
//
// StringUtilTest.java
// Since: 2007/03/27
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/test/org/utgenome/util/StringUtilTest.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testJoin() {
        Vector<String> v = new Vector<String>();
        v.add("Hello");
        v.add("World!");
        assertEquals("Hello World!", StringUtil.join(v, " "));
        v.add("SCMD");
        assertEquals("Hello, World!, SCMD", StringUtil.join(v, ", "));
    }

    @Test
    public void quote() {
        String message = "hello world";
        assertEquals("\'hello world\'", StringUtil.quote(message, StringUtil.SINGLE_QUOTE));
        assertEquals("\"hello world\"", StringUtil.quote(message, StringUtil.DOUBLE_QUOTE));
    }

    @Test
    public void contatinateWithTab() {
        String s = StringUtil.concatinateWithTab("hello", "world", "2005");
        assertEquals("hello\tworld\t2005", s);
    }

    @Test
    public void splitAtTab() {
        ArrayList<String> elems = StringUtil.splitAtTab("hello\tworld\tleo");

        assertEquals(3, elems.size());
        assertEquals("hello", elems.get(0));
        assertEquals("world", elems.get(1));
        assertEquals("leo", elems.get(2));

        ArrayList<String> elems2 = StringUtil.splitAtTab("hello\tworld\t\tleo");
        assertEquals(4, elems2.size());
        assertEquals("hello", elems2.get(0));
        assertEquals("world", elems2.get(1));
        assertEquals("", elems2.get(2));
        assertEquals("leo", elems2.get(3));

        ArrayList<String> elems3 = StringUtil.splitAtTab("hello\tworld\tleo\t");
        assertEquals(4, elems3.size());
        assertEquals("hello", elems3.get(0));
        assertEquals("world", elems3.get(1));
        assertEquals("leo", elems3.get(2));
        assertEquals("", elems3.get(3));

    }

    @Test
    public void splitCSV() throws Exception {
        ArrayList<String> e = StringUtil.splitCSV("\"hello, world\",leo");
        assertEquals(2, e.size());
        assertEquals("hello, world", e.get(0));
        assertEquals("leo", e.get(1));
    }

    @Test
    public void var2nat() throws Exception {
        assertEquals("hello world", StringUtil.varNameToNaturalName("helloWorld"));
        assertEquals("XML string", StringUtil.varNameToNaturalName("XML_String"));
        assertEquals("param name", StringUtil.varNameToNaturalName("paramName"));
        assertEquals("allow TAB in var name", StringUtil.varNameToNaturalName("allowTABinVarName"));
        assertEquals("wiki name like var name", StringUtil
                .varNameToNaturalName("WikiNameLikeVarName"));

        assertEquals("wiki name like var name", StringUtil
                .varNameToNaturalName("Wiki Name Like Var Name"));

        assertEquals("var arg01", StringUtil.varNameToNaturalName("var_arg01"));
        assertEquals("para1", StringUtil.varNameToNaturalName("para1"));

    }

}
