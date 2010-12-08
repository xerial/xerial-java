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
// AmoebaTuple.java
// Since: Jul 5, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba;

import java.util.SortedSet;

public interface AmoebaTuple {
	
	/**
	 * This is a short hand method for <code>getValue(getKeyParameterName())</code>
	 * @return
	 */
	public String getKey();
	/**
	 * Gets the value of the corresponding parameterName
	 * @param parameterName
	 * @return the parameter value
	 */
	public String getValue(String parameterName);

	/**
	 * Gets the parameter name of the key attribute 
	 * @return
	 */
	public String getKeyParameterName();
	
	/**
	 * Gets the set of the parameter values
	 * @return
	 */
	public SortedSet<String> getParameterNameSet();
		
}




