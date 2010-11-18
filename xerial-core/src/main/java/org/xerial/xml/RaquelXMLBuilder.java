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
// RaquelXMLBuilder.java
// Since: 2008/11/23 22:27:42
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.ContainerManager;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.NodeTupleIterator;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.TupleContainer;
import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.lens.relation.query.SpectramBloomFilter;
import org.xerial.lens.relation.query.TableJoin;
import org.xerial.lens.relation.query.TableJoin.OneToManyTupleCursor;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.lens.relation.schema.SchemaMapping;
import org.xerial.lens.relation.schema.SchemaSet;
import org.xerial.lens.relation.schema.XMLSkeltonNode;
import org.xerial.util.Range;
import org.xerial.util.graph.Automaton;
import org.xerial.util.graph.AutomatonCursor;
import org.xerial.util.log.Logger;
import org.xerial.xml.XMLGenerator.IndentType;

/**
 * Compact XML builder
 * 
 * @author leo
 * 
 */
public class RaquelXMLBuilder {
    private static Logger _logger = Logger.getLogger(RaquelXMLBuilder.class);

    private final ContainerManager storage;
    private final SchemaSet schemaSet;
    private final Automaton<XMLSkeltonNode, String> skelton;
    //private final Map<Schema, List<NodeValueCardinality>> distinctNodeCountOfEachRelation;
    private final XMLGenerator xml;

    public RaquelXMLBuilder(ContainerManager storage, SchemaSet schema) {
        //            Map<Schema, List<NodeValueCardinality>> distinctNodeCountOfEachRelation) {
        this.storage = storage;
        this.schemaSet = schema;
        //this.distinctNodeCountOfEachRelation = distinctNodeCountOfEachRelation;
        this.skelton = schema.getSkelton();

        xml = new XMLGenerator();
        setIndentLevel(1);
    }

    public void setIndentLevel(int indentLevel) {
        xml.setIndentCharacter(IndentType.SPACE, indentLevel);
    }

    public void build() throws XerialException {

        if (_logger.isTraceEnabled())
            _logger.trace("relation graph: \n" + skelton.toGraphviz());

        XMLSkeltonNode root = schemaSet.getRootSkelton();
        if (_logger.isDebugEnabled())
            _logger.debug("root:" + root);

        new XMLBuilder(root).build();
        xml.endDocument();
    }

    private static final int CORE_NODE_INDEX = 0; // A-node index
    private static final int M_NODE_INDEX = 1; // M node index of 1:M relationship

    class XMLBuilder {
        final XMLSkeltonNode target;
        final TupleContainer parentTuples;

        public XMLBuilder(XMLSkeltonNode target) {
            // for root relation
            this(null, target);
        }

        /**
         * @param parentTuples
         *            parent tuples that belong to the same group
         * @param target
         */
        public XMLBuilder(TupleContainer parentTuples, XMLSkeltonNode target) {
            if (target.size() <= 0)
                throw new XerialError(XerialErrorCode.INVALID_STATE,
                        "target must have at least one TupleSchema");

            this.parentTuples = parentTuples;
            this.target = target;
        }

        private boolean hasTwig() {
            return !skelton.getAdjacentStates(target).isEmpty();
        }

        /**
         * build XML beginning from the base relation
         */
        public void build() {
            if (_logger.isDebugEnabled())
                _logger.debug("=== build: " + target);

            if (parentTuples == null) {
                // read all
                if (target.size() != 1)
                    throw new XerialError(XerialErrorCode.INVALID_STATE,
                            "root tuple list must be size 1");

                TupleContainer buffer = readAll(target.get(0));

                new LeafTableBuilder(buffer).build();
                return;
            }

            // left join parent and the current target
            // TODO handle multiple relations to be joined

            String joinNodeName = target.getCoreNodeName();

            TupleContainer mergedTable = null;
            for (Schema each : target) {
                // left join with parent table
                NodeTupleIterator rightIterator = new NodeTupleIterator(each, storage);
                TupleContainer tmpResult = TableJoin.leftSemiJoin(parentTuples.getInputCursor(),
                        joinNodeName, each.isOneToMany() ? new OneToManyTupleCursor(rightIterator)
                                : rightIterator);

                if (mergedTable == null)
                    mergedTable = tmpResult;
                else {
                    // outer join
                    mergedTable = TableJoin.outerJoin(mergedTable.getInputCursor(), joinNodeName,
                            tmpResult.getInputCursor());
                }

                if (_logger.isDebugEnabled())
                    _logger.debug("after join:\n" + mergedTable);
            }

            if (!mergedTable.isEmpty()) {
                new LeafTableBuilder(mergedTable).build();
            }
            else {
                // output only core node 
                new LeafTableBuilder(parentTuples, new SchemaBuilder().add(joinNodeName).build())
                        .build();
            }

        }

