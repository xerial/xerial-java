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

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/** 
 * The base class for XML related exceptions
 * @author leo
 */
public class XMLException extends XerialException
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3833181419806668341L;
    /**
     * 
     */
    public XMLException()
    {
        super(XerialErrorCode.XMLException);
    }

    /**
     * @param message
     */
    public XMLException(String message)
    {
        super(XerialErrorCode.XMLException, message);
    }
    /**
     * @param message
     * @param cause
     */
    public XMLException(String message, Throwable cause)
    {
        super(XerialErrorCode.XMLException, message, cause);
    }
    /**
     * @param cause
     */
    public XMLException(Throwable cause)
    {
        super(XerialErrorCode.XMLException, cause);
    }
    /**
     * @param message
     */
    public XMLException(Object... message)
    {
        super(XerialErrorCode.XMLException, message);
    }
    
}




