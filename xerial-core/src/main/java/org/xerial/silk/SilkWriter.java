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

    private final SilkWriter parent;
    private final PrintWriter out;
    private ArrayDeque<String> nodeStack = new ArrayDeque<String>();
    private Config config = new Config();
    private final int levelOffset;

    public static class Config {
        public int indentWidth = 2;

        public boolean indentBeforeDataLine = false;
    }

    public SilkWriter(Writer out) {
        this.out = new PrintWriter(out);
        this.parent = null;
        this.levelOffset = 0;
    }

    public SilkWriter(OutputStream out) {
        this(new PrintWriter(new OutputStreamWriter(out)));
    }

    private SilkWriter(SilkWriter parent) {
        this.parent = parent;
        this.out = parent.out;
        this.levelOffset = parent.nodeStack.size();
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

    public SilkWriter comment(String comment) {
        out.print("#");
        out.println(comment);
        return this;
    }

    private void printIndent() {
        final int indentLevel = nodeStack.size() + levelOffset;
        for (int i = 0; i < indentLevel; ++i) {
            for (int w = 0; w < config.indentWidth; ++w)
                out.append(" ");
        }
    }

    public SilkWriter node(String nodeName) {
        printIndent();
        out.print("-");
        out.print(nodeName);
        pushContext(nodeName);
        SilkWriter child = new SilkWriter(this);
        registChildWriter(child);
        return child;
    }

    /**
     * Remember the child writer
     * 
     * @param childWriter
     */
    private void registChildWriter(SilkWriter childWriter) {
    // TODO impl
    }

    public SilkWriter attribute(String nodeName) {

        return this;
    }

    public SilkWriter attribute(String nodeName, String nodeValue) {
        return this;
    }

    public SilkWriter leaf(String nodeName) {
        return leaf(nodeName, null);
    }

    public SilkWriter leaf(String nodeName, String nodeValue) {
        printIndent();
        out.print("-");
        out.print(nodeName);
        if (nodeValue != null) {
            out.print(":");
            out.println(nodeValue);
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
