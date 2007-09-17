//--------------------------------------
// XerialJ Project
//
// AmoebaTuple.java
// Since: Jul 5, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba;

import java.util.SortedSet;

public interface AmoebaTuple {
	
	/**
	 * This is a short hand method for <code>getValue(getKeyParameterName())</code>
	 * @return
	 */
	public String getKey();
	/**
	 * Gets the value of the corresponding parameterName
	 * @param parameterName
	 * @return the parameter value
	 */
	public String getValue(String parameterName);

	/**
	 * Gets the parameter name of the key attribute 
	 * @return
	 */
	public String getKeyParameterName();
	
	/**
	 * Gets the set of the parameter values
	 * @return
	 */
	public SortedSet<String> getParameterNameSet();
		
}




