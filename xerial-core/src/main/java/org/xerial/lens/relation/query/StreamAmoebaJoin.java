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
// StreamAmoebaJoin.java
// Since: 2008/11/20 22:07:28
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.ObjectLens;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.lens.relation.Node.NodeBuilder;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.HashedDeque;
import org.xerial.util.graph.Edge;
import org.xerial.util.graph.Lattice;
import org.xerial.util.graph.LatticeCursor;
import org.xerial.util.graph.LatticeNode;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeParser;

/**
 * 
 * DFA-based amoeba join processing algorithm, which consumes XML streams
 * 
 * 
 * @author leo
 * 
 */
public class StreamAmoebaJoin {
    public static final String ALTERNATIVE_ATTRIBUTE_SYMBOL = "-";

    private static Logger _logger = Logger.getLogger(StreamAmoebaJoin.class);
    private static Logger _logger2 = Logger.getLogger(StreamAmoebaJoin.class, "lattice");

    final QuerySet query;
    final AmoebaJoinHandler handler;

    private final static String EMPTY_NODE_NAME = "";

    // for running amoeba join
    private long nodeCount = -1;
    private Lattice<String> nodeNameLattice = new Lattice<String>();
    private LatticeCursor<String> latticeCursor;

    private Deque<String> currentPath = new ArrayDeque<String>();
    private Deque<LatticeNode<String>> stateStack = new ArrayDeque<LatticeNode<String>>();

    //  HashedChainMap<String, XMLNode> nodeStackOfEachTag = new HashedChainMap<String, XMLNode>();
    private HashedDeque<String, Node> nodeStackOfEachTag = new HashedDeque<String, Node>();

    private HashMap<Edge, List<Operation>> operationSetOnForward = new HashMap<Edge, List<Operation>>();
    private HashMap<Edge, List<Operation>> operationSetOnBack = new HashMap<Edge, List<Operation>>();
    private HashMap<Edge, List<TextOperation>> operatSetOnText = new HashMap<Edge, List<TextOperation>>();

    private int attributeAmoebaSize = 1;