        Schema getOneToOneSchema() {
            for (Schema each : target) {
                if (each.isOneToOne())
                    return each;
            }

            return null;
        }

        /**
         * read the whole content on the vector
         * 
         * @return
         */
        TupleContainer readAll(Schema targetRelation) {
            if (_logger.isDebugEnabled())
                _logger.debug("read all: " + targetRelation);
            TupleContainer result = new TupleContainer(targetRelation);
            for (NodeTupleIterator cursor = new NodeTupleIterator(targetRelation, storage); cursor
                    .hasNext();)
                result.add(cursor.next());

            if (_logger.isDebugEnabled())
                _logger.debug("read count: " + result.size());

            return result;
        }

        class LeafTableBuilder {
            final Schema targetSchema;
            final TupleContainer input;
            int leafCount = 0;

            public LeafTableBuilder(TupleContainer bufferToBuild) {
                this(bufferToBuild, bufferToBuild.getSchema());
            }

            public LeafTableBuilder(TupleContainer bufferToBuild, Schema targetSchema) {
                this.targetSchema = targetSchema;
                this.input = bufferToBuild;
            }

            public void build() {
                if (input.size() == 0)
                    return;

                if (_logger.isDebugEnabled()) {
                    _logger.debug(String.format("*** build (target schema=%s)", targetSchema));
                    _logger.debug("relation size: " + input.size());
                    _logger.debug(input);
                }

                Schema newSchema = alternativeXMLStructure();

                // sorting is necessary to perform group by operation
                List<String> sortOrder = new ArrayList<String>();
                for (String eachNode : newSchema.getNodeNameList()) {
                    if (!target.hasManyNode(eachNode))
                        sortOrder.add(eachNode);
                }
                input.sort(sortOrder);

                if (_logger.isDebugEnabled())
                    _logger.debug("new structure: " + newSchema);

                buildNode(newSchema, TupleIndex.ZERO, new Range(0, input.size()));
            }

            HashMap<TupleIndex, Integer> getCardinalityOfColumns() {

                HashMap<TupleIndex, Integer> result = new HashMap<TupleIndex, Integer>();
                // count distinct values
                for (String nodeName : targetSchema.getNodeNameList()) {
                    if (schemaSet.getTreeNodeSet().contains(nodeName))
                        continue;

                    TupleIndex index = targetSchema.getNodeIndex(nodeName);
                    SpectramBloomFilter<String> bloomFilter = new SpectramBloomFilter<String>(16);
                    for (Tuple<Node> eachRow : input) {
                        TupleElement<Node> cell = eachRow.get(index);
                        if (!cell.isAtom())
                            continue;

                        String value = cell.castToNode().nodeValue;
                        if (value != null)
                            bloomFilter.insert(value);
                    }

                    result.put(index, bloomFilter.count());
                }

                return result;
            }

            public Schema alternativeXMLStructure() {
                return SchemaMapping.createAlternativeXMLStructure(targetSchema, target, input,
                        schemaSet);
            }

            boolean isCoreNode(String nodeName) {
                return input.getSchema().getNodeIndex(nodeName).get(0) == 0;
            }

            void buildNode(Schema newSchema, TupleIndex cursor, Range range) {
                Schema target = newSchema.get(cursor);
                if (target == null)
                    return; // no more output

                if (_logger.isDebugEnabled())
                    _logger.debug(String.format("---- build node: target: %s, latticeCursor: %s",
                            target, cursor));

                if (target.isAtom()) {
                    String nodeName = target.getName();

                    TupleIndex nodeIndexInInput = input.getSchema().getNodeIndex(nodeName);

                    if (!isSubtreeRoot(cursor) || !hasChild(newSchema, cursor)) {
                        buildLeaf(newSchema, nodeIndexInInput, range);
                        return;
                    }

                    boolean doNotMerge = isCoreNode(nodeName) && input.getSchema().isOneToOne();

                    // build for each group
                    TupleElement<Node> base = input.get(range.start).get(nodeIndexInInput);
                    int beginRow = range.start;
                    for (int relationCursor = range.start; relationCursor < range.end; relationCursor++) {
                        TupleElement<Node> current = input.get(relationCursor)
                                .get(nodeIndexInInput);
                        if (current == null)
                            continue;
                        if (doNotMerge || current.isTuple() || !isEqualIncludingNull(base, current)) {
                            // core node must be output individually.
                            // except the core node, can create a group
                            buildGroup(base.castToNode(), newSchema, cursor, new Range(beginRow,
                                    relationCursor));
                            base = current;
                            beginRow = relationCursor;
                        }
                    }
                    // output remaining nodes
                    if (beginRow < range.end) {
                        if (base != null)
                            buildGroup(base.castToNode(), newSchema, cursor, new Range(beginRow,
                                    range.end));
                    }
                }
                else {
                    // tuple
                    buildNode(newSchema, new TupleIndex(cursor, 0), range);
                }

            }

