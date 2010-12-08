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
// ANTLRUtil.java
// Since: Dec 11, 2007 3:28:50 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;

import java.util.ArrayList;

import org.antlr.runtime.tree.Tree;
import org.xerial.amoeba.query.impl.AmoebaQueryParser;
import org.xerial.util.StringUtil;

/**
 * Utiltiles to manipulate ANTLR parse trees
 * @author leo
 *
 */
public class ANTLRUtil
{
    public static Tree getFirstNode(Tree t, int tokenType)
    {
        for(int i=0; i<t.getChildCount(); i++)
        {
            Tree child = t.getChild(i);
            if(child.getType() == tokenType)
                return child;
        }
        return null;
    }
    
    public static ArrayList<Tree> getNodeList(Tree t, int tokenType)
    {
        ArrayList<Tree> nodeList = new ArrayList<Tree>();
        for(int i=0; i<t.getChildCount(); i++)
        {
            Tree child = t.getChild(i);
            if(child.getType() == tokenType)
            {
                nodeList.add(child);
            }
        }
        
        return nodeList;
    }
    
    public static String getFirstNodeValue(Tree t, int tokenType)
    {
        Tree node = getFirstNode(t, tokenType);
        if(node != null)
            return node.getText();
        else
            return "";
    }
    
    public static ArrayList<String> getValueList(Tree t, int tokenType)
    {
        ArrayList<String> textList = new ArrayList<String>();
        for(Tree node : getNodeList(t, tokenType)) 
        {
            textList.add(node.getText());
        }
        return textList;
    }
    
    public static String toString(Tree t)
    {
        StringBuilder buf = new StringBuilder();
        toStringInternal(t, buf, 0);
        return buf.toString();
    }
    
    private static void toStringInternal(Tree t, StringBuilder buf, int level)
    {
        if(t == null)
            return;
        
        int type = t.getType();
        String tokenName = AmoebaQueryParser.tokenNames[type];
        String text = t.getText();
        
        for(int i=0; i<level; i++)
            buf.append("  ");
        buf.append("[");
        buf.append(tokenName);
        buf.append("] ");
        if(text != null && !text.equals(tokenName))
        {
            buf.append(text);
        }
        buf.append(StringUtil.NEW_LINE);
        
        for(int i=0; i<t.getChildCount(); i++)
        {
            Tree child = (Tree) t.getChild(i);
            toStringInternal(child, buf, level+1);
        }
        
    }


    /**
     * Non constractable
     */
    protected ANTLRUtil()
    {}
}
