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
// ExceptionHelper.java
// Since: Oct 27, 2008 12:44:54 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core;

/**
 * Helper class for implementing Exceptions
 * 
 * @author leo
 * 
 */
class ExceptionHelper
{
    static String getMessage(ErrorCode errorCode, String message)
    {
        String errorCodeDescription = errorCode.getDescription();
        String errorCodeDisplay;
        if (errorCodeDescription == null || errorCodeDescription.length() <= 0)
            errorCodeDisplay = String.format("[%s]", errorCode.getCodeName());
        else
            errorCodeDisplay = String.format("[%s: %s]", errorCode.getCodeName(), errorCode.getDescription());

        if (message == null)
            return errorCodeDisplay;
        else
            return String.format("%s:%s", errorCodeDisplay, message);
    }

}
