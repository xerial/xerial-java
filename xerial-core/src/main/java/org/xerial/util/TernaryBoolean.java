/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// TernaryBoolean.java
// Since: Jan 7, 2009 2:19:26 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * Ternary boolean value (UNKNOWN, TRUE, FALSE)
 * 
 * @author leo
 * 
 */
public enum TernaryBoolean {
    UNKNOWN, TRUE, FALSE;

    public boolean getBoolean()
    {
        if (this == UNKNOWN)
            throw new XerialError(XerialErrorCode.NOT_INITIALIZED);
        else
            return this == TRUE ? true : false;
    }
}
