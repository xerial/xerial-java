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
// XerialJ
//
// ErrorCode.java
// Since: Sep 20, 2007 12:55:04 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import org.xerial.core.ErrorCode;

/**
 * Error codes used to report {@link DBException} type
 * 
 * @author leo
 * 
 */
public enum DBErrorCode implements ErrorCode {
    InvalidDataFormat, InvalidPageHeader, InvalidBeanClass, InvalidInput,

    // parser
    InvalidToken,

    TableIsNotFound,

    IOError,

    ThreadInterruption,

    PageIsFull,

    UnknownJDBCDriver,

    FailureOnConnectionClose, QueryError, UpdateError,

    SQLiteDBFileNotFound, JDBCConnectionError,

    InvalidSQLExpression,

    InvalidFile, AssociatedObjectAlreadyExist, ExceedsTheCapacity, UnknownError, OutOfIndex, NotSupported;

    private final String description;

    private DBErrorCode()
    {
        this.description = "";
    }

    private DBErrorCode(String description)
    {
        this.description = description;
    }

    public String getCodeName()
    {
        return this.name();
    }

    public String getDescription()
    {
        return null;
    }

}
