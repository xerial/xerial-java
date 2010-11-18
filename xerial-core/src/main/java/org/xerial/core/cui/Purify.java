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
 *  WITHOUT WARRANTI\ES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// Xerial Raquel Project
//
// Purify.java
// Since: Mar 9, 2009 2:40:49 PM
//
// $URL: http://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/cui/Purify.java $
// $Author: leo $
//--------------------------------------
package org.xerial.core.cui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

import org.xerial.core.XerialErrorCode;
import org.xerial.lens.relation.ContainerManager;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.RelationStreamCollector;
import org.xerial.lens.relation.query.StreamAmoebaJoin;
import org.xerial.lens.relation.schema.RelationSchema;
import org.xerial.lens.relation.schema.SchemaSet;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParserException;
import org.xerial.util.opt.Usage;
import org.xerial.util.text.TabAsTreeParser;
import org.xerial.xml.RaquelXMLBuilder;
import org.xerial.xml.XMLTreeParser;

/**
 * Alternative XML structure generator
 * 
 * @author leo
 * 
 */
@Usage(command = "> silk purify", description = "generate alternative XML structure")
public class Purify implements XerialCommand {
    private static Logger _logger = Logger.getLogger(Purify.class);

    /**
     * Translation mode
     * 
     * @author leo
     * 
     */
    public static enum Mode {
        FLAT, SIMPLE, ADAPTIVE
    }

    // command-line options 
    @Argument(index = 0, name = "input XML file", required = false)
    private String inputXMLFile;

    //    @Option(symbol = "m", longName = "mode", description = "mode: simple (default), flat or adaptive.")
    //    private final Mode mode = Mode.SIMPLE;

    @Option(symbol = "s", longName = "schema", description = "raquel schema file.")
    private final String schemaFile = null;

    @Option(symbol = "i", description = "read from STDIN")
    boolean readFromSTDIN = false;

    @Option(symbol = "c", longName = "cache", varName = "MBytes", description = "cache size in M bytes")
    private int cacheMbytes = 64;

    @Option(symbol = "t", description = "use tab-separated data as an input")
    private boolean useTabSeparatedData = false;

    @Option(symbol = "o", description = "output file name")
    String outputFileName = null;

    @Option(longName = "indent", description = "indent level. default = 0")
    int indentLevel = 0;

    @Option(symbol = "q", description = "query only mode")
    boolean queryOnly = false;

    Writer out = null;

    public void execute() throws Exception {

        if (schemaFile == null)
            throw new OptionParserException(XerialErrorCode.INVALID_ARGUMENT, "no shcema file");

        Reader schemaReader = new FileReader(schemaFile);

        Reader input = null;
        if (readFromSTDIN) {
            input = new BufferedReader(new InputStreamReader(System.in));
        }
        else {
            if (inputXMLFile == null)
                throw new OptionParserException(XerialErrorCode.INVALID_ARGUMENT,
                        "no input XML file");

            input = new BufferedReader(new FileReader(inputXMLFile));
        }

        // Retrieve relations in XML
        StopWatch timer = new StopWatch();
        ContainerManager storage = new ContainerManager(cacheMbytes * 1024 * 1024);
        SchemaSet schema = new SchemaSet(RelationSchema.parse(schemaReader));
        QuerySet qs = new QuerySet(schema);
        RelationStreamCollector rp = new RelationStreamCollector(qs, storage);
        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, rp);
        timer.reset();

        if (!useTabSeparatedData)
            aj.sweep(new XMLTreeParser(input, true));
        else
            aj.sweep(new TabAsTreeParser(input));

        double queryTime = timer.getElapsedTime();
        _logger.debug("query time: " + queryTime + " sec.");

        // Build XML
        timer.reset();
        RaquelXMLBuilder builder = new RaquelXMLBuilder(storage, schema);
        if (outputFileName != null) {
            _logger.debug("output file name: ");
            builder.setOutput(out = new BufferedWriter(new FileWriter(outputFileName)));
        }
        builder.setIndentLevel(indentLevel);
        builder.build();

        double buildTime = timer.getElapsedTime();
        _logger.debug("build time: " + buildTime + " sec.");

        // discard the temporary storage
        storage.dispose();

        if (out != null) {
            out.close();
        }

    }

    public String getName() {
        return "purify";
    }

    public String getOneLineDescription() {
        return "generate alternative XML structure";
    }

}
