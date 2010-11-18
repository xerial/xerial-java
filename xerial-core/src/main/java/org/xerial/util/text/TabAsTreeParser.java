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
// TabAsTreeParser.java
// Since: Feb 26, 2010 12:11:56 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeParser;

public class TabAsTreeParser implements TreeParser {

    private static Logger _logger = Logger.getLogger(TabSeparatedTextWalker.class);

    private boolean isFirstLineContainsColumnLabel = false;
    private boolean reportLineNumber = false;

    private final BufferedReader reader;

    private final String rootName = "root";
    private String rowName = "entry";
    private String lineAttributeName = "line";

    private final char separator;

    private int lineCount = -1;

    /**
     * The column label list
     */
    private final ArrayList<String> columnLableList = new ArrayList<String>();

    /**
     * 
     * 
     * @param reader
     * @param visitor
     */
    public TabAsTreeParser(Reader reader) {
        this(reader, '\t');
    }

    public TabAsTreeParser(Reader reader, char separator) {
        this.reader = new BufferedReader(reader);
        this.separator = separator;
    }

    /**
     * Treat the first line as column label or not.
     * 
     * @param firstLineIsColumnLabel
     */
    public void setFirstLineAsColumnLabel(boolean firstLineIsColumnLabel) {
        this.isFirstLineContainsColumnLabel = firstLineIsColumnLabel;
    }

    /**
     * Set the node name used for label each row (sub tree)
     * 
     * @param rowNodeName
     */
    public void setRowNodeName(String rowNodeName) {
        this.rowName = rowNodeName;
    }

    /**
     * Gets the row node name (default = "entry")
     * 
     * @return
     */
    public String getRowNodeName() {
        return this.rowName;
    }

    /**
     * Sets the column label
     * 
     * @param newColumnLabelList
     */
    public void setColunLabel(List<String> newColumnLabelList) {
        this.columnLableList.clear();
        for (String columnLabel : newColumnLabelList) {
            this.columnLableList.add(columnLabel);
        }
    }

    public TreeNode getSubTree() throws XerialException {
        throw new UnsupportedOperationException("getSubTree()");
    }

    public void skipDescendants() {
        throw new UnsupportedOperationException("skipDescendants()");

    }

    /**
     * Reads the next line and increment the counter
     * 
     * @return
     * @throws IOException
     */
    private String readLine() throws IOException {
        String line = reader.readLine();
        lineCount++;
        return line;
    }

    public void parse(TreeEventHandler handler) throws Exception {

        lineCount = -1;
        handler.init();
        handler.visitNode(rootName, null);
        try {
            // process the first line
            if (isFirstLineContainsColumnLabel) {
                ArrayList<String> splitRow = splitLine(readLine());
                int columnIndex = 1;
                for (String label : splitRow) {
                    if (label.length() <= 0) {
                        label = "c" + columnIndex;
                        _logger.warn(String.format(
                                "column (index=%d) has no column label. Use %s instead.",
                                columnIndex, label));
                    }
                    columnLableList.add(label);
                    columnIndex++;
                }
            }

            // read each line 
            for (String line = readLine(); line != null; line = readLine()) {
                ArrayList<String> columnData = splitLine(line);
                if (columnData == null || columnData.size() <= 0)
                    continue;

                handler.visitNode(rowName, null);
                if (reportLineNumber) {
                    String lineNumber = Integer.toString(lineCount);
                    handler.visitNode(lineAttributeName, lineNumber);
                    handler.leaveNode(lineAttributeName);
                }

                for (int i = 0; i < columnData.size(); i++) {
                    String columnName = getColumnLabel(i);
                    String columnValue = escapeText(columnData.get(i));
                    handler.visitNode(columnName, columnValue);
                    handler.leaveNode(columnName);
                }
                handler.leaveNode(rowName);
            }

        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.READ_ERROR, e);
        }

        handler.leaveNode(rootName);
        handler.finish();

    }

    public static String escapeText(String s) {
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("\"", "&quot;");
        s = s.replaceAll("'", "&#39;");
        return s;
    }

    /**
     * Test line number reporting is enabled or not.
     * 
     * @return
     */
    public boolean isReportLineNumber() {
        return reportLineNumber;
    }

    /**
     * Enable line number reporting (default = true)
     * 
     * @param reportLineNumber
     *            enable the line number reporting
     */
    public void setReportLineNumber(boolean reportLineNumber) {
        this.reportLineNumber = reportLineNumber;
    }

    /**
     * get the line number node name
     * 
     * @return
     */
    public String getLineAttributeName() {
        return lineAttributeName;
    }

    /**
     * Set the line number node name
     * 
     * @param lineAttributeName
     *            the line number node name (default = "line")
     */
    public void setLineAttributeName(String lineAttributeName) {
        this.lineAttributeName = lineAttributeName;
    }

    private ArrayList<String> splitLine(String line) {
        if (line.length() <= 0)
            return null;
        else
            return StringUtil.split(line, separator);
    }

    /**
     * Gets the column label of the specified column number
     * 
     * @param columnIndex
     *            the column index
     * @return the column label
     */
    public String getColumnLabel(int columnIndex) {
        if (columnIndex < columnLableList.size()) {
            return columnLableList.get(columnIndex);
        }
        else {
            for (int i = columnLableList.size(); i <= columnIndex; i++) {
                columnLableList.add("c" + (i + 1));
            }
            return getColumnLabel(columnIndex);
        }

    }

    public List<String> getColumnLabelList() {
        return columnLableList;
    }

}
