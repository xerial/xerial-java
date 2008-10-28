/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// Mapper.java
// Since: Oct 28, 2008 3:56:50 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * mapper
 * 
 * @author leo
 * 
 * @param <In>
 * @param <Out>
 */
public interface Mapper<In, Out>
{
    public Out map(In input);
}
