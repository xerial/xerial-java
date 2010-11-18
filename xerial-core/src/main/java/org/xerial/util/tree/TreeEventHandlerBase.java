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
// TreeEventHandlerBase.java
// Since: Jun 1, 2009 3:27:53 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

import org.xerial.lens.relation.schema.RelationSchema;

/**
 * Empty implementation of the {@link TreeEventHandler}
 * 
 * @author leo
 * 
 */
public class TreeEventHandlerBase implements TreeEventHandler {

    @Override
    public void finish() throws Exception {

    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void leaveNode(String nodeName) throws Exception {

    }

    @Override
    public void text(String nodeName, String textDataFragment) throws Exception {

    }

    @Override
    public void visitNode(String nodeName, String immediateNodeValue) throws Exception {

    }

    @Override
    public void schema(RelationSchema schema) throws Exception {

    }
}
