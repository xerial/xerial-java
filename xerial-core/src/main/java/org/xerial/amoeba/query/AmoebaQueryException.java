//--------------------------------------
// XerialJ Project
//
// AmoebaQueryException.java
// Since: Apr 24, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;

import org.xerial.core.XerialException;


public class AmoebaQueryException extends XerialException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AmoebaQueryException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AmoebaQueryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AmoebaQueryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AmoebaQueryException(Throwable cause) {
		super(cause);
	}
	
}




