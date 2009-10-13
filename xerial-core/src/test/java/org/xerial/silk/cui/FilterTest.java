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
// FilterTest.java
// Since: 2009/08/06 8:17:20
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilterTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testStartsWithProtocol() {
        assertTrue(Filter.startsWithProtocol("http://www.xerial.org/"));
        assertTrue(Filter.startsWithProtocol("https://www.xerial.org/"));
        assertTrue(Filter.startsWithProtocol("ftp://www.xerial.org/"));
        assertTrue(Filter.startsWithProtocol("svn+dav://www.xerial.org/"));
        assertFalse(Filter.startsWithProtocol("some/file.txt"));
    }
}