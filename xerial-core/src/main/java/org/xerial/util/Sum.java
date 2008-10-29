/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// Sum.java
// Since: 2008/10/28 17:26:43
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

public class Sum implements Reducer<Integer, Integer>
{
    public Integer reduce(Iterable<Integer> input)
    {
        int sum = 0;
        for(Integer each : input)
        {
            sum += each;
        }
        return sum;

    }

}
