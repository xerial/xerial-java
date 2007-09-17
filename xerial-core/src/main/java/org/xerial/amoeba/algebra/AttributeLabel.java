//--------------------------------------
// XerialJ Project
//
// AttributeLabel.java
// Since: Apr 24, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.algebra;

/**
 * label of the table attributes
 * @author leo
 *
 */
public class AttributeLabel {
	private final static String _null = new String();

	String relationName = _null;
	String name;
	
	public AttributeLabel(String name)
	{ this.name = name; }
	public AttributeLabel(String relationName, String name)
	{
		this.relationName = relationName;
		this.name = name;
	}
	
	public String getName() { return name; }
	public String getRelationName() { return relationName; }
	
	public boolean isGlobal() 
	{
		return relationName == _null;
	}
	
}




