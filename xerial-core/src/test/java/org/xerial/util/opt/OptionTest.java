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
// OptionTest.java
// Since: Oct 27, 2008 11:34:49 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;

public class OptionTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    class MyOption
    {
        @Option(symbol = "h", longName = "help", description = "display help message")
        boolean displayHelpMessage = false;

        @Argument
        ArrayList<String> files = new ArrayList<String>();

    }

    @Test
    public void constructor()
    {

    }

}
