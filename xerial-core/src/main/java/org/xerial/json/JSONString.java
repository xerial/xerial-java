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
// JSONString.java
// Since: Apr 4, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONString.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

import org.xerial.util.StringUtil;


public class JSONString extends JSONValueBase {

	private String s;
	public JSONString() {}
	public JSONString(String s)
	{
		this.s = StringUtil.unquote(s);
	}
	
	public String toString()
	{
		return s;
	}
	
	public String toJSONString()
	{
		return "\"" + s + "\"";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JSONString) {
			return s.equals(((JSONString) obj).s);
		}
		return false;
	}
	
	@Override
	public JSONString getJSONString() {
		return this;
	}
	
	public String getValue()
	{
		return s;
	}
    public JSONValueType getValueType()
    {
        return JSONValueType.String;
    }
}




