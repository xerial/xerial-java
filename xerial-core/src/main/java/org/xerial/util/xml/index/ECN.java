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
// ECN.java
// Since: 2005/09/09 10:53:52
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import java.util.Vector;

import org.xerial.util.Algorithm;
import org.xerial.util.MinMax;

/**
 * This class implements the Extensible Composite Number (ECN).
 * 
 * @author leo
 * 
 */
public class ECN implements Comparable<ECN> {
    private Vector<Character> val = new Vector<Character>();

    public ECN() {

    }

    public ECN(String stringRepresentation) {
        String[] composite = stringRepresentation.split("\\.");
        for (String c : composite) {
            int v = Integer.valueOf(c);
            val.add((char) v);
        }
    }

    /**
     * @param i
     */
    public void add(int i) {
        val.add((char) i);
    }

    /**
     * compare
     * 
     * @param other
     * @return
     */
    public int compareTo(ECN other) {
        MinMax<Integer> minmax = Algorithm.minmax(this.size(), other.size());
        for (int i = 0; i < minmax.min(); ++i) {
            int cmp = val.get(i) - other.get(i);
            if (cmp != 0)
                return cmp;
        }
        ECN largerECN = this.size() > other.size() ? this : other;
        for (int i = minmax.min(); i < minmax.max(); ++i) {
            int cmp = largerECN.get(i);
            if (cmp != 0)
                return cmp;
        }
        return 0;
    }

    public int size() {
        return val.size();
    }

    /**
     * @param index
     * @return index�̈
     */
    public int get(int index) {
        return val.get(index);
    }

}
