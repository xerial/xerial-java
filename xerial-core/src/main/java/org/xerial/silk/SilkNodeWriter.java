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
// SilkNodeWriter.java
// Since: Jul 29, 2009 6:32:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

public class SilkNodeWriter {

    private final SilkWriter out;
    private int nodeCount = 0;

    public SilkNodeWriter(SilkWriter parent) {
        this.out = parent;
    }

    public SilkNodeWriter node(String nodeName, String value) {

        if (nodeCount > 0)
            out.comma();

        out.inlineNode(nodeName, value);
        nodeCount++;
        return this;
    }

}
