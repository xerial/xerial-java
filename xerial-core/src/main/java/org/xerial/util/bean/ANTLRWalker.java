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

import org.antlr.runtime.Parser;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialException;

/**
 * A walker implementation for ANTLR parse trees
 * @author leo
 *
 */
public class ANTLRWalker implements TreeWalker
{
    private static final ArrayList<NodeAttribute> emptyAttributeList = new ArrayList<NodeAttribute>();
    private final Parser parser;
    private final TreeVisitor visitor;
    
    private boolean skipDescendants = false;
    
    public ANTLRWalker(Parser parser, TreeVisitor visitor)
    {
        this.parser = parser;
        this.visitor = visitor;
    }
    
        
    public void walk(Tree t) throws XerialException
    {
        int tokenType = t.getType();
        String nodeName = parser.getTokenNames()[tokenType];
        
        // invoke visitor
        visitor.visitNode(nodeName, emptyAttributeList, this);
        
        // visit child nodes
        if(skipDescendants)
        {
            for(int i=0; i<t.getChildCount(); i++)
            {
                Tree child = t.getChild(i);
                walk(child);
            }
            skipDescendants = false;
        }
        
        // leave the current node
        visitor.leaveNode(nodeName, t.getText(), this);
    }
    
    
    
    public void skipDescendants()
    {
        skipDescendants = true;
    }

}
