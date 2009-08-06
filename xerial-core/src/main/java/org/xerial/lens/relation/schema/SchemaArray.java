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
// SchemaArray.java
// Since: 2009/03/14 12:43:45
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.util.Functor;

/**
 * SchemaArray represents a non-1NF schema element
 * 
 * @author leo
 * 
 */
public class SchemaArray implements Schema, Iterable<Schema>
{
    private final Schema parent;
    private final ArrayList<Schema> column;
    private final FD fd;
    private final HashMap<String, TupleIndex> nodeIndex = new HashMap<String, TupleIndex>();

    public static SchemaArray createClone(SchemaArray other)
    {
        return new SchemaArray(other);
    }

    private SchemaArray(SchemaArray other)
    {
        this(other.parent, other.column, other.fd);
    }

    SchemaArray(Schema parent, List<Schema> schemaElementList, FD fd)
    {
        if (schemaElementList.size() < 1)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "schema element list must be size of one or more");

        this.parent = parent;
        this.column = new ArrayList<Schema>(schemaElementList);
        this.fd = fd;

        for (int i = 0; i < column.size(); ++i)
        {
            buildIndex(new TupleIndex(i));
        }
    }

    private void buildIndex(TupleIndex index)
    {
        Schema e = get(index);
        if (e.isAtom())
            nodeIndex.put(e.getName(), index);
        else
        {
            for (int i = 0; i < e.size(); ++i)
            {
                buildIndex(new TupleIndex(index, i));
            }
        }
    }

    public String getName()
    {
        return column.get(0).getName();
    }

    public Schema get(int index)
    {
        return column.get(index);
    }

    public Schema get(TupleIndex index)
    {
        if (index.size() <= 0)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "invalid schema index");

        int rootIndex = index.get(0);
        if (rootIndex >= column.size())
            return null;

        Schema elem = column.get(rootIndex);
        if (elem.isAtom())
        {
            if (index.hasTail())
                throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format(
                        "schema index %s doesn't match to %s", index, this));
            return elem;
        }
        else
        {
            if (!index.hasTail())
                return elem;
            else
                return elem.get(index.tail());
        }
    }

    public Schema flatten()
    {
        SchemaBuilder builder = new SchemaBuilder();
        builder.setFD(fd);
        flatten(builder, this);
        return builder.build();
    }

    private void flatten(SchemaBuilder builder, Schema elem)
    {
        if (elem.isAtom())
            builder.add(elem);
        else
        {
            for (int i = 0; i < elem.size(); ++i)
                flatten(builder, elem.get(i));
        }
    }

    public FD getFD()
    {
        return fd;
    }

    public boolean isAtom()
    {
        return false;
    }

    public boolean isTuple()
    {
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        buf.append("(");
        for (int i = 0; i < column.size() - 1; ++i)
        {
            buf.append(column.get(i));
            buf.append(", ");
        }
        buf.append(column.get(column.size() - 1));
        buf.append(")");
        buf.append(fd);

        return buf.toString();
    }

    public int size()
    {
        return column.size();
    }

    public boolean isOneToMany()
    {
        return fd != FD.ONE_TO_ONE;
    }

    public boolean isOneToOne()
    {
        return fd == FD.ONE_TO_ONE;
    }

    public TupleIndex getNodeIndex(String nodeName)
    {
        return nodeIndex.get(nodeName);
    }

    public void forEachNestedNodeName(Functor<String, ? > functor)
    {
        for (int i = 0; i < column.size(); ++i)
        {
            column.get(i).forEachNestedNodeName(functor);
        }
    }

    public void accept(SchemaVisitor visitor)
    {
        visitor.visitArray(this);
    }

    public String selfLoopNode()
    {
        SelfLoopFinder finder = new SelfLoopFinder();
        finder.visitArray(this);
        return finder.selfLoopNode;
    }

    public Iterator<Schema> iterator()
    {
        return column.iterator();
    }

    private static class NodeNamePicker implements SchemaVisitor
    {
        List<String> nodeNameList = new ArrayList<String>();

        public void visitArray(SchemaArray array)
        {
            for (int i = 0; i < array.size(); i++)
            {
                array.get(i).accept(this);
            }
        }

        public void visitAtom(SchemaAtom atom)
        {
            nodeNameList.add(atom.getName());
        }

    }

    public List<String> getNodeNameList()
    {
        NodeNamePicker picker = new NodeNamePicker();
        picker.visitArray(this);
        return picker.nodeNameList;
    }

}

class SelfLoopFinder implements SchemaVisitor
{
    HashSet<String> observedNodeName = new HashSet<String>();
    String selfLoopNode = null;

    public void visitArray(SchemaArray array)
    {
        for (Schema each : array)
        {
            if (selfLoopNode == null)
                each.accept(this);
        }
    }

    public void visitAtom(SchemaAtom atom)
    {
        if (selfLoopNode != null)
            return;

        String nodeName = atom.getName();
        if (!observedNodeName.add(nodeName))
        {
            selfLoopNode = nodeName;
        }
    }
}
