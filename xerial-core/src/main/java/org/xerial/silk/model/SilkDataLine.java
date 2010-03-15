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
// SilkDataLine.java
// Since: Feb 2, 2009 11:16:05 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.model;


/**
 * dataline
 * 
 * @author leo
 * 
 */
public class SilkDataLine implements SilkElement {
    private int indentLength = -1; // -1 means not computed
    private final String dataLine;

    public SilkDataLine(String dataLine) {
        this.dataLine = dataLine;
    }

    public int getIndentLength() {
        if (indentLength == -1) {
            int len = dataLine.length();
            int st = 0;

            while ((st < len) && (dataLine.charAt(st) <= ' ')) {
                st++;
            }
            indentLength = st;
        }
        return indentLength;
    }

    /**
     * get the original data line as is (including line-end comments)
     * 
     * @return the original data line w/o modification
     */
    public String getDataLine() {
        return dataLine;
    }

    /**
     * Get the trimmed data line (without line-end comments)
     * 
     * @return
     */
    public String getTrimmedDataLine() {
        return sanitizeDataLine(dataLine.trim());
    }

    private static String sanitizeDataLine(String line) {
        if (line.startsWith("\\"))
            return line.substring(1);
        else
            return line;
    }

    //    private static Pattern lineCommentPattern = Pattern
    //            .compile("[^\"]*(\\\"[^\"]*\\\")*[^\"]*(#.*)");

    //    public static String removeLineComment(String line) {
    //        if (!line.contains("#"))
    //            return line;
    //
    //        Matcher m = lineCommentPattern.matcher(line);
    //        if (m.matches()) {
    //            int lineCommentStart = m.start(2);
    //            if (lineCommentStart != -1)
    //                line = line.substring(0, lineCommentStart);
    //        }
    //        return line;
    //    }

    @Override
    public String toString() {
        return dataLine;
    }
}
