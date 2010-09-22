/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// ConvertTest.java
// Since: Sep 22, 2010 11:33:26 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertTest {

    @Test
    public void testConvertHelp() throws Exception {

        assertEquals(0, SilkWeaverMain.execute(new String[] { "convert", "--help" }));

    }

}
