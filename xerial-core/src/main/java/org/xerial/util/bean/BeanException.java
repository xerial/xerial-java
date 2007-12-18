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
// BeanException.java
// Since: Dec 18, 2007 12:47:54 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

public class BeanException extends XerialException
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /**
     * @param errorCode
     * @param message
     * @param e
     */
    public BeanException(XerialErrorCode errorCode, String message, Throwable e)
    {
        super(errorCode, message, e);
    }

    /**
     * @param errorCode
     * @param message
     */
    public BeanException(XerialErrorCode errorCode, String message)
    {
        super(errorCode, message);
    }

    /**
     * @param errorCode
     * @param e
     */
    public BeanException(XerialErrorCode errorCode, Throwable e)
    {
        super(errorCode, e);
    }

    /**
     * @param errorCode
     * @param message
     */
    public BeanException(XerialErrorCode errorCode, Object... message)
    {
        super(errorCode, message);
    }
    
}
