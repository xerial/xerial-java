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
// Compressor.java
// Since: 2005/07/24 16:21:36
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor
{
    ByteArrayInputStream compress(MemoryBlock block) throws IOException
    {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(buf);
        
        block.writeTo(gzipOutputStream);
        gzipOutputStream.finish();
        
        return new ByteArrayInputStream(buf.toByteArray()); 
    }
    

}
