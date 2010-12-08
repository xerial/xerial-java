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
// Value.java
// Since: 2007/04/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db;


/**
 * Add this Value class to the ValueDomain
 * in order to set the value domain of a input form. 
 * @author leo
 *
 */
public class Value  
{
	String label = null;
	String value = null;
	
	public Value() {}
	public Value(String value)
	{
		this.label = value;
		this.value = value;
	}
	public Value(String label, String value)
	{
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}




