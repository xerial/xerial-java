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
// XerialJ
//
// Filter.java
// Since: 2009/08/06 8:09:25
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core.cui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;

import org.xerial.json.JSONTreeParser;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.TupleVisitor;
import org.xerial.lens.relation.lang.RelationExpr;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.RelationExtractor;
import org.xerial.lens.relation.query.RelationHandler;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.silk.SilkEnv;
import org.xerial.silk.SilkParser;
import org.xerial.util.FileType;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.Usage;
import org.xerial.util.text.TabAsTreeParser;
import org.xerial.util.tree.TreeParser;
import org.xerial.util.xml.XMLTreeParser;

@Usage(command = "filter")
public class Filter implements XerialCommand {

    private static Logger _logger = Logger.getLogger(Filter.class);

    //    static enum FileType {
    //        Silk, XML, JSON, Tab, AUTO
    //    }

    @Argument(index = 0)
    public String inputResource = "-";

    @Argument(index = 1)
    public String query = null;

    @Option(symbol = "d", description = "column delimiter")
    public String splitChar = "\t";

    @Option(symbol = "t", description = "input file type")
    public FileType inputFileType = FileType.SILK;

    private final PrintStream out = System.out;

    public void execute() throws Exception {

        if (query == null) {
            _logger.error("no query is given");
            return;
        }

        // input 
        Reader in = null;
        if (inputResource.equals("-")) {
            in = new InputStreamReader(System.in);
            _logger.info("read data from STDIN");
        }
        else {
            inputFileType = FileType.getFileType(inputResource);

            if (startsWithProtocol(inputResource)) {
                URL inputURL = new URL(inputResource);
                _logger.info("read from resource: " + inputResource);
                in = new BufferedReader(new InputStreamReader(inputURL.openStream()));
            }
            else {
                _logger.info("read from file: " + inputResource);
                in = new BufferedReader(new FileReader(inputResource));
            }
        }

        RelationExpr expr = RelationExpr.parse(query);
        QuerySet qs = expr.buildQuerySet();
        _logger.debug("query set: " + qs);

        TreeParser treeInput = null;

        switch (inputFileType) {
        case SILK:
            treeInput = new SilkParser(in, SilkEnv.newEnv(inputResource));
            break;
        case XML:
            treeInput = new XMLTreeParser(in);
            break;
        case JSON:
            treeInput = new JSONTreeParser(in);
            break;
        case TAB:
            treeInput = new TabAsTreeParser(in);
            break;
        case CSV:
            treeInput = new TabAsTreeParser(in, ',');
            break;
        // TODO fasta file support
        //        case FASTA:
        //            break;
        default:
            _logger.warn("unknown file type: " + inputFileType);
            _logger.warn("using silk type, instead");
            inputFileType = FileType.SILK;
            break;
        }

        RelationExtractor.run(qs, treeInput, new RelationHandler() {

            public void relation(Schema s, Tuple<Node> relation) {
                TupleFormatter f = new TupleFormatter();
                relation.accept(f);

                System.out.println(StringUtil.join(f.elem, splitChar));
            }
        });

    }

    private static class TupleFormatter implements TupleVisitor<Node> {

        ArrayList<String> elem = new ArrayList<String>();

        public void visitNode(Node node) {
            elem.add(node.nodeValue == null ? Long.toString(node.nodeID) : node.nodeValue);
        }

        public void visitTuple(Tuple<Node> tuple) {
            for (TupleElement<Node> each : tuple) {
                each.accept(this);
            }
        }
    }

    public static boolean startsWithProtocol(String resourceName) {
        if (resourceName == null)
            return false;

        return resourceName.matches("^[A-za-z0-9+]+://.*");
    }

    public String getName() {
        return "filter";
    }

    public String getOneLineDescription() {
        return "extract relation from the data";
    }

}
