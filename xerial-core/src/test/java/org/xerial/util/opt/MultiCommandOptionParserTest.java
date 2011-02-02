/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// MultiCommandOptionParserTest.java
// Since: 2011/02/02 10:41:36
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.samplemodule.Hello;

public class MultiCommandOptionParserTest {
    private static Logger _logger = Logger.getLogger(MultiCommandOptionParserTest.class);

    public static interface Validator {
        public void execute() throws Exception;

        public void validate(String output);
    }

    public static void testStdOut(Validator validator) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer);
        PrintStream defaultOut = System.out;
        System.setOut(out);
        try {
            validator.execute();
            out.flush();
            String stdOutMessage = buffer.toString();
            _logger.debug(stdOutMessage);
            validator.validate(stdOutMessage);
        }
        finally {
            System.setOut(defaultOut);
        }
    }

    @Test
    public void multiCommands() throws Exception {

        final MultiCommandOptionParser m = new MultiCommandOptionParser();
        m.addCommand(Hello.class);

        testStdOut(new Validator() {
            @Override
            public void validate(String output) {
                assertTrue(output.contains("type --help"));
            }

            @Override
            public void execute() throws Exception {
                m.displayDefaultMessage();
            }
        });

        testStdOut(new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "--help" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("-h"));
                assertTrue(output.contains("--help"));
            }
        });

        Validator v1 = new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "hello" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.startsWith("hello"));
            }

        };
        testStdOut(v1);

        testStdOut(new Validator() {

            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "hello", "world" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.startsWith("hello world"));
            }
        });

        // Test whether a new instance of the command is created for each call of execute(args);
        testStdOut(v1);

        // display help message of sub commands
        testStdOut(new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "hello", "--help" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("name"));
            }
        });

    }

    @Test
    public void loadPackage() throws Exception {
        final MultiCommandOptionParser m = new MultiCommandOptionParser();
        m.addCommandsIn(Package.getPackage("org.xerial.util.opt.samplemodule"));

        testStdOut(new Validator() {

            public void execute() throws Exception {
                m.execute(new String[] { "--help" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("hello"));
                assertTrue(output.contains("import"));
            }
        });

        testStdOut(new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "hello" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.startsWith("hello"));
            }
        });

        testStdOut(new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "import", "-i", "sample.file" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("sample.file"));
            }
        });

        testStdOut(new Validator() {

            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "--help", "import" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("-i"));
                assertTrue(output.contains("input file"));
            }
        });

    }

    @Test
    public void autoLoadModule() throws Exception {

        final MultiCommandOptionParser m = new MultiCommandOptionParser();

    }
}
