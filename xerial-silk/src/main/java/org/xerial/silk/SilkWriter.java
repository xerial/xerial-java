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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.lens.ObjectLens;
import org.xerial.lens.impl.ParameterGetter;
import org.xerial.util.StringUtil;
import org.xerial.util.TypeInfo;

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
        public boolean insertTabAfterColon = false;

        // colon (inline-node)
        public boolean insertSpaceBeforeAttributeColon = false;
        public boolean insertSpaceAfterAttributeColon = false;
        public boolean insertTabAfterAttributeColon = false;

        // preamble
        public boolean insertSpaceAfterPreambleSymbol = false;

        // parenthesis 
        public boolean insertSpaceOutsideOfParen = false;
        public boolean insertSpaceInsideOfParen = false;

        // use attribute?
        public boolean preferUsingAttribute = false;
    }

    private FormatConfig formatConfig = new FormatConfig();
    private final int levelOffset;
    private boolean isUsable = true;

    private SyntaxType nodeValueSyntaxType = SyntaxType.DEFAULT;

    private boolean isFirstLine = true;
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
        if (parent != null)
            isFirstLine = false;
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

    SilkWriter endNode() {
        usabilityCheck();
        attributeParenCloseCheck(false);
        return this;
    }

    public SilkWriter preamble() {
        beginPreamble();
        createNewChildWriter("silk", "").attribute("version", "1.0");
        return this;
    }

    public SilkWriter preamble(String anyText) {
        beginPreamble();
        out.print(anyText);
        return this;
    }

    private void beginPreamble() {
        usabilityCheck();
        attributeParenCloseCheck(true);

        out.print("%");
        if (formatConfig.insertSpaceAfterPreambleSymbol)
            out.print(" ");
    }

    public SilkWriter sortInfo(String coreNodeName) {
        beginPreamble();
        out.print("sorted ");
        return createNewChildWriter(coreNodeName, "");
    }

    public SilkWriter sortInfo(String coreNodeName, String... keyNode) {

        SilkWriter w = sortInfo(coreNodeName);
        for (String each : keyNode) {
            w.attribute(each);
        }
        return w;
    }

    public SilkWriter schema(String coreNodeName, String... attribute) {

        SilkWriter w = schema(coreNodeName);
        for (String each : attribute) {
            w.attribute(each);
        }
        return w;
    }

    public SilkWriter schema(String coreNodeName) {
        beginPreamble();
        out.print("schema ");
        return createNewChildWriter(coreNodeName, "");
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

            if (index < comments.length - 1) {
                out.println(each);
            }
            else
                out.print(each);
            index++;
        }
        return this;
    }

    /**
     * print indent and returns the indentation level
     * 
     * @return indentation level
     */
    private int printIndent() {
        final int indentLevel = levelOffset;
        for (int i = 0; i < indentLevel; ++i) {
            for (int w = 0; w < formatConfig.indentWidth; ++w)
                out.append(" ");
        }
        return levelOffset;
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

    private void attributeParenCloseCheck(boolean startsWithLineHead) {
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

        if (startsWithLineHead) {
            if (!isFirstLine)
                out.println();
            else
                isFirstLine = false;
        }

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

        return createNewChildWriter(nodeName, NODE_INDICATOR);
    }

    private final static String NODE_INDICATOR = "-";

    private SilkWriter createNewChildWriter(String nodeName, String nodeIndicator) {
        printNodeName(nodeName, nodeIndicator);
        SilkWriter child = new SilkWriter(nodeName, this);
        registChildWriter(child);
        return child;
    }

    private void printNodeName(String nodeName, String nodeIndicator) {

        int indentLevel = printIndent();
        out.print(nodeIndicator);
        out.print(nodeName != null ? nodeName : "");
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

    /**
     * Insert a new line
     * 
     * @return
     */
    public SilkWriter newline() {
        out.println();
        return this;
    }

    public SilkWriter attribute(String nodeName) {
        return attribute(nodeName, null);
    }

    private void keyAndValue(String key, String value) {
        out.print(key);
        colonAndNodeValueForInlineNode(value);
    }

    public SilkWriter attribute(String attributeName, String attributeValue) {
        usabilityCheck();

        if (numAttribute == 0) {
            openParen();
        }
        else
            comma();

        keyAndValue(attributeName, attributeValue);

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

    public SilkWriter leaf(String nodeName, Object nodeValue) {

        if (!TypeInfo.isBasicType(nodeValue.getClass()))
            return leafObject(nodeName, nodeValue);

        usabilityCheck();

        attributeParenCloseCheck(true);

        printNodeName(nodeName, NODE_INDICATOR);

        if (nodeValue != null)
            colonAndNodeValue(convertToString(nodeValue));

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
            if (formatConfig.insertTabAfterAttributeColon)
                out.print("\t");
            out.print(sanitizeInLineNodeValue(nodeValue));
        }
    }

    static String sanitizeInLineNodeValue(String nodeValue) {

        String mustBeEscaped = "\"";
        nodeValue = nodeValue.replaceAll("\"", "\\\"");
        // "[](){},:>*|")));
        Pattern p = Pattern.compile(String.format("[%s]", "\\[\\](){},:>*|"));
        Matcher m = p.matcher(nodeValue);
        if (m.find()) {
            nodeValue = StringUtil.doubleQuote(nodeValue);
        }
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
            if (formatConfig.insertTabAfterColon)
                out.print("\t");
            if (nodeValue.length() > 0
                    && (StringUtil.isWhiteSpace(nodeValue.substring(0, 1)) || StringUtil
                            .isWhiteSpace(nodeValue.substring(nodeValue.length() - 1)))) {
                // preserve white spaces
                out.print("\"");
                out.print(nodeValue);
                out.print("\"");
            }
            else
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

    public SilkWriter text(String text) {
        usabilityCheck();

        attributeParenCloseCheck(true);

        if (formatConfig.indentBeforeDataLine)
            printIndent();

        String line[] = text.split("\r?\n");
        if (line == null)
            return this;

        for (String each : line) {
            out.print(escapeDataLine(each));
        }

        return this;
    }

    public static String escapeText(String text) {
        String[] line = text.split("\r?\n");
        if (line == null)
            return escapeDataLine(text);

        List<String> buf = new ArrayList<String>();
        for (String each : line) {
            buf.add(escapeDataLine(each));
        }
        return StringUtil.join(buf, StringUtil.NEW_LINE);
    }

    private static Pattern leadingHyphen = Pattern.compile("\\s*-");

    private static String escapeDataLine(String dataLine) {

        if (dataLine == null)
            return dataLine;

        Matcher m = leadingHyphen.matcher(dataLine);
        if (m.lookingAt()) {
            int hyphenPos = m.end();
            StringBuilder buf = new StringBuilder();
            buf.append(dataLine.substring(0, hyphenPos - 1));
            buf.append("\\");
            buf.append(dataLine.substring(hyphenPos - 1));
            return buf.toString();
        }

        // no change
        return dataLine;
    }

    private String convertToString(Object value) {
        Class< ? > c = value.getClass();
        if (c == Date.class) {
            return DateFormat.getDateTimeInstance().format(Date.class.cast(value));
        }
        else
            return value.toString();
    }

    /**
     * Output the input value (object) in Silk format undert the specified node
     * name
     * 
     * @param <Value>
     * @param leafNodeName
     *            node name
     * @param v
     *            object to convert into Silk
     * @return
     */
    public <Value> SilkWriter leafObject(String leafNodeName, Value v) {
        if (v == null)
            return this;

        if (TypeInfo.isBasicType(v.getClass())) {
            outputLeaf(leafNodeName, convertToString(v));
        }
        else {
            ObjectLens lens = ObjectLens.getObjectLens(v.getClass());
            if (lens.hasAttributes()) {
                SilkWriter c = node(leafNodeName);
                c.toSilk(v);
            }
            else {
                outputLeaf(leafNodeName, convertToString(v));
            }
        }
        return this;
    }

    private void outputLeaf(String leafNodeName, String value) {
        if (parent != null && formatConfig.preferUsingAttribute)
            attribute(leafNodeName, value);
        else
            leaf(leafNodeName, value);
    }

    /**
     * output the input object in Silk format
     * 
     * @param obj
     * @return
     */
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

        if (TypeInfo.isIterable(c)) {
            Iterable< ? > collection = (Iterable< ? >) obj;
            boolean hasAttributes = lens.hasAttributes();
            if (hasAttributes) {
                outputParemters(lens, obj);
            }

            if (collection != null) {
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

        endNode();

        return this;
    }

    private void outputParemters(ObjectLens lens, Object obj) {

        List<ParameterGetter> getterContainer = lens.getGetterContainer();
        List<ParameterGetter> postponedParameters = new ArrayList<ParameterGetter>();

        // output attribute-like parameters first
        for (ParameterGetter getter : getterContainer) {

            Class< ? > c = getter.getReturnType();
            if (TypeInfo.isBasicType(c)) {
                leafObject(getter.getNaturalParamName(), getter.get(obj));
            }
            else {
                if (TypeInfo.isIterable(c) || TypeInfo.isMap(c)) {
                    postponedParameters.add(getter);
                }
                else {
                    ObjectLens paramLens = ObjectLens.getObjectLens(c);
                    if (paramLens.hasAttributes())
                        postponedParameters.add(getter);
                    else
                        leafObject(getter.getNaturalParamName(), getter.get(obj));
                }
            }

        }

        for (ParameterGetter getter : postponedParameters) {

            Class< ? > c = getter.getReturnType();
            if (TypeInfo.isIterable(c)) {
                Iterable< ? > collection = (Iterable< ? >) getter.get(obj);

                if (collection != null) {
                    for (Object elem : collection) {
                        SilkWriter w = node(getter.getNaturalParamName());
                        w.toSilk(elem);
                    }
                }
            }
            else if (TypeInfo.isMap(c)) {
                Map< ? , ? > map = (Map< ? , ? >) getter.get(obj);

                if (!map.isEmpty()) {
                    String mapElemName = getter.getNaturalParamName();
                    if (!mapElemName.equals("")) {
                        SilkWriter w = node(mapElemName);
                        for (Entry< ? , ? > each : map.entrySet()) {
                            Object key = each.getKey();
                            Object value = each.getValue();
                            if (TypeInfo.isBasicType(key.getClass())) {
                                w.leafObject(key.toString(), value);
                            }
                            else {
                                w.node("key").toSilk(key);
                                w.node("value").toSilk(value);
                            }
                        }
                        w.endNode();
                    }
                    else {
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
            }
            else {
                leafObject(getter.getNaturalParamName(), getter.get(obj));
            }
        }
    }

}
