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
// Xerial Silk Weaver Project 
//
// FASTAPullParserTest.java
// Since: Jul 21, 2009 4:19:13 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.bio.fasta;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FASTAPullParserTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void pullParsing() throws Exception {
        FASTAPullParser parser = new FASTAPullParser(new StringReader(
                ">1|mySeq\nACGCTT\nACCC\n>2\nCCGGA"));
        FASTASequence s1 = parser.nextSequence();
        FASTASequence s2 = parser.nextSequence();

        assertNotNull(s1);
        assertNotNull(s2);
        assertEquals("ACGCTTACCC", s1.getSequence());
        assertEquals("CCGGA", s2.getSequence());

        assertEquals(2, s1.getDescriptionSize());
        assertEquals("1", s1.getDescription(0));
        assertEquals("mySeq", s1.getDescription(1));
        assertEquals(1, s2.getDescriptionSize());
        assertEquals("2", s2.getDescription(0));

        FASTASequence s3 = parser.nextSequence();
        assertNull(s3);
    }

    @Test
    public void pullParsing2() throws Exception {
        FASTAPullParser parser = new FASTAPullParser(new StringReader(
                ">1|mySeq\nACGCTT\nACCC\n>2\nCCGGA"));

        assertEquals("1|mySeq", parser.nextDescriptionLine());
        assertEquals("ACGCTT", parser.nextSequenceLine());
        assertEquals("ACCC", parser.nextSequenceLine());
        assertNull(parser.nextSequenceLine());

        assertEquals("2", parser.nextDescriptionLine());
        assertEquals("CCGGA", parser.nextSequenceLine());
        assertNull(parser.nextSequenceLine());

    }

}