            void buildLeaf(Schema targetSchema, TupleIndex nodeIndexInSrc, Range range) {
                String nodeName = input.getSchema().get(nodeIndexInSrc).getName();

                if (_logger.isDebugEnabled())
                    _logger.debug(String.format("---- buildLeaf: node=%s, range=%s", nodeName,
                            range));

                AutomatonCursor<XMLSkeltonNode, String> skeltonCursor = skelton.cursor(target);
                if (skeltonCursor.canAccept(nodeName)) {
                    XMLSkeltonNode nextSkelton = skeltonCursor.transit(nodeName);
                    TupleIndex parentNodeIndex = input.getSchema().getNodeIndex(nodeName);
                    TupleContainer container = new TupleContainer(new SchemaBuilder().add(nodeName)
                            .build());
                    for (int relationCursor = range.start; relationCursor < range.end; relationCursor++) {
                        Tuple<Node> t = input.get(relationCursor);
                        TupleElement<Node> cell = t.get(parentNodeIndex);
                        if (cell == null)
                            continue;

                        if (cell.isAtom()) {
                            Tuple<Node> parent = new Tuple<Node>(1);
                            parent.add(cell);
                            container.add(parent);
                        }
                        else {
                            Tuple<Node> nestedElement = cell.castToTuple();
                            for (TupleElement<Node> each : nestedElement) {
                                Tuple<Node> parent = new Tuple<Node>(1);
                                parent.add(each);
                                container.add(parent);
                            }
                        }
                    }
                    if (_logger.isDebugEnabled()) {
                        _logger.debug(String.format("parent:\n %s", container));
                        _logger.debug(String.format("need join: %s with %s", nodeName, nextSkelton));
                    }
                    XMLBuilder builder = new XMLBuilder(container, nextSkelton);
                    builder.build();
                }
                else {
                    for (int relationCursor = range.start; relationCursor < range.end; relationCursor++) {
                        TupleElement<Node> current = input.get(relationCursor).get(nodeIndexInSrc);
                        selfCloseTag(current);
                        leafCount++;
                    }
                }
            }

            void buildGroup(Node node, Schema newSchema, TupleIndex cursor, Range nextRange) {
                if (nextRange.start == nextRange.end)
                    return;

                if (_logger.isDebugEnabled())
                    _logger.debug(String.format("---- buildGroup: node=%s, range=%s", node,
                            nextRange));

                startTag(node);
                TupleIndex nextCursor = cursor.sibling();
                while (newSchema.get(nextCursor) != null) {
                    buildNode(newSchema, nextCursor, nextRange);
                    nextCursor = nextCursor.sibling();
                }

                endTag();
            }

            boolean isSubtreeRoot(TupleIndex cursor) {
                return cursor.get(cursor.size() - 1) == 0;
            }

            boolean hasChild(Schema schema, TupleIndex cursor) {
                return schema.get(cursor.sibling()) != null;
            }

        }

    }

    public static String escapeText(String s) {
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("\"", "&quot;");
        s = s.replaceAll("'", "&#39;");
        return s;
    }

    void selfCloseTag(TupleElement<Node> cell) {
        if (cell == null)
            return;
        if (cell.isAtom()) {
            Node node = cell.castToNode();
            if (node.nodeValue != null) {
                if (!schemaSet.getTreeNodeSet().contains(node.nodeName))
                    xml.selfCloseTag(node.nodeName, new XMLAttribute(node.nodeName + ":value",
                            escapeText(node.nodeValue)));
                else
                    xml.text(escapeText(node.nodeValue));
            }
            else
                xml.selfCloseTag(node.nodeName);
        }
        else {
            Tuple<Node> t = cell.castToTuple();
            for (TupleElement<Node> each : t) {
                selfCloseTag(each);
            }

        }
    }

    void startTag(Node node) {
        if (node.nodeValue != null) {
            if (!schemaSet.getTreeNodeSet().contains(node.nodeName))
                xml.startTag(node.nodeName, new XMLAttribute(node.nodeName + ":value",
                        escapeText(node.nodeValue)));
            else {
                xml.text(escapeText(node.nodeValue));
            }
        }
        else
            xml.startTag(node.nodeName);
    }

    void endTag() {
        xml.endTag();
    }

    static boolean isEqualIncludingNull(TupleElement<Node> prevCell, TupleElement<Node> nextCell) {
        Node prev = prevCell.castToNode();
        Node next = nextCell.castToNode();

        if (prev.nodeValue == null) {
            return next.nodeValue == null;
        }
        else {
            if (next.nodeValue == null)
                return false;
            else
                return prev.nodeValue.equals(next.nodeValue);
        }

    }

    boolean isOneToMany(Schema relation) {
        return relation.isOneToMany();
    }

    public void setOutput(Writer writer) {
        xml.setOutputWriter(writer);
    }
}
