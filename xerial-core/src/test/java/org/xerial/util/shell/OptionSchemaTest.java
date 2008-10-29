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
// OptionSchemaTest.java
// Since: Oct 29, 2008 12:49:36 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.LogLevel;
import org.xerial.util.log.Logger;

public class OptionSchemaTest
{
    private static Logger _logger = Logger.getLogger(OptionSchemaTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Usage(command = "> java -jar MyProg [option ..]")
    class MyOption
    {
        @Option(symbol = "h", longName = "help", description = "display help message")
        boolean      displayHelp;

        @Option(longName = "verbose", description = "output verbose messages")
        boolean      verbose;

        @Option(symbol = "l", longName = "loglevel", varName = "LOG_LEVEL", description = "set log level: ERROR, DEBUG, WARN")
        LogLevel     logLevel;

        @Argument(name = "file", index = 1, required = false)
        List<String> fileList;

        @Argument(name = "sub_command", index = 0)
        String       subCommand;

    }

    @Test
    public void testPrintUsage() throws IOException
    {
        OptionSchema schema = OptionSchema.newOptionSchema(MyOption.class);

        assertEquals(3, schema.getOptionItemList().size());
        assertEquals(2, schema.getArgumentItemList().size());
        assertNotNull(schema.getUsage());

        StringWriter out = new StringWriter();
        out.append("\n");
        schema.printUsage(out);
        _logger.debug(out.toString());
    }

}
