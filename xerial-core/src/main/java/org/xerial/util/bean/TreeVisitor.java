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
    public void init() throws Exception;
    
    /**
     * When found a node
     * @param nodeName the found node name
     */
    public void visitNode(String nodeName) throws Exception;
    
    /**
     * When leaving a node
     * @param nodeName the node name to leave
     */
    public void leaveNode(String nodeName) throws Exception;
    
    /**
     * Found a text data
     * @param text
     */
    public void foundText(String text) throws Exception;

    /**
     * When the tree visit has finished
     */
    public void finish() throws Exception;
}
