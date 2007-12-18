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

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * Exception base class related JSON 
 * @author leo
 *
 */
public class JSONException extends XerialException
{
    private static final long serialVersionUID = 1L;

	/**
     * @param errorCode
     */
    public JSONException(XerialErrorCode errorCode)
    {
        super(errorCode);
    }

    public JSONException(XerialErrorCode errorCode, String message)
	{
	    super(errorCode, message);
	}

    /**
     * @param errorCode
     * @param message
     * @param e
     */
    public JSONException(XerialErrorCode errorCode, String message, Throwable e)
    {
        super(errorCode, message, e);
    }

    /**
     * @param errorCode
     * @param e
     */
    public JSONException(XerialErrorCode errorCode, Throwable e)
    {
        super(errorCode, e);
    }

    /**
     * @param errorCode
     * @param message
     */
    public JSONException(XerialErrorCode errorCode, Object... message)
    {
        super(errorCode, message);
    }
	
    
	
}




