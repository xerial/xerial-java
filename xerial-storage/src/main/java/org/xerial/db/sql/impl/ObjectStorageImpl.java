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
// ObjectStorageImpl.java
// Since: Jun 26, 2008 3:28:06 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.db.DBErrorCode;
import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.sql.DatabaseAccess;
import org.xerial.db.sql.ObjectStorage;
import org.xerial.db.sql.PreparedStatementHandler;
import org.xerial.db.sql.QueryParam;
import org.xerial.db.sql.RelationBuilder;
import org.xerial.db.sql.SQLExpression;
import org.xerial.util.Pair;
import org.xerial.util.Predicate;
import org.xerial.util.StringUtil;
import org.xerial.util.lens.ObjectLens;
import org.xerial.util.log.Logger;

/**
 * An implementation of the {@link ObjectStorage}
 * 
 * @author leo
 * 
 */
public class ObjectStorageImpl implements ObjectStorage
{
    private static Logger                   _logger                               = Logger.getLogger(ObjectStorageImpl.class);

    private DatabaseAccess                  dbAccess;

    private HashSet<String>                 registeredTableSet                    = new HashSet<String>();
    private HashMap<Class< ? >, Relation>   relationOfEachClass                   = new HashMap<Class< ? >, Relation>();
    private HashMap<Class< ? >, String>     tableNameOfEachClass                  = new HashMap<Class< ? >, String>();

    private HashMap<Class< ? >, Class< ? >> associatedClassOfOneToOneRelationship = new HashMap<Class< ? >, Class< ? >>();

    public ObjectStorageImpl(DatabaseAccess dbAccess) {
        this.dbAccess = dbAccess;
    }

    public DatabaseAccess getDatabaseAccess() {
        return dbAccess;
    }

    public static Date getNowDate() {
        Date preciseNow = new Date();
        DateFormat instance = DateFormat.getDateTimeInstance();
        try {
            return instance.parse(instance.format(preciseNow));
        }
        catch (ParseException e) {
            _logger.error(e);
            throw new IllegalStateException(e);
        }
    }

    public <T> T create(T bean) throws DBException {
        Class< ? > beanType = bean.getClass();

        String tableName = getTableName(beanType);
        Relation r = getRelation(beanType);
        try {
            Date now = getNowDate();
            setCreatedAtTimeStamp(bean, now);
            setModifiedAtTimeStamp(bean, now);

            final Pair<List<Pair<DataType, String>>, List<byte[]>> valueData = retrieveColumnValueAndBlobList(r, bean);

            ArrayList<String> valueList = new ArrayList<String>();
            for (Pair<DataType, String> pair : valueData.getFirst()) {
                valueList.add(pair.getSecond());
            }

            String sql = SQLExpression.fillTemplate("insert into $1($2) values($3)", tableName,
                    StringUtil.join(writableAttributeList(r), ", "), StringUtil.join(valueList, ", "));

            int lastGeneratedID = dbAccess.insertAndRetrieveKeysWithPreparedStatement(sql,
                    new PreparedStatementHandler() {

                        public void setup(PreparedStatement preparedStatement) throws SQLException {
                            int index = 1;
                            for (byte[] blob : valueData.getSecond()) {
                                preparedStatement.setBytes(index++, blob);
                            }

                        }
                    });
            setBeanID(bean, lastGeneratedID);
        }
        catch (XerialException e) {
            throw new DBException(DBErrorCode.UpdateError, e);
        }

        return bean;
    }

