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
package org.xerial.relation.query;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.ObjectLens;
import org.xerial.relation.Node;
import org.xerial.relation.TupleIndex;
import org.xerial.relation.Node.NodeBuilder;
import org.xerial.relation.schema.Schema;
import org.xerial.relation.schema.SchemaArray;
import org.xerial.relation.schema.SchemaAtom;
import org.xerial.relation.schema.SchemaVisitor;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.HashedDeque;
import org.xerial.util.graph.Edge;
import org.xerial.util.graph.Lattice;
import org.xerial.util.graph.LatticeCursor;
import org.xerial.util.graph.LatticeNode;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.xml.XMLAttribute;
import org.xerial.util.xml.XMLGenerator;
import org.xerial.util.xml.XMLTreeWalker;

/**
 * 
 * DFA-based amoeba join processing algorithm, which consumes XML streams
 * 
 * 
 * @author leo
 * 
 */
public class StreamAmoebaJoin implements TreeVisitor
{
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

    public StreamAmoebaJoin(QuerySet query, AmoebaJoinHandler handler) throws IOException
    {
        this.query = query;
        this.handler = handler;

        if (query == null)
            throw new XerialError(XerialErrorCode.INVALID_INPUT, "query set is null");
    }

    static interface TextOperation
    {
        void execute(String testNodeName, String textData) throws Exception;
    }

    class SimpleTextOperation implements TextOperation
    {
        final Schema schema;
        final String coreNodeName;

        public SimpleTextOperation(Schema schema, String contextNodeName)
        {
            this.schema = schema;
            this.coreNodeName = contextNodeName;
        }

        public SimpleTextOperation(PushRelation pr)
        {
            this.schema = pr.schema;
            this.coreNodeName = pr.coreNodeName;
        }

        public void execute(String textNodeName, String textData) throws Exception
        {
            Deque<Node> nodeStack = getNodeStack(coreNodeName);
            Node contextNode = nodeStack.getLast();

            Deque<Node> textNodeStack = getNodeStack(textNodeName);
            Node textNode = textNodeStack.getLast();

            handler.text(schema, contextNode, textNode, textData);
        }
    }

    class ContextBasedTextOperation implements TextOperation
    {
        final HashMap<String, TextOperation> coreNode_action = new HashMap<String, TextOperation>();

        public ContextBasedTextOperation(ScopedPushRelation scopedPushOperation)
        {
            for (Entry<String, PushRelation> each : scopedPushOperation.coreNode_action.entrySet())
            {
                coreNode_action.put(each.getKey(), new SimpleTextOperation(each.getValue()));
            }
        }

