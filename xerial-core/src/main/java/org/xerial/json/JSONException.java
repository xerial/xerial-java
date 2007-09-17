//--------------------------------------
// XerialJ Project
//
// JSONException.java
// Since: 2007/04/26
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.json;

import org.xerial.core.XerialException;


/**
 * Exception base class related JSON 
 * @author leo
 *
 */
public class JSONException extends XerialException {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public JSONException() {
	}

	public JSONException(String message) {
		super(message);
	}

	public JSONException(Throwable cause) {
		super(cause);
	}

	public JSONException(String message, Throwable cause) {
		super(message, cause);
	}

}




