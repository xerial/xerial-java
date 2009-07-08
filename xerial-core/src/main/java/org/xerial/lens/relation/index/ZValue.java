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
// ZValue.java
// Since: Jul 8, 2009 11:31:56 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.index;

import org.xerial.util.Pair;

/**
 * ZValue for two-dimensional search.
 * 
 * x:31-bit, y:31 bit => zvalue:62 bit
 * 
 * @author leo
 * 
 */
public class ZValue {

    public final long zvalue;

    public ZValue(int x, int y) {
        zvalue = interleave(x, y);
    }

    public static Pair<Integer, Integer> getPoint(long zvalue) {
        int x = 0;
        int y = 0;

        int mask = 1 << 30;
        long cursorOnZValue = 1L << 61;
        for (int i = 0; i < 31; i++) {
            if ((zvalue & cursorOnZValue) != 0)
                x |= mask;

            cursorOnZValue >>>= 1;

            if ((zvalue & cursorOnZValue) != 0)
                y |= mask;

            mask >>>= 1;

            cursorOnZValue >>>= 1;
        }

        return new Pair<Integer, Integer>(x, y);
    }

    public static long interleave(int x, int y) {
        long zvalue = 0;
        int mask = 1 << 30;
        long cursorOnZValue = 1L << 61;
        for (int i = 0; i < 31; i++) {
            if ((x & mask) != 0)
                zvalue |= cursorOnZValue;

            cursorOnZValue >>>= 1;

            if ((y & mask) != 0)
                zvalue |= cursorOnZValue;

            mask >>>= 1;
            cursorOnZValue >>>= 1;
        }

        return zvalue;
    }
}
