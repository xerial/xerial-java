//--------------------------------------
// XerialJ Project
//
// RelationalTable.java
// Since: May 29, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.layer;


public class RelationalTableLayer implements DatabaseLayer
{
	private String tableName;
	
	/**
	 * @param tableName
	 */
	public RelationalTableLayer(String tableName) {
		this.tableName = tableName;
	}




	public DatabaseLayer getParent() {
		return null;
	}
	
}




