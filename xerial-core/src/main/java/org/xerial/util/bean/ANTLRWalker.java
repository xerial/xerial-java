/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// ANTLRWalker.java
// Since: Dec 19, 2007 5:54:17 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialException;

/**
 * A walker implementation for ANTLR parse trees
 * 
 * @author leo
 * 
 */
public class ANTLRWalker extends TreeWalker
{
    private final String[] parserTokenNames;
    private Tree currentNode = null;

    private boolean skipDescendants = false;

    public ANTLRWalker(final String[] parserTokenNames, TreeVisitor visitor, Tree parseTree)
    {
        super(visitor);
        this.parserTokenNames = parserTokenNames;
        this.currentNode = parseTree;
    }

    public void walk() throws XerialException
    {
        getTreeVisitor().init(this);
        walk(currentNode);
        getTreeVisitor().finish(this);
    }

    public void walk(Tree t) throws XerialException
    {
        currentNode = t;
        int tokenType = t.getType();
        String nodeName = parserTokenNames[tokenType];

        // invoke visitor
        getTreeVisitor().visitNode(nodeName, this);

        // visit child nodes
        if (!skipDescendants)
        {
            for (int i = 0; i < t.getChildCount(); i++)
            {
                Tree child = t.getChild(i);
                walk(child);
            }
            skipDescendants = false;
        }

        // leave the current node
        getTreeVisitor().leaveNode(nodeName, t.getText(), this);
    }

    public void skipDescendants()
    {
        skipDescendants = true;
    }

    public TreeNode getSubTree() throws BeanException
    {
        skipDescendants();
        return new ANTLRTreeNodeWrapper(currentNode);
    }

    class ANTLRTreeNodeWrapper implements TreeNode
    {
        private Tree t;

        public ANTLRTreeNodeWrapper(Tree t)
        {
            this.t = t;
        }

        public List<TreeNode> getChildren()
        {
            ArrayList<TreeNode> childList = new ArrayList<TreeNode>();
            for (int i = 0; i < t.getChildCount(); i++)
            {
                childList.add(new ANTLRTreeNodeWrapper(t.getChild(i)));
            }
            return childList;
        }

        public String getNodeName()
        {
            return parserTokenNames[t.getType()];
        }

        public String getNodeValue()
        {
            return t.getText();
        }

    }

}
