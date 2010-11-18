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
// Tuple.java
// Since: 2009/05/13 9:19:34
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * Tuple is a list of {@link TupleElement}s. This Tuple class allows Non-1NF
 * representation of the data.
 * 
 * @author leo
 * 
 */
public class Tuple<NodeType extends TupleElement<NodeType>> implements TupleElement<NodeType>,
        Iterable<TupleElement<NodeType>> {

    private final List<TupleElement<NodeType>> nodeList;

    public Tuple() {
        this.nodeList = new ArrayList<TupleElement<NodeType>>();
    }

    public Tuple(Tuple<NodeType> other) {
        this(other.nodeList);
    }

    public Tuple(int tupleSize) {
        this.nodeList = new ArrayList<TupleElement<NodeType>>(tupleSize);
    }

    public Tuple(List<TupleElement<NodeType>> nodeList) {
        this.nodeList = new ArrayList<TupleElement<NodeType>>(nodeList.size());
        for (TupleElement<NodeType> each : nodeList) {
            this.nodeList.add(each);
        }
    }

    public Iterator<TupleElement<NodeType>> iterator() {
        return nodeList.iterator();
    }

    public void add(TupleElement<NodeType> elem) {
        nodeList.add(elem);
    }

    public void set(int index, TupleElement<NodeType> node) {
        nodeList.set(index, node);
    }

    public int size() {
        return nodeList.size();
    }

    public void clear() {
        nodeList.clear();
    }

    public boolean isEmpty() {
        return nodeList.isEmpty();
    }

    public void sort(Comparator<TupleElement<NodeType>> comparator) {
        Collections.sort(nodeList, comparator);
    }

    public TupleElement<NodeType> get(int index) {
        return nodeList.get(index);
    }

    private static <T> String join(Collection<T> c, String concatinator) {
        if (c == null)
            return "";
        int size = c.size();
        if (size == 0)
            return "";

        Iterator<T> it = c.iterator();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; it.hasNext() && i < size - 1; i++) {
            Object data = it.next();
            if (data != null)
                buf.append(data.toString());
            else
                buf.append("null");
            buf.append(concatinator);
        }
        Object lastData = it.next();
        if (lastData != null)
            buf.append(lastData.toString());
        else
            buf.append("null");
        return buf.toString();
    }

    @Override
    public String toString() {
        return String.format("[%s]", join(nodeList, ", "));
    }

    public boolean addAll(List<NodeType> relationFragment) {
        return nodeList.addAll(relationFragment);
    }

    public boolean isAtom() {
        return true;
    }

    public boolean isTuple() {
        return true;
    }

    public void accept(TupleVisitor<NodeType> visitor) {
        visitor.visitTuple(this);
    }

    public NodeType castToNode() {
        return null;
    }

    public Tuple<NodeType> castToTuple() {
        return this;
    }

    public void set(TupleIndex index, TupleElement<NodeType> node) {
        if (!index.hasTail()) {
            set(index.get(0), node);
            return;
        }

        // nested node
        TupleElement<NodeType> target = get(index.get(0));
        if (target == null || !target.isTuple())
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                    "set to invalid element: index = %s in %s", index, this));

        Tuple<NodeType> tuple = (Tuple<NodeType>) target;
        tuple.set(index.tail(), node);
    }

    public TupleElement<NodeType> get(TupleIndex index) {
        TupleElement<NodeType> cell = nodeList.get(index.get(0));
        if (index.hasTail())
            return cell.get(index.tail());
        else
            return cell;
    }

    public NodeType getNode(int index) {
        TupleElement<NodeType> node = get(index);
        if (node.isAtom())
            return node.castToNode();
        else
            throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "node is not found: " + index);
    }

    public NodeType getNode(TupleIndex index) {
        TupleElement<NodeType> node = get(index);
        if (node == null)
            return null;

        if (node.isAtom())
            return node.castToNode();
        else
            throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "node is not found: " + index);

    }

    public Tuple<NodeType> flatten() {
        ArrayList<TupleElement<NodeType>> array = new ArrayList<TupleElement<NodeType>>();
        flatten(array, this.castToTuple());
        return new Tuple<NodeType>(array);
    }

    private void flatten(List<TupleElement<NodeType>> result, TupleElement<NodeType> cell) {
        if (cell.isAtom())
            result.add(cell.castToNode());
        else {
            for (TupleElement<NodeType> each : cell.castToTuple()) {
                flatten(result, each);
            }
        }
    }

}
