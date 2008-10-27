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
// XMLException.java
// Since: 2004/12/21
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import org.xerial.core.XerialException;

/**
 * The base class for XML related exceptions
 * 
 * @author leo
 */
public class XMLException extends XerialException
{
    private static final long serialVersionUID = 1L;

    public XMLException(XMLErrorCode errorCode, String message, Throwable cause)
    {
        super(errorCode, message, cause);
    }

    public XMLException(XMLErrorCode errorCode, String message)
    {
        super(errorCode, message);
    }

    public XMLException(XMLErrorCode errorCode, Throwable cause)
    {
        super(errorCode, cause);
    }

    public XMLException(XMLErrorCode errorCode)
    {
        super(errorCode);
    }

    public XMLErrorCode getErrorCode()
    {
        return (XMLErrorCode) super.getErrorCode();
    }

}
