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
package org.xerial.relation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * Tuple is a list of {@link TupleCell}s. Tuple class allows Non-1NF
 * representation of the data.
 * 
 * @author leo
 * 
 */
public class Tuple<NodeType> implements TupleCell<NodeType>, Iterable<TupleCell<NodeType>>
{

    private final List<TupleCell<NodeType>> nodeList;

    public Tuple()
    {
        this.nodeList = new ArrayList<TupleCell<NodeType>>();
    }

    public Tuple(Tuple<NodeType> other)
    {
        this(other.nodeList);
    }

    public Tuple(int tupleSize)
    {
        this.nodeList = new ArrayList<TupleCell<NodeType>>(tupleSize);
    }

    public Tuple(List<TupleCell<NodeType>> nodeList)
    {
        this.nodeList = new ArrayList<TupleCell<NodeType>>(nodeList.size());
        for (TupleCell<NodeType> each : nodeList)
        {
            this.nodeList.add(each);
        }
    }

    //    public static Tuple emptyTuple(Schema schema)
    //    {
    //        List<TupleCell> nodeList = new ArrayList<TupleCell>(schema.size());
    //        for (int i = 0; i < schema.size(); i++)
    //        {
    //            Schema subSchema = schema.get(i);
    //            if (subSchema.isAtom())
    //                nodeList.add(null);
    //            else
    //                nodeList.add(emptyTuple(subSchema));
    //        }
    //        return new Tuple(nodeList);
    //    }

    public void add(TupleCell<NodeType> node)
    {
        nodeList.add(node);
    }

    public void set(int index, TupleCell<NodeType> node)
    {
        nodeList.set(index, node);
    }

    public void set(TupleIndex index, TupleCell<NodeType> node)
    {
        if (!index.hasTail())
        {
            set(index.get(0), node);
            return;
        }

        // nested node
        TupleCell<NodeType> target = get(index.get(0));
        if (target == null || !target.isTuple())
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                    "set to invalid element: index = %s in %s", index, this));

        ((Tuple<NodeType>) target).set(index.tail(), node);
    }

    public int size()
    {
        return nodeList.size();
    }

    public void clear()
    {
        nodeList.clear();
    }

    public boolean isEmpty()
    {
        return nodeList.isEmpty();
    }

    public void sort(Comparator<TupleCell<NodeType>> comparator)
    {
        Collections.sort(nodeList, comparator);
    }

    public Iterator<TupleCell<NodeType>> iterator()
    {
        return nodeList.iterator();
    }

    public TupleCell<NodeType> get(int index)
    {
        return nodeList.get(index);
    }

    private static <T> String join(Collection<T> c, String concatinator)
    {
        if (c == null)
            return "";
        int size = c.size();
        if (size == 0)
            return "";

        Iterator<T> it = c.iterator();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; it.hasNext() && i < size - 1; i++)
        {
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
    public String toString()
    {
        return String.format("[%s]", join(nodeList, ", "));
    }

    public boolean addAll(List<TupleCell<NodeType>> relationFragment)
    {
        return nodeList.addAll(relationFragment);
    }

    public NodeType getNode()
    {
        throw new XerialError(XerialErrorCode.UNSUPPORTED);
    }

    public List<TupleCell<NodeType>> getNodeList()
    {
        return nodeList;
    }

    public boolean isNode()
    {
        return true;
    }

    public boolean isTuple()
    {
        return true;
    }

    public TupleCell<NodeType> get(TupleIndex index)
    {
        TupleCell<NodeType> cell = nodeList.get(index.get(0));
        if (index.hasTail())
            return cell.get(index.tail());
        else
            return cell;
    }

    @SuppressWarnings("unchecked")
    public NodeType getNode(int index)
    {
        TupleCell<NodeType> node = get(index);
        if (node.isNode())
            return (NodeType) node;
        else
            throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "node is not found: " + index);
    }

    @SuppressWarnings("unchecked")
    public NodeType getNode(TupleIndex index)
    {
        TupleCell<NodeType> node = get(index);
        if (node == null)
            return null;

        if (node.isNode())
            return (NodeType) node;
        else
            throw new XerialError(XerialErrorCode.MISSING_ELEMENT, "node is not found: " + index);

    }

    public Tuple<NodeType> getTuple()
    {
        return this;
    }

    public void accept(CellVisitor<NodeType> visitor)
    {
        visitor.visitTuple(this);
    }

}
