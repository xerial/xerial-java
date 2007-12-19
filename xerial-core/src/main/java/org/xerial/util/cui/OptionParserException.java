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
// Phenome Commons Project
//
// OptionParserException.java
// Since: 2005/01/04
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;

import org.xerial.core.XerialException;


/** 
 * An exception class thrown when illegal states are found when parsing command line arguments
 * 
 * @author leo
 *
 */
public class OptionParserException extends XerialException
{ 

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3906085637814695480L;

    /**
     * 
     */
    public OptionParserException()
    {
        super();
    }

    /**
     * @param message
     */
    public OptionParserException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public OptionParserException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public OptionParserException(Throwable cause)
    {
        super(cause);
    }

}




