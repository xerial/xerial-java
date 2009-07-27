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
// RelationEventHandler.java
// Since: May 14, 2009 12:39:42 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.schema.Schema;

/**
 * Interface of the amoeba join result handler. The tree data will be consumed
 * in the depth-first manner, and newly found amoeba pair and tree nodes will be
 * reported in the DFS order.
 * 
 * @author leo
 * 
 */
public interface AmoebaJoinHandler {

    /**
     * This method will be invoked once before the amoeba join process starts
     */
    public void init();

    /**
     * Invoked when a new amoeba node pair specified in the query set is found
     * 
     * @param schema
     * @param coreNode
     * @param attributeNode
     * @throws Exception
     */
    public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception;

    /**
     * Invoked when leaving a node
     * 
     * @param schema
     * @param node
     * @throws Exception
     */
    public void leaveNode(Schema schema, Node node) throws Exception;

    /**
     * Invoked when a text node belongs to a core node is found
     * 
     * @param schema
     * @param coreNode
     * @param textNode
     *            text node may not contain a text value
     * @param text
     *            text fragment data of the text node
     * @throws Exception
     */
    public void text(Schema schema, Node coreNode, Node textNode, String text) throws Exception;

    /**
     * Invoked when reading the input stream has finished
     */
    public void finish();
}
