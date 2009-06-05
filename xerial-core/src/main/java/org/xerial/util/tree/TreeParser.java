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
// TreeParser.java
// Since: Jun 5, 2009 6:19:43 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

/**
 * Tree-structured data parser interface
 * 
 * @author leo
 * 
 */
public interface TreeParser
{
    /**
     * start the parsing, and report {@link TreeEvent} to the given event
     * handler
     * 
     * @param handler
     * @throws Exception
     */
    public void parse(TreeEventHandler handler) throws Exception;
}