    /**
     * Set a time stamp to the object
     * 
     * @param <T>
     * @param bean
     * @param timeStampParameterName
     *            (createdAt or modifiedAt)
     * @throws BeanException
     */
    private static <T> void setTimeStamp(T bean, String timeStampParameterName, Date timeStamp) throws XerialException {
        ObjectLens lens = ObjectLens.getObjectLens(bean.getClass());
        try {
            lens.setParameter(bean, timeStampParameterName, timeStamp);
        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.InvocationTargetException, e);
        }

    }

    public static <T> void setCreatedAtTimeStamp(T bean, Date timeStamp) throws XerialException {
        setTimeStamp(bean, "createdAt", timeStamp);
    }

    public static <T> void setModifiedAtTimeStamp(T bean, Date timeStamp) throws XerialException {
        setTimeStamp(bean, "modifiedAt", timeStamp);
    }

    private <T, U> boolean isOneToOne(Class<T> parent, Class<U> child) {
        return associatedClassOfOneToOneRelationship.containsKey(parent)
                && associatedClassOfOneToOneRelationship.get(parent).equals(child);
    }

    public <T, U> U create(T parentObject, U associatedObject) throws DBException {
        setParentBeanID(parentObject, associatedObject);

        if (isOneToOne(parentObject.getClass(), associatedObject.getClass())) {
            if (getOne(parentObject, associatedObject.getClass()) != null) {
                throw new DBException(DBErrorCode.AssociatedObjectAlreadyExist);
            }
        }

        return create(associatedObject);
    }

    public <T, U, V> V create(T parent, U parent2, V newObject) throws DBException {
        setParentBeanID(parent, newObject);
        setParentBeanID(parent2, newObject);
        return create(newObject);
    }

    public <T, U, V> V create(Class<T> parent, int idOfT, Class<U> parent2, int idOfU, V newObject) throws DBException {
        setParentBeanID(parent, idOfT, newObject);
        setParentBeanID(parent2, idOfU, newObject);
        return create(newObject);
    }

    public static <T> void setBeanID(T bean, int id) throws DBException {
        setValue(bean, "id", id);
    }

    public static <T, U> void setParentBeanID(T parentObject, U associatedObject) throws DBException {
        int parentID = getBeanID(parentObject);
        setParentBeanID(parentObject.getClass(), parentID, associatedObject);
    }

    public static <T, U> void setParentBeanID(Class<T> parentClass, int idOfT, U associatedObject) throws DBException {
        String parentIDParamName = parentClass.getSimpleName() + "Id";
        setValue(associatedObject, parentIDParamName, idOfT);
    }

    public static <T> void setValue(T bean, String parameterName, Object value) throws DBException {
        try {
            Class< ? > beanClass = bean.getClass();
            ObjectLens lens = ObjectLens.getObjectLens(beanClass);
            lens.setParameter(bean, parameterName, value);
        }
        catch (Exception e) {
            throw new DBException(DBErrorCode.InvalidBeanClass, e);
        }
    }

    public static <T> int getBeanID(T bean) throws DBException {
        return Integer.class.cast(getValue(bean, "id"));
    }

    public static <T, U> int getAssociatedBeanID(T bean, Class<U> associatedClass) throws DBException {
        String associatedBeanIDName = getAssociatedIDColumnName(associatedClass);
        return Integer.class.cast(getValue(bean, associatedBeanIDName));
    }

    public static <T> String getAssociatedIDColumnName(Class<T> parentClass) {
        String parentClassName = parentClass.getSimpleName();
        return parentClassName.substring(0, 1).toLowerCase() + parentClassName.substring(1) + "Id";
    }

    /**
     * Retrieves the bean value using the getter corresponding to the given
     * parameter name
     * 
     * @param <T>
     * @param bean
     * @param parameterName
     * @return thre result of getSomething() method
     * @throws XerialException
     */
    public static <T> Object getValue(T bean, String parameterName) throws DBException {
        try {
            ObjectLens lens = ObjectLens.getObjectLens(bean.getClass());
            return lens.getParameter(bean, parameterName);
        }
        catch (Exception e) {
            _logger.error(e);
            throw new DBException(DBErrorCode.InvalidBeanClass, e);
        }
    }

    public static <T> Pair<List<Pair<DataType, String>>, List<byte[]>> retrieveColumnValueAndBlobList(
            Relation relation, T bean) {
        ArrayList<Pair<DataType, String>> valueList = new ArrayList<Pair<DataType, String>>();
        ArrayList<byte[]> blobList = new ArrayList<byte[]>();
        for (DataType dt : relation.getDataTypeList()) {
            if (dt.getName().equals("id"))
                continue; // skip ID attribute
            Object value = null;
            try {
                value = getValue(bean, dt.getName());
            }
            catch (Exception e) {
                _logger.error(e);
            }

            switch (dt.getType()) {
            case INTEGER:
            case LONG:
            case DOUBLE:
                // no quotation
                valueList.add(new Pair<DataType, String>(dt, value == null ? "" : value.toString()));
                break;
            case DATETIME: {
                Date date = Date.class.cast(value);
                String dateValue = (date == null) ? "" : String.format("'%s'",
                        DateFormat.getDateTimeInstance().format(date));
                valueList.add(new Pair<DataType, String>(dt, dateValue));

                break;
            }
            case BLOB: {
                valueList.add(new Pair<DataType, String>(dt, "?"));
                byte[] blobData = byte[].class.cast(value);
                if (blobData != null) {
                    blobList.add(blobData);
                }
                else
                    blobList.add(new byte[0]);
                break;
            }
            case BOOLEAN:
            case PASSWORD:
            case STRING:
            case TEXT:
            default:
                // with quotation
                valueList.add(new Pair<DataType, String>(dt, String.format("'%s'",
                        value == null ? "" : value.toString())));
                break;
            }
        }
        return new Pair<List<Pair<DataType, String>>, List<byte[]>>(valueList, blobList);

    }

    public static List<String> writableAttributeList(Relation relation) {
        ArrayList<String> writableAttributeList = new ArrayList<String>();
        for (DataType dt : relation.getDataTypeList()) {
            if (dt.getName().equals("id"))
                continue; // skip ID attribute
            writableAttributeList.add(dt.getName());
        }
        return writableAttributeList;
    }

    public <T> T get(Class<T> classType, int id) throws DBException {
        String tableName = getTableName(classType);
        String sql = SQLExpression.fillTemplate("select $1 from $2 where id = $3", getSelectColumnList(classType),
                tableName, id);

        List<T> result = dbAccess.query(sql, classType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public <T> T get(Class<T> classType, String sql) throws DBException {
        List<T> result = dbAccess.query(sql, classType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public <T, U> List<U> getAll(T startPoint, Class<U> associatedType) throws DBException {
        int startPointID = getBeanID(startPoint);
        return getAll(startPoint.getClass(), startPointID, associatedType);
    }

    public <T, U> List<U> getAllWithSorting(T startPoint, Class<U> associatedType) throws DBException {
        int startPointID = getBeanID(startPoint);
        String tableName = getTableName(associatedType);
        String parentIDColumnName = getAssociatedIDColumnName(startPoint.getClass());
        String sql = SQLExpression.fillTemplate("select $1 from $2 u where $3 = $4 order by u.id",
                getSelectColumnList(associatedType, "u."), tableName, parentIDColumnName, startPointID);
        return dbAccess.query(sql, associatedType);
    }

    public <T, U> List<U> getAll(T startPoint, Class<U> associatedType, QueryParam queryParam) throws DBException {
        int startPointID = getBeanID(startPoint);
        return getAll(startPoint.getClass(), startPointID, associatedType, queryParam);
    }

    public <T, U> List<U> getAll(Class<T> startPointClass, int idOfT, Class<U> associtedType) throws DBException {
        String tableName = getTableName(associtedType);
        String parentIDColumnnString = getAssociatedIDColumnName(startPointClass);
        String sql = SQLExpression.fillTemplate("select $1 from $2 where $3 = $4", getSelectColumnList(associtedType),
                tableName, parentIDColumnnString, idOfT);
        return dbAccess.query(sql, associtedType);
    }

    public <T, U> List<U> getAll(Class<T> startPointClass, int idOfT, Class<U> associatedType, QueryParam queryParam)
            throws DBException {
        String tableName = getTableName(associatedType);
        String parentIDColumnName = getAssociatedIDColumnName(startPointClass);
        String sql = SQLExpression.fillTemplate("select $1 from $2 u where $3 = $4 $5 order by $6",
                getSelectColumnList(associatedType, "u."), tableName, parentIDColumnName, idOfT,
                (queryParam.getWhereCondition() != null) ? "and " + queryParam.getWhereCondition() : "",
                (queryParam.getOrderByColumns() != null) ? queryParam.getOrderByColumns() : "u.id");
        return dbAccess.query(sql, associatedType);
    }

    public <T> List<T> getAll(Class<T> classType) throws DBException {
        return getAll(classType, (Predicate<T>) null);
    }

    public <T> List<T> getAll(Class<T> classType, String sql) throws DBException {
        return dbAccess.query(sql, classType);
    }

    public <T> List<T> getAll(Class<T> classType, Predicate<T> filterPredicate) throws DBException {
        String tableName = getTableName(classType);
        String sql = SQLExpression.fillTemplate("select $1 from $2", getSelectColumnList(classType), tableName);
        if (filterPredicate != null)
            return dbAccess.query(sql, classType, filterPredicate);
        else
            return dbAccess.query(sql, classType);
    }

    public <T, U> U getOne(T startPoint, Class<U> associatedType) throws DBException {
        int parentID;
        parentID = getBeanID(startPoint);
        return getOne(startPoint.getClass(), parentID, associatedType);
    }

    public <T, U> U getOne(T startPoint, Class<U> associatedType, int idOfU) throws DBException {
        String tableNameOfU = getTableName(associatedType);
        String parentIDColumnName = getAssociatedIDColumnName(startPoint.getClass());
        int parentID = getBeanID(startPoint);

        String sql = SQLExpression.fillTemplate("select $5 from $1 where $2 = $3 and id = $4", tableNameOfU,
                parentIDColumnName, parentID, idOfU, getSelectColumnList(associatedType));
        List<U> result = dbAccess.query(sql, associatedType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;

    }

    public <T> String getSelectColumnList(Class<T> objectType) throws DBException {
        return getSelectColumnList(objectType, "");
    }

    public <T> String getSelectColumnList(Class<T> objectType, String prefix) throws DBException {
        Relation r = getRelation(objectType);
        ArrayList<String> columnNameList = new ArrayList<String>();
        for (DataType dt : r.getDataTypeList()) {
            columnNameList.add(prefix + dt.getName());
        }
        return StringUtil.join(columnNameList, ", ");
    }

    public <T, U, V> V get(Class<T> parent, int idOfT, Class<U> parent2, int idOfU, Class<V> objectType)
            throws DBException {
        String tableNameOfV = getTableName(objectType);
        String parentIDColumnName = getAssociatedIDColumnName(parent);
        String parent2IDColumnName = getAssociatedIDColumnName(parent2);

        String sql = SQLExpression.fillTemplate("select $1 from $2 where $3 = $4 and $5 = $6",
                getSelectColumnList(objectType), tableNameOfV, parentIDColumnName, idOfT, parent2IDColumnName, idOfU);

        List<V> result = dbAccess.query(sql, objectType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public <T, U> U getOne(Class<T> startPointClass, int idOfT, Class<U> associatedType) throws DBException {
        String tableNameOfU = getTableName(associatedType);
        String parentIDColumnName = getAssociatedIDColumnName(startPointClass);

        String sql = SQLExpression.fillTemplate("select $1 from $2 where $3 = $4", getSelectColumnList(associatedType),
                tableNameOfU, parentIDColumnName, idOfT);
        List<U> result = dbAccess.query(sql, associatedType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;

    }

    public <T, U> U getOne(Class<T> startPointClass, int idOfT, Class<U> associatedType, int idOfU) throws DBException {
        String tableNameOfU = getTableName(associatedType);
        String parentIDColumnName = getAssociatedIDColumnName(startPointClass);

        String sql = SQLExpression.fillTemplate("select $1 from $2 where $3 = $4 and id = $5",
                getSelectColumnList(associatedType), tableNameOfU, parentIDColumnName, idOfT, idOfU);
        List<U> result = dbAccess.query(sql, associatedType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public <T, U> T getParent(U child, Class<T> parentType) throws DBException {
        int parentID = getAssociatedBeanID(child, parentType);
        String parentTableName = getTableName(parentType);
        String sql = SQLExpression.fillTemplate("select $1 from $2 where id = $3", getSelectColumnList(parentType),
                parentTableName, parentID);
        List<T> result = dbAccess.query(sql, parentType);
        if (result == null || result.size() <= 0)
            return null;
        else
            return result.get(0);

    }

    public <T, U> T getParent(Class<T> parentClass, Class<U> childClass, int idOfU) throws DBException {
        String parentTableName = getTableName(parentClass);
        String childTableName = getTableName(childClass);
        String sql = SQLExpression.fillTemplate("select $1 from $2 t, $3 u where u.id = $4",
                getSelectColumnList(parentClass, "t."), parentTableName, childTableName, idOfU);
        List<T> result = dbAccess.query(sql, parentClass);
        if (result == null || result.size() <= 0)
            return null;
        else
            return result.get(0);

    }

    public <T, U> void oneToOne(Class<T> from, Class<U> to) throws DBException {
        associatedClassOfOneToOneRelationship.put(from, to);
    }

    public static <T> String createTableSchema(Relation r) throws XerialException {
        LinkedList<String> columnDefList = new LinkedList<String>();
        for (DataType dt : r.getDataTypeList()) {
            StringBuilder columnDef = new StringBuilder();
            columnDef.append(String.format("%s %s", dt.getName(), dt.getTypeName()));

            if (dt.getName().equals("id")) {
                columnDef.append(" primary key autoincrement not null");
                // id attribute must be the first column
                columnDefList.addFirst(columnDef.toString());
            }
            else
                columnDefList.add(columnDef.toString());
        }

        return StringUtil.join(columnDefList, ", ");
    }

    public static <T> String createTableSchema(Class<T> classType) throws XerialException {
        Relation r = RelationBuilder.createRelation(classType);
        return createTableSchema(r);
    }

    public <T> void register(Class<T> classType) throws DBException {
        String tableName = classType.getSimpleName().toLowerCase();
        register(tableName, classType);
    }

    public <T> void register(String tableName, Class<T> classType) throws DBException {
        if (registeredTableSet.contains(tableName) && tableNameOfEachClass.containsKey(classType))
            return; // already registered

        try {
            Relation relation = RelationBuilder.createRelation(classType);
            if (!dbAccess.hasTable(tableName)) {
                // No corresponding table is found, so create a new table
                String sql = dbAccess.createTableSQL(tableName, relation);
                _logger.info(String.format("create a new table %s", tableName));
                dbAccess.update(sql);
            }

            // TODO It it needed to test duplicate entries?
            tableNameOfEachClass.put(classType, tableName);
            relationOfEachClass.put(classType, relation);
            registeredTableSet.add(tableName);

        }
        catch (XerialException e) {
            throw new DBException(DBErrorCode.InvalidBeanClass, e);
        }

    }

    private String getTableNameWithoutRegister(Class< ? > beanType) {
        String tableName = tableNameOfEachClass.get(beanType);
        if (tableName == null) {
            return beanType.getSimpleName().toLowerCase();
        }
        else
            return tableName;
    }

    private boolean isRegistered(Class< ? > beanType) {
        return tableNameOfEachClass.get(beanType) != null;
    }

    private String getTableName(Class< ? > beanType) throws DBException {
        if (!isRegistered(beanType)) {
            // if no corresponding table name for the given beanType was found, register the class
            register(beanType);
            return getTableName(beanType);
        }
        else
            return getTableNameWithoutRegister(beanType);
    }

    private Relation getRelation(Class< ? > beanClass) throws DBException {
        Relation r = relationOfEachClass.get(beanClass);
        if (r == null) {
            try {
                r = RelationBuilder.createRelation(beanClass);
                relationOfEachClass.put(beanClass, r);
            }
            catch (XerialException e) {
                throw new DBException(DBErrorCode.InvalidBeanClass, e);
            }
        }
        return r;
    }

    //    public <T> void saveBlob(Class<T> objectClass, int id, String parameterName, final byte[] blobData)
    //            throws DBException
    //    {
    //        String tableName = getTableName(objectClass);
    //        String sql = SQLExpression.fillTemplate("update $1 set $2 = ? where id = $3", tableName, parameterName, id);
    //        dbAccess.updateWithPreparedStatement(sql, new PreparedStatementHandler() {
    //            public void setup(PreparedStatement preparedStatement) throws SQLException
    //            {
    //                preparedStatement.setBytes(1, blobData);
    //            }
    //        });
    //    }
    //
    //    public <T> void saveBlob(T object, String parameterName, final byte[] blobData) throws DBException
    //    {
    //        saveBlob(object.getClass(), getBeanID(object), parameterName, blobData);
    //    }
    //
    public static <T> Pair<String, List<byte[]>> createUpdateStatement(Relation relation, T bean) {
        Pair<List<Pair<DataType, String>>, List<byte[]>> valueData = retrieveColumnValueAndBlobList(relation, bean);
        ArrayList<String> setStatementList = new ArrayList<String>();
        for (Pair<DataType, String> pair : valueData.getFirst()) {
            String columnName = pair.getFirst().getName();
            if (columnName.equalsIgnoreCase("createdAt"))
                continue;
            setStatementList.add(String.format("%s = %s", columnName, pair.getSecond()));
        }
        return new Pair<String, List<byte[]>>(StringUtil.join(setStatementList, ", "), valueData.getSecond());
    }

    public <T> void save(T bean) throws DBException {
        Class< ? > beanType = bean.getClass();
        String tableName = getTableName(beanType);

        try {
            Relation r = getRelation(beanType);
            int id = getBeanID(bean);

            Date now = getNowDate();
            setModifiedAtTimeStamp(bean, now);

            final Pair<String, List<byte[]>> setValueList = createUpdateStatement(r, bean);
            String sql = SQLExpression.fillTemplate("update $1 set $2 where id = $3", tableName,
                    setValueList.getFirst(), id);

            dbAccess.updateWithPreparedStatement(sql, new PreparedStatementHandler() {
                public void setup(PreparedStatement preparedStatement) throws SQLException {
                    int index = 1;
                    for (byte[] blob : setValueList.getSecond()) {
                        preparedStatement.setBytes(index++, blob);
                    }
                }
            });

        }
        catch (XerialException e) {
            throw new DBException(DBErrorCode.InvalidBeanClass, e);
        }
    }

    public <T> void saveAll(Class<T> classType, Collection<T> objectList) throws DBException {
        String tableName = getTableName(classType);
        Date now = getNowDate();
        try {
            Relation r = getRelation(classType);
            dbAccess.update("begin transaction");
            for (T bean : objectList) {
                int id = getBeanID(bean);

                setModifiedAtTimeStamp(bean, now);

                final Pair<String, List<byte[]>> setValueList = createUpdateStatement(r, bean);
                String sql = SQLExpression.fillTemplate("update $1 set $2 where id = $3", tableName,
                        setValueList.getFirst(), id);

                dbAccess.updateWithPreparedStatement(sql, new PreparedStatementHandler() {
                    public void setup(PreparedStatement preparedStatement) throws SQLException {
                        int index = 1;
                        for (byte[] blob : setValueList.getSecond()) {
                            preparedStatement.setBytes(index++, blob);
                        }
                    }
                });
            }
            dbAccess.update("commit");
        }
        catch (Exception e) {
            dbAccess.update("rollback");
            throw new DBException(DBErrorCode.UpdateError, e);
        }

    }

    //    
    //    public <T> byte[] getBlob(Class<T> objectClass, int id, String parameterName) throws DBException
    //    {
    //        String tableName = getTableName(objectClass);
    //        String sql = SQLExpression.fillTemplate("select $1 from $2 where id = $3", parameterName, tableName, id);
    //
    //        return null;
    //    }
    //
    //    public <T> byte[] getBlob(T object, String parameterName) throws DBException
    //    {
    //        return getBlob(object.getClass(), getBeanID(object), parameterName);
    //    }

    public <T> T get(Class<T> classType, QueryParam queryParam) throws DBException {
        List<T> result = getAll(classType, queryParam);
        return result.size() > 0 ? result.get(0) : null;
    }

    public <T> List<T> getAll(Class<T> classType, QueryParam queryParam) throws DBException {
        assert (queryParam != null);
        String sql = SQLExpression.fillTemplate("select $1 from $2 $3", getSelectColumnList(classType),
                getTableName(classType), queryParam.toSQLFragment());
        return dbAccess.query(sql, classType);
    }

    public <T> int count(Class<T> classType) throws DBException {
        return count(classType, new QueryParam());
    }

    public <T> int count(Class<T> classType, QueryParam queryParam) throws DBException {
        assert (queryParam != null);
        String sql = SQLExpression.fillTemplate("select count(*) as count from $1 $2", getTableName(classType),
                queryParam.toSQLFragment());
        return count(sql);
    }

    int count(String sql) throws DBException {
        List<ResultCount> countList = dbAccess.query(sql, ResultCount.class);
        if (countList.size() > 0)
            return countList.get(0).getCount();
        else
            return 0;
    }

    public <T, U> int count(Class<T> parent, int idOfT, Class<U> objectType) throws DBException {
        String parentIdColumn = getAssociatedIDColumnName(parent);

        String sql = SQLExpression.fillTemplate("select count(*) as count from $1 where $2 = $3",
                getTableName(objectType), parentIdColumn, idOfT);
        return count(sql);
    }

    public <T, U, V> int count(Class<T> parent, int idOfT, Class<U> parent2, int idOfU, Class<V> objectType)
            throws DBException {
        String parentIdColumn = getAssociatedIDColumnName(parent);
        String parent2IdColumn = getAssociatedIDColumnName(parent2);

        String sql = SQLExpression.fillTemplate("select count(*) as count from $1 where $2 = $3 and $4 = $5",
                getTableName(objectType), parentIdColumn, idOfT, parent2IdColumn, idOfU);

        return count(sql);
    }

    public <T> void delete(T object) throws DBException {
        int id = getBeanID(object);
        delete(object.getClass(), id);
    }

    public <T> void delete(Class<T> objectType, int id) throws DBException {
        String sql = SQLExpression.fillTemplate("delete from $1 where id = $2", getTableName(objectType), id);
        dbAccess.update(sql);
    }

    public <View, ObjectType> List<View> getAllFromView(Class<View> viewType, Class<ObjectType> objectType)
            throws DBException {
        String sql = SQLExpression.fillTemplate("select $1 from $2", getSelectColumnList(viewType),
                getTableName(objectType));
        return getAllFromView(viewType, sql);
    }

    public <View, ObjectType> List<View> getAllFromView(Class<View> viewType, String sql) throws DBException {
        return dbAccess.query(sql, viewType);
    }

    public <View, ObjectType> View getFromView(Class<View> viewType, Class<ObjectType> objectType) throws DBException {
        String sql = SQLExpression.fillTemplate("select $1 from $2", getSelectColumnList(viewType),
                getTableName(objectType));
        return getFromView(viewType, sql);
    }

    public <View> View getFromView(Class<View> viewType, String sql) throws DBException {
        List<View> result = dbAccess.query(sql, viewType);
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public <T> void drop(Class<T> classType) throws DBException {
        String sql = SQLExpression.fillTemplate("drop table if exists $1", getTableNameWithoutRegister(classType));
        dbAccess.update(sql);

    }
}
