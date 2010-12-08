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
// SQLiteDataTypeInfo.java
// Since: 2007/05/08
//
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




