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
// NodeTupleIterator.java
// Since: Nov 26, 2008 4:35:03 PM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/tuple/NodeTupleIterator.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.schema.Schema;

public class NodeTupleIterator implements TupleCursor {
    int cursor = -1;
    int chainIndex = 0;
    final int chainSize;
    final Schema relation;
    final ContainerManager storage;
    TupleContainer cache = null;
    int index = -1;

    public NodeTupleIterator(Schema relation, ContainerManager storage) {
        this.relation = relation;
        this.storage = storage;

        chainSize = storage.numChain(relation);
        readNext();
    }

    public int getIndex() {
        return index;
    }

    void readNext() {
        try {
            if (chainIndex < chainSize) {
                cache = storage.load(relation, chainIndex++);
                cursor = -1;

                //_logger.debug("readNext: " + cache);
            }
            else {
                cache = null;
            }
        }
        catch (XerialException e) {
            throw new XerialError(XerialErrorCode.LOAD_FAILURE, e);
        }
    }

    public boolean hasNext() {
        if (cache == null)
            return false;

        if (cursor + 1 < cache.size()) {
            return true;
        }
        else {
            readNext();
            return hasNext();
        }
    }

    public Tuple<Node> next() {
        cursor++;
        index++;
        return cache.get(cursor);
    }

    public Tuple<Node> peekNext() {
        return cache.get(cursor + 1);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public Schema getSchema() {
        return relation;
    }

}
