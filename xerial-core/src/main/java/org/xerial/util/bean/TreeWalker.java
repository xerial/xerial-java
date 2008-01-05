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
// TreeWalker.java
// Since: Dec 19, 2007 12:40:15 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import org.xerial.core.XerialException;


/**
 * An depth-first walker interface of tree structured data
 * 
 * @author leo
 *
 */
public abstract class TreeWalker
{
    private final TreeVisitor visitor;
    
    protected TreeWalker(TreeVisitor visitor)
    {
        if(visitor == null)
            throw new NullPointerException("visitor cannot be null");
        this.visitor = visitor;
    }
    
    public TreeVisitor getTreeVisitor() 
    {
        return visitor;
    }
    
    /**
     * Start walking 
     */
    public abstract void walk() throws XerialException;
    
    /**
     * Skip the descendants of the current node
     */
    public abstract void skipDescendants();
    
    /**
     * Gets the entire subtree beginning from the current node, and 
     * skips the descendants. 
     * @return {@link TreeNode} representation of the tree structured data beginning from the current node
     * @throws BeanException TODO
     */
    public abstract TreeNode getSubTree() throws BeanException;
    
}
