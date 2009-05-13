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
// RelationSetter.java
// Since: 2009/05/12 20:14:43
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import org.xerial.core.XerialException;

/**
 * RelationSetter is for setting a node tuple to an object
 * 
 * @author leo
 * 
 */
public abstract class RelationSetter
{
    public abstract void bind(Object object, Object value) throws XerialException;

}
