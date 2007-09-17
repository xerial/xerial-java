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

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class StringUtilTest
{
    @Test
    public void testJoin()
    {
        Vector<String> v = new Vector<String>();
        v.add("Hello");
        v.add("World!");
        assertEquals("Hello World!", StringUtil.join(v, " "));
        v.add("SCMD");
        assertEquals("Hello, World!, SCMD", StringUtil.join(v, ", "));
    }
    
    @Test
    public void quote()
    {
        String message = "hello world";
        assertEquals("\'hello world\'", StringUtil.quote(message, StringUtil.SINGLE_QUOTE));
        assertEquals("\"hello world\"", StringUtil.quote(message, StringUtil.DOUBLE_QUOTE));
    }

    @Test
    public void contatinateWithTab()
    {
        String s = StringUtil.concatinateWithTab("hello", "world", "2005");
        assertEquals("hello\tworld\t2005", s);
    }

    
}




