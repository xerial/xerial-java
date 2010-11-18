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
// SilkProjection.java
// Since: Jul 8, 2009 10:08:10 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * Projection consisting of partial views of class objects
 * 
 * @author leo
 * 
 */
public class SilkProjection {

    /**
     * name of this projection definition
     */
    public String name;
    public String targetClass;

    public List<String> attribute = new ArrayList<String>();

    public boolean allIncluded = false;

    public List<String> orderBy = new ArrayList<String>();

}