    public StreamAmoebaJoin(QuerySet query, AmoebaJoinHandler handler) throws IOException {
        this.query = query;
        this.handler = handler;

        if (query == null)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "query set is null");
    }

    static interface TextOperation {
        void execute(String testNodeName, String textData) throws Exception;
    }

    class SimpleTextOperation implements TextOperation {
        final Schema schema;
        final String coreNodeName;

        public SimpleTextOperation(Schema schema, String contextNodeName) {
            this.schema = schema;
            this.coreNodeName = contextNodeName;
        }

        public SimpleTextOperation(PushRelation pr) {
            this.schema = pr.schema;
            this.coreNodeName = pr.coreNodeName;
        }

        public void execute(String textNodeName, String textData) throws Exception {
            Deque<Node> nodeStack = getNodeStack(coreNodeName);
            Node contextNode = nodeStack.getLast();

            Deque<Node> textNodeStack = getNodeStack(textNodeName);
            Node textNode = textNodeStack.getLast();

            handler.text(schema, contextNode, textNode, textData);
        }
    }

    class ContextBasedTextOperation implements TextOperation {
        final HashMap<String, TextOperation> coreNode_action = new HashMap<String, TextOperation>();

        public ContextBasedTextOperation(ScopedPushRelation scopedPushOperation) {
            for (Entry<String, PushRelation> each : scopedPushOperation.coreNode_action.entrySet()) {
                coreNode_action.put(each.getKey(), new SimpleTextOperation(each.getValue()));
            }
        }

        public void execute(String nodeName, String textData) throws Exception {
            int hop = 0;
            for (Iterator<String> it = currentPath.descendingIterator(); it.hasNext()
                    && hop <= attributeAmoebaSize; hop++) {
                String contextNode = it.next();
                if (coreNode_action.containsKey(contextNode)) {
                    coreNode_action.get(contextNode).execute(nodeName, textData);
                    return;
                }
            }
        }

    }

    /**
     * Defines an operation assigned to an currentEdge of the node name lattice
     * 
     * @author leo
     * 
     */
    static interface Operation {
        void execute() throws Exception;
    }

    class PushRelation implements Operation {
        final Schema schema;
        final String coreNodeName;
        final String attributeNodeName;
        final String newlyFoundNodeName;

        public PushRelation(Schema schema, String previouslyFoundTag, String newlyFoundTag) {
            this.schema = schema;
            this.newlyFoundNodeName = newlyFoundTag;

            if (isCoreNodeIndex(schema.getNodeIndex(previouslyFoundTag))) {
                this.coreNodeName = previouslyFoundTag;
                this.attributeNodeName = newlyFoundTag;
            }
            else if (isCoreNodeIndex(schema.getNodeIndex(newlyFoundTag))) {
                this.coreNodeName = newlyFoundTag;
                this.attributeNodeName = previouslyFoundTag;
            }
            else
                throw new XerialError(XerialErrorCode.INVALID_STATE, "no core node in " + schema);
        }

        public void execute() throws Exception {
            Node coreNode = getNodeStack(coreNodeName).getLast();
            Node attributeNode = getNodeStack(attributeNodeName).getLast();

            if (_logger.isTraceEnabled())
                _logger.trace(String.format("push:(%s, %s)", coreNode, attributeNode));

            handler.newAmoeba(schema, coreNode, attributeNode);
        }

        @Override
        public String toString() {
            return String.format("push: %s for (%s, %s)", schema, coreNodeName, attributeNodeName);
        }
    }

    class ScopedPushRelation implements Operation {
        final HashMap<String, PushRelation> coreNode_action = new HashMap<String, PushRelation>();

        public ScopedPushRelation(List<PushRelation> candidates) {
            for (PushRelation each : candidates) {
                Schema s = each.schema;
                coreNode_action.put(each.coreNodeName, each);
            }
        }

        public void execute() throws Exception {
            int hop = 0;
            for (Iterator<String> it = currentPath.descendingIterator(); it.hasNext()
                    && hop <= attributeAmoebaSize; hop++) {
                String contextNode = it.next();
                if (coreNode_action.containsKey(contextNode)) {
                    coreNode_action.get(contextNode).execute();
                    return;
                }
            }

            //            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("no action is invoked: path=%s %s",
            //                    currentPath, coreNode_action));
        }

    }

    class ScopedPopRelation implements Operation {
        final HashMap<String, PopRelation> coreNode_action = new HashMap<String, PopRelation>();

        public ScopedPopRelation(List<PushRelation> candidates) {
            for (PushRelation each : candidates) {
                Schema s = each.schema;

                coreNode_action.put(each.coreNodeName, new PopRelation(s, each.newlyFoundNodeName));
            }
        }

        public void execute() throws Exception {
            int hop = 0;
            for (Iterator<String> it = currentPath.descendingIterator(); it.hasNext()
                    && hop <= attributeAmoebaSize; hop++) {
                String contextNode = it.next();
                if (coreNode_action.containsKey(contextNode)) {
                    coreNode_action.get(contextNode).execute();
                    return;
                }
            }

            //            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("no action is invoked: path=%s %s",
            //                    currentPath, coreNode_action));
        }

    }

    class PopRelation implements Operation {
        final Schema schema;
        final String poppedTag;

        public PopRelation(Schema schema, String poppedTag) {
            this.schema = schema;
            this.poppedTag = poppedTag;
        }

        public void execute() throws Exception {
            Node poppedNode = getNodeStack(poppedTag).getLast();
            handler.leaveNode(schema, poppedNode);
            //container.pop(poppedNode);
        }

    }

    class PushLoopedRelation implements Operation {
        final Schema schema;
        final String tagName;

        public PushLoopedRelation(Schema schema, String tagName) {
            this.schema = schema;
            this.tagName = tagName;
        }

        public void execute() throws Exception {
            Deque<Node> nodeStack = getNodeStack(tagName);
            if (nodeStack.size() < 2)
                throw new XerialError(XerialErrorCode.INVALID_STATE);

            Iterator<Node> reverseCursor = nodeStack.descendingIterator();
            Node newlyFoundNode = reverseCursor.next();
            Node previouslyFoundNode = reverseCursor.next();

            if (_logger.isTraceEnabled())
                _logger.trace(String.format("loop back: %s and %s", previouslyFoundNode,
                        newlyFoundNode));

            handler.newAmoeba(schema, previouslyFoundNode, newlyFoundNode);
        }

    }

    public Deque<Node> getNodeStack(String nodeName) {
        return nodeStackOfEachTag.get(nodeName);
    }

    public static String sanitize(String nodeName) {
        return ObjectLens.getCanonicalParameterName(nodeName);
    }

    /**
     * Body of depth-first tree traverser
     * 
     * @author leo
     * 
     */
    private class AmoebaFinder implements TreeEventHandler {

        public void finish() throws Exception {
            leaveNode("root");
            if (_logger.isTraceEnabled())
                _logger.trace("sweep finished");
            handler.finish();
        }

        public void init() throws Exception {
            nodeCount = -1;
            latticeCursor = nodeNameLattice.cursor();
            stateStack.addLast(latticeCursor.getNode());

            handler.init();

            visitNode("root", null);
        }

        public void visitNode(String nodeName, String nodeValue) throws Exception {

            Node currentNode = new NodeBuilder(nodeName).nodeID(++nodeCount).nodeValue(nodeValue)
                    .build();

            String cNodeName = currentNode.getCanonicalNodeName();
            Deque<Node> nodeStack = getNodeStack(cNodeName);
            nodeStack.add(currentNode);

            // forward
            //LatticeNode<String> prevState = latticeCursor.getNode();
            LatticeNode<String> nextState = latticeCursor.next(cNodeName);
            stateStack.addLast(nextState);
            currentPath.addLast(cNodeName != null ? cNodeName : EMPTY_NODE_NAME);

            // for tree nodes

            if (query.isTreeNode(cNodeName)) {
                throw new XerialError(XerialErrorCode.UNSUPPORTED,
                        "tree not is not currently supported");
            }

        }

        public void text(String nodeName, String textDataFragment) throws Exception {

            Iterator<LatticeNode<String>> it = stateStack.descendingIterator();
            LatticeNode<String> currentState = it.next();
            LatticeNode<String> prevState = it.next();

            Edge currentEdge = new Edge(prevState.getID(), currentState.getID());
            List<TextOperation> textOperation = operatSetOnText.get(currentEdge);

            String cName = sanitize(nodeName);

            // generate a text operation set
            if (textOperation == null) {
                textOperation = new ArrayList<TextOperation>();
                operatSetOnText.put(currentEdge, textOperation);

                List<Operation> forwardAction = getForwardActionList(prevState, currentState, cName);
                for (Operation each : forwardAction) {
                    if (each instanceof PushRelation) {
                        textOperation.add(new SimpleTextOperation((PushRelation) each));
                    }
                    else if (each instanceof ScopedPushRelation) {
                        textOperation.add(new ContextBasedTextOperation((ScopedPushRelation) each));
                    }
                    else
                        throw new XerialError(XerialErrorCode.INVALID_STATE, "unknown operation: "
                                + each);
                }
            }

            assert textOperation != null;

            try {
                for (TextOperation each : textOperation)
                    each.execute(cName, textDataFragment);
            }
            catch (Exception e) {
                throw XerialException.convert(e);
            }
        }

        public void leaveNode(String nodeName) throws Exception {
            String sanitizedNodeName = sanitize(nodeName);

            Deque<Node> nodeStack = getNodeStack(sanitizedNodeName);
            Node currentNode = nodeStack.getLast();

            try {
                back(currentNode);
            }
            catch (Exception e) {
                if (e instanceof XerialError)
                    throw (XerialError) e;
                else
                    throw XerialException.convert(e);
            }

            currentPath.removeLast();

            nodeStack.removeLast();
        }

        private List<Operation> getForwardActionList(LatticeNode<String> prevState,
                LatticeNode<String> nextState, String nodeName) {
            Edge currentEdge = new Edge(prevState.getID(), nextState.getID());

            List<Operation> actionList = operationSetOnForward.get(currentEdge);
            if (actionList != null)
                return actionList;

            int prevNodeID = currentEdge.getSourceNodeID();
            int nextNodeID = currentEdge.getDestNodeID();

            // lazily prepare the action list
            actionList = new ArrayList<Operation>();
            operationSetOnForward.put(currentEdge, actionList);
            List<Operation> backActionList = new ArrayList<Operation>();
            operationSetOnBack.put(new Edge(nextNodeID, prevNodeID), backActionList);

            // search for the corresponding relations to newly found two node pair 
            String newlyFoundTag = nodeName;

            if (_logger2.isTraceEnabled())
                _logger2.trace("create actions for " + newlyFoundTag);

            if (prevNodeID != nextNodeID) {
                List<PushRelation> foundAction = new ArrayList<PushRelation>();
                // (core node, attribute node)
                for (Schema r : query.getTargetQuerySet()) {
                    TupleIndex ni = r.getNodeIndex(newlyFoundTag);
                    if (ni == null)
                        continue;

                    for (String previouslyFoundNode : nextState) {
                        TupleIndex pi = r.getNodeIndex(previouslyFoundNode);
                        if (pi == null)
                            continue;

                        if (previouslyFoundNode.equals(newlyFoundTag))
                            continue;

                        if (!(isCoreNodeIndex(ni) || isCoreNodeIndex(pi)))
                            continue;

                        if (_logger2.isTraceEnabled())
                            _logger2.trace(String.format("new pair: %s, %s (in %s)",
                                    previouslyFoundNode, newlyFoundTag, r));

                        foundAction.add(new PushRelation(r, previouslyFoundNode, newlyFoundTag));
                        break;
                    }
                }

                // set the action list
                if (foundAction.size() > 1) {
                    // context-dependent actions
                    actionList.add(new ScopedPushRelation(foundAction));
                    backActionList.add(new ScopedPopRelation(foundAction));
                }
                else {
                    // a single action
                    for (PushRelation each : foundAction) {
                        actionList.add(each);
                        backActionList.add(new PopRelation(each.schema, each.newlyFoundNodeName));
                    }
                }

            }
            else {
                // loop back e.g. A -> A
                for (Schema r : query.getTargetQuerySet()) {
                    String selfLoopNode = r.selfLoopNode();
                    if (selfLoopNode == null)
                        continue;
                    else {
                        actionList.add(new PushLoopedRelation(r, selfLoopNode));
                        break;
                    }
                }
            }

            return actionList;

        }

        void back(Node node) throws Exception {
            Iterator<LatticeNode<String>> it = stateStack.descendingIterator();
            LatticeNode<String> current = it.next();
            LatticeNode<String> prev = it.next();
            stateStack.removeLast();

            // process forward edge
            for (Operation each : getForwardActionList(prev, current, node.getCanonicalNodeName())) {
                each.execute();
            }

            // process back edge
            int prevState = latticeCursor.getNodeID();
            int nextState = latticeCursor.reset(stateStack.peekLast()).getID();

            Edge backEdge = new Edge(prevState, nextState);
            List<Operation> actionList = operationSetOnBack.get(backEdge);
            if (actionList == null) {
                throw new XerialError(XerialErrorCode.INVALID_STATE, "empty action list: " + node);
            }
            if (actionList.isEmpty()) {
                Node poppedNode = getNodeStack(node.getCanonicalNodeName()).getLast();
                handler.leaveNode(null, poppedNode);
            }
            else
                for (Operation each : actionList) {
                    each.execute();
                }

        }

    }

    private boolean isCoreNodeIndex(TupleIndex ti) {
        return ti.size() == 1 && ti.get(0) == 0;
    }

    public void sweep(TreeParser parser) throws Exception {
        AmoebaFinder f = new AmoebaFinder();
        parser.parse(f);
    }

    public QuerySet getQuerySet() {
        return query;
    }

}