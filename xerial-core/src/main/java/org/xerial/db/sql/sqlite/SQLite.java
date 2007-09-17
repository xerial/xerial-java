//--------------------------------------
// XerialJ Project
//
// SQLite.java
// Since: 2007/05/10
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import org.xerial.db.datatype.BooleanType;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.DoubleType;
import org.xerial.db.datatype.IntegerType;
import org.xerial.db.datatype.PasswordType;
import org.xerial.db.datatype.StringType;
import org.xerial.db.datatype.TextType;

/**
 * This SQLite class holds information related to sqlite3
 * @author leo
 *
 */
public class SQLite 
{
	private SQLite() {}
	
	public static final String driverName = "org.sqlite.JDBC";
	private static final String dbFilePrefix = "jdbc:sqlite:";
	private static final String memoryDatabase = dbFilePrefix + ":memory:";
	
	public static String getDatabaseAddress(String filePath)
	{
		return dbFilePrefix + filePath;
	}
	
	public static String getMemoryDatabaseAddress()
	{
		return memoryDatabase;
	}
	
	public static String getDataTypeName(DataType dataType)
	{
		if(dataType instanceof IntegerType)
			return "integer";
		else if(dataType instanceof StringType || dataType instanceof TextType || dataType instanceof PasswordType)
			return "string";
		else if(dataType instanceof DoubleType)
			return "double";
		else if(dataType instanceof BooleanType)
			return "boolean";
		else 
			return "string";
	}
	
}




