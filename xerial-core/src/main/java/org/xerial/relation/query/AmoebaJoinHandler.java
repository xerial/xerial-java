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
package org.xerial.relation.query;

import org.xerial.relation.Node;
import org.xerial.relation.schema.Schema;

public interface AmoebaJoinHandler
{
    public void init();

    public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception;

    public void leaveNode(Schema schema, Node node) throws Exception;

    /**
     * @param schema
     * @param coreNode
     * @param textNode
     *            text node may not contain a text value
     * @param text
     *            text fragment data of the text node
     * @throws Exception
     */
    public void text(Schema schema, Node coreNode, Node textNode, String text) throws Exception;

    public void finish();
}
