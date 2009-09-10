/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// XerialException.java
// Since: 2004/12/21
//
// $URL$
// $Author:leo $
//--------------------------------------
package org.xerial.core;

import org.xerial.json.JSONErrorCode;

/**
 * Base exception class for Xerial Project.
 * 
 * XerialException must be instantiated with an error code that implements
 * {@link ErrorCode} interface. To add your own error codes for the use with
 * {@link XerialException}, you have to implement the {@link ErrorCode}
 * interface. See examples of error codes: {@link XerialErrorCode},
 * {@link JSONErrorCode}, etc.
 * 
 * @author leo
 * 
 */
public class XerialException extends Exception
{

    private static final long serialVersionUID = 1L;

    protected final ErrorCode errorCode;

    public XerialException(XerialException e) {
        super(e.getErrorMessage());
        this.errorCode = e.errorCode;
    }

    public XerialException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public XerialException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public XerialException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public XerialException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    @SuppressWarnings("unchecked")
    public <T> T getErrorCode() {
        return (T) errorCode;
    }

    @Override
    public String getMessage() {
        return ExceptionHelper.getMessage(errorCode, super.getMessage());
    }

    private String getErrorMessage() {
        return super.getMessage();
    }

}
