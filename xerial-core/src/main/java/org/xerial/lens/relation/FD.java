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
// XerialJ
//
// FD.java
// Since: May 13, 2009 5:39:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

/**
 * Functional dependency that holds in the relation
 * 
 * @author leo
 * 
 */
public enum FD {
    ONE_TO_ONE("."), ONE_OR_MORE("+"), ZERO_OR_ONE("?"), ZERO_OR_MORE("*");

    private final String symbol;

    private FD(String displaySymbol)
    {
        this.symbol = displaySymbol;
    }

    public boolean isOneToOne()
    {
        return this == ONE_TO_ONE;
    }

    public boolean isOneToMany()
    {
        return this != ONE_TO_ONE;
    }

    @Override
    public String toString()
    {
        return symbol;
    }

}
