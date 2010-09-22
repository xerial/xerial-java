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
// StandardInputStream.java
// Since: Sep 22, 2010 12:41:07 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * An wrapper of System.in used for avoiding accidentally closing System.in,
 * which should not be closed by the user.
 * 
 * @author leo
 * 
 */
public class StandardInputStream extends InputStream {

    @Override
    public int read() throws IOException {
        return System.in.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return System.in.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return System.in.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
        // do nothing
    }

}
