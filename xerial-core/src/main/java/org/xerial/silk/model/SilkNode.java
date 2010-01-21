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
// SilkNode.java
// Since: Jan 30, 2009 6:58:59 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.model;

import java.util.ArrayList;

import org.xerial.util.StringUtil;

/**
 * SilkNode begins with '-' character, follwed by object notation of the form:
 * 
 * <pre>
 *  object_name (: nodeValue)? '(' attribute, ... ')' ([format_name])? ('*' | '&gt;' | '|')
 * </pre>
 * 
 * @author leo
 * 
 */
public class SilkNode implements SilkElement {

    public static class SilkNodeBuilder {
        private int indent = NO_INDENT;
        private String name;
        private SilkValue value;

        private String dataType;
        private SilkNodeOccurrence occurrence = SilkNodeOccurrence.ONE;
        private final ArrayList<SilkNode> childNodeList = new ArrayList<SilkNode>();

        public SilkNode build() {
            return new SilkNode(indent, name, value, dataType, occurrence, childNodeList);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setIndent(String indentString) {
            if (indentString == null)
                indent = NO_INDENT;
            else {
                int indentLevel = 0;
                for (; indentLevel < indentString.length(); ++indentLevel)
                    if (indentString.charAt(indentLevel) != ' ')
                        break;
                indent = indentLevel;
            }
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public void addSilkNode(SilkNodeBuilder newNode) {
            if (name == null) {
                newNode.indent = this.indent;
            }

            childNodeList.add(newNode.build());
        }

        public void setValue(String text) {
            this.value = new SilkTextValue(text);
        }

        public void setJSON(String jsonText) {
            this.value = new SilkJSONValue(jsonText);
        }

        public void setFunction(SilkFunction func) {
            this.value = func;
        }

        public void setOccurrence(SilkNodeOccurrence occurrence) {
            this.occurrence = occurrence;
        }

    }

    public final int indent;
    public final String name;
    public final SilkValue value;

    public final String dataType;
    public final SilkNodeOccurrence occurrence;
    public final ArrayList<SilkNode> childNodeList;

    private SilkNode(int indent, String name, SilkValue value, String dataType,
            SilkNodeOccurrence occurrence, ArrayList<SilkNode> childNodeList) {
        super();
        this.indent = indent;
        this.name = name;
        this.value = value;
        this.dataType = dataType;
        this.occurrence = occurrence;
        this.childNodeList = childNodeList;
    }

    public String getName() {
        return name;
    }

    public boolean hasManyOccurrences() {
        return occurrence == SilkNodeOccurrence.ZERO_OR_MORE
                || occurrence == SilkNodeOccurrence.ONE_OR_MORE;
    }

    public boolean hasChildren() {
        return childNodeList.size() > 0;
    }

    public final static int NO_INDENT = Integer.MAX_VALUE; // must be higher than other indent levels
    public final static int INTERMIDIATE_NODE_INDENT = Integer.MAX_VALUE - 1; // 

    /**
     * Return the indent level (the length of the leadning white spaces) of this
     * node. If no indent is specified, return {@link SilkNode#NO_INDENT}.
     * 
     * @return the indent level of the node, or {@link SilkNode#NO_INDENT} if no
     *         indent is specified.
     */
    public int getIndentLevel() {
        return indent;
    }

    public boolean hasDataType() {
        return dataType != null;
    }

    public String getDataType() {
        return dataType;
    }

    public SilkNodeOccurrence getOccurrence() {
        return occurrence;
    }

    public ArrayList<SilkNode> getChildNodes() {
        return childNodeList;
    }

    public SilkValue getValue() {
        return value;
    }

    public boolean hasValue() {
        return value != null;
    }

    @Override
    public String toString() {
        String childNodeString = childNodeList.isEmpty() ? "" : String.format("(%s)", StringUtil
                .join(childNodeList, ", "));
        String nodeValue = value != null ? ":" + value.toString() : "";
        if (hasDataType())
            return String.format("%s[%s]<%s>%s%s", name, dataType, childNodeString, occurrence,
                    nodeValue);
        else
            return String.format("%s%s<%s>%s", name, childNodeString, occurrence, nodeValue);
    }

    public String toSilk() {
        StringBuffer buf = new StringBuffer();
        buf.append(indent);

        buf.append(toSilkAttribute());

        return buf.toString();
    }

    private String toSilkAttribute() {
        StringBuffer buf = new StringBuffer();
        if (name != null)
            buf.append(name);

        if (dataType != null) {
            buf.append("[");
            buf.append(dataType);
            buf.append("]");
        }

        if (value != null) {
            buf.append(":");
            buf.append(value.getValue());
        }

        if (!childNodeList.isEmpty()) {
            buf.append("(");
            ArrayList<String> childNodes = new ArrayList<String>();
            for (SilkNode child : childNodeList)
                childNodes.add(child.toSilkAttribute());
            buf.append(StringUtil.join(childNodes, ", "));
            buf.append(")");
        }

        buf.append(occurrence);

        return buf.toString();
    }

}
