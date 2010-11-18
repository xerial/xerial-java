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
// SilkWeaverMainTest.java
// Since: 2009/07/22 11:45:26
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;
import org.xerial.weaver.core.cui.SilkWeaverMain;

public class SilkWeaverMainTest {

    private static Logger _logger = Logger.getLogger(SilkWeaverMainTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void programInfo() throws Exception {
        assertTrue(SilkWeaverMain.execute(new String[] {}) == 0);
    }

    @Test
    public void helpCommand() throws Exception {
        assertTrue(SilkWeaverMain.execute(new String[] { "--help" }) == 0);
    }

    @Test
    public void help() throws Exception {
        assertEquals(0, SilkWeaverMain.execute(new String[] { "help", "--help" }));
    }

}
