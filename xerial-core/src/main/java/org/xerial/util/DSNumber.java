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
// DSNumber.java
// Since: 2009/05/13 9:29:15
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * DSNumber (Dot-separated number) for specifying a position in a nested node
 * tuple, e.g., 1, 1.1, 1.2, ...etc.
 * 
 * @author leo
 * 
 */
public class DSNumber implements Comparable<DSNumber> {
    private int[] index;

    /**
     * Create an index with a single level, e.g., 1, 2, 3, ...
     * 
     * @param baseIndex
     */
    public DSNumber(int baseIndex) {
        this.index = new int[1];
        this.index[0] = baseIndex;
    }

    /**
     * Create an index based on a parent index, e.g, 1.1, 1.2, 1.1.1, 1.1.2,
     * ..etc.
     * 
     * @param parent
     * @param childIndex
     */
    public DSNumber(DSNumber parent, int childIndex) {
        if (parent == null) {
            this.index = new int[1];
            this.index[0] = childIndex;
        }
        else {
            this.index = new int[parent.size() + 1];
            for (int i = 0; i < parent.size(); ++i)
                index[i] = parent.get(i);
            index[parent.size()] = childIndex;
        }
    }

    public static DSNumber root() {
        return new DSNumber(0);
    }

    public static DSNumber parse(String indexStr) {
        if (indexStr == null)
            throw new NullPointerException("indexStr");

        String[] component = indexStr.split("\\.");
        if (component == null)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "invalid format:" + indexStr);

        int[] index = new int[component.length];
        for (int i = 0; i < component.length; ++i)
            index[i] = Integer.parseInt(component[i]);
        return new DSNumber(index);
    }

    private DSNumber(int[] index) {
        this.index = index;
    }

    public DSNumber parent() {
        if (index.length <= 1)
            return null;

        int[] newIndex = new int[index.length - 1];
        for (int i = 0; i < index.length - 1; ++i)
            newIndex[i] = index[i];
        return new DSNumber(newIndex);
    }

    public DSNumber tail() {
        if (index.length < 2)
            return null;

        int[] newIndex = new int[index.length - 1];
        for (int i = 1; i < index.length; ++i)
            newIndex[i - 1] = index[i];
        return new DSNumber(newIndex);
    }

    public DSNumber sibling() {
        int[] newIndex = new int[index.length];
        for (int i = 0; i < index.length; ++i)
            newIndex[i] = index[i];
        newIndex[index.length - 1]++;
        return new DSNumber(newIndex);
    }

    /**
     * nested level
     * 
     * @return nested level
     */
    public int size() {
        return index.length;
    }

    public boolean hasParent() {
        return index.length > 1;
    }

    public boolean hasTail() {
        return index.length > 1;
    }

    /**
     * Get the index on the specified level
     * 
     * @param level
     * @return
     */
    public int get(int level) {
        return index[level];
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            if (i != 0)
                buf.append(".");
            buf.append(index[i]);
        }
        return buf.toString();
    }

    @Override
    public boolean equals(Object obj) {
        DSNumber other = DSNumber.class.cast(obj);
        if (this.index.length != other.index.length)
            return false;

        for (int i = 0; i < this.index.length; ++i) {
            if (this.index[i] != other.index[i])
                return false;
        }
        return true;

    }

    public int compareTo(DSNumber other) {
        int i1 = 0;
        int i2 = 0;
        int cmp = 0;
        while (i1 < this.index.length && i2 < other.index.length) {
            int e1 = this.index[i1];
            int e2 = other.index[i2];
            cmp = e1 - e2;
            if (cmp != 0)
                return cmp;

            i1++;
            i2++;
        }
        if (i1 < this.index.length)
            return 1;
        else {
            if (i2 < other.index.length)
                return -1;
            else
                return 0;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        for (int i = 0; i < index.length; ++i)
            hash += 137 * index[i];
        return hash / 1987;
    }

}
