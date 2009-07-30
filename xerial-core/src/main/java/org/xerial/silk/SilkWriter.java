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
// SilkWriter.java
// Since: May 28, 2009 5:04:34 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.xerial.util.ArrayDeque;

/**
 * Supporting class for generating Silk data. This class is not thread-safe,
 * i.e, concurrent access to this class may cause invalid Silk format.
 * 
 * 
 * @author leo
 * 
 */
public class SilkWriter {
    private final PrintWriter out;
    private ArrayDeque<String> nodeStack = new ArrayDeque<String>();
    private Config config = new Config();

    public static class Config {
        public int indentWidth = 2;

        public boolean indentBeforeDataLine = false;
    }

    public SilkWriter(Writer out) {
        this.out = new PrintWriter(out);
    }

    public SilkWriter(OutputStream out) {
        this.out = new PrintWriter(new OutputStreamWriter(out));
    }

    public void flush() {
        this.out.flush();
    }

    public void close() {
        this.out.close();
    }

    public void resetContext() {
        nodeStack.clear();
    }

    public SilkWriter preamble() {
        out.println("%silk(version:1.0)");
        return this;
    }

    private void printIndent() {
        for (int i = 0; i < nodeStack.size(); ++i) {
            for (int w = 0; w < config.indentWidth; ++w)
                out.append(" ");
        }
    }

    public SilkWriter node(String nodeName) {

        printIndent();
        out.print("-");
        out.println(nodeName);

        pushContext(nodeName);

        return this;
    }

    public SilkWriter node(String nodeName, String nodeValue) {
        printIndent();
        out.print("-");
        out.print(nodeName);
        out.print(":");
        out.println(nodeValue);
        pushContext(nodeName);
        return this;
    }

    public SilkNodeWriter startContext(String nodeName) {
        printIndent();
        return new SilkNodeWriter(this, nodeName, null);
    }

    public SilkWriter inlineNode(String nodeName, String value) {

        out.print(nodeName);
        if (value != null) {
            out.print(":");
            out.print(value);
        }
        return this;
    }

    SilkWriter comma() {
        out.print(",");
        return this;
    }

    private void pushContext(String nodeName) {
        nodeStack.addLast(nodeName);
    }

    public SilkWriter leaveNode() {
        nodeStack.removeLast();
        return this;
    }

    public SilkWriter dataLine(String dataLine) {

        if (config.indentBeforeDataLine)
            printIndent();

        out.println(escapeDataLine(dataLine));

        return this;
    }

    private String escapeDataLine(String dataLine) {

        if (dataLine.startsWith("-")) {
            StringBuilder buf = new StringBuilder();
            buf.append("\\");
            buf.append(dataLine);
            return buf.toString();
        }

        // no change
        return dataLine;
    }

}
