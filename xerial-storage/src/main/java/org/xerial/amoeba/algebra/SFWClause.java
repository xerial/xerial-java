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
// XerialJ Project
//
// SFWClause.java
// Since: Apr 24, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.algebra;

import java.util.ArrayList;

import org.xerial.amoeba.algebra.AttributeLabel;
import org.xerial.amoeba.algebra.RelationLabel;

/**
 * select/from/where clause
 * 
 * @author leo
 *
 */
public class SFWClause {

	ArrayList<AttributeLabel> _attributeLabel = new ArrayList<AttributeLabel>();
	ArrayList<RelationLabel> _relationLabel = new ArrayList<RelationLabel>();
	
	
}




