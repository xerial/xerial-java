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
// XerialJ Project
//
// XMLBeanException.java
// Since: 2005/01/12
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.bean;

import org.xerial.util.xml.XMLException;

/**
 * XMLBean‚ÉŠÖ˜A‚·‚é—áŠO
 * @author leo
 *
 */
public class XMLBeanException extends XMLException
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256721762719839287L;

    /**
     * 
     */
    public XMLBeanException()
    {
        super();
    }

    /**
     * @param message
     */
    public XMLBeanException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public XMLBeanException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public XMLBeanException(Throwable cause)
    {
        super(cause);
    }



}




