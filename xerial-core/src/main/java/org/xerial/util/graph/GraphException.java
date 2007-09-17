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
// GraphException.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import org.xerial.core.XerialException;

/** 
 * Exception base class related to Graph package
 * @author leo
 *
 */
public class GraphException extends XerialException
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256446906237531955L;

    /**
     * 
     */
    public GraphException()
    {
        super();
    }

    /**
     * @param message
     */
    public GraphException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public GraphException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public GraphException(Throwable cause)
    {
        super(cause);
    }

}
