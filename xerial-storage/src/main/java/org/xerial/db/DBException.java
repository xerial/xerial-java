/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
 * 
 * @author leo
 * 
 */
public class DBException extends XerialException
{

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private final DBErrorCode errorCode;

    public DBException(DBErrorCode errorCode)
    {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public DBException(DBErrorCode errorCode, String message)
    {
        super(errorCode, message);
        this.errorCode = errorCode;
    }

    public DBException(DBErrorCode errorCode, Throwable e)
    {
        super(errorCode, e);
        this.errorCode = errorCode;
    }

    public DBException(DBErrorCode errorCode, String message, Throwable e)
    {
        super(errorCode, message, e);
        this.errorCode = errorCode;
    }

    public DBErrorCode getErrorCode()
    {
        return errorCode;
    }
}
