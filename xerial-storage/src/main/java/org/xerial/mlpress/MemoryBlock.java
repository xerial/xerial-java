/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// MemoryBlock.java
// Since: 2005/07/24 15:34:24
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * The byte size of MemoryBlock  dinamically expands from
 * 256 to 512, 1024, 2048, 4096, 8192, 16384, 32768 and 65536.
 *  
 * @author leo
 *
 */
public class MemoryBlock
{
    MemoryBlockManager _manager;
    ByteArrayOutputStream _buf = new ByteArrayOutputStream(256);
    final static int BLOCKSIZE_MAX = 65536;
    int _blockSize = 256;
    int _cursor = 0;
    int _id = 0;

    
    public MemoryBlock(int id, MemoryBlockManager manager)
    {
        _id = id;
        _manager = manager;
    }

    public int size()
    {
        return _blockSize;
    }
    
    public int getID()
    {
        return _id;
    }
    
    public void write(int byteValue)
    {
        if(_cursor + 1 >= _blockSize)
            resize();
        
        _buf.write(byteValue);
    }

    public void write(byte[] data, int offset, int len)
    {
        if(_cursor + len >= _blockSize)
            resize();
        
        _buf.write(data, offset, len);
        _cursor += len;
    }
    
    public void writeTo(OutputStream out) throws IOException
    {
        _buf.writeTo(out);
    }
    
    public void resize()
    {
        int newBlockSize = _blockSize * 2;
        if(newBlockSize > BLOCKSIZE_MAX)
        {
            // TODO overflow handling
        }
        _manager.expandBlockSize(this, newBlockSize);
        _blockSize = newBlockSize;
    }
        
}

