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
// RelationHandler.java
// Since: 2009/08/06 17:16:15
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.schema.Schema;

/**
 * For receiving found relations
 * 
 * @author leo
 * 
 */
public interface RelationHandler {

    public void relation(Schema s, Tuple<Node> relation);
}
