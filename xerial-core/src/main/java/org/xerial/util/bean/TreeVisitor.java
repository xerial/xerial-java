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
// TreeIterator.java
// Since: Dec 18, 2007 11:04:35 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.util.List;

import org.xerial.core.XerialException;

/**
 * A depth-first visitor model for tree structured data, including XML, JSON, ANTLR Parse Tree, etc. 
 * @author leo
 *
 */
public interface TreeVisitor
{

    /**
     * Initialize the visitor here 
     */
    public void init(TreeWalker walker) throws XerialException;
    
    /**
     * When found a node
     * @param nodeName the found node name
     */
    public void visitNode(String nodeName, List<TreeNodeAttribute> nodeAttributeList, TreeWalker walker) throws XerialException;
    
    /**
     * When leaving a node
     * @param nodeName the node name to leave
     * @param nodeValue
     * @throws XerialException
     */
    public void leaveNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException;
    
    /**
     * When the tree visit has finished
     */
    public void finish(TreeWalker walker) throws XerialException;
}
