//--------------------------------------
// XerialJ Project
//
// Value.java
// Since: 2007/04/03
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db;


/**
 * Add this Value class to the ValueDomain
 * in order to set the value domain of a input form. 
 * @author leo
 *
 */
public class Value  
{
	String label = null;
	String value = null;
	
	public Value() {}
	public Value(String value)
	{
		this.label = value;
		this.value = value;
	}
	public Value(String label, String value)
	{
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}




