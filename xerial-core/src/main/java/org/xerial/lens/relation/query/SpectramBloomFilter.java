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
// Xerial Raquel Project
//
// SpectramBloomFilter.java
// Since: Nov 17, 2008 11:38:23 AM
//
// $URL: http://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/query/SpectramBloomFilter.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation.query;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * A rough implementation of the bloom filter for counting the approximate
 * number of distinct values
 * 
 * @author leo
 * 
 */
public class SpectramBloomFilter<T> {
    private final int tableSize;
    private final byte[] hashTable;
    private final static int BYTE_SIZE = 8;
    private int countOfDistinctElements = 0;
    private int collisionCount = 0;

    public SpectramBloomFilter(int tableSize) {
        if (tableSize <= 0)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format("table size = %d",
                    tableSize));

        this.tableSize = tableSize;
        this.hashTable = new byte[tableSize];
    }

    /**
     * @param value
     * @return true if already exist
     */
    public void insert(T value) {
        int hash = value.hashCode();
        if (hash < 0)
            hash = -hash;
        hash %= (tableSize * BYTE_SIZE);
        int pos = hash / BYTE_SIZE;
        int offset = hash % BYTE_SIZE;
        byte flag = (byte) (1 << offset);

        if ((hashTable[pos] & flag) == 0) {
            hashTable[pos] |= flag;
            countOfDistinctElements++;
        }
        else
            collisionCount++;
    }

    public int count() {
        return countOfDistinctElements;
    }

    public int collisionCount() {
        return collisionCount;
    }

}
