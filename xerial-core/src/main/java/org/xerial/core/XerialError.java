/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// XerialJ
//
// XerialRuntimeException.java
// Since: Oct 27, 2008 12:32:23 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core;

/**
 * Unchecked exception class that represents errors related to programming bugs.
 * This type of error is usually unrecoverable.
 * 
 * @author leo
 * 
 */
public class XerialError extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    public XerialError(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public XerialError(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public XerialError(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public XerialError(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public XerialError(XerialError cause) {
        super(cause);
        this.errorCode = cause.getErrorCode();
    }

    public XerialError(XerialException cause) {
        super(cause);
        this.errorCode = cause.getErrorCode();
    }

    /**
     * Get the error code of this error
     * 
     * @return
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return ExceptionHelper.getMessage(errorCode, super.getMessage());
    }

}
