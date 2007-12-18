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
public class JSONException extends XerialException
{
    private static final long serialVersionUID = 1L;
    private final JSONErrorCode errorCode;
    
	/**
     * @param errorCode
     */
    public JSONException(JSONErrorCode errorCode)
    {
        super();
        this.errorCode = errorCode;
    }

    public JSONException(JSONErrorCode errorCode, String message)
	{
	    super(message);
        this.errorCode = errorCode;
	}

    /**
     * @param errorCode
     * @param message
     * @param e
     */
    public JSONException(JSONErrorCode errorCode, String message, Throwable e)
    {
        super(message, e);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode
     * @param e
     */
    public JSONException(JSONErrorCode errorCode, Throwable e)
    {
        super(e);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode
     * @param message
     */
    public JSONException(JSONErrorCode errorCode, Object... message)
    {
        super(message);
        this.errorCode = errorCode;
    }
	
    public String getMessage()
    {
        return "[" + errorCode.name() + "] " + super.getMessage();
    }

	
}




