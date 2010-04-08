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
// Xerial Silk Weaver Project 
//
// SilkWeaverException.java
// Since: Jul 21, 2009 4:15:34 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver;

import org.xerial.core.ErrorCode;
import org.xerial.core.XerialException;

/**
 * Exception base class for the SilkWeaver project
 * 
 * @author leo
 * 
 */
public class SilkWeaverException extends XerialException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SilkWeaverException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public SilkWeaverException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public SilkWeaverException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public SilkWeaverException(ErrorCode errorCode) {
        super(errorCode);
    }

    public SilkWeaverException(XerialException e) {
        super(e);
    }

}
