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
// Import.java
// Since: Feb 9, 2009 3:40:27 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.plugin;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkEnv;
import org.xerial.silk.SilkParser;
import org.xerial.util.FileType;
import org.xerial.util.io.Base64OutputStream;
import org.xerial.util.tree.TreeEventHandler;

/**
 * <em>import</em> function
 * 
 * @author leo
 * 
 */
public class Import implements SilkFunctionPlugin {

    @SilkFunctionArgument
    String filePath = null;

    public void init(SilkEnv env) throws XerialException {

    }

    public void eval(SilkEnv env, TreeEventHandler handler) throws Exception {
        if (filePath == null) {
            env.getLogger().warn("no file path is specified");
            return;
        }

        try {
            String url = env.getResourceBasePath();
            if (!env.getResourceBasePath().endsWith("/"))
                url += "/";
            url += filePath;

            FileType f = FileType.getFileType(filePath);
            switch (f) {
            case SILK:
            case TAB: {
                SilkParser parser = new SilkParser(new URL(url), env);
                parser.parseWithoutInitAndFinish(handler);
                break;
            }
            case JPEG:
            case GIF:
            case BMP:
            case PDF:
            case PS:
            case TIFF:
            case WORD:
            case EXCEL:
            case POWER_POINT:
            case PNG: {
                loadBinary(new URL(url), env, handler);
            }
                break;
            default: {
                SilkParser parser = new SilkParser(new URL(url), env);
                parser.parseWithoutInitAndFinish(handler);
                break;
            }
            }

        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

    }

    public void loadBinary(URL path, SilkEnv env, TreeEventHandler handler) throws Exception {
        env.getLogger().debug("load binary: " + path);

        InputStream source = path.openStream();
        BufferedInputStream in = new BufferedInputStream(source);

        byte[] buffer = new byte[1024];
        int readBytes = 0;
        while ((readBytes = in.read(buffer, 0, buffer.length)) != -1) {
            ByteArrayOutputStream base64buffer = new ByteArrayOutputStream(readBytes);
            Base64OutputStream base64out = new Base64OutputStream(base64buffer);
            base64out.write(buffer, 0, readBytes);
            base64out.flush();
            String[] fragment = new String(base64buffer.toByteArray()).split("\\r\\n");
            for (String each : fragment) {
                handler.text(env.getContextNode().name, each);
            }
        }

    }

}
