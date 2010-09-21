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
// Xerial Silk Weaver Project 
//
// Copy.java
// Since: Jul 21, 2009 4:23:15 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * File copy with a configurable buffer size
 * 
 * @author leo
 * 
 */
public class FileCopy {

    public static class Config {
        public long BLOCK_SIZE = 64L * 1024L; // use 64 KB block size  
    }

    public static void copy(File source, File dest) throws IOException {
        copy(source, dest, new Config());
    }

    public static void copy(File source, File dest, Config config) throws IOException {

        FileChannel in = null, out = null;
        try {
            in = new FileInputStream(source).getChannel();
            out = new FileOutputStream(dest).getChannel();

            final long fileSize = in.size();
            long cursor = 0;

            while (cursor < fileSize) {
                long dataSizeToSend = (fileSize - cursor) < config.BLOCK_SIZE ? fileSize - cursor
                        : config.BLOCK_SIZE;
                long bytesTransferred = in.transferTo(cursor, dataSizeToSend, out);
                cursor += bytesTransferred;
            }

        }
        finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }

    }

}
