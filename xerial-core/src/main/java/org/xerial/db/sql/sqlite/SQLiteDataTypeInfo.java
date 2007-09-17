//--------------------------------------
// XerialJ Project
//
// SQLiteDataTypeInfo.java
// Since: 2007/05/08
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

/**
 * SQLiteDataTypeInfo is a result row format of a query  'pragma table_info(tablename)' 
 * @author leo
 *
 */
public class SQLiteDataTypeInfo 
{
	String name;
	String type;
	boolean isPrimaryKey = false;
	boolean isNotNull = false;

	public SQLiteDataTypeInfo()
	{
		
	}
	
	public SQLiteDataTypeInfo(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isPrimaryKey()
	{
		return isPrimaryKey;
	}
	
	public boolean isPk()
	{
		return isPrimaryKey;
	}
	public void setPk(boolean value) {
		isPrimaryKey = value;
	}
	
	
	public boolean isNotnull()
	{
		return isNotNull;
	}
	
	public void setNotnull(boolean value)
	{
		isNotNull = value;
	}

	
}




