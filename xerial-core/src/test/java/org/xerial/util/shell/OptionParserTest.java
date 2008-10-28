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
// OptionParserTest.java
// Since: Oct 28, 2008 4:44:53 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OptionParserTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    class MyOption
    {
        @Option(name = "h", longName = "help", description = "display help message")
        boolean      displayHelp;

        @Argument(description = "sub command name", index = 0)
        String       subCommand;

        @Argument(description = "input files ...", index = 1, required = true)
        List<String> fileList;
    }

    @Test
    public void option()
    {
        MyOption myOption = new MyOption();
        OptionParser parser = new OptionParser(myOption);
        parser.parse(new String[] { "", "" });
    }
}
