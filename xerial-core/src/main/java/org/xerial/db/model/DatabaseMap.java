//--------------------------------------
// XerialJ Project
//
// DatabaseMap.java
// Since: May 22, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.model;

import java.util.List;

import org.xerial.db.layer.DatabaseLayer;
import org.xerial.util.tree.BinaryTree;

public class DatabaseMap 
{
	private BinaryTree<DatabaseLayer> _treeMap = new BinaryTree<DatabaseLayer>();
	

	public List<DatabaseLayer> getDBLayer(String datamodelNodeName)
	{
		return null;
	}
	
	public String translateToSQL(String amoebaQuery)
	{
		return null;
	}
	
}




