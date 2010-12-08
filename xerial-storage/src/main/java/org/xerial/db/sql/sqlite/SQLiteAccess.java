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
// SQLiteQuery.java
// Since: May 8, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/db/sql/sqlite/SQLiteAccess.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.xerial.core.XerialException;
import org.xerial.db.DBErrorCode;
import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.DataTypeBase;
import org.xerial.db.datatype.TypeName;
import org.xerial.db.sql.ConnectionPool;
import org.xerial.db.sql.ConnectionPoolImpl;
import org.xerial.db.sql.DatabaseAccessBase;
import org.xerial.db.sql.JSONObjectReader;
import org.xerial.db.sql.JSONValueReader;
import org.xerial.db.sql.RelationBuilder;
import org.xerial.db.sql.SQLExpression;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONValue;
import org.xerial.util.CollectionUtil;
import org.xerial.util.Functor;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.log.Logger;

/**
 * SQLiteAccess is not thread safe.
 * 
 * @author leo
 * 
 */
public class SQLiteAccess extends DatabaseAccessBase
{
    private SQLiteCatalog _catalog = null;
    private static Logger _logger  = Logger.getLogger(SQLiteAccess.class);

    /**
     * Create an memory database access
     * 
     * @throws DBException
     */
    public SQLiteAccess() throws DBException {
        super(new ConnectionPoolImpl(SQLite.driverName, SQLite.getMemoryDatabaseAddress(), 1));
    }

    public SQLiteAccess(String filePath) throws DBException {
        super(new ConnectionPoolImpl(SQLite.driverName, SQLite.getDatabaseAddress(filePath)));
    }

    public SQLiteAccess(ConnectionPool connectionPool) throws DBException {
        super(connectionPool);
    }

    public SQLiteCatalog getCatalog() throws DBException {
        if (_catalog == null)
            _catalog = new SQLiteCatalog(this);

        return _catalog;
    }

    public Collection<String> getTableList() throws DBException {
        return getCatalog().getTableNameSet();
    }

    @Override
    public List<String> getTableNameList() throws DBException {
        ArrayList<String> list = new ArrayList<String>();
        for (String s : super.getTableNameList()) {
            if (s.equals("sqlite_sequence"))
                continue;
            list.add(s);
        }
        return list;
    }

    public List<SQLiteDataTypeInfo> getSQLiteDataTypeInfo(String tableName) throws DBException {
        String sql = SQLExpression.fillTemplate("pragma table_info($1)", tableName);
        return query(sql, SQLiteDataTypeInfo.class);
    }

    public Relation getRelationSchema(String tableName) throws DBException {
        Relation r = new Relation();
        List<SQLiteDataTypeInfo> dataTypeList = getSQLiteDataTypeInfo(tableName);

        for (SQLiteDataTypeInfo typeInfo : dataTypeList) {
            String name = typeInfo.getName();
            String type = typeInfo.getType();
            type = type.toLowerCase();

            DataType dt;
            dt = Relation.getDataType(name, type);
            dt = new DataTypeBase(name, TypeName.STRING);
            r.add(dt);
        }

        return r;
    }

    public void deleteByKeyValue(Object bean, String tableName) throws DBException, XerialException {

        List<SQLiteDataTypeInfo> keyAttribute = getCatalog().getKeyAttributeName(tableName);
        ArrayList<String> deleteTargetCondition = new ArrayList<String>();
        for (SQLiteDataTypeInfo key : keyAttribute) {
            JSONObject json = BeanUtil.toJSONObject(bean);
            JSONValue value = json.get(key.getName());
            if (value == null)
                throw new DBException(DBErrorCode.InvalidDataFormat, "key value cannot be null: " + key.getName());
            deleteTargetCondition.add(key.getName() + "=" + value.toJSONString());
        }

        String sql = SQLExpression.fillTemplate("delete from $1 $2", tableName,
                (deleteTargetCondition.size() > 0) ? "where " + StringUtil.join(deleteTargetCondition, " and ") : "");

        update(sql);

    }

    @SuppressWarnings("unchecked")
    public void createTable(String tableName, Relation r) throws DBException {

        List<String> attributeDefinitionList = CollectionUtil.collectFromNonGenericCollection(r.getDataTypeList(),
                new Functor<DataType, String>() {
                    public String apply(DataType dt) {
                        String attributeDefinition = dt.getName() + " " + SQLite.getDataTypeName(dt);
                        if (dt.isPrimaryKey())
                            attributeDefinition += " primary key";
                        if (dt.isNullable())
                            attributeDefinition += " not null";
                        return attributeDefinition;
                    }
                });

        String tableSchema = StringUtil.join(attributeDefinitionList, ", ");

        String sql = SQLExpression.fillTemplate("create table $1 ($2)", tableName, tableSchema);

        update(sql);

        getCatalog().reflesh();

    }

    public void dropTable(String tableName) throws DBException {
        String sql = SQLExpression.fillTemplate("drop table $1", tableName);
        update(sql);

        getCatalog().reflesh();

    }

    public <T> List<T> amoebaQuery(Class<T> beanClass, String tableName) throws DBException {
        List<String> parameterList;
        try {
            parameterList = RelationBuilder.extractBeanParameterList(beanClass);
        }
        catch (XerialException e) {
            throw new DBException(DBErrorCode.InvalidBeanClass, e);
        }
        String sql = SQLExpression.fillTemplate("select $1 from $2", StringUtil.join(parameterList, ", "), tableName);
        return query(sql, beanClass);
    }

    public List<JSONValue> selectColumnData(String sql, String targetColumn) throws DBException {
        return queryWithHandler(sql, new JSONValueReader(targetColumn));
    }

    /**
     * @param sql
     * @return
     * @throws DBException
     */
    public List<JSONObject> jsonQuery(String sql) throws DBException {
        return queryWithHandler(sql, new JSONObjectReader());
    }

    //    public boolean hasTable(String tableName) throws DBException
    //    {
    //        return getCatalog().getTableNameSet().contains(tableName);
    //    }

}
