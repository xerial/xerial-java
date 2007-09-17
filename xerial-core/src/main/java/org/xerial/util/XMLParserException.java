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
// XMLParserException.java
// Since: 2005/01/12
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

import org.xerial.util.xml.XMLException;

/**
 * XMLÇÃparserÇ…ä÷Ç∑ÇÈó·äOÅBparserÇÃê∂ê¨é∏îsÇ»Ç«
 * @author leo
 *
 */
public class XMLParserException extends XMLException
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4051326755778607409L;

    /**
     * 
     */
    public XMLParserException()
    {
        super();
    }

    /**
     * @param message
     */
    public XMLParserException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public XMLParserException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public XMLParserException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @param message
     */
    public XMLParserException(Object... message)
    {
        super(message);
    }

}




