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
// DBRuntimeException.java
// Since: Sep 1, 2008 11:02:24 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

/**
 * An DBError indicates a serious error has occurred in the application, and the
 * application should not catch this type of exception.
 * 
 * @author leo
 * 
 */
public class DBError extends Error
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final DBErrorCode errorCode;

    public DBError(DBErrorCode errorCode, String message)
    {
        this(errorCode, message, null);
    }

    protected DBError(DBErrorCode errorCode, String message, Throwable cause)
    {
        super(message, cause);
        this.errorCode = errorCode;
    }

    protected DBError()
    {
        this.errorCode = DBErrorCode.UnknownError;
    }

    public DBError(DBErrorCode errorCode, Throwable cause)
    {
        this(errorCode, null, cause);
    }

    public DBError(DBErrorCode errorCode)
    {
        this(errorCode, null, null);
    }

    public DBErrorCode getErrorCode()
    {
        return errorCode;
    }

    @Override
    public String toString()
    {
        String message = getLocalizedMessage();
        if (message == null)
            message = "";
        return String.format("[%s] %s", errorCode, message);
    }

}
