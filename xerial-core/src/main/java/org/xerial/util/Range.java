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
// Range.java
// Since: Oct 28, 2008 3:22:44 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * Range
 * 
 * @author leo
 */
public class Range implements Comparable<Range>
{
    public final int start;
    public final int end;

    public Range(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(Range other)
    {
        return (other.start <= this.end) && (other.end >= this.start);
    }

    @Override
    public String toString()
    {
        return String.format("(%s,%e)", start, end);
    }

    public int compareTo(Range o)
    {
        int diff = this.start - o.start;
        return diff == 0 ? this.end - o.end : diff;
    }

}
