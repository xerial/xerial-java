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
// RelationHolder.java
// Since: Nov 7, 2008 2:28:57 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.TupleElementVisitor;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.log.Logger;

/**
 * Relation fragment holder used in {@link StreamAmoebaJoin}
 * 
 * 
 * @author leo
 * 
 */
public class RelationFragmentHolder {
    private static Logger _logger = Logger.getLogger(RelationFragmentHolder.class);

    private final Schema relation;
    private final Schema schemaWithoutCoreNode;
    //    private IndexedSet<String> nodeNameIndex = new IndexedSet<String>();

    private LinkedList<RelationFragment> fragmentStack = new LinkedList<RelationFragment>();
    private Deque<Node> coreNodeStack = new ArrayDeque<Node>();
    private HashMap<Node, Integer> fragmentListStartPosition = new HashMap<Node, Integer>();

    private final int relationSize;

    private final RelationHandler handler;

    private class RelationFragment {
        //private BitVector          activeStackFlag;
        private Tuple<Node> relationFragment;

        public RelationFragment() {
            //activeStackFlag = new BitVector(relationSize - 1);
            relationFragment = emptyTuple(schemaWithoutCoreNode);
        }

        public Tuple<Node> emptyTuple(Schema schema) {
            List<TupleElement<Node>> nodeList = new ArrayList<TupleElement<Node>>(schema.size());
            for (int i = 0; i < schema.size(); i++) {
                Schema subSchema = schema.get(i);
                if (subSchema.isAtom())
                    nodeList.add(null);
                else
                    nodeList.add(emptyTuple(subSchema));
            }
            return new Tuple<Node>(nodeList);
        }

        class CompletenessTester implements TupleElementVisitor<Node> {
            boolean hasNull = false;

            public boolean isComplete() {
                relationFragment.accept(this);
                return !hasNull;
            }

            public void visitNode(Node node) {
                if (node == null)
                    hasNull = true;
            }

            public void visitTuple(Tuple<Node> tuple) {
                if (tuple == null) {
                    hasNull = true;
                    return;
                }

                for (TupleElement<Node> each : tuple) {
                    if (hasNull)
                        break;

                    if (each == null) {
                        hasNull = true;
                        break;
                    }

                    each.accept(this);
                }

            }

        }

        public boolean isComplete() {
            return new CompletenessTester().isComplete();
        }

        public void set(Node node) {
            TupleIndex flagIndex = getIndexOf(node);
            relationFragment.set(flagIndex, node);
        }

        private TupleIndex getIndexOf(Node node) {
            return schemaWithoutCoreNode.getNodeIndex(node.nodeName);
        }

        public String toString() {
            return relationFragment.toString();
        }

    }

    public RelationFragmentHolder(Schema targetRelation, RelationHandler handler) {
        this.relation = targetRelation;

        SchemaBuilder builder = new SchemaBuilder();
        for (int i = 1; i < relation.size(); ++i)
            builder.add(relation.get(i));
        this.schemaWithoutCoreNode = builder.build();

        this.handler = handler;

        relationSize = targetRelation.size();

    }

    public Schema getRelation() {

        return relation;
    }

    public boolean isCoreNode(TupleIndex nodeID) {
        return nodeID.size() == 1 && nodeID.get(0) == 0;
    }

    /**
     * @param node
     * @return is changed?
     */
    public boolean push(Node node) {
        if (_logger.isTraceEnabled())
            _logger.trace("push: " + node);
        TupleIndex nodeNameID = relation.getNodeIndex(node.nodeName);
        if (isCoreNode(nodeNameID)) {
            // core node
            if (coreNodeStack.isEmpty()) {
                coreNodeStack.addLast(node);
                fragmentListStartPosition.put(node, 0);
                return true;
            }
            else if (coreNodeStack.getLast().nodeID != node.nodeID) {
                coreNodeStack.addLast(node);
                fragmentListStartPosition.put(node, fragmentStack.size());
                return true;
            }
        }
        else {
            // fragment node
            RelationFragment target = getTargetRelationFragmentFromStack();
            target.set(node);
            return true;
        }
        return false;
    }

    public void pop(Node node) {
        if (_logger.isTraceEnabled())
            _logger.trace("pop:  " + node);
        TupleIndex nodeNameID = relation.getNodeIndex(node.nodeName);
        RelationFragment target = getTargetRelationFragmentFromStack();
        if (isCoreNode(nodeNameID)) {
            // for setting text values
            coreNodeStack.removeLast();
            coreNodeStack.addLast(node);

            int stackStart = fragmentListStartPosition.get(node);

            for (Iterator<RelationFragment> it = fragmentStack.listIterator(stackStart); it
                    .hasNext();) {
                RelationFragment fragment = it.next();
                if (fragment.isComplete()) {
                    output(node, target);
                }
            }
            while (fragmentStack.size() > stackStart) {
                fragmentStack.removeLast();
            }
            coreNodeStack.removeLast();
        }
        else {
            // for setting text values
            target.set(node);
            if (target.isComplete()) {
                if (!coreNodeStack.isEmpty()) {
                    output(coreNodeStack.getLast(), target);
                    fragmentStack.removeLast();
                }
            }
        }
    }

    public void output(Node coreNode, RelationFragment fragment) {
        //_logger.info(String.format("[%s, %s]", coreNode, fragment));

        Tuple<Node> rel = new Tuple<Node>(relationSize);
        rel.add(coreNode);
        for (TupleElement<Node> each : fragment.relationFragment)
            rel.add(each);

        handler.relation(relation, rel);
    }

    public RelationFragment getTargetRelationFragmentFromStack() {
        if (coreNodeStack.isEmpty()) {
            RelationFragment fragment;
            if (fragmentStack.isEmpty()) {
                fragment = new RelationFragment();
                fragmentStack.add(fragment);
            }
            else
                fragment = fragmentStack.getLast();
            return fragment;
        }
        else {
            Node latestCoreNode = coreNodeStack.getLast();
            int stackPos = fragmentListStartPosition.get(latestCoreNode);
            if (stackPos >= fragmentStack.size()) // if no relation fragment is stacked
            {
                // add a new relation fragment 
                RelationFragment fragment = new RelationFragment();
                fragmentStack.add(fragment);
                return fragment;
            }
            else {
                return fragmentStack.getLast();
            }
        }
    }

}
