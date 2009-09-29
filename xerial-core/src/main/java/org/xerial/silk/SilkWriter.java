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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.lens.ObjectLens;
import org.xerial.lens.impl.ParameterGetter;
import org.xerial.util.bean.TypeInfo;

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
        public boolean insertSpaceAfterColon = true;
        /**
         * insert tab after colon symbol (intermediate node only)
         */
        public boolean insertTagAfterColon = false;

        // colon (inline-node)
        public boolean insertSpaceBeforeAttributeColon = false;
        public boolean insertSpaceAfterAttributeColon = false;
        public boolean insertTagAfterAttributeColon = false;

        // preamble
        public boolean insertSpaceAfterPreambleSymbol = true;

        // parenthesis 
        public boolean insertSpaceOutsideOfParen = false;
        public boolean insertSpaceInsideOfParen = false;
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
        this.formatConfig = parent.formatConfig;
    }

    public void setFormatConfig(FormatConfig config) {
        if (config == null)
            throw new NullPointerException("config is null");

        this.formatConfig = config;
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
        usabilityCheck();
        attributeParenCloseCheck(true);
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
        out.print("%");
        if (formatConfig.insertSpaceAfterPreambleSymbol)
            out.print(" ");
        out.print("silk");

        openParen();
        keyAndValue("version", "1.0");
        closeParen();

        return this;
    }

    /**
     * output comment line
     * 
     * @param comment
     * @return
     */
    public SilkWriter commentLine(String comment) {

        usabilityCheck();
        // before generating comment line, close the opened attribute parenthesis
        attributeParenCloseCheck(true);

        String[] comments = comment.split("(\\r\\n|\\r|\\n)");

        int index = 0;
        for (String each : comments) {
            if (formatConfig.indentCommentLine)
                printIndent();

            out.print("#");

            if (formatConfig.insertSpaceAfterCommentSymbol)
                out.print(" ");

            if (index < comments.length - 1)
                out.println(each);
            else
                out.print(each);
            index++;
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
        attributeParenCloseCheck(false);
        this.isUsable = false;
    }

    private void usabilityCheck() {
        if (!this.isUsable)
            throw new XerialError(XerialErrorCode.INVALID_USAGE, "This writer is no longer usable");

        invalidateChildWriters();
    }

    private void openParen() {
        if (formatConfig.insertSpaceOutsideOfParen)
            out.print(" ");
        out.print("(");
        if (formatConfig.insertSpaceInsideOfParen)
            out.print(" ");
    }

    private void closeParen() {
        if (formatConfig.insertSpaceInsideOfParen)
            out.print(" ");
        out.print(")");
        if (formatConfig.insertSpaceOutsideOfParen)
            out.print(" ");
    }

    private void attributeParenCloseCheck(boolean insertNewline) {
        if (numAttribute > 0) {
            closeParen();

            if (nodeValueSyntaxType == SyntaxType.TAB)
                out.print("|");
        }

        switch (nodeValueSyntaxType) {
        case SEQUENCE:
            out.print(">");
            break;
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

        printNodeName(nodeName);
        SilkWriter child = new SilkWriter(nodeName, this);
        registChildWriter(child);
        return child;
    }

    private void printNodeName(String nodeName) {
        printIndent();
        out.print("-");
        if (nodeName != null)
            out.print(nodeName);
    }

    public SilkWriter tabDataSchema(String nodeName) {
        SilkWriter child = node(nodeName);
        child.setNodeValueSyntax(SyntaxType.TAB);
        return child;
    }

    public SilkWriter multilineData(String nodeName) {
        SilkWriter child = node(nodeName);
        child.setNodeValueSyntax(SyntaxType.SEQUENCE);
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

    private void keyAndValue(String key, String value) {
        out.print(key);
        colonAndNodeValueForInlineNode(value);
    }

    public SilkWriter attribute(String nodeName, String nodeValue) {
        usabilityCheck();

        if (numAttribute == 0) {
            openParen();
        }
        else
            comma();

        keyAndValue(nodeName, nodeValue);

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

    void colonAndNodeValueForInlineNode(String nodeValue) {
        if (nodeValue != null) {
            if (formatConfig.insertSpaceBeforeAttributeColon)
                out.print(" ");
            out.print(":");
            if (formatConfig.insertSpaceAfterAttributeColon)
                out.print(" ");
            if (formatConfig.insertTagAfterAttributeColon)
                out.print("\t");
            out.print(sanitizeInLineNodeValue(nodeValue));
        }
    }

    String sanitizeInLineNodeValue(String nodeValue) {
        // TODO impl
        return nodeValue;
    }

    /**
     * Test whether this writer is usable or not
     * 
     * @return
     */
    public boolean isUsable() {
        return isUsable;
    }

    void colonAndNodeValue(String nodeValue) {
        if (nodeValue != null) {
            if (formatConfig.insertSpaceBeforeColon)
                out.print(" ");
            out.print(":");
            if (formatConfig.insertSpaceAfterColon)
                out.print(" ");
            if (formatConfig.insertTagAfterColon)
                out.print("\t");
            out.print(nodeValue);
        }
    }

    public SilkWriter dataLine(String dataLine) {
        usabilityCheck();

        attributeParenCloseCheck(true);

        if (formatConfig.indentBeforeDataLine)
            printIndent();

        out.print(escapeDataLine(dataLine));

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

    private <Value> SilkWriter leafObject(String leafNodeName, Value v) {
        if (v == null)
            return this;

        if (TypeInfo.isBasicType(v.getClass())) {

            if (parent != null)
                attribute(leafNodeName, v.toString());
            else
                leaf(leafNodeName, v.toString());
        }
        else {
            ObjectLens lens = ObjectLens.getObjectLens(v.getClass());
            if (lens.hasAttributes()) {
                SilkWriter c = node(leafNodeName);
                c.toSilk(v);
            }
            else {
                if (parent != null)
                    attribute(leafNodeName, v.toString());
                else
                    leaf(leafNodeName, v.toString());
            }
        }
        return this;
    }

    public SilkWriter toSilk(Object obj) {

        if (obj == null)
            return this;

        usabilityCheck();

        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c)) {
            nodeValue(obj.toString());
            return this;
        }

        ObjectLens lens = ObjectLens.getObjectLens(obj.getClass());

        if (TypeInfo.isCollection(c)) {
            Collection< ? > collection = (Collection< ? >) obj;
            boolean hasAttributes = lens.hasAttributes();
            if (hasAttributes) {
                outputParemters(lens, obj);
            }

            if (!collection.isEmpty()) {
                for (Object elem : collection) {
                    SilkWriter w = node(null);
                    w.toSilk(elem);
                }
            }
        }
        else if (TypeInfo.isMap(c)) {
            Map< ? , ? > map = (Map< ? , ? >) obj;
            boolean hasAttributes = lens.hasAttributes();

            if (hasAttributes) {
                outputParemters(lens, obj);
            }

            if (!map.isEmpty()) {

                String mapElemName = getContextNodeName();
                if (mapElemName == null)
                    mapElemName = "entry";

                for (Entry< ? , ? > each : map.entrySet()) {
                    Object key = each.getKey();
                    Object value = each.getValue();

                    if (TypeInfo.isBasicType(key.getClass())) {
                        leafObject(key.toString(), value);
                    }
                    else {
                        SilkWriter w = node(mapElemName);
                        w.node("key").toSilk(key);
                        w.node("value").toSilk(value);
                    }
                }
            }
        }
        else {
            if (lens.hasAttributes())
                outputParemters(lens, obj);
            else
                out.print(obj.toString());
        }

        attributeParenCloseCheck(false);

        return this;
    }

    private void outputParemters(ObjectLens lens, Object obj) {

        List<ParameterGetter> getterContainer = lens.getGetterContainer();
        List<ParameterGetter> postponedParameters = new ArrayList<ParameterGetter>();

        // output attribute-like parameters first
        for (ParameterGetter getter : getterContainer) {

            Class< ? > c = getter.getReturnType();
            if (TypeInfo.isBasicType(c)) {
                leafObject(getter.getParamName(), getter.get(obj));
            }
            else {
                if (TypeInfo.isCollection(c) || TypeInfo.isMap(c)) {
                    postponedParameters.add(getter);
                }
                else {
                    ObjectLens paramLens = ObjectLens.getObjectLens(c);
                    if (paramLens.hasAttributes())
                        postponedParameters.add(getter);
                    else
                        leafObject(getter.getParamName(), getter.get(obj));
                }
            }

        }

        for (ParameterGetter getter : postponedParameters) {

            Class< ? > c = getter.getReturnType();
            if (TypeInfo.isCollection(c)) {
                Collection< ? > collection = (Collection< ? >) getter.get(obj);

                if (!collection.isEmpty()) {
                    for (Object elem : collection) {
                        SilkWriter w = node(getter.getParamName());
                        w.toSilk(elem);
                    }
                }
            }
            else if (TypeInfo.isMap(c)) {
                Map< ? , ? > map = (Map< ? , ? >) getter.get(obj);

                if (!map.isEmpty()) {

                    String mapElemName = getter.getParamName();

                    for (Entry< ? , ? > each : map.entrySet()) {
                        Object key = each.getKey();
                        Object value = each.getValue();

                        if (TypeInfo.isBasicType(key.getClass())) {
                            leafObject(key.toString(), value);
                        }
                        else {
                            SilkWriter w = node(mapElemName);
                            w.node("key").toSilk(key);
                            w.node("value").toSilk(value);
                        }
                    }
                }
            }
            else {
                leafObject(getter.getParamName(), getter.get(obj));
            }
        }
    }

}
