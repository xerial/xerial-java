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
// BisulfiteSequence.java
// Since: Jul 21, 2009 4:13:41 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.bio.bisulfite;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.xerial.weaver.bio.fasta.FASTAPullParser;

/**
 * @author leo
 * 
 */
public class BisulfiteSequence {

    private static Map<Character, Character> conversionTableFromCtoT = new HashMap<Character, Character>();
    private static Map<Character, Character> conversionTableFromGtoA = new HashMap<Character, Character>();

    static {
        conversionTableFromCtoT.put('c', 't');
        conversionTableFromCtoT.put('C', 'T');

        conversionTableFromGtoA.put('g', 'a');
        conversionTableFromGtoA.put('G', 'A');
    }

    public static enum ConversionType {
        CtoT, GtoA
    };

    /**
     * Convert the nucleotides C to T contained in the input FASTA file.
     * 
     * @param fastaFile
     * @param output
     * @throws IOException
     */
    public static void convertCtoT(Reader fastaFile, Writer output) throws IOException {
        convert(fastaFile, output, conversionTableFromCtoT);
    }

    /**
     * Convert the nucleotides G to A contained in the input FASTA file.
     * 
     * @param fastaFile
     * @param output
     * @throws IOException
     */
    public static void convertGtoA(Reader fastaFile, Writer output) throws IOException {
        convert(fastaFile, output, conversionTableFromGtoA);
    }

    public static String convertCtoT(String sequence) {
        return convert(sequence, ConversionType.CtoT);
    }

    public static String convertGtoA(String sequence) {
        return convert(sequence, ConversionType.GtoA);
    }

    public static String convert(String sequence, ConversionType type) {
        Map<Character, Character> conversionTable = null;
        switch (type) {
        case CtoT:
            conversionTable = conversionTableFromCtoT;
            break;
        case GtoA:
            conversionTable = conversionTableFromGtoA;
        default:
            break;
        }

        return convert(sequence, conversionTable);
    }

    public static String convert(String sequence, Map<Character, Character> conversionTable) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < sequence.length(); ++i) {
            char ch = sequence.charAt(i);

            Character converted = conversionTable.get(ch);
            if (converted != null)
                buf.append(converted);
            else
                buf.append(ch);
        }
        return buf.toString();
    }

    private static void convert(Reader fastaFile, Writer output,
            Map<Character, Character> conversionTable) throws IOException {
        PrintWriter out = new PrintWriter(output);
        FASTAPullParser fasta = new FASTAPullParser(fastaFile);

        String desc;
        while ((desc = fasta.nextDescriptionLine()) != null) {
            out.print(">");
            out.println(desc);

            String sequenceLine;
            while ((sequenceLine = fasta.nextSequenceLine()) != null) {
                out.println(convert(sequenceLine, conversionTable));
            }
        }
        out.flush();

    }
}
