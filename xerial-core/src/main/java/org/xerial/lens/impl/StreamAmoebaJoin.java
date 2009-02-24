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
// StreamAmoebaJoin.java
// Since: Feb 24, 2009 2:00:28 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.impl;

import org.xerial.core.XerialException;
import org.xerial.util.graph.Lattice;
import org.xerial.util.graph.LatticeCursor;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * Stream amoeba join processor
 * 
 * @author leo
 * 
 */
public class StreamAmoebaJoin
{

    public StreamAmoebaJoin()
    {

    }

    public void process(TreeWalker walker) throws XerialException
    {
        TreeStreamProcessor processor = new TreeStreamProcessor();
        walker.walk(processor);
    }

    private class TreeStreamProcessor implements TreeVisitor
    {
        Lattice<String> contextNodeSet = new Lattice<String>();
        LatticeCursor<String> cursor;

        public void finish(TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void init(TreeWalker walker) throws XerialException
        {
            cursor = contextNodeSet.cursor();
        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {
            int prevStateID = cursor.getNodeID();
            int nextStateID = cursor.back(nodeName).getID();

        }

        public void text(String textDataFragment, TreeWalker walker) throws XerialException
        {

        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
            int prevStateID = cursor.getNodeID();
            int nextStateID = cursor.next(nodeName).getID();

        }

    }

    private class ActionTable
    {

    }

}
