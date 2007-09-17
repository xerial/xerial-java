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


import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.StringType;
import org.xerial.db.sql.ColumnReader;
import org.xerial.db.sql.ConnectionPool;
import org.xerial.db.sql.DatabaseAccess;
import org.xerial.db.sql.JSONObjectReader;
import org.xerial.db.sql.JSONValueReader;
import org.xerial.db.sql.NaiveConnectionPool;
import org.xerial.db.sql.RelationBuilder;
import org.xerial.db.sql.ResultPullReader;
import org.xerial.db.sql.SQLExpression;
import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONObject;
import org.xerial.json.JSONValue;
import org.xerial.util.CollectionUtil;
import org.xerial.util.Functor;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.InvalidBeanException;
import org.xerial.util.log.Logger;

/**
 * SQLiteAccess is not thread safe.
 * @author leo
 *
 */
public class SQLiteAccess 
{
	private DatabaseAccess _dbAccess;
	private SQLiteCatalog _catalog = null;
	private static Logger _logger = Logger.getLogger(SQLiteAccess.class);
	
	
	public SQLiteAccess(String filePath) throws DBException
	{
		this._dbAccess = new DatabaseAccess(new NaiveConnectionPool(SQLite.driverName, SQLite.getDatabaseAddress(filePath)));
	}
	
	
	public SQLiteAccess(DatabaseAccess dbAccess) throws DBException
	{
		this._dbAccess = dbAccess;
	}
	
	public SQLiteCatalog getCatalog() throws DBException
	{
		if(_catalog == null)
			_catalog = new SQLiteCatalog(this);
		
		return _catalog;
	}
	
	
	
	public Collection<String> getTableList() throws DBException
	{
		return getCatalog().getTableNameSet();
	}
	
	public List<SQLiteDataTypeInfo> getSQLiteDataTypeInfo(String tableName) throws DBException
	{
		String sql = SQLExpression.fillTemplate(
				"pragma table_info($1)",
				tableName);
		
		return _dbAccess.query(sql, SQLiteDataTypeInfo.class);
	}
	
	public Relation getRelationSchema(String tableName) throws DBException
	{
		Relation r = new Relation();
		List<SQLiteDataTypeInfo> dataTypeList = getSQLiteDataTypeInfo(tableName);
		
		for(SQLiteDataTypeInfo typeInfo : dataTypeList)
		{
			String name = typeInfo.getName();
			String type = typeInfo.getType();
			type = type.toLowerCase();
				
			DataType dt;
			try {
				dt = Relation.getDataType(name, type);
			} catch (InvalidJSONDataException e) {
				throw new DBException(e);
			}
			dt = new StringType(name);
			r.add(dt);
		}

		return r;
	}

	public void insert(Object bean, String tableName) throws DBException, InvalidBeanException {
		
		String sql = SQLExpression.fillTemplate(
				"insert into $1 values($2)", 
				tableName,
				getCatalog().createValueTupleFromBean(tableName, bean)
		);

		_dbAccess.update(sql);
	}

	public void deleteByKeyValue(Object bean, String tableName) throws DBException, InvalidBeanException {

		List<SQLiteDataTypeInfo> keyAttribute = getCatalog().getKeyAttributeName(tableName);
		ArrayList<String> deleteTargetCondition = new ArrayList<String>();
		for(SQLiteDataTypeInfo key : keyAttribute)
		{
			JSONObject json = BeanUtil.toJSONObject(bean);
			JSONValue value = json.get(key.getName());
			if(value == null)
				throw new DBException("key value cannot be null: " + key.getName());
			deleteTargetCondition.add(key.getName() + "=" + value.toJSONString());
		}
		
		
		String sql = SQLExpression.fillTemplate(
				"delete from $1 $2",
				tableName,
				(deleteTargetCondition.size() > 0) ? "where " + StringUtil.join(deleteTargetCondition, " and ") : ""
		);
		
		
		_dbAccess.update(sql);
		
	}

	@SuppressWarnings("unchecked")
	public void createTable(String tableName, Relation r) throws DBException {
		
		List<String> attributeDefinitionList = 
			CollectionUtil.collectFromNonGenericCollection(r.getDataTypeList(), new Functor<DataType>() {
				public Object apply(DataType dt) {
					String attributeDefinition = dt.getName() + " " + SQLite.getDataTypeName(dt);
					if(dt.isPrimaryKey())
						attributeDefinition += " primary key";
					if(dt.isNotNull())
						attributeDefinition += " not null";
					return attributeDefinition;
				}
			});
		
		String tableSchema = StringUtil.join(attributeDefinitionList, ", ");
		
		String sql = SQLExpression.fillTemplate(
				"create table $1 ($2)",
				tableName,
				tableSchema
		);
		
		_dbAccess.update(sql);
		
		getCatalog().reflesh();
		
	}
	
	
	public void dropTable(String tableName) throws DBException
	{
		String sql = SQLExpression.fillTemplate(
				"drop table $1",
				tableName
		);
		_dbAccess.update(sql);
		
		getCatalog().reflesh();

	}
	
	public <T> List<T> amoebaQuery(Class<T> beanClass, String tableName) throws DBException, InvalidBeanException
	{
		List<String> parameterList = RelationBuilder.extractBeanParameterList(beanClass);
		String sql = SQLExpression.fillTemplate(
				"select $1 from $2",
				StringUtil.join(parameterList, ", "),
				tableName
		);
		return _dbAccess.query(sql, beanClass);
	}
	
	
	public <T> List<T> query(String sql, Class<T> resultRowType) throws DBException
	{
		return _dbAccess.query(sql, resultRowType);
	}
	
	public <T> List<T> query(String sql, String targetColumn, Class<T> resultRowType) throws DBException
	{
		return _dbAccess.query(sql, new ColumnReader<T>(targetColumn));
	}
	
	public void pullQuery(String sql, Writer out) throws DBException
	{
		_dbAccess.pullQueryResult(sql, new ResultPullReader(out));
	}
	
	public List<JSONValue> selectColumnData(String sql, String targetColumn) throws DBException
	{
		return _dbAccess.query(sql, new JSONValueReader(targetColumn));
	}
	
	
	/**
	 * @param sql
	 * @return 
	 * @throws DBException
	 */
	public List<JSONObject> jsonQuery(String sql) throws DBException
	{
		return _dbAccess.query(sql, new JSONObjectReader());
	}
	
	public void update(String sql) throws DBException
	{
		_dbAccess.update(sql);
	}

	public boolean hasTable(String tableName) throws DBException {
		return getCatalog().getTableNameSet().contains(tableName);
	}
	
	
	public ConnectionPool getConnectionPool()
	{
		return _dbAccess.getConnectionPool();
	}
}




