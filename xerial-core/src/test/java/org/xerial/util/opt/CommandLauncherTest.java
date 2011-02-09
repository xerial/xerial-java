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
import org.xerial.util.opt.samplemodule.FindModule;
import org.xerial.util.opt.samplemodule.Hello;

public class CommandLauncherTest {
    private static Logger _logger = Logger.getLogger(CommandLauncherTest.class);

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
            _logger.debug("\n" + stdOutMessage);
            validator.validate(stdOutMessage);
        }
        finally {
            System.setOut(defaultOut);
        }
    }

    @Test
    public void addCommand() throws Exception {

        final CommandLauncher m = new CommandLauncher();
        m.addCommand(Hello.class);

        testStdOut(new Validator() {
            @Override
            public void validate(String output) {
                assertTrue(output.contains("type --help"));
            }

            @Override
            public void execute() throws Exception {
                m.execute(new String[] {});
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
                assertTrue(!output.contains("world"));
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

    }

    @Test
    public void addPackage() throws Exception {

        final CommandLauncher m = new CommandLauncher();
        m.addCommandsIn(Hello.class.getPackage());

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
    public void recursive() throws Exception {
        final CommandLauncher m = new CommandLauncher();
        m.addCommandsIn(Hello.class.getPackage(), true);
        testStdOut(new Validator() {

            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "hello2" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("HELLO"));
            }
        });

        testStdOut(new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "hello" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("hello"));
            }
        });

        testStdOut(new Validator() {
            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "--help" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("hello2"));
            }
        });
    }

    @Test
    public void moduleTest() throws Exception {
        final CommandLauncher m = new CommandLauncher();
        m.addModule(new FindModule());

        testStdOut(new Validator() {

            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "--help" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("find"));
            }
        });

        testStdOut(new Validator() {

            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "find", "--help" });
            }

            @Override
            public void validate(String output) {
                assertTrue(output.contains("import"));
            }
        });

        testStdOut(new Validator() {

            @Override
            public void execute() throws Exception {
                m.execute(new String[] { "find", "import", "-i", "sample.file" });
            }

            @Override
            public void validate(String output) {
                output.contains("sample.file");
            }
        });

    }

    @Test
    public void setHelpMessage() throws Exception {
        final CommandLauncher m = new CommandLauncher();

    }

}
