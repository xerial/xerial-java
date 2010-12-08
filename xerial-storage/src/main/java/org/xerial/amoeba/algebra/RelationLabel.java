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
// RelationLabel.java
// Since: Apr 24, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.algebra;

/**
 * a label of the intermediate relation
 * @author leo
 *
 */
public class RelationLabel 
{
	String name;

	/**
	 * @param name
	 */
	public RelationLabel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}




