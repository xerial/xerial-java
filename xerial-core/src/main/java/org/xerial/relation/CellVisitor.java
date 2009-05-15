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
// CellVisitor.java
// Since: 2009/05/13 9:32:39
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

/**
 * Visitor interface for traversing Tuple
 * 
 * @author leo
 * 
 */
public interface CellVisitor<NodeType>
{
    public void visitNode(NodeType node);

    public void visitTuple(Tuple<NodeType> tuple);

}