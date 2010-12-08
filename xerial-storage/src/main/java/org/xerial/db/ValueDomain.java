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
// ValueDomain.java
// Since: 2007/04/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db;

import java.util.ArrayList;
import java.util.List;


/**
 * A ValueDomain shows a set of possible values that can be 
 * used within a DataType in a Relation.   
 * 
 * @author leo
 *
 */
public class ValueDomain  
{
    /**
     * The following line specifies the element type of the List, that is, org.utgenome.gwt.web.client.db.Value. 
     * This information is requried in the GWT compiler.
     * 
     * @gwt.typeArgs <org.utgenome.gwt.web.client.db.Value> 
     */
	List valueList = new ArrayList();
	
	public ValueDomain()
	{}
	public ValueDomain(List valueList)
	{
		this.valueList = valueList;
	}
	
	public List getValueList() {
		return valueList;
	}
	public void setValueList(List valueList) {
		this.valueList = valueList;
	}
	public void addValueList(Value value)
	{
		valueList.add(value);
	}
	
}




