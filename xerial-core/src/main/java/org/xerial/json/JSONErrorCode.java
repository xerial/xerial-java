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
// JSONErrorCode.java
// Since: Dec 18, 2007 3:48:48 PM
//
// $URL$
// $Author$
//--------------------------------------
/**
 * 
 */
package org.xerial.json;

import org.xerial.core.ErrorCode;

/**
 * 
 * @author leo
 * 
 */
public enum JSONErrorCode implements ErrorCode {

    // JSONException
    InvalidJSONData, KeyIsNotFound, NotAJSONNumber, NotAJSONString, NotAJSONObject, CannotConvertToJSONValue,

    JSONValueIsNotFound, NotInAJSONObject, NotInAJSONArray, UnexpectedEndOfJSON,

    ParseError, InvalidBeanClass, NotInAJSONString, ;

    private final String description;

    private JSONErrorCode(String description)
    {
        this.description = description;
    }

    private JSONErrorCode()
    {
        this.description = EMPTY_DESCRIPTION;
    }

    public String getCodeName()
    {
        return name();
    }

    public String getDescription()
    {
        return description;
    }

}
