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
public class Tuple<Element> implements TupleElement<Element>, Iterable<TupleElement<Element>> {

    private final List<TupleElement<Element>> nodeList;

    public Tuple() {
        this.nodeList = new ArrayList<TupleElement<Element>>();
    }

    public Tuple(Tuple<Element> other) {
        this(other.nodeList);
    }

    public Tuple(int tupleSize) {
        this.nodeList = new ArrayList<TupleElement<Element>>(tupleSize);
    }

    public Tuple(List<TupleElement<Element>> nodeList) {
        this.nodeList = new ArrayList<TupleElement<Element>>(nodeList.size());
        for (TupleElement<Element> each : nodeList) {
            this.nodeList.add(each);
        }
    }

    public void add(TupleElement<Element> node) {
        nodeList.add(node);
    }

    public void set(int index, TupleElement<Element> node) {
        nodeList.set(index, node);
    }

    public void set(TupleIndex index, TupleElement<Element> node) {
        if (!index.hasTail()) {
            set(index.get(0), node);
            return;
        }

        // nested node
        TupleElement<Element> target = get(index.get(0));
        if (target == null || !target.isTuple())
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                    "set to invalid element: index = %s in %s", index, this));

        ((Tuple<Element>) target).set(index.tail(), node);
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

    public void sort(Comparator<TupleElement<Element>> comparator) {
        Collections.sort(nodeList, comparator);
    }

    public Iterator<TupleElement<Element>> iterator() {
        return nodeList.iterator();
    }

    public TupleElement<Element> get(int index) {
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

    public boolean addAll(List<TupleElement<Element>> relationFragment) {
        return nodeList.addAll(relationFragment);
    }

    public Element castToNode() {
        return null;
    }

    public Tuple<Element> castToTuple() {
        return this;
    }

    public boolean isNode() {
        return true;
    }

    public boolean isTuple() {
        return true;
    }

    public TupleElement<Element> get(TupleIndex index) {
        TupleElement<Element> cell = nodeList.get(index.get(0));
        if (index.hasTail())
            return cell.get(index.tail());
        else
            return cell;
    }

    @SuppressWarnings("unchecked")
    public Element getNode(int index) {
        TupleElement<Element> node = get(index);
        if (node.isNode())
            return (Element) node;
        else
            throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "node is not found: " + index);
    }

    @SuppressWarnings("unchecked")
    public Element getElement(TupleIndex index) {
        TupleElement<Element> node = get(index);
        if (node == null)
            return null;

        if (node.isNode())
            return (Element) node;
        else
            throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "node is not found: " + index);

    }

    public Tuple<Element> flatten() {
        ArrayList<TupleElement<Element>> array = new ArrayList<TupleElement<Element>>();
        flatten(array, this);
        return new Tuple<Element>(array);
    }

    private void flatten(List<TupleElement<Element>> result, TupleElement<Element> cell) {
        if (cell.isNode())
            result.add(cell);
        else {
            for (TupleElement<Element> each : cell.castToTuple()) {
                flatten(result, each);
            }
        }
    }

    public void accept(TupleElementVisitor<Element> visitor) {
        visitor.visitTuple(this);
    }

}
