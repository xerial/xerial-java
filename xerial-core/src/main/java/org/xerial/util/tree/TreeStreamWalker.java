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
// TreeStreamWalker.java
// Since: Mar 30, 2009 5:22:24 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

import org.xerial.core.XerialException;

/**
 * A common interface for the stream parser of structured data.
 * 
 * @author leo
 * 
 */
public interface TreeStreamWalker
{
    public TreeEvent next() throws XerialException;
}
