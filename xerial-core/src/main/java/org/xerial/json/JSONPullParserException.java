//--------------------------------------
// XerialJ Project
//
// JSONPullParserException.java
// Since: May 8, 2007
//
// $Date: 2007-05-08 11:51:00 +0900 (Tue, 08 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONPullParserException.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import org.xerial.core.XerialException;


public class JSONPullParserException extends XerialException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JSONPullParserException() {
	}

	public JSONPullParserException(String message) {
		super(message);
	}

	public JSONPullParserException(Throwable cause) {
		super(cause);
	}

	public JSONPullParserException(String message, Throwable cause) {
		super(message, cause);
	}

}




