//--------------------------------------
// XerialJ Project
//
// StringType.java
// Since: 2007/04/13
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;

import java.util.Iterator;

import org.xerial.db.ValueDomain;


public class StringType extends DataTypeBase 
{
	transient ValueDomain valueDomain = null;
	
	public StringType(String name)
	{
		super(name);
	}
	public StringType(String name, ValueDomain valueDomain)
	{
		super(name);
		this.valueDomain = valueDomain;
	}
	
	private boolean hasValueDomain()
	{
		return valueDomain != null;
	}
	
	
	public String getTypeName() {
		return "string";
	}

}




