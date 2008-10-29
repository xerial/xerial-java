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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.cui.OptionParserException;

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
    public void option() throws OptionParserException
    {
        MyOption myOption = new MyOption();
        OptionParser parser = new OptionParser(myOption);
        parser.parse(new String[] { "add", "-h", "1.txt", "2.txt" });

        assertEquals("add", myOption.subCommand);
        assertTrue(myOption.displayHelp);
        assertNotNull(myOption.fileList);
        assertEquals(2, myOption.fileList.size());
        assertEquals("1.txt", myOption.fileList.get(0));
        assertEquals("2.txt", myOption.fileList.get(1));
        
    }
}
