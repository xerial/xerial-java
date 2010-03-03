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
// Xerial Raquel Project
//
// Bench.java
// Since: Mar 9, 2009 10:20:13 AM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/cui/Bench.java $
// $Author: leo $
//--------------------------------------
package org.xerial.silk.cui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ZipfRandom;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.Usage;
import org.xerial.util.xml.XMLAttribute;
import org.xerial.util.xml.XMLGenerator;

/**
 * Benchmark generator
 * 
 * @author leo
 * 
 */
@Usage(command = "> raquel bench [options]")
public class Bench implements SilkCommand {
    private static Logger _logger = Logger.getLogger(Bench.class);

    // CUI options

    @Option(symbol = "a", longName = "skew", varName = "<alpha>", description = "data skew (alpha). 0 (uniform distribution), 1 (skewed), 2 (much skewed), ..")
    private int skew = 1;

    @Option(symbol = "s", longName = "scale", varName = "<factor>", description = "scaling factor. default = 0.01 (10 objects)")
    private String scalability = "0.01";

    @Option(symbol = "m", varName = "<ratio>", description = "one-to-many relationship percentage (%): 1-to-100")
    private int oneToManyPercentage = 0;

    @Option(symbol = "q", varName = "<ratio>", description = "the number of skewed column")
    private int numSkewedColumn = 3;

    @Option(symbol = "c", longName = "column", description = "column size. default=3")
    private int numColumn = 3;

    @Option(symbol = "n", longName = "cardinality", description = "cardinality of values. default = 100")
    private int cardinality = 10000;

    //    @Option(symbol = "f", longName = "fanout", description = "fanout (number of child nodes) of 1:M relationship nodes. default=2")
    //    private int fanout = 2;

    @Option(symbol = "o", description = "output file name")
    private String outputFileName = null;

    @Option(symbol = "O", description = "output to a file (file name will be automatically generated)")
    private boolean outputToFile = false;

    // local variables
    private XMLGenerator xml;
    private List<ZipfRandom> zipfDist = new ArrayList<ZipfRandom>();
    private List<String> tagName = new ArrayList<String>();
    private List<String> attributeName = new ArrayList<String>();
    private Writer out;

    public void execute() throws XerialException {
        _logger.debug(String.format("%-10s = %s", "scale", scalability));
        _logger.debug(String.format("%-10s = %d", "1:M ratio", oneToManyPercentage));
        _logger.debug(String.format("%-10s = %d", "column", numColumn));
        _logger.debug(String.format("%-10s = %d", "card", cardinality));
        _logger.debug(String.format("%-10s = %d", "skew", skew));

        xml = new XMLGenerator();

        int skewedColumnIndexMax = numSkewedColumn - 1;

        try {
            if (outputToFile) {
                String outputDir = String.format("c%d-m%d-N%d", numColumn, oneToManyPercentage,
                        cardinality);
                String outputFile = String.format("raquel-a%d-q%d-s%s.xml", skew, numSkewedColumn,
                        scalability);
                _logger.debug("output dir = " + outputDir);
                _logger.debug("output file = " + outputFile);

                File dir = new File(outputDir);
                dir.mkdirs();
                outputFileName = new File(outputDir, outputFile).getCanonicalPath();
            }

            if (outputFileName != null) {
                out = new BufferedWriter(new FileWriter(outputFileName));
                xml.setOutputWriter(out);
            }

            if (numColumn <= 0 || numColumn > 25)
                throw new XerialException(XerialErrorCode.INVALID_INPUT,
                        "column size must be between 0 and 25: " + numColumn);
            // prepare the tag names & random number generator
            for (int i = 0; i < numColumn; ++i) {
                char tagChar = (char) ('A' + i);
                String tag = Character.toString(tagChar);
                tagName.add(tag);
                attributeName.add(tag + ":value");
                double skewLevel = (numColumn - i - 1) < skewedColumnIndexMax ? skew : 0;
                _logger.debug(String.format("skewlevel = %.2f", skewLevel));
                zipfDist.add(new ZipfRandom(i * 10000, skewLevel, cardinality));
            }

            _logger.debug("tag list: " + tagName);

            xml.startTag("bench");

            // use the fixed seed value for the Zipf random number generator

            int numRelaitons = 0;
            double scalingFactor;
            try {
                scalingFactor = Double.parseDouble(scalability);
            }
            catch (NumberFormatException e) {
                throw new XerialException(XerialErrorCode.INVALID_INPUT,
                        "scalability must be double value: " + scalability);
            }

            final int numRelationsMAX = (int) (scalingFactor * 1000);
            _logger.debug("num relations = " + numRelationsMAX);

            while (numRelaitons < numRelationsMAX) {
                String value = Integer.toString(zipfDist.get(0).nextInt());
                xml.startTag(tagName.get(0), new XMLAttribute(attributeName.get(0), value));
                outputTag(tagName, 1);
                numRelaitons++;
                xml.endTag(); // first tag
            }

            xml.endTag(); // bench

            xml.endDocument();

            if (outputFileName != null) {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            }
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

    }

    void outputTag(List<String> tagList, int tagListSweepLine) {
        assert xml != null;
        assert zipfDist != null;

        if (tagListSweepLine >= tagList.size())
            return;

        String value = Integer.toString(zipfDist.get(tagListSweepLine).nextInt());
        xml.selfCloseTag(tagList.get(tagListSweepLine), new XMLAttribute(attributeName
                .get(tagListSweepLine), value));
        outputTag(tagList, tagListSweepLine + 1);
    }

    public String getName() {
        return "bench";
    }

    public String getOneLineDescription() {
        return "benchmark generator";
    }

}
