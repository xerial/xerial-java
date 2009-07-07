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
// Xerial Raquel Project
//
// SchemaAtom.java
// Since: 2009/03/14 14:38:21
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;
import java.util.List;

import org.xerial.lens.relation.DataType;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.util.Functor;

/**
 * Singleton element in a schema definition
 * 
 * @author leo
 * 
 */
public class SchemaAtom implements Schema {
    public final String nodeName;
    public final FD fd;
    public final DataType type;

    public SchemaAtom(String nodeName) {
        this(nodeName, FD.ONE_TO_ONE);
    }

    public SchemaAtom(String nodeName, FD fd) {
        this(nodeName, DataType.STRING, fd);
    }

    public SchemaAtom(String nodeName, DataType type, FD fd) {
        this.nodeName = nodeName;
        this.type = type;
        this.fd = fd;
    }

    public Schema get(TupleIndex index) {
        throw new UnsupportedOperationException("atom:get");
    }

    @Override
    public String toString() {

        if (type != null)
            return String.format("%s[%s]%s", nodeName, type, fd.isOneToMany() ? "*" : "");
        else
            return String.format("%s%s", nodeName, fd.isOneToMany() ? "*" : "");
    }

    public String getName() {
        return nodeName;
    }

    public boolean isAtom() {
        return true;
    }

    public boolean isNested() {
        return false;
    }

    public int size() {
        return 1;
    }

    public FD getFD() {
        return fd;
    }

    public Schema flatten() {
        return this;
    }

    public Schema get(int index) {
        return this;
    }

    public boolean isOneToMany() {
        return false;
    }

    public boolean isOneToOne() {
        return true;
    }

    public TupleIndex getNodeIndex(String nodeName) {
        throw new UnsupportedOperationException("getNodeIndex()");
    }

    public void forEachNestedNodeName(Functor<String, ? > functor) {
        functor.apply(nodeName);
    }

    public void accept(SchemaVisitor visitor) {
        visitor.visitAtom(this);
    }

    public String selfLoopNode() {
        return null;
    }

    public List<String> getNodeNameList() {
        List<String> l = new ArrayList<String>(1);
        l.add(this.getName());
        return l;
    }

}
