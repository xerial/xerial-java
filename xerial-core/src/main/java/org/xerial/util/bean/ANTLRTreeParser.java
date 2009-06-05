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
// ANTLRTreeParser.java
// Since: Jun 5, 2009 6:43:56 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import org.antlr.runtime.tree.Tree;
import org.xerial.util.tree.TreeEventHandler;
import org.xerial.util.tree.TreeParser;

/**
 * {@link TreeParser} for ANTLR parse trees
 * 
 * @author leo
 * 
 */
public class ANTLRTreeParser implements TreeParser
{
    private final String[] parserTokenNames;
    private Tree currentNode = null;

    public ANTLRTreeParser(final String[] parserTokenNames, Tree parseTree)
    {
        this.parserTokenNames = parserTokenNames;
        this.currentNode = parseTree;
    }

    public void parse(TreeEventHandler handler) throws Exception
    {
        handler.init();
        walk(currentNode, handler);
        handler.finish();
    }

    public void walk(Tree t, TreeEventHandler handler) throws Exception
    {
        currentNode = t;
        int tokenType = t.getType();
        String nodeName = parserTokenNames[tokenType];

        // invoke visitor
        handler.visitNode(nodeName, t.getText());

        for (int i = 0; i < t.getChildCount(); i++)
        {
            Tree child = t.getChild(i);
            walk(child, handler);
        }

        // leave the current node
        handler.leaveNode(nodeName);
    }
}
