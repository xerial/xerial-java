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
public interface TreeWalker
{
    /**
     * Start walking, and invoke some visitor methods (
     * {@link TreeVisitor#visitNode(String, TreeWalker)},
     * {@link TreeVisitor#leaveNode(String, String, TreeWalker)} etc. while
     * traversing the tree.
     * 
     * @param visitor
     *            A {@link TreeVisitor} that handles tree visit events
     * @throws XerialException
     *             when we have to stop the walking
     */
    public void walk(TreeVisitor visitor) throws XerialException;

    /**
     * Skip the descendants of the current node
     */
    public void skipDescendants();

    /**
     * Gets the entire subtree beginning from the current node, and skips all
     * visitor method invocation as for the sub tree nodes.
     * 
     * 
     * @return {@link TreeNode} representation of the tree structured data
     *         beginning from the current node
     * @throws XerialException
     *             when we have to stop the walking
     * 
     */
    public TreeNode getSubTree() throws XerialException;

}
