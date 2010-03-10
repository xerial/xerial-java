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
// TreeEventHandler.java
// Since: Jun 1, 2009 2:59:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.tree;

import org.xerial.core.XerialException;

/**
 * {@link TreeEvent} handler interface
 * 
 * @author leo
 * 
 */
public interface TreeEventHandler {
    /**
     * Initialize the visitor here
     */
    public void init() throws Exception;

    /**
     * Invoked when a new node is found (in the depth-first manner)
     * 
     * @param immediateNodeValue
     *            immediate node value of the node. When no value is observed,
     *            this value will be <tt>null</tt>.
     * 
     * @param nodeName
     *            found node name
     */
    public void visitNode(String nodeName, String immediateNodeValue) throws Exception;

    /**
     * Invoked when text data attached to the current node is found. This event
     * might be invoked one or more times for a node.
     * 
     * @param textDataFragment
     *            text data fragment
     * @throws XerialException
     */
    public void text(String nodeName, String textDataFragment) throws Exception;

    /**
     * Invoked when leaving a node (in the depth-first manner)
     * 
     * @param nodeName
     *            node name to leave
     * 
     * @throws XerialException
     */
    public void leaveNode(String nodeName) throws Exception;

    /**
     * When the tree visit has finished
     */
    public void finish() throws Exception;

}
