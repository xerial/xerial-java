/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// BenchmarkTableGenerator.java
// Since: Nov 13, 2007 8:17:41 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.benchmark;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Random;

import org.xerial.core.XerialErrorCode;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;
import org.xerial.xml.XMLAttribute;
import org.xerial.xml.XMLGenerator;

/**
 * Generates Benchmark Tables
 * 
 * @author leo
 * 
 */
public class BenchmarkTableGenerator
{
    private static enum Mode {
        SIMPLE, HIERARCHICAL, RANDOM
    }

    @Option(symbol = "h", longName = "help", description = "display help message")
    private boolean displayHelp = false;
    @Option(symbol = "f", longName = "fanout", varName = "FANOUT", description = "set fanout. default=2")
    private int     fanout      = 2;

    @Option(symbol = "c", longName = "column", varName = "NUM", description = "set table column size. default = 3")
    private int     numColumn   = 4;

    @Option(symbol = "s", longName = "scalability", varName = "FACTOR", description = "scalability factor. default = 0.1")
    private double  factor      = 0.1;                               // factor * 1,000 rows will be generated

    @Option(symbol = "m", longName = "mode", varName = "MODE", description = "0: simple, 1: hierarchical, 2: random")
    private int     modeNum     = 0;

    @Option(symbol = "o", longName = "output", varName = "FILE", description = "output file name")
    private String  outFile     = null;

    private Mode    mode        = Mode.SIMPLE;

    private Writer  out         = new OutputStreamWriter(System.out);

    private static enum Opt {
        HELP, FANOUT, COLUMN, SCALABILITY_FACTOR, MODE, OUTPUT
    }

    private boolean      isReady      = true;

    private OptionParser optionParser = new OptionParser(this);

