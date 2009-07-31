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
import java.util.HashSet;
import java.util.Set;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

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
    private Set<SilkWriter> childWriterSet = new HashSet<SilkWriter>();

    private final String contextNodeName;

    /**
     * Silk output format configurations
     * 
     * @author leo
     * 
     */
    public static class FormatConfig {

        // indentation
        public int indentWidth = 2;
        public boolean indentBeforeDataLine = false;
        public boolean indentCommentLine = false;

        // comment
        public boolean insertSpaceAfterCommentSymbol = true;

        // comma
        public boolean insertSpaceAfterComma = true;

        // colon
        public boolean insertSpaceBeforeColon = false;
        public boolean insertSpaceAfterColon = false;
    }

    private FormatConfig formatConfig = new FormatConfig();
    private final int levelOffset;
    private boolean isUsable = true;

    private SyntaxType nodeValueSyntaxType = SyntaxType.DEFAULT;

    private int numAttribute = 0;

    public SilkWriter(Writer out) {
        this.out = new PrintWriter(out);
        this.parent = null;
        this.levelOffset = 0;
        this.contextNodeName = null;
    }

    public SilkWriter(OutputStream out) {
        this(new PrintWriter(new OutputStreamWriter(out)));
    }

    private SilkWriter(String contextNodeName, SilkWriter parent) {
        this.parent = parent;
        this.out = parent.out;
        this.levelOffset = parent.levelOffset + 1;
        this.contextNodeName = contextNodeName;
    }

    /**
     * Get the parent writer
     * 
     * @return
     */
    public SilkWriter getParent() {
        return parent;
    }

    public String getContextNodeName() {
        return contextNodeName;
    }

    public void flush() {
        this.out.flush();
    }

    public void endDocument() {
        attributeParenCloseCheck(true);
        out.println();
        flush();
    }

    /**
     * Close the writer (or output stream) inside the SilkWriter
     */
    public void close() {
        endDocument();
        this.out.close();
    }

    public SilkWriter preamble() {
        out.println("%silk(version:1.0)");
        return this;
    }

    /**
     * output comment line
     * 
     * @param comment
     * @return
     */
    public SilkWriter commentLine(String comment) {

        // before generating comment line, close the opened attribute parenthesis
        attributeParenCloseCheck(true);

        String[] comments = comment.split("(\\r\\n|\\r|\\n)");

        for (String each : comments) {
            if (formatConfig.indentCommentLine)
                printIndent();

            out.print("#");

            if (formatConfig.insertSpaceAfterCommentSymbol)
                out.print(" ");

            out.println(each);
        }
        return this;
    }

    private void printIndent() {
        final int indentLevel = levelOffset;
        for (int i = 0; i < indentLevel; ++i) {
            for (int w = 0; w < formatConfig.indentWidth; ++w)
                out.append(" ");
        }
    }

    private void invalidateChildWriters() {
        for (SilkWriter each : childWriterSet) {
            each.invalidate();
        }

        childWriterSet.clear();
    }

    private void invalidate() {
        this.isUsable = false;
    }

    private void usabilityCheck() {
        if (!this.isUsable)
            throw new XerialError(XerialErrorCode.INVALID_USAGE, "This writer is no longer usable");

        invalidateChildWriters();
    }

    private void attributeParenCloseCheck(boolean insertNewline) {
        if (numAttribute > 0) {
            out.print(")");

            switch (nodeValueSyntaxType) {
            case SEQUENCE:
                out.print(">");
                break;
            case TAB:
                out.print("|");
                break;
            }
        }

        if (insertNewline)
            out.println();

        numAttribute = 0;
    }

    /**
     * Output a silk node, and gets a new SilkWriter for genarating attributes
     * and child nodes
     * 
     * @param nodeName
     * @return
     */
    public SilkWriter node(String nodeName) {
        usabilityCheck();

        attributeParenCloseCheck(true);

        printIndent();
        out.print("-");
        out.print(nodeName);
        SilkWriter child = new SilkWriter(nodeName, this);
        registChildWriter(child);
        return child;
    }

    public static enum SyntaxType {
        DEFAULT, TAB, SEQUENCE
    }

    public SilkWriter setNodeValueSyntax(SyntaxType type) {
        this.nodeValueSyntaxType = type;
        return this;
    }

    /**
     * Remember the child writer
     * 
     * @param childWriter
     */
    private void registChildWriter(SilkWriter childWriter) {
        childWriterSet.add(childWriter);
    }

    public SilkWriter attribute(String nodeName) {
        return attribute(nodeName, null);
    }

    public SilkWriter attribute(String nodeName, String nodeValue) {
        usabilityCheck();

        if (numAttribute == 0) {
            out.print("(");
        }
        else
            comma();

        out.print(nodeName);

        colonAndNodeValue(nodeValue);

        numAttribute++;
        return this;
    }

    public SilkWriter nodeValue(String value) {
        usabilityCheck();
        attributeParenCloseCheck(false);

        colonAndNodeValue(value);
        return this;
    }

    public SilkWriter leaf(String nodeName) {
        return leaf(nodeName, null);
    }

    public SilkWriter leaf(String nodeName, String nodeValue) {
        usabilityCheck();

        attributeParenCloseCheck(true);

        printIndent();
        out.print("-");
        out.print(nodeName);

        colonAndNodeValue(nodeValue);

        return this;
    }

    void comma() {
        out.print(",");
        if (formatConfig.insertSpaceAfterComma)
            out.print(" ");
    }

    void colonAndNodeValue(String nodeValue) {
        if (nodeValue != null) {
            if (formatConfig.insertSpaceBeforeColon)
                out.print(" ");
            out.print(":");
            if (formatConfig.insertSpaceAfterColon)
                out.print(" ");
            out.print(nodeValue);
        }
    }

    public SilkWriter dataLine(String dataLine) {
        usabilityCheck();

        attributeParenCloseCheck(true);

        if (formatConfig.indentBeforeDataLine)
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
