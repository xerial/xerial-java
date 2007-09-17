//--------------------------------------
// XerialJ Project
//
// ValueDomain.java
// Since: 2007/04/03
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db;

import java.util.ArrayList;
import java.util.List;


/**
 * A ValueDomain shows a set of possible values that can be 
 * used within a DataType in a Relation.   
 * 
 * @author leo
 *
 */
public class ValueDomain  
{
    /**
     * The following line specifies the element type of the List, that is, org.utgenome.gwt.web.client.db.Value. 
     * This information is requried in the GWT compiler.
     * 
     * @gwt.typeArgs <org.utgenome.gwt.web.client.db.Value> 
     */
	List valueList = new ArrayList();
	
	public ValueDomain()
	{}
	public ValueDomain(List valueList)
	{
		this.valueList = valueList;
	}
	
	public List getValueList() {
		return valueList;
	}
	public void setValueList(List valueList) {
		this.valueList = valueList;
	}
	public void addValueList(Value value)
	{
		valueList.add(value);
	}
	
}




