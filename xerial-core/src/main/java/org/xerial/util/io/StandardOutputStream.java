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
// StandardOutputStream.java
// Since: Sep 22, 2010 12:48:58 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * An wrapper class of STDOUT for avoiding accidentally closing STDOUT, which
 * should not be closed by users.
 * 
 * @author leo
 * 
 */
public class StandardOutputStream extends OutputStream {

    @Override
    public void flush() throws IOException {
        System.out.flush();
    }

    @Override
    public void write(int b) throws IOException {
        System.out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        // do nothing
    }

}
