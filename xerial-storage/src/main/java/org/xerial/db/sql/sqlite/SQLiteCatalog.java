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
// XerialJ Project
//
// SQLiteCatalog.java
// Since: 2007/05/08
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.xerial.core.XerialException;
import org.xerial.db.DBErrorCode;
import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.sql.RelationBuilder;
import org.xerial.db.sql.SQLExpression;
import org.xerial.json.JSONObject;
import org.xerial.lens.JSONLens;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

/**
 * SQLiteCatalog holds the information of table shamas of a given database.
 * 
 * @author leo
 * 
 */
public class SQLiteCatalog
{

    private static Logger             _logger        = Logger.getLogger(SQLiteCatalog.class);

    private SQLiteAccess              _query;
    private HashMap<String, Relation> _relationTable = new HashMap<String, Relation>();

    // private HashMap<Relation, SQLiteDataTypeInfo> _able = new HashMap<String,
    // SQLiteDataTypeInfo>();

    public SQLiteCatalog(SQLiteAccess query) throws DBException {
        this._query = query;
        searchRelations();
    }

    public void reflesh() throws DBException {
        _relationTable.clear();
        searchRelations();
    }

    public Set<String> getTableNameSet() {
        return _relationTable.keySet();
    }

    public String toJSON() {
        JSONObject relationList = new JSONObject();
        for (String tableName : _relationTable.keySet()) {
            try {
                Relation r = getRelation(tableName);
                JSONObject relationJSONObj = RelationBuilder.toJSON(r);
                relationList.put(tableName, relationJSONObj);
            }
            catch (DBException e) {
                _logger.error(e);
            }
        }
        return relationList.toJSONString();
    }

    private void searchRelations() throws DBException {
        String q = SQLExpression.fillTemplate("select name from sqlite_master where type = '$1'", "table");
        List<String> tableList = _query.singleColumnQuery(q, "name", String.class);
        for (String tableName : tableList) {
            if (tableName.equals("sqlite_master") || tableName.equals("sqlite_sequence"))
                continue;
            _relationTable.put(tableName, _query.getRelationSchema(tableName));
        }
    }

    /**
     * Align the content of a bean object so that it matches with the
     * corresponding relation (table schema)
     * 
     * For example, give a bean class, e.g.
     * <code>class Person { int id; String name; (getters are ommited) } </code>
     * and a table named person with a schema 'id, name', the
     * createValueTupleFromBean("person", (a Person object)) will give a tuple
     * representation of the Person object (id=1, name="leo"), that is
     * '1,"leo"'.
     * 
     * This returned string can be used as it is within an insert statement of
     * the SQL, i.e., <code>insert into person values(1, "leo")</code>
     * 
     * @param tableName
     * @param bean
     * @return
     * @throws DBException
     * @throws InvalidBeanException
     */
    public String createValueTupleFromBean(String tableName, Object bean) throws DBException, XerialException {
        Relation r = getRelation(tableName);

        JSONObject json = new JSONObject(JSONLens.toJSON(bean));

        HashMap<String, String> valueList = new HashMap<String, String>();
        for (String attribute : json.keys())
            valueList.put(attribute, json.get(attribute).toJSONString());

        ArrayList<String> tupleValue = new ArrayList<String>();
        for (Iterator<DataType> it = r.getDataTypeList().iterator(); it.hasNext();) {
            DataType dt = it.next();
            tupleValue.add(valueList.get(dt.getName()));
        }

        return StringUtil.join(tupleValue, ",");
    }

    public List<SQLiteDataTypeInfo> getKeyAttributeName(String tableName) throws DBException {
        List<SQLiteDataTypeInfo> schemaInfo = _query.getSQLiteDataTypeInfo(tableName);

        ArrayList<SQLiteDataTypeInfo> primaryKeySet = new ArrayList<SQLiteDataTypeInfo>();
        for (SQLiteDataTypeInfo typeInfo : schemaInfo) {
            if (typeInfo.isPrimaryKey())
                primaryKeySet.add(typeInfo);
        }
        return primaryKeySet;
    }

    private Relation getRelation(String tableName) throws DBException {
        Relation r = _relationTable.get(tableName);
        if (r == null)
            throw new DBException(DBErrorCode.TableIsNotFound, tableName + " table doesn't exist in the database.");
        return r;
    }

}
