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
// XerialExceptionTest.java
// Since: 2004/12/21
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.core;

import org.xerial.core.XerialException;

import junit.framework.TestCase;

/**
 * @author leo
 *
 */
public class XerialExceptionTest extends TestCase
{
    
    public void testVarArgConstructor()
    {
        XerialException e = new XerialException("exception message", 1, "hello");

    }
    
//    public void testVarArgConstructor2()
//    {
//        XerialException e = new XerialException("value:%d", 1);
//        assertEquals("value:1", e.getMessage());
//    }
//
}




