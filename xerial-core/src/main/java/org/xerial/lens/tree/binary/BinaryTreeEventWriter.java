/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// BinaryTreeEventWriter.java
// Since: 2010/04/19 19:02:35
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.tree.binary;

import java.io.IOException;
import java.io.OutputStream;

import org.xerial.lens.tree.TreeEvent;

/**
 * For writing tree event stream in binary
 * 
 * @author leo
 * 
 */
public class BinaryTreeEventWriter {

    private final OutputStream out;

    public BinaryTreeEventWriter(OutputStream out) {
        this.out = out;
    }

    public void write(TreeEvent e) throws IOException {
        switch (e.event) {
        case VISIT:
            out.write(0);
            break;
        case LEAVE:
            break;
        case TEXT:
            break;
        }
    }

}
