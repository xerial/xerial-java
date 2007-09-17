//--------------------------------------
// XerialJ Project
//
// InvalidJSONDataException.java
// Since: 2007/04/02
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.json;


/**
 * Invoked when invalid json data is passed 
 * @author leo
 *
 */
@SuppressWarnings("serial")
public class InvalidJSONDataException extends JSONException {

	public InvalidJSONDataException() {
	}

	public InvalidJSONDataException(String message) {
		super(message);
	}

	public InvalidJSONDataException(Throwable cause) {
		super(cause);
	}

	public InvalidJSONDataException(String message, Throwable cause) {
		super(message, cause);
	}

}




