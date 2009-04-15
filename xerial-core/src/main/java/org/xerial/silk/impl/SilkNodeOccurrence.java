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
// SilkNodeOccurrence.java
// Since: Jan 30, 2009 7:15:46 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

/**
 * node occurrence
 * 
 * @author leo
 * 
 */
public enum SilkNodeOccurrence {

    ONE("."),
    ZERO_OR_MORE("*"),
    ONE_OR_MORE("+"),
    ZERO_OR_ONE("?"),
    SEQUENCE(">"),
    TABBED_SEQUENCE("|"),
    MULTILINE_SEQUENCE(">>");

    private String symbol;

    private SilkNodeOccurrence(String symbol)
    {
        this.symbol = symbol;
    }

    public boolean isFollowedByStreamData()
    {
        return this == SEQUENCE || this == TABBED_SEQUENCE || this == ZERO_OR_MORE || this == MULTILINE_SEQUENCE;
    }

    @Override
    public String toString()
    {
        return symbol;
    }
}
