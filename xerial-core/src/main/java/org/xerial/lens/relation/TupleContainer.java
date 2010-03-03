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
// TupleContainer.java
// Since: 2009/03/14 23:57:47
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.util.StringUtil;
import org.xerial.util.io.Buffer;
import org.xerial.util.io.BufferReader;
import org.xerial.util.io.BufferWriter;
import org.xerial.util.log.Logger;

/**
 * On memory {@link XMLTuple} holder.
 * 
 * @author leo
 * 
 */
public class TupleContainer implements Iterable<Tuple<Node>> {
    private static Logger _logger = Logger.getLogger(TupleContainer.class);

    private final Schema schema;
    private Tuple<Node> buffer; // [ [tuple1], [tuple2], ... ]
    private int byteSize = 0;

    public TupleContainer(Schema schema) {
        this.schema = schema;
        this.buffer = new Tuple<Node>();
    }

    /**
     * Copy constructor
     * 
     * @param other
     */
    public TupleContainer(TupleContainer other) {
        this.schema = other.getSchema();
        this.buffer = new Tuple<Node>(other.buffer);
        this.byteSize = other.byteSize;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public Schema getSchema() {
        return schema;
    }

    public boolean hasEnoughRoomFor(Tuple<Node> newTuple, int maximumByteSize) {
        return ByteSize.getByteSize(newTuple) <= (maximumByteSize - getByteSize());
    }

    public void add(Tuple<Node> relation) {
        if (relation.size() != schema.size())
            throw new XerialError(XerialErrorCode.INVALID_INPUT, String.format(
                    "relation size must be %d, but the input has %d nodes", schema.size(), relation
                            .size()));

        buffer.add(relation);
        byteSize += ByteSize.getByteSize(relation);
    }

    public int getByteSize() {
        return byteSize;
    }

    public void sort(List<String> orderBy) {
        buffer.sort(new RelationComparator(orderBy));
    }

    @Override
    public String toString() {
        List<String> buf = new ArrayList<String>();
        for (TupleElement<Node> each : buffer) {
            buf.add(each.toString());
        }
        return StringUtil.join(buf, "\n");
    }

    class RelationComparator implements Comparator<TupleElement<Node>> {
        List<TupleIndex> relationIndexListForSorting = new ArrayList<TupleIndex>();

        public RelationComparator(List<String> orderBy) {
            for (String each : orderBy) {
                TupleIndex index = schema.getNodeIndex(each);
                if (index == null)
                    throw new XerialError(XerialErrorCode.INVALID_ARGUMENT, each);

                relationIndexListForSorting.add(index);
            }
        }

        String getValue(TupleElement<Node> elem, TupleIndex index) {
            if (elem == null)
                return null;
            TupleElement<Node> e = elem.get(index);
            if (e.isTuple())
                return getValue(e, TupleIndex.ZERO);
            else
                return getValue(e.castToNode());
        }

        String getValue(TupleElement<Node> elem) {
            Node node = Node.class.cast(elem);
            return node != null ? node.nodeValue : null;
        }

        public int compare(TupleElement<Node> left, TupleElement<Node> right) {
            // null < other values
            for (TupleIndex eachIndex : relationIndexListForSorting) {
                String leftValue = getValue(left, eachIndex);
                String rightValue = getValue(right, eachIndex);
                if (leftValue == null) {
                    if (rightValue == null)
                        continue;
                    else
                        return -1;
                }
                else {
                    if (rightValue == null)
                        return 1;
                    else {
                        int cmp = leftValue.compareTo(rightValue);
                        if (cmp != 0)
                            return cmp;
                    }
                }
            }

            return 0;

        }

    }

    public TupleCursor iterator() {
        return new TupleCursor() {

            int cursor = 0;

            public Tuple<Node> peekNext() {
                return get(cursor);
            }

            public boolean hasNext() {
                return cursor < size();
            }

            public Tuple<Node> next() {
                return get(cursor++);
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public Schema getSchema() {
                return schema;
            }
        };

    }

    public TupleCursor getInputCursor() {
        return iterator();
    }

    private static class ByteSize implements TupleVisitor<Node> {
        int byteSize = 0;

        public static int getByteSize(Tuple<Node> tuple) {
            ByteSize b = new ByteSize();
            b.visitTuple(tuple);
            return b.byteSize;
        }

        public void visitNode(Node node) {
            byteSize += 8; // node id size (4) + string length (4) 
            if (node.nodeValue != null)
                byteSize += node.nodeValue.getBytes().length;
        }

        public void visitTuple(Tuple<Node> tuple) {
            if (tuple == null)
                return;

            for (TupleElement<Node> each : tuple) {
                if (each == null)
                    continue;
                each.accept(this);
            }

        }

    }

    private static class TupleWriter implements TupleVisitor<Node> {
        BufferWriter writer;
        int writtenByteSize = 0;

        public TupleWriter(BufferWriter writer) {
            this.writer = writer;
        }

        public void visitNode(Node node) {
            writer.writeLong(node.nodeID);
            writtenByteSize += Buffer.LONG_SIZE;
            if (node.nodeValue != null) {
                byte[] binaryValue = node.nodeValue.getBytes();
                writer.writeInt(binaryValue.length);
                writtenByteSize += 4;
                for (byte b : binaryValue)
                    writer.writeByte(b);

                writtenByteSize += binaryValue.length;
            }
            else {
                writer.writeInt(0);
                writtenByteSize += 4;
            }
        }

        public void visitTuple(Tuple<Node> tuple) {
            // write relation size & buffer size 
            // The minus size value indicates the beginning of the tuple
            writer.writeInt(-tuple.size());
            writtenByteSize += 4;

            for (TupleElement<Node> each : tuple)
                each.accept(this);
        }

    }

    /**
     * @param writer
     * @return the total bite size of the written data
     */
    public int dump(BufferWriter writer) {
        TupleWriter writeProcess = new TupleWriter(writer);
        buffer.accept(writeProcess);
        return writeProcess.writtenByteSize;
    }

    public void clear() {
        byteSize = 0;
        buffer.clear();
    }

    private class TupleReader {
        BufferReader reader;
        Schema schema;

        public TupleReader(BufferReader reader, Schema schema) {
            this.reader = reader;
            this.schema = schema;
        }

        public Tuple<Node> load() throws XerialException {
            int tupleSize = reader.readInt();
            if (tupleSize > 0)
                throw new XerialException(XerialErrorCode.INVALID_STATE,
                        "tuple size must be writtin in negative integer");

            tupleSize = -tupleSize;
            Tuple<Node> newTuple = new Tuple<Node>(tupleSize);
            for (int i = 0; i < tupleSize; ++i) {
                newTuple.add(loadTuple(schema));
            }
            return newTuple;
        }

        private Tuple<Node> loadTuple(Schema tupleSchema) throws XerialException {
            int tupleSize = reader.readInt();
            if (tupleSize > 0 || -tupleSize != tupleSchema.size())
                throw new XerialException(XerialErrorCode.INVALID_STATE, String.format(
                        "tuple size doesn't match: %d and %d", tupleSize, tupleSchema.size()));
            tupleSize = -tupleSize;

            Tuple<Node> tuple = new Tuple<Node>(tupleSize);
            for (int i = 0; i < tupleSize; ++i) {
                Schema columnSchema = tupleSchema.get(i);
                if (columnSchema.isAtom()) {
                    String nodeName = columnSchema.getName();
                    tuple.add(loadXMLNode(nodeName));
                }
                else {
                    // ((A, B), C, D)
                    tuple.add(loadTuple(columnSchema));
                }

            }
            return tuple;
        }

        private TupleElement<Node> load(Schema cellSchema) {
            int nodeID = reader.readInt();
            if (nodeID < 0) {
                // tuple  
                int numTuple = -nodeID;
                Tuple<Node> tuple = new Tuple<Node>(numTuple);
                for (int i = 0; i < numTuple; ++i) {
                    tuple.add(load(cellSchema));
                }
                return tuple;
            }
            else {
                return loadXMLNode(cellSchema, nodeID);
            }
        }

        private TupleElement<Node> loadXMLNode(Schema schema, int nodeID) {
            if (schema.isAtom()) {
                String nodeName = schema.getName();
                return loadXMLNode(nodeName, nodeID);
            }
            else {
                Tuple<Node> tuple = new Tuple<Node>(schema.size());
                tuple.add(loadXMLNode(schema.get(0), nodeID));
                for (int i = 1; i < schema.size(); ++i) {
                    tuple.add(load(schema.get(i)));
                }
                return tuple;
            }
        }

        private Node loadXMLNode(String nodeName) {
            int nodeID = reader.readInt();
            return loadXMLNode(nodeName, nodeID);
        }

        private Node loadXMLNode(String nodeName, int nodeID) {
            Node.NodeBuilder nodeBuilder = new Node.NodeBuilder(nodeName);
            nodeBuilder.nodeID(nodeID);
            int textDataLength = reader.readInt();
            // build XML node
            nodeBuilder.nodeID(nodeID);
            if (textDataLength > 0) {
                byte[] textBuf = new byte[textDataLength];
                for (int l = 0; l < textDataLength; ++l)
                    textBuf[l] = reader.readByte();
                nodeBuilder.nodeValue(new String(textBuf));
            }
            return nodeBuilder.build();

        }

    }

    public void load(BufferReader reader) {
        clear();
        buffer = null;

        TupleReader tupleReader = new TupleReader(reader, schema);
        try {
            buffer = tupleReader.load();
            byteSize = ByteSize.getByteSize(buffer);
        }
        catch (XerialException e) {
            _logger.error(e);
        }

    }

    public int size() {
        return buffer.size();
    }

    public Tuple<Node> get(int index) {
        TupleElement<Node> cell = buffer.get(index);
        if (cell.isTuple())
            return cell.castToTuple();
        else
            throw new XerialError(XerialErrorCode.INVALID_STATE,
                    "tuple cache can only contain XMLTuple: " + cell);
    }
}
