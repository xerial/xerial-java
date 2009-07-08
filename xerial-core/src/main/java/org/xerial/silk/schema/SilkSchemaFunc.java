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
// SilkSchemaFunc.java
// Since: Jul 8, 2009 11:13:18 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * Function in a SilkSchema
 * 
 * @author leo
 * 
 */
public class SilkSchemaFunc implements OrderByElement {

    public String name;
    public List<String> argument = new ArrayList<String>();

}
