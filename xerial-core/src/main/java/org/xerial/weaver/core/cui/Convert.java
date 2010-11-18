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
// Convert.java
// Since: Sep 22, 2010 11:27:53 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xerial.lens.relation.schema.RelationSchema;
import org.xerial.silk.SilkParser;
import org.xerial.util.io.StandardInputStream;
import org.xerial.util.io.StandardOutputStream;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.tree.TreeEventHandler;

public class Convert implements SilkWeaverCommand {

    private static Logger _logger = Logger.getLogger(Convert.class);

    @Argument(index = 0, required = false)
    private String input = "-";

    @Argument(index = 1, required = false)
    private String output = "-";

    @Override
    public int execute(SilkWeaverModule module, String[] args) throws Exception {

        // prepare the parser
        SilkParser parser = null;
        if ("-".equals(input)) {
            // use standard input
            parser = new SilkParser(new StandardInputStream());
        }
        else {
            // open file
            _logger.info("input: " + input);
            parser = new SilkParser(new File(input));
        }

        // prepre the output
        OutputStream out = null;
        if ("-".equals(output)) {
            // use standard output
            out = new StandardOutputStream();
        }
        else {
            _logger.info("output: " + output);
            out = new FileOutputStream(output);
        }
        // wrap the output stream with a buffer
        out = new BufferedOutputStream(out);

        parser.parse(new TreeEventHandler() {

            @Override
            public void init() throws Exception {
                _logger.info("start parsing");
            }

            @Override
            public void visitNode(String nodeName, String immediateNodeValue) throws Exception {
                if (_logger.isDebugEnabled())
                    _logger.debug(String.format("visit %s:%s", nodeName, immediateNodeValue));
            }

            @Override
            public void text(String nodeName, String textDataFragment) throws Exception {
                if (_logger.isDebugEnabled())
                    _logger.debug(String.format("text  %s:%s", nodeName, textDataFragment));
            }

            @Override
            public void schema(RelationSchema schema) throws Exception {

            }

            @Override
            public void leaveNode(String nodeName) throws Exception {

            }

            @Override
            public void finish() throws Exception {
                _logger.info("parsing finished");
            }
        });

        return ReturnCode.SUCCESS.toInt();
    }

    @Override
    public String getCommandName() {
        return "convert";
    }

    @Override
    public String getOneLineDescription() {
        return "convert Silk data into a binary format";
    }

}
