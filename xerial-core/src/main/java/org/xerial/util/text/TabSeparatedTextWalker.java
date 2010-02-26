/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// Xerial Raquel Project
//
// TabSeparatedTextWalker.java
// Since: 2008/06/01 14:19:55
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
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * Stream walker for tab-separated text data.
 * 
 * Each line in the tex file is represented as a subtree.
 * 
 * @author leo
 * 
 */
public class TabSeparatedTextWalker implements TreeWalker
{

    private static Logger _logger = Logger.getLogger(TabSeparatedTextWalker.class);

    private boolean isFirstLineContainsColumnLabel = false;
    private boolean reportLineNumber = false;

    private BufferedReader reader;

    private String rootName = "root";
    private String rowName = "entry";
    private String lineAttributeName = "line";

    private final String separator;

    private int lineCount = -1;

    /**
     * The column label list
     */
    private ArrayList<String> columnLableList = new ArrayList<String>();

    /**
     * 
     * 
     * @param reader
     * @param visitor
     */
    public TabSeparatedTextWalker(Reader reader)
    {
        this(reader, "\t");
    }

    public TabSeparatedTextWalker(Reader reader, String separator)
    {
        this.reader = new BufferedReader(reader);
        this.separator = separator;
    }

    /**
     * Treat the first line as column label or not.
     * 
     * @param firstLineIsColumnLabel
     */
    public void setFirstLineAsColumnLabel(boolean firstLineIsColumnLabel)
    {
        this.isFirstLineContainsColumnLabel = firstLineIsColumnLabel;
    }

    /**
     * Set the node name used for label each row (sub tree)
     * 
     * @param rowNodeName
     */
    public void setRowNodeName(String rowNodeName)
    {
        this.rowName = rowNodeName;
    }

    /**
     * Gets the row node name (default = "entry")
     * 
     * @return
     */
    public String getRowNodeName()
    {
        return this.rowName;
    }

    /**
     * Sets the column label
     * 
     * @param newColumnLabelList
     */
    public void setColunLabel(List<String> newColumnLabelList)
    {
        this.columnLableList.clear();
        for (String columnLabel : newColumnLabelList)
        {
            this.columnLableList.add(columnLabel);
        }
    }

    public TreeNode getSubTree() throws XerialException
    {
        throw new UnsupportedOperationException("getSubTree()");
    }

    public void skipDescendants()
    {
        throw new UnsupportedOperationException("skipDescendants()");

    }

    /**
     * Reads the next line and increment the counter
     * 
     * @return
     * @throws IOException
     */
    private String readLine() throws IOException
    {
        String line = reader.readLine();
        lineCount++;
        return line;
    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        lineCount = -1;
        visitor.init(this);
        visitor.visitNode(rootName, null, this);
        try
        {
            // process the first line
            if (isFirstLineContainsColumnLabel)
            {
                String[] splitRow = splitLine(readLine());
                int columnIndex = 1;
                for (String label : splitRow)
                {
                    if (label.length() <= 0)
                    {
                        label = "c" + columnIndex;
                        _logger.warn(String.format("column (index=%d) has no column label. Use %s instead.",
                                columnIndex, label));
                    }
                    columnLableList.add(label);
                    columnIndex++;
                }
            }

            // read each line 
            for (String line = readLine(); line != null; line = readLine())
            {
                String[] columnData = splitLine(line);
                if (columnData == null || columnData.length <= 0)
                    continue;

                visitor.visitNode(rowName, null, this);
                if (reportLineNumber)
                {
                    String lineNumber = Integer.toString(lineCount);
                    visitor.visitNode(lineAttributeName, lineNumber, this);
                    visitor.leaveNode(lineAttributeName, this);
                }

                for (int i = 0; i < columnData.length; i++)
                {
                    String columnName = getColumnLabel(i);
                    String columnValue = escapeText(columnData[i]);
                    visitor.visitNode(columnName, columnValue, this);
                    visitor.leaveNode(columnName, this);
                }
                visitor.leaveNode(rowName, this);
            }

        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.READ_ERROR, e);
        }

        visitor.leaveNode(rootName, this);
        visitor.finish(this);

    }

    public static String escapeText(String s)
    {
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
    public boolean isReportLineNumber()
    {
        return reportLineNumber;
    }

    /**
     * Enable line number reporting (default = true)
     * 
     * @param reportLineNumber
     *            enable the line number reporting
     */
    public void setReportLineNumber(boolean reportLineNumber)
    {
        this.reportLineNumber = reportLineNumber;
    }

    /**
     * get the line number node name
     * 
     * @return
     */
    public String getLineAttributeName()
    {
        return lineAttributeName;
    }

    /**
     * Set the line number node name
     * 
     * @param lineAttributeName
     *            the line number node name (default = "line")
     */
    public void setLineAttributeName(String lineAttributeName)
    {
        this.lineAttributeName = lineAttributeName;
    }

    private String[] splitLine(String line)
    {
        if (line.length() <= 0)
            return null;
        else
            return line.split(separator);
    }

    /**
     * Gets the column label of the specified column number
     * 
     * @param columnIndex
     *            the column index
     * @return the column label
     */
    public String getColumnLabel(int columnIndex)
    {
        if (columnIndex < columnLableList.size())
        {
            return columnLableList.get(columnIndex);
        }
        else
        {
            for (int i = columnLableList.size(); i <= columnIndex; i++)
            {
                columnLableList.add("c" + (i + 1));
            }
            return getColumnLabel(columnIndex);
        }

    }

    public List<String> getColumnLabelList()
    {
        return columnLableList;
    }

    public String getRootName()
    {
        return rootName;
    }

    public void setRootName(String rootName)
    {
        this.rootName = rootName;
    }

}
