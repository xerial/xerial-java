//--------------------------------------
// XerialJ Project
//
// DataType.java
// Since: 2007/04/13
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;


/**
 * DataType interface is used to represtent various data types, e.g., integer, DataTime, Color, etc.
 * 
 * DataTypes are sorted in the order of parameter name
 * @author leo
 *
 */
public interface DataType extends Comparable<DataType> {

	/**
	 * Gets the parameter name (column name in a relation) of the type 
	 * @return the parameter name
	 */
	public String getName();
	/**
	 * Gets the type name of this data type, e.g., integer, boolean, etc.
	 * @return the type name
	 */
	public String getTypeName();
	
	/**
	 * is primary key?
	 * @return true if this data type is used as a primary key, otherwise false.
	 */
	public boolean isPrimaryKey();
	
	/**
	 * allowed to be null? 
	 * @return true if this data type value cannot be null, otherwise false. 
	 */
	public boolean isNotNull();
}




