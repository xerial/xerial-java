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
// Pair.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

/** 
 * @author leo
 *
 */
public class Pair<X, Y>
{
    X _x;
    Y _y;
    
    /**
     * 
     */
    public Pair(X x, Y y)
    {
        _x = x;
        _y = y;
    }
    public X getFirst()
    {
        return _x;
    }
    public Y getSecond()
    {
        return _y;
    }
    public void setFirst(X x)
    {
        _x = x;
    }
    public void setSecond(Y y)
    {
        _y = y;
    }
    
    
}



