/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XMLOrganizer.java
// Since: Oct 11, 2007 10:48:53 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.amoeba;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.sql.ResultSetHandler;
import org.xerial.db.sql.SQLExpression;
import org.xerial.db.sql.sqlite.SQLiteAccess;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.util.CollectionUtil;
import org.xerial.util.Functor;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;
import org.xerial.util.log.SimpleLogWriter;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.xml.XMLAttribute;
import org.xerial.util.xml.XMLGenerator;

/**
 * A program for converting SQLite database into XML
 * 
 * @author leo
 * 
 */
public class XMLOrganizer
{
    public static Logger _logger = Logger.getLogger(XMLOrganizer.class);

    private enum Opt {
        HELP, OUTPUT_FILE, FLAT, AGGREGATE
    }

    private enum StructureType {
        FLAT_XML, AGGREATED_XML
    }

    private StructureType structureType    = StructureType.FLAT_XML;

    private Writer        output           = new OutputStreamWriter(System.out);

    @Option(symbol = "h", longName = "help", description = "display help message")
    private boolean       displayHelp      = false;

    @Option(symbol = "f", longName = "flat", description = "create flat XML (default)")
    private boolean       useFlat          = false;
    @Option(symbol = "a", longName = "aggregate", description = "create aggregated XML")
    private boolean       useAggregatedXML = false;

    @Option(symbol = "o", longName = "output", varName = "FILE", description = "output file")
    private String        outFile          = null;

    @Argument
    private String        dbFileName       = null;

    public static void main(String[] args) {
        final XMLOrganizer organizer = new XMLOrganizer();

        OptionParser option = new OptionParser(organizer);

        _logger.setLogWriter(new SimpleLogWriter(System.err));

        try {
            option.parse(args);
            if (organizer.displayHelp) {
                System.out.println("> XMLOrganizer [option] sqlite_dbfile");
                option.printUsage();
            }

            if (organizer.useFlat)
                organizer.structureType = StructureType.FLAT_XML;

            if (organizer.useAggregatedXML)
                organizer.structureType = StructureType.AGGREATED_XML;

            if (organizer.dbFileName == null) {
                throw new XerialException(XerialErrorCode.INVALID_INPUT, "db file name is not specified");
            }

            if (organizer.outFile == null) {
                String outputFileName = organizer.outFile;
                File outputFile = new File(outputFileName);
                File parentDirOfOutputFile = outputFile.getParentFile();
                if (parentDirOfOutputFile != null) {
                    parentDirOfOutputFile.mkdirs();
                }
                organizer.output = new BufferedWriter(new FileWriter(outputFile));
            }

            organizer.load(organizer.dbFileName);
        }
        catch (XerialException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println("error while opening file: " + e);
        }
    }

    public void load(String sqliteDBFileName) throws XerialException {
        SQLiteAccess sqliteDB = new SQLiteAccess(sqliteDBFileName);
        XMLGenerator xmlOut = new XMLGenerator(output);

        xmlOut.startTag("database", new XMLAttribute("file", sqliteDBFileName));

        switch (structureType) {
        case FLAT_XML:
            flatXML(sqliteDB, xmlOut);
            break;
        case AGGREATED_XML: {
            RecursiveAggregator aggregator = new RecursiveAggregator(sqliteDB, xmlOut);
            aggregator.process();
        }
            break;
        default:
            throw new XerialException(XerialErrorCode.INVALID_INPUT, "Unknown Structure Type");
        }

        xmlOut.endTag(); // database
        xmlOut.endDocument();

        System.out.flush();
    }

    public void flatXML(SQLiteAccess sqliteDB, XMLGenerator xmlOut) throws DBException {
        for (String table : sqliteDB.getTableList()) {
            List<Integer> count = sqliteDB.singleColumnQuery(SQLExpression.fillTemplate(
                    "select count(*) as count from $1", table), "count", Integer.class);
            if (count.size() <= 0)
                continue;
            int rowCount = count.get(0);
            _logger.debug("row count: " + rowCount);

            final int limit = 100;
            int readRowCount = 0;
            while (readRowCount < rowCount) {
                List<JSONObject> rowData = sqliteDB.jsonQuery(SQLExpression.fillTemplate(
                        "select * from $1 limit $2 offset $3", table, limit, readRowCount));
                for (JSONObject obj : rowData) {
                    xmlOut.startTag(table);
                    for (String key : obj.keys()) {
                        try {
                            String value = obj.getString(key);
                            xmlOut.element(key, value);
                        }
                        catch (JSONException e) {
                            _logger.error(e);
                        }
                    }
                    xmlOut.endTag(); // table
                }
                readRowCount += rowData.size();
            }
        }

    }

    class RecursiveAggregator
    {
        SQLiteAccess sqliteDB;
        XMLGenerator xmlOut;

        /**
         * @param sqliteDB
         * @param xmlOut
         */
        public RecursiveAggregator(SQLiteAccess sqliteDB, XMLGenerator xmlOut) {
            this.sqliteDB = sqliteDB;
            this.xmlOut = xmlOut;
        }

        public String generateWhereClause(List<String> conditionList) {
            return conditionList.isEmpty() ? "" : "where " + StringUtil.join(conditionList, " and ");
        }

        public int groupCountQuery(String tableName, String column, List<String> conditionList) throws DBException {
            List<Integer> count = sqliteDB.singleColumnQuery(SQLExpression.fillTemplate(
                    "select count(*) as count from (select * from $1 $2 group by $3)", tableName,
                    generateWhereClause(conditionList), column), "count", Integer.class);
            if (count.size() <= 0)
                return 0;
            return count.get(0);
        }

