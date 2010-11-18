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
// XerialJ
//
// JSONStreamWalker.java
// Since: Dec 19, 2007 8:08:32 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.Reader;

import org.xerial.util.tree.TreeWalkerImpl;

/**
 * A walker that traverses JSON streams
 * 
 * @author leo
 * 
 */
public class JSONStreamWalker extends TreeWalkerImpl
{
    public JSONStreamWalker(Reader jsonStream) throws IOException
    {
        super(new JSONStreamReader(jsonStream));
    }

}
