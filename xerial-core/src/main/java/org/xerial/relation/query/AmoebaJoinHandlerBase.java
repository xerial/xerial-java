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
// AmoebaJoinHandlerBase.java
// Since: 2009/05/18 19:15:42
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation.query;

import org.xerial.relation.Node;
import org.xerial.relation.schema.Schema;

/**
 * An empty implementation of {@link AmoebaJoinHandler}
 * 
 * @author leo
 * 
 */
public class AmoebaJoinHandlerBase implements AmoebaJoinHandler
{

    public void leaveNode(Schema schema, Node node)
    {

    }

    public void newAmoeba(Schema schema, Node coreNode, Node attributeNode)
    {

    }

    public void text(Schema schema, Node coreNode, String nodeName, String text)
    {

    }

}
