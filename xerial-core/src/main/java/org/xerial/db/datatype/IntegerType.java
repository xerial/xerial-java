//--------------------------------------
// XerialJ Project
//
// IntegerType.java
// Since: 2007/04/13
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;


import org.xerial.db.ValueDomain;




public class IntegerType extends DataTypeBase 
{
	private ValueDomain _valueDomain = null;

	public IntegerType(String name) {
		super(name);
	}
	public IntegerType(String name, ValueDomain valueDomain)
	{
		super(name);
		_valueDomain = valueDomain;
	}
	
	public IntegerType(String name, boolean isPrimaryKey, boolean isNotNull)
	{
		super(name, isPrimaryKey, isNotNull);
	}


	public String getTypeName() {
		return "integer";
	}

	

}




