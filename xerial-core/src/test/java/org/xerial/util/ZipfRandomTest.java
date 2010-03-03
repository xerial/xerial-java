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
// Xerial Raquel Project
//
// ZipfRandomTest.java
// Since: Mar 6, 2009 5:26:35 PM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/test/java/org/xerial/raquel/ZipfRandomTest.java $
// $Author: leo $
//--------------------------------------
package org.xerial.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class ZipfRandomTest {
    private static Logger _logger = Logger.getLogger(ZipfRandomTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testNextInt() {
        ZipfRandom r = new ZipfRandom(3, 100);

        for (int i = 0; i < 100; i++) {
            int v = r.nextInt();
            _logger.debug(v);
        }
    }

}
