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
// SilkModule.java
// Since: Jul 3, 2009 2:41:56 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * Module for packing several class definitions within a scope
 * 
 * @author leo
 * 
 */
public class SilkModule {
    public final static String ROOT_MODULE_NAME = "";

    public String name = ROOT_MODULE_NAME;

    public List<SilkModule> module = new ArrayList<SilkModule>();
    public List<SilkClass> classDef = new ArrayList<SilkClass>();
    public List<SilkRelation> relation = new ArrayList<SilkRelation>();
    public List<SilkProjection> projection = new ArrayList<SilkProjection>();

}