    public BenchmarkTableGenerator(String[] args) throws OptionParserException {
        optionParser.parse(args);
        if (displayHelp) {
            optionParser.printUsage();
            isReady = false;
        }

        switch (modeNum) {
        case 0:
            mode = Mode.SIMPLE;
            break;
        case 1:
            mode = Mode.HIERARCHICAL;
            break;
        case 2:
            mode = Mode.RANDOM;
            break;
        default:
            throw new OptionParserException(XerialErrorCode.PARSE_ERROR, "Unknown mode: " + modeNum);
        }

        if (outFile != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
                out = writer;
            }
            catch (IOException e) {
                throw new OptionParserException(XerialErrorCode.IO_EXCEPTION, e);
            }
        }

    }

    private String[] colName;

    public void generate() throws IOException {
        colName = new String[numColumn + 1];
        colName[0] = "item";
        for (int i = 1; i < colName.length; i++) {
            char c = (char) ('a' + i - 1);
            colName[i] = String.valueOf(c);
        }

        XMLGenerator xmlOut = new XMLGenerator(out);
        xmlOut.startTag("table");

        int numRow = (int) (factor * 1000);
        switch (mode) {
        case SIMPLE:
            Simple s = new Simple(numRow, xmlOut);
            s.generate();
            break;
        case HIERARCHICAL:
            Hierarchical h = new Hierarchical(numRow, xmlOut);
            h.generate();
            break;
        case RANDOM:
            RandomGen r = new RandomGen(numRow, xmlOut);
            r.generate();
            break;
        }
        xmlOut.endTag();
        xmlOut.endDocument();
        xmlOut.flush();
        out.close();
    }

    public String getColName(int colIndex) {
        return colName[colIndex];
    }

    public class Hierarchical
    {
        int          numRow;
        XMLGenerator xmlOut;

        public Hierarchical(int numRow, XMLGenerator xmlOut) {
            this.numRow = numRow;
            this.xmlOut = xmlOut;

            int treeSize = (int) (Math.pow(fanout, numColumn));
            int numTree = numRow / treeSize + (numRow % treeSize == 0 ? 0 : 1);
        }

        public void generate() {
            int offset = 0;
            while (numRow > 0) {
                process(0, offset++);
            }
        }

        private void process(int col, int offset) {
            if (col >= numColumn) {
                xmlOut.flush();
                numRow--;
                return;
            }

            int numChildren = (col == 0) ? 1 : fanout;
            for (int f = 0; f < numChildren; f++) {
                xmlOut.startTag(getColName(col), new XMLAttribute("value", f + 1 + offset));
                process(col + 1, 0);
                xmlOut.endTag();
                if (numRow <= 0)
                    return;
            }

        }
    }

    public class RandomGen
    {
        int          numRow;
        XMLGenerator xmlOut;
        Random       r = new Random(40);

        public RandomGen(int numRow, XMLGenerator xmlOut) {
            this.numRow = numRow;
            this.xmlOut = xmlOut;

            int treeSize = (int) (Math.pow(fanout, numColumn));
            int numTree = numRow / treeSize + (numRow % treeSize == 0 ? 0 : 1);
        }

        class Element
        {
            int col;
            int value;

            public Element(int col, int value) {
                super();
                this.col = col;
                this.value = value;
            }
        }

        private boolean canHaveMulpleNodes(LinkedList<Integer> randomOrder, int index) {
            int currentColumn = randomOrder.get(index);
            int maxInFirstHalf = -1;
            for (int i = 0; i < index; i++) {
                int column = randomOrder.get(i);
                if (column > currentColumn)
                    return false;
                if (maxInFirstHalf < column)
                    maxInFirstHalf = column;
            }
            for (int i = index + 1; i < randomOrder.size(); i++) {
                if (maxInFirstHalf > randomOrder.get(i))
                    return false;
            }
            return true;
        }

        private int smallestFDColumnIndex(LinkedList<Integer> randomOrder, int index) {

            for (int i = 0; i < index; i++) {
                int column = randomOrder.get(i);
                for (int j = randomOrder.size() - 1; j >= index; j--) {
                    int currentColumn = randomOrder.get(j);
                    if (column > currentColumn) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public void generate() {
            int offset = 0;
            while (numRow > 0) {
                LinkedList<Integer> colSet = new LinkedList<Integer>();
                for (int i = 1; i < numColumn; i++) {
                    colSet.add(i);
                }
                LinkedList<Integer> randomOrder = new LinkedList<Integer>();
                while (!colSet.isEmpty()) {
                    int targetIndex = r.nextInt(colSet.size());
                    int targetCol = colSet.remove(targetIndex);
                    randomOrder.add(targetCol);
                }
                xmlOut.startTag("item", new XMLAttribute("value", ++offset));
                process(randomOrder, 0, new LinkedList<Element>());
                xmlOut.endTag();
            }
        }

        private void process(LinkedList<Integer> randomOrder, int cursor, LinkedList<Element> elementStack)

        {
            if (cursor >= randomOrder.size()) {
                numRow--;
                return;
            }

            int currentColumn = randomOrder.get(cursor);
            int smallestFDColumnIndex = smallestFDColumnIndex(randomOrder, cursor);
            if (smallestFDColumnIndex == -1)
                smallestFDColumnIndex = cursor;
            for (int f = 0; f < fanout; f++) {
                Element e = new Element(currentColumn, f + 1);
                elementStack.add(e);
                xmlOut.startTag(getColName(e.col), new XMLAttribute("value", e.value));
                process(randomOrder, cursor + 1, elementStack);
                xmlOut.endTag();
                if (numRow <= 0) {
                    elementStack.removeLast();
                    break;
                }
                else {
                    if (f < (fanout - 1)) {
                        for (int i = cursor - 1; i >= smallestFDColumnIndex; i--) {
                            xmlOut.endTag();
                        }
                        for (int i = smallestFDColumnIndex; i < cursor; i++) {
                            Element e2 = elementStack.get(i);
                            xmlOut.startTag(getColName(e2.col), new XMLAttribute("value", e2.value));
                        }
                    }
                }
                elementStack.removeLast();
            }
        }
    }

    public class Simple
    {
        int          numRow;
        XMLGenerator xmlOut;
        int[]        value = new int[numColumn];

        public Simple(int numRow, XMLGenerator xmlOut) {
            this.numRow = numRow;
            this.xmlOut = xmlOut;

            for (int i = 0; i < value.length; i++)
                value[i] = 1;

            int treeSize = (int) (Math.pow(fanout, (double) numColumn - 1));
            int numTree = numRow / treeSize + (numRow % treeSize == 0 ? 0 : 1);
        }

        public void generate() {
            int offset = 0;
            while (numRow > 0) {
                xmlOut.startTag("item", new XMLAttribute("value", ++offset));
                process(1);
                xmlOut.endTag();
            }
        }

        private void process(int col) {
            if (numRow <= 0)
                return;

            if (col >= numColumn) {
                for (int c = 1; c < numColumn; c++)
                    xmlOut.startTag(getColName(c), new XMLAttribute("value", value[c]));
                for (int c = 1; c < numColumn; c++)
                    xmlOut.endTag();
                xmlOut.flush();
                numRow--;
                return;
            }

            int numChildren = (col == 0) ? 1 : fanout;
            for (int f = 0; f < numChildren; f++) {
                value[col] = f + 1;
                process(col + 1);

            }

        }
    }

    public static void main(String[] args) {
        try {
            BenchmarkTableGenerator btg = new BenchmarkTableGenerator(args);
            if (btg.isReady)
                btg.generate();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
