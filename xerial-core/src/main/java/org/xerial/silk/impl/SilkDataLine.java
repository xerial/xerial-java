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
// SilkDataLine.java
// Since: Feb 2, 2009 11:16:05 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.impl;

/**
 * dataline
 * 
 * @author leo
 * 
 */
public class SilkDataLine implements SilkElement
{
    private final String dataLine;

    public SilkDataLine(String dataLine)
    {
        this.dataLine = dataLine;
    }

    public String getDataLine()
    {
        return dataLine;
    }

    @Override
    public String toString()
    {
        return dataLine;
    }
}