        public void execute(String nodeName, String textData) throws Exception
        {
            int hop = 0;
            for (Iterator<String> it = currentPath.descendingIterator(); it.hasNext() && hop <= attributeAmoebaSize; hop++)
            {
                String contextNode = it.next();
                if (coreNode_action.containsKey(contextNode))
                {
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
    static interface Operation
    {
        void execute() throws Exception;
    }

    class PushRelation implements Operation
    {
        final Schema schema;
        final String coreNodeName;
        final String attributeNodeName;
        final String newlyFoundNodeName;

        public PushRelation(Schema schema, String previouslyFoundTag, String newlyFoundTag)
        {
            this.schema = schema;
            this.newlyFoundNodeName = newlyFoundTag;

            if (isCoreNodeIndex(schema.getNodeIndex(previouslyFoundTag)))
            {
                this.coreNodeName = previouslyFoundTag;
                this.attributeNodeName = newlyFoundTag;
            }
            else if (isCoreNodeIndex(schema.getNodeIndex(newlyFoundTag)))
            {
                this.coreNodeName = newlyFoundTag;
                this.attributeNodeName = previouslyFoundTag;
            }
            else
                throw new XerialError(XerialErrorCode.INVALID_STATE, "no core node in " + schema);
        }

        public void execute() throws Exception
        {
            Node coreNode = getNodeStack(coreNodeName).getLast();
            Node attributeNode = getNodeStack(attributeNodeName).getLast();

            if (_logger.isTraceEnabled())
                _logger.trace(String.format("push:(%s, %s)", coreNode, attributeNode));

            handler.newAmoeba(schema, coreNode, attributeNode);
        }

        @Override
        public String toString()
        {
            return String.format("push: %s for (%s, %s)", schema, coreNodeName, attributeNodeName);
        }
    }

    class ScopedPushRelation implements Operation
    {
        final HashMap<String, PushRelation> coreNode_action = new HashMap<String, PushRelation>();

        public ScopedPushRelation(List<PushRelation> candidates)
        {
            for (PushRelation each : candidates)
            {
                Schema s = each.schema;
                coreNode_action.put(each.coreNodeName, each);
            }
        }

        public void execute() throws Exception
        {
            int hop = 0;
            for (Iterator<String> it = currentPath.descendingIterator(); it.hasNext() && hop <= attributeAmoebaSize; hop++)
            {
                String contextNode = it.next();
                if (coreNode_action.containsKey(contextNode))
                {
                    coreNode_action.get(contextNode).execute();
                    return;
                }
            }

            //            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("no action is invoked: path=%s %s",
            //                    currentPath, coreNode_action));
        }

    }

    class ScopedPopRelation implements Operation
    {
        final HashMap<String, PopRelation> coreNode_action = new HashMap<String, PopRelation>();

        public ScopedPopRelation(List<PushRelation> candidates)
        {
            for (PushRelation each : candidates)
            {
                Schema s = each.schema;

                coreNode_action.put(each.coreNodeName, new PopRelation(s, each.newlyFoundNodeName));
            }
        }

        public void execute() throws Exception
        {
            int hop = 0;
            for (Iterator<String> it = currentPath.descendingIterator(); it.hasNext() && hop <= attributeAmoebaSize; hop++)
            {
                String contextNode = it.next();
                if (coreNode_action.containsKey(contextNode))
                {
                    coreNode_action.get(contextNode).execute();
                    return;
                }
            }

            //            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("no action is invoked: path=%s %s",
            //                    currentPath, coreNode_action));
        }

    }

    class PopRelation implements Operation
    {
        final Schema schema;
        final String poppedTag;

        public PopRelation(Schema schema, String poppedTag)
        {
            this.schema = schema;
            this.poppedTag = poppedTag;
        }

        public void execute() throws Exception
        {
            Node poppedNode = getNodeStack(poppedTag).getLast();
            handler.leaveNode(schema, poppedNode);
            //container.pop(poppedNode);
        }

    }

    class PushLoopedRelation implements Operation
    {
        final Schema schema;
        final String tagName;

        public PushLoopedRelation(Schema schema, String tagName)
        {
            this.schema = schema;
            this.tagName = tagName;
        }

        public void execute() throws Exception
        {
            Deque<Node> nodeStack = getNodeStack(tagName);
            if (nodeStack.size() < 2)
                throw new XerialError(XerialErrorCode.INVALID_STATE);

            Iterator<Node> reverseCursor = nodeStack.descendingIterator();
            Node newlyFoundNode = reverseCursor.next();
            Node previouslyFoundNode = reverseCursor.next();

            _logger.debug(String.format("loop back: %s and %s", previouslyFoundNode, newlyFoundNode));
            handler.newAmoeba(schema, previouslyFoundNode, newlyFoundNode);
        }

    }

    class ReportText
    {

    }

    public void finish(TreeWalker walker) throws XerialException
    {
        leaveNode("root", walker);
        if (_logger.isTraceEnabled())
            _logger.trace("sweep finished");
        handler.finish();
    }

    public void init(TreeWalker walker) throws XerialException
    {
        nodeCount = -1;
        latticeCursor = nodeNameLattice.cursor();
        stateStack.addLast(latticeCursor.getNode());

        handler.init();

        visitNode("root", null, walker);
    }

    public Deque<Node> getNodeStack(String nodeName)
    {
        return nodeStackOfEachTag.get(nodeName);
    }

    public static String sanitize(String nodeName)
    {
        return ObjectLens.getCanonicalParameterName(nodeName);
    }

    public void visitNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
    {
        nodeName = sanitize(nodeName);

        Node currentNode = new NodeBuilder(nodeName).nodeID(++nodeCount).nodeValue(nodeValue).build();
        Deque<Node> nodeStack = getNodeStack(nodeName);
        nodeStack.add(currentNode);

        // forward
        LatticeNode<String> prevState = latticeCursor.getNode();
        LatticeNode<String> nextState = latticeCursor.next(nodeName);
        stateStack.addLast(nextState);
        currentPath.addLast(nodeName != null ? nodeName : EMPTY_NODE_NAME);

        // for tree nodes

        if (query.isTreeNode(nodeName))
        {
            // retrieve the entire subtree
            TreeNode subTree = walker.getSubTree();
            String xml = new XMLBuilder().build(subTree).getXML();
            nodeStack.removeLast();
            nodeStack.addLast(new NodeBuilder(currentNode).nodeValue(xml).build());
            //leaveNode(nodeName, walker);
            return;
        }

    }

    public void text(String nodeName, String textDataFragment, TreeWalker walker) throws XerialException
    {
        nodeName = sanitize(nodeName);

        Iterator<LatticeNode<String>> it = stateStack.descendingIterator();
        LatticeNode<String> currentState = it.next();
        LatticeNode<String> prevState = it.next();

        Edge currentEdge = new Edge(prevState.getID(), currentState.getID());
        List<TextOperation> textOperation = operatSetOnText.get(currentEdge);

        // generate a text operation set
        if (textOperation == null)
        {
            textOperation = new ArrayList<TextOperation>();
            operatSetOnText.put(currentEdge, textOperation);

            List<Operation> forwardAction = getForwardActionList(prevState, currentState, nodeName);
            for (Operation each : forwardAction)
            {
                if (each instanceof PushRelation)
                {
                    textOperation.add(new SimpleTextOperation((PushRelation) each));
                }
                else if (each instanceof ScopedPushRelation)
                {
                    textOperation.add(new ContextBasedTextOperation((ScopedPushRelation) each));
                }
                else
                    throw new XerialError(XerialErrorCode.INVALID_STATE, "unknown operation: " + each);
            }
        }

        assert textOperation != null;

        try
        {
            for (TextOperation each : textOperation)
                each.execute(nodeName, textDataFragment);
        }
        catch (Exception e)
        {
            if (e instanceof XerialException)
                throw (XerialException) e;
            else
                throw new XerialException(XerialErrorCode.INHERITED, e);
        }
    }

    public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
    {
        nodeName = sanitize(nodeName);

        Deque<Node> nodeStack = getNodeStack(nodeName);
        Node currentNode = nodeStack.getLast();

        try
        {
            back(currentNode);
        }
        catch (Exception e)
        {
            if (e instanceof XerialException)
                throw (XerialException) e;
            else if (e instanceof XerialError)
                throw (XerialError) e;
            else
                throw new XerialException(XerialErrorCode.INHERITED, e);
        }

        currentPath.removeLast();

        nodeStack.removeLast();
    }

    private List<Operation> getForwardActionList(LatticeNode<String> prevState, LatticeNode<String> nextState,
            String nodeName)
    {
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

        if (prevNodeID != nextNodeID)
        {
            List<PushRelation> foundAction = new ArrayList<PushRelation>();
            // (core node, attribute node)
            for (Schema r : query.getTargetQuerySet())
            {
                TupleIndex ni = r.getNodeIndex(newlyFoundTag);
                if (ni == null)
                    continue;

                for (String previouslyFoundNode : nextState)
                {
                    TupleIndex pi = r.getNodeIndex(previouslyFoundNode);
                    if (pi == null)
                        continue;

                    if (previouslyFoundNode.equals(newlyFoundTag))
                        continue;

                    if (!(isCoreNodeIndex(ni) || isCoreNodeIndex(pi)))
                        continue;

                    if (_logger2.isTraceEnabled())
                        _logger2
                                .trace(String.format("new pair: %s, %s (in %s)", previouslyFoundNode, newlyFoundTag, r));

                    foundAction.add(new PushRelation(r, previouslyFoundNode, newlyFoundTag));
                    break;
                }
            }

            // set the action list
            if (foundAction.size() > 1)
            {
                // context-dependent actions
                actionList.add(new ScopedPushRelation(foundAction));
                backActionList.add(new ScopedPopRelation(foundAction));
            }
            else
            {
                // a single action
                for (PushRelation each : foundAction)
                {
                    actionList.add(each);
                    backActionList.add(new PopRelation(each.schema, each.newlyFoundNodeName));
                }
            }

        }
        else
        {
            // loop back e.g. A -> A
            for (Schema r : query.getTargetQuerySet())
            {
                String selfLoopNode = r.selfLoopNode();
                if (selfLoopNode == null)
                    continue;
                else
                {
                    actionList.add(new PushLoopedRelation(r, selfLoopNode));
                    break;
                }
            }
        }

        return actionList;

    }

    private boolean isCoreNodeIndex(TupleIndex ti)
    {
        return ti.size() == 1 && ti.get(0) == 0;
    }

    void back(Node node) throws Exception
    {
        Iterator<LatticeNode<String>> it = stateStack.descendingIterator();
        LatticeNode<String> current = it.next();
        LatticeNode<String> prev = it.next();
        stateStack.removeLast();

        // process forward edge
        for (Operation each : getForwardActionList(prev, current, node.nodeName))
        {
            each.execute();
        }

        // process back edge
        int prevState = latticeCursor.getNodeID();
        int nextState = latticeCursor.reset(stateStack.peekLast()).getID();

        Edge backEdge = new Edge(prevState, nextState);
        List<Operation> actionList = operationSetOnBack.get(backEdge);
        if (actionList == null)
        {
            throw new XerialError(XerialErrorCode.INVALID_STATE, "empty action list: " + node);
        }
        if (actionList.isEmpty())
        {
            Node poppedNode = getNodeStack(node.nodeName).getLast();
            handler.leaveNode(null, poppedNode);
        }
        else
            for (Operation each : actionList)
            {
                each.execute();
            }

    }

    static class AttributeNodeFinder implements SchemaVisitor
    {
        Deque<String> nodeName = new ArrayDeque<String>();

        public void visitArray(SchemaArray array)
        {
            for (Schema each : array)
                each.accept(this);
        }

        public void visitAtom(SchemaAtom atom)
        {
            nodeName.add(atom.getName());
        }
    }

    public void sweepXML(Reader xml) throws XerialException
    {
        if (_logger.isDebugEnabled())
            _logger.debug("sweep XML");
        XMLTreeWalker xmlStreamReader = new XMLTreeWalker(xml);
        xmlStreamReader.walk(this);
    }

    public void sweep(TreeWalker walker) throws XerialException
    {
        walker.walk(this);
    }

    public QuerySet getQuerySet()
    {
        return query;
    }

    public static class XMLBuilder
    {
        private final StringWriter buf = new StringWriter();
        private final XMLGenerator xml;

        public XMLBuilder()
        {
            xml = new XMLGenerator(buf);
        }

        public XMLBuilder build(TreeNode node)
        {
            String tagName = node.getNodeName();

            String nodeValue = node.getNodeValue();
            if (nodeValue != null)
            {
                if (node.getChildren().isEmpty())
                {
                    xml.startTag(tagName);
                    xml.text(nodeValue);
                }
                else
                    xml.startTag(tagName, new XMLAttribute("value", nodeValue));
            }
            else
                xml.startTag(tagName);

            for (TreeNode eachChild : node.getChildren())
            {
                build(eachChild);
            }

            xml.endTag();
            return this;
        }

        public String getXML()
        {
            xml.flush();
            xml.endDocument();
            return buf.toString();

        }
    }

}