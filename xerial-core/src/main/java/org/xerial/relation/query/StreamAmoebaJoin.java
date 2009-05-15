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

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
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

    final QuerySet query;
    final RelationEventHandler handler;

    // for running amoeba join
    int nodeCount = 0;
    Lattice<String> nodeNameLattice = new Lattice<String>();
    LatticeCursor<String> latticeCursor;

    //  HashedChainMap<String, XMLNode> nodeStackOfEachTag = new HashedChainMap<String, XMLNode>();
    HashedDeque<String, Node> nodeStackOfEachTag = new HashedDeque<String, Node>();

    HashMap<Edge, List<Operation>> operationSetOnForward = new HashMap<Edge, List<Operation>>();
    HashMap<Edge, List<Operation>> operationSetOnBack = new HashMap<Edge, List<Operation>>();

    public StreamAmoebaJoin(QuerySet query, RelationEventHandler handler) throws IOException
    {
        this.query = query;
        this.handler = handler;
    }

    /**
     * Defines an operation assigned to an currentEdge of the node name lattice
     * 
     * @author leo
     * 
     */
    static interface Operation
    {
        void execute();
    }

    class PushRelation implements Operation
    {
        final Schema schema;
        final String previouslyFoundTag;
        final String newlyFoundTag;

        public PushRelation(Schema schema, String previouslyFoundTag, String newlyFoundTag)
        {
            this.schema = schema;
            this.previouslyFoundTag = previouslyFoundTag;
            this.newlyFoundTag = newlyFoundTag;
        }

        public void execute()
        {
            Node knownNode = getNodeStack(previouslyFoundTag).getLast();
            Node newNode = getNodeStack(newlyFoundTag).getLast();

            if (_logger.isTraceEnabled())
                _logger.trace(String.format("push:(%s, %s)", knownNode, newNode));

            handler.newRelationFragment(schema, knownNode, newNode);

            //            boolean isChanged = container.push(knownNode);
            //            if (isChanged)
            //            {
            //                Set<RelationFragmentHolder> stackListToExecutePop = popListOfNodeID.get(knownNode.nodeID);
            //                if (stackListToExecutePop == null)
            //                {
            //                    stackListToExecutePop = new HashSet<RelationFragmentHolder>();
            //                    popListOfNodeID.put(knownNode.nodeID, stackListToExecutePop);
            //                }
            //                stackListToExecutePop.add(container);
            //            }
            //
            //            container.push(newNode);
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

        public void execute()
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

        public void execute()
        {
            Deque<Node> nodeStack = getNodeStack(tagName);
            if (nodeStack.size() < 2)
                throw new XerialError(XerialErrorCode.INVALID_STATE);

            Iterator<Node> reverseCursor = nodeStack.descendingIterator();
            Node newlyFoundNode = reverseCursor.next();
            Node previouslyFoundNode = reverseCursor.next();

            _logger.debug(String.format("loop back: %s and %s", previouslyFoundNode, newlyFoundNode));
            handler.newRelationFragment(schema, previouslyFoundNode, newlyFoundNode);
        }

    }

    public void finish(TreeWalker walker) throws XerialException
    {
        _logger.debug("sweep finished");
    }

    public void init(TreeWalker walker) throws XerialException
    {
        nodeCount = 0;
        latticeCursor = nodeNameLattice.cursor();
    }

    public Deque<Node> getNodeStack(String nodeName)
    {
        return nodeStackOfEachTag.get(nodeName);
    }

    public void visitNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
    {
        Node currentNode = new NodeBuilder(nodeName).nodeID(++nodeCount).nodeValue(nodeValue).build();
        Deque<Node> nodeStack = getNodeStack(nodeName);
        nodeStack.add(currentNode);

        forward(currentNode);

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
        handler.text(nodeName, textDataFragment);
    }

    public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
    {
        Deque<Node> nodeStack = getNodeStack(nodeName);
        Node currentNode = nodeStack.getLast();

        back(currentNode);
        nodeStack.removeLast();
    }

    void forward(Node node)
    {
        LatticeNode<String> prevNode = latticeCursor.getNode();
        LatticeNode<String> nextNode = latticeCursor.next(node.nodeName);

        int prevNodeID = prevNode.getID();
        int nextNodeID = nextNode.getID();

        Edge currentEdge = new Edge(prevNodeID, nextNodeID);
        List<Operation> actionList = operationSetOnForward.get(currentEdge);
        if (actionList == null)
        {
            // lazily prepare the action list
            actionList = new ArrayList<Operation>();
            operationSetOnForward.put(currentEdge, actionList);
            List<Operation> backActionList = new ArrayList<Operation>();
            operationSetOnBack.put(new Edge(nextNodeID, prevNodeID), backActionList);

            // search for the corresponding relations to newly found two node pair 
            String newlyFoundTag = node.nodeName;

            // TODO this part consider node pairs (core node, attribute node)
            if (prevNode != nextNode)
            {
                for (Schema r : query.getTargetQuerySet())
                {
                    if (r.getNodeIndex(newlyFoundTag) != null)
                    {
                        for (String previouslyFoundTag : nextNode)
                        {
                            TupleIndex pi = r.getNodeIndex(previouslyFoundTag);
                            if (r.getNodeIndex(previouslyFoundTag) == null)
                                continue;

                            if (previouslyFoundTag.equals(newlyFoundTag))
                                continue;

                            if (_logger.isTraceEnabled())
                                _logger.trace(String.format("new pair: %s(%s), %s (in %s)", previouslyFoundTag, pi,
                                        newlyFoundTag, r));
                            actionList.add(new PushRelation(r, previouslyFoundTag, newlyFoundTag));
                            backActionList.add(new PopRelation(r, newlyFoundTag));
                            break;
                        }
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

            // TODO handling cross edge (adding ClearRelation operation) 

        }

        assert actionList != null;

        for (Operation each : actionList)
        {
            each.execute();
        }

    }

    void back(Node node)
    {
        int prevState = latticeCursor.getNodeID();
        int nextState = latticeCursor.back(node.nodeName).getID();

        Edge edge = new Edge(prevState, nextState);
        List<Operation> actionList = operationSetOnBack.get(edge);
        if (actionList == null)
        {
            throw new XerialError(XerialErrorCode.INVALID_STATE, "empty action list: " + node);
        }

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