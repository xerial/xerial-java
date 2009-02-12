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
// Base64Reader.java
// Since: Feb 10, 2009 1:18:37 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.commons.codec.binary.Base64;
import org.xerial.util.Algorithm;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;

/**
 * Base64 reader for encoding the input stream with Base64
 * 
 * @author leo
 * 
 */
public class Base64Reader extends Reader
{
    private BufferedInputStream in;
    private Deque<byte[]> cache = new ArrayDeque<byte[]>();
    private int offset = 0;

    public Base64Reader(InputStream in)
    {
        this.in = new BufferedInputStream(in);
    }

    @Override
    public void close() throws IOException
    {
        in.close();
    }

    private int readNext(char[] buf, int offset, int remainingLength)
    {
        if (cache.isEmpty())
        {

        }

        byte[] buffer = new byte[1024];
        int readBytes = 0;

        while ((readBytes = in.read(buffer, 0, buffer.length)) > 0)
        {
            if (readBytes == buffer.length)
            {
                byte[] encoded = Base64.encodeBase64(buffer);
                cache.addLast(encoded);
            }
            else
            {
                byte[] tmp = new byte[readBytes];
                System.arraycopy(buffer, 0, tmp, 0, readBytes);

                byte[] encoded = Base64.encodeBase64(tmp);
                cache.addLast(encoded);
            }
        }

    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException
    {
        final int maxSize = Algorithm.min(cbuf.length - off, len);
        int readBytes = readNext(cbuf, offset, len);

        while (readBytes < maxSize)
        {
            if (readBytes == len)
                return readBytes;

        }

        // TODO copy to the buffer

        // TODO Auto-generated method stub
        return 0;
    }

}
