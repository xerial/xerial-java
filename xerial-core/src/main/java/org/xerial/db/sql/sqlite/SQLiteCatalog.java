//--------------------------------------
// XerialJ Project
//
// SQLiteCatalog.java
// Since: 2007/05/08
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.xerial.db.DBException;
import org.xerial.db.Relation;
import org.xerial.db.datatype.DataType;
import org.xerial.db.sql.RelationBuilder;
import org.xerial.db.sql.SQLExpression;
import org.xerial.json.JSONObject;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.InvalidBeanException;
import org.xerial.util.log.Logger;

/**
 * SQLiteCatalog holds the information of table shamas of a given database.
 * @author leo
 *
 */
public class SQLiteCatalog {
	
	private static Logger _logger = Logger.getLogger(SQLiteCatalog.class);
	
	private SQLiteAccess _query;
	private HashMap<String, Relation> _relationTable = new HashMap<String, Relation>();
	//private HashMap<Relation, SQLiteDataTypeInfo> _able = new HashMap<String, SQLiteDataTypeInfo>();
	
	public SQLiteCatalog(SQLiteAccess query) throws DBException
	{
		this._query = query;
		searchRelations();
	}

	public void reflesh() throws DBException
	{
		_relationTable.clear();
		searchRelations();
	}
	
	public Set<String> getTableNameSet()
	{
		return _relationTable.keySet();
	}
	
	
	public String toJSON()
	{
		JSONObject relationList = new JSONObject();
		for(String tableName : _relationTable.keySet())
		{
			try {
				Relation r = getRelation(tableName);
				JSONObject relationJSONObj = RelationBuilder.toJSON(r);
				relationList.put(tableName, relationJSONObj);
			} catch (DBException e) {
				_logger.error(e);
			}
		}
		return relationList.toJSONString();
	}
	
	private void searchRelations() throws DBException
	{
		String q = SQLExpression.fillTemplate(
				"select name from sqlite_master where type = '$1'",	"table");
		List<String> tableList = _query.query(q, "name", String.class);
		for(String tableName : tableList)
			_relationTable.put(tableName, _query.getRelationSchema(tableName));
	}
	
	
	/**
	 * Align the content of a bean object so that it matches with the corresponding relation (table schema)  
	 * 
	 * For example, give a bean class, e.g. 
	 * <code>class Person { int id; String name; (getters are ommited) } </code>
	 * and a table named person with a schema 'id, name', 
	 * the createValueTupleFromBean("person", (a Person object)) 
	 * will give a tuple representation of the Person object (id=1, name="leo"), that is '1,"leo"'.
	 * 
	 * This returned string can be used  as it is within an insert statement of the SQL, i.e.,
	 * <code>insert into person values(1, "leo")</code> 
	 * 
	 * @param tableName
	 * @param bean
	 * @return
	 * @throws DBException
	 * @throws InvalidBeanException
	 */
	public String createValueTupleFromBean(String tableName, Object bean) throws DBException, InvalidBeanException
	{
		Relation r = getRelation(tableName);

		JSONObject json = (JSONObject) BeanUtil.toJSONObject(bean);
		
		HashMap<String, String> valueList = new HashMap<String, String>();
		for(String attribute : json.keys())
			valueList.put(attribute, json.get(attribute).toJSONString());

		ArrayList<String> tupleValue = new ArrayList<String>();
		for(Iterator it = r.getDataTypeList().iterator(); it.hasNext(); )
		{
			DataType dt = (DataType) it.next();
			tupleValue.add(valueList.get(dt.getName()));
		}
		
		return StringUtil.join(tupleValue, ",");
	}


	public List<SQLiteDataTypeInfo> getKeyAttributeName(String tableName) throws DBException {
		List<SQLiteDataTypeInfo> schemaInfo = _query.getSQLiteDataTypeInfo(tableName);
		
		ArrayList<SQLiteDataTypeInfo> primaryKeySet = new ArrayList<SQLiteDataTypeInfo>();
		for(SQLiteDataTypeInfo typeInfo : schemaInfo) 
		{
			if(typeInfo.isPrimaryKey())
				primaryKeySet.add(typeInfo);
		}
		return primaryKeySet;
	}
	
	
	private Relation getRelation(String tableName) throws DBException
	{
		Relation r = _relationTable.get(tableName);
		if(r == null)
			throw new DBException(tableName + " table doesn't exist in the database.");
		return r;
	}
	
}

