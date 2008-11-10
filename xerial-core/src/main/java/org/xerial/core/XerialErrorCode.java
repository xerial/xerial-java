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
// StandardErrorCode.java
// Since: Oct 27, 2008 1:02:08 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core;

/**
 * Standard error codes
 * 
 * @author leo
 * 
 */
public enum XerialErrorCode implements ErrorCode {

    // related to programming error
    INVALID_STATE,
    SYNTAX_ERROR,
    NOT_INITIALIZED,
    // collection
    MISSING_ELEMENT,

    // resources 
    RESOURCE_NOT_FOUND,

    // I/O
    READ_ERROR,
    OUTPUT_ERROR,

    // option parser error
    DUPLICATE_OPTION,
    NO_OPTION,
    NO_USAGE_ANNOTATION,
    MISSING_ARGUMENT,

    // type 
    MISSING_TYPE_PARAMETER,
    NOT_A_COLLECTION,
    INACCESSIBLE_METHOD

    ;

    private final String description;

    private XerialErrorCode()
    {
        this.description = EMPTY_DESCRIPTION;
    }

    private XerialErrorCode(String description)
    {
        this.description = description;
    }

    public String getCodeName()
    {
        return name();
    }

    public String getDescription()
    {
        return null;
    }

}
