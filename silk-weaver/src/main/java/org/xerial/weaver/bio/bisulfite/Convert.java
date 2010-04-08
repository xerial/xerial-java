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
// Xerial Silk Weaver Project 
//
// Convert.java
// Since: 2009/07/22 14:09:16
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.bio.bisulfite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.Usage;
import org.xerial.weaver.bio.bisulfite.BisulfiteSequence.ConversionType;
import org.xerial.weaver.core.cui.SilkWeaverCommand;
import org.xerial.weaver.core.cui.SilkWeaverModule;

/**
 * Sequence converter
 * 
 * @author leo
 * 
 */
@Usage(command = "convert", description = "convert the sequence in the input fasta file from C->T or G->A")
public class Convert implements SilkWeaverCommand {

    private static Logger _logger = Logger.getLogger(Convert.class);

    @Argument(index = 0, name = "(input FASTA file)")
    private String inputFastaFile = null;

    @Option(symbol = "t", longName = "type", varName = "CtoT|GtoA", description = "conversion type: CtoT (default) or GtoA")
    private ConversionType conversionType = ConversionType.CtoT;

    @Option(symbol = "o", description = "specify the output file (default output is STDOUT)")
    private String outputFile = null;

    public void execute(SilkWeaverModule module, String[] unusedArgs) throws Exception {

        if (inputFastaFile == null) {
            System.err.println("no input FASTA file");
            return;
        }

        _logger.info("input file: " + inputFastaFile);

        if (!new File(inputFastaFile).exists()) {
            System.err.println("file doesn't exist: " + inputFastaFile);
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFastaFile));

        Writer output = new OutputStreamWriter(System.out);
        if (outputFile != null) {
            File out = new File(outputFile);
            File parent = out.getParentFile();
            if (parent != null)
                parent.mkdirs();

            output = new BufferedWriter(new FileWriter(out));
            _logger.info("output file: " + out);
        }

        _logger.info("conversion type: " + conversionType);
        try {

            switch (conversionType) {
            case CtoT:
                BisulfiteSequence.convertCtoT(reader, output);
                break;
            case GtoA:
                BisulfiteSequence.convertGtoA(reader, output);
                break;
            }
        }
        finally {
            if (outputFile != null)
                output.close(); // close except the stdout
        }

    }

    public String getCommandName() {
        return "convert";
    }

    public String getOneLineDescription() {
        return "convert input fasta sequence from C->T or G->A";
    }

}
