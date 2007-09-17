//--------------------------------------
// Aqua Project
//
// DBException.java
// Since: 2007/02/25
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db;

import org.xerial.core.XerialException;


/**
 * An exception base class related to the database package
 * @author leo
 *
 */
public class DBException extends XerialException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(Throwable e) {
		super(e);
	}
	
	public DBException(String message, Throwable e)
	{
		super(message, e);
	}

}