        public int countQuery(String tableName, List<String> conditionList) throws DBException {
            List<Integer> count = sqliteDB.singleColumnQuery(SQLExpression.fillTemplate(
                    "select count(*) as count from $1 $2", tableName, generateWhereClause(conditionList)), "count",
                    Integer.class);
            return (count.size() <= 0) ? 0 : count.get(0);
        }

        class Count
        {
            public DataType dataType;
            public int      count;

            /**
             * @param dataType
             * @param count
             */
            public Count(DataType dataType, int count) {
                this.dataType = dataType;
                this.count = count;
            }

        }

        class DistinctCountList extends ResultSetHandler<ArrayList<Integer>>
        {
            ArrayList<Integer> countList = new ArrayList<Integer>();

            public ArrayList<Integer> handle(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                countList.clear();
                for (int i = 1; i <= columnCount; i++) {
                    countList.add(rs.getInt(i));
                }
                return countList;
            }
        }

        public Count getMinGroupCount(String tableName, List<DataType> remainingDataTypeList, List<String> conditionList)
                throws DBException {
            ArrayList<String> distinctCountColumnList = new ArrayList<String>();
            for (DataType dt : remainingDataTypeList) {
                distinctCountColumnList.add("count(distinct " + dt.getName() + ")");
            }
            String selectColumnStmt = StringUtil.join(distinctCountColumnList, ", ");

            // select count(distinct column1), count(distinct column1) from
            // (select * from tableName where ...)
            String sql = SQLExpression.fillTemplate("select $1 from (select * from $2 $3)", selectColumnStmt,
                    tableName, generateWhereClause(conditionList));

            ArrayList<Integer> distinctCountList = sqliteDB.accumulate(sql, new DistinctCountList());

            int index = distinctCountList.indexOf(Collections.min(distinctCountList));
            return new Count(remainingDataTypeList.get(index), distinctCountList.get(index));
        }

        public void recursivelyOutputColumnData(String tableName, LinkedList<DataType> columnDataTypeList,
                LinkedList<String> conditionList, boolean isTopElement) throws DBException {
            int rowCount = countQuery(tableName, conditionList);
            if (rowCount <= 0)
                return;

            _logger.debug("recursive: " + columnDataTypeList);

            if (columnDataTypeList.isEmpty())
                return;

            Count minCount = getMinGroupCount(tableName, columnDataTypeList, conditionList);

            if (minCount.count >= rowCount) {
                // no aggregation is required

                List<String> selectColumnList = CollectionUtil.collect(columnDataTypeList,
                        new Functor<DataType, String>() {
                            public String apply(DataType input) {
                                return input.getName();
                            }
                        });
                String selectColumn = StringUtil.join(selectColumnList, ", ");
                String condition = generateWhereClause(conditionList);

                final int limit = 100;
                int readRowCount = 0;
                while (readRowCount < rowCount) {
                    List<JSONObject> rowData = sqliteDB.jsonQuery(SQLExpression.fillTemplate(
                            "select $1 from $2 $3 limit $4 offset $5", selectColumn, tableName, condition, limit,
                            readRowCount));
                    for (JSONObject obj : rowData) {
                        xmlOut.startTag(tableName);

                        for (String key : obj.keys()) {
                            try {
                                String value = obj.getString(key);
                                xmlOut.element(key, value);
                            }
                            catch (JSONException e) {
                                _logger.error(e);
                            }
                        }

                        xmlOut.endTag(); // table
                    }

                    readRowCount += rowData.size();
                }
                return; // exit the loop
            }
            else {
                // further aggregation is possible
                DataType targetColumnOfAggregation = minCount.dataType;

                List distinctValueList = sqliteDB.singleColumnQuery(SQLExpression.fillTemplate(
                        "select distinct $1 from $2 $3 order by $1", targetColumnOfAggregation.getName(), tableName,
                        generateWhereClause(conditionList)), targetColumnOfAggregation.getName(), String.class);

                for (Object columnValueObj : distinctValueList) {
                    String columnValue = columnValueObj.toString();

                    xmlOut.startTag(targetColumnOfAggregation.getName(), new XMLAttribute("value", columnValue));

                    columnDataTypeList.remove(targetColumnOfAggregation);

                    conditionList.addLast(targetColumnOfAggregation.getName() + "=\"" + columnValue + "\"");

                    recursivelyOutputColumnData(tableName, (LinkedList<DataType>) columnDataTypeList.clone(),
                            (LinkedList<String>) conditionList, false);

                    conditionList.removeLast();
                    xmlOut.endTag(); // targetColumnNameOfAggregation
                }
            }

        }

        public void process() throws DBException {
            for (String table : sqliteDB.getTableList()) {
                Relation schema = sqliteDB.getRelationSchema(table);
                LinkedList<DataType> columnDataTypeList = new LinkedList<DataType>();
                columnDataTypeList.addAll(schema.getDataTypeList());

                // aggregate relational data beginning from a column with the
                // fewest number of distinct values.
                LinkedList<String> conditionList = new LinkedList<String>();

                xmlOut.startTag("table", new XMLAttribute("value", table));
                recursivelyOutputColumnData(table, columnDataTypeList, conditionList, true);
                xmlOut.endTag(); // table
            }

        }

    }

}
