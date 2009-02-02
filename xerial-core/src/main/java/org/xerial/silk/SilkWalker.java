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
// SilkWalker.java
// Since: Feb 2, 2009 11:29:02 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;

import org.xerial.core.XerialException;
import org.xerial.silk.impl.SilkNode;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.Pair;
import org.xerial.util.graph.Automaton;
import org.xerial.util.graph.AutomatonCursor;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * {@link TreeWalker} implementation of the Silk format.
 * 
 * @author leo
 * 
 */
public class SilkWalker implements TreeWalker
{
    private final SilkPullParser parser;
    private final Deque<SilkNode> contextNodeStack = new ArrayDeque<SilkNode>();

    private static enum State {
        INIT, PRESERVED_NODE, DATA_LINE
    }

    private static enum Symbol {
        ChildNode, AncestorNode, SiblingNode, Data
    }

    private static Automaton<State, Symbol> stateMachine = new Automaton<State, Symbol>();
    private AutomatonCursor<State, Symbol> stateCursor;

    private static interface Action
    {
        void execute();
    }

    private static HashMap<Pair<State, State>, Action> actionTable = new HashMap<Pair<State, State>, Action>();

    static
    {
        stateMachine.addTransition(State.INIT, Symbol.ChildNode, State.PRESERVED_NODE);
        stateMachine.addTransition(State.PRESERVED_NODE, Symbol.Data, State.DATA_LINE);
        stateMachine.addTransition(State.DATA_LINE, Symbol.Data, State.DATA_LINE);
        stateMachine.addTransition(State.DATA_LINE, Symbol.ChildNode, State.PRESERVED_NODE);
        stateMachine.addTransition(State.DATA_LINE, Symbol.ChildNode, State.PRESERVED_NODE);

    }

    private class OutputNode implements Action
    {

        public void execute()
        {
        // TODO Auto-generated method stub

        }

    }

    /**
     * Creates a new SilkWalker with the specified input stream
     * 
     * @param input
     * @throws IOException
     */
    public SilkWalker(InputStream input) throws IOException
    {
        this.parser = new SilkPullParser(input);
        init();
    }

    /**
     * Creates a new SilkWalker with the specified reader
     * 
     * @param input
     * @throws IOException
     */
    public SilkWalker(Reader input) throws IOException
    {
        this.parser = new SilkPullParser(input);
        init();
    }

    public void init()
    {
        actionTable.put(new Pair<State, State>(State.PRESERVED_NODE, State.DATA_LINE), new OutputNode());

    }

    public TreeNode getSubTree() throws XerialException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void skipDescendants()
    {
    // TODO Auto-generated method stub

    }

    public void walk(TreeVisitor visitor) throws XerialException
    {
        // initialize
        stateCursor = stateMachine.cursor(State.INIT);

        visitor.init(this);

        while (parser.hasNext())
        {
            SilkEvent currentEvent = parser.next();

            switch (currentEvent.getType())
            {
            case NODE:
                // push context node
                SilkNode newContextNode = SilkNode.class.cast(currentEvent.getElement());
                contextNodeStack.push(newContextNode);

                /*
                 * 1.node -> 2.node:        output node 1.
                 * 1.node -> 2.data line    output 2 (with node 1's values)     
                 * 1.node -> 
                 */

                break;

            case FUNCTION:
                break;
            case DATA_LINE:
                break;
            case BLANK_LINE:
                break;

            }

        }

        visitor.finish(this);
    }

    private SilkNode getContextNode()
    {
        if (contextNodeStack.isEmpty())
            return null;
        else
            return contextNodeStack.getLast();
    }
}
